package icbs.gl
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.admin.Branch
import icbs.tellering.TxnFile
import icbs.admin.Currency
import icbs.admin.TxnTemplate
import icbs.lov.TxnType
import icbs.gl.GlAccount
import icbs.admin.Branch
import icbs.tellering.TxnBreakdown
import icbs.gl.BillsPayableLedger
import icbs.gl.BillsPayableLoan
import icbs.loans.Loan
import java.lang.*
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.sql.Sql
class BillsPayableController {
    
    def dataSource
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]
    
    def index(Integer max) {
         params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            params.sort = "dateOpened"
        }
        if (UserMaster.get(session.user_id).branch.id == 3) {
            if (params.query == null) {  // show all instances  
                def billsPayableList = BillsPayable.list()
                respond billsPayableList, model:[billsPayableInstanceCount: BillsPayable.count()]
            }else{
                def billsPayableList = BillsPayable.createCriteria().list(params) {
                and {
                    eq("branch", UserMaster.get(session.user_id).branch)
                }
                or {              
                    ilike("pnNo", "%${params.query}%")
                    ilike("creditorName", "%${params.query}%")
                    ilike("accountName", "%${params.query}%")
                }
            }
            respond billsPayableList, model:[params:params, billsPayableInstanceCount: billsPayableList.totalCount]
            }
        }else if (params.query == null) {  // show all instances            
                def billsPayableList = BillsPayable.createCriteria().list(params) {
                    and {
                        eq("branch", UserMaster.get(session.user_id).branch)
                    }
                }
                respond billsPayableList, model:[params:params, billsPayableInstanceCount: billsPayableList.totalCount]
            }
        else {    // show query results
            def billsPayableList = BillsPayable.createCriteria().list(params) {
                and {
                    eq("branch", UserMaster.get(session.user_id).branch)
                }
                or {    
                    ilike("pnNo", "%${params.query}%")
                    ilike("creditorName", "%${params.query}%")
                    ilike("accountName", "%${params.query}%")
                }
            }
            respond billsPayableList, model:[params:params, billsPayableInstanceCount: billsPayableList.totalCount]
        }
    }
    
    def create(){
        respond new BillsPayable(params)
    }
    
    @Transactional
    def save(BillsPayable billsPayableInstance){
        if (billsPayableInstance == null) {
            notFound()
            return
        }      
        
        if (billsPayableInstance.hasErrors()) {
            respond billsPayableInstance.errors, view:'create'
            return
        }       
        
        if (!billsPayableInstance.glContra) {
            flash.error = 'GL Account cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }    
        if (!billsPayableInstance.accountName) {
            flash.error = 'Account Name cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }          
        if (!billsPayableInstance.creditorName) {
            flash.error = 'Creditor Name cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }  
        
        if (!billsPayableInstance.dateOpened) {
            flash.error = 'Date Opened cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }    
        if (!billsPayableInstance.dueDate) {
            flash.error = 'Date Opened cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        } else {
            if (billsPayableInstance.dueDate <= billsPayableInstance.dateOpened) {
                flash.error = 'Maturity date cannot be same or earlier than opening date|error|alert'
                respond billsPayableInstance.errors, view:'create'
                return                 
            }
        }      
        
        // initialize other values
        billsPayableInstance.principal = 0.00D
        billsPayableInstance.interestAmt = 0.00D
        billsPayableInstance.createdBy = UserMaster.get(session.user_id)
        billsPayableInstance.branch = billsPayableInstance.createdBy.branch
        billsPayableInstance.dateCreated = billsPayableInstance.branch.runDate
        billsPayableInstance.status = ConfigItemStatus.get(2)
        
        billsPayableInstance.save(flush:true)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'billsPayableInstance.label', default: 'Bills Payable'), billsPayableInstance.id])
                redirect billsPayableInstance
            }
            '*' { respond billsPayableInstance, [status: CREATED] }
        }        
    }
    def show(BillsPayable billsPayableInstance){
        respond billsPayableInstance
    }    
    
    def edit(BillsPayable billsPayableInstance) {
        respond billsPayableInstance
    }
    def viewTransactions(BillsPayable billsPayableInstance){
        respond billsPayableInstance
    }															
    
    @Transactional
    def update(BillsPayable billsPayableInstance) {
        if (billsPayableInstance == null) {
            notFound()
            return
        }      
        
        if (billsPayableInstance.hasErrors()) {
            respond billsPayableInstance.errors, view:'create'
            return
        }       
        
        if (!billsPayableInstance.glContra) {
            flash.error = 'GL Account cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }    
        if (!billsPayableInstance.accountName) {
            flash.error = 'Account Name cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }          
        if (!billsPayableInstance.creditorName) {
            flash.error = 'Creditor Name cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }  
        
        if (!billsPayableInstance.dateOpened) {
            flash.error = 'Date Opened cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        }    
        if (!billsPayableInstance.dueDate) {
            flash.error = 'Date Opened cannot be null|error|alert'
            respond billsPayableInstance.errors, view:'create'
            return              
        } else {
            if (billsPayableInstance.dueDate <= billsPayableInstance.dateOpened) {
                flash.error = 'Maturity date cannot be same or earlier than opening date|error|alert'
                respond billsPayableInstance.errors, view:'create'
                return                 
            }
        }      
        
        if (billsPayableInstance.isDirty('glContra')){
           // perform reclassification
           def originalGl = billsPayableInstance.getPersistentValue('glContra')
           def newGl = billsPayableInstance.glContra
           if (originalGl != newGl){
                // need new institution record for BP reclass pointer
                // insert into institution
                // (id, version, caption, param_code, param_type, param_value)
                // values
                // (107,1,'BP Reclass Transaction Template Pointer','GLS.60500','Numeric','75')
                def t = TxnTemplate.get(Institution.findByParamCode('GLS.60420').paramValue.toInteger())
                
                def tx = new TxnFile(txnCode:t.code,txnDescription:t.description,
                    txnDate:billsPayableInstance.branch.runDate,currency:t.currency,
                    txnAmt:billsPayableInstance.principal,txnRef:'Bills Reclass',status:ConfigItemStatus.get(2), 
                    branch:billsPayableInstance.branch,txnTimestamp: new Date().toTimestamp(),
                    txnParticulars:'BP Reclassification',txnType:t.txnType,txnTemplate:t, 
                    user:UserMaster.get(session.user_id))
                tx.save(flush:true)
                
                def txnDr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,debitAcct:originalGl,
                    debitAmt:billsPayableInstance.principal, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
                    user:UserMaster.get(session.user_id))
                txnDr.save(flush:true)
        
                def txnCr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,creditAcct:newGl,
                    creditAmt:billsPayableInstance.principal, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
                    user:UserMaster.get(session.user_id))      
                txnCr.save(flush:true)    
           }
        }
        // initialize other values
        billsPayableInstance.save(flush:true)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'billsPayableInstance.label', default: 'Bills Payable'), billsPayableInstance.id])
                redirect billsPayableInstance
            }
            '*' { respond billsPayableInstance, [status: UPDATED] }
        }        
        
    }
    
    def bpDebit(BillsPayable billsPayableInstance){
        respond billsPayableInstance
    }
    @Transactional
    def savebpDebit(BillsPayable billsPayableInstance){
        // new txnfile
        def amountCash  = params.debitAmt.toString().replace(',','').toDouble()
        def bpId = BillsPayable.get(params.bpDebitId.toInteger())
        if (amountCash > bpId.principal)
        {
            flash.message = "Invalid Withdrawal Amount|error|alert"
            render(view:'/billsPayable/bpDebit', model: [billsPayableInstance:bpId])
            return  
        }
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        def txtFile  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:bpId.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:bpId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        txtFile.save(flush:true, failOnError:true);
        
        def bpLedger = new BillsPayableLedger(billsPayable:bpId, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.particulars, debit:amountCash, credit:0.00D,
            balance:bpId.principal-amountCash, txnFile:txtFile)
        bpLedger.save(flush:true)
  
        bpId.principal = bpId.principal - amountCash 
        bpId.save(flush:true)
        
        def txnDeb = new TxnBreakdown(branch:txtFile.branch, currency:bpId.currency,debitAcct:bpId.glContra,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:txtFile, user:UserMaster.get(session.user_id))
        txnDeb.save(flush:true)
        

        def txnCrCash = new TxnBreakdown(branch:txtFile.branch, currency:bpId.currency,creditAcct:t.defContraAcct,
            creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:txtFile, user:UserMaster.get(session.user_id))      
        txnCrCash.save(flush:true)
        println('ito na: '+txtFile)
        
        billsPayableInstance = bpId
        respond billsPayableInstance.errors, view:'show'
    }
    
    def bpCredit(BillsPayable billsPayableInstance){
        respond billsPayableInstance
    }
    @Transactional
    def savebpCredit(BillsPayable billsPayableInstance){
        // new txnfile
        def amountCash  = params.creditAmt.toString().replace(',','').toDouble()
        
        def bpCId = BillsPayable.get(params.bpCreditId.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:bpCId.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:bpCId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        
        def bpCLedger = new BillsPayableLedger(billsPayable:bpCId, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.particulars, debit:0.00D, credit:amountCash,
            balance:bpCId.principal+amountCash, txnFile:tx)
        bpCLedger.save(flush:true)
    
    
        bpCId.principal = bpCId.principal + amountCash 
        bpCId.save(flush:true)
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:bpCId.currency,debitAcct:t.defContraAcct,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:bpCId.currency,creditAcct:bpCId.glContra,
                creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
        txnCrCash.save(flush:true)
        println('ito na: '+tx)
        
       
        billsPayableInstance = bpCId
        respond billsPayableInstance.errors, view:'show'
    }
    
    // link loans to Bills Payable
    def linkLoans(BillsPayable billsPayableInstance , Integer max){
       //  respond billsPayableInstanceprintln
         println "linkLoans outise params" + params
         println "Bills Payable" +  params.id
         println "max" + max
        if(max <= 0){
            max = 10    
        } 
          println params.query
            println "BP params" + params
            println "BP billsPayableInstance" + billsPayableInstance
            params.max = Math.min(max ?: 25, 100)
//            def billPayableLinkLoans = BillsPayableLoan.findAllByBillsPayable(BillsPayable.get(params.id))
//            println("billPayableLinkLoans : "+ billPayableLinkLoans)
            
            if(params.query.toString() == "null" || params.query.toString()== "")
            {
                
                //def billPayableLinkLoansInstance = billPayableLinkLoans
                def billPayableLinkLoansInstance = BillsPayableLoan.createCriteria().list (params) {
                   
                       eq("billsPayable",BillsPayable.get(params.id))
                       
                }
                render(view: "linkLoans", model: [params:params,billsPayableInstance: billsPayableInstance,
                    billPayableLinkLoansInstance: billPayableLinkLoansInstance,billPayableLinkLoansInstanceCount:billPayableLinkLoansInstance.totalCount])
            return
            }else{
                
                def billPayableLinkLoansInstance = BillsPayableLoan.createCriteria().list (params) {
                    and {
                        eq("billsPayable",BillsPayable.get(params.id))
                    }
                    or {
                    
                    ilike("loan","%${params.query}%")
                    ilike("user", "%${params.query}%")
                    ilike("status", "%${params.query}%")
                }
                   
                }
                render(view: "linkLoans", model: [params:params,billsPayableInstance: billsPayableInstance,
                    billPayableLinkLoansInstance: billPayableLinkLoansInstance,billPayableLinkLoansInstanceCount:billPayableLinkLoansInstance.totalCount])
            return
            }
            
            }
            
    def assignLoan(BillsPayable billsPayableInstance){
        
        def json = request.JSON
        //def TxnTypeInstance = TxnType.get(json.typevalue.toInteger())
        //def TxnTypeInstance = TxnType.get(json.typevalue)
        def idididid = BillsPayable.get(params.billspayable.toInteger())
        println("Printtt: "+params)
        
       
        def b = Branch.get(1)
        def loanIdId = Loan.get(params.id.toInteger())
        println("Id: "+ loanIdId)
        def loanIdIdList = BillsPayableLoan.list()
        println("loanIdIdList : "+loanIdIdList)
        println("GGGG :" + billsPayableInstance)
        println("idididid: "+idididid)
        
        
       println("gieeeeeeee")
        def billsPayableLoanSave = new BillsPayableLoan()
       
        
        billsPayableLoanSave.billsPayable = BillsPayable.get(params.billspayable.toInteger())
        billsPayableLoanSave.loan = loanIdId
        billsPayableLoanSave.linkDate = b.runDate
        billsPayableLoanSave.user = UserMaster.get(session.user_id)
        billsPayableLoanSave.status = ConfigItemStatus.get(2)
        
        println("billsPayableLoanSave.billsPayable "+ billsPayableLoanSave.billsPayable)
        println("billsPayableLoanSave.loan"+ billsPayableLoanSave.loan)
        println("billsPayableLoanSave.linkDate "+ billsPayableLoanSave.linkDate)
        println("billsPayableLoanSave.user "+ billsPayableLoanSave.user)
        println("billsPayableLoanSave.status "+ billsPayableLoanSave.status )
        

        
        
        billsPayableLoanSave.save(flush:true)
        def sql = new Sql(dataSource)
        def TxnTypeInstance = "select * from bills_payable where id = '${params.billspayable.toInteger()}'"
        def resultqueryall = sql.rows(TxnTypeInstance)
        
        println("return: "+resultqueryall)
        render resultqueryall as JSON
           
    }   
    def validateExistingAssignLoan(){
        println("validateExistingAssignLoan: "+params)
         def json = request.JSON
        //def existingLoan = BillsPayableLoan.findAllByLoanAndBillsPayable(Loan.get(params.id),params.billspayable)
        //println("existingLoan :" + existingLoan)
        
        def sql = new Sql(dataSource)
        def TxnTypeInstance = "select id from bills_payable_loan where " +
            "loan_id  = '${params.id}' and bills_payable_id = '${params.billspayable}' " +
            "union " +
            "select id from loan where id  = '${params.id}' and status_id in (1,6,7,8)"
        def resultqueryall = sql.rows(TxnTypeInstance)
        println("return: "+resultqueryall)
        render resultqueryall as JSON
        
        
    }
    def deleteLinkLoans( ){
        println("giezel params: "+params)
        def billPayableLinkLoansInstance = BillsPayableLoan.get(params.assignLoanId)
        
        def json = request.JSON
        def sql = new Sql(dataSource)
        def result = BillsPayableLoan.executeUpdate("delete from BillsPayableLoan where id = '${billPayableLinkLoansInstance.id}'")
        println("result :" + result)
       
        render resultqueryall as JSON 
     
    }
   
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'billsPayable.label', default: 'BillsPayable'),params.billspayable])
                redirect action: "linkLoans", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
        
    

