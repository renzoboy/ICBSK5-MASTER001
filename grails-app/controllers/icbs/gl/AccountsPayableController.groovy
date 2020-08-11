package icbs.gl

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.lov.DepositStatus
import icbs.tellering.TxnFile
import icbs.admin.Currency
import icbs.admin.TxnTemplate
import icbs.cif.Customer
import icbs.lov.TxnType
import icbs.gl.GlAccount
import icbs.admin.Branch
import icbs.admin.Institution
import icbs.lov.ConfigItemStatus
import icbs.tellering.TxnBreakdown
import icbs.gl.AccountsPayableLedger
import org.hibernate.Session
import org.hibernate.SessionFactory
import groovy.sql.Sql
import icbs.admin.Product
class AccountsPayableController {
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", update: "POST"]
    
    def index(Integer max) {
        println("Accounts Payable Instance")
        params.max = Math.min(max ?: 10, 100)
        if(params.offset==null){
            params.offset=0
        }
        if (UserMaster.get(session.user_id).branch.id == 3) {
            // main branch
            if (params.query == null) {
                respond AccountsPayable.list(params), model:[params:params,AccountsPayableInstanceCount:  AccountsPayable.count()]
                return
            }else{
                def AccountsPayableList = AccountsPayable.createCriteria().list (params) {
                    or {
                        ilike("particulars", "%${params.query}%")
                        ilike("acctNo", "%${params.query}%")
                    }
                    order("apCreatedDate", "desc")
                }
                respond AccountsPayableList, model:[params:params,AccountsPayableInstanceCount: AccountsPayableList.totalCount]
            }
            return
        }else if (params.query == null) {
            // meaning get user branch 
            def AccountsPayableList = AccountsPayable.createCriteria().list (params) {
                eq("branch", UserMaster.get(session.user_id).branch)
                order("apCreatedDate", "desc")
            }
            respond AccountsPayableList, model:[params:params,AccountsPayableInstanceCount: AccountsPayableList.totalCount]
            return
        }else{
            def AccountsPayableList = AccountsPayable.createCriteria().list (params) {
                eq("branch", UserMaster.get(session.user_id).branch) 
                or {
                    ilike("particulars", "%${params.query}%")
                    ilike("acctNo", "%${params.query}%")
                }
                order("apCreatedDate", "desc")
            }
            respond AccountsPayableList, model:[params:params,AccountsPayableInstanceCount: AccountsPayableList.totalCount]
        }
        return
    }
    def generateAccountNo(AccountsPayable accountsPayableInstance) {
        
        
        int[] piArray = [1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8]
        
        String accountNo
        String branchCode
        String productCode
        println '+++' + accountsPayableInstance.branch
        def productInstance = Product.get(Institution.findByParamCode("GLS.60490").paramValue.toInteger())
        def result = AccountsPayable.executeQuery("select max(SUBSTRING(acctNo, 9,5))from AccountsPayable where SUBSTRING(acctNo, 1,7) = CONCAT(:branch,'-',:prod))", [branch: String.format("%03d", accountsPayableInstance?.branch?.code), prod: String.format("%03d", productInstance?.code)])
        int serialNum
        println '+++' + result
        String serialOld 
        if (result[0] != null) {
            //averageBal = result[0][0].div(days)
            serialOld = result[0]//.substring(8, 13).trim()
            serialNum = Integer.parseInt(serialOld)
        } else {
            serialNum = 0
        } 

        serialNum++
        
        branchCode = String.format("%03d", accountsPayableInstance?.branch?.code)
        productCode = String.format("%03d", productInstance?.code)
        String serialCode = String.format("%05d", serialNum);

        
        accountNo = branchCode + productCode + serialCode
        println '+++' + accountNo
        def checksum = 0
        for(int i= accountNo.length() - 1; i >= 0;i--) {
            checksum += Character.getNumericValue(accountNo.charAt(i)) * piArray[i]
        }
        
        String checkBit = (checksum % 10).toString()
        
        accountsPayableInstance.acctNo = branchCode+"-"+productCode +"-"+serialCode+"-"+checkBit
        
        println '+++' + accountsPayableInstance.acctNo
        accountsPayableInstance.save(flush:true,failOnError:true)
        
    }
    def create(){
        respond new AccountsPayable(params)
    }
    
    @Transactional
    def save(AccountsPayable accountsPayableInstance){
        println("=============== Accounts payable Save Create =============")
        println("params: "+params)
        
        def cifId = Customer.get(params.customer.id.toInteger())
        //def custAdd = Address.get()
        def addr = Customer.get(params.addresss)
        println("Customer ID:"+ cifId)
        if (accountsPayableInstance == null) {
            notFound()
            return
        }
        accountsPayableInstance.balance = 0.00D
        
        if (accountsPayableInstance.hasErrors()) {
            respond accountsPayableInstance.errors, view:'create'
            return
        }  
        if (!accountsPayableInstance.glContra) {
            flash.error = 'GL Account cannot be null|error|alert'
            respond accountsPayableInstance.errors, view:'create'
            return              
        }
        if (!accountsPayableInstance.payable){
            flash.error = 'Payable cannot be null|error|alert'
            respond accountsPayableInstance.errors, view:'create'
            return              
        }
        
        accountsPayableInstance.user = UserMaster.get(session.user_id)
        accountsPayableInstance.customer = cifId
        accountsPayableInstance.status = ConfigItemStatus.get(2)
        accountsPayableInstance.branch = UserMaster.get(session.user_id).branch
        accountsPayableInstance.bookingDate = accountsPayableInstance.branch.runDate
        accountsPayableInstance.dateCreated = UserMaster.get(session.user_id).branch.runDate
        accountsPayableInstance.reference = params?.reference
        accountsPayableInstance.save(flush:true)
        accountsPayableInstance.apCreatedDate = UserMaster.get(session.user_id).branch.runDate
        //============ txnfile for credit AP
        def amountCash  = params.balance.toString().replace(',','').toDouble()
        if(amountCash > 0){
            def cibId = accountsPayableInstance
            def b = Branch.get(1)
            def t = TxnTemplate.get(params.txnType.toInteger())
            //def t = TxnTemplate.get(Institution.findByParamCode("GLS.60430").paramValue.toInteger())

            def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
                txnAmt:amountCash,txnRef:'New AP Created - Cr Adjustment',status:ConfigItemStatus.get(2), branch:cibId.branch,
                txnTimestamp: new Date().toTimestamp(),txnParticulars:''+accountsPayableInstance.particulars,txnType:t.txnType,txnTemplate:t, 
                user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);

            def apLedger = new AccountsPayableLedger(accountsPayable:cibId, refDate:b.runDate, valueDate:b.runDate,
                reference:'New AP Created - Cr Adjustment', particulars:''+accountsPayableInstance.particulars, debit:0.00D, credit:amountCash,
                balance:cibId.balance+amountCash, txnFile:tx)
            apLedger.save(flush:true)


            cibId.balance = cibId.balance + amountCash 
            cibId.save(flush:true)
            //debit
            def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:t.defContraAcct,
                debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
            println("t. :"+t.defContraAcct)
            //credit
            //def cashGl = UserMaster.get(session.user_id).cash.code
                def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:cibId.glContra,
                    creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
            //==================================
        }
        
        // generate Account No
        generateAccountNo(accountsPayableInstance)
        
        // Log
        //def description = 'save Currency ' +  currencyInstance.name
        //auditLogService.insert('040', 'ADM00100', description, 'currency', null, null, null, currencyInstance.id)


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accountsPayableInstance.label', default: 'Accounts Payable'), accountsPayableInstance.id])
                redirect accountsPayableInstance
            }
            '*' { respond accountsPayableInstance, [status: CREATED] }
        }        
    }
    
    def show(AccountsPayable accountsPayableInstance){
        respond accountsPayableInstance
    }
    
    def edit(AccountsPayable accountsPayableInstance){
        if (accountsPayableInstance.status.id == 8) {
            respond accountsPayableInstance.errors, view:'show'
            return
        }
        
        respond accountsPayableInstance
    }
    
    @Transactional
    def update(AccountsPayable accountsPayableInstance){
        println("===== Accounts Payable Update ==========")
        println("params: "+params)    
        if (accountsPayableInstance == null) {
            notFound()
            return
        }
        
        if (accountsPayableInstance.hasErrors()) {
            respond accountsPayableInstance.errors, view:'create'
            return
        }  
        if (!accountsPayableInstance.glContra) {
            flash.message = 'GL Account cannot be null|error|alert'
            respond accountsPayableInstance.errors, view:'create'
            return              
        }
        if (!accountsPayableInstance.payable){
            flash.message = 'Payable cannot be null|error|alert'
            respond accountsPayableInstance.errors, view:'create'
            return              
        }
        
        
        accountsPayableInstance.save(flush:true)
        // Log
        //def description = 'save Currency ' +  currencyInstance.name
        //auditLogService.insert('040', 'ADM00100', description, 'currency', null, null, null, currencyInstance.id)

        redirect(action: "show",controller: "accountsPayable",id:accountsPayableInstance.id)
    }
    def updateAccountsPayable(){
        println("========= Update Accounts Payable new ")
        println("params: "+params)
        def oldAPBalance = 0.00D
        def newAPBalance = 0.00D
        def accountsPayableInstance = AccountsPayable.get(params.accountsPayableId)
            accountsPayableInstance.payable = params.payable
            accountsPayableInstance.customer = Customer.get(params.customer.id)
            accountsPayableInstance.currency = Currency.get(params.currency.id)
            accountsPayableInstance.glContra = params.glContra
            accountsPayableInstance.particulars = params.particulars
            accountsPayableInstance.reference = params?.reference
            oldAPBalance = accountsPayableInstance.balance
            
            newAPBalance = params.balance.toString().replace(',','').toDouble()
        accountsPayableInstance.save(flush:true,failOnError:true)   
        
        //check if AP has Account No
        if(accountsPayableInstance.acctNo == null || accountsPayableInstance.acctNo==""){
            generateAccountNo(accountsPayableInstance)
        }
        //============ txnfile for credit AP
        if(oldAPBalance == 0){
            def amountCash  = newAPBalance
            if(amountCash > 0){
                def cibId = accountsPayableInstance
                def b = Branch.get(1)
                def t = TxnTemplate.get(Institution.findByParamCode("GLS.60430").paramValue.toInteger())

                def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
                    txnAmt:amountCash,txnRef:'New AP Created - Cr Adjustment',status:ConfigItemStatus.get(2), branch:cibId.branch,
                    txnTimestamp: new Date().toTimestamp(),txnParticulars:''+accountsPayableInstance.particulars,txnType:t.txnType,txnTemplate:t, 
                    user:UserMaster.get(session.user_id))
                tx.save(flush:true, failOnError:true);

                def apLedger = new AccountsPayableLedger(accountsPayable:cibId, refDate:b.runDate, valueDate:b.runDate,
                    reference:'New AP Created - Cr Adjustment', particulars:''+accountsPayableInstance.particulars, debit:0.00D, credit:amountCash,
                    balance:cibId.balance+amountCash, txnFile:tx)
                apLedger.save(flush:true)


                cibId.balance = cibId.balance + amountCash 
                cibId.save(flush:true)
                //debit
                def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:t.defContraAcct,
                    debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
                txnDr.save(flush:true)
                println("t. :"+t.defContraAcct)
                //credit
                //def cashGl = UserMaster.get(session.user_id).cash.code
                    def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:cibId.glContra,
                        creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
                txnCrCash.save(flush:true)
                //==================================
            }
        }
        
        
        redirect(action: "show",controller: "accountsPayable",id:accountsPayableInstance.id)
    }
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accountsPayable.label', default: 'Cash in Bank'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }    
    def viewTransactions(AccountsPayable accountsPayableInstance){
        respond accountsPayableInstance
    }
    def apTxnView(AccountsPayable accountsPayableInstance){
        respond accountsPayableInstance   
    }
    def apDebit(AccountsPayable accountsPayableInstance){
        respond accountsPayableInstance
    }
    def apCredit(AccountsPayable accountsPayableInstance){
        respond accountsPayableInstance
    }
    @Transactional
    def saveapDebit(AccountsPayable accountsPayableInstance){
        // new txnfile
        println("params: "+params)
        def amountCash  = params.debitAmt.toString().replace(',','').toDouble()
        def cibId = AccountsPayable.get(params.apDebit.toInteger())
        if (amountCash > cibId.balance)
        {
            flash.message = "Invalid Debit Amount|error|alert"
            render(view:'/accountsPayable/apDebit', model: [accountsPayableInstance:cibId])
            return  
        }
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:cibId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.txparticulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        def apLedger = new AccountsPayableLedger(accountsPayable:cibId, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.txparticulars, debit:amountCash, credit:0.00D,
            balance:cibId.balance-amountCash, txnFile:tx)
        apLedger.save(flush:true)
    
    
        cibId.balance = cibId.balance - amountCash 
        cibId.save(flush:true)
        // for debit
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:cibId.glContra,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        
        // for credit
        //def cashGl = UserMaster.get(session.user_id).cash.code
        println("t. :"+t.defContraAcct)
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:t.defContraAcct,creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
        txnCrCash.save(flush:true)
        
        //check if accounts payable balance is zero Force Closed
        if(cibId.balance == 0){
            accountsPayableInstance.status = ConfigItemStatus.get(8)
            accountsPayableInstance.save(flush:true)
        }
       
        redirect(action: 'show',controller: 'AccountsPayable',id:cibId.id)
    }
    @Transactional    
    def saveapCredit(AccountsPayable accountsPayableInstance){
        // new txnfile
        println("params: "+params)
        def amountCash  = params.creditAmt.toString().replace(',','').toDouble()
        
        def cibId = AccountsPayable.get(params.apCredit.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:cibId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.txparticulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        def apLedger = new AccountsPayableLedger(accountsPayable:cibId, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.txparticulars, debit:0.00D, credit:amountCash,
            balance:cibId.balance+amountCash, txnFile:tx)
        apLedger.save(flush:true)
    
    
        cibId.balance = cibId.balance + amountCash 
        cibId.save(flush:true)
        //debit
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:t.defContraAcct,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        println("t. :"+t.defContraAcct)
        //credit
        //def cashGl = UserMaster.get(session.user_id).cash.code
            def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:cibId.glContra,
                creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
        txnCrCash.save(flush:true)
        
            //println('ito na: '+tx)
        
       
        redirect(action: 'show',controller: 'AccountsPayable',id:cibId.id)
    }	
    
    def apClose(AccountsPayable accountsPayableInstance){
        respond accountsPayableInstance
    }
    @Transactional
    def saveApClose(AccountsPayable accountsPayableInstance){
        // Needs new record in Config_Item_Status
        // insert into config_item_status (id, version, code, description, short_description, status) 
        // values (8,1,'995','Closed','CLSD',true);
        accountsPayableInstance.status = ConfigItemStatus.get(8)
        accountsPayableInstance.save(flush:true)
        
        respond accountsPayableInstance.errors, view:'show'   
    }
    def reclassAp(){
        println("========= RECLASS Accounts PAYABLE ===========")
        println("params: "+params)
        def accountsPayableInstance = AccountsPayable.get(params.id)
        [accountsPayableInstance:accountsPayableInstance]
    }
    def apSaveReclass(){
        println("============= SAVE AP RECLASS ===========")
        println("params: "+params)
        def accountsPayableInstance = AccountsPayable.get(params.accountsPayableId.toInteger())
        //=========== get reclass Accounts payable =================
        def b = Branch.get(1)
        def apDrReclassTemplate = Institution.findByParamCode("GLS.60420").paramValue
        def t = TxnTemplate.get(apDrReclassTemplate.toInteger())
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:accountsPayableInstance.currency,
            txnAmt:accountsPayableInstance.balance,txnRef:'AP Reclassification',status:ConfigItemStatus.get(2), branch:accountsPayableInstance.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:'AP Reclassification',txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        
        // for debit
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:accountsPayableInstance.currency,debitAcct:accountsPayableInstance.glContra,
            debitAmt:accountsPayableInstance.balance, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)

        accountsPayableInstance.glContra = params.reclassGlContra
        accountsPayableInstance.save(flush:true)

        def txnCr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,creditAcct:params.reclassGlContra,
            creditAmt:accountsPayableInstance.balance, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
            user:UserMaster.get(session.user_id))      
        txnCr.save(flush:true) 
        //===========================================
        
        redirect(action: 'show',controller: 'AccountsPayable',id:accountsPayableInstance.id)
    }
}
