package icbs.loans
import static org.springframework.http.HttpStatus.*

import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.lov.DepositStatus
import icbs.tellering.TxnFile
import icbs.tellering.TxnLoanPaymentDetails
import icbs.admin.Currency
import icbs.admin.TxnTemplate
import icbs.lov.TxnType
import icbs.gl.GlAccount
import icbs.admin.Branch
import icbs.admin.Product
import icbs.lov.ConfigItemStatus
import icbs.tellering.TxnBreakdown
import icbs.lov.LoanAcctStatus
import icbs.lov.ProductType
import icbs.admin.Product
import icbs.lov.LoanCollateralStatus
import icbs.gl.CfgAcctGlTemplateDet
import icbs.loans.ROPA
import icbs.loans.ROPALedger
import icbs.loans.RopaCollateralDetails
import icbs.loans.RopaSaleDetails
import icbs.loans.Collateral
import icbs.loans.CollateralHistory
import icbs.lov.LoanCollateralStatus
import icbs.loans.LoanApplication
import icbs.admin.Institution
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.lang.*
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.sql.Sql
import icbs.gl.InterBranchPointer
import icbs.loans.RopaAccumulatedDepreciation
import icbs.loans.RopaAllowanceLedger
@Transactional(readOnly = true)
class RopaController {
    def loanService
    def glTransactionService
    def jrxmlTcId
    def jasperService
    def transactionFileId
    def dataSource
    def auditLogService
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]

   def index(Integer max) {
        
        params.max = Math.min(max ?: 10, 100)
 
        def ColumnName = "id"
        def ColumnOrderBy = "desc"
        if (params.query == null) {  // show all instances  
           
            println("clickable sort column: "+params)
           if(params.sort==null){
                 ColumnName = "id"
                 ColumnOrderBy = "asc"
           }else{
                 ColumnName = params.sort
                 ColumnOrderBy = params.order
           }

            def RopaInstanceList = RopaCollateralDetails.createCriteria().list(params) {
                and {
                    gt("status",LoanCollateralStatus.read(5))
                }
                order("id", "asc")
            }
            println("result value: "+RopaInstanceList)
            //respond GlContigentAccountList, model:[BranchInstanceCount: GlContigentAccountList.totalCount]
            [RopaInstanceList:RopaInstanceList,BranchInstanceCount: RopaInstanceList.totalCount,]
        }else{
             def RopaInstanceList = RopaCollateralDetails.createCriteria().list(params) {
                 or {
                    ilike("formerTitle", "%${params.query}%")
                    ilike("kindOfLand", "%${params.query}%")
                    ilike("location", "%${params.query}%")
                } 
                and {
                    gt("status",LoanCollateralStatus.read(5))
                }
                order("id", "asc")
            }
           [RopaInstanceList:RopaInstanceList,BranchInstanceCount: RopaInstanceList.totalCount]
        }  
    }
    
    def indexScr(Integer max) {
        println("params: "+params)
        params.max = Math.min(max ?: 10, 100)


        if (params.sort == null) {  // default ordering
            //params.sort = "code"
        }

        if (params.query == null || params.query  == "") {  // show all instances 
            println("andito ako ")
            def ropaSaleDetailsList = RopaSaleDetails.createCriteria().list(params) {
                gt("scrAmount",0.00D)
                order("id", "asc")
            }
            respond ropaSaleDetailsList, model:[ropaSaleDetailsList: ropaSaleDetailsList,ropaSaleDetailsInstanceCount: ropaSaleDetailsList.totalCount]
        }
        else {    // show query results
            println("boom")
            def c = RopaSaleDetails.createCriteria()
            def ropaSaleDetailsList = c.list (params) {
                ilike("scrAccountNo","%"+params.query+"%")
                and {
                    gt("scrAmount",0.00D)
                }
                order("id", "asc")
            }
            
            println("ropaSaleDetailsList: "+ropaSaleDetailsList)
            respond ropaSaleDetailsList, model:[ropaSaleDetailsList: ropaSaleDetailsList,ropaSaleDetailsInstanceCount: ropaSaleDetailsList.totalCount]
        }
        return
    }

    def create(){
        respond new ROPA(params)
    }

   @Transactional
    def save() {
        def loan = Loan.get(params.loanID.toInteger())
            def ropaInstance = new ROPA()

                ropaInstance.loan = loan
                ropaInstance.glContraLitigationExp = Institution.findByParamCode('GLS.60560').paramValue
                ropaInstance.glContraRopa = Institution.findByParamCode('GLS.60550').paramValue
                ropaInstance.glContraBldg = Institution.findByParamCode('GLS.60570').paramValue
                ropaInstance.ropaIncome = Institution.findByParamCode('GLS.60590').paramValue
                ropaInstance.otherAccumlated = Institution.findByParamCode('GLS.60610').paramValue
                ropaInstance.otherGl = Institution.findByParamCode('GLS.60600').paramValue
                ropaInstance.accumulatedDepreciation = Institution.findByParamCode('GLS.60580').paramValue

                ropaInstance.ropaDate = loan.branch.runDate
                ropaInstance.acquiredFrom = loan.customer
                ropaInstance.customerDisplayName = loan.customer.displayName
                ropaInstance.loanAcctNo = loan.accountNo

                ropaInstance.branch = loan.branch
                ropaInstance.dateCreated = loan.branch.runDate
                ropaInstance.runDateCreated = loan.branch.runDate

                ropaInstance.createdBy = UserMaster.get(session.user_id)

            if (ropaInstance == null) {
                notFound()
                return
            }
            if (ropaInstance.hasErrors()) {
                println 'ERRORS'
                println ropaInstance.errors
                respond ropaInstance.errors, view:'create'
                return
            }
            def ropaLoan = ROPA.findAllByLoan(loan)
            if (ropaLoan){
                flash.message = 'Loan already transferred to ROPA!'
                respond ropaInstance.errors, view:'create'
                return
            }
        if (loan.balanceAmount == 0.00D) {
            flash.message = 'Loan has no balance to transfer!'
            respond ropaInstance.errors, view:'create'
            return
        }
        if (loan.status.id >= 6){
            flash.message = 'Loan has invalid status!'
            respond ropaInstance.errors, view:'create'
            return
        }
        if (!loan.loanApplication.collaterals) {
            flash.message = 'Loan has no linked collateral!'
            respond ropaInstance.errors, view:'create'
            return
        }
        ropaInstance.save(flush:true, failOnError:true)
        //createLoanHistoryEntry(loanInstance)
        def balance = loan.balanceAmount
        //loan.status = LoanAcctStatus.get(7)
        def amount = balance
        def credit = loan.balanceAmount - balance
        //loan.balanceAmount = credit
        loan.statusChangedDate = loan.branch.runDate

        //Loan Collateral
        //def collId = LoanApplication.collaterals{}
        println("collateral" + loan.loanApplication.collaterals)
        for(collaterals in loan.loanApplication.collaterals) {
            def collId = collaterals
            collId.status = LoanCollateralStatus.get(6)
            collId.save(flush:true, failOnError:true)

            println("Collateral ID ====>" + collId)

            def collList = new RopaCollateralDetails()
                collList.ropa = ropaInstance
                collList.loan = loan
                collList.collateral = collId
                collList.refDate = loan.branch.runDate
                collList.status = LoanCollateralStatus.get(1)
                if(collId.rem == null){
                    collList.formerTitle = null
                    collList.kindOfLand = null
                    collList.landAppraisal = null
                    collList.landArea = null
                    collList.location = null
                    collList.save(flush:true, failOnError:true)
                }else{
                    //insert Other Collateral Details
                    collList.formerTitle = collId.rem.tctNo
                    collList.kindOfLand = collId.description
                    collList.landAppraisal = collId.appraisedValue
                    collList.landArea = collId.rem.landArea
                    collList.location = collId.rem.location
                    collList.save(flush:true, failOnError:true)
                }

            def collHist = new CollateralHistory(collateral:collId, refDate:loan.branch.runDate,
                description:'Collateral transferred to ROPA '+ropaInstance, user:UserMaster.get(session.user_id))

            collId.status = LoanCollateralStatus.get(6)
            collId.save(flush:true, failOnError:true)
        }
        //loanService.commitLoanHistoryEntry("Transfer to ROPA" )
        loan.save(flush:true,failOnError:true)
        redirect(action: "show", id: ropaInstance.id, params: [id: ropaInstance.id])
        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ropaInstance.label', default: 'ROPA'), ropaInstance.id])
                redirect ropaInstance
            }
            '*' { respond ropaInstance, [status: CREATED] }
        } */
    }

    def show(ROPA ropaInstance){
        println("params: "+params)
        def ropapapapaInstance = ROPA.get(params.id.toInteger())
        [ropapapapaInstance:ropapapapaInstance]
    }

    def ropaSaleCash(){
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
        return [collateralInstance:collateralInstance]
    }
    
    def ropaSaleInst(){
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
        return [collateralInstance:collateralInstance]
    }
    
    @Transactional
    def saveRopaSaleCash(){
        println("saveRopaSaleCash() params: "+params)
        def bankRopaAgent = UserMaster.get(params.agent.id.toInteger())
        def ropaCollateral = RopaCollateralDetails.get(params.id.toInteger())
        def findCollateral = ropaCollateral.collateral
        def salePrice = params.sellingPrice ? (params.sellingPrice.toString().replaceAll(",","")).toDouble() : 0.00D
        //def accDep = params.accumulatedDepreciation ? (params.accumulatedDepreciation.toString().replaceAll(",","")).toDouble() : 0.00D
        //def grt = params.grt ? (params.grt.toString().replaceAll(",","")).toDouble() : 0.00D
        def commissions = params.commission ? (params.commission.toString().replaceAll(",","")).toDouble() : 0.00D
        def ropaTransfer = RopaTransfer.findByRopaCollateralDetails(ropaCollateral)
        def ropaBranch = ropaTransfer.loan.branch
        def processBranch = UserMaster.get([session.user_id]).branch

        def collateralInstance = null
        // save to Ropa Sale Details
        def ropaAmt = ropaCollateral.ropaLandAmt
        def ropaBldgAmt = ropaCollateral.ropaBldgAmt
        def ropaOtherAmt = ropaCollateral.ropaOtherAmt
        def totRopa = ropaAmt + ropaBldgAmt + ropaOtherAmt

        def accDepBldg = ropaCollateral.buildingAccDepreciation
        def accDepOthers = ropaCollateral.otherAccDepreciation
        def accDep = accDepBldg + accDepOthers

        def gainRopa = salePrice + accDep - totRopa - commissions
        def grt = gainRopa * 0.07
        grt = grt.round(2)

        def dueToHo = totRopa - accDep

        // inter-branch for head office
        def ho = Branch.get(Institution.findByParamCode('GEN.10260').paramValue.toInteger())
        def hoCr = InterBranchPointer.get(ropaBranch.id).creditPointer
        def hoDr = InterBranchPointer.get(processBranch.id).debitPointer
        def commGl = Institution.findByParamCode('GLS.60510').paramValue

        def ropaLandGl = ropaTransfer.ropa.glContraRopa
        def ropaBldgGl = ropaTransfer.ropa.glContraBldg
        def otherRopaGl = ropaTransfer.ropa.otherGl
        def ropaIncomeGl = ropaTransfer.ropa.ropaIncome
        def accDepBldgGl = ropaTransfer.ropa.accumulatedDepreciation
        def accDepOtherGl = ropaTransfer.ropa.otherAccumlated

        def txnTmp = TxnTemplate.get(params?.txnType.toInteger())
        def taxDr = Institution.findByParamCode('GLS.60520').paramValue
        def taxCr = Institution.findByParamCode('GLS.60530').paramValue

        /*def oldApplication = RopaSaleDetails.findAllByLoanApplication(LoanApplication.get(params?.loanApplication))
        if (oldApplication) {
            for (oa in oldApplication){
                if (oa.txnFile.status.id != 4){
                    flash.message = 'SCR Application ALready used in previous cash sale transaction!|error|alert'
                    render(view: 'ropaSaleCash', model: [collateralInstance:ropaCollateral])
                    return
                }    
            }
        }*/
        
        if (salePrice  < totRopa) {
            flash.message = 'Sale price cannot be less than ROPA Amount!|error|alert'
            render(view: 'ropaSaleCash', model: [collateralInstance:ropaCollateral])
            return
        }


        if (accDep > ropaBldgAmt){
            flash.message = 'Accumulated depreciation cannot be greater than Building Amount!|error|alert'
            render(view: 'ropaSaleCash', model: [collateralInstance:ropaCollateral])
            return
        }
        if (commissions > (salePrice + accDep - totRopa)){
            flash.message = 'Commission cannot be greater than net gain!|error|alert'
            render(view: 'ropaSaleCash', model: [collateralInstance:ropaCollateral])
            return
        }
        def lnApp = LoanApplication.get(params?.loanApplication.toInteger())
        def tx = new TxnFile(currency:ropaTransfer.txnFile.currency, user:UserMaster.get(session.user_id),
            branch:UserMaster.get(session.user_id).branch, txnAmt:salePrice,beneficiary:lnApp.customer,
            txnCode:txnTmp.code, txnDate:ropaTransfer.loan.branch.runDate, txnTimestamp:new Date().toTimestamp(),
            txnDescription:txnTmp.description, status:ConfigItemStatus.get(2),
            txnType:txnTmp.txnType, txnParticulars:params.particulars, txnRef:params.reference)
        tx.save(flush:true, failOnError:true)

        if (ropaBranch.id != processBranch.id){
            // interbranch  --- ROPA Branch
            // debit due branch
            def dueToDr = InterBranchPointer.findByBranch(processBranch).creditPointer
            if (ropaBranch.id != ho.id && processBranch.id != ho.id){
                dueToDr = ho.dueFromGl.code
            }
            def txnBrDr = new TxnBreakdown(branch:ropaBranch, debitAcct:dueToDr,
                debitAmt:dueToHo, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrDr.save(flush:true, failOnError:true)

            // accumulated dep
            if (accDepBldg > 0.00D){
                def txnBr2AccDr = new TxnBreakdown(branch:ropaBranch, debitAcct:accDepBldgGl,
                    debitAmt:accDepBldg, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBr2AccDr.save(flush:true, failOnError:true)
            }

            if (accDepOthers > 0.00D){

                def txnBr2OthDr = new TxnBreakdown(branch:ropaBranch, debitAcct:accDepOtherGl,
                    debitAmt:accDepOthers, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBr2OthDr.save(flush:true, failOnError:true)
            }

            // credit ropa
            def br2TbDr = new TxnBreakdown(branch:ropaBranch, creditAcct:ropaLandGl,
                creditAmt:ropaAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            br2TbDr.save(flush:true, failOnError:true)

            // credit ropa bldg
            if (ropaBldgAmt > 0.00D){
                def br2BldgTbCr = new TxnBreakdown(branch:ropaBranch, creditAcct:ropaBldgGl,
                    creditAmt:ropaBldgAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                br2BldgTbCr.save(flush:true, failOnError:true)
            }
            // credit ropa other
            if (ropaOtherAmt > 0.00D){
                def br2OtherTbCr = new TxnBreakdown(branch:ropaBranch, creditAcct:otherRopaGl,
                    creditAmt:ropaOtherAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                br2OtherTbCr.save(flush:true, failOnError:true)
            }

            // interbranch  --- branch 1
            // Process Branch
            // debit ROPA
            def txnBrRopaDr = new TxnBreakdown(branch:processBranch, debitAcct:ropaLandGl,
                debitAmt:ropaAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrRopaDr.save(flush:true, failOnError:true)

            if (ropaBldgAmt > 0.00D){
                // ropa building
                def txnBrBldgDr = new TxnBreakdown(branch:processBranch, debitAcct:ropaBldgGl,
                    debitAmt:ropaBldgAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrBldgDr.save(flush:true, failOnError:true)
            }

            if (ropaOtherAmt > 0.00D){
                // ropa building
                def txnBrOthDr = new TxnBreakdown(branch:processBranch, debitAcct:otherRopaGl,
                    debitAmt:ropaOtherAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrOthDr.save(flush:true, failOnError:true)
            }
            // accumulated dep
            if (accDepBldg > 0.00D){
                def txnBrAccCr = new TxnBreakdown(branch:processBranch, creditAcct:accDepBldgGl,
                    creditAmt:accDepBldg, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrAccCr.save(flush:true, failOnError:true)
            }
            if (accDepOthers > 0.00D){
                def txnBrAccOthCr = new TxnBreakdown(branch:processBranch, creditAcct:accDepOtherGl,
                    creditAmt:accDepOthers, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrAccOthCr.save(flush:true, failOnError:true)
            }
            // due to head office
            def dueToCr = InterBranchPointer.findByBranch(ropaBranch).creditPointer
            if (ropaBranch.id != ho.id && processBranch.id != ho.id){
                dueToCr = ho.dueFromGl.code
            }
            def txnBrCr = new TxnBreakdown(branch:processBranch, creditAcct:dueToCr,
                creditAmt:dueToHo, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrCr.save(flush:true, failOnError:true)
        }

        // ROPA SALE
        // debit sale price
        def txnSaleDr = new TxnBreakdown(branch:processBranch, debitAcct:txnTmp.defContraAcct, debitAmt:salePrice,
            currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
        txnSaleDr.save(flush:true, failOnError:true)

        // accumulated dep
        if (accDepBldg > 0.00D){
            def txnBrAccDr = new TxnBreakdown(branch:processBranch, debitAcct:accDepBldgGl,
                debitAmt:accDepBldg, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrAccDr.save(flush:true, failOnError:true)
        }
        if (accDepOthers > 0.00D){
            def txnBrAccDr = new TxnBreakdown(branch:processBranch, debitAcct:accDepOtherGl,
                debitAmt:accDepOthers, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrAccDr.save(flush:true, failOnError:true)
        }
        // credit ROPA
        // ROPA Land
        def txnCrRopa = new TxnBreakdown(branch:processBranch, creditAcct:ropaLandGl,
            creditAmt:ropaAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
        txnCrRopa.save(flush:true, failOnError:true)

        if (ropaBldgAmt > 0.00D){
            // ropa building
            def txnBldgCr = new TxnBreakdown(branch:processBranch, creditAcct:ropaBldgGl,
                creditAmt:ropaBldgAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBldgCr.save(flush:true, failOnError:true)
        }
        if (ropaOtherAmt > 0.00D){
            // ropa building
            def txnOtherCr = new TxnBreakdown(branch:processBranch, creditAcct:otherRopaGl,
                creditAmt:ropaOtherAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnOtherCr.save(flush:true, failOnError:true)
        }
        // commission
        if (commissions > 0.00D){
            def crComm = new TxnBreakdown(branch:processBranch, creditAcct:commGl, creditAmt:commissions,
                    currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            crComm.save(flush:true, failOnError:true)
        }

        if (gainRopa > 0.00D){
            def txnBrGainCr = new TxnBreakdown(branch:processBranch, creditAcct:ropaIncomeGl,
                creditAmt:gainRopa, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrGainCr.save(flush:true, failOnError:true)
        }
        if (grt > 0.00D){
            def tbTaxDr = new TxnBreakdown(branch:processBranch, debitAcct:taxDr, debitAmt:grt,
                    currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            tbTaxDr.save(flush:true, failOnError:true)
            def tbTaxCr = new TxnBreakdown(branch:processBranch, creditAcct:taxCr, creditAmt:grt,
                currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            tbTaxCr.save(flush:true, failOnError:true)
        }
        if (ropaBranch.id != ho.id && processBranch.id != ho.id && processBranch.id != ropaBranch.id){
            def hoTbDr = new TxnBreakdown(branch:ho,debitAcct:hoDr, debitAmt:dueToHo,
                currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            hoTbDr.save(flush:true, failOnError:true)

            def hoTbCr = new TxnBreakdown(branch:ho, creditAcct:hoCr, creditAmt:dueToHo,
                currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            hoTbCr.save(flush:true, failOnError:true)
        }

        ropaCollateral.ropaLandAmt = 0.00D
        ropaCollateral.ropaBldgAmt = 0.00D
        ropaCollateral.ropaOtherAmt = 0.00D
        ropaCollateral.buildingAccDepreciation = 0.00D
        ropaCollateral.otherAccDepreciation = 0.00D
        ropaCollateral.status = LoanCollateralStatus.read(7)
        ropaCollateral.save(flush:true)

        findCollateral.status = LoanCollateralStatus.read(3)
        findCollateral.save(flush:true)

        //salePrice/commissions/ropaBranch/processBranch/ropaAmt/ropaBldgAmt/ropaOtherAmt/accDep/gainRopa
        //accDepBldg + accDepOthers
        
        def ropaSaleDetailsInstance = new RopaSaleDetails(ropa: ropaTransfer.ropa,collateral: ropaCollateral.collateral,
            saleAmount: salePrice,accumulatedDepreciation:accDep,grossReceiptsTax:grt,commission:commissions,particulars:params?.particulars,
            reference: params?.reference,incomeAmount:gainRopa,txnFile:tx, ropaCollateralDetails: ropaCollateral,loanApplication:params?.loanApplication,
            ropaLandAmt: ropaAmt,ropaBldgAmt: ropaBldgAmt,ropaOtherAmt: ropaOtherAmt,accDepBldg: accDepBldg,accDepOther: accDepOthers,
            ropaBranch: ropaBranch,processBranch: processBranch,agent: bankRopaAgent)

        ropaSaleDetailsInstance.save(flush:true,failOnError:true)

        flash.message="Ropa Successfully Sold."
        redirect(action: "collateralShow",controller:"ropa",id:ropaCollateral.id)
    }

    @Transactional
    def saveRopaSaleInst(){
        println("saveRopaSaleInst() params: "+params)
        def bankRopaAgent = UserMaster.get(params.agent.id.toInteger())
        def ropaCollateral = RopaCollateralDetails.get(params.id.toInteger())
        def findCollateral = ropaCollateral.collateral

        def salePrice = params.sellingPrice ? (params.sellingPrice.toString().replaceAll(",","")).toDouble() : 0.00D
        //def accDep = params.accumulatedDepreciation ? (params.accumulatedDepreciation.toString().replaceAll(",","")).toDouble() : 0.00D
        //def grt = params.grt ? (params.grt.toString().replaceAll(",","")).toDouble() : 0.00D
        def commissions = params.commission ? (params.commission.toString().replaceAll(",","")).toDouble() : 0.00D
        def ropaTransfer = RopaTransfer.findByRopaCollateralDetails(ropaCollateral)

        def ropaBranch = ropaTransfer.loan.branch
        def processBranch = UserMaster.get([session.user_id]).branch
        //def gainRopa = 0.00D
        def loanApplication = LoanApplication.get(params?.loanApplication)
        def loan = Loan.findByLoanApplication(loanApplication)
        def scr = Loan.findByLoanApplication(loanApplication)

        def scrDiscount = params.scrDiscount ? (params.scrDiscount.toString().replaceAll(",","")).toDouble() : 0.00D
        def downPayment = params.downPayment ? (params.downPayment.toString().replaceAll(",","")).toDouble() : 0.00D

        def scrAmt = salePrice - downPayment
        def ropaAmt = ropaCollateral.ropaLandAmt
        def ropaBldgAmt = ropaCollateral.ropaBldgAmt
        def ropaOtherAmt = ropaCollateral.ropaOtherAmt
        def totRopa = ropaAmt + ropaBldgAmt + ropaOtherAmt

        def accDepBldg = ropaCollateral.buildingAccDepreciation
        def accDepOthers = ropaCollateral.otherAccDepreciation
        def accDep = accDepBldg + accDepOthers

        def gainRopa = salePrice + accDep - totRopa - scrDiscount - commissions
        def grt = gainRopa * 0.07
        grt = grt.round(2)
        def dueToHo = totRopa - accDep

        // inter-branch for head office
        def ho = Branch.get(Institution.findByParamCode('GEN.10260').paramValue.toInteger())
        def hoCr = InterBranchPointer.get(ropaBranch.id).creditPointer
        def hoDr = InterBranchPointer.get(processBranch.id).debitPointer
        def commGl = Institution.findByParamCode('GLS.60510').paramValue

        def ropaLandGl = ropaTransfer.ropa.glContraRopa
        def ropaBldgGl = ropaTransfer.ropa.glContraBldg
        def otherRopaGl = ropaTransfer.ropa.otherGl
        def ropaIncomeGl = ropaTransfer.ropa.ropaIncome
        def accDepBldgGl = ropaTransfer.ropa.accumulatedDepreciation
        def accDepOtherGl = ropaTransfer.ropa.otherAccumlated

        // save to Ropa Sale Details
        if (salePrice  < (ropaAmt + ropaBldgAmt + ropaOtherAmt)) {
            flash.message = 'Sale price cannot be less than ROPA Amount!|error|alert'
            render(view: 'ropaSaleInst', model: [collateralInstance:ropaCollateral])
            return
        }

        if (grt >= salePrice){
            flash.message = 'Gross Receipts Tax cannot be greater than sale price!|error|alert'
            render(view: 'ropaSaleInst', model: [collateralInstance:ropaCollateral])
            return
        }

        if (accDep > ropaBldgAmt){
            flash.message = 'Accumulated depreciation cannot be greater than Building Amount!|error|alert'
            render(view: 'ropaSaleInst', model: [collateralInstance:ropaCollateral])
            return
        }

        if (scr.status.id != 3){
            flash.message = 'SCR not yet approved!|error|alert'
            render(view: 'ropaSaleInst', model: [collateralInstance:ropaCollateral])
            return
        }
        if (scr.grantedAmount != (scrAmt + scr.balanceAmount)){
            flash.message = 'Amount does not match loan granted!|error|alert'
            render(view: 'ropaSaleInst', model: [collateralInstance:ropaCollateral])
            return
        }

        def txnTmp = TxnTemplate.get(params?.txnType.toInteger())
        def taxDr = Institution.findByParamCode('GLS.60520').paramValue
        def taxCr = Institution.findByParamCode('GLS.60530').paramValue

        def tx = new TxnFile(acctNo:scr.accountNo, loanAcct:scr,
            currency:ropaTransfer.txnFile.currency, user:UserMaster.get(session.user_id),
            branch:UserMaster.get(session.user_id).branch, txnAmt:salePrice,
            txnCode:txnTmp.code, txnDate:scr.branch.runDate, txnTimestamp:new Date().toTimestamp(),
            txnDescription:txnTmp.description, status:ConfigItemStatus.get(2),
            txnType:txnTmp.txnType, txnParticulars:params.particulars, txnRef:params.reference)
        tx.save(flush:true, failOnError:true)

        if (ropaBranch.id != processBranch.id){
            // interbranch  --- ROPA Branch
            // debit due branch
            def dueToDr = InterBranchPointer.findByBranch(processBranch).creditPointer
            if (ropaBranch.id != ho.id && processBranch.id != ho.id){
                dueToDr = ho.dueFromGl.code
            }
            def txnBrDr = new TxnBreakdown(branch:ropaBranch, debitAcct:dueToDr,
                debitAmt:dueToHo, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrDr.save(flush:true, failOnError:true)

            // accumulated dep
            if (accDepBldg > 0.00D){
                def txnBr2AccDr = new TxnBreakdown(branch:ropaBranch, debitAcct:accDepBldgGl,
                    debitAmt:accDepBldg, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBr2AccDr.save(flush:true, failOnError:true)
            }
            if (accDepOthers > 0.00D){

                def txnBr2OthDr = new TxnBreakdown(branch:ropaBranch, debitAcct:accDepOtherGl,
                    debitAmt:accDepOthers, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBr2OthDr.save(flush:true, failOnError:true)
            }

            // credit ropa
            def br2TbCr = new TxnBreakdown(branch:ropaBranch, creditAcct:ropaLandGl,
                    creditAmt:ropaAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            br2TbCr.save(flush:true, failOnError:true)

            // credit ropa bldg
            if (ropaBldgAmt > 0.00D){
                def br2BldgTbCr = new TxnBreakdown(branch:ropaBranch, creditAcct:ropaBldgGl,
                    creditAmt:ropaBldgAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                br2BldgTbCr.save(flush:true, failOnError:true)
            }
            // credit ropa other
            if (ropaOtherAmt > 0.00D){
                def br2OtherTbCr = new TxnBreakdown(branch:ropaBranch, creditAcct:otherRopaGl,
                    creditAmt:ropaOtherAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                br2OtherTbCr.save(flush:true, failOnError:true)
            }

            // interbranch  --- branch 1
            // Process Branch
            // debit ROPA
            def txnBrRopaDr = new TxnBreakdown(branch:processBranch, debitAcct:ropaLandGl,
                    debitAmt:ropaAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrRopaDr.save(flush:true, failOnError:true)

            if (ropaBldgAmt > 0.00D){
                // ropa building
                def txnBrBldgDr = new TxnBreakdown(branch:processBranch, debitAcct:ropaBldgGl,
                    debitAmt:ropaBldgAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrBldgDr.save(flush:true, failOnError:true)

            }

            if (ropaOtherAmt > 0.00D){
                // ropa building
                def txnBrOthDr = new TxnBreakdown(branch:processBranch, debitAcct:otherRopaGl,
                    debitAmt:ropaOtherAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrOthDr.save(flush:true, failOnError:true)
            }
            // accumulated dep
            if (accDepBldg > 0.00D){
                def txnBrAccCr = new TxnBreakdown(branch:processBranch, creditAcct:accDepBldgGl,
                    creditAmt:accDepBldg, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrAccCr.save(flush:true, failOnError:true)
            }
            if (accDepOthers > 0.00D){
                def txnBrAccOthCr = new TxnBreakdown(branch:processBranch, creditAcct:accDepOtherGl,
                    creditAmt:accDepOthers, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
                txnBrAccOthCr.save(flush:true, failOnError:true)
            }
            // due to head office

            def dueToCr = InterBranchPointer.findByBranch(ropaBranch).creditPointer
            if (ropaBranch.id != ho.id && processBranch.id != ho.id){
                dueToCr = ho.dueFromGl.code
            }
            def txnBrCr = new TxnBreakdown(branch:processBranch, creditAcct:dueToCr,
                    creditAmt:dueToHo, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrCr.save(flush:true, failOnError:true)
        }

        // ROPA SALE
        // debit downpayment
        def txnSaleDr = new TxnBreakdown(branch:processBranch, debitAcct:txnTmp.defContraAcct, debitAmt:downPayment,
            currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
        txnSaleDr.save(flush:true, failOnError:true)

        // debit scr
        def scrGl = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(loan.glLink, '0',loan.loanPerformanceId.id).glCode
        def txnScrDr = new TxnBreakdown(branch:processBranch, debitAcct:scrGl, debitAmt:scrAmt,
            currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
        txnScrDr.save(flush:true, failOnError:true)

        // accumulated dep
        if (accDepBldg > 0.00D){
            def txnBrAccDr = new TxnBreakdown(branch:processBranch, debitAcct:accDepBldgGl,
                debitAmt:accDepBldg, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrAccDr.save(flush:true, failOnError:true)
        }
        if (accDepOthers > 0.00D){
            def txnBrAccDr = new TxnBreakdown(branch:processBranch, debitAcct:accDepOtherGl,
                debitAmt:accDepOthers, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrAccDr.save(flush:true, failOnError:true)
        }
        // credit ROPA
        // ROPA Land
        def txnCrRopa = new TxnBreakdown(branch:processBranch, creditAcct:ropaLandGl,
            creditAmt:ropaAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
        txnCrRopa.save(flush:true, failOnError:true)

        if (ropaBldgAmt > 0.00D){
            // ropa building
            def txnBldgCr = new TxnBreakdown(branch:processBranch, creditAcct:ropaBldgGl,
                creditAmt:ropaBldgAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBldgCr.save(flush:true, failOnError:true)
        }
        if (ropaOtherAmt > 0.00D){
            // ropa building
            def txnOtherCr = new TxnBreakdown(branch:processBranch, creditAcct:otherRopaGl,
                creditAmt:ropaOtherAmt, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnOtherCr.save(flush:true, failOnError:true)
        }

        // SCR Discount
        if (scrDiscount > 0.00D){
            def scrDiscountGl = Institution.findByParamCode('GLS.60540').paramValue
            def txnDiscCr = new TxnBreakdown(branch:processBranch, creditAcct:scrDiscountGl,
                creditAmt:scrDiscount, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnDiscCr.save(flush:true, failOnError:true)
        }
        // commission
        if (commissions > 0.00D){
            def crComm = new TxnBreakdown(branch:processBranch, creditAcct:commGl, creditAmt:commissions,
                    currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            crComm.save(flush:true, failOnError:true)
        }

        if (gainRopa > 0.00D){
            def txnBrGainCr = new TxnBreakdown(branch:processBranch, creditAcct:ropaIncomeGl,
                creditAmt:gainRopa, currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            txnBrGainCr.save(flush:true, failOnError:true)
        }
        if (grt > 0.00D){
            def tbTaxDr = new TxnBreakdown(branch:processBranch, debitAcct:taxDr, debitAmt:grt,
                    currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            tbTaxDr.save(flush:true, failOnError:true)
            def tbTaxCr = new TxnBreakdown(branch:processBranch, creditAcct:taxCr, creditAmt:grt,
                currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            tbTaxCr.save(flush:true, failOnError:true)
        }

        if (ropaBranch.id != ho.id && processBranch.id != ho.id && processBranch.id != ropaBranch.id){
            def hoTbDr = new TxnBreakdown(branch:ho,debitAcct:hoDr, debitAmt:dueToHo,
                currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            hoTbDr.save(flush:true, failOnError:true)

            def hoTbCr = new TxnBreakdown(branch:ho, creditAcct:hoCr, creditAmt:dueToHo,
                currency:tx.currency, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            hoTbCr.save(flush:true, failOnError:true)
        }

        ropaCollateral.ropaLandAmt = 0.00D
        ropaCollateral.ropaBldgAmt = 0.00D
        ropaCollateral.ropaOtherAmt = 0.00D
        ropaCollateral.buildingAccDepreciation = 0.00D
        ropaCollateral.otherAccDepreciation = 0.00D
        ropaCollateral.status = LoanCollateralStatus.read(8)
        ropaCollateral.save(flush:true)

        ropaCollateral.status = LoanCollateralStatus.read(7)
        ropaCollateral.save(flush:true)

        findCollateral.status = LoanCollateralStatus.read(2)
        findCollateral.save(flush:true)

        def ropaSaleDetailsInstance = new RopaSaleDetails(ropa:ropaTransfer.ropa,collateral: ropaCollateral.collateral,
            saleAmount: salePrice,accumulatedDepreciation:accDep,grossReceiptsTax:grt,commission:commissions,particulars:params?.particulars,
            reference: params?.reference,incomeAmount:gainRopa,txnFile:tx,loanApplication:loanApplication, ropaCollateralDetails: ropaCollateral,
            scrDiscount:scrDiscount, downpayment:downPayment,scrAmount: scrAmt, loan:loan,
            ropaLandAmt: ropaAmt,ropaBldgAmt: ropaBldgAmt,ropaOtherAmt: ropaOtherAmt,accDepBldg: accDepBldg,accDepOther: accDepOthers,
            ropaBranch: ropaBranch,processBranch: processBranch,agent: bankRopaAgent)
        ropaSaleDetailsInstance.save(flush:true,failOnError:true)

        // process loan release
        scr.balanceAmount = scr.balanceAmount + scrAmt
        scr.totalDisbursementAmount = scr.totalDisbursementAmount + scrAmt
        scr.status = LoanAcctStatus.get(4)
        scr.save(flush:true, failOnError:true)

        def ll = new LoanLedger(loan: scr, txnFile: tx, txnDate: scr.branch.runDate,
            txnTemplate: txnTmp, txnRef: params.reference, principalDebit: scrAmt,
            principalBalance: scr.balanceAmount, txnParticulars:params.particulars)
        ll.save(flush:true,failOnError:true)

        loanApplication.addToCollaterals(findCollateral)
        loanApplication.save(flush:true,failOnError:true)
        
        flash.message="SCR Successfully Sold."
        redirect(action: "collateralShow",controller:"ropa",id:ropaCollateral.id)
    }



    @Transactional
    def cancelRopaSale(){
        println("cancelRopaSale params:"+params)
        def ropaSale = RopaSaleDetails.get(params.ropaSaleId.toInteger())
        def tx = ropaSale.txnFile
        
        if (ropaSale.ropaCollateralDetails.status.id != 7){
            flash.message = 'Cannot Cancel Transfer - Due to Invalid ROPA Status'
            render(view: "ropaSaleDetails", model: [ropaSaleInstance:ropaSale])
            return
        }
        
        tx.status = ConfigItemStatus.read(4)
        tx.save(flush:true, failOnError:true)
        
        def glEntries = TxnBreakdown.findAllByTxnFile(tx,[sort: "id", order: "desc"])
        for (g in glEntries) {
            def newGl = new TxnBreakdown(branch:g.branch, creditAcct:g.debitAcct, creditAmt:g.debitAmt,
                currency:g.currency, debitAcct:g.creditAcct, debitAmt:g.creditAmt, txnCode:g.txnCode,
                txnDate:g.branch.runDate, txnFile:g.txnFile, user:g.user)
            newGl.save(flush:true)
        }        
        
        // cancel loan release
        def scr = tx.loanAcct
        if (scr){
            scr.balanceAmount = scr.balanceAmount - ropaSale.scrAmount
            scr.totalDisbursementAmount = scr.totalDisbursementAmount - ropaSale.scrAmount
            scr.status = LoanAcctStatus.get(3)
            scr.save(flush:true, failOnError:true)
            
            def ll = new LoanLedger(loan: scr, txnFile: tx, txnDate: scr.branch.runDate,
                txnTemplate: tx.txnTemplate, txnRef: 'ROPA SALE INST CANCEL SCR ACCT - '+scr.accountNo, principalCredit: ropaSale.scrAmount,
                principalBalance: scr.balanceAmount, txnParticulars:'ROPA SALE INST CANCEL')
            ll.save(flush:true,failOnError:true)
        }
        
        def ropaCollateral = ropaSale.ropaCollateralDetails
        ropaCollateral.ropaLandAmt = ropaCollateral.ropaLandAmt + ropaSale.ropaLandAmt
        ropaCollateral.ropaBldgAmt = ropaCollateral.ropaBldgAmt + ropaSale.ropaBldgAmt
        ropaCollateral.ropaOtherAmt = ropaCollateral.ropaOtherAmt + ropaSale.ropaOtherAmt
        ropaCollateral.buildingAccDepreciation = ropaCollateral.buildingAccDepreciation + ropaSale.accDepBldg
        ropaCollateral.otherAccDepreciation = ropaCollateral.otherAccDepreciation + ropaSale.accDepOther
        ropaCollateral.status = LoanCollateralStatus.read(6)
        ropaCollateral.save(flush:true)
        
        flash.message = "ROPA Sale Successfully Cancelled."
        redirect(action: "collateralShow",controller:"ropa",id:ropaCollateral.id)
    }
    
    //Transfer to ROPA
    def transferToRopaGSP(){
        println("rdMontana ====================> Pumasok")
        println("params:"+params)
        def transferToRopaInstance = RopaCollateralDetails.get(params.id.toInteger()).ropa
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
        println("collateralInstance: "+collateralInstance)
        [transferToRopaInstance:transferToRopaInstance,collateralInstance:collateralInstance]
    }

    @Transactional
    def saveTransferToRopa(){
        println("rdMontana ==========> Pumasok sa saveTransferToRopa")
        println("params: "+ params)
        def collateralInstance = RopaCollateralDetails.get(params.collateral)
        println("collateralInstance: "+ collateralInstance)

        def getIdOfropa = collateralInstance.ropa
        def loan = getIdOfropa.loan
        def collateral = collateralInstance.collateral
        //def ropaLandAmt = params.ropaLandAmount ? (params.ropaLandAmount.toString().replaceAll(",","")).toDouble() : 0.00D
        //def ropabldgAmt = params.ropaBuildingAmount ? (params.ropaBuildingAmount.toString().replaceAll(",","")).toDouble() : 0.00D
        def marketValueLand = params.marketValueLand ? (params.marketValueLand.toString().replaceAll(",","")).toDouble() : 0.00D
        def marketValueBuilding = params.marketValueBuilding ? (params.marketValueBuilding.toString().replaceAll(",","")).toDouble() : 0.00D
        def marketValueOthers = params.otherPropertiesAcquired ? (params.otherPropertiesAcquired.toString().replaceAll(",","")).toDouble() : 0.00D
        def transferAmt = params.transferAmount ? (params.transferAmount.toString().replaceAll(",","")).toDouble() : 0.00D

        def totValue = marketValueLand + marketValueBuilding + marketValueOthers
        def ropaLand = transferAmt * (marketValueLand.div(totValue))
        def ropaBldg = transferAmt * (marketValueBuilding.div(totValue))
        def ropaOther = transferAmt * (marketValueOthers.div(totValue))

        ropaLand = ropaLand.round(2)
        ropaBldg = ropaBldg.round(2)
        ropaOther = ropaOther.round(2)
        if (ropaLand + ropaBldg + ropaOther != transferAmt){
            ropaLand = transferAmt - ropaBldg - ropaOther
        }

	ropaLand = ropaLand.round(2)
        ropaBldg = ropaBldg.round(2)
        ropaOther = ropaOther.round(2)

        def ropaLandGl = getIdOfropa.glContraRopa
        def ropaBldgGl = getIdOfropa.glContraBldg
        def ropaOtherGl = getIdOfropa.otherGl

        def txnTmp = TxnTemplate.get(params.txnType)
        //def txnAmt = ropaLandAmt + ropabldgAmt
        println("transferAmt: "+transferAmt)

        if (transferAmt > loan.balanceAmount){
            flash.message = "Txn Amount Greater than Loan Balance Amount"
            respond collateralInstance.errors, view:'transferToRopaGSP'
            return
        }

        if(loan.status.id == 8){
            flash.message = "ERROR: Loan already Written-Off"
            respond collateralInstance.errors, view:'transferToRopaGSP'
            return
        }

        def tx = new TxnFile(acctNo:loan.accountNo, loanAcct:loan,
            currency:loan.product.currency, user:UserMaster.get(session.user_id),
            branch:UserMaster.get(session.user_id).branch, txnAmt:transferAmt,
            txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnTimestamp:new Date().toTimestamp(),
            txnDescription:txnTmp.description, status:ConfigItemStatus.get(2),
            txnType:txnTmp.txnType, txnParticulars:params.particulars, txnRef:params.reference)
        tx.save(flush:true,failOnError:true)

         // txnDr ==>land, params.ropaLand
        def txnDr = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, debitAcct:ropaLandGl,
            debitAmt:ropaLand, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        if (ropaBldg > 0.00D){
            def txnDrBldg = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, debitAcct:ropaBldgGl,
                debitAmt:ropaBldg, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDrBldg.save(flush:true)
        }
        if (ropaOther > 0.00D){
            def txnDrOther = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, debitAcct:ropaOtherGl,
                debitAmt:ropaOther, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDrOther.save(flush:true)
        }
        def creditLoan = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(loan.glLink,'0',loan.loanPerformanceId.id)

        // txnCr => txnAmt
        def txnCr = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, creditAcct:creditLoan.glCode,
            creditAmt:transferAmt, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnCr.save(flush:true)

        //Saving of Parameters
        def transferToROPA = new RopaTransfer()
            transferToROPA.loan = loan
            transferToROPA.ropaCollateralDetails = collateralInstance
            transferToROPA.ropa = getIdOfropa
            transferToROPA.marketValueLand = marketValueLand
            transferToROPA.marketValueBuilding = marketValueBuilding
            transferToROPA.marketValueOther = marketValueOthers
            transferToROPA.ropaLandAmount = ropaLand
            transferToROPA.ropaBuildingAmount = ropaBldg
            transferToROPA.otherGlAmount = ropaOther
            transferToROPA.transferAmount = transferAmt
            transferToROPA.txnFile = tx
        transferToROPA.save(flush:true, failOnError:true)

        if (transferAmt >= loan.balanceAmount){
            // params.ropaBuilding
            loan.status = LoanAcctStatus.get(7)
            loan.interestBalanceAmount = 0.00D

            loan.penaltyBalanceAmount = 0.00D
            loan.serviceChargeBalanceAmount = 0.00D
            loan.overduePrincipalBalance = 0.00D
        }
        loan.balanceAmount = loan.balanceAmount - transferAmt
        loan.save(flush:true, failOnError:true)


        def ll = new LoanLedger(loan: loan, txnFile: tx, txnDate: loan.branch.runDate,
            txnTemplate: txnTmp, txnRef: params.reference, principalCredit: transferAmt,
            principalBalance: loan.balanceAmount, txnParticulars:params.particulars)
        ll.save(flush:true,failOnError:true)

        collateral.status = LoanCollateralStatus.get(6)
        collateral.save(flush:true, failOnError:true)

        collateralInstance.ropaLandAmt = collateralInstance.ropaLandAmt + ropaLand
        collateralInstance.ropaBldgAmt = collateralInstance.ropaBldgAmt + ropaBldg
        collateralInstance.ropaOtherAmt = collateralInstance.ropaOtherAmt + ropaOther
        collateralInstance.landAppraisal = marketValueLand
        collateralInstance.buildingAppraisal = marketValueBuilding
        collateralInstance.otherAppraisal = marketValueOthers
        collateralInstance.status = LoanCollateralStatus.get(6)
        collateralInstance.allowanceProbLoss = 0.00D
        collateralInstance.allowanceProbLossBldg = 0.00D
        collateralInstance.allowanceProbLossOtherProp = 0.00D
        collateralInstance.save(flush:true, failOnError:true)

        getIdOfropa.save(flush:true, failOnError:true)
        //redirect(controller: "ropa", action: "show", id: getIdOfropa, params: [collateralId: collateralInstance])
        //render(view:'/show', model: [ropaInstance:ropaInstance])
        flash.message = "Successfuly Tranfered."

        redirect(action: "collateralShow",controller:"ropa",id:collateralInstance.id)
        
    }
    
    def ropaForSale(Integer max){
        def ropaList = RopaCollateralDetails.findAllByStatus(LoanCollateralStatus.read(6))
        [ropaList:ropaList]
    }
    
    def edit(ROPA ropaInstance){
        //respond ropaInstance
        println("params: "+params)
        println("customerDisplayName: "+ropaInstance.customerDisplayName)
        def ropapapapaInstanceInstance = ROPA.get(params.id.toInteger())
        [ropapapapaInstanceInstance:ropapapapaInstanceInstance]
    }
    
    def editCollateral(){
        def collateralInstance = RopaCollateralDetails.get(params.id)
        println("collateralInstance: "+collateralInstance)
        [collateralInstance: collateralInstance]
    }
    
    def ropaDebitCap(){
        println("params: "+params)
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
        def ropadebitInstance = collateralInstance.ropa
        [ropadebitInstance:ropadebitInstance, collateralInstance:collateralInstance]
    }
    
    def viewMoreTransaction(ROPA ropaInstance){
        def moretramnsactionInstance = ROPA.get(params.id.toInteger())
        [moretramnsactionInstance:moretramnsactionInstance]
    }
    
    def ropaCreditCap(){
        println("params: "+params)
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
        def ropacreditInstance = collateralInstance.ropa
        [ropacreditInstance:ropacreditInstance, collateralInstance:collateralInstance]
    }

    @Transactional
    def taropaDebitSave(ROPA ropaInstance){
        println "pumasok"
        println ("params: "+params)
       
        def amountROPADebit  = params.ropadebit ? (params.ropadebit.replaceAll(",","")).toDouble() : 0.00D
        def ropaCollateral = RopaCollateralDetails.get(params.collID.toInteger())
        def ropaID = ropaCollateral.ropa
        def b = Branch.get(ropaCollateral.ropa.loan.branch.id)
        def txn = TxnTemplate.get(params.txnType.toInteger())
        println("amountROPADebit: "+amountROPADebit)
        println("opaCollateral.ropaLandAmt: "+ropaCollateral.ropaLandAmt)
        println("opaCollateral.ropaLandAmt: "+ropaCollateral.ropaBldgAmt)
        println("opaCollateral.ropaLandAmt: "+ropaCollateral.ropaOtherAmt)
        def totRopa = ropaCollateral.landAppraisal + ropaCollateral.buildingAppraisal + ropaCollateral.otherAppraisal
        println("totRopa: "+totRopa)
        def drLand = amountROPADebit * (ropaCollateral.landAppraisal.div(totRopa))
        def drBldg = amountROPADebit * (ropaCollateral.buildingAppraisal.div(totRopa))
        def drOther = amountROPADebit * (ropaCollateral.otherAppraisal.div(totRopa))

        println("drLand: "+drLand)
        println("drBldg: "+drBldg)
        println("drOther: "+drOther)
        
        drLand = drLand.round(2)
        drBldg = drBldg.round(2)
        drOther = drOther.round(2)
        def sumAllXRopaAtribs = drLand + drBldg + drOther
        sumAllXRopaAtribs = sumAllXRopaAtribs.round(2)
        amountROPADebit = amountROPADebit.round(2)
        println("sumAllXRopaAtribs: "+sumAllXRopaAtribs)
        println("amountROPADebit: "+amountROPADebit)
        if (sumAllXRopaAtribs != amountROPADebit){
            println("pasok here sa condition")
            drLand = amountROPADebit - (drBldg + drOther)
        }
        def tfile  = new TxnFile(txnCode:txn.code,txnDescription:txn.description,txnDate:b.runDate,currency:ropaID.currency,
            txnAmt:amountROPADebit,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:ropaID.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:txn.txnType,txnTemplate:txn,
            user:UserMaster.get(session.user_id))
            tfile.save(flush:true, failOnError:true);
            println"nagsave sa txnfile"+tfile

        println("drLand: "+drLand)
        if (drLand > 0.00D){
            def txnDrLand = new TxnBreakdown(branch:b, currency:ropaID.currency, debitAcct:ropaID.glContraRopa,
                debitAmt:drLand, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnDrLand.save(flush:true)
        }
        if (drBldg > 0.00D){
            def txnDrBldg = new TxnBreakdown(branch:b, currency:ropaID.currency, debitAcct:ropaID.glContraBldg,
                debitAmt:drBldg, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnDrBldg.save(flush:true)
        }
        if (drOther > 0.00D){
            def txnOthBldg = new TxnBreakdown(branch:b, currency:ropaID.currency, debitAcct:ropaID.otherGl,
                debitAmt:drOther, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnOthBldg.save(flush:true)
        }

        def txnCrCash = new TxnBreakdown(branch:b, currency:ropaID.currency,creditAcct:txn.defContraAcct,
            creditAmt:amountROPADebit, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
        txnCrCash.save(flush:true)

        println('ito na: '+tfile)
        ropaCollateral.ropaLandAmt = ropaCollateral.ropaLandAmt + drLand
        ropaCollateral.ropaBldgAmt = ropaCollateral.ropaBldgAmt + drBldg
        ropaCollateral.ropaOtherAmt = ropaCollateral.ropaOtherAmt + drOther
        ropaCollateral.save(flush:true, failOnError:true)

        def ropaLedgerDebit = new ROPALedger(ropa:ropaID, txnDate:b.runDate, valueDate:b.runDate, reference:params.reference,
            particulars:params.particulars, debitAmt:amountROPADebit, creditAmt:0.00D,
            balanceAmt:0.00D, ropaLandAmt:ropaCollateral.ropaLandAmt, ropaBldgAmt:ropaCollateral.ropaBldgAmt,
            ropaOtherAmt: ropaCollateral.ropaOtherAmt, txnFile:tfile)
        ropaLedgerDebit.save(flush:true, failOnError:true)
        flash.message = "Transaction Success."
        redirect(action: "collateralShow", id: ropaInstance.id, params: [id: ropaCollateral.id])
    }

    @Transactional
    def saveropaCredit(ROPA ropaInstance){
        println params
        // new txnfile
        def amountRopaCredit  = params.ropacreditAmt.toString().replace(',','').toDouble()

        def ropaCollateral = RopaCollateralDetails.get(params.collID.toInteger())
        def ropaCreditId = ropaCollateral.ropa
        def b = Branch.get(ropaCollateral.ropa.loan.branch.id)
        def txn = TxnTemplate.get(params.txnType.toInteger())
        def totRopa = ropaCollateral.landAppraisal + ropaCollateral.buildingAppraisal + ropaCollateral.otherAppraisal
        println("totRopa: "+totRopa)
        def crLand = amountRopaCredit * (ropaCollateral.landAppraisal.div(totRopa))
        def crBldg = amountRopaCredit * (ropaCollateral.buildingAppraisal.div(totRopa))
        def crOther = amountRopaCredit * (ropaCollateral.otherAppraisal.div(totRopa))

        crLand = crLand.round(2)
        crBldg = crBldg.round(2)
        crOther = crOther.round(2)
        if ((crLand + crBldg + crOther) != amountRopaCredit){
            crLand = amountRopaCredit - crBldg - crOther
        }

        def tfile  = new TxnFile(txnCode:txn.code,txnDescription:txn.description,txnDate:b.runDate,currency:ropaCreditId.currency,
            txnAmt:amountRopaCredit,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:ropaCreditId.branch,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:txn.txnType,txnTemplate:txn,
            user:UserMaster.get(session.user_id))
            tfile.save(flush:true)

            println"nagsave sa txnfile"+tfile

        if (crLand > 0.00D){
            def txnDrLand = new TxnBreakdown(branch:b, currency:ropaCreditId.currency, creditAcct:ropaCreditId.glContraRopa,
                creditAmt:crLand, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnDrLand.save(flush:true)
        }
        if (crBldg > 0.00D){
            def txnDrBldg = new TxnBreakdown(branch:b, currency:ropaCreditId.currency, creditAcct:ropaCreditId.glContraBldg,
                creditAmt:crBldg, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnDrBldg.save(flush:true)
        }
        if (crOther > 0.00D){
            def txnDrBldg = new TxnBreakdown(branch:b, currency:ropaCreditId.currency, creditAcct:ropaCreditId.otherGl,
                creditAmt:crOther, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnDrBldg.save(flush:true)
        }

        //def cashGl = UserMaster.get(session.user_id).cash.code
        def txnCrCash = new TxnBreakdown(branch:b, currency:ropaCreditId.currency,debitAcct:ropaCreditId.glContraRopa,
            debitAmt:amountRopaCredit, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile, user:UserMaster.get(session.user_id))
            txnCrCash.save(flush:true)

        println('ito na: '+tfile)
        ropaCollateral.ropaLandAmt = ropaCollateral.ropaLandAmt - crLand
        ropaCollateral.ropaBldgAmt = ropaCollateral.ropaBldgAmt - crBldg
        ropaCollateral.ropaOtherAmt = ropaCollateral.ropaOtherAmt - crOther
        ropaCollateral.save(flush:true, failOnError:true)

        def ropaLedgerDebit = new ROPALedger(ropa:ropaCreditId, txnDate:b.runDate, valueDate:b.runDate, reference:params.reference,
            particulars:params.particulars, creditAmt:amountRopaCredit, debitAmt:0.00D,
            balanceAmt:0.00D, ropaLandAmt:ropaCollateral.ropaLandAmt, ropaBldgAmt:ropaCollateral.ropaBldgAmt,
            ropaOtherAmt: ropaCollateral.ropaOtherAmt, txnFile:tfile)
        ropaLedgerDebit.save(flush:true, failOnError:true)

        //respond ropaInstance.errors, view:'show'
        flash.message = "Transaction Success"
        redirect(controller: "ropa",action: "collateralShow", id: ropaInstance.id, params: [id: ropaCollateral.id])
    }

    @Transactional
    def updateRopa(){

        def ropaInstance = ROPA.get(params.ropaId.toInteger())
            ropaInstance.glContraRopa = params?.glContraRopa
            ropaInstance.glContraLitigationExp = params?.glContraLitigationExp
            ropaInstance.glContraBldg = params?.glContraBldg
            ropaInstance.otherAccumlated = params?.otherAccumlated
            ropaInstance.ropaIncome = params?.ropaIncome
            ropaInstance.accumulatedDepreciation = params?.accumulatedDepreciation
            ropaInstance.otherGl = params?.otherGl
        ropaInstance.save(flush:true,failOnError:true)

        flash.message = "Ropa Details Successfully Updated."
        redirect(action: "show", controller: "ropa", id: ropaInstance.id)
    }
    
    @Transactional
    def updateCollateral(){
        println("params: "+params)
        println("rdMontana --> Pumasok")
        def getCosExpiryDate = params?.certificateRegistrationDate? new Date().parse("MM/dd/yyyy", params?.certificateRegistrationDate) : null
        if (getCosExpiryDate){
            getCosExpiryDate = getCosExpiryDate + 365
        }
        println("getCosExpiryDate: "+getCosExpiryDate)
        
        def updateCollateralInstance = RopaCollateralDetails.get(params.collateralId.toInteger())
            updateCollateralInstance.consolidatedDate = params?.consolidatedDate? new Date().parse("MM/dd/yyyy", params?.consolidatedDate) : null
            updateCollateralInstance.certificateDate = params?.certificateDate? new Date().parse("MM/dd/yyyy", params?.certificateDate) : null
            updateCollateralInstance.certificateRegistrationDate = params?.certificateRegistrationDate? new Date().parse("MM/dd/yyyy", params?.certificateRegistrationDate) : null																																												
            //updateCollateralInstance.issuancefCosDate =  params?.issuancefCosDate? new Date().parse("MM/dd/yyyy", params?.issuancefCosDate) : null
            updateCollateralInstance.fireInsuranceStartDate = params?.fireInsuranceStartDate? new Date().parse("MM/dd/yyyy", params?.fireInsuranceStartDate) : null
            updateCollateralInstance.fireInsuranceEndDate = params?.fireInsuranceEndDate? new Date().parse("MM/dd/yyyy", params?.fireInsuranceEndDate) : null
            updateCollateralInstance.forClosureDate = params?.forClosureDate? new Date().parse("MM/dd/yyyy", params?.forClosureDate) : null
            updateCollateralInstance.notarizationOfDacionDate = params?.notarizationOfDacionDate? new Date().parse("MM/dd/yyyy", params?.notarizationOfDacionDate) : null
            updateCollateralInstance.latestRatrDate = params?.latestRatrDate? new Date().parse("MM/dd/yyyy", params?.latestRatrDate) : null
            updateCollateralInstance.cosExpiryDateOfRedemption = getCosExpiryDate
            updateCollateralInstance.fireInsuranceAmt = params?.fireInsuranceAmt ? (params?.fireInsuranceAmt.toString().replaceAll(",","")).toDouble() : 0.00D
            updateCollateralInstance.fireInsurancePolicyNo = params?.fireInsurancePolicyNo
            updateCollateralInstance.consolidatedTitleNumber = params?.consolidatedTitleNumber
            updateCollateralInstance.provisionForFireInsurance = params?.provisionForFireInsurance ? (params?.provisionForFireInsurance.toString().replaceAll(",","")).toDouble() : 0.00D
            updateCollateralInstance.appraisedBy = UserMaster.get(params?.appraisedBy)
            updateCollateralInstance.save(flush:true,failOnError:true)

        flash.message = "Collateral Details Successfully Updated."
        redirect(action: "collateralShow", controller: "ropa", id: updateCollateralInstance.id)
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

     //collateral Show
    def collateralShow(){
        println("params: "+params)
        def collateralInstance = RopaCollateralDetails.get(params.id)
        def collRopaInstance = collateralInstance.ropa
        println("collateralInstance: "+collateralInstance)
        println("collRopaInstance: "+collRopaInstance)
        
        def sql = new Sql(dataSource)
        // check if collateral is linked to other loan
        //def loanAppCollaterals = "select collateral_id,loan_application_id from loan_application_collaterals where collateral_id = "+collateralInstance.collateral.id
        def loanAppCollaterals = " select B.id as loanid,A.collateral_id,A.loan_application_id,B.account_no from loan_application_collaterals  A "+
        " inner join loan B on B.loan_application_id = A.loan_application_id "+
        " where  B.status_id not in (6,7,8) and A.collateral_id = "+collateralInstance.collateral.id+" and B.loan_application_id <> "+collateralInstance.loan.loanApplication.id
        def loanAppCollateralsInstance = sql.rows(loanAppCollaterals)
        def counter = 0
        def isCollateralLinkedToOtherLoan = false
        for(x in loanAppCollateralsInstance){
            counter = counter + 1
        }
        println("Collateral Link to Other Count: "+counter)
        if(counter > 0){
            isCollateralLinkedToOtherLoan = true
        }
        [collateralInstance:collateralInstance, collRopaInstance:collRopaInstance,isCollateralLinkedToOtherLoan:isCollateralLinkedToOtherLoan]
    }
    def showRopaLedgerTrans(){
        println("params:"+params)
        def ropaLedgerInstance = ROPALedger.get(params.id)
            println("ropaLedgerInstance:"+ropaLedgerInstance)
            [ropaLedgerInstance:ropaLedgerInstance]
																																			  
    }
    
    // Ropa Sale
    def ropaSale(ROPA ropaInstance){
        println("params: "+params)
        def ropaSaleInstance = RopaCollateralDetails.get(params.id.toInteger())
        [ropaSaleInstance:ropaSaleInstance]
        // display GSP
    }
    
    def ropaTransferDetails(){
        println("ropaTransferDetails params: "+params)
        def ropaTransferInstance = RopaTransfer.get(params.id.toInteger())
        [ropaTransferInstance:ropaTransferInstance]
    }
    
    @Transactional
    def cancelRopaTransfer(){
        println("cancelRopaTransfer params: "+params)
        
        def ropaTransfer = RopaTransfer.get(params.ropaTransferId.toInteger())
        def collateral = ropaTransfer.ropaCollateralDetails.collateral
        // check if already sold
        if (ropaTransfer.ropaCollateralDetails.status.id != 6){
            flash.message = 'Cannot Cancel Transfer - Due to Invalid ROPA Status'
            render(view: "ropaTransferDetails", model: [ropaTransferInstance:ropaTransfer])
            return
        }
        
        def tx = ropaTransfer.txnFile
        tx.status = ConfigItemStatus.read(4)
        tx.save(flush:true)
        
        def glEntries = TxnBreakdown.findAllByTxnFile(tx)
        for (g in glEntries) {
            def newGl = new TxnBreakdown(branch:g.branch, creditAcct:g.debitAcct, creditAmt:g.debitAmt,
                currency:g.currency, debitAcct:g.creditAcct, debitAmt:g.creditAmt, txnCode:g.txnCode,
                txnDate:g.branch.runDate, txnFile:g.txnFile, user:g.user)
            newGl.save(flush:true)
        }
            
        def loan = tx.loanAcct
        loan.balanceAmount = loan.balanceAmount + ropaTransfer.transferAmount
        if (loan.status.id == 7){
            if (loan.maturityDate <= loan.branch.runDate){
                loan.status = LoanAcctStatus.read(5)
                loan.overduePrincipalBalance = loan.balanceAmount
            } else {
                loan.status = LoanAcctStatus.read(4)
            }
        }
        loan.save(flush:true, failOnError:true)
        
        def ll = new LoanLedger(loan: loan, txnFile: tx, txnDate: loan.branch.runDate, 
            txnTemplate: tx.txnTemplate, txnRef: tx.txnRef, principalDebit: ropaTransfer.transferAmount,
            principalBalance: loan.balanceAmount, txnParticulars:tx.txnParticulars)
        ll.save(flush:true,failOnError:true)
        
        collateral.status = LoanCollateralStatus.get(2)
        collateral.save(flush:true, failOnError:true)
        
        def collateralInstance = ropaTransfer.ropaCollateralDetails
        collateralInstance.status = LoanCollateralStatus.get(1)
        
        // clear up instance value upon cancel of transfer back to previous values
        collateralInstance.ropaLandAmt = 0.00D
        collateralInstance.ropaBldgAmt = 0.00D
        collateralInstance.ropaOtherAmt = 0.00D
        
        collateralInstance.save(flush:true, failOnError:true)
        
        def collRopaInstance = ropaTransfer.ropaCollateralDetails.ropa
        flash.message = 'ROPA Transfer Successfully Cancelled.'
        render(view:"collateralShow", model: [collateralInstance: collateralInstance, collRopaInstance: collRopaInstance])
    }
    
    def ropaSaleDetails(){
        println("ropaSaleDetails params: "+params)
        def ropaSaleInstance = RopaSaleDetails.get(params.id.toInteger())
        println("ropaSaleInstance: "+ropaSaleInstance)
        [ropaSaleInstance:ropaSaleInstance]
    }
    
    //Save SCR
    @Transactional
    def saveropaSale(){
        println("Reymart params: "+params)

        def loanAppID = LoanApplication.get(params.loanApplication.toInteger())
        def downpaymentAmount = params.downpayment ? (params.downpayment.toString().replaceAll(",","")).toDouble() : 0.00D
        println("downpaymentAmount: "+downpaymentAmount)
        def saleAmount = params.hiddenSale ? (params.hiddenSale.toString().replaceAll(",","")).toDouble() : 0.00D

        println("saleAmount: "+saleAmount)
        def xxxScrAmount = params.hiddenScrAmount ? (params.hiddenScrAmount.toString().replaceAll(",","")).toDouble() : 0.00D
        def xxIncomeAmount = params.hiddenIncome ? (params.hiddenIncome.toString().replaceAll(",","")).toDouble() : 0.00D

        def xxxCollateralId = params?.findCollId.toInteger()
        println("xxxCollateralId: "+xxxCollateralId)
        def rStatus

        //def ropaSaleInstance = RopaCollateralDetails.get(params.id.toInteger())

        def txn = TxnTemplate.get(params.txnType.toInteger())
        def b = Branch.get(1)

        def getRopaId = ROPA.get(params.getRopaId)
            println("ROPA: "+getRopaId)

        def ropaCollDetailsId = RopaCollateralDetails.findByRopa(getRopaId)
            println("ropaCollDetailsId: "+ropaCollDetailsId)
            //Change Status of Collateral

            def getRopaCollateralTableId = RopaCollateralDetails.get(ropaCollDetailsId.id)
            getRopaCollateralTableId.status = LoanCollateralStatus.get(7)
            println("getRopaCollateralTableId.status: " + getRopaCollateralTableId.status)
            getRopaCollateralTableId.save(flush:true)

        def tfile  = new TxnFile(txnCode:txn.code,txnDescription:txn.description,txnDate:b.runDate,currency:1,
            txnAmt:downpaymentAmount,txnRef:params.reference,status:ConfigItemStatus.get(2), branch:b,
            txnTimestamp: new Date().toTimestamp(),txnParticulars:params.particulars,txnType:txn.txnType,txnTemplate:txn,
            user:UserMaster.get(session.user_id))
            tfile.save(flush:true)
            println("TXN FILE PARAMS ====== " +tfile)

        if(downpaymentAmount > 0 ){
             // with downpayment
            def glTransitoria = Institution.findByParamCode("GLS.60080").paramValue
            def txnDrDownpayment = new TxnBreakdown(branch:b, currency:1, debitAcct:txn.defContraAcct,
                debitAmt:downpaymentAmount, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile,
                user:UserMaster.get(session.user_id))
            txnDrDownpayment.save(flush:true)
            def txnDrTrans = new TxnBreakdown(branch:b, currency:1, debitAcct:glTransitoria,
                debitAmt:(saleAmount + xxIncomeAmount) - downpaymentAmount , txnCode:txn.code, txnDate:b.runDate, txnFile:tfile,
                user:UserMaster.get(session.user_id))
            txnDrTrans.save(flush:true)
        }else{
            //No Downpayment
            def txnDrInc = new TxnBreakdown(branch:b, currency:1, debitAcct:txn.defContraAcct,
                debitAmt:saleAmount + xxIncomeAmount, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile,
                user:UserMaster.get(session.user_id))
            txnDrInc.save(flush:true)
        }
        
        if(xxIncomeAmount > 0 ){
           //With Income
            def txnCrInc = new TxnBreakdown(branch:b, currency:1,creditAcct:params.ropaIncomeContra,
                      creditAmt:xxIncomeAmount, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile,
                      user:UserMaster.get(session.user_id))
                    txnCrInc.save(flush:true)
        }
       
        def txnCrSale = new TxnBreakdown(branch:b, currency:1,creditAcct:params.ropaContra,
            creditAmt:saleAmount, txnCode:txn.code, txnDate:b.runDate, txnFile:tfile,
            user:UserMaster.get(session.user_id))
        txnCrSale.save(flush:true)
        println("======= Saving. . . .  ROPA SALE DETAILS ====== ")
            
        def cId = ropaCollDetailsId.collateral
        //SCR Amount Condition
        def downpaymentAndScrCalculation

        if(xxxScrAmount == downpaymentAmount){
            xxxScrAmount = 0.00D
            downpaymentAndScrCalculation = 0.00D
            rStatus = LoanCollateralStatus.get(7)
            println ("xxxScrAmount: "+xxxScrAmount)
        }else{
            println ("result false")
            xxxScrAmount = xxxScrAmount
            println ("xxxScrAmount : "+ xxxScrAmount)
            rStatus = LoanCollateralStatus.get(2)
            downpaymentAndScrCalculation = xxxScrAmount - downpaymentAmount
            println("Calculation: "+downpaymentAndScrCalculation)
        }
        if (xxIncomeAmount == 0.00D || xxIncomeAmount == null){
            rStatus = LoanCollateralStatus.get(7)
            println("rStatus: " +rStatus)
        }else{
            rStatus = LoanCollateralStatus.get(7)
            println("rStatus: " +rStatus)
        }

        def saveRopaSaleDetails = new RopaSaleDetails()
        saveRopaSaleDetails.loanApplication = loanAppID
        saveRopaSaleDetails.collateral = cId
        saveRopaSaleDetails.ropa = getRopaId
        saveRopaSaleDetails.saleAmount = saleAmount
        saveRopaSaleDetails.downpayment = downpaymentAmount
        saveRopaSaleDetails.scrAmount = xxxScrAmount
        saveRopaSaleDetails.difference = downpaymentAndScrCalculation
        saveRopaSaleDetails.reference = params.reference
        saveRopaSaleDetails.particulars = params.particulars
        saveRopaSaleDetails.txnFile = tfile
        saveRopaSaleDetails.incomeAmount = xxIncomeAmount
        saveRopaSaleDetails.ropaCollateralDetails = ropaCollDetailsId
        saveRopaSaleDetails.ropaContra = params.ropaContra
        saveRopaSaleDetails.ropaIncomeContra = params.ropaIncomeContra
        saveRopaSaleDetails.status = rStatus
        
        println("status: "+saveRopaSaleDetails.status)
        //saveRopaSaleDetails.
        saveRopaSaleDetails.save(flush:true,failOnError:true)
        flash.message = "Successfully Saved!"
        def ropaHistDesc
        if (xxxScrAmount == 0.00) {
            // release collateral
            cId.status = LoanCollateralStatus.get(7)
            ropaHistDesc = 'Collaretal/ROPA sale ' + RopaSaleDetails
            //Amount
            redirect(action: "show", id: saveRopaSaleDetails.ropa.id, params: [id: saveRopaSaleDetails.ropa.id, saveRopaSaleDetails: saveRopaSaleDetails.collateral.id])
            return
        } else {
            // re-activate collateral
            cId.status = LoanCollateralStatus.get(2)
            ropaHistDesc = 'Collaretal/ROPA transfer to Sales Contract ' + RopaSaleDetails
            //save loan app granted amount
            loanAppID.amount = saveRopaSaleDetails.difference
            loanAppID.save(flush:true,failOnError:true)
        }
        cId.save(flush:true, failOnError:true)

        // link collateral to loan application
        loanAppID.addToCollaterals(cId)
        loanAppID.save(flush:true,failOnError:true)

        def collHist = new CollateralHistory(collateral:cId, refDate:loanAppID.branch.runDate,
            description:ropaHistDesc, user:UserMaster.get(session.user_id))
        collHist.save(flush:true, failOnError:true)
        redirect(action: "show", controller: "loanApplication", id: loanAppID.id, params: [id: loanAppID.id, amount: downpaymentAndScrCalculation])
    }
   
    def collectionInformation(){
        def json = request.JSON
        //def TxnTypeInstance = TxnType.get(json.typevalue.toInteger())
        //def TxnTypeInstance = TxnType.get(json.typevalue)
        def sql = new Sql(dataSource)
        def TxnTypeInstance = " select a.amount, a.id, c.display_name, a.application_date,a.approval_status_id, a.product_id, b.product_type_id from loan_application a inner join customer c on c.id = a.customer_id inner join product as b on b.id = a.product_id join product_type as d on d.id = b.product_type_id where a.id = '${json.id.toInteger()}'"
        def resultqueryall = sql.rows(TxnTypeInstance)

        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    
    def collectionInformationInstallment(){

        def json = request.JSON
        def sql = new Sql(dataSource)
        def TxnTypeInstance =  " select a.id, c.display_name,e.account_no,e.granted_amount,e.balance_amount,e.status_id,b.product_type_id from loan_application a "+
                                "inner join product as b on b.id = a.product_id " +
                                "inner join customer c on c.id = a.customer_id " +
                                "inner join product_type as d on d.id = b.product_type_id "+
                                "left outer join loan e on e.loan_application_id = a.id "+
                                "where a.id = '${json.id.toInteger()}'"
        def resultqueryall = sql.rows(TxnTypeInstance)

        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    
    def search(Integer max) {
     // params.max = Math.min(max ?: 10, 100)
        params.max = Math.min(max ?: 25, 100)

        if (params.sort == null) {
            params.sort = "id"
        }

        if (params.query == null || params.query.trim() == "") {  // show all instances
            println("Pumasok dito")
            render(template:"search/searchRopa", model:[params:params, domainInstanceList:LoanApplication.list(params), domainInstanceCount:LoanApplication.count()]) as JSON
        } else {    // show query results
            println("Pumasok dito sa else")
            def result = LoanApplication.createCriteria().list(params) {
                or{
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
            render(template:"search/searchRopa", model:[params:params, domainInstanceList:result, domainInstanceCount:result.totalCount]) as JSON
        }
        return
    }
    
    def ropaCreateAccdep(){
        println("================ createRopaAccdep ===============")
        println("params: "+params)
        def ropaCollateralDetails = RopaCollateralDetails.get(params.id.toInteger())
        [ropaCollateralDetails:ropaCollateralDetails]
    }
    
    @Transactional
    def saveRopaAccDep(){
        println("================ saveRopaAccDep ===============")
        println("params: "+params)
        def ropaCollateralInstance = RopaCollateralDetails.get(params.ropaColleteralId.toInteger())
        def ropadebitAmt = params.debitAmt ? (params.debitAmt.replaceAll(",","")).toDouble() : 0.00D
        def ropacreditAmt = params.creditAmt ? (params.creditAmt.replaceAll(",","")).toDouble() : 0.00D
        def ropadebitAmtOth = params.debitAmtOth ? (params.debitAmtOth.replaceAll(",","")).toDouble() : 0.00D
        def ropacreditAmtOth = params.creditAmtOth ? (params.creditAmtOth.replaceAll(",","")).toDouble() : 0.00D
        //for error Msg
        def ropaCollateralDetails = ropaCollateralInstance

        def totAmt = ropaCollateralInstance.ropaBldgAmt + ropaCollateralInstance.ropaOtherAmt
        if (ropacreditAmt > 0.00D){
            ropaCollateralInstance.buildingAccDepreciation = ropaCollateralInstance.buildingAccDepreciation + ropacreditAmt
        }
        if (ropacreditAmtOth > 0.00D){
            ropaCollateralInstance.otherAccDepreciation = ropaCollateralInstance.otherAccDepreciation + ropacreditAmtOth
        }

        if (ropadebitAmt > 0.00D){
            ropaCollateralInstance.buildingAccDepreciation = ropaCollateralInstance.buildingAccDepreciation - ropadebitAmt
        }
        if (ropadebitAmtOth > 0.00D){
            ropaCollateralInstance.otherAccDepreciation = ropaCollateralInstance.otherAccDepreciation -  ropadebitAmtOth
        }
        ropaCollateralInstance.save(flush:true, failOnError:true)

        def accDepInstance = new RopaAccumulatedDepreciation(recordDate: UserMaster.get(session.user_id).branch.runDate,
            recordBy: UserMaster.get(session.user_id),ropa: ropaCollateralInstance.ropa,status: ConfigItemStatus.get(2),debitAmt: ropadebitAmt,
            otherDebitAmt:ropadebitAmtOth,otherCreditAmt:ropacreditAmtOth,
            creditAmt: ropacreditAmt,reference: ''+params.reference,particulars: ''+params.particulars,ropaCollateralDetails: ropaCollateralInstance)
        accDepInstance.save(flush:true,failOnError:true)

        flash.message = "New Accumulated Depreciation Successfully Recorded."

        redirect(action: 'showRopaAccDepDetails', controller: 'ropa', id: ropaCollateralInstance.id)
    }
    
    def showRopaAccDepDetails(){
        println("================ showRopaAccDepDetails ===============")
        println("params: "+params)

        def ropaCollateralDetails = RopaCollateralDetails.get(params?.id.toInteger())

        def c = RopaAccumulatedDepreciation.createCriteria()
        def ropaAccumulatedDepInstance = c.list {
            eq("ropa", ropaCollateralDetails.ropa)
            eq("ropaCollateralDetails",ropaCollateralDetails)
            order("recordDate", "asc")
        }
        [ropaAccumulatedDepInstance:ropaAccumulatedDepInstance,ropaCollateralDetails:ropaCollateralDetails]
    }
    
    def ropaForTransfer(Integer max) {

        params.max = Math.min(max ?: 10, 100)

        def ColumnName = "id"
        def ColumnOrderBy = "desc"
        if (params.query == null) {  // show all instances

            println("clickable sort column: "+params)
           if(params.sort==null){
                 ColumnName = "id"
                 ColumnOrderBy = "desc"
           }else{
                 ColumnName = params.sort
                 ColumnOrderBy = params.order
           }
           def RopaInstanceList = RopaCollateralDetails.createCriteria().list(params) {
               //order(ColumnName,ColumnOrderBy)
               and {
                    eq("status",LoanCollateralStatus.read(1))
                }
                order("id", "asc")
            }
            println("result value: "+RopaInstanceList)
            //respond GlContigentAccountList, model:[BranchInstanceCount: GlContigentAccountList.totalCount]
            [RopaInstanceList:RopaInstanceList,BranchInstanceCount: RopaInstanceList.totalCount,]
        } else {
             def RopaInstanceList = RopaCollateralDetails.createCriteria().list(params) {
                 or {
                    ilike("formerTitle", "%${params.query}%")
                    ilike("kindOfLand", "%${params.query}%")
                    ilike("location", "%${params.query}%")
                } and {
                    eq("status",LoanCollateralStatus.read(1))
                }
                order("id", "asc")
            }
           [RopaInstanceList:RopaInstanceList,BranchInstanceCount: RopaInstanceList.totalCount]
        }
    }
    
    def specialtransferToRopaGSP(){
        def ropaInstance = RopaCollateralDetails.get(params.id.toInteger()).ropa
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())

        println("collateralInstance: "+collateralInstance)

        [ropaInstance:ropaInstance,collateralInstance:collateralInstance]
    }
    
    @Transactional
    def saveSpecialTransfer(){
        println("=============== saveSpecialTransfer ================")
        println("params: "+params)
        def loanInstance = Loan.get(params?.loanID.toInteger())
        def collateralInstance = RopaCollateralDetails.get(params.collateral.toInteger())

        def checkCollateral = loanInstance.loanApplication.collaterals.findAll{it.id == collateralInstance?.collateral?.id}
        if(!checkCollateral){
            //wala
            flash.message="Collateral was not belong to this Loan Account"
            redirect(action: "specialtransferToRopaGSP",controller:"ropa", id:collateralInstance.id)
        }

        println("collateralInstance: "+ collateralInstance)

        def getIdOfropa = collateralInstance.ropa
        def loan = loanInstance
        def collateral = collateralInstance.collateral
        //def ropaLandAmt = params.ropaLandAmount ? (params.ropaLandAmount.toString().replaceAll(",","")).toDouble() : 0.00D
        //def ropabldgAmt = params.ropaBuildingAmount ? (params.ropaBuildingAmount.toString().replaceAll(",","")).toDouble() : 0.00D
        def marketValueLand = params.marketValueLand ? (params.marketValueLand.toString().replaceAll(",","")).toDouble() : 0.00D
        def marketValueBuilding = params.marketValueBuilding ? (params.marketValueBuilding.toString().replaceAll(",","")).toDouble() : 0.00D
        def marketValueOthers = params.otherPropertiesAcquired ? (params.otherPropertiesAcquired.toString().replaceAll(",","")).toDouble() : 0.00D
        def transferAmt = params.transferAmount ? (params.transferAmount.toString().replaceAll(",","")).toDouble() : 0.00D

        def totValue = marketValueLand + marketValueBuilding + marketValueOthers
        def ropaLand = transferAmt * (marketValueLand.div(totValue))
        def ropaBldg = transferAmt * (marketValueBuilding.div(totValue))
        def ropaOther = transferAmt * (marketValueOthers.div(totValue))
	ropaLand = ropaLand.round(2)
        ropaBldg = ropaBldg.round(2)
        ropaOther = ropaOther.round(2)

        if ((ropaLand + ropaBldg + ropaOther) != transferAmt){
            ropaLand = transferAmt - (ropaBldg + ropaOther)
        }

        def ropaLandGl = getIdOfropa.glContraRopa
        def ropaBldgGl = getIdOfropa.glContraBldg
        def ropaOtherGl = getIdOfropa.otherGl
        def txnTmp = TxnTemplate.get(params.txnType)
        //def txnAmt = ropaLandAmt + ropabldgAmt
        println("transferAmt: "+transferAmt)

        /*if (transferAmt > loanInstance.balanceAmount){
            flash.message = "Txn Amount Greater than Loan Balance Amount"
            redirect(action: "specialtransferToRopaGSP",controller:"ropa", id:collateralInstance.id)
        }
        if(loanInstance.status.id == 8){
            flash.message = "ERROR: Loan already Written-Off"
            respond collateralInstance.errors, view:'transferToRopaGSP'
            return
        }*/

        def tx = new TxnFile(acctNo:loan.accountNo, loanAcct:loan,
            currency:loan.product.currency, user:UserMaster.get(session.user_id),
            branch:UserMaster.get(session.user_id).branch, txnAmt:transferAmt,
            txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnTimestamp:new Date().toTimestamp(),
            txnDescription:txnTmp.description, status:ConfigItemStatus.get(2),
            txnType:txnTmp.txnType, txnParticulars:params.particulars, txnRef:params.reference)
        tx.save(flush:true,failOnError:true)

         // txnDr ==>land, params.ropaLand
        def txnDr = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, debitAcct:ropaLandGl,
            debitAmt:ropaLand, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnDr.save(flush:true)
        if (ropaBldg > 0.00D){
            def txnDrBldg = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, debitAcct:ropaBldgGl,
                debitAmt:ropaBldg, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDrBldg.save(flush:true)
        }
        if (ropaOther > 0.00D){
            def txnDrOther = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, debitAcct:ropaOtherGl,
                debitAmt:ropaOther, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
            txnDrOther.save(flush:true)
        }
        def creditLoan = CfgAcctGlTemplateDet.findByGlTemplateAndOrdinalPosAndStatus(loan.glLink,'0',loan.loanPerformanceId.id)

        // txnCr => txnAmt
        def txnCr = new TxnBreakdown(branch:loan.branch.id, currency:tx.currency, creditAcct:creditLoan.glCode,
            creditAmt:transferAmt, txnCode:txnTmp.code, txnDate:loan.branch.runDate, txnFile:tx, user:UserMaster.get(session.user_id))
        txnCr.save(flush:true)

        //Saving of Parameters
        def transferToROPA = new RopaTransfer()
            transferToROPA.loan = loan
            transferToROPA.ropaCollateralDetails = collateralInstance
            transferToROPA.ropa = getIdOfropa
            transferToROPA.marketValueLand = marketValueLand
            transferToROPA.marketValueBuilding = marketValueBuilding
            transferToROPA.marketValueOther = marketValueOthers
            transferToROPA.ropaLandAmount = ropaLand
            transferToROPA.ropaBuildingAmount = ropaBldg
            transferToROPA.otherGlAmount = ropaOther
            transferToROPA.transferAmount = transferAmt
            transferToROPA.txnFile = tx
        transferToROPA.save(flush:true, failOnError:true)

        if (transferAmt >= loan.balanceAmount){
            // params.ropaBuilding
            loan.status = LoanAcctStatus.get(7)
            loan.interestBalanceAmount = 0.00D

            loan.penaltyBalanceAmount = 0.00D
            loan.serviceChargeBalanceAmount = 0.00D
            loan.overduePrincipalBalance = 0.00D
        }
        
        loan.balanceAmount = loan.balanceAmount - transferAmt
        loan.save(flush:true, failOnError:true)

        def ll = new LoanLedger(loan: loan, txnFile: tx, txnDate: loan.branch.runDate,
            txnTemplate: txnTmp, txnRef: params.reference, principalCredit: transferAmt,
            principalBalance: loan.balanceAmount, txnParticulars:params.particulars)
        ll.save(flush:true,failOnError:true)

        collateral.status = LoanCollateralStatus.get(6)
        collateral.save(flush:true, failOnError:true)

        collateralInstance.ropaLandAmt = collateralInstance.ropaLandAmt + ropaLand
        collateralInstance.ropaBldgAmt = collateralInstance.ropaBldgAmt + ropaBldg
        collateralInstance.ropaOtherAmt = collateralInstance.ropaOtherAmt + ropaOther
        collateralInstance.landAppraisal = marketValueLand
        collateralInstance.buildingAppraisal = marketValueBuilding
        collateralInstance.otherAppraisal = marketValueOthers
        collateralInstance.status = LoanCollateralStatus.get(6)
        collateralInstance.save(flush:true, failOnError:true)
        getIdOfropa.save(flush:true, failOnError:true)
        //redirect(controller: "ropa", action: "show", id: getIdOfropa, params: [collateralId: collateralInstance])
        //render(view:'/show', model: [ropaInstance:ropaInstance])
        flash.message = "Successfuly Tranfered."

        redirect(action: "show",controller:"ropa",id:getIdOfropa.id)
    }
   
    def ropaSpecialCollateralValidatorAjax(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        def loanAcctNo = json.accountno.toString()
        def theCollateral = json.thecollateral.toInteger()
        def loanInstance = Loan.findByAccountNo(loanAcctNo)
        
        def queryall = "select collateral_id,loan_application_id from loan_application_collaterals where collateral_id = '${theCollateral}' and loan_application_id = '${loanInstance.loanApplication.id}' "
        def resultqueryall = sql.rows(queryall)
        println("return: "+resultqueryall)
        render resultqueryall as JSON
    }
    
    @Transactional
    def probableLosesSaveUpdateDebit(){
        println("==================== probableLosesSaveUpdate =======================")
        println("params: "+params)
        
        def xallowanceProbLoss = params.allowanceProbLoss ? (params.allowanceProbLoss.toString().replaceAll(",","")).toDouble() : 0.00D
        def xallowanceProbLossBldg = params.allowanceProbLossBldg ? (params.allowanceProbLossBldg.toString().replaceAll(",","")).toDouble() : 0.00D
        def xallowanceProbLossOtherProp = params.allowanceProbLossOtherProp ? (params.allowanceProbLossOtherProp.toString().replaceAll(",","")).toDouble() : 0.00D

        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
            collateralInstance.allowanceProbLoss -= xallowanceProbLoss
            collateralInstance.allowanceProbLossBldg -= xallowanceProbLossBldg
            collateralInstance.allowanceProbLossOtherProp -= xallowanceProbLossOtherProp
        collateralInstance.save(flush:true,failOnError:true)
        
        def led = new RopaAllowanceLedger(recordDate:Branch.get(1).runDate, recordBy:UserMaster.get(session.user_id),
            ropa:collateralInstance.ropa, status:ConfigItemStatus.get(2), landDebit:xallowanceProbLoss,
            landCredit:0.00D, bldgDebit:xallowanceProbLossBldg, bldgCredit:0.00D, 
            otherDebitAmt:xallowanceProbLossOtherProp, otherCreditAmt: 0.00D, 
            particulars:'ROPA Allowance for Probable Losses Debit',
            ropaCollateralDetails:collateralInstance)
        led.save(flush:true, failOnError:true)
        
        flash.message = "Allowance for Probable Loses Successfully Updated."
        redirect(action: "collateralShow",controller: "ropa",id: collateralInstance.id)
    }
    
    @Transactional
    def probableLosesSaveUpdateCredit(){
        println("==================== probableLosesSaveUpdate =======================")
        println("params: "+params)
        
        def xallowanceProbLoss = params.allowanceProbLossCr ? (params.allowanceProbLossCr.toString().replaceAll(",","")).toDouble() : 0.00D
        def xallowanceProbLossBldg = params.allowanceProbLossBldgCr ? (params.allowanceProbLossBldgCr.toString().replaceAll(",","")).toDouble() : 0.00D
        def xallowanceProbLossOtherProp = params.allowanceProbLossOtherPropCr ? (params.allowanceProbLossOtherPropCr.toString().replaceAll(",","")).toDouble() : 0.00D
        
        def collateralInstance = RopaCollateralDetails.get(params.id.toInteger())
            collateralInstance.allowanceProbLoss += xallowanceProbLoss
            collateralInstance.allowanceProbLossBldg += xallowanceProbLossBldg
            collateralInstance.allowanceProbLossOtherProp += xallowanceProbLossOtherProp
        collateralInstance.save(flush:true,failOnError:true)
        
        def led = new RopaAllowanceLedger(recordDate:Branch.get(1).runDate, recordBy:UserMaster.get(session.user_id),
            ropa:collateralInstance.ropa, status:ConfigItemStatus.get(2), landDebit:0.00D,
            landCredit:xallowanceProbLoss, bldgDebit:0.00D, bldgCredit:xallowanceProbLossBldg, 
            otherDebitAmt:0.00D, otherCreditAmt: xallowanceProbLossOtherProp, 
            particulars:'ROPA Allowance for Probable Losses Credit',
            ropaCollateralDetails:collateralInstance)
        led.save(flush:true, failOnError:true)        
        flash.message = "Allowance for Probable Loses Successfully Updated."
        redirect(action: "collateralShow",controller: "ropa",id: collateralInstance.id)
    }
}
//jmpc