package icbs.gl
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.lov.DepositStatus
import icbs.tellering.TxnFile
import icbs.admin.Currency
import icbs.admin.TxnTemplate
import icbs.admin.Institution
import icbs.lov.TxnType
import icbs.cif.Customer
import icbs.gl.GlAccount
import icbs.admin.Branch
import icbs.lov.ConfigItemStatus
import icbs.tellering.TxnBreakdown
import org.hibernate.Session
import org.hibernate.SessionFactory
import groovy.sql.Sql
import icbs.admin.Product
class AccountsReceivableController {
static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", update: "POST"]
    def dataSource
    def index(Integer max) {
        println("Accounts Payable Instance")
        params.max = Math.min(max ?: 10, 100)

        if(params.offset==null){
            params.offset=0
        }
        if (UserMaster.get(session.user_id).branch.id == 3) {
            // main branch
            if (params.query == null) {
                respond AccountsReceivable.list(params), model:[params:params,AccountsReceivableInstanceCount:  AccountsReceivable.count()]
                return
            }else{
                def AccountsReceivableList = AccountsReceivable.createCriteria().list (params) {
                    or {
                        ilike("description", "%${params.query}%")
                        ilike("receivableName", "%${params.query}%")
                        ilike("acctNo", "%${params.query}%")
                    }
                    order("arCreatedDate", "desc")
                }
			 
                respond AccountsReceivableList, model:[params:params,AccountsReceivableInstanceCount: AccountsReceivableList.totalCount]
            }
            return
        }else if (params.query == null) {
            // meaning get user branch 
            def AccountsReceivableList = AccountsReceivable.createCriteria().list (params) {
					 
                eq("branch", UserMaster.get(session.user_id).branch)  
		order("arCreatedDate", "desc")		 
            }
            respond AccountsReceivableList, model:[params:params,AccountsReceivableInstanceCount: AccountsReceivableList.totalCount]
            return
        }else{
            def AccountsReceivableList = AccountsReceivable.createCriteria().list (params) {
					 
                eq("branch", UserMaster.get(session.user_id).branch) 
				 
                or {
                    ilike("description", "%${params.query}%")
                    ilike("receivableName", "%${params.query}%")
                    ilike("acctNo", "%${params.query}%")
                }
                order("arCreatedDate", "desc")
            }
            respond AccountsReceivableList, model:[params:params,AccountsReceivableInstanceCount: AccountsReceivableList.totalCount]
        }
        return
    }
    def generateAccountNo(AccountsReceivable accountsReceivableInstance) {
        
        
        int[] piArray = [1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8]
        
        String accountNo
        String branchCode
        String productCode
        println '+++' + accountsReceivableInstance.branch
        def productInstance = Product.get(Institution.findByParamCode("GLS.60500").paramValue.toInteger())
        def result = AccountsReceivable.executeQuery("select max(SUBSTRING(acctNo, 9,5))from AccountsReceivable where SUBSTRING(acctNo, 1,7) = CONCAT(:branch,'-',:prod))", [branch: String.format("%03d", accountsReceivableInstance?.branch?.code), prod: String.format("%03d", productInstance?.code)])
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
        
        branchCode = String.format("%03d", accountsReceivableInstance?.branch?.code)
        productCode = String.format("%03d", productInstance?.code)
        String serialCode = String.format("%05d", serialNum);

        
        accountNo = branchCode + productCode + serialCode
        println '+++' + accountNo
        def checksum = 0
        for(int i= accountNo.length() - 1; i >= 0;i--) {
            checksum += Character.getNumericValue(accountNo.charAt(i)) * piArray[i]
        }
        
        String checkBit = (checksum % 10).toString()
        
        accountsReceivableInstance.acctNo = branchCode+"-"+productCode +"-"+serialCode+"-"+checkBit
        
        println '+++' + accountsReceivableInstance.acctNo
        accountsReceivableInstance.save(flush:true,failOnError:true)
        
    }
    
    def create(){
         def customer = null
        if (params?.cid) {
            customer = Customer.get(params?.cid)
            
        }

        respond new AccountsReceivable(params), model:[customer:customer]
    }
    
    def edit(AccountsReceivable accountsReceivableInstance){
        respond accountsReceivableInstance
    } 
    @Transactional
    def update(AccountsReceivable accountsReceivableInstance){
        if (accountsReceivableInstance == null) {
            notFound()
            return
        }

        if (accountsReceivableInstance.hasErrors()) {
            respond accountsReceivableInstance.errors, view:'edit'
            return
        }
        
        if (accountsReceivableInstance.isDirty('glContra')){
           // perform reclassification
           def originalGl = accountsReceivableInstance.getPersistentValue('glContra')
           def newGl = accountsReceivableInstance.glContra
           if (originalGl != newGl){
                // need new institution record for AP reclass pointer
                // insert into institution
                // (id, version, caption, param_code, param_type, param_value)
                // values
                // (101,1,'AR Reclass Transaction Template Pointer','GLS.60410','Numeric','75')
                def t = TxnTemplate.get(Institution.findByParamCode('GLS.60410').paramValue.toInteger())
                
                def tx = new TxnFile(txnCode:t.code,txnDescription:t.description,
                    txnDate:accountsReceivableInstance.branch.runDate,currency:t.currency,
                    txnAmt:accountsReceivableInstance.balance,txnRef:'AR Reclass',status:ConfigItemStatus.get(2), 
                    branch:accountsReceivableInstance.branch,txnTimestamp: new Date().toTimestamp(),
                    txnParticulars:'AR Reclassification',txnType:t.txnType,txnTemplate:t, 
                    user:UserMaster.get(session.user_id))
                tx.save(flush:true)
                
                def txnDr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,debitAcct:originalGl,
                    debitAmt:accountsReceivableInstance.balance, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
                    user:UserMaster.get(session.user_id))
                txnDr.save(flush:true)
        
                def txnCr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,creditAcct:newGl,
                    creditAmt:accountsReceivableInstance.balance, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
                    user:UserMaster.get(session.user_id))      
                txnCr.save(flush:true)    
           }            
        }
        accountsReceivableInstance.save flush:true
  
        // Log
        //def description = 'save Currency ' +  currencyInstance.name
        //auditLogService.insert('040', 'ADM00100', description, 'currency', null, null, null, currencyInstance.id)


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accountsReceivable.label', default: 'Accounts Receivable'), accountsReceivableInstance.id])
                redirect accountsReceivableInstance
            }
            '*' { respond accountsReceivableInstance, [status: CREATED] }
        }
                  
    }
    def updateAccountsReceivable(){
        println("========= Update Accounts Receivable new ")
        println("params: "+params)
        def oldBalance = 0.00D
        def newARBalance = 0.00D
        def accountsReceivableInstance = AccountsReceivable.get(params.accountsReceivableId)
            oldBalance = accountsReceivableInstance.balance
            accountsReceivableInstance.receivableName = params.receivableName
            accountsReceivableInstance.maturityDate = params.maturityDate? new Date().parse("MM/dd/yyyy", params.maturityDate) : ''
            accountsReceivableInstance.requiredAllowance = params.requiredAllowance.toString().replace(',','').toDouble()
            accountsReceivableInstance.customer = Customer.get(params.customer.id)
            accountsReceivableInstance.currency = Currency.get(params.currency.id)
            accountsReceivableInstance.description = params.description
            accountsReceivableInstance.glContra = params.glContra
            accountsReceivableInstance.reference = params.reference
            
            
           
            
            //accountsReceivableInstance.balance = params.balance.toString().replace(',','').toDouble()
        accountsReceivableInstance.save(flush:true,failOnError:true)   
        newARBalance = params.balance.toString().replace(',','').toDouble()
        
        //check if AR has Account No
        if(accountsReceivableInstance.acctNo == null || accountsReceivableInstance.acctNo==""){
            generateAccountNo(accountsReceivableInstance)
        }
         
        // check if old balance is zero 
        if(oldBalance == 0){
            if(newARBalance > 0){
                //======== entry debit AR for first balance
                def amountCash  = newARBalance
                
                    def cibId = accountsReceivableInstance
                    def b = Branch.get(1)
                    def t = TxnTemplate.get(Institution.findByParamCode("GLS.60440").paramValue.toInteger())
                    def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
                        txnAmt:amountCash,txnRef:'AR Update - Dr Adjustment',status:ConfigItemStatus.get(2), branch:cibId.branch,
                        txnTimestamp: new Date().toTimestamp(),txnParticulars:'AR Update - Dr Adjustment',txnType:t.txnType,txnTemplate:t, 
                        user:UserMaster.get(session.user_id))
                    tx.save(flush:true, failOnError:true);
                    def arLedger = new AccountsReceivableLedger(accountsReceivable:cibId, refDate:b.runDate, valueDate:b.runDate,
                        reference:params.reference, particulars:'AR Update - Dr Adjustment', debit:amountCash, credit:0.00D,
                        balance:amountCash, txnFile:tx)
                    arLedger.save(flush:true)

                    cibId.balance = amountCash 
                    cibId.save(flush:true)

                    def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:cibId.glContra,
                        debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
                    txnDr.save(flush:true)
                    def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:t.defContraAcct,
                        creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
                    txnCrCash.save(flush:true)
                
                //=========================================
            }
        }
        redirect(action: "show",controller: "accountsReceivable",id:accountsReceivableInstance.id)
    }
    
    @Transactional
    def save(AccountsReceivable accountsReceivableInstance){
        def cifId = Customer.get(params.customer.id.toInteger())
        //def custAdd = Address.get()
        def addr = Customer.get(params.addresss)
        println("Customer ID:"+ cifId)
        if (accountsReceivableInstance == null) {
            notFound()
            return
        }
        accountsReceivableInstance.balance = params.balance.toString().replace(',','').toDouble()
        accountsReceivableInstance.requiredValuationReserves = params.requiredAllowance.toString().replace(',','').toDouble()
        
        if (accountsReceivableInstance.hasErrors()) {
            respond accountsReceivableInstance.errors, view:'create'
            return
        }  
        if (!accountsReceivableInstance.glContra) {
            flash.error = 'GL Account cannot be null|error|alert'
            respond accountsReceivableInstance.errors, view:'create'
            return              
        }
        if (!accountsReceivableInstance.description){
            flash.error = 'Description cannot be null|error|alert'
            respond accountsReceivableInstance.errors, view:'create'
            return              
        }
        
        accountsReceivableInstance.user = UserMaster.get(session.user_id)
        accountsReceivableInstance.customer = cifId
        accountsReceivableInstance.status = ConfigItemStatus.get(2)
        accountsReceivableInstance.branch = UserMaster.get(session.user_id).branch
        accountsReceivableInstance.bookingDate = accountsReceivableInstance.branch.runDate
        accountsReceivableInstance.arCreatedDate = UserMaster.get(session.user_id).branch.runDate
        accountsReceivableInstance.save(flush:true)
        
        //======== entry debit AR for first balance
        def amountCash  = accountsReceivableInstance.balance
        if(amountCash > 0){
            def cibId = accountsReceivableInstance
            def b = Branch.get(1)
            def t = TxnTemplate.get(params.txnType.toInteger())
            //def t = TxnTemplate.get(Institution.findByParamCode("GLS.60440").paramValue.toInteger())
            def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
                txnAmt:amountCash,txnRef:'New AR Created - Dr Adjustment',status:ConfigItemStatus.get(2), branch:cibId.branch,
                txnTimestamp: new Date().toTimestamp(),txnParticulars:'New AR Created - Dr Adjustment',txnType:t.txnType,txnTemplate:t, 
                user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            def arLedger = new AccountsReceivableLedger(accountsReceivable:cibId, refDate:b.runDate, valueDate:b.runDate,
                reference:params.reference, particulars:'New AR Created - Dr Adjustment', debit:amountCash, credit:0.00D,
                balance:amountCash, txnFile:tx)
            arLedger.save(flush:true)

            cibId.balance = amountCash 
            cibId.save(flush:true)

            def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:cibId.glContra,
                debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
            def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:t.defContraAcct,
                creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        }
        
        //GENERATE ACCOUNT NO
        generateAccountNo(accountsReceivableInstance)
        
        //=========================================
        // Log
        //def description = 'save Currency ' +  currencyInstance.name
        //auditLogService.insert('040', 'ADM00100', description, 'currency', null, null, null, currencyInstance.id)


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accountsReceivableInstance.label', default: 'Accounts Receivable'), accountsReceivableInstance.id])
                redirect accountsReceivableInstance
            }
            '*' { respond accountsReceivableInstance, [status: CREATED] }
        }        
    }
    def show(AccountsReceivable accountsReceivableInstance){
        
        def db = new Sql(dataSource)
        def sqlstmt  = "select A.balance, C.ACL, A.balance * case when C.ACL is null then 0 else C.ACL end as allowance,C.allowance_class_description "+
           " from accounts_receivable A inner join branch B on A.branch_id = B.id "+
           " left outer join allowance_classification C on cast( B.run_date::date - A.booking_date::date as int ) between no_of_days_from and no_of_days_to "+ 
           " where A.id = "+accountsReceivableInstance.id
        def xallowance = db.rows(sqlstmt) 
        for(xxupdate in xallowance){
            accountsReceivableInstance.requiredAllowance = xxupdate.allowance
            accountsReceivableInstance.save(flush: true)
        }
        respond accountsReceivableInstance
    }
    def viewTransactions(AccountsReceivable accountsReceivableInstance){
        println("accountsReceivableInstance: "+accountsReceivableInstance)
        respond accountsReceivableInstance
    }
    def arDebit(AccountsReceivable accountsReceivableInstance){
        respond accountsReceivableInstance
    }
    @Transactional
    def savearDebit(AccountsReceivable accountsReceivableInstance){
        // new txnfile
        def amountCash  = params.debitAmt.toString().replace(',','').toDouble()
        
        def cibId = AccountsReceivable.get(params.arDebit.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:cibId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        def arLedger = new AccountsReceivableLedger(accountsReceivable:cibId, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.particulars, debit:amountCash, credit:0.00D,
            balance:cibId.balance+amountCash, txnFile:tx)
        arLedger.save(flush:true)
        
        cibId.balance = cibId.balance + amountCash 
        cibId.save(flush:true)
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:cibId.glContra,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:t.defContraAcct,
            creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
        txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
        
       
        redirect(action: 'show',controller: 'AccountsReceivable',id:cibId.id)
    }

    def arCredit(AccountsReceivable accountsReceivableInstance){
        respond accountsReceivableInstance
    }
    
    // AR Credit
    @Transactional
    def savecrDebit(AccountsReceivable accountsReceivableInstance){
        // new txnfile
        def amountCash  = params.creditAmt.toString().replace(',','').toDouble()
        
        def cibId = AccountsReceivable.get(params.crCredit.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:cibId.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:cibId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        def arLedger = new AccountsReceivableLedger(accountsReceivable:cibId, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.particulars, debit:0.00D, credit:amountCash,
            balance:cibId.balance-amountCash, txnFile:tx)
        arLedger.save(flush:true)
        
        cibId.balance = cibId.balance - amountCash 
        cibId.save(flush:true)
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,debitAcct:t.defContraAcct,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:cibId.currency,creditAcct:cibId.glContra,
            creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
        txnCrCash.save(flush:true)
        
        //check if AR balance is zero then close AR
        if(cibId.balance == 0){
            cibId.status = ConfigItemStatus.get(8)
            cibId.save(flush:true)
        }
        
       
        redirect(action: 'show',controller: 'AccountsReceivable',id:cibId.id)
    }
    def reclassAr(){
        println("========= RECLASS Accounts PAYABLE ===========")
        println("params: "+params)
        def accountsReceivableInstance = AccountsReceivable.get(params.id)
        [accountsReceivableInstance:accountsReceivableInstance]
    }
    def arSaveReclass(){
        println("============= SAVE AP RECLASS ===========")
        println("params: "+params)
        def accountsReceivableInstance = AccountsReceivable.get(params.accountsReceivableId.toInteger())
        //=========== get reclass Accounts payable =================
        def b = Branch.get(1)
        def arCrReclassTemplate = Institution.findByParamCode("GLS.60450").paramValue
        def t = TxnTemplate.get(arCrReclassTemplate.toInteger())
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:accountsReceivableInstance.currency,
            txnAmt:accountsReceivableInstance.balance,txnRef:'AR Reclassification',status:ConfigItemStatus.get(2), branch:accountsReceivableInstance.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:'AR Reclassification',txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        
        // for debit
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:accountsReceivableInstance.currency,debitAcct:params.reclassGlContra,
            debitAmt:accountsReceivableInstance.balance, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)

        

        def txnCr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,creditAcct:accountsReceivableInstance.glContra,
            creditAmt:accountsReceivableInstance.balance, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
            user:UserMaster.get(session.user_id))      
        txnCr.save(flush:true)
        
        accountsReceivableInstance.glContra = params.reclassGlContra
        accountsReceivableInstance.save(flush:true)
        //===========================================
        
        redirect(action: 'show',controller: 'AccountsReceivable',id:accountsReceivableInstance.id)
    }
    def arClose(AccountsReceivable accountsReceivableInstance){
        respond accountsReceivableInstance
    }
    @Transactional
    def saveArClose(AccountsReceivable accountsReceivableInstance){
        accountsReceivableInstance.status = ConfigItemStatus.get(8)
        accountsReceivableInstance.save(flush:true)
        respond accountsReceivableInstance, view:'show'
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cashInBank.label', default: 'Cash in Bank'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
}
