package icbs.loans


import grails.converters.JSON
import grails.converters.deep.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import org.apache.poi.ss.formula.functions.Irr
import org.apache.poi.ss.formula.functions.FinanceLib
import icbs.tellering.TxnLoanPaymentDetails
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import icbs.lov.LoanProvisionBsp
import icbs.audit.AuditLog
import icbs.admin.Branch
import icbs.admin.Module
import icbs.admin.Product
import icbs.admin.UserMaster
import icbs.deposit.Deposit
import icbs.admin.Currency
import icbs.admin.Institution
import icbs.loans.LoanApplication
import icbs.loans.LoanRemark
import icbs.loans.LoanApplicationComaker.*
import icbs.loans.TxnRopaDetails
import icbs.loans.GroupRecord	
import icbs.loans.ScrRopa
import icbs.loans.ROPA
import icbs.loans.LoanLossProvisionDetail	
import icbs.loans.PenaltyIncomeScheme
import icbs.loans.LoanGuaranteeDetail
import icbs.loans.LoanAllowanceLedger
import icbs.loans.LoanUidLedger
import icbs.lov.LoanAcctStatus
import icbs.lov.LoanSpecialType
import icbs.lov.TxnType
import icbs.lov.LoanPerformanceId
import icbs.admin.TxnTemplate
import icbs.deposit.Hold
import icbs.deposit.Deposit
import icbs.lov.HoldStatus
import icbs.lov.HoldType
import icbs.lov.Commodity
import icbs.lov.ConfigItemStatus
import icbs.lov.SweepType
import icbs.lov.SweepRule
import icbs.lov.SweepStatus
import icbs.lov.LoanRediscountingPartner		  
import icbs.tellering.TxnFile
import icbs.gl.GlAccount
import icbs.gl.CfgAcctGlTemplate
import icbs.gl.CfgAcctGlTemplateDet
import org.hibernate.Session
import org.hibernate.SessionFactory
import icbs.reports.LoanListingEntry
import groovy.time.TimeCategory
import icbs.loans.LoanSweep
import groovy.sql.Sql
import icbs.tellering.TxnBreakdown
//new imports
import java.text.SimpleDateFormat
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartFile
import java.lang.*
import icbs.loans.LoanWriteOffCollectionHist
import icbs.loans.LoanReversalHist
import icbs.loans.LoanRestructureHist
import icbs.loans.ScrDiscountSchedule
import icbs.loans.LoanRediscountingStatus
// ===================================


class LoanController {
    def jrxmlTcId
    def jasperService
    def transactionFileId 
    def dataSource
    def auditLogService
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]
    
    def loanService   
    def glTransactionService

    def index(Integer max) {
      
        def module
        if (params?.module)
            module = params?.module
        else
            module = getModule(request?.forwardURI)
        def title = getTitle(module)

      //  params.max = Math.min(max ?: 10, 100)     //replace to change min to 25 line
        params.max = Math.min(max ?: 25, 100)
        
        if (params.sort == null) {
            params.sort = "id"
        }

        if (params.query == null) {
            respond Loan.list(params), model:[params:params, LoanInstanceCount: Loan.count(), module:module, title:title]
        } else {
            def LoanList  = Loan.createCriteria().list(params) {
               or{
                 ilike("accountNo","%${params.query.trim()}%")
                    'customer'{
                        or{
                            ilike("displayName","%${params.query.trim()}%")
                        }
                    }
                    if(params.query.trim().isLong()){
                        idEq(params.query.trim().toLong())
                        
                    }
                }
            }
            
            respond LoanList, model:[params:params, LoanInstanceCount: LoanList.totalCount, module:module, title:title]
        }
        return
    }
    
    def printLoanInstallment(){
        try {    
            //println"asdf "+session["jrxmlTcId"]
            params._name = "INSTALLMENT SCHEDULE FINAL VERSION"
            params._format ="PDF"//required caps
            params._file ="LOAN_INSTALLMENT_SCHEDULE_WITHOUT_EIR_NOLOGO.jasper" //jasper file name
            params.id=  session["jrxmlTcId"]
//            params.id = 1 //jasper param name
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()
            //set the byte content on the response. This determines what is shown in your browser window.       
            response.setContentType('application/pdf')
            response.setContentLength(bytes.length)

            response.setHeader('Content-disposition', 'inline; filename=quote.pdf')
            response.setHeader('Expires', '0');
            response.setHeader('Cache-Control', 'must-revalidate, post-check=0, pre-check=0');
            response.outputStream << bytes
            response.outputStream.flush()
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }        
    }
    
    def printDisclosure(){    
        try {    
            println"asdf "+session["jrxmlTcId"]
            params._name = "Disclosure Statement"
            params._format ="PDF"//required caps
            params._file ="Disclosure_Statement.jasper" //jasper file name
            params.id=  session["jrxmlTcId"]
//            params.id = 1 //jasper param name
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()
            //set the byte content on the response. This determines what is shown in your browser window.       
            response.setContentType('application/pdf')
            response.setContentLength(bytes.length)

            response.setHeader('Content-disposition', 'inline; filename=quote.pdf')
            response.setHeader('Expires', '0');
            response.setHeader('Cache-Control', 'must-revalidate, post-check=0, pre-check=0');
            response.outputStream << bytes
            response.outputStream.flush()
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }
    }  
     def printPromissory(){    
        try {    
            println"---------------- "
            params._name = "Promissory"
            params._format ="PDF"//required caps
            params._file ="PN.jasper" //jasper file name
            params.id =  session["jrxmlTcId"]
//            params.id = 1 //jasper param name
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()
            //set the byte content on the response. This determines what is shown in your browser window.       
            response.setContentType('application/pdf')
            response.setContentLength(bytes.length)

            response.setHeader('Content-disposition', 'inline; filename=quote.pdf')
            response.setHeader('Expires', '0');
            response.setHeader('Cache-Control', 'must-revalidate, post-check=0, pre-check=0');
            response.outputStream << bytes
            response.outputStream.flush()
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }
    } 
    //print loan inquiry
    def printLoanInquiry(){
        try {    
            println"---------------- "
            params._name = "loan_inquiry"
            params._format ="PDF"//required caps
            params._file ="loan_inquiry.jrxml" //jasper file name
            params.id =  session["jrxmlTcId"]
//            params.id = 1 //jasper param name
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()
            //set the byte content on the response. This determines what is shown in your browser window.       
            response.setContentType('application/pdf')
            response.setContentLength(bytes.length)

            response.setHeader('Content-disposition', 'inline; filename=quote.pdf')
            response.setHeader('Expires', '0');
            response.setHeader('Cache-Control', 'must-revalidate, post-check=0, pre-check=0');
            response.outputStream << bytes
            response.outputStream.flush()
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }        
    }
    //Loan Approval Slip
    def printLoanApprovalSlip(){    
        try {    
            println"---------------- "
            params._name = "LoanApprovalSlip"
            params._format ="PDF"//required caps
            params._file ="TransactionSlipLoanSample1.jrxml" //jasper file name
            params.id =  session["jrxmlTcId"]
//            params.id = 1 //jasper param name
            def reportDef = jasperService.buildReportDefinition(params, request.getLocale(), [])
            byte[] bytes = jasperService.generateReport(reportDef).toByteArray()
            //set the byte content on the response. This determines what is shown in your browser window.       
            response.setContentType('application/pdf')
            response.setContentLength(bytes.length)

            response.setHeader('Content-disposition', 'inline; filename=quote.pdf')
            response.setHeader('Expires', '0');
            response.setHeader('Cache-Control', 'must-revalidate, post-check=0, pre-check=0');
            response.outputStream << bytes
            response.outputStream.flush()
        }catch(Exception e) {
            //deal with your exception here
            e.printStackTrace()
        }
    }
    

    def search(Integer max) {
     //   params.max = Math.min(max ?: 10, 100)   //replace to change min to 25 line
//     println "Loan Params : " + params
//     println "Loan Params query : " + params.query
//     println "Loan Params sort : " + params.sort
//     println "Loan Params flag : " + params.flag
     def flags = params.flag
     if(!flags){
         flags = 0
     }
     params.max = Math.min(max ?: 25, 100)

        if (params.sort == null) {
            params.sort = "id"

        }
        
        if (params.query == null || params.query.trim() == "") {  // show all instances
//            if(flags.toInteger() == 6){
//                def stat = LoanAcctStatus.get(3)
//                def result = Loan.createCriteria().list(params){
//                    eq('status', stat)
//                }
//                render(template:"search/searchLoan", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
//            }
//            else
//            {
                render(template:"search/searchLoan", model:[params:params, domainInstanceList:Loan.list(params), domainInstanceCount:LoanApplication.count()]) as JSON
//            }
        } 
        else 
        {    
//            if(flags.toInteger() == 6){
//                println "TESTING : !!!"
//                // show query results
//                def result = Loan.createCriteria().list(params){
//                            or{
//                       ilike("accountNo","%${params.query.trim()}%")
//                       eq('status', stat)
//                       'customer'{
//                           or{
//                               ilike("displayName","%${params.query.trim()}%")
//                               eq('status', stat)
//                           }
//                       }
//                       if(params.query.trim().isLong()){
//                           idEq(params.query.trim().toLong())
//                       }
//                   }
//               }
//               render(template:"search/searchLoan", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
//            }
//            else
//            {
                // show query results
                def result = Loan.createCriteria().list(params){
                            or{
                       ilike("accountNo","%${params.query.trim()}%")
                       'customer'{
                           or{
                               ilike("displayName","%${params.query.trim()}%")
                           }
                       }
                       if(params.query.trim().isLong()){
                           idEq(params.query.trim().toLong())
                       }
                   }
               }
//               render(template:"search/searchLoan", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
//            }
            
 
            render(template:"search/searchLoan", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
        }            
        return
    }    

    def getModule(String url) {
        if (url =~ /^.*\/loanAmendment.*$/) {
            return "loanAmendment"
        } else if (url =~ /^.*\/loanInterestAccrual.*$/) {
            return "loanInterestAccrual"            
        } else if (url =~ /^.*\/loanRepricing.*$/) {
            return "loanRepricing" 
        } else if (url =~ /^.*\/loanReschedule.*$/) {
            return "loanReschedule" 
        } else if (url =~ /^.*\/reschedule.*$/) {
            return "loanReschedule"             
        } else if (url =~ /^.*\/loanRestructure.*$/) {
            return "loanRestructure" 
        } else if (url =~ /^.*\/restructure.*$/) {
            return "loanRestructure" 
        } else if (url =~ /^.*\/loanGLClassification.*$/) {
            return "loanGLClassification"
        } else if (url =~ /^.*\/loanRenewal.*$/) {
            return "loanRenewal"  
        } else if (url =~ /^.*\/loanBranchTransfer.*$/) {
            return "loanBranchTransfer"  
        } else if (url =~ /^.*\/loanApproval.*$/) {
            return "loanApproval"  
        } else if (url =~ /^.*\/loanTermination.*$/) {
            return "loanTermination"       
        } else if (url =~ /^.*\/loanWriteOff.*$/) {
            return "loanWriteOff"       
        } else if (url =~ /^.*\/loanROPA.*$/) {
            return "loanROPA"       
        } else if (url =~ /^.*\/loanProvision.*$/) {
            return "loanProvision"  
        }else if (url =~ /^.*\/scr.*$/) {
            return "scr"  
        } else {  // if (url =~ /^.*\/loan(\/|\/index|\/show\/\d*)?$/) {
            return "loan"
        }
    }

    def getTitle(String module) {
        if (module == "loan") {
            return "Loan Accounts"
        } else if (module == "loanAmendment") {
            return "Loan Account Amendment"
        } else if (module == "loanInterestAccrual") {
            return "Loan Account Interest Accrual"
        } else if (module == "loanRepricing") {
            return "Loan Account Repricing"
        } else if (module == "loanReschedule") {
            return "Loan Account Reschedule"
        } else if (module == "loanRestructure") {
            return "Loan Account Restructure"
        } else if (module == "loanGLClassification") {
            return "Loan GL Classification"
        } else if (module == "loanRenewal") {
            return "Loan Account Renewal"
        } else if (module == "loanBranchTransfer") {
            return "Loan Account Branch Transfer"
        } else if (module == "loanApproval") {
            return "Loan Account Approval"
        } else if (module == "loanTermination") {
            return "Loan Account Termination"
        } else if (module == "loanWriteOff") {
            return "Loan Account Write-Off"
        } else if (module == "loanROPA") {
            return "Loan ROPA"
		 } else if (module == "loanProvision") {
            return "Loan Loss Provisioning"
		}else if (module == "scr") {
            return "Sales Contract Receivable"
        }

    }

    def getLoanDetailsAjax() {
        def loanInstance = null
        if (params?.id) {
            loanInstance = Loan.get(params.id)

        }

        render(template:"search/loanDetails", model:[loanInstance: loanInstance]) as JSON
        return
    }

    def getTermAjax() {

        
        def term = params?.term ? params.term.toInteger() : 0
        def numInstallments = params?.numInstallments ? params.numInstallments.toInteger() : 0
        def frequency = params?.frequency ? params.frequency.toInteger() : 0
        def openingDate = params?.openingDate ? new Date().parse("MM/dd/yyyy", params?.openingDate) : null
        
        def firstInstallmentDate = params?.firstInstallmentDate ? new Date().parse("MM/dd/yyyy", params?.firstInstallmentDate) : null

        def interestIncomeScheme = null    
        if (params?.interestIncomeScheme) {
            interestIncomeScheme = InterestIncomeScheme.get(params.interestIncomeScheme)
        }

        def gracePeriod = interestIncomeScheme?.gracePeriod ?: 0
        def installmentType = interestIncomeScheme?.installmentType.id
        def installmentCalculation = interestIncomeScheme?.installmentCalcType.id

        def dueDate
        def prevDueDate = firstInstallmentDate  
        def baseDate = firstInstallmentDate   

        if (installmentType != 5 && installmentCalculation != 1 && installmentCalculation != 6) {
            for(int i = 1; i <= gracePeriod; i++) {                      
                dueDate = loanService.getNextDueDate(prevDueDate, baseDate, frequency)
                prevDueDate = dueDate
                baseDate = baseDate
              
            }
        }

        if (installmentCalculation == 1) {  // single payment   
            term = term + gracePeriod            

            render(template:"search/term", model:[term: term]) as JSON
            return
        } else if (installmentType == 5 || installmentCalculation == 6) {  // manual
            def lastInstallment = session["installments"].get(session["installments"].size() - 1)
            dueDate = lastInstallment.installmentDate
        } else {  // others
            for(int i = 1 + gracePeriod; i <= numInstallments + gracePeriod; i++) {
                if (i == 1 && firstInstallmentDate) {
                    dueDate = firstInstallmentDate
                } else {
                    
                    dueDate = loanService.getNextDueDate(prevDueDate, baseDate, frequency)
                }
                prevDueDate = dueDate
                baseDate = baseDate
              
            }
        }

        term = dueDate - openingDate

        render(template:"search/term", model:[term: term]) as JSON
        return
    }

    def show(Loan loanInstance) {
        println "id "+loanInstance.id
        def a = loanInstance.id.toInteger()
        session["jrxmlTcId"] = a
        def module = getModule(request?.forwardURI)
        def title = getTitle(module)

        def loanApplicationInstance = loanInstance.loanApplication
        def comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)
        
        println("   comakerss: "+comakers)	
        def totalDeductions = 0
        for(loanDeduction in loanInstance?.loanDeductions) {
            totalDeductions += loanDeduction?.amount
        }

        def totalUID = 0
        def totalUIDServiceCharge = 0.00D
        for(loanEIRSchedules in loanInstance?.loanEIRSchedules) {
            totalUID += loanEIRSchedules?.uidAmount.round(2)
            if(!loanEIRSchedules?.serviceChargeAmount){
                loanEIRSchedules?.serviceChargeAmount = 0.00D
            }
            totalUIDServiceCharge += loanEIRSchedules?.serviceChargeAmount
             
        }
        // add computation of interest to date
        def intToDate
        use(TimeCategory) {
            def duration = loanInstance.branch.runDate - loanInstance.accruedInterestDate
            intToDate = duration.days * loanInstance.interestRate.div(100) * loanInstance.balanceAmount.div(loanInstance.interestIncomeScheme.divisor)
        }
        if (loanInstance.branch.runDate > loanInstance.maturityDate) {
            intToDate = loanInstance.interestBalanceAmount
        } else {
            intToDate += loanInstance.interestBalanceAmount
        }
        intToDate = intToDate.round(2)
        
        if(loanInstance.status.id == 7){
            intToDate = 0.00D
        }


	def accountOfficerInstance


        def loanHistoryList = LoanHistory.findAllByAccountNo(loanInstance.accountNo)   
        
        //Audit Logs
        def auditLogsList = AuditLog.findAllByRecordIdAndTableNameAndModuleBetween(loanInstance.id,'Loan',Module.get(216),Module.get(236))
        println("auditLogsList: " +auditLogsList)

        respond loanInstance, model:[loanApplicationInstance:loanApplicationInstance,accountOfficerInstance:accountOfficerInstance, totalDeductions: totalDeductions, 
           totalUID: totalUID,totalUIDServiceCharge:totalUIDServiceCharge, loanHistoryList: loanHistoryList.sort{it.id}, module:module, title:title, intToDate:intToDate, comakers:comakers, auditLogsList:auditLogsList]
    }
    def create() {
        // initialize session variables
        session["serviceCharges"] = []
        session["deductions"] = []
        session["installments"] = []        
        session["eirSchedules"] = []
        session["sweepAccounts"] = []
        session["pageAction"]=""
        session["pageAction"]="create"	
        

        def loanApplication = null
        if (params?.id) {
            loanApplication = LoanApplication.get(params?.id)
        }

        respond new Loan(params), model:[loanApplication:loanApplication]
    }
    def accountTypeValidator(){
        
    }
    def applicationCollectInformation(){
        def json = request.JSON
        //def TxnTypeInstance = TxnType.get(json.typevalue.toInteger())
        //def TxnTypeInstance = TxnType.get(json.typevalue)
        def sql = new Sql(dataSource)
        println("id: "+json.id)
        //def TxnTypeInstance = " select a.amount, a.id, c.display_name, a.application_date,a.approval_status_id, a.product_id, b.product_type_id from loan_application a inner join customer c on c.id = a.customer_id inner join product as b on b.id = a.product_id join product_type as d on d.id = b.product_type_id where a.id = '${json.id.toInteger()}'"
        def TxnTypeInstance = " select a.amount, a.id, c.display_name, a.application_date,e.description,a.approval_status_id, a.product_id,b.name, b.product_type_id from loan_application a "+
        " inner join customer c on c.id = a.customer_id "+
        " inner join product b on b.id = a.product_id "+
        " inner join product_type d on d.id = b.product_type_id "+
        " inner join loan_application_status e on e.id = a.approval_status_id "+
        " where a.id = '${json.id.toInteger()}' "
        
        def resultqueryall = sql.rows(TxnTypeInstance)

        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }

    @Transactional
    def save(Loan loanInstance) {







	
	 
	
        if (loanInstance.loanApplication == null) {
            notFound()
            return
        }

        def test = LoanApplication.get(params.loanApplication).approvalStatus
        if (test.id != 6 && test.id != 9 && test.id != 10 && test.id != 11){
            statusPending()
            return
        }
        if(loanInstance.ageInArrears == null){
            loanInstance.ageInArrears = 0 
        }
        if(loanInstance.loanProvisionBsp == null){
           loanInstance.loanProvisionBsp = LoanProvisionBsp.get(1) 
        }
       
        if (loanInstance.grantedAmount < 0){ 
            flash.message = 'Loan Amount Cannot be negative !|error|alert'
            render(view: '/loan/create', model: [loanInstance:loanInstance])
            return
        }
        if (loanInstance.interestRate < 0){ 
            flash.message = 'Loan interest rate cannot be negative !|error|alert'
            render(view: '/loan/create', model: [loanInstance:loanInstance])
            return
        } 
        if (loanInstance.glLink == null) {
            flash.message = "Invalid Loan GL Link!|error|alert"
            render(view: '/loan/create', model: [loanInstance:loanInstance])
            return          
        }        
      
        if (loanInstance.grantedAmount > loanInstance.product.maxOpen){
            flash.message = "Loan amount greater than product limit!|error|alert"
            render(view: '/loan/create', model: [loanInstance:loanInstance])
            return              
        }
        if (loanInstance.grantedAmount < loanInstance.product.minOpen){
            flash.message = "Loan amount less than allowed for product!|error|alert"
            render(view: '/loan/create', model: [loanInstance:loanInstance])
            return              
        }        
        loanService.beforeValidation(loanInstance)
        loanInstance.clearErrors()
            loanInstance.validate()

            def installmentType = loanInstance?.interestIncomeScheme?.installmentType.id
            def installmentCalculation = loanInstance?.interestIncomeScheme?.installmentCalcType.id
        if (installmentType == 5 || installmentCalculation == 6) {  // manual            
            loanInstance.numInstallments = session["installments"].size()
            Boolean dateCheck = false
            Boolean checkAmt = false
            def startDate = Branch.get(1).runDate
            
            def totalAmount = 0.00D
            for(installment in session["installments"]) {
                totalAmount = totalAmount + installment.principalInstallmentAmount
                if (installment.installmentDate <= startDate) {
                    dateCheck = true
                }
                startDate = installment.installmentDate
                if (installment.principalInstallmentAmount < 0 || installment.interestInstallmentAmount < 0 || installment.serviceChargeInstallmentAmount < 0) {
                    checkAmt = true
                }
            }            

            loanInstance.clearErrors()
            loanInstance.validate()
            
            totalAmount = totalAmount.round(2)
            loanInstance.grantedAmount = loanInstance.grantedAmount.round(2)
            if (dateCheck==true) {
                println '==== loan installments date check fail====='
                loanInstance.errors.rejectValue("maturityDate", "loan.maturityDate.invalid")                
            }
            if (checkAmt==true) {
                println '==== loan installments amounts check fail====='
                loanInstance.errors.rejectValue("grantedAmount", "loan.grantedAmount.invalid")                
            }            
            if (totalAmount != loanInstance.grantedAmount) {
                println '==== loan granted check ====='
                println totalAmount
                println '============================='
                loanInstance.errors.rejectValue("grantedAmount", "loan.grantedAmount.incorrect")
            }
        }
        
            if (loanInstance.applicationDate == null)
            {  
                loanInstance.applicationDate = Branch.get(1).runDate
            }
        
            if (loanInstance.openingDate == null)
            {  
                loanInstance.openingDate = Branch.get(1).runDate
                loanInstance.accruedInterestDate = Branch.get(1).runDate
            } 
            if (loanInstance.firstInstallmentDate)
            {  
               if(loanInstance.firstInstallmentDate < Branch.get(1).runDate)
               {
                    flash.message = 'First Installment Date Cannot be less than Current Date !.|error|alert'
                    render(view: '/loan/create', model: [loanInstance:loanInstance])
                    return
               }
            } 

        if (loanInstance.hasErrors()) {
            respond loanInstance.errors, view:'create'
            return
        }                              
        loanService.initializeLoan(loanInstance)
        def installmentAmount = params?.installmentAmount ? (params?.installmentAmount.replaceAll(",","")).toDouble() : null
        loanService.saveLoan(loanInstance, installmentAmount)
         def description = loanInstance.accountNo + ' was created by ' + UserMaster.get(session.user_id).username
           auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)
        
        request.withFormat {
            form multipartForm {
                    //loanInstance.totalNetProceeds = loanInstance.totalNetProceeds - loanInstance.advInterest
                    // loanInstance.save flush:true          
                //flash.message = message(code: 'default.created.message', args: [message(code: 'loan.label', default: 'Loan'), loanInstance.id])
                flash.message = 'Successfully opened Account ' +loanInstance.accountNo
                redirect loanInstance
            }
            '*' { respond loanInstance, [status: CREATED] }
        }
    }
    
    def renew(Loan renewalLoanInstance) { 
        def module = getModule(request?.forwardURI)

        //if (module == "loanRenewal") 
        def loanInstance = Loan.read(renewalLoanInstance.id)
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)
        
        def newLoanInstance = new Loan()
        newLoanInstance.id =  Loan.count() + 1
        // clone loan account
        Loan.constraints.each() { key, value ->
            if (key != "loanInstallments" && key != "serviceCharges" && key != "loanDeductions" && 
                key != "loanEIRSchedules" && key != "sweepAccounts" ) {
                newLoanInstance."${key}" = loanInstance."${key}"
            }
        }        

        //respond newLoanInstance, model:[module:module]
        respond loanInstance, model:[module:module]
    }

    def applyIntToDate(Loan loanInstance) { 
        def module = getModule(request?.forwardURI)
        Double totInt = 0.00D
        Double intRate
        
        if (loanInstance.loanPerformanceId.id == 1 ) {
            intRate = loanInstance.interestRate.div(100) 
        } else {
            // past due, use different rate
            intRate = loanInstance.interestRate.div(100)
        }
        if (loanInstance.maturityDate <= loanInstance.branch.runDate) {
            flash.message = 'Account Already matured'
        } else if (loanInstance.advInterest > 0) {           
            flash.message = 'Advance interest error'
        } else {
            use(TimeCategory) {
                def duration = loanInstance.branch.runDate - loanInstance.accruedInterestDate
                totInt  = (loanInstance.balanceAmount * intRate * duration.days).div(loanInstance.interestIncomeScheme.divisor)
                totInt = totInt.round(2)
            }
        }
        
        if (totInt > 0) {
            println totInt
            def tf = new TxnFile(acctNo:loanInstance.accountNo, branch:loanInstance.branch, currency:loanInstance.product.currency,
                loanAcct:loanInstance, status:ConfigItemStatus.get(2), user:UserMaster.get(session.user_id), txnAmt:totInt,
                txnCode:TxnTemplate.get(40).code, txnDate:loanInstance.branch.runDate, txnTimestamp:new Date().toTimestamp(),
                txnDescription:'Apply Interest to Date', txnParticulars: loanInstance.accountNo + ' - Apply Interest to current Date', 
                txnType:TxnTemplate.get(40).txnType, txnRef:loanInstance.accountNo + ' Int', txnTemplate:TxnTemplate.get(40))
            
            tf.save(flush:true)
            
            def ll = new LoanLedger(loan: loanInstance, txnFile: tf, txnDate: tf.txnDate, txnTemplate: TxnTemplate.get(40), 
                interestCredit: totInt, interestDebit:totInt, txnRef: tf.txnRef,principalBalance: loanInstance.balanceAmount)
            ll.save(flush:true)
            
            loanInstance.interestBalanceAmount += totInt
            loanInstance.save(flush:true)
            flash.message = 'Interest Credit Completed!!!'
            
            session["transactionFileId"] = tf.id.toInteger()
            redirect(controller: "tellering", action: "txnSuccess")
        } else {
            redirect(action: "show", id:loanInstance.id , params: [loanInstance: loanInstance])
        }

    }
    
    def applyIntToMaturity(Loan loanInstance) { 
        def module = getModule(request?.forwardURI)
        Double totInt = 0.00D
        
        for(installment in loanInstance.loanInstallments.sort{it.sequenceNo}) {
            if (installment.status.id == 2 || installment.status.id == 3 || installment.status.id == 4) {
                totInt += (installment.interestInstallmentAmount - installment.interestInstallmentPaid)
            }
        }
        
        if (loanInstance.maturityDate <= loanInstance.branch.runDate) {
            totInt = 0.00D
            flash.message = 'Loan Already matured'
        }
        
        if (totInt > 0) {
            println totInt
            def tf = new TxnFile(acctNo:loanInstance.accountNo, branch:loanInstance.branch, currency:loanInstance.product.currency,
                loanAcct:loanInstance, status:ConfigItemStatus.get(2), user:UserMaster.get(session.user_id), txnAmt:totInt,
                txnCode:TxnTemplate.get(40).code, txnDate:loanInstance.branch.runDate, txnTimestamp:new Date().toTimestamp(),
                txnDescription:'Apply Interest to Date', txnParticulars: loanInstance.accountNo + ' - Apply Interest to maturity', 
                txnType:TxnTemplate.get(40).txnType, txnRef:loanInstance.accountNo + ' Int', txnTemplate:TxnTemplate.get(40))
            
            tf.save(flush:true)
            
            def ll = new LoanLedger(loan: loanInstance, txnFile: tf, txnDate: tf.txnDate, txnTemplate: TxnTemplate.get(40), 
                interestCredit: totInt, interestDebit:totInt, txnRef: tf.txnRef,principalBalance: loanInstance.balanceAmount)
            ll.save(flush:true)
            
            loanInstance.interestBalanceAmount += totInt
            loanInstance.save(flush:true)
            flash.message = 'Interest Credit to Maturity Completed!!!'
            session["transactionFileId"] = tf.id.toInteger()
            redirect(controller: "tellering", action: "txnSuccess")
            
        } else {
            redirect(action: "show", id:loanInstance.id , params: [loanInstance: loanInstance])            
        }
    }
    
def capitalizeAccruedInt(Loan loanInstance) { 
        // make loan payment and then loan disbursement
        def totInt = loanInstance.interestBalanceAmount + loanInstance.penaltyBalanceAmount
        if (totInt > 0.00D) {
            // loan payment
            def tx = TxnTemplate.get(Institution.findByParamCode("LNS.50073").paramValue.toInteger())
            def tf = new TxnFile(acctNo:loanInstance.accountNo, branch:loanInstance.branch, currency:loanInstance.product.currency,
                loanAcct:loanInstance, status:ConfigItemStatus.get(2), user:UserMaster.get(session.user_id), txnAmt:totInt,
                txnCode:tx.code, txnDate:loanInstance.branch.runDate, txnTimestamp:new Date().toTimestamp(),
                txnDescription:'Capitalize Interest - Interest Payment', txnParticulars: loanInstance.accountNo + ' - Capitalize Interest Payment', 
                txnType:tx.txnType, txnRef:loanInstance.accountNo + ' Int', txnTemplate:tx)
            
            tf.save(flush:true)
            
            def ll = new LoanLedger(loan: loanInstance, txnFile: tf, txnDate: tf.txnDate, txnTemplate: tx, 
                interestCredit: loanInstance.interestBalanceAmount, interestDebit:loanInstance.interestBalanceAmount, 
                txnRef: tf.txnRef,principalBalance: loanInstance.balanceAmount)
            ll.save(flush:true)
            
            loanInstance.interestBalanceAmount = 0.00D
            loanInstance.penaltyBalanceAmount = 0.00D
            loanInstance.save(flush:true)
            
            def txnLoanPaymentDetailsInstance = new TxnLoanPaymentDetails() 
            txnLoanPaymentDetailsInstance.acct = loanInstance  
            txnLoanPaymentDetailsInstance.acctNo = loanInstance?.accountNo  
            txnLoanPaymentDetailsInstance.balForwarded = loanInstance?.balanceAmount
            txnLoanPaymentDetailsInstance.branch = loanInstance?.branch
            txnLoanPaymentDetailsInstance.currency = Currency.get(loanInstance?.product?.currencyId)
            txnLoanPaymentDetailsInstance.interestAmt = ll.interestCredit
            txnLoanPaymentDetailsInstance.interestBalAfterPayment = 0.00D
            txnLoanPaymentDetailsInstance.paymentAmt = totInt
            txnLoanPaymentDetailsInstance.penaltyAmt = ll.penaltyCredit
            txnLoanPaymentDetailsInstance.penaltyBalAfterPayment = 0.00D
            txnLoanPaymentDetailsInstance.principalAmt = 0.00D
            txnLoanPaymentDetailsInstance.principalBalAfterPayment = loanInstance?.balanceAmount
            txnLoanPaymentDetailsInstance.serviceChargeAmt = 0.00D
            txnLoanPaymentDetailsInstance.totalNetProceeds = loanInstance?.totalNetProceeds
            txnLoanPaymentDetailsInstance.txnDate = loanInstance.branch.runDate
            txnLoanPaymentDetailsInstance.txnFile = tf 
            txnLoanPaymentDetailsInstance.txnRef = tf.txnRef 
            txnLoanPaymentDetailsInstance.user = UserMaster.get(session.user_id)
            txnLoanPaymentDetailsInstance.save(flush:true,failOnError:true)
            
            glTransactionService.saveTxnBreakdown(tf.id)
            
            
            // loan disbursement / principal memo debit
            def txDisb = TxnTemplate.get(Institution.findByParamCode("LNS.50081").paramValue.toInteger())
            def tfDisb = new TxnFile(acctNo:loanInstance.accountNo, branch:loanInstance.branch, currency:loanInstance.product.currency,
                loanAcct:loanInstance, status:ConfigItemStatus.get(2), user:UserMaster.get(session.user_id), txnAmt:totInt,
                txnCode:txDisb.code, txnDate:loanInstance.branch.runDate, txnTimestamp:new Date().toTimestamp(),
                txnDescription:'Capitalize Interest - Memo Debit Principal', 
                txnParticulars: loanInstance.accountNo + ' - Memo Debit Principal', 
                txnType:txDisb.txnType, txnRef:loanInstance.accountNo + ' Int', txnTemplate:txDisb)
            
            tfDisb.save(flush:true)
            
            def llDisb = new LoanLedger(loan: loanInstance, txnFile: tfDisb, txnDate: tfDisb.txnDate, txnTemplate: txDisb, 
                interestCredit: 0.00D, interestDebit:0.00D, 
                txnRef: tfDisb.txnRef,principalDebit:totInt,principalBalance: loanInstance.balanceAmount + totInt)
            llDisb.save(flush:true)
            
            loanInstance.totalDisbursementAmount += totInt
            loanInstance.balanceAmount += totInt
            loanInstance.save(flush:true)
            
            glTransactionService.saveTxnBreakdown(tfDisb.id)
            
            flash.message = 'Capitalize Interest Payment Completed!!!'
            session["transactionFileId"] = tfDisb.id.toInteger()
            redirect(controller: "tellering", action: "txnSuccess")
            
        } else {
            flash.message = 'Account Error - no interest to capitalize!|error|alert'
            redirect(action: "show", id:loanInstance.id , params: [loanInstance: loanInstance])            
        }      
    }


    //@Transactional
    //this is also used for renewal
    def saveNew(Loan loanInstance) {  
        println '$$$$$'
        println params
        println loanInstance
        if (loanInstance == null) {
            notFound()
            return
        }

        def ol = loanInstance.id
        def newLoanInstance = new Loan()
        newLoanInstance.id =  Loan.count() + 1
        // clone loan account
        Loan.constraints.each() { key, value ->
            if (key != "loanInstallments" && key != "serviceCharges" && key != "loanDeductions" && 
                key != "loanEIRSchedules" && key != "sweepAccounts" ) {
                newLoanInstance."${key}" = loanInstance."${key}"
            }
        }
        loanInstance.discard()
        def oldLoan = Loan.get(ol)
        
        if (params.activity=='Renewal') {
            def oldRenew = LoanRenewal.findAllByOldLoanAndRenewalCompleted(oldLoan, true)
            if (oldRenew) {
                oldLoan.errors.rejectValue("accountNo", "loan.accountNo.alreadyRenewed")
                respond oldLoan.errors, view:'renew', model:[module:params?.module]
                return
            }
            
            if (oldLoan.product.configItemStatus.id != 2) {
                oldLoan.errors.rejectValue("product", "loan.product.productClosed")
                respond oldLoan.errors, view:'renew', model:[module:params?.module]
                return                
            }
            
            def totAmtToClose = oldLoan.balanceAmount + oldLoan.interestBalanceAmount + oldLoan.penaltyBalanceAmount + oldLoan.serviceChargeBalanceAmount
            if (loanInstance.grantedAmount < totAmtToClose) {
                oldLoan.errors.rejectValue("grantedAmount", "loan.grantedAmount.grantedAmountCannotCoverTotalDue")
                respond oldLoan.errors, view:'renew', model:[module:params?.module]
                return                
            }
            // cancel/delete all unposted renewals, treat the orphan loans as new
            def renewalList = LoanRenewal.findAllByOldLoanAndRenewalCompleted(loanInstance, false)
            for (rl in renewalList) {
                rl.delete(flush:true)
            }
        }
        
        loanService.beforeValidation(newLoanInstance)
        newLoanInstance.clearErrors()
        newLoanInstance.validate()

        def installmentType = newLoanInstance?.interestIncomeScheme?.installmentType.id
        def installmentCalculation = loanInstance?.interestIncomeScheme?.installmentCalcType.id
        if (installmentType == 5 || installmentCalculation == 6) {  // manual            
            newLoanInstance.numInstallments = session["installments"].size()

            def totalAmount = 0
            for(installment in session["installments"]) {
                totalAmount = totalAmount + installment.principalInstallmentAmount
            }            

            newLoanInstance.clearErrors()
            newLoanInstance.validate()

            if (totalAmount != newLoanInstance.grantedAmount) {
                nl.errors.rejectValue("grantedAmount", "loan.grantedAmount.incorrect")
            }
        }

        if (newLoanInstance.hasErrors()) {
            respond newLoanInstance.errors, view:'renew', model:[module:params?.module]
            return
        }        

        // add validation for new loan instance
        if (params.activity=='Renewal') {
            
            newLoanInstance.validate()
            if (newLoanInstance.hasErrors()) {
                respond newLoanInstance.errors, view:'renew', model:[module:params?.module]
                return
            }            
        } 
        
        if (module == "loanRenewal")
            loanService.commitLoanHistoryEntry(params?.activity)

        loanService.initializeLoan(newLoanInstance)
        def installmentAmount = params?.installmentAmount ? (params?.installmentAmount.replaceAll(",","")).toDouble() : null
        if (params.activity=='Renewal') { 
            loanService.renewLoan(newLoanInstance, installmentAmount)
        } else {
            loanService.saveLoan(newLoanInstance, installmentAmount)
        }
        
        // update renewal table
        if (params.activity=='Renewal') {
            def lnRenew = new LoanRenewal(customer:newLoanInstance.customer, newLoan:newLoanInstance,
                newLoanAmount:newLoanInstance.grantedAmount, oldLoan:oldLoan, oldLoanAmount:oldLoan.grantedAmount,
                renewalCompleted:false)
            lnRenew.save(flush:true, failOnError:true)            

            def description = oldLoan.accountNo + ' renewal was processed by ' + UserMaster.get(session.user_id).username
            auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, oldLoan.id)
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'loan.label', default: 'Loan'), newLoanInstance.id])
                redirect controller:params?.module, action:'show', id:newLoanInstance?.id 
                //redirect loanInstance
            }
            '*' { respond newLoanInstance, [status: CREATED] }
        }
    }

    def edit(Loan loanInstance) {
        session["pageAction"]=""
        session["sweeplist"] =""
        session["pageAction"]="edit"
        session["loanidvalue"]=""
        session["loanidvalue"]=loanInstance.id
        println("loan id: "+loanInstance.id)
        session["sweepAccounts"] = null
        session["loanModule"] = null
        def c = LoanRecovery.createCriteria()
        def results = c.list {
            
            eq("fundedLoan", Loan.get(loanInstance.id))	 
        }
        session["sweeplist"] = results
        
        println("mysweepList: "+session["sweeplist"])
        def module = getModule(request?.forwardURI)
        
        createLoanHistoryEntry(loanInstance)        
        createSessionData(loanInstance)        
        def loanApplication = loanInstance.loanApplication
        respond loanInstance, model:[module:module,loanApplication:loanApplication]
   
   
    }

    def reschedule(Loan loanInstance) {
        def module = getModule(request?.forwardURI)
        
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)        
        def loanApplication = loanInstance.loanApplication
        session["installments"] = [] 
        respond loanInstance, model:[module:module,loanApplication:loanApplication]
    }

    def writeOff(Loan loanInstance) {
        def module = getModule(request?.forwardURI)
        
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)        

        respond loanInstance, model:[module:module]
    }    

    @Transactional
    def update(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }
        println("==============================================================")
        println("Loan updateeeee  params: "+params)
        println("params activity: "+params?.activity)
        
        session["loanModule"] = params?.activity
        println("session[loanModule]: "+session["loanModule"])  
        //to create installment amount base on balance amount
        def origOpen = loanInstance.openingDate
        def origGranted = loanInstance.grantedAmount
        if (params?.activity == "Reschedule") {
           
            loanInstance.grantedAmount = loanInstance.balanceAmount
            loanInstance.openingDate = loanInstance.branch.runDate
            if (loanInstance.interestIncomeScheme.installmentCalcType.id == 6) {
                // for manual installment, interest start date to current date
                loanInstance.interestStartDate = loanInstance.branch.runDate
            }
            if (loanInstance.interestStartDate < loanInstance.branch.runDate) {
				flash.message = 'Interest Start Date should be Greater than Run Date!'																	   
                respond loanInstance.errors, view:'reschedule', model:[module:params?.module]
                return                
            }
            if (loanInstance.firstInstallmentDate < loanInstance.branch.runDate) {
				flash.message = 'First Installment Date should be Greater than Run Date!'																		  
                respond loanInstance.errors, view:'reschedule', model:[module:params?.module]
                return                
            }     
            
            println '******************************'
            println loanInstance.grantedAmount
            println loanInstance.openingDate
            println '******************************'
        }
        if (params?.activity == "Restructure") {
            loanInstance.grantedAmount = loanInstance.balanceAmount
            loanInstance.openingDate = loanInstance.branch.runDate
            if (loanInstance.interestStartDate < loanInstance.branch.runDate) {
                 flash.message = 'Interest Start Date should be Greater than Run Date!'
                respond loanInstance.errors, view:'restructure', model:[module:params?.module]
                return                
            }
            if (loanInstance.firstInstallmentDate < loanInstance.branch.runDate) {
                flash.message = 'First Installment Date should be Greater than Run Date!'
                respond loanInstance.errors, view:'restructure', model:[module:params?.module]
                return                 
            } 
            loanInstance.grantedAmount = loanInstance.balanceAmount
            loanInstance.openingDate = loanInstance.branch.runDate
            //update lastTransactionDate for loan restructure
            loanInstance.lastTransactionDate = loanInstance.branch.runDate					  
        }
        
        loanService.beforeValidation(loanInstance)
        loanInstance.clearErrors()
        loanInstance.validate()
        
         
        
        if (params.activity == 'Amendment' && loanInstance.status.id > 2) {
            println("pasok dito sa amendment")
            def uId = UserMaster.get(session.user_id)  
            loanService.saveLoanAmendment(loanInstance, uId)
            
             def description = 'Loan Account ' +  loanInstance.accountNo + ' was edited by ' + UserMaster.get(session.user_id).username
           auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)
        
            
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.updated.message', args: [message(code: 'Loan.label', default: 'Loan'), loanInstance.id])
                    redirect controller:params?.module, action:'show', id:loanInstance?.id 
                }
                '*'{ respond loanInstance, [status: OK] }
            }
            return
        }
            
        def installmentType = loanInstance?.interestIncomeScheme?.installmentType.id
        def installmentCalculation = loanInstance?.interestIncomeScheme?.installmentCalcType.id
        if (installmentType == 5 || installmentCalculation == 6) {  // manual            
            loanInstance.numInstallments = session["installments"].size()

            def totalAmount = 0
            for(installment in session["installments"]) {
                totalAmount = totalAmount + installment.principalInstallmentAmount
            }            
           
            loanInstance.clearErrors()
            loanInstance.validate()
            println("totalAmount : "+totalAmount.round(2))
            println("granted amount: "+loanInstance.grantedAmount)
            totalAmount = totalAmount.round(2)
            if (totalAmount != loanInstance.grantedAmount) {
                println("condition totalAmount != loanInstance.grantedAmount ")
                loanInstance.errors.rejectValue("grantedAmount", "loan.grantedAmount.incorrect")
            }
        }
       
        if (loanInstance.hasErrors()) {
            if(params?.activity == "Restructure"){
                println("condition .hasErrors")
                loanInstance = Loan.get(loanInstance.id)
                respond loanInstance.errors, view:'restructure', model:[module:params?.module]
                return
            }else if(params?.activity == "Reschedule"){
                println("condition .hasErrors")
                loanInstance = Loan.get(loanInstance.id)
                respond loanInstance.errors, view:'reschedule', model:[module:params?.module]
                return
            }else{
                println("condition .hasErrors")
                loanInstance = Loan.get(loanInstance.id)
                respond loanInstance.errors, view:'edit', model:[module:params?.module]
                return
            }
        }    
        
        loanService.commitLoanHistoryEntry(params?.activity)
        clearLoanData(loanInstance)
        
        if (params?.activity == "Write-Off") {
            loanService.writeOff(loanInstance)
        }
       println("asdasdasdads")
        def installmentAmount = params?.installmentAmount ? (params?.installmentAmount.replaceAll(",","")).toDouble() : null        
        loanService.saveLoan(loanInstance, installmentAmount)
        // to revert back granted amount value
        if (params?.activity == "Reschedule") {   
        //loanInstance.grantedAmount = origGranted
        //loanInstance.openingDate = origOpen
            loanInstance.status = LoanAcctStatus.read(4)
			 def description = loanInstance.accountNo + ' was rescheduled by ' + UserMaster.get(session.user_id).username
            auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)
            
            //create txn file as for AMLA Report Purposes
            def xTemplate = TxnTemplate.get(Institution.findByParamCode('LNS.50140').paramValue.toInteger())
            def tf = new TxnFile(acctNo:loanInstance.accountNo, loanAcct:loanInstance, currency:loanInstance.product.currency,
                user:UserMaster.get(session.user_id), branch:loanInstance.branch, txnAmt:loanInstance.balanceAmount, txnCode:xTemplate.code, 
                txnDate:Branch.get(1).runDate,txnTimestamp:new Date().toTimestamp(), txnDescription:'Loan GL Link Update',
                status:ConfigItemStatus.get(2), txnType:xTemplate.txnType, txnRef:'Loan Gl Reclassification - Reschedule', 
                txnParticulars:'Loan Gl Reclassification - Reschedule', txnTemplate:xTemplate)
            tf.save(flush:true,failOnError:true)
        
            //create ledger
            def ll = new LoanLedger(loan: loanInstance, txnFile: tf, txnDate: Branch.get(1).runDate, txnTemplate: xTemplate, 
                principalCredit: loanInstance.balanceAmount, principalDebit:loanInstance.balanceAmount, txnRef: tf.txnRef,
                principalBalance: loanInstance.balanceAmount, txnParticulars:'Loan Reschedule')
            ll.save(flush:true, failOnError:true)
        }
         if (params?.activity == "Restructure") {   
        //loanInstance.grantedAmount = origGranted
        //loanInstance.openingDate = origOpen
        loanInstance.status = LoanAcctStatus.read(4)
            def description = loanInstance.accountNo + ' was restructured by ' + UserMaster.get(session.user_id).username
            auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)
			
            // check if nag iba yung gLink
            //callGLClassification or create new function
            println("ACTIVITY: "+params?.activity)
            println("oldLoanGlink: "+oldLoanGlink)
            println("params.glLink.id: "+params.glLink.id)
            
            /*if(oldLoanGlink != params.glLink.id){
                //get reclass loan
                println("RECLASS  UPDATE GL CLASSIFICATION")
                loanInstance.prevGLLink = CfgAcctGlTemplate.get(oldLoanGlink)
                loanInstance.save(flush: true)
                loanService.loanRestructureGLReclass(loanInstance, CfgAcctGlTemplate.get(params.glLink.id), UserMaster.get(session.user_id))
            }*/
            
            //check if existing to table of history
            def jmCheckIfRestructed = LoanRestructureHist.findAllByLoanAndStatus(loanInstance,ConfigItemStatus.get(2))
            if(jmCheckIfRestructed){
                jmCheckIfRestructed.status = ConfigItemStatus.get(3)
                jmCheckIfRestructed.save(flush:true)
            }
            // insert to LoanRestructureHist
            def loanRestructureHistInstance = new LoanRestructureHist(loan:loanInstance,restructuredDate: loanInstance.branch.runDate,
                amount: loanInstance.balanceAmount,status: ConfigItemStatus.get(2),restructuredBy: UserMaster.get(session.user_id),branch: UserMaster.get(session.user_id).branch)
            loanRestructureHistInstance.save(flush:true)	
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Loan.label', default: 'Loan'), loanInstance.id])
                redirect controller:params?.module, action:'show', id:loanInstance?.id 
            }
            '*'{ respond loanInstance, [status: OK] }
        }
    }    

    @Transactional
    def delete(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }

        loanInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Loan.label', default: 'Loan'), loanInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def createSessionData(Loan loanInstance) {
        /*session["installments"] = []
        def installmentType = loanInstance?.interestIncomeScheme?.installmentType.id
        def installmentCalculation = loanInstance?.interestIncomeScheme?.installmentCalcType.id
        if (installmentType == 5 || installmentCalculation == 6) {  // manual            
            // duplicate previous installments
            for(installment in loanInstance.loanInstallments.sort{it.sequenceNo}) {
                def newInstallment = new LoanInstallment(installmentDate: installment.installmentDate, 
                    principalInstallmentAmount: installment.principalInstallmentAmount, 
                    interestInstallmentAmount: installment.interestInstallmentAmount)
                session["installments"].add(newInstallment)
            }
        }*/

        session["installments"] = []
        // duplicate previous installments
        for(installment in loanInstance.loanInstallments.sort{it.sequenceNo}) {
            def newInstallment = new LoanInstallment()
            LoanInstallment.constraints.each() { key, value ->            
                newInstallment."${key}" = installment."${key}"   
            }
            session["installments"].add(newInstallment)
        }

        session["eirSchedules"] = []       
        // duplicate EIR schedules
        for(eirSchedule in loanInstance?.loanEIRSchedules?.sort{it.transferDate}) {
            def newEIRSchedule = new LoanEIRSchedule(transferAmount: eirSchedule.transferAmount, 
                transferDate: eirSchedule.transferDate, uidAmount: eirSchedule.uidAmount)
            session["eirSchedules"].add(newEIRSchedule)
        }     

        session["serviceCharges"] = []
        // duplicate previous service charges
        for(serviceCharge in loanInstance.serviceCharges.sort{it.id}) {
            def newServiceCharge = new ServiceCharge(scheme: serviceCharge.scheme, amount: serviceCharge.amount, 
                rate: serviceCharge.rate)
            session["serviceCharges"].add(newServiceCharge)
        }

        session["deductions"] = []
        // duplicate previous deductions
        for(deduction in loanInstance.loanDeductions.sort{it.id}) {
            def newDeduction = new LoanDeduction(scheme: deduction.scheme, amount: deduction.amount)
            session["deductions"].add(newDeduction)
        }

        session["sweepAccounts"] = []
        // duplicate previous sweep accounts
        for(sweepAccount in loanInstance.sweepAccounts.sort{it.id}) {
            def newSweepAccount = new LoanSweep(depositAccount: sweepAccount.depositAccount, type: sweepAccount.type, 
                rule: sweepAccount.rule, fundLimitAmt: sweepAccount.fundLimitAmt, fundLimitPercentage: sweepAccount.fundLimitPercentage, 
                ordinalNum: sweepAccount.ordinalNum, remarks: sweepAccount.remarks, status: sweepAccount.status, 
                dateCreated: sweepAccount.dateCreated, createdBy: sweepAccount.createdBy)
            session["sweepAccounts"].add(newSweepAccount)
        }
    }

    /*
     * Schemes
     */
    def viewLoanPaymentList(Integer max){
        
        println("================ viewLoanPaymentList =========")
        println("params: "+params)
        def loanInstance = Loan.get(params?.id)
        println("loanInstance: "+loanInstance)
       
        def c = TxnLoanPaymentDetails.createCriteria()
        def loanPayments = c.list {

            eq("acct", loanInstance)
            order("txnDate", "desc")
        }
        println("Loan Payment Transaction Instance")
        [loanInstance:loanInstance,loanPayments:loanPayments]
    
        //=============================
    }
    def showLoanPaymentDetails(){
        println("================ showLoanPaymentDetails =========")
        println("params: "+params)
        def txnLoanPaymentDetailsInstance = TxnLoanPaymentDetails.get(params.id)
        
        def sql = new Sql(dataSource)
        def queryall = "select id from loan_ledger where txn_file_id  = "+txnLoanPaymentDetailsInstance.txnFile.id+" order by id desc limit 1 "
        def resultqueryall = sql.rows(queryall)
        def loanLedgerDetails
        for(x in resultqueryall){
            loanLedgerDetails = LoanLedger.get(x.id.toInteger())
        }
        def loanReversalHist = LoanReversalHist.findByOrigTxnFile(txnLoanPaymentDetailsInstance.txnFile)
        println("loanLedgerDetails: "+loanLedgerDetails)
        [txnLoanPaymentDetailsInstance: txnLoanPaymentDetailsInstance,loanLedgerDetails:loanLedgerDetails,loanReversalHist:loanReversalHist]
    }
    def loanReversePayment(){
        
        def txnLoanPaymentDetailsInstance = TxnLoanPaymentDetails.get(params.loanPaymentDetailId.toInteger())
        def loanInstance = txnLoanPaymentDetailsInstance.acct
        def txnFileInstance = txnLoanPaymentDetailsInstance.txnFile
        
        println("txnLoanPaymentDetailsInstance: "+txnLoanPaymentDetailsInstance)
        println("loanInstance: "+loanInstance)
        println("txnFileInstance: "+txnFileInstance)
        def t = TxnTemplate.get(Institution.findByParamCode("REV.10101").paramValue.toInteger())
        def b = UserMaster.get(session.user_id).branch
        def txnF
        def xOrigTxnFile = txnFileInstance
        def xReversalTxnFile = null
        if (loanInstance.status.id >= 6){
            flash.message = "cannot reverse transactions - Account Closed/ROPA/Write-Off"
            redirect(action: 'show',controller: 'loan',id: loanInstance.id)            
        }
        
        if(txnFileInstance.txnType.id == 16 && txnFileInstance.txnTemplate.memoTxnType.id != 4){
            flash.message = "Cannot reverse back dated Non-Cash transaction (invalid memo transaction type)"
            redirect(action: 'show',controller: 'loan',id: loanInstance.id)
        }
        
        if(txnLoanPaymentDetailsInstance.txnDate == b.runDate){
            println("txnLoanPaymentDetailsInstance.txnDate == b.runDate")
            if(txnFileInstance.txnType.id == 12 || txnFileInstance.txnType.id == 13 || txnFileInstance.txnType.id == 14 || txnFileInstance.txnType.id == 15){
                // cash transactions
                flash.message = "Cannot reverse cash transactions please use Txn Reversal Module"
                redirect(action: 'show',controller: 'loan',id: loanInstance.id)
            }
            
            if(txnFileInstance.txnType.id == 16 && txnFileInstance.txnTemplate.memoTxnType.id == 4){
                println("Loan Non Cash")
                //=============== IF SAME DAY and txn type id is 16 (Loan Non Cash Transactions)
                // Same day loan non cash transaction 
                //update txnfile status to cancelled
                txnFileInstance.status = ConfigItemStatus.get(4)
                txnFileInstance.save(flush: true)
                txnF = txnFileInstance
                xReversalTxnFile = txnFileInstance
            }else{
                flash.message = "Cannot reverse please use Txn Reversal Module"
                redirect(action: 'show',controller: 'loan',id: loanInstance.id)
            }
        }else{
            println("BACK DATING REVERSAL")
            // back dating reversal
            
            // check if origtransaction is Loan check payment 
            if(xOrigTxnFile.txnType.id == 13 || xOrigTxnFile.txnType.id == 15){
                // if check payment use CRETU txn template memo debit return check
                t = TxnTemplate.get(Institution.findByParamCode("LNS.50130").paramValue.toInteger())
            }
            // ================ CREATE TXN FILE REVERSAL ===================
            txnF  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:loanInstance.currency,
                txnAmt:txnFileInstance.txnAmt,txnRef:''+params.txtReference,status:ConfigItemStatus.get(2), branch:loanInstance.branch,
                txnTimestamp: new Date().toTimestamp(),txnParticulars:''+params.txtParticulars,txnType:t.txnType,txnTemplate:t, 
                user:UserMaster.get(session.user_id),loanAcct: loanInstance,acctNo: loanInstance.accountNo)
            txnF.save(flush:true, failOnError:true);
                
            xReversalTxnFile = txnF
            //=============================================================
        }
        
        // ============= LOOP TXN BREAKDOWN LOAN PAYMENT ================
        def txnBreakdownInstance = TxnBreakdown.findAllByTxnFile(txnFileInstance,[sort: "id", order: "desc"])
                                                
        println("txnBreakdownInstance: "+txnBreakdownInstance)
        for(txnB in txnBreakdownInstance){
            
            def newGl = new TxnBreakdown(branch:txnB.branch, creditAcct:txnB.debitAcct, creditAmt:txnB.debitAmt,
                currency:txnB.currency, debitAcct:txnB.creditAcct, debitAmt:txnB.creditAmt, txnCode:txnB.txnCode,
                txnDate:b.runDate, txnFile:txnF, user:UserMaster.get(session.user_id))
            newGl.save(flush:true)
        }
        
        def totalRevesalPrincipalAmt =  0.00D
        def totalRevesalInterestAmt = 0.00D
        def totalRevesalPenaltyAmt = 0.00D
        def totalRevesalServiceChargeAmt = 0.00D

        if(txnLoanPaymentDetailsInstance.principalAmt){
            totalRevesalPrincipalAmt = txnLoanPaymentDetailsInstance.principalAmt
        }
        if(txnLoanPaymentDetailsInstance.interestAmt){
            totalRevesalInterestAmt = txnLoanPaymentDetailsInstance.interestAmt
        }
        if(txnLoanPaymentDetailsInstance.penaltyAmt){
            totalRevesalPenaltyAmt = txnLoanPaymentDetailsInstance.penaltyAmt
        }
        if(txnLoanPaymentDetailsInstance.serviceChargeAmt){
            totalRevesalServiceChargeAmt = txnLoanPaymentDetailsInstance.serviceChargeAmt
        }

        //============ Update Balance of Loan ==========
        loanInstance.balanceAmount += totalRevesalPrincipalAmt
        loanInstance.interestBalanceAmount += totalRevesalInterestAmt
        loanInstance.penaltyBalanceAmount += totalRevesalPenaltyAmt
        loanInstance.lastTransactionNo = txnF.id
        loanInstance.serviceChargeBalanceAmount += totalRevesalServiceChargeAmt
        loanInstance.save(flush: true)
        //==============================================
            
        // ============== CREATE LOAN LEDGER =================
        def loanLedgerEntry = new LoanLedger(loan: loanInstance, txnFile: xOrigTxnFile, 
            txnDate: b.runDate, txnTemplate: t, txnRef: 'TXN-REV-'+params?.txtReference,
            principalDebit: totalRevesalPrincipalAmt, principalBalance: loanInstance.balanceAmount, 
            interestDebit: totalRevesalInterestAmt, interestBalance: loanInstance.interestBalanceAmount, 
            penaltyDebit: totalRevesalPenaltyAmt, penaltyBalance: loanInstance.penaltyBalanceAmount,
            chargesDebit: totalRevesalServiceChargeAmt, chargesBalance: loanInstance.serviceChargeBalanceAmount)
        loanLedgerEntry.save(flush:true,failOnError:true)
        //=====================================================
        
        //============ save to Loan Reversal History
        def LoanReversalHistInstance = new LoanReversalHist(loan:loanInstance,origTxnFile:xOrigTxnFile,
            reverseTxnFile:xReversalTxnFile,isReverse:true,reference:'TXN-REV-'+params?.txtReference,particulars:''+params.txtParticulars)
        LoanReversalHistInstance.save(flush:true)
        
        loanService.updateInstallment(xReversalTxnFile)
        
        flash.message = "Loan Payment Successfully Reversed.. "
        redirect(action:"reversalSuccess",controller: "loan",id:txnF.id)
    }
    def reversalSuccess(){
        println("=============== reversalSuccess =================")
        println("params: "+params)
        flash.message = "Payment Successfully Reversed.. "
        
        def loanLedgerInstance
        
        def sql = new Sql(dataSource)
        def queryall = "select id from loan_ledger where txn_file_id  = "+params.id.toInteger()+" order by id desc limit 1 "
        def resultqueryall = sql.rows(queryall)
        
        for(x in resultqueryall){
            loanLedgerInstance = LoanLedger.get(x.id.toInteger())
        }
        [loanLedgerInstance:loanLedgerInstance]
    }
    
    def getProductSchemesAjax() {
        def loanInstance = null
        if (params?.id) {            
            loanInstance = Loan.get(params.id)
        }

        def product = null
        if (params?.product) {        
            product = Product.get(params.product)            
        } 
        
        render(template:"schemes/schemes", model:[loanInstance: loanInstance, params: params, product: product]) as JSON
        return
    }

    def getProductSchemesAjax2() {
        def loanInstance = null
        if (params?.id) {
            loanInstance = Loan.get(params.id)
        }

        def product = null
        if (params?.product) {
            product = Product.get(params.product)            
        } 
        
        render(template:"schemes/schemes2", model:[loanInstance: loanInstance, params: params, product: product]) as JSON
        return
    }

    def getSchemeDetailsAjax() {
        def interestIncomeScheme = null
        if (params?.interestIncomeScheme) {
            interestIncomeScheme = InterestIncomeScheme.get(params.interestIncomeScheme)
        }

        def penaltyIncomeScheme = null
        if (params?.penaltyIncomeScheme) {
            penaltyIncomeScheme = PenaltyIncomeScheme.get(params.penaltyIncomeScheme)
        }

        /*def amortizedChargeScheme = null
        if (params?.amortizedChargeScheme) {
            amortizedChargeScheme = AmortizedChargeScheme.get(params.amortizedChargeScheme)
        }*/

        render(template:"schemes/schemeDetails", model:[interestIncomeScheme: interestIncomeScheme, 
            penaltyIncomeScheme: penaltyIncomeScheme]) as JSON
        return
    }    

    def getAmortizedChargeSchemeInfoAjax() {
        def amortizedChargeScheme

        if (params.id) {
            amortizedChargeScheme = AmortizedChargeScheme.get(params.id)
        } else {
            amortizedChargeScheme = null
        }

        render(template:"serviceCharges/amortizedChargeSchemeInfo", model:[amortizedChargeScheme: amortizedChargeScheme]) as JSON
        return
    }     

    def getDeductionSchemeInfoAjax() {
        def deductionScheme

        if (params.id) {
            deductionScheme = LoanDeductionScheme.get(params.id)
        } else {
            deductionScheme = null
        }

        render(template:"deductions/deductionSchemeInfo", model:[deductionScheme: deductionScheme]) as JSON
        return
    }     


    /*
     * Loan Application
     */

    def showLoanApplicationAjax() {
         println("pasok dito agad 1")
         def comakers
        def loanApplicationInstance = null
            //println("   loanAppId: "+loanApplicationInstance)
        println("loan aplication id: in params: "+params?.id)    
        if (params?.id) {
            loanApplicationInstance = LoanApplication.get(params?.id)
            if(loanApplicationInstance == null){
                println("null yung loan application id...")
            }else{
               //def coMakers
               comakers = LoanApplicationComaker.findAllByLoanApplication(loanApplicationInstance)
               println("comakers: "+comakers)
               //coMakers = comakers
               //def aStudent = [name: "Student1"]
               //session["coMakers"] = comakers
               //println("Scomakers: "+session["coMakers"])
            }
  
        }

        render(template:"loanApplication/show", model:[loanApplicationInstance:loanApplicationInstance,comakers:comakers]) as JSON
        return
    }

    /*
     * Service Charges
     */

    def showServiceChargesAjax() {
        render(template:"serviceCharges/list") as JSON
        return
    }

    def showAddServiceChargeAjax() {
        def product = Product.get(params?.product)

        render(template:"serviceCharges/form", model:[product:product]) as JSON
        return
    }

    def addServiceChargeAjax() {         
        def scheme = AmortizedChargeScheme.get(params?.scheme)
        def product = Product.get(params?.product)
        def amount

        def hasErrors = false
        
        def serviceCharge
        if (scheme?.type?.id == 2) {  // rate
            def grantedAmount = (params?.grantedAmount.replaceAll(",","")).toDouble()
            def rate = params?.rate ? (params?.rate.replaceAll(",","")).toDouble() : null
            def numInstallments = params?.numInstallments ? params?.numInstallments?.toInteger() : 0

            if (grantedAmount > 0 && numInstallments > 0 && rate != null) {
                amount = ((grantedAmount * rate * 0.01) / numInstallments).round(2)
            } else {
                amount = 0
            }            

            serviceCharge = new ServiceCharge(scheme:scheme, amount:amount, rate:params?.rate)

            if (session["serviceCharges"]?.size > 0 && session["serviceCharges"]?.find{it?.scheme?.id == scheme?.id} != null) {
                serviceCharge.errors.rejectValue("scheme", "serviceCharge.scheme.used")
                hasErrors = true
            }

            if (!rate) {
                serviceCharge.errors.rejectValue("rate", "serviceCharge.rate.null")
                hasErrors = true
            }            
        } else {
            
             if (params?.amount  == '')
                {
                 amount = params?.amount 
                }
             else
                {
                 amount = params?.amount.toDouble()
                }
            if (amount == '')
                {
            def message = 'Amount Value cannot be null !'
            render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge]) as JSON
            return
                }    
          
             if (amount < 0)
                 {
            def message = 'Amount Value cannot be negative !'
            render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge]) as JSON
            return
             }
            

            serviceCharge = new ServiceCharge(scheme:scheme, amount:amount, rate:0)

            if (session["serviceCharges"]?.size > 0 && session["serviceCharges"]?.find{it?.scheme?.id == scheme?.id} != null) {
                serviceCharge.errors.rejectValue("scheme", "serviceCharge.scheme.used")
                hasErrors = true
            }

            if (!amount) {
                serviceCharge.errors.rejectValue("amount", "serviceCharge.amount.null")
                hasErrors = true
            }            
        }        

        if (hasErrors) {
            render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge]) as JSON
            return
        }

        def serviceCharges
        if (session["serviceCharges"]) {
            serviceCharges = session["serviceCharges"]
        } else {
            serviceCharges = []
        } 
        serviceCharges.add(serviceCharge)
        session["serviceCharges"] = serviceCharges

        def message = "Service charge successfully added"
        render(template:"serviceCharges/form", model:[product:product, message:message]) as JSON

        return
    }

    def showUpdateServiceChargeAjax() {        
        def id = params?.id?.toInteger()
        def product = Product.get(params?.product)

        def serviceCharges = session["serviceCharges"]        
        def serviceCharge = serviceCharges[id]

        render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge]) as JSON
        return
    }

    def updateServiceChargeAjax() {   
        def id = params?.id?.toInteger()
        def scheme = AmortizedChargeScheme.get(params?.scheme)
        def product = Product.get(params?.product)
        def amount
        def rate

        def hasErrors = false

        def serviceCharge
        def serviceCharges = session["serviceCharges"]
        def tempServiceCharge
        if (scheme?.type?.id == 2) {  // rate            
            def grantedAmount = (params?.grantedAmount.replaceAll(",","")).toDouble()            
            def numInstallments = params?.numInstallments ? params?.numInstallments?.toInteger() : 0
            rate = params?.rate ? (params?.rate.replaceAll(",","")).toDouble() : null

            if (grantedAmount > 0 && numInstallments > 0 && rate != null) {
                amount = ((grantedAmount * rate * 0.01) / numInstallments).round(2)
            } else {
                amount = 0
            }

            tempServiceCharge = new ServiceCharge(scheme:scheme, amount:amount, rate:rate)
            
            for(int i = 0; i < serviceCharges?.size(); i++) {
                if (i != id && serviceCharges[i].scheme.id == scheme.id) {
                    tempServiceCharge.errors.rejectValue("scheme", "serviceCharge.scheme.used")
                    hasErrors = true
                }
            }

            if (!rate) {
                tempServiceCharge.errors.rejectValue("rate", "serviceCharge.rate.null")
                hasErrors = true
            }
        } else {
            amount = params?.amount ? (params?.amount.replaceAll(",","")).toDouble() : null
            rate = 0
            
            tempServiceCharge = new ServiceCharge(scheme:scheme, amount:amount, rate:0)
            if (amount == '')
                     {
                    def message = 'Amount Value cannot be null !'
                    render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge]) as JSON
                    return
                    }    
          
                    if (amount < 0)
                    {
                     def message = 'Amount Value cannot be negative !'
                     render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge]) as JSON
                    return
                    }
            for(int i = 0; i < serviceCharges?.size(); i++) {
                if (i != id && serviceCharges[i].scheme.id == scheme.id) {
                    tempServiceCharge.errors.rejectValue("scheme", "serviceCharge.scheme.used")
                    hasErrors = true
                }
            }

            if (!amount) {
                tempServiceCharge.errors.rejectValue("amount", "serviceCharge.amount.null")
                hasErrors = true
            }              
        }

        if (hasErrors) {
            render(template:"serviceCharges/form", model:[product:product, serviceCharge:tempServiceCharge]) as JSON
            return
        }

        serviceCharge = serviceCharges[id]
        serviceCharge.scheme = scheme
        serviceCharge.amount = amount
        serviceCharge.rate = rate

        def message = "Service charge successfully updated"
        render(template:"serviceCharges/form", model:[product:product, serviceCharge:serviceCharge, message:message]) as JSON

        return
    }

    def deleteServiceChargeAjax() {
        def id = params?.id?.toInteger()
        session["serviceCharges"].remove(id)

        render "success"
        return
    }

    /*
     * Deductions
     */

    def showDeductionsAjax() {
        render(template:"deductions/list") as JSON
        return
    }

    def showAddDeductionAjax() {
        def product = Product.get(params?.product)

        render(template:"deductions/form", model:[product:product]) as JSON
        return
    }

    def addDeductionAjax() {
        println("params: "+params)
        params?.amount = params?.amount ? (params?.amount.replaceAll(",","")): null
        println("params: "+params?.value)
        def scheme = LoanDeductionScheme.get(params?.scheme)
        def product = Product.get(params?.product)
        def amount
        
      
        def hasErrors = false

        def deduction
        if (scheme?.type?.id == 2) {  // rate
            def grantedAmount = (params?.grantedAmount.replaceAll(",","")).toDouble()
            def rate = params?.rate ? (params?.rate.replaceAll(",","")).toDouble() : null
           
            if (grantedAmount > 0 && rate != null) {
                amount = (grantedAmount * rate * 0.01).round(2)
            } else {
                amount = 0
            }

            deduction = new LoanDeduction(scheme:scheme, amount:amount, rate:rate)

            if (session["deductions"]?.size > 0 && session["deductions"]?.find{it?.scheme?.id == scheme?.id} != null) {
                deduction.errors.rejectValue("scheme", "loanDeduction.scheme.used")
                hasErrors = true
            }

            if (!rate) {
                deduction.errors.rejectValue("rate", "loanDeduction.rate.null")
                hasErrors = true
            }            
        } else if (scheme?.type?.id == 3) {
            // DST Computation
            def grantedAmount = (params?.grantedAmount.replaceAll(",","")).toDouble()
            def rate = params?.rate ? (params?.rate.replaceAll(",","")).toDouble() : null
           
            if (grantedAmount > 0 ) {
                amount = grantedAmount* 0.005
                amount = amount.round(2)    
            } else {
                amount = 0
            }

            deduction = new LoanDeduction(scheme:scheme, amount:amount, rate:rate)

            if (session["deductions"]?.size > 0 && session["deductions"]?.find{it?.scheme?.id == scheme?.id} != null) {
                deduction.errors.rejectValue("scheme", "loanDeduction.scheme.used")
                hasErrors = true
            }

            if (!amount) {
                deduction.errors.rejectValue("amount", "loanDeduction.amount.invalid")
                hasErrors = true
            }              
        } else if (scheme?.type?.id == 6) {
          // fire insurance special calculation
            def grantedAmount = (params?.grantedAmount.replaceAll(",","")).toDouble()
            def rate = params?.rate ? (params?.rate.replaceAll(",","")).toDouble() : null
           
            if (grantedAmount > 100000 ) {
                amount = grantedAmount* 0.002
                amount = amount.round(2)    
            } else {
                amount = 120
            }

            deduction = new LoanDeduction(scheme:scheme, amount:amount, rate:rate)

            if (session["deductions"]?.size > 0 && session["deductions"]?.find{it?.scheme?.id == scheme?.id} != null) {
                deduction.errors.rejectValue("scheme", "loanDeduction.scheme.used")
                hasErrors = true
            }

            if (!amount) {
                deduction.errors.rejectValue("amount", "loanDeduction.amount.invalid")
                hasErrors = true
            }          
        } else {
            if (params?.amount  == '')
                {
                 amount = params?.amount 
                }
             else
                {
                 amount = params?.amount.toDouble()
                }
            if (amount == '')
                {
            def message = 'Amount Value cannot be null !'
            render(template:"deductions/form" , model:[product:product, message:message]) as JSON
            return
                }    
          
             if (amount < 0)
                 {
            def message = 'Amount Value cannot be negative !'
            render(template:"deductions/form" , model:[product:product, message:message]) as JSON
            return
             }
           

            deduction = new LoanDeduction(scheme:scheme, amount:amount, rate:0)

            if (session["deductions"]?.size > 0 && session["deductions"]?.find{it?.scheme?.id == scheme?.id} != null) {
                deduction.errors.rejectValue("scheme", "loanDeduction.scheme.used")
                hasErrors = true
            }

            if (!amount) {
                deduction.errors.rejectValue("amount", "loanDeduction.amount.null")
                hasErrors = true                
            }  
        
        }        

        if (hasErrors) {
            render(template:"deductions/form", model:[product:product, deduction:deduction]) as JSON
            return
        }

        def deductions
      
        if (session["deductions"]) {
            deductions = session["deductions"]
        } else {
            deductions = []
        }  
            
        deductions.add(deduction)
        session["deductions"] = deductions
    
        def message = "Deduction successfully added"
        render(template:"deductions/form", model:[product:product, message:message]) as JSON

        return
    }

    def showUpdateDeductionAjax() {        
        def id = params?.id?.toInteger()
        def product = Product.get(params?.product)

        def deductions = session["deductions"]        
        def deduction = deductions[id]

        render(template:"deductions/form", model:[product:product, deduction:deduction]) as JSON
        return
    }

    def updateDeductionAjax() {   
        def id = params?.id?.toInteger()
        def scheme = LoanDeductionScheme.get(params?.scheme)
        def product = Product.get(params?.product)
        def amount
        def rate

        def hasErrors = false

        def deduction
        def deductions = session["deductions"]      
        def tempDeduction  
        if (scheme?.type?.id == 2) {  // rate
            def grantedAmount = (params?.grantedAmount.replaceAll(",","")).toDouble()            
            rate = params?.rate ? (params?.rate.replaceAll(",","")).toDouble() : null

            if (grantedAmount > 0 && rate != null) {
                amount = (grantedAmount * rate * 0.01).round(2)
            } else {
                amount = 0
            }

            tempDeduction = new LoanDeduction(scheme:scheme, amount:amount, rate:rate)

            for(int i = 0; i < deductions?.size(); i++) {
                if (i != id && deductions[i].scheme.id == scheme.id) {
                    tempDeduction.errors.rejectValue("scheme", "loanDeduction.scheme.used")
                    hasErrors = true
                }
            }

            if (!rate) {
                tempDeduction.errors.rejectValue("rate", "loanDeduction.rate.null")
                hasErrors = true
            } 
        } else {
            amount = params?.amount ? (params?.amount.replaceAll(",","")).toDouble() : null
            rate = 0
    
            tempDeduction = new LoanDeduction(scheme:scheme, amount:amount, rate:0)
                    if (amount == '')
                     {
                    def message = 'Amount Value cannot be null !'
                    render(template:"deductions/form" , model:[product:product, deduction:deduction, message:message]) as JSON
                    return
                    }    
          
                    if (amount < 0)
                    {
                     def message = 'Amount Value cannot be negative !'
                     render(template:"deductions/form" , model:[product:product, deduction:deduction, message:message]) as JSON
                    return
                    }
            
            
            
            
            for(int i = 0; i < deductions?.size(); i++) {
                if (i != id && deductions[i].scheme.id == scheme.id) {
                    tempDeduction.errors.rejectValue("scheme", "loanDeduction.scheme.used")
                    hasErrors = true
                }
            }

            if (!amount) {
                tempDeduction.errors.rejectValue("amount", "loanDeduction.amount.null")                
                hasErrors = true
            }                  
        }        

        if (hasErrors) {
            render(template:"deductions/form", model:[product:product, deduction:tempDeduction]) as JSON
            return
        }

        deduction = deductions[id]
        deduction.scheme = scheme
        deduction.amount = amount
        deduction.rate = rate

        def message = "Deduction successfully updated"
        render(template:"deductions/form", model:[product:product, deduction:deduction, message:message]) as JSON

        return
    }

    def deleteDeductionAjax() {
        def id = params?.id?.toInteger()
        session["deductions"].remove(id)

        render "success"
        return
    }    

    /*
     * Sweep
     */

    def showDepositAccountInfo() {
        def depositAccount

        if (params.id) {
            depositAccount = Deposit.get(params.id)
        } else {
            depositAccount = null
        }

        render(template:"sweep/depositInfo", model:[depositAccount: depositAccount]) as JSON
        return
    }

    def showSweepAccountsAjax() {
        render(template:"sweep/list") as JSON
        return
    }

    def showAddSweepAccountAjax() {
        render(template:"sweep/form") as JSON
        return
    }

    def addSweepAccountAjax() { 
        println '----- sweep -----'
        println params
        def depositAccount = Deposit.get(params?.deposit)
        def type = SweepType.get(params?.type)
        def rule = SweepRule.get(params?.rule)
        def fundLimitAmt  
        def fundLimitPercentage = params?.fundLimitPercentage
        def ordinalNum = params?.ordinalNum ? params?.ordinalNum?.toInteger() : null
        def remarks = params?.remarks
        
        

         
        
//       
//        if (depositAccount == null)
//        {
//            def message = 'Deposit Account cannot be null !'
//            render(template:"sweep/form" , model:[message:message]) as JSON
//            return
//        }
        
        if (rule == SweepRule.get(3))
        { 
            println 'angels' 
            
             if (params?.fundLimitAmt  == '')
                {
                 fundLimitAmt = params?.fundLimitAmt 
                }
             else
                {
                 fundLimitAmt = params?.fundLimitAmt.toDouble()
                }
                         if (fundLimitAmt == '')
                         {
                          def message = 'Fixed Amount cannot be null if Rule is Fixed Amount!'
                          render(template:"sweep/form" , model:[message:message]) as JSON
                            return
                         }
                         if (fundLimitAmt < 0 )
                         {
                          def message = 'Fixed Amount cannot be negative'
                          render(template:"sweep/form" , model:[message:message]) as JSON
                            return
                         }
        }
        
         if (ordinalNum == null)
        {
            def message = 'Ordinal Number cannot be null !'
            render(template:"sweep/form" , model:[message:message]) as JSON
            return
        }

        def sweepAccount = new LoanSweep(depositAccount:depositAccount, type:type, rule:rule, fundLimitAmt:fundLimitAmt,
            fundLimitPercentage:fundLimitPercentage, ordinalNum:ordinalNum, remarks:remarks)

        def hasErrors = false

        if (!depositAccount) {
            sweepAccount.errors.rejectValue("depositAccount", "sweep.depositAccount.null")
            hasErrors = true
        } else if (session["sweepAccounts"]?.size > 0 && session["sweepAccounts"]?.find{it?.depositAccount?.id == depositAccount?.id} != null) {
            sweepAccount.errors.rejectValue("depositAccount", "sweep.depositAccount.used")
            hasErrors = true
        }

        if (rule?.id == 3 && !fundLimitAmt) {
            sweepAccount.errors.rejectValue("fundLimitAmt", "sweep.fundLimitAmt.null")
            hasErrors = true
        }

        if (rule?.id == 4 && !fundLimitPercentage) {
            sweepAccount.errors.rejectValue("fundLimitPercentage", "sweep.fundLimitPercentage.null")
            hasErrors = true
        }

        if (ordinalNum == null) {
            sweepAccount.errors.rejectValue("ordinalNum", "sweep.ordinalNum.null")
            hasErrors = true
        } else if (session["sweepAccounts"]?.size > 0 && session["sweepAccounts"]?.find{it?.ordinalNum == ordinalNum} != null) {
            sweepAccount.errors.rejectValue("ordinalNum", "sweep.ordinalNum.notUnique")
            hasErrors = true
        }

        if (hasErrors) {
            render(template:"sweep/form", model:[sweepAccount:sweepAccount]) as JSON
            return
        }       

        sweepAccount.status = SweepStatus.get(2)
        sweepAccount.createdBy = UserMaster.get(session.user_id)  
        sweepAccount.dateCreated = new Date()

        def sweepAccounts
        if (session["sweepAccounts"]) {
            sweepAccounts = session["sweepAccounts"]
        } else {
            sweepAccounts = []
        }        
        sweepAccounts.add(sweepAccount)
        session["sweepAccounts"] = sweepAccounts
        
        if(session["pageAction"]=="edit"){
            def loanididid = Loan.get(params?.loanidvalue).id
            // saving first the LoanSweep object
            sweepAccount.save(flush:true)
            // retrieving the last id for the last save
            def sql = new Sql(dataSource)
            def queryall = "select id from loan_sweep order by id desc limit 1"
            def resultqueryall = sql.rows(queryall)
            // insert loan_id and the last of the LoanSweep id
            def insertQuery = "insert into loan_loan_sweep (loan_sweep_accounts_id,loan_sweep_id) values (${loanididid},${LoanSweep.get(resultqueryall.id[0].toInteger()).id})"
            def resultInsert = sql.execute(insertQuery) 
        }

        def message = "Sweep account successfully added"
        render(template:"sweep/form", model:[message:message]) as JSON

        return
    }

    def showUpdateSweepAccountAjax() {
        session["sweepposition"]=""
        def id = params?.id?.toInteger()
        def posArray = params?.posArray?.toInteger()
        def sweepAccounts = session["sweepAccounts"]
        def sweepAccount = sweepAccounts[posArray]
        session["sweepposition"]= params?.posArray
        render(template:"sweep/form", model:[sweepAccount:sweepAccount]) as JSON
        return
    }

    def updateSweepAccountAjax() {   
        def id = params?.id?.toInteger()
        def posArray = params?.posArray?.toInteger()													
        def depositAccount = Deposit.get(params?.deposit)
        def type = SweepType.get(params?.type)
        def rule = SweepRule.get(params?.rule)
        def fundLimitAmt = params?.fundLimitAmt ? (params?.fundLimitAmt.replaceAll(",","")).toDouble() : null
        def fundLimitPercentage = params?.fundLimitPercentage ? (params?.fundLimitPercentage.replaceAll(",","")).toDouble() : null
        def ordinalNum = params?.ordinalNum ? params?.ordinalNum?.toInteger() : null
        def remarks = params?.remarks

        def tempSweepAccount = new LoanSweep(depositAccount:depositAccount, type:type, rule:rule, fundLimitAmt:fundLimitAmt,
            fundLimitPercentage:fundLimitPercentage, ordinalNum:ordinalNum, remarks:remarks)
                 if (rule == SweepRule.get(3))
        { 
         
            
             if (params?.fundLimitAmt  == '')
                {
                 fundLimitAmt = params?.fundLimitAmt 
                }
             else
                {
                 fundLimitAmt = params?.fundLimitAmt.toDouble()
                }
                         if (fundLimitAmt == '')
                         {
                          def message = 'Fixed Amount cannot be null if Rule is Fixed Amount!'
                          render(template:"sweep/form" , model:[message:message]) as JSON
                            return
                         }
                         if (fundLimitAmt < 0 )
                         {
                          def message = 'Fixed Amount cannot be negative'
                          render(template:"sweep/form" , model:[message:message]) as JSON
                            return
                         }
        }
        def hasErrors = false

        if (!depositAccount) {
            tempSweepAccount.errors.rejectValue("depositAccount", "sweep.depositAccount.null")
            hasErrors = true
        } else {
            def sweepAccounts = session["sweepAccounts"]
            for(int i = 0; i < sweepAccounts?.size(); i++) {
                if (i != posArray && sweepAccounts[i].depositAccount == depositAccount) {
                    tempSweepAccount.errors.rejectValue("depositAccount", "sweep.depositAccount.used")
                    hasErrors = true
                }
            }            
        }

        if (rule?.id == 3 && !fundLimitAmt) {
            tempSweepAccount.errors.rejectValue("fundLimitAmt", "sweep.fundLimitAmt.null")
            hasErrors = true
        }

        if (rule?.id == 4 && !fundLimitPercentage) {
            tempSweepAccount.errors.rejectValue("fundLimitPercentage", "sweep.fundLimitPercentage.null")
            hasErrors = true
        }

        if (ordinalNum == null) {
            tempSweepAccount.errors.rejectValue("ordinalNum", "sweep.ordinalNum.null")
            hasErrors = true
        } else {
            def sweepAccounts = session["sweepAccounts"]
            for(int i = 0; i < sweepAccounts?.size(); i++) {
                if (i != posArray && sweepAccounts[i].ordinalNum == ordinalNum) {
                    tempSweepAccount.errors.rejectValue("ordinalNum", "sweep.ordinalNum.notUnique")
                    hasErrors = true
                }
            }
        }

        if (hasErrors) {
            render(template:"sweep/form", model:[sweepAccount:tempSweepAccount]) as JSON
            return
        }    

        def sweepAccounts = session["sweepAccounts"]        
        def sweepAccount = sweepAccounts[posArray]

        sweepAccount.depositAccount = depositAccount
        sweepAccount.type = type
        sweepAccount.rule = rule
        sweepAccount.fundLimitAmt = fundLimitAmt
        sweepAccount.fundLimitPercentage = fundLimitPercentage
        sweepAccount.ordinalNum = ordinalNum
        sweepAccount.remarks = remarks
        println("================================================================="+session["pageAction"])
        if(session["pageAction"]=="edit"){
            println("depositAccount: "+depositAccount)
            println("type: "+type)
            println("rule: "+rule)
            println("fundLimitAmt: "+fundLimitAmt)
            println("fundLimitPercentage: "+fundLimitPercentage)
            println("ordinalNum: "+ordinalNum)
            println("remarks: "+remarks)
            
            def loanSweepInstance = LoanSweep.get(id)
                loanSweepInstance.depositAccount = depositAccount
                loanSweepInstance.type = type
                loanSweepInstance.rule = rule
                loanSweepInstance.fundLimitAmt = fundLimitAmt
                loanSweepInstance.fundLimitPercentage = fundLimitPercentage
                loanSweepInstance.ordinalNum = ordinalNum
                loanSweepInstance.remarks = remarks
                loanSweepInstance.save(flush:true)
            
        }
        def message = "Sweep account successfully updated"
        render(template:"sweep/form", model:[sweepAccount:sweepAccount, message:message]) as JSON

        return
    }

    def deleteSweepAccountAjax() {
        def id = params?.id?.toInteger()
        def posArray = params?.posArray?.toInteger()
        println("deletesweep loanid: "+session["loanidvalue"].toInteger())
        if(session["pageAction"]=="edit"){
            def sql = new Sql(dataSource)
            //def queryall = "delete from loan_loan_sweep where loan_sweep_id = ${id} and loan_sweep_accounts_id = ${session["loanidvalue"].toInteger()}"
            def queryall="delete from loan_loan_sweep where loan_sweep_id = "+id+"and loan_sweep_accounts_id = "+session["loanidvalue"].toInteger()
            def resultqueryall = sql.execute(queryall)
            if(!resultqueryall){
                println("pasok sa ifffffffffffffff")
                 def queryall1 = "delete from loan_sweep where id ="+id
                
                def resultqueryall1 = sql.execute(queryall1)
            }else{
                println("pasok sa else")
            }
        }
        session["sweepAccounts"].remove(posArray)

        render "success"
        return
    }      

    /*
     * Manual Loan Installments
     */

    def showInstallmentsAjax() {
        def thepassedvalue = params?.onffvalue
        println("the parameter passed onoffvalue: "+thepassedvalue)
      
        render(template:"installments/list", model: [onoffplugvalue: thepassedvalue]) as JSON
        return
    }     

    def showAddInstallmentAjax() {    
        render(template:"installments/form") as JSON
        return
    }

    def addInstallmentAjax() {    
        def date = params?.date
        def principal = params?.principal
        def interest = params?.interest
        def serviceCharge = params?.serviceCharge ? (params?.serviceCharge.replaceAll(",","")).toDouble() : null
        println "value " + params
        def installment = new LoanInstallment(installmentDate:date, principalInstallmentAmount:principal, interestInstallmentAmount:interest, serviceChargeInstallmentAmount:serviceCharge)

        def hasErrors = false

        if (!date) {
            installment.errors.rejectValue("installmentDate", "loanInstallment.installmentDate.null")
            hasErrors = true
        } else {
            def laterDate = true;
            for(def i = 0; i < session["installments"].size(); i++) {
                if (installment.installmentDate <= session["installments"].get(i).installmentDate) {
                    laterDate = false;
                }
            }

            if (!laterDate) {
                installment.errors.rejectValue("installmentDate", "loanInstallment.installmentDate.incorrect")    
                hasErrors = true
            }
        }
        
        if (!principal) {
            installment.errors.rejectValue("principalInstallmentAmount", "loanInstallment.principal.null")
            hasErrors = true
        }

        if (!interest) {
            installment.errors.rejectValue("interestInstallmentAmount", "loanInstallment.interest.null")
            hasErrors = true
        }

        if (hasErrors) {
            render(template:"installments/form", model:[installment:installment]) as JSON
            return
        } 

        def installments
        if (session["installments"]) {
            installments = session["installments"]
        } else {
            installments = []
        }        
        installments.add(installment)
        session["installments"] = installments

        def add = "true"
        def message = "Installment successfully added"
        session["onffvalue"]="addbtn";	  
        render(template:"installments/form", model:[add:add, message:message]) as JSON

        return
    }

    def showUpdateInstallmentAjax() {   
        def id = params?.id?.toInteger()
        
        def installments = session["installments"]        
        def installment = installments[id]

        render(template:"installments/form", model:[installment:installment]) as JSON
        return
    }

    def updateInstallmentAjax() {    
        def id = params?.id?.toInteger()
        def date = params?.date ? new Date().parse("MM/dd/yyyy", params?.date) : null
        def principal = params?.principal ? (params?.principal.replaceAll(",","")).toDouble() : null
        def interest = params?.interest ? (params?.interest.replaceAll(",","")).toDouble() : null
        def serviceCharge = params?.serviceCharge ? (params?.serviceCharge.replaceAll(",","")).toDouble() : null
        def tempInstallment = new LoanInstallment(installmentDate:date, principalInstallmentAmount:principal, 
            interestInstallmentAmount:interest,serviceChargeInstallmentAmount:serviceCharge)

        def hasErrors = false

        if (!date) {
            tempInstallment.errors.rejectValue("installmentDate", "loanInstallment.installmentDate.null")
            hasErrors = true
        } else {
            def laterDate = true;
            for(def i = 0; i < id; i++) {
                if (tempInstallment.installmentDate <= session["installments"].get(i).installmentDate) {
                    laterDate = false;
                }
            }

            if (!laterDate) {
                tempInstallment.errors.rejectValue("installmentDate", "loanInstallment.installmentDate.incorrect")    
                hasErrors = true
            }
        }

        if (!principal) {
            tempInstallment.errors.rejectValue("principalInstallmentAmount", "loanInstallment.principal.null")
            hasErrors = true
        }

        if (!interest) {
            //tempInstallment.errors.rejectValue("interestInstallmentAmount", "loanInstallment.interest.null")
            //hasErrors = true
            interest = 0.0
        }

        if (hasErrors) {
            render(template:"installments/form", model:[installment:tempInstallment]) as JSON
            return
        }   

        def installments = session["installments"]        
        def installment = installments[id]

        installment.installmentDate = date
        installment.principalInstallmentAmount = principal
        installment.interestInstallmentAmount = interest
        installment.serviceChargeInstallmentAmount = serviceCharge

        def message = "Installment successfully updated"
        render(template:"installments/form", model:[installment:installment, message:message]) as JSON

        return
    }

    def deleteInstallmentAjax() {
        def id = params?.id?.toInteger()
        session["installments"].remove(id)

        render "success"
        return
    }

    /*
     * History
     */

    def createLoanHistoryEntry(Loan loanInstance) {
        def loanHistory = new LoanHistory()
        session["loanHistory"] = []
        println("loanInstance ==============================================: "+loanInstance.id)
        // copy details from loan account        

        Loan.constraints.each() { key, value ->            
            if (key != "loanInstallments" && key != "serviceCharges" && 
                key != "loanDeductions" && key != "sweepAccounts") {                                
                loanHistory."${key}" = loanInstance."${key}"
            }
        }
        session["loanHistory"].add(loanHistory)    

        // duplicate service charges
        session["newServiceCharges"] = []       
        for(serviceCharge in loanInstance?.serviceCharges) {
            def newServiceCharge = new ServiceCharge()
            ServiceCharge.constraints.each() { key, value ->            
                newServiceCharge."${key}" = serviceCharge."${key}"   
            }
            session["newServiceCharges"].add(newServiceCharge)            
        }

        // duplicate deductions
        session["newDeductions"] = []       
        for(deduction in loanInstance?.loanDeductions) {
            def newDeduction = new LoanDeduction()
            LoanDeduction.constraints.each() { key, value ->            
                newDeduction."${key}" = deduction."${key}"   
            }
            session["newDeductions"].add(newDeduction)
        }

        // duplicate installments
        session["newInstallments"] = []       
        for(installment in loanInstance?.loanInstallments) {
            def newInstallment = new LoanInstallment()
            LoanInstallment.constraints.each() { key, value ->            
                newInstallment."${key}" = installment."${key}"   
            }
            session["newInstallments"].add(newInstallment)
        }        

        // duplicate EIR schedules
        session["newEIRSchedules"] = []       
        for(eirSchedule in loanInstance?.loanEIRSchedules) {
            def newEIRSchedule = new LoanEIRSchedule()
            LoanEIRSchedule.constraints.each() { key, value ->            
                newEIRSchedule."${key}" = eirSchedule."${key}"   
            }
            session["newEIRSchedules"].add(newEIRSchedule)
        } 

        // duplicate sweep accounts
        session["newSweepAccounts"] = []       
        for(sweepAccount in loanInstance?.sweepAccounts) {
            println '--->' + sweepAccount
            def newSweepAccount = new LoanSweep()
            LoanSweep.constraints.each() { key, value ->            
                newSweepAccount."${key}" = sweepAccount."${key}"   
            }
            println '----->' + newSweepAccount
            session["newSweepAccounts"].add(newSweepAccount)
        }       
    }

    def clearLoanData(Loan loanInstance) {
        loanInstance.serviceCharges.clear()
        loanInstance.loanDeductions.clear()
        loanInstance.loanInstallments.clear()
        loanInstance.loanEIRSchedules.clear()
        loanInstance.sweepAccounts.clear()
        //loanInstance.save flush:true 
    }

    def showHistory() {
        println("=======  SHOW HISTORY ============")
        if (params?.id && params?.history) {
            println("PASOK HERE SA PARAMS ID AND HISTORY")
            def origLoanInstance = Loan.get(params.id)
            def loanInstance = LoanHistory.get(params.history)
            println("origLoanInstance: "+origLoanInstance)
            println("loanInstance: "+loanInstance)
            def totalDeductions = 0
            for(loanDeduction in loanInstance?.loanDeductions) {
                totalDeductions += loanDeduction?.amount
            }
            
            respond loanInstance, model: [loanInstance: loanInstance, origLoanInstance: origLoanInstance,
                loanApplicationInstance: loanInstance.loanApplication, totalDeductions: totalDeductions]
           
        } else {
            notFound()
            return
        }
    }     

    /*
     * Repricing
     */

    def showUpdateInterestRateAjax() {
        def loanInstance = Loan.get(params?.id)

        render(template:"interestRate/form", model:[loanInstance:loanInstance]) as JSON
        return
    }

    @Transactional
    def updateInterestRateAjax() {
        def loanInstance = Loan.get(params.id)
        
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)

        def interestRate = params?.interestRate ? (params?.interestRate.replaceAll(",","")).toDouble() : null
        if (!interestRate) {
            loanInstance.errors.rejectValue("interestRate", "loan.interestRate.null")

            render(template:"interestRate/form", model:[loanInstance:loanInstance]) as JSON    
            return        
        }        
        
        loanService.commitLoanHistoryEntry("Repricing")
        clearLoanData(loanInstance)
        
        loanService.updateInterestRate(loanInstance, interestRate)
        
        def description = loanInstance.accountNo + ' interest rate was updated by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)

        def message = "Interest rate successfully updated"
        render(template:"interestRate/form", model:[loanInstance:loanInstance, message:message]) as JSON

        return
    }    

    /*
     * Interest Accrual
     */

    @Transactional
    def startInterestAccrual(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }

        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)

        loanService.commitLoanHistoryEntry("Start Interest Accrual")
        clearLoanData(loanInstance)

        loanService.updateInterestAccrual(loanInstance, true)
        
        def description = loanInstance.accountNo + ' accrued interest start was started by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)

        request.withFormat {
            form multipartForm {
                flash.message = "Interest accrual started"
                //redirect loanInstance
                redirect controller:params?.module, action: 'show', id: loanInstance.id
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Transactional
    def stopInterestAccrual(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }

        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)

        loanService.commitLoanHistoryEntry("Stop Interest Accrual")
        clearLoanData(loanInstance)
        
        loanService.updateInterestAccrual(loanInstance, false)
        def description = loanInstance.accountNo + ' interest accrual was stopped by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)

        request.withFormat {
            form multipartForm {
                flash.message = "Interest accrual stopped"
                //redirect loanInstance
                redirect controller:params?.module, action: 'show', id: loanInstance.id
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    def loanWriteOffCollectionList(){
        println("============ loanWriteOffCollectionList ============")
        println("params: "+params)
        
        def c = LoanWriteOffCollectionHist.createCriteria()
        def loanWriteOffCollectionInstance = c.list {
            and {
                eq("loan", Loan.get(params.id))
            }
            
            order("id", "asc")
        }
        [loanWriteOffCollectionInstance:loanWriteOffCollectionInstance]
    }
    def writeOffCollectionDetails(){
        println("========== writeOffCollectionDetails ===========")
        println("params: "+params)
        def collectionInstance = LoanWriteOffCollectionHist.get(params.id)
        [collectionInstance:collectionInstance]
    }
    
    
    def approved(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }
        def aln = Loan.get(loanInstance.id)
        if (aln.status.id > 2) {
            flash.message = "Account Details Already approved"
            //redirect loanInstance
            redirect controller:params?.module, action: 'show', id: loanInstance.id 
            return
        }
        
         def coll 
         coll = loanInstance.loanApplication.collaterals
         println "====>" + coll.size()
         for (co in coll)
         {
           println "1. " + co.collateralType.id
           if (co.collateralType.id == 3)  
           {
                def amount
                println "deposit " + Deposit.findByAcctNo(co.holdout.accountNo).availableBalAmt
                println "loan " + loanInstance.grantedAmount 
                def depositInstance = Deposit.findByAcctNo(co.holdout.accountNo)
                if(depositInstance.availableBalAmt <= loanInstance.grantedAmount)
                {
                    amount = depositInstance.availableBalAmt
                    
                }
                else
                {
                    amount = loanInstance.grantedAmount                    
                }
                //def depositInstance = Deposit.findByAcctNo(co.holdout.accountNo)
                def number = Deposit.findByAcctNo(co.holdout.accountNo)
               
                def holdInstance = new Hold()
                holdInstance.amt = amount
                holdInstance.holdDate = Branch.get(1).runDate
                holdInstance.maturityDate = loanInstance.maturityDate
                holdInstance.remarks = 'Auto Posting of Hold Out Collateral'
                holdInstance.status = HoldStatus.get(2)
                holdInstance.type = HoldType.get(1)
                number.addToHolds(holdInstance).save(flush: true) 
              
                number.availableBalAmt -= amount 
                number.holdBalAmt += amount
                number.save(flush:true, failOnError:true)
              
                //def dep = Deposit.findByAcctNo(co.holdout.accountNo)
                //number.availableBalAmt -= amount 
                //number.holdBalAmt += amount
                //number.save(flush:true, failOnError:true)
                println '+++++++++++++++++++++++++++'
                println number.acctNo
                println number.availableBalAmt
                println number.holdBalAmt
                println number.errors
                println '+++++++++++++++++++++++++++'              
           }
         }

        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)
        loanInstance?.hasInterestAccrual = true
        loanInstance?.dateApproved = loanInstance?.branch?.runDate
        loanInstance?.approvedBy = UserMaster.get(session.user_id)
        loanInstance.save(flush:true)
       
        loanService.commitLoanHistoryEntry("Update Status to " + LoanAcctStatus.get(3).description)
        clearLoanData(loanInstance)
        loanService.updateStatus(loanInstance, LoanAcctStatus.get(3))
        loanService.updateOpeningBal(loanInstance, LoanAcctStatus.get(3))
            def message = "Status successfully updated"
            def x = Institution.findByParamCode('LNS.50074').paramValue.toInteger()
            def branch = Branch.get(loanInstance.branchId)    
            def txnFileInstance = new TxnFile()
            loanInstance.grantedAmount = loanInstance.grantedAmount.round(2)
            loanInstance.totalNetProceeds = loanInstance.totalNetProceeds.round(2)
            def amount = loanInstance.grantedAmount - loanInstance.totalNetProceeds
            amount = amount.round(2)
            def deduct = amount - loanInstance.advInterest
            deduct = deduct.round(2)
            txnFileInstance.acctNo = loanInstance.accountNo
            txnFileInstance.loanAcct = loanInstance
            txnFileInstance.currency = Currency.get(loanInstance.product.currencyId)
            txnFileInstance.user = UserMaster.get(session.user_id)
            txnFileInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
            txnFileInstance.txnAmt = amount


            txnFileInstance.txnCode = TxnTemplate.get(x).code
            txnFileInstance.txnDate = branch.runDate
            txnFileInstance.txnTimestamp = new Date().toTimestamp()
            txnFileInstance.txnDescription = TxnTemplate.get(x).codeDescription
            txnFileInstance.status = ConfigItemStatus.get(2)
            txnFileInstance.txnType = TxnTemplate.get(x).txnType
            txnFileInstance.txnRef = params.txnReference.toString()
            txnFileInstance.txnParticulars = params.txnParticulars.toString()
            txnFileInstance.save(flush:true,failOnError:true)




            glTransactionService.saveTxnBreakdown(txnFileInstance.id)
            def loanLedgerEntry = new LoanLedger(loan: loanInstance, txnFile: txnFileInstance, 
                txnDate: branch.runDate, txnTemplate: TxnTemplate.get(x), interestCredit: loanInstance.advInterest, 
                interestDebit:loanInstance.advInterest, chargesCredit:deduct ,chargesDebit:deduct, 
                txnRef: txnFileInstance.txnRef,principalBalance: loanInstance.balanceAmount)
            loanLedgerEntry.save(flush:true,failOnError:true)
            
            // handling of loan renewal pay-off to old loan
            println '+++' + loanInstance
            def lnRenew = LoanRenewal.findAllByNewLoanAndRenewalCompleted(loanInstance,false, [max: 1, sort: "id", order: "asc"])
            if (lnRenew) {
                for (l in lnRenew) {
                    // debit new loan for total due
                    def oldLoan = l.oldLoan
                    def debitTxn = TxnTemplate.get(Institution.findByParamCode('LNS.50081').paramValue.toInteger())   // should be changed later to parameter
                    def totAmtToClose = oldLoan.balanceAmount + oldLoan.interestBalanceAmount + oldLoan.penaltyBalanceAmount + oldLoan.serviceChargeBalanceAmount
                    // create debit txnFile
                    def debitTf = new TxnFile(acctNo:loanInstance.accountNo, branch:loanInstance.branch, 
                        currency:loanInstance.product.currency, loanAcct:loanInstance, status:ConfigItemStatus.get(2), 
                        txnAmt:totAmtToClose, txnCode:debitTxn.code, 
                        txnDate:loanInstance.branch.runDate, txnDescription:'Renewal payout',
                        txnParticulars: 'Renewal payout to ' + oldLoan.accountNo, txnRef:'Renewal :' + oldLoan.accountNo,
                        txnTemplate:debitTxn, txnTimestamp: new Date().toTimestamp(), txnType:debitTxn.txnType,
                        user:UserMaster.get(session.user_id))
                    debitTf.save(flush:true)
                    def debitLd = new LoanLedger(loan:loanInstance, principalDebit:totAmtToClose, txnCode:debitTxn.code,
                        principalBalance:loanInstance.balanceAmount + totAmtToClose, txnDate:loanInstance.branch.runDate,
                        txnFile:debitTf, txnParticulars:'Renewal payout to ' + oldLoan.accountNo,
                        txnRef:'Renewal :' + oldLoan.accountNo, txnTemplate:debitTxn)
                    debitLd.save(flush:true)
                    glTransactionService.saveTxnBreakdown(debitTf.id)
                    
                    loanInstance.balanceAmount += totAmtToClose
                    loanInstance.totalDisbursementAmount += totAmtToClose
                    // credit payment to old loan
                    def creditTxn = TxnTemplate.get(Institution.findByParamCode('LNS.50082').paramValue.toInteger())   // should be changed later to parameter
                    def creditTf = new TxnFile(acctNo:oldLoan.accountNo, branch:loanInstance.branch, 
                        currency:oldLoan.product.currency, loanAcct:oldLoan, status:ConfigItemStatus.get(2), 
                        txnAmt:totAmtToClose, txnCode:creditTxn.code, 
                        txnDate:oldLoan.branch.runDate, txnDescription:'Renewal payment',
                        txnParticulars: 'Renewal payment from ' + loanInstance.accountNo, 
                        txnRef:'Renewal :' + loanInstance.accountNo,
                        txnTemplate:creditTxn, txnTimestamp: new Date().toTimestamp(), txnType:creditTxn.txnType,
                        user:UserMaster.get(session.user_id))
                    creditTf.save(flush:true)
                    def creditLd = new LoanLedger(loan:oldLoan, txnCode:debitTxn.code,
                        chargesBalance:0, chargesCredit:oldLoan.serviceChargeBalanceAmount, 
                        chargesDebit: oldLoan.serviceChargeBalanceAmount, 
                        interestBalance:0, interestCredit:oldLoan.interestBalanceAmount, 
                        interestDebit:oldLoan.interestBalanceAmount,
                        penaltyBalance:0, penaltyCredit: oldLoan.penaltyBalanceAmount,
                        penaltyDebit:oldLoan.penaltyBalanceAmount,
                        principalBalance:0, principalCredit: oldLoan.balanceAmount,
                        txnDate:loanInstance.branch.runDate,
                        txnFile:creditTf, txnParticulars:'Renewal payment from ' + loanInstance.accountNo,
                        txnRef:'Renewal:' + loanInstance.accountNo, txnTemplate:creditTxn)
                    creditLd.save(flush:true)   
                    // loan payment details
                    def txnLoanPaymentDetailsInstance = new TxnLoanPaymentDetails(acct:oldLoan,
                        acctNo:oldLoan.accountNo, balForwarded:oldLoan.balanceAmount,
                        branch:oldLoan.branch, currency:oldLoan.product.currency,
                        interestAmt:oldLoan.interestBalanceAmount, interestBalAfterPayment:0,
                        paymentAmt:totAmtToClose, penaltyAmt:oldLoan.penaltyBalanceAmount,
                        penaltyBalAfterPayment:0, principalAmt:oldLoan.balanceAmount, principalBalAfterPayment:0,
                        serviceChargeAmt:oldLoan.serviceChargeBalanceAmount,
                        totalNetProceeds:0, txnDate:oldLoan.branch.runDate,txnFile:creditTf,
                        txnRef:'Renewal:' + loanInstance.accountNo, user:UserMaster.get(session.user_id)) 
                    txnLoanPaymentDetailsInstance.save(flush:true,failOnError:true)
                    glTransactionService.saveTxnBreakdown(creditTf.id)
                    
                    // close old loan
                    oldLoan.status = LoanAcctStatus.get(6)
                    oldLoan.balanceAmount = 0
                    oldLoan.interestBalanceAmount = 0
                    oldLoan.penaltyBalanceAmount = 0
                    oldLoan.serviceChargeBalanceAmount = 0
                    oldLoan.save(flush:true)
                    // save renewal
                    l.renewalCompleted = true
                    l.save(flush:true)
                }
            }
            
            request.withFormat {
                form multipartForm {
                    flash.message = "Approve Success"
                    //redirect loanInstance
                    redirect controller:params?.module, action: 'show', id: loanInstance.id
                }
                '*'{ render status: NO_CONTENT }
            }
											
		 
 
    } 
    
    /*
     * Branch
     */

    def showUpdateBranchAjax() {
        def loanInstance = Loan.get(params.id)
        
        render(template:"branch/form", model:[loanInstance:loanInstance]) as JSON
        return
    }

    @Transactional
    def updateBranchAjax() {
        println params
        def loanInstance = Loan.get(params.id)
        
        if (loanInstance.branch.id == params.branch.id) {
            def message = "ERROR: Same branch selected"
            render(template:"branch/form", model:[loanInstance:loanInstance, message:message]) as JSON
            return
        }
        
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)

        loanService.commitLoanHistoryEntry("Branch Transfer")
        clearLoanData(loanInstance)

        loanService.updateBranch(loanInstance, Branch.get(params.branch.id), params.particulars, params.reference, UserMaster.get(session.user_id))
        println params.branch.id
        def description = loanInstance.accountNo + ' branch was updated by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)
        def message = "Branch successfully updated"
        render(template:"branch/form", model:[loanInstance:loanInstance, message:message]) as JSON

        return
    }
    /*
     * Status
     */

     def viewRopa(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def txnRopaInstance = new TxnRopaDetails()
            render(view:'ropa/view', model: [loanInstance:loanInstance, txnRopaInstance:txnRopaInstance])
        }else{
            notFound()
        }  
    }
    
     def viewWriteOff(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            render(view:"writeOff/view",model:[loanInstance:loanInstance])
        }else{
            notFound()
        }  
    }


def reopen(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            render(view:"status/reopen",model:[loanInstance:loanInstance])
        }else{
            notFound()
        }         
    }
    
    @Transactional
    def saveReopen(Loan loanInstance){
        createLoanHistoryEntry(loanInstance)
        
        clearLoanData(loanInstance)
        if (loanInstance.maturityDate < loanInstance.branch.runDate) {
            loanInstance.status = LoanAcctStatus.read(5)
        } else {
            loanInstance.status = LoanAcctStatus.read(4)
        }
        loanService.commitLoanHistoryEntry('Reopen Closed Loan')
        loanInstance.save(flush:true)
        
        def description = loanInstance.accountNo + ' was re-opened by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)

       request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Loan.label', default: 'Loan'), loanInstance.id])
                redirect controller:params?.module, action:'show', id:loanInstance?.id 
            }
            '*'{ respond loanInstance, [status: OK] }
        }        


    }  
	
	


    def showUpdateStatusAjax() {
        def loanInstance = Loan.get(params.id)
        
        render(template:"status/form1", model:[loanInstance:loanInstance, save:'save']) as JSON
        return
    }
        def showUpdateStatAjax() {
        def loanInstance = Loan.get(params.id)
        
        render(template:"status/form", model:[loanInstance:loanInstance]) as JSON
        return
    }

//    @Transactional
//    //loan aproval instead we use approve function
//    def updateStatusAjax() {
//        def loanInstance = Loan.get(params.id)
//        createLoanHistoryEntry(loanInstance)
//        createSessionData(loanInstance)
//        def stats = LoanAcctStatus.get(params.status.id).id
//        loanInstance?.hasInterestAccrual = true
//        loanInstance.save(flush:true)
//        loanService.commitLoanHistoryEntry("Update Status to " + LoanAcctStatus.get(params.status.id).description)
//        clearLoanData(loanInstance)
//        loanService.updateStatus(loanInstance, LoanAcctStatus.get(params.status.id))
//        if (stats == 3){
//        loanService.updateOpeningBal(loanInstance, LoanAcctStatus.get(params.status.id))
//        def message = "Status successfully updated"
//            def x = Institution.findByParamCode('LNS.50074').paramValue.toInteger()
//            def branch = Branch.get(loanInstance.branchId)    
//            def txnFileInstance = new TxnFile()
//            def amount = loanInstance.grantedAmount - loanInstance.totalNetProceeds
//            def deduct = amount - loanInstance.advInterest
//            txnFileInstance.acctNo = loanInstance.accountNo
//            txnFileInstance.loanAcct = loanInstance
//            txnFileInstance.currency = Currency.get(loanInstance.product.currencyId)
//            txnFileInstance.user = UserMaster.get(session.user_id)
//            txnFileInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
//            txnFileInstance.txnAmt = amount
//            txnFileInstance.txnCode = TxnTemplate.get(x).code
//            txnFileInstance.txnDate = branch.runDate
//            txnFileInstance.txnTimestamp = new Date().toTimestamp()
//            txnFileInstance.txnDescription = TxnTemplate.get(x).codeDescription
//            txnFileInstance.status = ConfigItemStatus.get(2)
//            txnFileInstance.txnType = TxnTemplate.get(x).txnType
//            txnFileInstance.txnRef = 'Loan Deduction'
//            txnFileInstance.save(flush:true,failOnError:true)
//            glTransactionService.saveTxnBreakdown(txnFileInstance.id)
//            def loanLedgerEntry = new LoanLedger(loan: loanInstance, txnFile: txnFileInstance, txnDate: branch.runDate, txnTemplate: TxnTemplate.get(x), interestCredit: loanInstance.advInterest, interestDebit:loanInstance.advInterest, chargesCredtit:deduct ,chargesDebit:deduct , txnRef: txnFileInstance.txnRef,principalBalance: loanInstance.balanceAmount)
//            loanLedgerEntry.save(flush:true,failOnError:true)
//        render(template:"status/form1", model:[loanInstance:loanInstance, message:message, save:'save']) as JSON
//        return
//        }
//        
//        else{
//        def message = "Status successfully updated"
//        render(template:"status/form1", model:[loanInstance:loanInstance, message:message, save:'save']) as JSON
//
//        return
//    }
//    }

        def showUpdateCloseStatusAjax() {
        def loanInstance = Loan.get(params.id)
        
        render(template:"status/form2", model:[loanInstance:loanInstance]) as JSON
        return
    }

    @Transactional
    def updateCloseStatusAjax() {
        def loanInstance = Loan.get(params.id)
        println params
        println loanInstance
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)
        def stats = LoanAcctStatus.get(params.status.id).id

        loanService.commitLoanHistoryEntry("Update Status to " + LoanAcctStatus.get(params.status.id).description)
        clearLoanData(loanInstance)

        loanService.updateStatus(loanInstance, LoanAcctStatus.get(params.status.id))
        def message = "Status successfully updated"
        def description = loanInstance.accountNo + ' was Terminated by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('100', 'LON01100', description, 'Loan', null, null, null, loanInstance.id)
        
        render(template:"status/form2", model:[loanInstance:loanInstance, message:message]) as JSON

        return
 
    }

    @Transactional
 
    def updateStatAjax() {
        def loanInstance = Loan.get(params.id)
        println params
        println loanInstance
        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)
        def stats = LoanAcctStatus.get(params.status.id).id
        loanService.commitLoanHistoryEntry("Update Status to " + LoanAcctStatus.get(params.status.id).description)
        clearLoanData(loanInstance)
        loanService.updateStatus(loanInstance, LoanAcctStatus.get(params.status.id))
        if (stats == 3){
        loanService.updateOpeningBal(loanInstance, LoanAcctStatus.get(params.status.id))
        def message = "Status successfully updated"
        render(template:"status/form", model:[loanInstance:loanInstance, message:message]) as JSON
        return
        }
        else{
        def message = "Status successfully updated"
        render(template:"status/form", model:[loanInstance:loanInstance, message:message]) as JSON
        return
    }
    }
    @Transactional
    def terminate(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }

        loanInstance.statusChangedDate = loanInstance.branch.runDate
        loanInstance.status = LoanAcctStatus.get(6)
        loanInstance.save flush:true
        def description = loanInstance.accountNo + ' was Terminated by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('100', 'LON01100', description, 'Loan', null, null, null, loanInstance.id)
        
       request.withFormat {
            form multipartForm {
                flash.message = "Loan " + loanInstance.id + " terminated"
                redirect controller:"loanTermination", action:'show', id:loanInstance?.id 
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    
    def transferR(Loan loanInstance, TxnRopaDetails txnRopaInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }
        println 'transferR start---------------------------'
        println params
        println txnRopaInstance
        println 'transferR end  ---------------------------'
        
        createLoanHistoryEntry(loanInstance)
        def balance = loanInstance.balanceAmount
        loanInstance.status = LoanAcctStatus.get(7)
        def amount = balance  
        def credit = loanInstance.balanceAmount - balance
        loanInstance.balanceAmount = credit
                
        def branch = Branch.get(loanInstance.branchId)    
        def txnFileInstance = new TxnFile()
        txnFileInstance.acctNo = loanInstance.accountNo
        txnFileInstance.loanAcct = loanInstance
        txnFileInstance.currency = Currency.get(loanInstance.product.currencyId)
        txnFileInstance.user = UserMaster.get(session.user_id)
        txnFileInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
        txnFileInstance.txnAmt = balance
        txnFileInstance.txnCode = TxnTemplate.get(79).code
        txnFileInstance.txnDate = branch.runDate
        txnFileInstance.txnTimestamp = new Date().toTimestamp()
        txnFileInstance.txnDescription = TxnTemplate.get(79).codeDescription
        txnFileInstance.status = ConfigItemStatus.get(2)
        txnFileInstance.txnType = TxnTemplate.get(79).txnType
        txnFileInstance.txnParticulars = loanInstance.accountNo + ' Loans Transfer to ROPA'
        txnFileInstance.txnRef = 'Loans Transfer to ROPA'
        txnFileInstance.save(flush:true,failOnError:true)
            
        def txnLoanPaymentDetailsInstance = new TxnLoanPaymentDetails() 
        txnLoanPaymentDetailsInstance.acct = loanInstance 
        txnLoanPaymentDetailsInstance.acctNo = loanInstance.accountNo  
        txnLoanPaymentDetailsInstance.balForwarded = balance
        txnLoanPaymentDetailsInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
        txnLoanPaymentDetailsInstance.currency = Currency.get(loanInstance?.product?.currencyId)
        txnLoanPaymentDetailsInstance.interestAmt = 0
        txnLoanPaymentDetailsInstance.interestBalAfterPayment = 0
        txnLoanPaymentDetailsInstance.paymentAmt = 0
        txnLoanPaymentDetailsInstance.penaltyAmt = 0
        txnLoanPaymentDetailsInstance.penaltyBalAfterPayment = 0
        txnLoanPaymentDetailsInstance.principalAmt = amount
        txnLoanPaymentDetailsInstance.principalBalAfterPayment = loanInstance?.balanceAmount
        txnLoanPaymentDetailsInstance.serviceChargeAmt = 0
        txnLoanPaymentDetailsInstance.totalNetProceeds = loanInstance?.totalNetProceeds
        txnLoanPaymentDetailsInstance.txnDate = branch.runDate
        txnLoanPaymentDetailsInstance.txnFile = txnFileInstance 
        txnLoanPaymentDetailsInstance.txnRef = 'loan transfer to ROPA'
        txnLoanPaymentDetailsInstance.user = UserMaster.get(session.user_id)
        txnLoanPaymentDetailsInstance.save(flush:true,failOnError:true)
        glTransactionService.saveTxnBreakdown(txnFileInstance.id)
            
        def loanLedgerEntry = new LoanLedger(loan: loanInstance, txnFile: txnFileInstance, txnDate: branch.runDate, txnTemplate: TxnTemplate.get(79), txnRef: txnFileInstance.txnRef,principalCredit: amount ,principalBalance: loanInstance.balanceAmount)
                loanLedgerEntry.save(flush:true,failOnError:true)
                
        loanService.commitLoanHistoryEntry("Transfer to ROPA" )
        loanInstance.save flush:true
        /*
        def txnRopaDetails = new TxnRopaDetails(txnFile:txnFileInstance, 
            modeOfForeclosure:txnRopaInstance.modeOfForeclosure, dateBooked:txnRopaInstance.dateBooked,
            dateAcquired:txnRopaInstance.dateAcquired, dateRegistered:txnRopaInstance.dateAcquired,
            dateNotarized:txnRopaInstance.dateNotarized, dateConsolidated:txnRopaInstance.dateNotarized,
            expiryOfRedemption:txnRopaInstance.expiryOfRedemption, particulars:txnRopaInstance.particulars)
        txnRopaDetails.save(flush:true)
       */
       request.withFormat {
            form multipartForm {
                flash.message = "Loan " + loanInstance.id + " TRANSFER TO ROPA "
                 session["transactionFileId"] = txnFileInstance.id.toInteger()
                 redirect(controller: "tellering", action: "txnSuccess")
            }
            '*'{ render status: NO_CONTENT }
        }
    }
       

        

  def transferW(Loan loanInstance) {
            
        if (loanInstance == null) {
            notFound()
            return
        }
        println 'WRITE-OFF'
        println params
        def txnWrt = TxnTemplate.get(params.txnTemplate.toInteger())
        def loanTranWrtPointer = TxnTemplate.get(Institution.findByParamCode('LNS.50140').paramValue.toInteger())
        createLoanHistoryEntry(loanInstance)
        def balance = loanInstance.balanceAmount
        def amount = balance - 1
        loanInstance.status = LoanAcctStatus.get(8)
        def credit = loanInstance.balanceAmount - (balance - 1)
        loanInstance.balanceAmount = credit
        def branch = Branch.get(loanInstance.branchId)    
        def txnFileInstance = new TxnFile()
            txnFileInstance.acctNo = loanInstance.accountNo
            txnFileInstance.loanAcct = loanInstance
            txnFileInstance.currency = Currency.get(loanInstance.product.currencyId)
            txnFileInstance.user = UserMaster.get(session.user_id)
            txnFileInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
            txnFileInstance.txnAmt = amount
            txnFileInstance.txnCode = loanTranWrtPointer.code
            txnFileInstance.txnDate = branch.runDate
            txnFileInstance.txnTimestamp = new Date().toTimestamp()
            txnFileInstance.txnDescription = loanTranWrtPointer.codeDescription
            txnFileInstance.status = ConfigItemStatus.get(2)
            txnFileInstance.txnType = loanTranWrtPointer.txnType
            txnFileInstance.txnRef = 'Loans Transfer to Write Off'
            txnFileInstance.txnParticulars = loanInstance.accountNo + ' Loans Transfer to Write Off'
            
			txnFileInstance.save(flush:true,failOnError:true)
         
        def txnLoanPaymentDetailsInstance = new TxnLoanPaymentDetails() 
            txnLoanPaymentDetailsInstance.acct = loanInstance 
            txnLoanPaymentDetailsInstance.acctNo = loanInstance.accountNo  
            txnLoanPaymentDetailsInstance.balForwarded = balance
            txnLoanPaymentDetailsInstance.branch = Branch.get(UserMaster.get(session.user_id).branchId)
            txnLoanPaymentDetailsInstance.currency = Currency.get(loanInstance?.product?.currencyId)
            txnLoanPaymentDetailsInstance.interestAmt = 0
            txnLoanPaymentDetailsInstance.interestBalAfterPayment = 0
            txnLoanPaymentDetailsInstance.paymentAmt = 0
            txnLoanPaymentDetailsInstance.penaltyAmt = 0
            txnLoanPaymentDetailsInstance.penaltyBalAfterPayment = 0
            txnLoanPaymentDetailsInstance.principalAmt = amount
            txnLoanPaymentDetailsInstance.principalBalAfterPayment = loanInstance?.balanceAmount
            txnLoanPaymentDetailsInstance.serviceChargeAmt = 0
            txnLoanPaymentDetailsInstance.totalNetProceeds = loanInstance?.totalNetProceeds
            txnLoanPaymentDetailsInstance.txnDate = branch.runDate
            txnLoanPaymentDetailsInstance.txnFile = txnFileInstance 
            txnLoanPaymentDetailsInstance.txnRef = 'Loans Transfer to Write Off'
            txnLoanPaymentDetailsInstance.user = UserMaster.get(session.user_id)
            txnLoanPaymentDetailsInstance.save(flush:true,failOnError:true)
            glTransactionService.saveTxnBreakdown(txnFileInstance.id)
            def loanLedgerEntry = new LoanLedger(loan: loanInstance, txnFile: txnFileInstance, txnDate: branch.runDate, 
                txnTemplate: loanTranWrtPointer, txnRef: txnFileInstance.txnRef,principalCredit: amount,
                principalBalance: loanInstance.balanceAmount)
            loanLedgerEntry.save(flush:true,failOnError:true)
                
                loanService.commitLoanHistoryEntry("Transfer to Write off ")
                loanInstance.save flush:true
           
       request.withFormat {
            form multipartForm {
                flash.message = "Loan " + loanInstance.id + " TRANSFER TO WRITE OFF "
                 session["transactionFileId"] = txnFileInstance.id.toInteger()
                 redirect(controller: "tellering", action: "txnSuccess")
            }
            '*'{ render status: NO_CONTENT }
        }
    }


    
    

         
        



    /*@Transactional
    def writeOff(Loan loanInstance) {
        if (loanInstance == null) {
            notFound()
            return
        }

        loanInstance.status = LoanAcctStatus.get(7)
        loanInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Loan " + loanInstance.id + " written off"
                redirect controller:"loanWriteOff", action:'show', id:loanInstance?.id 
            }
            '*'{ render status: NO_CONTENT }
        }
    }*/

    @Transactional
    def transferToROPA() {
        def loanInstance = Loan.get(params.id)

        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)

        loanService.commitLoanHistoryEntry("ROPA")
        clearLoanData(loanInstance)

        loanService.ropa(loanInstance)

        request.withFormat {
            form multipartForm {
                flash.message = "Loan " + loanInstance.id + " transfered to ROPA"
                redirect controller:"loanROPA", action:'show', id:loanInstance?.id 
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    /*
     * GL Classification
     */

     def showUpdateGLClassificationAjax() {
        def loanInstance = Loan.get(params.id)
        
        render(template:"gl/form", model:[loanInstance:loanInstance]) as JSON
        return
    }

    @Transactional
    def updateGLClassificationAjax() {
        def loanInstance = Loan.get(params.id)

        createLoanHistoryEntry(loanInstance)
        createSessionData(loanInstance)

        loanService.commitLoanHistoryEntry("Update GL Classification")
        clearLoanData(loanInstance)

        loanService.updateGLClassification(loanInstance, CfgAcctGlTemplate.get(params.glLink.id), UserMaster.get(session.user_id))

        def message = "GL classification successfully updated"
        render(template:"gl/form", model:[loanInstance:loanInstance, message:message]) as JSON

        return
    }

    /*
     * Special
     */

    def showSpecial(Loan loanInstance) {
        respond loanInstance
    }

    def editSpecial(Loan loanInstance) {
        respond loanInstance
    }

    @Transactional
    def updateSpecial(Loan loanInstance) {
        def type = LoanSpecialType.get(params?.type.id)
        def action = params?.specialAction?.trim() 
        def transferDate = params?.transferDate ? new Date().parse("MM/dd/yyyy", params?.transferDate) : null
        if (loanInstance.special) {
            loanInstance.special.type = type
            loanInstance.special.action = action
            loanInstance.special.transferDate = transferDate
        } else {
            def special = new LoanSpecial(type: type, action: action, transferDate: transferDate)
            special.save flush:true    

            loanInstance.special = special
        }            
        loanInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Loan.label', default: 'Loan'), loanInstance.id])
                redirect action: 'showSpecial', id: loanInstance.id
                //redirect loanInstance
            }
            '*'{ respond loanInstance, [status: OK] }
        }
    }

    /*
     * Litigation
     */

    def litigation(Loan loanInstance) {
        params.max = Math.min(params?.max?.toInteger() ?: 10, 100)

        if (params.offset == null) {
            params.offset = 0
        }

        if (params.sort == null) {
            params.sort = "id"
        }
        
        def litigationExpenses = loanInstance?.special?.litigationExpenses
        def litigationDeficiencies = loanInstance?.special?.litigationDeficiencies
        
        respond loanInstance, model:[litigationExpenses:litigationExpenses, litigationDeficiencies:litigationDeficiencies]
        return
    }

    @Transactional
    def saveLitigationExpense(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def litigationExpense = new LitigationExpense(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToLitigationExpenses(litigationExpense);
        loanInstance.save flush:true

        /*params.remove("save")
        params.remove("glAccount")
        params.remove("glAccount.id")        
        params.remove("type")
        params.remove("type.id")
        params.remove("amount")*/

        redirect action: 'litigation', id: loanInstance.id
        return
    }

    @Transactional
    def saveLitigationDeficiency(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def litigationDeficiency = new LitigationDeficiency(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToLitigationDeficiencies(litigationDeficiency);
        loanInstance.save flush:true      

        redirect action: 'litigation', id: loanInstance.id
        return
    }

    /*
     * ROPA
     */

    def ropa(Loan loanInstance) {            
        respond loanInstance
        return
    }

    @Transactional
    def saveROPAExpense(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def ropaExpense = new ROPAExpense(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToRopaExpenses(ropaExpense);
        loanInstance.save flush:true
        
        redirect action: 'ropa', id: loanInstance.id
        return
    }

    @Transactional
    def saveROPAExpenseAdjustment(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def ropaExpenseAdjustment = new ROPAExpenseAdjustment(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToRopaExpenseAdjustments(ropaExpenseAdjustment);
        loanInstance.save flush:true
        
        redirect action: 'ropa', id: loanInstance.id
        return
    }

    @Transactional
    def saveROPAExpenseCapitalization(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def ropaExpenseCapitalization = new ROPAExpenseCapitalization(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToRopaExpenseCapitalizations(ropaExpenseCapitalization);
        loanInstance.save flush:true
        
        redirect action: 'ropa', id: loanInstance.id
        return
    }

    @Transactional
    def saveROPAExpenseCapitalizationAdjustment(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def ropaExpenseCapitalizationAdjustment = new ROPAExpenseCapitalizationAdjustment(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToRopaExpenseCapitalizationAdjustments(ropaExpenseCapitalizationAdjustment);
        loanInstance.save flush:true
        
        redirect action: 'ropa', id: loanInstance.id
        return
    }

    @Transactional
    def saveROPASellOff(Loan loanInstance) {        
        def glAccount = GlAccount.get(params?.glAccount.id)        
        def type = TxnType.get(params?.type.id)        
        def amount = params?.amount?.toDouble() ?: 0

        def ropaSellOff = new ROPASellOff(glAccount: glAccount, type: type, amount: amount)
        loanInstance.special.addToRopaSellOffs(ropaSellOff);
        loanInstance.save flush:true
        
        redirect action: 'ropa', id: loanInstance.id
        return
    }

    /*
     * Reports
     */

    def reports() {
        render (view:'reports/view')
    }

    def generateReport() {
        if (params.type == "1") {
            params._name = "Loan Listing"
            params._file = "loan_listing"

            //def loans = Loan.list(fetch:[customer:"eager"])

            def loanListing = []
            for(loan in Loan.list()) {
                def entry = new LoanListingEntry()
                entry.accountNo = loan?.accountNo
                entry.customerName = loan?.customer?.displayName

                entry.customerAddress = ""
                def primaryAddress = loan?.customer?.addresses?.find{it.isPrimary==true}                
                if (primaryAddress) 
                    entry.customerAddress = primaryAddress?.address1 + ', ' + primaryAddress?.address2 +', ' +primaryAddress?.address3

                entry.dateGranted = loan?.openingDate.format("MM/dd/yyyy")
                entry.maturityDate = loan?.maturityDate.format("MM/dd/yyyy")
                entry.balanceAmount = loan?.balanceAmount

                entry.uid = loan?.advInterest ?: 0
                entry.interestRate = loan?.interestRate
                entry.frequency = loan?.frequency?.description
                entry.lastTransactionDate = loan?.lastTransactionDate?.format("MM/dd/yyyy") ?: ""
                /*entry.principalAmount = 0
                entry.interestAmount = 0
                entry.amortizationAmount = 0
                entry.product = ""
                entry.status = ""*/

                loanListing.add(entry)
            }

            chain(controller:'jasper',action:'index',model:[data:loanListing], params:params)
        } else {
            //render (view:'reports/view')
            redirect action: 'reports'
        }
    }
        

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'loan.label', default: 'Loan'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
        protected void statusPending() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.approval', args: [message(code: 'loan.label', default: 'Loan'), params.id])
                redirect action: "index", method: "GET"
                flash.warning = ' angelo'
           
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // start of my coding JM CODES HERE================================================== JM CODES HERE ==============

    def showImportInstallmentAjax() {    
        render(template:"installments/formupload") as JSON
        return
    }
   
   // addInstallmentAjax
    def importInstallmentss(){
        
        def installmaent_date
        def principal_amt
        def interest_value
        def service_charge
        int counter=0;
        int validateTitleExcelTitleHeader =0
        println("from ajax value :"+params)
        session["installments"]="";
        session["onffvalue"]="";
        
         MultipartFile file = request.getFile( 'file' )
        file.inputStream.eachCsvLine { row ->
            
             installmaent_date = row[0]?: "NA";
             principal_amt = row[1]?: "0.00";
             interest_value = row[2]?: "0.00";
             service_charge = row[3]?: "0.00";
             
            if(validateTitleExcelTitleHeader==0){
                validateTitleExcelTitleHeader=1
            }else{
                
                println("======== CSV PER LINE ===============")
                println("Installment Date: "+installmaent_date);
                println("Principal Amount: "+principal_amt);
                println("Interest Amount: "+interest_value);
                println("Service Charge: "+service_charge);
                println("=====================================")
                println("")
        
                //println("params id: "+params.id);
               
               def date = installmaent_date? new Date().parse("MM/dd/yyyy", installmaent_date) : null
               def principal = principal_amt ? (principal_amt.replaceAll(",","")).toDouble() : null
               def interest = interest_value ? (interest_value.replaceAll(",","")).toDouble() : null
               def serviceCharge = service_charge ? (service_charge.replaceAll(",","")).toDouble() : null

              // def serviceChargeddd = service_charge.toDouble()
               def installment = new LoanInstallment(installmentDate:date, principalInstallmentAmount:principal, interestInstallmentAmount:interest, serviceChargeInstallmentAmount:serviceCharge)

                def hasErrors = false
              def installments
               if (session["installments"]) {
                   
                   installments = session["installments"]
               } else {
                   
                   installments = []
               } 
               installments.add(installment)
               session["installments"] = installments             

               if (!date) {
                   installment.errors.rejectValue("installmentDate", "loanInstallment.installmentDate.null")
                   hasErrors = true
                } else {
                   def laterDate = true;
                   for(def i = 0; i < session["installments"].size(); i++) {
                        if (installment.installmentDate <= session["installments"].get(i).installmentDate) {
                           laterDate = false;
                       }
                   }

                   if (!laterDate) {
                       installment.errors.rejectValue("installmentDate", "loanInstallment.installmentDate.incorrect")    
                       hasErrors = true
                   }
               }

               if (!principal) {
                   installment.errors.rejectValue("principalInstallmentAmount", "loanInstallment.principal.null")
                   hasErrors = true
               }

               if (!interest) {
                   installment.errors.rejectValue("interestInstallmentAmount", "loanInstallment.interest.null")
                   hasErrors = true
               }

               if (hasErrors) {
                   render(template:"installments/form", model:[installment:installment]) as JSON
                   return
               } 
               counter = counter + 1;
            }

        }

        if(counter>0){

            println("pasok sa condition if counter greater than 0")
             flash.message = "Upload Successfully Executed!"    
            def add = "true"
            def message = "Installment successfully added"      
            render(template:"installments/formupload") as JSON
            
        }
    
}

    /* Download csv file code */
    /*
    def downloadSampleExcel() {
        response.setContentType('application/vnd.ms-excel')
        response.setHeader('Content-Disposition', 'Attachment;Filename="file.csv"')
        WritableWorkbook workbook = Workbook.createWorkbook(response.outputStream)
        WritableSheet sheet1 = workbook.createSheet("Students", 0)
        //excel column names / headers
        sheet1.addCell(new Label(0,0, "Installment_date"))
        sheet1.addCell(new Label(1,0, "Principal_amount"))
        sheet1.addCell(new Label(2,0, "Interest"))
        sheet1.addCell(new Label(3,0, "Service_charge"))
        // excel row values based on coordinates (column,row)
        sheet1.addCell(new Label(0,1, "10/4/2016"))
        sheet1.addCell(new Label(1,1, "10000"))
        sheet1.addCell(new Label(2,1, "200"))
        sheet1.addCell(new Label(3,1, "50"))

        workbook.write();
        workbook.close();
    }    
    */
    /* End of Download csv file code */
    
    // =======================END OF JM CODES ==============================================END OF JM CODES HERE===========
    def editSweepAccount(Loan loanInstance){
        println "id "+loanInstance.id
        
        def a = loanInstance.id.toInteger()
        session["jrxmlTcId"] = a
        def module = getModule(request?.forwardURI)
        def title = getTitle(module)

        def loanApplicationInstance = loanInstance.loanApplication

        // add computation of interest to date
        def intToDate
        use(TimeCategory) {
            def duration = loanInstance.branch.runDate - loanInstance.accruedInterestDate
            intToDate = duration.days * loanInstance.interestRate.div(100) * loanInstance.balanceAmount.div(loanInstance.interestIncomeScheme.divisor)
        }
        session["pageAction"]=""
        session["sweeplist"] =""
        session["pageAction"]="edit"
        session["loanidvalue"]=""
        session["loanidvalue"]=loanInstance.id
        println("loan id: "+loanInstance.id)
        session["sweepAccounts"] = null
 
        def c = LoanRecovery.createCriteria()
        def results = c.list {
            
            eq("fundedLoan", Loan.get(loanInstance.id))
        }
        session["sweeplist"] = results
        println("mysweepList: "+session["sweeplist"])            
        respond loanInstance, model:[loanApplicationInstance:loanApplicationInstance,module:module, title:title, intToDate:intToDate]        
    }
    def removeLoanSweepAccountAjax(){
        def json = request.JSON
        def loanSweepInstanceee = LoanRecovery.get(json.sweepIdValue.toInteger())
        auditLogService.insert('100', 'LON00600',loanSweepInstanceee.fundedLoan.accountNo + ' remove loan sweep ' + loanSweepInstanceee.depositAccount.acctNo, 'LoanRecovery', null, null, null, loanSweepInstanceee.id)
        
        println("########### value from ajax #################################")
        println("loanIdValue :"+json.loanIdValue)
        println("sweepIdValue: "+json.sweepIdValue)
        def sql = new Sql(dataSource)
        def queryall = "delete from loan_recovery where id ="+json.sweepIdValue.toInteger()+"and funded_loan_id ="+json.loanIdValue.toInteger()    
        def resultqueryall1 = sql.execute(queryall)
        println("############################################")
        def queryallsss = "select * from loan where id ="+json.loanIdValue.toInteger()
        def resultqueryall = sql.rows(queryallsss)
        render resultqueryall as JSON    
    }
    def validateDuplicateSweepDepositAcctNoAjax(){
        def json = request.JSON
        println("########### value from ajax #################################")
        println("depositAccountNo :"+json.depositAccountNo)
        println("loanAccountId: "+json.loanAccountId)
        println("depositAccountId: "+json.depositAccountId)
        
        def c = Deposit.createCriteria()
        def results = c.list {
            eq("acctNo", json.depositAccountNo.toString())
        }
        def sql = new Sql(dataSource)
        def queryall = "select * from loan_recovery where funded_loan_id = "+json.loanAccountId.toInteger()+" and deposit_account_id = "+results.id[0]
        def resultqueryall = sql.rows(queryall)
        println("result: "+resultqueryall)
        println("reuslt: "+results.id[0])
        println("############################################")
        render resultqueryall as JSON   
    }
    def editLoanSweepAccountAjaxx(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        
        println("########### value from ajax #################################")
        println("saccountNo :"+json.saccountNo)
        println("sdepositAccount: "+json.sdepositAccount)
        println("stype: "+json.stype)
        println("srule :"+json.srule)
        println("sfundLimitAmt: "+json.sfundLimitAmt)
        println("sfundLimitPercentage: "+json.sfundLimitPercentage)
        println("sremarks: "+json.sremarks)
        println("loanAccountId: "+json.loanAccountIds)
        println("loanrecoveryid: "+json.loanrecoveryid)
        def loanSweepInstanceee = LoanRecovery.get(json.loanrecoveryid)
        loanSweepInstanceee.depositAccount = Deposit.get(json.sdepositAccount)
        loanSweepInstanceee.type = SweepType.get(json.stype)
        loanSweepInstanceee.rule = SweepRule.get(json.srule)
        loanSweepInstanceee.fundLimitAmt = json.sfundLimitAmt.toDouble()
        loanSweepInstanceee.fundLimitPercentage = json.sfundLimitPercentage.toDouble()
        loanSweepInstanceee.remarks = json.sremarks.toString()
        loanSweepInstanceee.fundedLoan = Loan.get(json.loanAccountIds)
        loanSweepInstanceee.status = SweepStatus.get(2)
        loanSweepInstanceee.createdBy = UserMaster.get(session.user_id)  
        loanSweepInstanceee.dateCreated = new Date()
        loanSweepInstanceee.save(flush: true) 
        auditLogService.insert('100', 'LON00600',loanSweepInstanceee.fundedLoan.accountNo + ' edit loan sweep ' + loanSweepInstanceee.depositAccount.acctNo, 'LoanRecovery', null, null, null, loanSweepInstanceee.id)
        
        def queryallsss = "select * from loan_recovery limit 1"
        def resultqueryall = sql.rows(queryallsss)
        render resultqueryall as JSON
        
    }
    def addLoanSweepAccountAjaxx(){
        def json = request.JSON
      
        println("########### value from ajax #################################")
        println("saccountNo :"+json.saccountNo)
        println("sdepositAccount: "+json.sdepositAccount)
        println("stype: "+json.stype)
        println("srule :"+json.srule)
        println("sfundLimitAmt: "+json.sfundLimitAmt)
        println("sfundLimitPercentage: "+json.sfundLimitPercentage)
        println("sremarks: "+json.sremarks)
        println("loanAccountId: "+json.loanAccountIds)
        
        def loanSweepInstanceee = new LoanRecovery()
        loanSweepInstanceee.depositAccount = Deposit.get(json.sdepositAccount)
        loanSweepInstanceee.type = SweepType.get(json.stype)
        loanSweepInstanceee.rule = SweepRule.get(json.srule)
        loanSweepInstanceee.fundLimitAmt = json.sfundLimitAmt.toDouble()
        loanSweepInstanceee.fundLimitPercentage = json.sfundLimitPercentage.toDouble()
        loanSweepInstanceee.remarks = json.sremarks.toString()
        loanSweepInstanceee.fundedLoan = Loan.get(json.loanAccountIds)
        loanSweepInstanceee.status = SweepStatus.get(2)
        loanSweepInstanceee.createdBy = UserMaster.get(session.user_id)  
        loanSweepInstanceee.dateCreated = new Date()
        loanSweepInstanceee.save(flush: true)
        
        auditLogService.insert('100', 'LON00600',loanSweepInstanceee.fundedLoan.accountNo + ' Add loan sweep ' + loanSweepInstanceee.depositAccount.acctNo, 'LoanRecovery', null, null, null, loanSweepInstanceee.id)
        
        println("savingggg.....")
        def sql = new Sql(dataSource)
        def queryall = "select * from loan_recovery limit 1"
        def resultqueryall = sql.rows(queryall)
        render resultqueryall as JSON
      
    }
    
 def loanRelief(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'relief/show', model: [loanInstance:loanInstance, reliefInstance:reliefInstance])
        }else{
            notFound()
        }        
    }
    
    def applyRelief(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            if (!reliefInstance) {
                def r = new LoanRelief(loan:loanInstance, loanReliefStatus:true, 
                    reliefDate:loanInstance.branch.runDate, loanAmount:loanInstance.balanceAmount,
                    particulars:'Applied Loan Relief', updatedBy:UserMaster.get(session.user_id))
                r.save(flush:true)
                reliefInstance = r 
            } else {
                reliefInstance.loanReliefStatus = true
                reliefInstance.reliefDate = loanInstance.branch.runDate
                reliefInstance.loanAmount = loanInstance.balanceAmount
                reliefInstance.particulars = 'Applied Loan Relief'
                reliefInstance.updatedBy = UserMaster.get(session.user_id)
                reliefInstance.reliefRemovalDate = null
                reliefInstance.removedBy = null               
                reliefInstance.save(flush:true)
            }
            def description = 'Loan Account ' +  loanInstance.accountNo + ' applied for loan relief by ' + UserMaster.get(session.user_id).username
            auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)

            render(view:'relief/show', model: [loanInstance:loanInstance, reliefInstance:reliefInstance])
        }else{
            notFound()
        }          
    }
    
    def removeRelief(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            reliefInstance.loanReliefStatus = false
            reliefInstance.particulars = 'Removed Loan Relief'
            reliefInstance.reliefRemovalDate = loanInstance.branch.runDate
            reliefInstance.removedBy = UserMaster.get(session.user_id)
            reliefInstance.save(flush:true)
        def description = loanInstance.accountNo + ' relief was removed by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)
            
             render(view:'relief/show', model: [loanInstance:loanInstance, reliefInstance:reliefInstance])
        }else{
            notFound()
        }          
    }
    def loanReclassification(){
        println("boom pumaosk na dito")
        def loanInstance = Loan.get(params.id.toInteger())
        [loanInstance:loanInstance]
    }
    def updateLoanPerformaceNow(){
       println("params: "+params)
       def json = request.JSON
       def sql = new Sql(dataSource)
       def loangetOldPerformance = Loan.get(json.loanId.toInteger()).loanPerformanceId
       println("loangetOldPerformance: "+loangetOldPerformance)
       println("newLoanPerformanceID: "+json.newLoanPerformanceID)
       def loanUpdateInstance = Loan.get(json.loanId.toInteger())
       def loannewLoanPerformace = LoanPerformanceId.get(json.newLoanPerformanceID.toInteger()).id
       def user = UserMaster.get(session.user_id)
       if (loangetOldPerformance == loannewLoanPerformace) {
           // do nothing, logic test grails fail
           println("noting to do ")
           
       } else {
            def txnTmp = TxnTemplate.get(Institution.findByParamCode('LNS.50075').paramValue.toInteger())
            def tf = new TxnFile(acctNo:loanUpdateInstance.accountNo, branch:loanUpdateInstance.branch, currency:loanUpdateInstance.product.currency,
                loanAcct:loanUpdateInstance, status:ConfigItemStatus.read(2), txnAmt:loanUpdateInstance.balanceAmount, txnCode:txnTmp.code,
                txnDate:Branch.get(1).runDate, txnDescription:'Manual Reclassification of Loan', txnParticulars:'reclassify loan',
                txnRef:'Loan Reclass', txnTemplate:txnTmp, txnType:txnTmp.txnType,
                txnTimestamp:new Date().toTimestamp(), user: user)
            tf.save(flush:true,failOnError:true)
        
            def ll = new LoanLedger(loan:loanUpdateInstance, principalDebit:loanUpdateInstance.balanceAmount, principalCredit:loanUpdateInstance.balanceAmount, 
                principalBalance:loanUpdateInstance.balanceAmount, txnFile:tf, txnCode:tf.txnCode, txnDate:Branch.get(1).runDate,
                txnRef:tf.txnRef, txnParticulars:'Manual Reclassification', txnTemplate:tf.txnTemplate)
            ll.save(flush:true,failOnError:true)

            def rc = new LoanReClassHist(loanAcct:loanUpdateInstance, newClass:loannewLoanPerformace, oldClass:loangetOldPerformance, reclassDate:Branch.get(1).runDate,
                reclassDesc:'Manual Reclassification', txnFile:tf)
            rc.save(flush:true,failOnError:true)           
            glTransactionService.saveTxnBreakdown(tf.id)
       }
       loanUpdateInstance.loanPerformanceId = LoanPerformanceId.get(json.newLoanPerformanceID.toInteger())
       loanUpdateInstance.save(flush: true)
       def queryallsss = "select * from loan where id ="+json.loanId.toInteger()
       def resultqueryall = sql.rows(queryallsss)
       render resultqueryall as JSON 
       
    }
    
def loanRemarkIndex(Loan loanInstance){
       respond loanInstance    
    }
   def loanRemarksShow(LoanRemark loanRemarkInstance){
       respond loanRemarkInstance
    }
    def remarksIndex(Loan loanInstance){
       respond loanInstance
    }
   def createNewRemarks(Loan loanInstance){
       respond loanInstance
   }
   @Transactional
   def saveNewRemarks(Loan loanInstance){
       
       println ("Mag ssave siya")
        def remarks = new LoanRemark (loan:loanInstance, createdBy:UserMaster.get(session.user_id), lastUpdateBy: UserMaster.get(session.user_id), 
            remarkDate: new Date().toTimestamp(), lastUpdateDate:new Date().toTimestamp(), remarks:params.newremark)
            remarks.save(flush:true, failOnError:true);
        
        def lastId = LoanRemark.last(sort:'id')
        println "last id " +  lastId.id
        
        def sql = new Sql(dataSource)
        //def loanRemark = "select * from loan_remark where id = "+lastId.id+""
        def query = "select user_master.name1, user_master.name2, user_master.name3, loan_remark.id, loan_remark.created_by_id, loan_remark.last_update_by_id, loan_remark.last_update_date, loan_remark.loan_id, loan_remark.remark_date, loan_remark.remarks from user_master "
            query += "INNER JOIN loan_remark ON user_master.id = loan_remark.created_by_id WHERE loan_remark.id = "+lastId.id+""
        def result = sql.rows(query)
        println "result" + result
        
//        def result = LoanRemark.findById(lastId.id)
//        println "res" + result
		def description = loanInstance.accountNo + ' remarks was created by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00500', description, 'Loan', null, null, null, loanInstance.id)

            render(view:'loanRemarksShow', model:[loanRemarkInstance:result]) 
    }
   
    def showRemarksDetails(LoanRemark loanRemarkInstance){
        respond loanRemarkInstance      
    }
    def deleteRemarksAjax(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        
        println("loan remarks id :"+json.remarksId)
        def sqlstment = "delete from loan_remark where id ="+json.remarksId.toInteger()
        def krukru = sql.execute(sqlstment)
        def sssss = "select * from branch where id = 1"
        def returnIntsncesdee = sql.rows(sssss)
        render returnIntsncesdee as JSON
    }
    
    def loanUidDebit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanUidDebit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        }   
    }
   
    def saveUidDebit(Loan loanInstance){
        def debitAmount  = params.debitAmt.toString().replace(',','').toDouble()
        def debitId = Loan.get(params.uidDebit.toInteger())
        println("DebitId: "+debitId)
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceuidDebit = LoanLossProvisionDetail.findByLoan(debitId)
        println("uidbal: "+instanceuidDebit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:debitId.currency,
            txnAmt:debitAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:debitId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        
            tx.save(flush:true, failOnError:true);
            println("nag save sa txn File: "+ tx )
            
            def uidLedger = new LoanUidLedger()
            uidLedger.loan = debitId
            uidLedger.loanProvision = instanceuidDebit
            uidLedger.refDate = b.runDate
            uidLedger.reference = params.reference
            uidLedger.particulars = params.particulars
            uidLedger.debitAmt = debitAmount
            uidLedger.creditAmt = 0.00D
            uidLedger.uidBalance = instanceuidDebit.uidBalance - debitAmount
            uidLedger.txnFile = tx
            println("loan: "+ uidLedger.loan)
            println("loanProvision: "+ uidLedger.loanProvision)
            println("refDate: "+ uidLedger.refDate)
            println("reference: "+ uidLedger.reference)
            println("particulars: "+ uidLedger.particulars)
            println("debitAmt: "+ uidLedger.debitAmt)
            println("creditAmt: "+ uidLedger.creditAmt)
            println("uidBalance: "+ uidLedger.uidBalance)
            println("txnFile: "+ uidLedger.txnFile)
            uidLedger.save(flush:true)
            
            instanceuidDebit.uidBalance = instanceuidDebit.uidBalance - debitAmount
            println("uidbal: "+ instanceuidDebit.uidBalance)
            instanceuidDebit.save(flush:true)
        
        //def debitUid = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(debitId.glLink.id,'9',2).glCode.toInteger()
        def debitUid = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(debitId.glLink,'9',2).glCode
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:debitId.currency,debitAcct:debitUid,
            debitAmt:debitAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:debitId.currency,creditAcct:t.defContraAcct,
            creditAmt:debitAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
            redirect(action: "show", controller: "loan",id:debitId.id)
    }
    
    def saveUidCredit(Loan loanInstance){
        def creditAmount  = params.creditAmt.toString().replace(',','').toDouble()
        def creditId = Loan.get(params.uidCredit.toInteger())
        println("DebitId: "+creditId)
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceuidDebit = LoanLossProvisionDetail.findByLoan(creditId)
        println("uidbal: "+instanceuidDebit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:creditId.currency,
            txnAmt:creditAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:creditId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
            
            
        def uidLedger = new LoanUidLedger()
            uidLedger.loan = creditId
            uidLedger.loanProvision = instanceuidDebit
            uidLedger.refDate = b.runDate
            uidLedger.reference = params.reference
            uidLedger.particulars = params.particulars
            uidLedger.debitAmt = 0.00D 
            uidLedger.creditAmt = creditAmount
            uidLedger.uidBalance = instanceuidDebit.uidBalance + creditAmount
            uidLedger.txnFile = tx
            println("loanProvision: "+ uidLedger.loanProvision)
            println("refDate: "+ uidLedger.refDate)
            println("reference: "+ uidLedger.reference)
            println("particulars: "+ uidLedger.particulars)
            println("debitAmt: "+ uidLedger.debitAmt)
            println("creditAmt: "+ uidLedger.creditAmt)
            println("uidBalance: "+ uidLedger.uidBalance)
            println("txnFile: "+ uidLedger.txnFile)
            uidLedger.save(flush:true)
            
            
            instanceuidDebit.uidBalance = instanceuidDebit.uidBalance + creditAmount
            println("uidbal: "+ instanceuidDebit.uidBalance)
            instanceuidDebit.save(flush:true)
        
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:creditId.currency,debitAcct:t.defContraAcct,
            debitAmt:creditAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
        def creditUid = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(creditId.glLink,'9',2).glCode
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:creditId.currency,creditAcct:creditUid,
            creditAmt:creditAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
            redirect(action: "show", controller: "loan",id:creditId.id)
    }
    
    def loanUidCredit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanUidCredit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    
    // additional allowance credit
    def loanUidCredittransaction(Loan loanInstance){
        def creditAllowAmount  = params.creditAllowAmt.toString().replace(',','').toDouble()
        def creditAllowId = Loan.get(params.allowCredit.toInteger())
        def allowtype = params.Additional_Allowance
        println("Allowtype: "+allowtype)
        println("DebitId: "+creditAllowId)
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceuidDebit = LoanLossProvisionDetail.findByLoan(creditAllowId)
        println("uidbal: "+instanceuidDebit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:creditAllowId.currency,
            txnAmt:creditAllowAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:creditAllowId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )

        def loanAllowance = new LoanAllowanceLedger()
            loanAllowance.allowanceType = allowtype
            loanAllowance.loan = creditAllowId
            loanAllowance.loanProvision = instanceuidDebit
            loanAllowance.refDate = b.runDate
            loanAllowance.reference = params.reference
            loanAllowance.particulars = params.particulars
            loanAllowance.debitAmt = 0.00D 
            loanAllowance.creditAmt =  params.creditAllowAmount ? (params.creditAllowAmount.replaceAll(",","")).toDouble() : null
            loanAllowance.totalAllowance = instanceuidDebit.totalProvision + creditAllowAmount
            loanAllowance.txnFile = tx
            println("allowanceType: "+ loanAllowance.allowanceType)
            println("loanProvision: "+ loanAllowance.loanProvision)
            println("refDate: "+ loanAllowance.refDate)
            println("reference: "+ loanAllowance.reference)
            println("particulars: "+ loanAllowance.particulars)
            println("debitAmt: "+ loanAllowance.debitAmt)
            println("creditAmt: "+ loanAllowance.creditAmt)
            println("uidBalance: "+ loanAllowance.totalAllowance)
            println("txnFile: "+ loanAllowance.txnFile)
            loanAllowance.save(flush:true)
            
            
            instanceuidDebit.totalProvision = instanceuidDebit.totalProvision + creditAllowAmount
            println("uidbal: "+ instanceuidDebit.totalProvision)
            instanceuidDebit.save(flush:true)
        
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:creditAllowId.currency,debitAcct:t.defContraAcct,
            debitAmt:creditAllowAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
        def creditAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(creditAllowId.glLink,'A',2).glCode
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:creditAllowId.currency,creditAcct:creditAllow,
            creditAmt:creditAllowAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
            redirect(action: "show", controller: "loan",id:creditAllowId.id)
    }
    
    
    def loanAllowanceCredit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanAllowanceCredit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    
    def loanCredit(Loan loanInstance){
        def CreditAmount  = params.creditAmt.toString().replace(',','').toDouble()
        def AllowId = Loan.get(params.allowCredit.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        println("DebitAmount: "+DebitAmount)
        println("DebitId: "+AllowId)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:AllowId.currency,
            txnAmt:CreditAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:AllowId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
            
        def uidLedger = new LoanUidLedger(loanProvision:AllowId, refDate:b.runDate,
            reference:params.reference, particulars:params.particulars, debitAmt:CreditAmount, creditAmt:0.00D,
            totalAllowance:AllowId.totalProvision + CreditAmount, txnFile:tx)
            uidLedger.save(flush:true)
            
        
        println("nag save sa ledger: "+ UidLedger )
        DebitId.uidBalance = DebitId.uidBalance - DebitAmount
        println("uidbal: "+ DebitId.uidBalance)
	DebitId.save(flush:true)
        
        
//        def txnDr = new TxnBreakdown(branch:tx.branch, currency:DebitId.currency,debitAcct:DebitId.glCode,
//            debitAmt:DebitAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
//            txnDr.save(flush:true)
//        
//        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:DebitId.currency,creditAcct:t.defContraAcct,
//            creditAmt:DebitAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
//            txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
            redirect(action: "show", controller: "loan",id:DebitId.id)
    }
    
    def loanAllowanceTransferDebit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanAllowanceTransferDebit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    
    def loanAllowanceTransferDebittransaction(){
        def allowDebitAmount  = params.AllowdebitAmt.toString().replace(',','').toDouble()
        def allowDebitId = Loan.get(params.allowDebit.toInteger())
        def allowtype = params.Transfer_Allowance
        println("Allowtype: "+allowtype)
        println("allowDebitId: "+allowDebitId)
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceuidDebit = LoanLossProvisionDetail.findByLoan(allowDebitId)
        println("uidbal: "+instanceuidDebit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:allowDebitId.currency,
            txnAmt:allowDebitAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:allowDebitId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
            
            
        def allowanceLedger = new LoanAllowanceLedger()
            allowanceLedger.allowanceType = allowtype
            allowanceLedger.loan = allowDebitId
            allowanceLedger.loanProvision = instanceuidDebit
            allowanceLedger.refDate = b.runDate
            allowanceLedger.reference = params.reference
            allowanceLedger.particulars = params.particulars
            allowanceLedger.debitAmt =  allowDebitAmount
            allowanceLedger.creditAmt = 0.00D
            allowanceLedger.totalAllowance = instanceuidDebit.totalProvision - allowDebitAmount
            allowanceLedger.txnFile = tx
            println("allowanceType: "+ allowanceLedger.allowanceType)
            println("loan: "+ allowanceLedger.loan)
            println("loanProvision: "+ allowanceLedger.loanProvision)
            println("refDate: "+ allowanceLedger.refDate)
            println("reference: "+ allowanceLedger.reference)
            println("particulars: "+ allowanceLedger.particulars)
            println("debitAmt: "+ allowanceLedger.debitAmt)
            println("creditAmt: "+ allowanceLedger.creditAmt)
            println("uidBalance: "+ allowanceLedger.totalAllowance)
            println("txnFile: "+ allowanceLedger.txnFile)
            allowanceLedger.save(flush:true)
            
            
            instanceuidDebit.totalProvision = instanceuidDebit.totalProvision - allowDebitAmount
            println("uidbal: "+ instanceuidDebit.totalProvision)
            instanceuidDebit.save(flush:true)
        
        def debitAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(allowDebitId.glLink,'A',2).glCode
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:allowDebitId.currency,debitAcct:debitAllow,
            debitAmt:allowDebitAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:allowDebitId.currency,creditAcct:t.defContraAcct,
            creditAmt:allowDebitAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
            redirect(action: "show", controller: "loan",id:allowDebitId.id)
    }
    
    def loanAllowanceTransferCredit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanAllowanceTransferCredit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    
    def loanAllowanceTransferCredittransaction(){
        def allowCreditAmount  = params.AllowcreditAmt.toString().replace(',','').toDouble()
        def allowCreditId = Loan.get(params.alloCredit.toInteger())
         def allowtype = params.Transfer_Allowance
        println("Allowtype: "+allowtype)
        println("AllowDebitId: "+allowCreditId)
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceuidDebit = LoanLossProvisionDetail.findByLoan(allowCreditId)
        println("uidbal: "+instanceuidDebit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:allowCreditId.currency,
            txnAmt:allowCreditAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:allowCreditId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
            
            
        def allowanceLedger = new LoanAllowanceLedger()
            allowanceLedger.allowanceType = allowtype
            allowanceLedger.loan = allowCreditId
            allowanceLedger.loanProvision = instanceuidDebit
            allowanceLedger.refDate = b.runDate
            allowanceLedger.reference = params.reference
            allowanceLedger.particulars = params.particulars
            allowanceLedger.debitAmt = 0.00D
            allowanceLedger.creditAmt = allowCreditAmount
            allowanceLedger.totalAllowance = instanceuidDebit.totalProvision + allowCreditAmount
            allowanceLedger.txnFile = tx
            println("allowanceType: "+ allowanceLedger.allowanceType)
            println("loan: "+ allowanceLedger.loan)
            println("loanProvision: "+ allowanceLedger.loanProvision)
            println("refDate: "+ allowanceLedger.refDate)
            println("reference: "+ allowanceLedger.reference)
            println("particulars: "+ allowanceLedger.particulars)
            println("debitAmt: "+ allowanceLedger.debitAmt)
            println("creditAmt: "+ allowanceLedger.creditAmt)
            println("uidBalance: "+ allowanceLedger.totalAllowance)
            println("txnFile: "+ allowanceLedger.txnFile)
            allowanceLedger.save(flush:true)
            
            
            instanceuidDebit.totalProvision = instanceuidDebit.totalProvision + allowCreditAmount
            println("uidbal: "+ instanceuidDebit.totalProvision)
            instanceuidDebit.save(flush:true)
        
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:allowCreditId.currency,debitAcct:t.defContraAcct,
            debitAmt:allowCreditAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
            
        def creditAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(allowCreditId.glLink,'A',2).glCode
        
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:allowCreditId.currency,creditAcct:creditAllow,
            creditAmt:allowCreditAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
        println('ito na: '+tx)
        redirect(action: "show", controller: "loan",id:allowCreditId.id)
    }
	   //Loan Service Charge Credit
    def loanServiceChargeCredit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanServiceChargeCredit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    //Loan Service Charge Debit
    def loanServiceChargeDebit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanServiceChargeDebit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    
    //Loan Deferred Credit
   def loanDeferredCredit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanDeferredCredit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    //Loan Deferred Debit
    def loanDeferredDebit(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'loanLoss/loanDeferredDebit', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    //Loan Service Charge Credit Transaction
     //dagdag ng transactional
    @Transactional
    def loanServiceChargeCreditTransaction(){
        def serviceChargeAmount  = params.creditAmt.toString().replace(',','').toDouble()
        def serviceChargeId = Loan.get(params.serviceChargeCreditId.toInteger())
        def allowtype = params.Transfer_Allowance
        println("Amount: "+serviceChargeAmount)
        println("SC ID: "+serviceChargeId) 
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceScCredit = LoanLossProvisionDetail.findByLoan(serviceChargeId)
        println("Service Charge Bal: "+serviceChargeId)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:serviceChargeId.currency,
            txnAmt:serviceChargeAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:serviceChargeId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
        def serviceChargeLedger = new LoanServiceChargeLedger()
            serviceChargeLedger.loan = serviceChargeId
            serviceChargeLedger.loanProvision = instanceScCredit
            serviceChargeLedger.refDate = b.runDate
            serviceChargeLedger.reference = params.reference
            serviceChargeLedger.particulars = params.particulars
            serviceChargeLedger.debitAmt = 0.00D
            serviceChargeLedger.creditAmt = serviceChargeAmount
            serviceChargeLedger.serviceChargeBalance = instanceScCredit.loanServiceCharge + serviceChargeAmount
            serviceChargeLedger.txnFile = tx
            println("loan: "+ serviceChargeLedger.loan)
            println("loanProvision: "+ serviceChargeLedger.loanProvision)
            println("refDate: "+ serviceChargeLedger.refDate)
            println("reference: "+ serviceChargeLedger.reference)
            println("particulars: "+ serviceChargeLedger.particulars)
            println("debitAmt: "+ serviceChargeLedger.debitAmt)
            println("creditAmt: "+ serviceChargeLedger.creditAmt)
            println("uidBalance: "+ serviceChargeLedger.serviceChargeBalance)
            println("txnFile: "+ serviceChargeLedger.txnFile)
            serviceChargeLedger.save(flush:true)
            
            instanceScCredit.loanServiceCharge = instanceScCredit.loanServiceCharge + serviceChargeAmount
            println("Service charge bal: "+ instanceScCredit.loanServiceCharge)
            instanceScCredit.save(flush:true)
        
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:serviceChargeId.currency,debitAcct:t.defContraAcct,
            debitAmt:serviceChargeAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
            
        def creditAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(serviceChargeId.glLink,'C',2).glCode
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:serviceChargeId.currency,creditAcct:creditAllow,
            creditAmt:serviceChargeAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
        println('ito na: '+tx)
        redirect(action: "show", controller: "loan",id:serviceChargeId.id)
        
    }
    
    //Loan Service Charge Debit Transaction
     //dagdag ng transactional
    @Transactional
    def loanServiceChargeDebitTransaction(){
        def serviceChargeAmount  = params.debitAmt.toString().replace(',','').toDouble()
        def serviceChargeId = Loan.get(params.serviceChargeDebitId.toInteger())
        def allowtype = params.Transfer_Allowance
        println("Amount: "+serviceChargeAmount)
        println("SC ID: "+serviceChargeId) 
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instanceScDebit = LoanLossProvisionDetail.findByLoan(serviceChargeId)
        println("Service Charge Bal: "+serviceChargeId)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:serviceChargeId.currency,
            txnAmt:serviceChargeAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:serviceChargeId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
        def serviceChargeLedger = new LoanServiceChargeLedger()
            serviceChargeLedger.loan = serviceChargeId
            serviceChargeLedger.loanProvision = instanceScDebit
            serviceChargeLedger.refDate = b.runDate
            serviceChargeLedger.reference = params.reference
            serviceChargeLedger.particulars = params.particulars
            serviceChargeLedger.debitAmt = serviceChargeAmount
            serviceChargeLedger.creditAmt = 0.00D
            serviceChargeLedger.serviceChargeBalance = instanceScDebit.loanServiceCharge - serviceChargeAmount
            serviceChargeLedger.txnFile = tx
            println("loan: "+ serviceChargeLedger.loan)
            println("loanProvision: "+ serviceChargeLedger.loanProvision)
            println("refDate: "+ serviceChargeLedger.refDate)
            println("reference: "+ serviceChargeLedger.reference)
            println("particulars: "+ serviceChargeLedger.particulars)
            println("debitAmt: "+ serviceChargeLedger.debitAmt)
            println("creditAmt: "+ serviceChargeLedger.creditAmt)
            println("uidBalance: "+ serviceChargeLedger.serviceChargeBalance)
            println("txnFile: "+ serviceChargeLedger.txnFile)
            serviceChargeLedger.save(flush:true)
            
            instanceScDebit.loanServiceCharge = instanceScDebit.loanServiceCharge - serviceChargeAmount
            println("Service charge bal: "+ instanceScDebit.loanServiceCharge)
            instanceScDebit.save(flush:true)
        
    
        def debitAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(serviceChargeId.glLink,'C',2).glCode
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:serviceChargeId.currency,debitAcct:debitAllow,
            debitAmt:serviceChargeAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:serviceChargeId.currency,creditAcct:t.defContraAcct,
            creditAmt:serviceChargeAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
        println('ito na: '+tx)
        redirect(action: "show", controller: "loan",id:serviceChargeId.id)
    }
    
    //Loan Deferred Credit Transaction
    //dagdagan ng transactional
    @Transactional
    def deferredCredit(){
        def deferredAmount  = params.creditAmt.toString().replace(',','').toDouble()
        def deferredId = Loan.get(params.deferredCreditId.toInteger())
        def allowtype = params.Transfer_Allowance
        println("Amount: "+deferredAmount)
        println("Deferred ID: "+deferredId) 
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instancedeferredCredit = LoanLossProvisionDetail.findByLoan(deferredId)
        println("Deferred Charge Bal: "+instancedeferredCredit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:deferredId.currency,
            txnAmt:deferredAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:deferredId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
        def deferredLedger = new LoanDeferredLedger()
            deferredLedger.loan = deferredId
            deferredLedger.loanProvision = instancedeferredCredit
            deferredLedger.refDate = b.runDate
            deferredLedger.reference = params.reference
            deferredLedger.particulars = params.particulars
            deferredLedger.debitAmt = 0.00D
            deferredLedger.creditAmt = deferredAmount
            deferredLedger.deferredBalance = instancedeferredCredit.otherDeferredCredit + deferredAmount
            deferredLedger.txnFile = tx
            println("loan: "+ deferredLedger.loan)
            println("loanProvision: "+ deferredLedger.loanProvision)
            println("refDate: "+ deferredLedger.refDate)
            println("reference: "+ deferredLedger.reference)
            println("particulars: "+ deferredLedger.particulars)
            println("debitAmt: "+ deferredLedger.debitAmt)
            println("creditAmt: "+ deferredLedger.creditAmt)
            println("uidBalance: "+ deferredLedger.deferredBalance)
            println("txnFile: "+ deferredLedger.txnFile)
            deferredLedger.save(flush:true)
            
            instancedeferredCredit.otherDeferredCredit = instancedeferredCredit.otherDeferredCredit + deferredAmount
            println("Service charge bal: "+ instancedeferredCredit.otherDeferredCredit)
            instancedeferredCredit.save(flush:true)
        
        
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:deferredId.currency,debitAcct:t.defContraAcct,
            debitAmt:deferredAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
        println ("BREAKDOWN txnDr:"+ txnDr)
            
        def creditAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(deferredId.glLink,'D',2).glCode
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:deferredId.currency,creditAcct:creditAllow,
            creditAmt:deferredAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
        println ("BREAKDOWN txnCrCash:"+ txnCrCash)
        println('ito na: '+tx)
        redirect(action: "show", controller: "loan",id:deferredId.id)
        
    }
    //Loan Deferred Debit Transaction
    //dagdagan ng transactional
    @Transactional
    def deferredDebit(){
        def deferredAmount  = params.debitAmt.toString().replace(',','').toDouble()
        def deferredId = Loan.get(params.deferredDebitId.toInteger())
        def allowtype = params.Transfer_Allowance
        println("Amount: "+deferredAmount)
        println("Deferred ID: "+deferredId) 
        
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        
        def instancedeferredCredit = LoanLossProvisionDetail.findByLoan(deferredId)
        println("Deferred Charge Bal: "+instancedeferredCredit)
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:deferredId.currency,
            txnAmt:deferredAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:deferredId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
        println("nag save sa txn File: "+ tx )
        def deferredLedger = new LoanDeferredLedger()
            deferredLedger.loan = deferredId
            deferredLedger.loanProvision = instancedeferredCredit
            deferredLedger.refDate = b.runDate
            deferredLedger.reference = params.reference
            deferredLedger.particulars = params.particulars
            deferredLedger.debitAmt =  deferredAmount
            deferredLedger.creditAmt = 0.00D
            deferredLedger.deferredBalance = instancedeferredCredit.otherDeferredCredit - deferredAmount
            deferredLedger.txnFile = tx
            println("loan: "+ deferredLedger.loan)
            println("loanProvision: "+ deferredLedger.loanProvision)
            println("refDate: "+ deferredLedger.refDate)
            println("reference: "+ deferredLedger.reference)
            println("particulars: "+ deferredLedger.particulars)
            println("debitAmt: "+ deferredLedger.debitAmt)
            println("creditAmt: "+ deferredLedger.creditAmt)
            println("uidBalance: "+ deferredLedger.deferredBalance)
            println("txnFile: "+ deferredLedger.txnFile)
            deferredLedger.save(flush:true)
            
            instancedeferredCredit.otherDeferredCredit = instancedeferredCredit.otherDeferredCredit - deferredAmount
            println("Deferred charge bal: "+ instancedeferredCredit.otherDeferredCredit)
            instancedeferredCredit.save(flush:true)
            
        def debitAllow = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(deferredId.glLink,'D',2).glCode
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:deferredId.currency,debitAcct:debitAllow,
            debitAmt:deferredAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
            
        println ("BREAKDOWN txnDr:"+ txnDr)
        
        def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:deferredId.currency,creditAcct:t.defContraAcct,
            creditAmt:deferredAmount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
            
        println ("BREAKDOWN txnCrCash:"+ txnCrCash)            
        println('ito na: '+tx)
        redirect(action: "show", controller: "loan",id:deferredId.id)
    }
    def loanGurantee(Loan loanInstance){
        if (loanInstance == null){
            notFound()
            return        
        }
        
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanInstance)
        //show gsp
        render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanInstance,loanGuaranteeInstance:loanGuaranteeInstance])
    }
	def loanScrMaintenance(){
        if(params.id){
            def loanInstance = Loan.get(params.id)
            def reliefInstance = LoanRelief.findByLoan(loanInstance)
            render(view:'scr/scrMaintenance', model: [loanInstance:loanInstance])
        }else{
            notFound()
        } 
    }
    
    def agfpInformation(){
        
        println("---->>rdmontana Loan Rediscounting<<-----")
        println("params: "+params)
        def loanInstance = Loan.get(params.id)
        if (loanInstance == null){
            notFound()
            return        
        }
        println("loanInstance: "+ loanInstance)
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanInstance)
        //show gsp
        if (loanGuaranteeInstance == null) {
            loanGuaranteeInstance = new LoanGuaranteeDetail()
        } 
        render(view:'loanGuarantee/agfpInformation', model: [loanInstance:loanInstance,loanGuaranteeInstance:loanGuaranteeInstance])
    }
    def commodityRateAjax(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        def agfpCommodity = json.agfpCommodity.toString()
        println("agfpCommodity: "+json.agfpCommodity)
        
        def queryall = "select * from commodity where id='${agfpCommodity}'"
        def resultqueryall = sql.rows(queryall)
        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    def saveAgfpInformation(){
        println("rdmontana ====> Pumasok na sa saving ng saveAgfpInformation")
        
        def loanInstance = Loan.get(params.id)
        
        def loanId = Loan.findById(Integer.parseInt(params.loanInstance.toString()))
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)
        
        if(loanGuaranteeInstance){
            def agfpLoanGuarantee = LoanGuaranteeDetail.get(Integer.parseInt(loanGuaranteeInstance.id.toString()))
                agfpLoanGuarantee.loan = loanId
                agfpLoanGuarantee.agfpCommodity = Commodity.get(params.agfpCommodity.toInteger())
                agfpLoanGuarantee.agfpHectaresOrHeads = params.agfpHectaresOrHeads ? (params.agfpHectaresOrHeads.toString().replaceAll(",","")).toDouble() : 0.00D
               // saveLoanGuarantee.agfpPcicInsured = false
                //saveLoanGuarantee.agfpArbBorrower = false
                agfpLoanGuarantee.agfpGuaranteeRate = params.agfpGuaranteeRate ? (params.agfpGuaranteeRate.toString().replaceAll(",","")).toDouble() : 0.00D
                agfpLoanGuarantee.agfpGuaranteeFee = params.agfpGuaranteeFee ? (params.agfpGuaranteeFee.toString().replaceAll(",","")).toDouble() : 0.00D
                agfpLoanGuarantee.agfpReferred = params.agfpReferred.toString()
                agfpLoanGuarantee.agfpRemarks = params.agfpRemarks.toString()
                agfpLoanGuarantee.save(flush:true)
                render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance])
        }else{
            def saveLoanGuaranteeAgfp = new LoanGuaranteeDetail()
                saveLoanGuaranteeAgfp.loan = loanId
                saveLoanGuaranteeAgfp.agfpCommodity = Commodity.get(params.agfpCommodity.toInteger())
                saveLoanGuaranteeAgfp.agfpHectaresOrHeads = params.agfpHectaresOrHeads ? (params.agfpHectaresOrHeads.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeAgfp.agfpPcicInsured = false
                saveLoanGuaranteeAgfp.agfpArbBorrower = false
                saveLoanGuaranteeAgfp.agfpGuaranteeRate = params.agfpGuaranteeRate ? (params.agfpGuaranteeRate.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeAgfp.agfpGuaranteeFee = params.agfpGuaranteeFee ? (params.agfpGuaranteeFee.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeAgfp.agfpReferred = params.agfpReferred.toString()
                saveLoanGuaranteeAgfp.agfpRemarks = params.agfpRemarks.toString()
                saveLoanGuaranteeAgfp.save(flush:true)
                loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)   	
                render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
        }
        
    }
    
    def sbgfcInformation(){
        
        println("---->>rdmontana Loan Rediscounting<<-----")
        println("params: "+params)
        def loanInstance = Loan.get(params.id)
        if (loanInstance == null){
            notFound()
            return        
        }
        println("loanInstance: "+ loanInstance)
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanInstance)
        //show gsp
        if (loanGuaranteeInstance == null) {
            loanGuaranteeInstance = new LoanGuaranteeDetail()
        } 
        render(view:'loanGuarantee/sbgfcInformation', model: [loanInstance:loanInstance,loanGuaranteeInstance:loanGuaranteeInstance])
    }
    def saveSbgfcInformation(){
        println("rdmontana ====> Pumasok na sa saving ng saveSbgfcInformation")
        
        def loanInstance = Loan.get(params.id)
        
        def loanId = Loan.findById(Integer.parseInt(params.loanInstance.toString()))
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)
        
        if(loanGuaranteeInstance){
            println("rdmontana -->> Pumasok sa If")
            def sbgfcLoanGuarantee = LoanGuaranteeDetail.get(Integer.parseInt(loanGuaranteeInstance.id.toString()))
                sbgfcLoanGuarantee.loan = loanId
                sbgfcLoanGuarantee.sbgfcMainOfficeAddress = params.sbgfcMainOfficeAddress.toString()
                sbgfcLoanGuarantee.sbgfcPosition = params.sbgfcPosition.toString()
                sbgfcLoanGuarantee.sbgfcNetWorth = params.sbgfcNetWorth ? (params.sbgfcNetWorth.toString().replaceAll(",","")).toDouble() : 0.00D
                sbgfcLoanGuarantee.sbgfcNatureOfBusiness = params.sbgfcNatureOfBusiness.toString()
                sbgfcLoanGuarantee.sbgfcBusinessType = params.sbgfcBusinessType.toString()
                sbgfcLoanGuarantee.sbgfcStartOfBusinessOperation = params.sbgfcStartOfBusinessOperation
                sbgfcLoanGuarantee.sbgfcAssetSize = params.sbgfcAssetSize ? (params.sbgfcAssetSize.toString().replaceAll(",","")).toDouble() : 0.00D
                sbgfcLoanGuarantee.sbgfcNumberOfEmployees = (params.sbgfcNumberOfEmployees.empty)?params.sbgfcNumberOfEmployees = null:Integer.parseInt(params.sbgfcNumberOfEmployees.toString())
                sbgfcLoanGuarantee.sbgfcTypeOfLoan = params.sbgfcTypeOfLoan.toString()
                sbgfcLoanGuarantee.sbgfcPurposeOfLoan = params.sbgfcPurposeOfLoan.toString()
                sbgfcLoanGuarantee.sbgfcOutstandingBalance = params.sbgfcOutstandingBalance ? (params.sbgfcOutstandingBalance.toString().replaceAll(",","")).toDouble() : 0.00D
                sbgfcLoanGuarantee.sbgfcDsc = (params.sbgfcDsc.empty)?params.sbgfcDsc = null:Double.parseDouble(params.sbgfcDsc)
                sbgfcLoanGuarantee.sbgfcInitialBrrTotalPoints = params.sbgfcInitialBrrTotalPoints ? (params.sbgfcInitialBrrTotalPoints.toString().replaceAll(",","")).toDouble() : null
                sbgfcLoanGuarantee.sbgfcInitialBrrGrade = params.sbgfcInitialBrrGrade ? (params.sbgfcInitialBrrGrade.toString().replaceAll(",","")).toDouble() : null
                sbgfcLoanGuarantee.sbgfcBrrTotalPoints = params.sbgfcBrrTotalPoints ? (params.sbgfcBrrTotalPoints.toString().replaceAll(",","")).toDouble() : null
                sbgfcLoanGuarantee.sbgfcBrrGrade = params.sbgfcBrrGrade ? (params.sbgfcBrrGrade.toString().replaceAll(",","")).toDouble() : null
                sbgfcLoanGuarantee.sbgfcTypeOfCollateral = params.sbgfcTypeOfCollateral.toString()
                sbgfcLoanGuarantee.sbgfcMarketValue = params.sbgfcMarketValue ? (params.sbgfcMarketValue.toString().replaceAll(",","")).toDouble() : 0.00D
                sbgfcLoanGuarantee.sbgfcLoanValue = params.sbgfcLoanValue ? (params.sbgfcLoanValue.toString().replaceAll(",","")).toDouble() : 0.00D
                sbgfcLoanGuarantee.sbgfcBusinessName = params.sbgfcBusinessName.toString()
                sbgfcLoanGuarantee.save(flush:true)
                render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance])
        }else{
            def saveLoanGuaranteeSbgfc = new LoanGuaranteeDetail()
                saveLoanGuaranteeSbgfc.loan = loanId
                saveLoanGuaranteeSbgfc.sbgfcMainOfficeAddress = params.sbgfcMainOfficeAddress.toString()
                saveLoanGuaranteeSbgfc.sbgfcPosition = params.sbgfcPosition.toString()
                saveLoanGuaranteeSbgfc.sbgfcNetWorth = params.sbgfcNetWorth ? (params.sbgfcNetWorth.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcNatureOfBusiness = params.sbgfcNatureOfBusiness.toString()
                saveLoanGuaranteeSbgfc.sbgfcBusinessType = params.sbgfcBusinessType.toString()
                saveLoanGuaranteeSbgfc.sbgfcStartOfBusinessOperation = params.sbgfcStartOfBusinessOperation
                saveLoanGuaranteeSbgfc.sbgfcAssetSize = params.sbgfcAssetSize ? (params.sbgfcAssetSize.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcNumberOfEmployees = (params.sbgfcNumberOfEmployees.empty)?params.sbgfcNumberOfEmployees = null:Integer.parseInt(params.sbgfcNumberOfEmployees.toString())
                saveLoanGuaranteeSbgfc.sbgfcTypeOfLoan = params.sbgfcTypeOfLoan.toString()
                saveLoanGuaranteeSbgfc.sbgfcPurposeOfLoan = params.sbgfcPurposeOfLoan.toString()
                saveLoanGuaranteeSbgfc.sbgfcOutstandingBalance = params.sbgfcOutstandingBalance ? (params.sbgfcOutstandingBalance.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcDsc = (params.sbgfcDsc.empty)?params.sbgfcDsc = null:Double.parseDouble(params.sbgfcDsc)
                saveLoanGuaranteeSbgfc.sbgfcInitialBrrTotalPoints = params.sbgfcInitialBrrTotalPoints ? (params.sbgfcInitialBrrTotalPoints.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcInitialBrrGrade = params.sbgfcInitialBrrGrade ? (params.sbgfcInitialBrrGrade.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcBrrTotalPoints = params.sbgfcBrrTotalPoints ? (params.sbgfcBrrTotalPoints.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcBrrGrade = params.sbgfcBrrGrade ? (params.sbgfcBrrGrade.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcTypeOfCollateral = params.sbgfcTypeOfCollateral.toString()
                saveLoanGuaranteeSbgfc.sbgfcMarketValue = params.sbgfcMarketValue ? (params.sbgfcMarketValue.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcLoanValue = params.sbgfcLoanValue ? (params.sbgfcLoanValue.toString().replaceAll(",","")).toDouble() : 0.00D
                saveLoanGuaranteeSbgfc.sbgfcBusinessName = params.sbgfcBusinessName.toString()
                saveLoanGuaranteeSbgfc.save(flush:true)
                loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)   	
                render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
        }
        
    }
    
    
    def hgcInformation(){
        
        println("---->>rdmontana Loan Rediscounting<<-----")
        println("params: "+params)
        def loanInstance = Loan.get(params.id)
        if (loanInstance == null){
            notFound()
            return        
        }
        println("loanInstance: "+ loanInstance)
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanInstance)
        //show gsp
        if (loanGuaranteeInstance == null) {
            loanGuaranteeInstance = new LoanGuaranteeDetail()
        } 
        render(view:'loanGuarantee/hgcInformation', model: [loanInstance:loanInstance,loanGuaranteeInstance:loanGuaranteeInstance])
    }
    
    def saveHgcInformation(){
        println("rdmontana ====> Pumasok na sa saving ng saveHgcInformation")
        
        def loanInstance = Loan.get(params.id)
        
        def loanId = Loan.findById(Integer.parseInt(params.loanInstance.toString()))
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)
        
        if(loanGuaranteeInstance){
            def hgcLoanGuarantee = LoanGuaranteeDetail.get(Integer.parseInt(loanGuaranteeInstance.id.toString()))
                hgcLoanGuarantee.loan = loanId
                hgcLoanGuarantee.hgcValueForEnrollment = params?.hgcValueForEnrollment ? (params?.hgcValueForEnrollment.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.hgcCoverageStartPeriod = (params.hgcCoverageStartPeriod.empty)?params.hgcCoverageStartPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcCoverageStartPeriod)
                hgcLoanGuarantee.hgcCoverageEndPeriod = (params.hgcCoverageEndPeriod.empty)?params.hgcCoverageEndPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcCoverageEndPeriod)
                hgcLoanGuarantee.hgcPremiumRate = params?.hgcPremiumRate ? (params?.hgcPremiumRate.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.hgcPremiumDue = params?.hgcPremiumDue ? (params?.hgcPremiumDue.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.hgcTctNo = params.hgcTctNo
                hgcLoanGuarantee.hgcLocation = params.hgcLocation
                hgcLoanGuarantee.hgcAppraisedValue = params?.hgcAppraisedValue ? (params?.hgcAppraisedValue.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.hgcLoanToValueRatio = params?.hgcLoanToValueRatio ? (params?.hgcLoanToValueRatio.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.rediscounting = false
                hgcLoanGuarantee.rediscountingAgent = params.rediscountingAgent.toString()
                hgcLoanGuarantee.hgcValueOfNewReleaseForEnrollment = params?.hgcValueOfNewReleaseForEnrollment ? (params?.hgcValueOfNewReleaseForEnrollment.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.hgcTotalAmountReleased = params?.hgcTotalAmountReleased ? (params?.hgcTotalAmountReleased.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.hgcloanReleasedDate = (params.hgcloanReleasedDate.empty)?params.hgcloanReleasedDate = null:new Date().parse("MM/dd/yyyy", params.hgcloanReleasedDate)
                hgcLoanGuarantee.hgcCogNoOfTheFirstReleased = params?.hgcCogNoOfTheFirstReleased
                hgcLoanGuarantee.hgcAddCoverageStartPeriod = (params.hgcAddCoverageStartPeriod.empty)?params.hgcAddCoverageStartPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcAddCoverageStartPeriod)
                hgcLoanGuarantee.hgcAddCoverageEndPeriod = (params.hgcAddCoverageEndPeriod.empty)?params.hgcAddCoverageEndPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcAddCoverageEndPeriod)    
                hgcLoanGuarantee.hgcAddPremiumDue = params?.hgcAddPremiumDue ? (params?.hgcAddPremiumDue.replaceAll(",","")).toDouble() : null
                hgcLoanGuarantee.save(flush:true)
                render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
        }else{
            def saveLoanGuaranteeHgc = new LoanGuaranteeDetail()
                saveLoanGuaranteeHgc.loan = loanId
                saveLoanGuaranteeHgc.hgcValueForEnrollment = params?.hgcValueForEnrollment ? (params?.hgcValueForEnrollment.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.hgcCoverageStartPeriod = (params.hgcCoverageStartPeriod.empty)?params.hgcCoverageStartPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcCoverageStartPeriod)
                saveLoanGuaranteeHgc.hgcCoverageEndPeriod = (params.hgcCoverageEndPeriod.empty)?params.hgcCoverageEndPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcCoverageEndPeriod)
                saveLoanGuaranteeHgc.hgcPremiumRate = params?.hgcPremiumRate ? (params?.hgcPremiumRate.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.hgcPremiumDue = params?.hgcPremiumDue ? (params?.hgcPremiumDue.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.hgcTctNo = params.hgcTctNo
                saveLoanGuaranteeHgc.hgcLocation = params.hgcLocation
                saveLoanGuaranteeHgc.hgcAppraisedValue = params?.hgcAppraisedValue ? (params?.hgcAppraisedValue.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.hgcLoanToValueRatio = params?.hgcLoanToValueRatio ? (params?.hgcLoanToValueRatio.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.rediscounting = false
                saveLoanGuaranteeHgc.rediscountingAgent = params.rediscountingAgent.toString()
                saveLoanGuaranteeHgc.hgcValueOfNewReleaseForEnrollment = params?.hgcValueOfNewReleaseForEnrollment ? (params?.hgcValueOfNewReleaseForEnrollment.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.hgcTotalAmountReleased = params?.hgcTotalAmountReleased ? (params?.hgcTotalAmountReleased.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.hgcloanReleasedDate = (params.hgcloanReleasedDate.empty)?params.hgcloanReleasedDate = null:new Date().parse("MM/dd/yyyy", params.hgcloanReleasedDate)
                saveLoanGuaranteeHgc.hgcCogNoOfTheFirstReleased = params?.hgcCogNoOfTheFirstReleased
                saveLoanGuaranteeHgc.hgcAddCoverageStartPeriod = (params.hgcAddCoverageStartPeriod.empty)?params.hgcAddCoverageStartPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcAddCoverageStartPeriod)
                saveLoanGuaranteeHgc.hgcAddCoverageEndPeriod = (params.hgcAddCoverageEndPeriod.empty)?params.hgcAddCoverageEndPeriod = null:new Date().parse("MM/dd/yyyy", params.hgcAddCoverageEndPeriod)    
                saveLoanGuaranteeHgc.hgcAddPremiumDue = params?.hgcAddPremiumDue ? (params?.hgcAddPremiumDue.replaceAll(",","")).toDouble() : null
                saveLoanGuaranteeHgc.save(flush:true)
                loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)   	
                render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
        }
        
    }
    def loanGuaranteeShow(){
         println("rdmontana ====> Pumasok na sa saving ng loanGuaranteeShow")
        
        def loanInstance = Loan.get(params.id)
        
        def loanId = Loan.findById(Integer.parseInt(params.loanInstance.toString()))
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)
        render(view:'loanGuarantee/loanGuaranteeShow', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
    }
    def loanRediscountingGsp(){
        println("---->>rdmontana Loan Rediscounting GSP<<-----")
        println("params: "+params)
        def loanInstance = Loan.get(params.id)
        println("loanInstance: "+ loanInstance)
        def loanRediscountingInstance = LoanRediscounting.findByLoan(loanInstance)
        println("pumasok sa: " + loanRediscountingInstance)
        render(view:'loanGuarantee/loanRediscountingGsp', model: [loanInstance:loanInstance,loanRediscountingInstance:loanRediscountingInstance])
        
    }
    def saveLoanRediscounting(){
        println("---->>rdmontana Loan Rediscounting CREATE<<-----")
        println("params: "+ params)
        def loanInstance = Loan.get(params.loanInstance)
        println("loanInstance: "+ loanInstance)
        def loanId = Loan.findById(Integer.parseInt(params.loanInstance.toString()))
        def branchId = loanInstance.branch.id 
        println("Branch ID: "+ branchId)
        def loanRediscountingInstance = LoanRediscounting.findByLoan(loanId)
        if(!loanRediscountingInstance){
            println("Pumasok dito kasi null yung table")
            def rediscountingInstance = new LoanRediscounting()
                rediscountingInstance.loan = loanId
                rediscountingInstance.dateGranted =  (params.dateGranted.empty)?params.dateGranted = null:new Date().parse("MM/dd/yyyy", params.dateGranted)
                rediscountingInstance.maturityDate = (params.maturityDate.empty)?params.maturityDate = null:new Date().parse("MM/dd/yyyy", params.maturityDate)
                rediscountingInstance.pnNo = params.pnNo.toString()
                rediscountingInstance.loanRediscountingPartner = LoanRediscountingPartner.get(params.loanRediscountingPartner.toInteger())
                rediscountingInstance.loanRediscountingStatus = LoanRediscountingStatus.get(2)
                rediscountingInstance.save(flush:true,failOnError:true)
                loanRediscountingInstance = LoanRediscounting.findByLoan(loanId) 
                def getLoanAppCollInstance = loanInstance.loanApplication
                println("getLoanAppCollInstance: "+getLoanAppCollInstance)
                render(view:'loanGuarantee/loanRediscountingShow', model: [loanInstance:loanInstance,loanRediscountingInstance:loanRediscountingInstance, getLoanAppCollInstance:getLoanAppCollInstance])
        }else{
            def loanRediscountingInstancePa = LoanRediscounting.get(Integer.parseInt(loanRediscountingInstance.id.toString()))
            loanRediscountingInstancePa.dateGranted =  (params.dateGranted.empty)?params.dateGranted = null:new Date().parse("MM/dd/yyyy", params.dateGranted)
            loanRediscountingInstancePa.maturityDate = (params.maturityDate.empty)?params.maturityDate = null:new Date().parse("MM/dd/yyyy", params.maturityDate)
            loanRediscountingInstancePa.pnNo = params.pnNo.toString()
            loanRediscountingInstancePa.loanRediscountingPartner = LoanRediscountingPartner.get(params.loanRediscountingPartner.toInteger())
            loanRediscountingInstancePa.loanRediscountingStatus = LoanRediscountingStatus.get(params?.loanRediscountingStatus.toInteger())
            loanRediscountingInstancePa.save(flush:true,failOnError:true)
            def getLoanAppCollInstance = loanInstance.loanApplication
                println("getLoanAppCollInstance: "+getLoanAppCollInstance)
            render(view:'loanGuarantee/loanRediscountingShow', model: [loanInstance:loanInstance,loanRediscountingInstance:loanRediscountingInstance, getLoanAppCollInstance:getLoanAppCollInstance])

        
        }
    }						  
	 def collectionInformation(){
        def json = request.JSON
        //def TxnTypeInstance = TxnType.get(json.typevalue.toInteger())
        //def TxnTypeInstance = TxnType.get(json.typevalue)
        def sql = new Sql(dataSource)
        def TxnTypeInstance = "select * from ropa where id = '${json.id.toInteger()}'"
        def resultqueryall = sql.rows(TxnTypeInstance)
        
        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    @Transactional
    def saveScrMaintenance(){
        println("churva")
        def remarksIddididid = params.remarks
        def scrIdId = Loan.get(params.scrId.toInteger())
        def rororororpapapa = ROPA.get(params.ropaididid.toInteger())
        println("ropaniya:"+rororororpapapa)

        def scrTransaction = new ScrRopa()
            scrTransaction.loan = scrIdId
            scrTransaction.ropa = rororororpapapa
            scrTransaction.remarks = remarksIddididid
        
            println("loan:" + scrTransaction.loan)
            println("ropa:" + scrTransaction.ropa)
            println("remarks:" + scrTransaction.remarks)
            
            scrTransaction.save(flush:true, failOnError:true)
            println("save:"+scrTransaction )
			
															
		
            redirect(action: "show", controller: "loan",id:scrIdId.id)
}

	def saveGuarantee(Loan loanInstance){
        // save details
        
        def loanId = Loan.findById(Integer.parseInt(params.loanInstance.toString()))
        def loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)
        
        //validator
        if(loanGuaranteeInstance){
        

        def updateLoanGuarantee = LoanGuaranteeDetail.get(Integer.parseInt(loanGuaranteeInstance.id.toString()))
        updateLoanGuarantee.loan = loanId
        updateLoanGuarantee.agfpCommodity = params.agfpCommodity
        updateLoanGuarantee.agfpHectaresOrHeads = (params.agfpHectaresOrHeads.empty)?params.agfpHectaresOrHeads = null:Double.parseDouble(params.agfpHectaresOrHeads.toString())
       // saveLoanGuarantee.agfpPcicInsured = false
        //saveLoanGuarantee.agfpArbBorrower = false
        updateLoanGuarantee.agfpGuaranteeRate = (params.agfpGuaranteeRate.empty)?params.agfpGuaranteeRate = null:Double.parseDouble(params.agfpGuaranteeRate.toString())
        updateLoanGuarantee.agfpGuaranteeFee = (params.agfpGuaranteeFee.empty)?params.agfpGuaranteeFee = null:Double.parseDouble(params.agfpGuaranteeFee.toString())
        updateLoanGuarantee.agfpReferred = params.agfpReferred.toString()
        updateLoanGuarantee.agfpRemarks = params.agfpRemarks.toString()
        updateLoanGuarantee.sbgfcMainOfficeAddress = params.sbgfcMainOfficeAddress.toString()
        updateLoanGuarantee.sbgfcPosition = params.sbgfcPosition.toString()
        updateLoanGuarantee.sbgfcNetWorth = (params.sbgfcNetWorth.empty)?params.sbgfcNetWorth = null:Double.parseDouble(params.sbgfcNetWorth.toString())
        updateLoanGuarantee.sbgfcNatureOfBusiness = params.sbgfcNatureOfBusiness.toString()
        updateLoanGuarantee.sbgfcBusinessType = params.sbgfcBusinessType.toString()
        updateLoanGuarantee.sbgfcStartOfBusinessOperation = params.sbgfcStartOfBusinessOperation
        updateLoanGuarantee.sbgfcAssetSize = (params.sbgfcAssetSize.empty)?params.sbgfcAssetSize = null:Double.parseDouble(params.sbgfcAssetSize.toString())
        updateLoanGuarantee.sbgfcNumberOfEmployees = (params.sbgfcNumberOfEmployees.empty)?params.sbgfcNumberOfEmployees = null:Integer.parseInt(params.sbgfcNumberOfEmployees.toString())
																																															 
        updateLoanGuarantee.sbgfcTypeOfLoan = params.sbgfcTypeOfLoan.toString()
        updateLoanGuarantee.sbgfcPurposeOfLoan = params.sbgfcPurposeOfLoan.toString()
        updateLoanGuarantee.sbgfcOutstandingBalance = (params.sbgfcOutstandingBalance.empty)? params.sbgfcOutstandingBalance = null:Double.parseDouble(params.sbgfcOutstandingBalance.toString())
        updateLoanGuarantee.sbgfcDsc = (params.sbgfcDsc.empty)?params.sbgfcDsc = null:Double.parseDouble(params.sbgfcDsc)
        updateLoanGuarantee.sbgfcInitialBrrTotalPoints = (params.sbgfcInitialBrrTotalPoints.empty)? params.sbgfcInitialBrrTotalPoints = null:Integer.parseInt(params.sbgfcInitialBrrTotalPoints)
        updateLoanGuarantee.sbgfcInitialBrrGrade = (params.sbgfcInitialBrrGrade.empty)?params.sbgfcInitialBrrGrade = null:Double.parseDouble(params.sbgfcInitialBrrGrade.toString())
        updateLoanGuarantee.sbgfcBrrTotalPoints = (params.sbgfcBrrTotalPoints.empty)?params.sbgfcBrrTotalPoints = null:Double.parseDouble(params.sbgfcBrrTotalPoints.toString())
        updateLoanGuarantee.sbgfcBrrGrade = (params.sbgfcBrrGrade.empty)?params.sbgfcBrrGrade = null : Double.parseDouble(params.sbgfcBrrGrade.toString())
        updateLoanGuarantee.sbgfcTypeOfCollateral = params.sbgfcTypeOfCollateral.toString()
        updateLoanGuarantee.sbgfcMarketValue = (params.sbgfcMarketValue.empty)?params.sbgfcMarketValue = null:Double.parseDouble(params.sbgfcMarketValue.toString())
        updateLoanGuarantee.sbgfcLoanValue = (params.sbgfcLoanValue.empty)?params.sbgfcLoanValue = null:Double.parseDouble(params.sbgfcLoanValue)
        updateLoanGuarantee.hgcValueForEnrollment = (params.hgcValueForEnrollment.empty)?params.hgcValueForEnrollment = null:Double.parseDouble(params.hgcValueForEnrollment)
        updateLoanGuarantee.hgcCoveragePeriod = params.hgcCoveragePeriod.toString()
        updateLoanGuarantee.hgcPremiumRate = (params.hgcPremiumRate.empty)?params.hgcPremiumRate = null:Double.parseDouble(params.hgcPremiumRate)
        updateLoanGuarantee.hgcPremiumDue = (params.hgcPremiumDue.empty)?params.hgcPremiumDue = null:Double.parseDouble(params.hgcPremiumDue)
        updateLoanGuarantee.hgcTctNo = params.hgcTctNo
        updateLoanGuarantee.hgcLocation = params.hgcLocation
        updateLoanGuarantee.hgcAppraisedValue = (params.hgcAppraisedValue.empty)?params.hgcAppraisedValue = null:Double.parseDouble(params.hgcAppraisedValue)
        updateLoanGuarantee.hgcLoanToValueRatio = (params.hgcLoanToValueRatio.empty)?params.hgcLoanToValueRatio = null:Double.parseDouble(params.hgcLoanToValueRatio)
        //updateLoanGuarantee.rediscounting = false
        updateLoanGuarantee.rediscountingAgent = params.rediscountingAgent.toString()
        updateLoanGuarantee.save(flush:true)
        println updateLoanGuarantee
        render(view:'loanGuarantee/UpdateloanGuaranteeDetail', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
        }else{
         
           
         
        def saveLoanGuarantee = new LoanGuaranteeDetail()
        saveLoanGuarantee.loan = loanId
        saveLoanGuarantee.agfpCommodity = params.agfpCommodity
        saveLoanGuarantee.agfpHectaresOrHeads = (params.agfpHectaresOrHeads.empty)?params.agfpHectaresOrHeads = null:Double.parseDouble(params.agfpHectaresOrHeads.toString())
        saveLoanGuarantee.agfpPcicInsured = false
        saveLoanGuarantee.agfpArbBorrower = false
        saveLoanGuarantee.agfpGuaranteeRate = (params.agfpGuaranteeRate.empty)?params.agfpGuaranteeRate = null:Double.parseDouble(params.agfpGuaranteeRate.toString())
        saveLoanGuarantee.agfpGuaranteeFee = (params.agfpGuaranteeFee.empty)?params.agfpGuaranteeFee = null:Double.parseDouble(params.agfpGuaranteeFee.toString())
        saveLoanGuarantee.agfpReferred = params.agfpReferred.toString()
        saveLoanGuarantee.agfpRemarks = params.agfpRemarks.toString()
        saveLoanGuarantee.sbgfcMainOfficeAddress = params.sbgfcMainOfficeAddress.toString()
        saveLoanGuarantee.sbgfcPosition = params.sbgfcPosition.toString()
        saveLoanGuarantee.sbgfcNetWorth = (params.sbgfcNetWorth.empty)?params.sbgfcNetWorth = null:Double.parseDouble(params.sbgfcNetWorth.toString())
        saveLoanGuarantee.sbgfcNatureOfBusiness = params.sbgfcNatureOfBusiness.toString()
        saveLoanGuarantee.sbgfcBusinessType = params.sbgfcBusinessType.toString()
        saveLoanGuarantee.sbgfcStartOfBusinessOperation = params.sbgfcStartOfBusinessOperation
        saveLoanGuarantee.sbgfcAssetSize = (params.sbgfcAssetSize.empty)?params.sbgfcAssetSize = null:Double.parseDouble(params.sbgfcAssetSize.toString())
        saveLoanGuarantee.sbgfcNumberOfEmployees = (params.sbgfcNumberOfEmployees.empty)?params.sbgfcNumberOfEmployees = null:Integer.parseInt(params.sbgfcNumberOfEmployees.toString())
																																														   
        saveLoanGuarantee.sbgfcTypeOfLoan = params.sbgfcTypeOfLoan.toString()
        saveLoanGuarantee.sbgfcPurposeOfLoan = params.sbgfcPurposeOfLoan.toString()
        saveLoanGuarantee.sbgfcOutstandingBalance = (params.sbgfcOutstandingBalance.empty)? params.sbgfcOutstandingBalance = null:Double.parseDouble(params.sbgfcOutstandingBalance.toString())
        saveLoanGuarantee.sbgfcDsc = (params.sbgfcDsc.empty)?params.sbgfcDsc = null:Double.parseDouble(params.sbgfcDsc)
        saveLoanGuarantee.sbgfcInitialBrrTotalPoints = (params.sbgfcInitialBrrTotalPoints.empty)? params.sbgfcInitialBrrTotalPoints = null:Integer.parseInt(params.sbgfcInitialBrrTotalPoints)
        saveLoanGuarantee.sbgfcInitialBrrGrade = (params.sbgfcInitialBrrGrade.empty)?params.sbgfcInitialBrrGrade = null:Double.parseDouble(params.sbgfcInitialBrrGrade.toString())
        saveLoanGuarantee.sbgfcBrrTotalPoints = (params.sbgfcBrrTotalPoints.empty)?params.sbgfcBrrTotalPoints = null:Integer.parseInt(params.sbgfcBrrTotalPoints)
        saveLoanGuarantee.sbgfcBrrGrade = (params.sbgfcBrrGrade.empty)?params.sbgfcBrrGrade = null : Double.parseDouble(params.sbgfcBrrGrade.toString())
        saveLoanGuarantee.sbgfcTypeOfCollateral = params.sbgfcTypeOfCollateral.toString()
        saveLoanGuarantee.sbgfcMarketValue = (params.sbgfcMarketValue.empty)?params.sbgfcMarketValue = null:Double.parseDouble(params.sbgfcMarketValue.toString())
        saveLoanGuarantee.sbgfcLoanValue = (params.sbgfcLoanValue.empty)?params.sbgfcLoanValue = null:Double.parseDouble(params.sbgfcLoanValue)
        saveLoanGuarantee.hgcValueForEnrollment = (params.hgcValueForEnrollment.empty)?params.hgcValueForEnrollment = null:Double.parseDouble(params.hgcValueForEnrollment)
        saveLoanGuarantee.hgcCoveragePeriod = params.hgcCoveragePeriod.toString()
        saveLoanGuarantee.hgcPremiumRate = (params.hgcPremiumRate.empty)?params.hgcPremiumRate = null:Double.parseDouble(params.hgcPremiumRate)
        saveLoanGuarantee.hgcPremiumDue = (params.hgcPremiumDue.empty)?params.hgcPremiumDue = null:Double.parseDouble(params.hgcPremiumDue)
        saveLoanGuarantee.hgcTctNo = params.hgcTctNo
        saveLoanGuarantee.hgcLocation = params.hgcLocation
        saveLoanGuarantee.hgcAppraisedValue = (params.hgcAppraisedValue.empty)?params.hgcAppraisedValue = null:Double.parseDouble(params.hgcAppraisedValue)
        saveLoanGuarantee.hgcLoanToValueRatio = (params.hgcLoanToValueRatio.empty)?params.hgcLoanToValueRatio = null:Double.parseDouble(params.hgcLoanToValueRatio)
        saveLoanGuarantee.rediscounting = false
        saveLoanGuarantee.rediscountingAgent = params.rediscountingAgent.toString()
        saveLoanGuarantee.save(flush:true)
        loanGuaranteeInstance = LoanGuaranteeDetail.findByLoan(loanId)   
//

//            println saveLoanGuarantee
////         

									 
		   
         render(view:'loanGuarantee/UpdateloanGuaranteeDetail', model: [loanInstance:loanId,loanGuaranteeInstance:loanGuaranteeInstance]) 
//         
  
        }
                
    }
    def scrCreateDiscountSchedule(){
        println("=========== scrCreateDiscountSchedule =================")
        println("params: "+params)
        def loanInstance = Loan.get(params?.id.toInteger())
        
        [loanInstance:loanInstance]
    }
    @Transactional
    def saveScrDiscountSchedule(){
        println(" ============= saveScrDiscountSchedule =============")
        println("params: "+params)
        def loanInstance = Loan.get(params?.loanId.toInteger())
        def scrdebitAmt = params.debitAmt ? (params.debitAmt.replaceAll(",","")).toDouble() : 0.00D
        def scrcreditAmt = params.creditAmt ? (params.creditAmt.replaceAll(",","")).toDouble() : 0.00D
        def scrSchedDate = params.scheduleDate? new Date().parse("MM/dd/yyyy", params.scheduleDate) : null
        
        def scrDiscountScheduleInstance = new ScrDiscountSchedule(loan:loanInstance,scrdateCreated:UserMaster.get(session.user_id).branch.runDate,
            branch: UserMaster.get(session.user_id).branch,debitAmt: scrdebitAmt,creditAmt:scrcreditAmt,scheduleDate: scrSchedDate,
            reference:''+params?.reference,particulars: ''+params?.particulars,createdBy: UserMaster.get(session.user_id),status: ConfigItemStatus.get(2))
        scrDiscountScheduleInstance.save(flush:true,failOnError:true)
        
        flash.message = "SCR Discount Schedule Successfully Created."
        redirect(action: "showDiscountSchedule",controller: "loan", id: loanInstance.id)
    }
    def showDiscountSchedule(){
        println("============ showDiscountSchedule ===============")
        println("params: "+params)
        
        def loanInstance = Loan.get(params?.id)
         
        def c = ScrDiscountSchedule.createCriteria()
        def scrDiscountScheduleInstance = c.list {
            
            eq("loan", loanInstance)
            order("scheduleDate", "asc")
        }
        [scrDiscountScheduleInstance:scrDiscountScheduleInstance,loanInstance:loanInstance]
    }

}


