package icbs.gl
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import groovy.sql.Sql
import groovy.json.JsonBuilder		
import icbs.gl.AssetsHeldToMaturityLedger		
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.tellering.TxnFile
import icbs.admin.Currency
import icbs.admin.TxnTemplate
import icbs.lov.TxnType
import icbs.gl.GlAccount
import icbs.admin.Branch
import icbs.lov.ConfigItemStatus
import icbs.tellering.TxnBreakdown
import java.lang.*
import icbs.admin.Institution
import org.apache.poi.ss.formula.functions.Irr
import org.apache.poi.ss.formula.functions.FinanceLib
import groovy.time.TimeCategory
import java.text.SimpleDateFormat
import java.util.Formatter.DateTime
import java.util.Date
import java.math.*;
import java.lang.Math;
import icbs.gl.HtmSchedule
import icbs.gl.HtmType
import icbs.lov.ResidentType
class AssetsHtmController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
     def dataSource
     def index(Integer max) {
        println("params: "+params)
        params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            //params.sort = "code"
        }

        if (params.query == null) {  // show all instances 
            def assetsHtmList = AssetsHeldToMaturity.createCriteria().list(params) {
                
                order("createdDate", "desc")
            }
            respond assetsHtmList, model:[assetsHtmList: assetsHtmList,assetsHtmInstanceCount: assetsHtmList.totalCount]
        }
        else {    // show query results
            def assetsHtmList = AssetsHeldToMaturity.createCriteria().list(params) {
                or {
                    ilike("htmDescription","%${params.query}%")
                    ilike("htmType","%${params.query}%")
                    ilike("glCode","%${params.query}%")
                }
                order("createdDate", "desc")
            }
            respond assetsHtmList, model:[assetsHtmList: assetsHtmList,assetsHtmInstanceCount: assetsHtmList.totalCount]
        }
    }

    
    def create(){
        def assetsHtmInstance = new AssetsHeldToMaturity()
        respond assetsHtmInstance
    }
    @Transactional
    def save(AssetsHeldToMaturity assetsHtmInstance){
        println("params: "+params)
        
        //def htmID = AssetsHeldToMaturity.get(params.htmID.toInteger())
        def htmInstance = new AssetsHeldToMaturity()
        
        htmInstance.amount = params.amount ? (params.amount.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.discountAmount = params.discountAmount ? (params.discountAmount.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.branch = UserMaster.get(session.user_id).branch
        htmInstance.createdBy = UserMaster.get(session.user_id)
        htmInstance.createdDate = htmInstance.branch.runDate
        htmInstance.effectiveYield = params.effectiveYield ? (params.effectiveYield.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.glCode = params.glCode
        htmInstance.htmAccrualDebitAcct = params.htmAccrualDebitAcct
        htmInstance.htmAccrualCredittAcct = params.htmAccrualCredittAcct
        htmInstance.currency = Currency.get(params.currency.id.toInteger())
        htmInstance.htmDescription = params.xHtmDesc
       
        htmInstance.interestRate = params.interestRate ? (params.interestRate.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.maturityDate = params.maturityDate? new Date().parse("MM/dd/yyyy", params.maturityDate) : null
        htmInstance.maturityValue = params.maturityValue? (params.maturityValue.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.reference = params.reference
        htmInstance.remarks = params.remarks
        htmInstance.valueDate = params.valueDate? new Date().parse("MM/dd/yyyy", params.valueDate) : null
        htmInstance.status = ConfigItemStatus.get(2)
        htmInstance.residentType = ResidentType.get(params?.residentType.toInteger())
        htmInstance.htmIssuer = params?.htmIssuer
        htmInstance.htmTypeDesc = HtmType.get(params?.htmTypeDesc.toInteger())
        htmInstance.htmType = HtmType.get(params?.htmTypeDesc.toInteger()).description
        
        println("nagsave na siya: "+ params.valueDate)
        htmInstance.save(flush:true,failOnError:true)
        //redirect(action: "show", controller: "assetsHtm",id:htmInstance.id)
        
        // ============ create entry debit transaction
        
        def amountCash  = htmInstance.amount
        def htmid = htmInstance
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        //def t = TxnTemplate.get(Institution.findByParamCode("GLS.60460").paramValue.toInteger())
        println("amountCash: "+amountCash)
        println("htmid: "+htmid)
        
	def tx  = new TxnFile(txnCode:t.code,txnDescription:'New HTM-'+t.description,txnDate:b.runDate,currency:htmid.currency,
            txnAmt:amountCash,txnRef:'New HTM-'+params.reference,status:ConfigItemStatus.get(2), branch:htmid.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:'New Create HTM debit entry',txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
            //add to ledger
	    def htmLedger = new AssetsHeldToMaturityLedger(assetsHeldToMaturity:htmid, refDate:b.runDate, valueDate:params.valueDate,
            reference:'New HTM-'+params.reference, particulars:'New Create HTM debit entry', debit:amountCash, credit:0.00D,
            balance:amountCash, txnFile:tx)
            htmLedger.save(flush:true)

	    //debit txn breakdown
            def txnDr = new TxnBreakdown(branch:tx.branch, currency:htmid.currency,debitAcct:htmid.glCode,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
            
            // credit txn breakdown
            def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:htmid.currency,creditAcct:t.defContraAcct,
            creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
        //======================= create entry for discount =======================
        if(htmInstance.discountAmount > 0.00D){
            
            def htmCRDiscountTemplate = TxnTemplate.get(Institution.findByParamCode("GLS.60650").paramValue.toInteger())
            
            def txDiscount  = new TxnFile(txnCode:htmCRDiscountTemplate.code,txnDescription:htmCRDiscountTemplate.description,txnDate:b.runDate,currency:htmid.currency,
                txnAmt:htmInstance.discountAmount,txnRef:'HTM Discount CR',status:ConfigItemStatus.get(2), branch:htmid.branch,
                txnTimestamp: new Date().toTimestamp(),txnParticulars:'to record HTM Discount Credit',txnType:htmCRDiscountTemplate.txnType,txnTemplate:htmCRDiscountTemplate, 
                user:UserMaster.get(session.user_id))
            txDiscount.save(flush:true, failOnError:true);
            
            //debit txn breakdown
            def txnDiscountDr = new TxnBreakdown(branch:txDiscount.branch, currency:htmid.currency,debitAcct:htmCRDiscountTemplate.defContraAcct,
                debitAmt:htmInstance.discountAmount, txnCode:htmCRDiscountTemplate.code, txnDate:b.runDate, txnFile:txDiscount, user:UserMaster.get(session.user_id))
            txnDiscountDr.save(flush:true)
            
            // credit txn breakdown
            def txnDiscountCr = new TxnBreakdown(branch:txDiscount.branch, currency:htmid.currency,creditAcct:htmInstance.htmAccrualDebitAcct,
                creditAmt:htmInstance.discountAmount, txnCode:htmCRDiscountTemplate.code, txnDate:b.runDate, txnFile:txDiscount, user:UserMaster.get(session.user_id))      
            txnDiscountCr.save(flush:true)
            
        }
        //generateSchedule
        if(htmInstance.htmTypeDesc.id != 2){
            generateHtmDiscountSchedule(htmid)
        }
        
        
        flash.message = "HTM Successfully created"
        redirect(action: "show", controller: "assetsHtm",id:htmid.id)
    }  
    
    def show(AssetsHeldToMaturity assetsHtmInstance){
        println("params: "+params)
        def htmInstance = AssetsHeldToMaturity.get(params.id.toInteger())
        
        def c = HtmSchedule.createCriteria()
        def htmScheduleInstance = c.list {
            
            eq("assetsHeldToMaturity", htmInstance)
            order("xhtmScheduleDate", "asc")
        }
        def totalDiscountInstance = 0.00D
        def remainingDiscount = 0.00D
        for(x in htmScheduleInstance){
            totalDiscountInstance = totalDiscountInstance + x.amount
            if(x.xhtmScheduleDate > htmInstance.branch.runDate){
                remainingDiscount = remainingDiscount + x.amount
            }
        }
        println("totalDiscountInstance: "+totalDiscountInstance)
        println("remainingDiscount: "+remainingDiscount)
        [htmInstance:htmInstance,htmScheduleInstance:htmScheduleInstance,totalDiscountInstance:totalDiscountInstance,
        remainingDiscount:remainingDiscount]

    }
    
     
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'assetsHtm.label', default: 'Assets Held to Maturity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def viewMoreTransaction(AssetsHeldToMaturity assetsHtmInstance){
        def htmVmtInstance = AssetsHeldToMaturity.get(params.id.toInteger())
        def c = AssetsHeldToMaturityLedger.createCriteria()
        def htmLedgerInstance = c.list {
           
            eq("assetsHeldToMaturity", htmVmtInstance)
            order("refDate", "asc")
        }
        [htmVmtInstance:htmVmtInstance,htmLedgerInstance:htmLedgerInstance]
    }
    def htmDebit(AssetsHeldToMaturity assetsHtmInstance){
        println("params: "+params)
        def htmDebitInstance = AssetsHeldToMaturity.get(params.id.toInteger())
        [htmDebitInstance:htmDebitInstance]
    }
    def htmCredit(AssetsHeldToMaturity assetsHtmInstance){
         println("params: "+params)
        def htmCreditInstance = AssetsHeldToMaturity.get(params.id.toInteger())
        [htmCreditInstance:htmCreditInstance]
    }
    @Transactional
    def savehtmDebit(AssetsHeldToMaturity assetsHtmInstance){
        def amountCash  = params.debitAmt.toString().replace(',','').toDouble()
        def htmid = AssetsHeldToMaturity.get(params.htmDebit.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        println("amountCash: "+amountCash)
        println("htmid: "+htmid)
	def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:htmid.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:htmid.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
	    def htmLedger = new AssetsHeldToMaturityLedger(assetsHeldToMaturity:htmid, refDate:b.runDate, valueDate:b.runDate,
            reference:params.reference, particulars:params.particulars, debit:amountCash, credit:0.00D,
            balance:htmid.amount + amountCash, txnFile:tx)
            htmLedger.save(flush:true)
        
		htmid.amount = htmid.amount + amountCash 
		htmid.save(flush:true)
	   
            def txnDr = new TxnBreakdown(branch:tx.branch, currency:htmid.currency,debitAcct:htmid.glCode,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
            def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:htmid.currency,creditAcct:t.defContraAcct,
            creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
            println('ito na: '+tx)
        //assetsHtmInstance = htmid
        
        flash.message = "HTM Credit Transaction Successfully executed"
        redirect(action: "show", controller: "assetsHtm",id:htmid.id)
        //respond assetsHtmInstance.errors, view:'show'
        
    }
    def savehtmCredit(AssetsHeldToMaturity assetsHtmInstance){
        println("====================== SAVE HTM CREDIT =============================")
        println("params: "+params)
        def amountCash  = params.creditAmt.toString().replace(',','').toDouble()
        def htmid = AssetsHeldToMaturity.get(params.htmCredit.toInteger())
        def b = Branch.get(1)
        def t = TxnTemplate.get(params.txnType.toInteger())
        println("amountCash: "+amountCash)
        println("htmid: "+htmid)
	def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:htmid.currency,
            txnAmt:amountCash,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:htmid.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
            tx.save(flush:true, failOnError:true);
            
	    def htmLedger = new AssetsHeldToMaturityLedger(assetsHeldToMaturity:htmid, refDate:b.runDate, valueDate:b.runDate,//b.runDate,
            reference:params.reference, particulars:params.particulars, debit:0.00D, credit:amountCash,
            balance:htmid.amount - amountCash, txnFile:tx)
            htmLedger.save(flush:true)
        
		htmid.amount = htmid.amount - amountCash 
		htmid.save(flush:true)
	   
            def txnDr = new TxnBreakdown(branch:tx.branch, currency:htmid.currency,debitAcct:t.defContraAcct,
            debitAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDr.save(flush:true)
        
            def txnCrCash = new TxnBreakdown(branch:tx.branch, currency:htmid.currency,creditAcct:htmid.glCode,
            creditAmt:amountCash, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))      
            txnCrCash.save(flush:true)
        
        if(htmid.amount == 0.00D){
            // close HTM
            htmid.status = ConfigItemStatus.get(8)
            htmid.save(flush:true)
            
            // update htm_schedule set as remove delete 
            def htmSchedInstance = HtmSchedule.findAllByAssetsHeldToMaturity(htmid)
            for(xhtmId in htmSchedInstance){
                xhtmId.status = ConfigItemStatus.get(3)
                xhtmId.save(flush:true)
            }
        }
        
        flash.message = "HTM Credit Transaction Successfully executed."
        redirect(action: "show", controller: "assetsHtm",id:htmid.id)
        //respond assetsHtmInstance.errors, view:'show'
        
    }    
    def edit(){
         def assetsHtmInstance = AssetsHeldToMaturity.get(params.id.toInteger())   
        [assetsHtmInstance:assetsHtmInstance]
        
    }
    
    @Transactional
    def update(){
        println("magic params: "+params)
        def htmInstance = AssetsHeldToMaturity.get(params.idto.toInteger())
        //htmInstance.amount = params.amount ? (params.amount.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.amount = params.amount ? (params.amount.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.discountAmount = params.discountAmount ? (params.discountAmount.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.branch = UserMaster.get(session.user_id).branch
        htmInstance.createdBy = UserMaster.get(session.user_id)
        htmInstance.createdDate = htmInstance.branch.runDate
        htmInstance.effectiveYield = params.effectiveYield ? (params.effectiveYield.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.glCode = params.glCode
        htmInstance.htmAccrualDebitAcct = params.htmAccrualDebitAcct
        htmInstance.htmAccrualCredittAcct = params.htmAccrualCredittAcct
        htmInstance.currency = Currency.get(params.currency.id.toInteger())
        htmInstance.htmDescription = params.xHtmDesc
       
        htmInstance.interestRate = params.interestRate ? (params.interestRate.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.maturityDate = params.maturityDate? new Date().parse("MM/dd/yyyy", params.maturityDate) : null
        htmInstance.maturityValue = params.maturityValue? (params.maturityValue.replaceAll(",","")).toDouble() : 0.00D
        htmInstance.reference = params.reference
        htmInstance.remarks = params.remarks
        htmInstance.valueDate = params.valueDate? new Date().parse("MM/dd/yyyy", params.valueDate) : null
        htmInstance.status = ConfigItemStatus.get(2)
        htmInstance.residentType = ResidentType.get(params?.residentType.toInteger())
        htmInstance.htmIssuer = params?.htmIssuer
        htmInstance.htmTypeDesc = HtmType.get(params?.htmTypeDesc.toInteger())
        htmInstance.htmType = HtmType.get(params?.htmTypeDesc.toInteger()).description
        
        println("nagsave na siya: "+ params.valueDate)
        htmInstance.save(flush:true,failOnError:true)
        
        flash.message="HTM Details Successfully Updated"
        redirect(action: "show", controller: "assetsHtm",id:htmInstance.id)
                  
    }
    def reclassHtm(){
        println("========= RECLASS Assets Held to Maturity ===========")
        println("params: "+params)
        def assetsHeldToMaturityInstance = AssetsHeldToMaturity.get(params.id)
        [assetsHeldToMaturityInstance:assetsHeldToMaturityInstance]
    }
    def htmSaveReclass(){
        println("============= SAVE HTM RECLASS ===========")
        println("params: "+params)
        def assetsHeldToMaturityInstance = AssetsHeldToMaturity.get(params.assestsHeldToMaturityId.toInteger())
        //=========== get reclass Assets Held to Maturity =================
        def b = Branch.get(1)
        def arCrReclassTemplate = Institution.findByParamCode("GLS.60470").paramValue
        def t = TxnTemplate.get(arCrReclassTemplate.toInteger())
        
        def tx  = new TxnFile(txnCode:t.code,txnDescription:t.description,txnDate:b.runDate,currency:assetsHeldToMaturityInstance.currency,
            txnAmt:assetsHeldToMaturityInstance.amount,txnRef:'HTM Reclassification',status:ConfigItemStatus.get(2), branch:assetsHeldToMaturityInstance.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:'HTM Reclassification',txnType:t.txnType,txnTemplate:t, 
            user:UserMaster.get(session.user_id))
        tx.save(flush:true, failOnError:true);
        
        // for debit
        def txnDr = new TxnBreakdown(branch:tx.branch, currency:assetsHeldToMaturityInstance.currency,debitAcct:params.reclassGlContra,
            debitAmt:assetsHeldToMaturityInstance.amount, txnCode:t.code, txnDate:b.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)

        

        def txnCr = new TxnBreakdown(branch:tx.branch, currency:tx.currency,creditAcct:assetsHeldToMaturityInstance.glCode,
            creditAmt:assetsHeldToMaturityInstance.amount, txnCode:t.code, txnDate:tx.txnDate, txnFile:tx, 
            user:UserMaster.get(session.user_id))      
        txnCr.save(flush:true)
        
        assetsHeldToMaturityInstance.glCode = params.reclassGlContra
        assetsHeldToMaturityInstance.save(flush:true)
        //===========================================
        flash.message = "HTM Successfully Reclassified"
        redirect(action: 'show',controller: 'assetsHtm',id:assetsHeldToMaturityInstance.id)
    }
    def generateHtmDiscountSchedule(AssetsHeldToMaturity assetsHeldToMaturityInstance){
        println("================== generateHtmDiscountSchedule =====================")
        println("params: "+params)
        
        def maturityDate = assetsHeldToMaturityInstance.maturityDate
        def valueDate = assetsHeldToMaturityInstance.valueDate
        def faceValueAmount = assetsHeldToMaturityInstance.amount
        def totalDiscount = assetsHeldToMaturityInstance.discountAmount
        def term = maturityDate - valueDate
        def divisor = 360
        def interestRate = assetsHeldToMaturityInstance.interestRate
        def effectiveYield = assetsHeldToMaturityInstance.effectiveYield
        
        
        println("maturityDate: "+maturityDate)
        println("valueDate: "+valueDate)
        println("faceValueAmount: "+faceValueAmount)
        println("totalDiscount: "+totalDiscount)
        println("term: "+term)
        println("divisor: "+divisor)
        println("interestRate: "+interestRate)
        println("effectiveYield: "+effectiveYield)
        def theFirstDate = valueDate
        def calendar = new GregorianCalendar()
        calendar.setTime(theFirstDate)
        
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        
        def endOfMonth = calendar.getTime()
        def discountAmountOverTerm = totalDiscount / term
        def discountAmountPerSched = 0.00D
        println("discountAmountPerSched: "+discountAmountOverTerm)
        def schedDateDiffrenceToValueDate = endOfMonth - valueDate
        println("endOfMonth: "+endOfMonth)
        println("valueDate: "+valueDate)
        println("schedDateDiffrenceToValueDate: "+schedDateDiffrenceToValueDate)
        discountAmountPerSched = discountAmountOverTerm * schedDateDiffrenceToValueDate
        println("schedDateDiffrenceToValueDate: "+schedDateDiffrenceToValueDate)
        println("discountAmountPerSched: "+discountAmountPerSched)
        discountAmountPerSched = discountAmountPerSched.round(2)
        
        while(theFirstDate<=maturityDate){
            
            println("********************************************************************")
            
            def htmScheduleInstance = new HtmSchedule()
                htmScheduleInstance.assetsHeldToMaturity = assetsHeldToMaturityInstance
                htmScheduleInstance.xhtmScheduleDate = endOfMonth
                if(endOfMonth > maturityDate){
                    htmScheduleInstance.xhtmScheduleDate = maturityDate
                }
                
                htmScheduleInstance.amount = discountAmountPerSched
                htmScheduleInstance.status = ConfigItemStatus.get(2)
            htmScheduleInstance.save(flush: true)
            
            println("The HTM Schedule Date: "+endOfMonth)
            println("discountAmountPerSched: "+discountAmountPerSched)
            
            def oldSchedDate = endOfMonth
            
            
            
            calendar.add(Calendar.MONTH, 1)																       
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            endOfMonth = calendar.getTime()
            
            if(endOfMonth > maturityDate){
                endOfMonth = maturityDate
            }
            discountAmountPerSched = (endOfMonth - oldSchedDate) * discountAmountOverTerm
            discountAmountPerSched = discountAmountPerSched.round(2)
  
            theFirstDate += 30
        }
        
    }
}
