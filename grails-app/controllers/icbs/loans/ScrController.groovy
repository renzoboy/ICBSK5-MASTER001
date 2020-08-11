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
import icbs.admin.Branch
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
import icbs.loans.LoanLossProvisionDetail	
import icbs.loans.PenaltyIncomeScheme
import icbs.loans.LoanGuaranteeDetail
import icbs.lov.LoanAcctStatus
import icbs.lov.LoanSpecialType
import icbs.lov.TxnType
import icbs.admin.TxnTemplate
import icbs.deposit.Hold
import icbs.deposit.Deposit
import icbs.lov.HoldStatus
import icbs.lov.HoldType
import icbs.lov.ConfigItemStatus
import icbs.lov.SweepType
import icbs.lov.SweepRule
import icbs.lov.SweepStatus
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
import icbs.loans.ROPA
import icbs.loans.ScrRopa
import icbs.loans.ROPALedger
//new imports
import java.text.SimpleDateFormat
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartFile
import java.lang.*

class ScrController {
    def jrxmlTcId
    def jasperService
    def transactionFileId 
    def dataSource
    def auditLogService
    static allowedMethods = [save: "POST", update: ["PUT","POST"], delete: "DELETE"]
    
    def loanService   
    def glTransactionService
    def index(Integer max) {
       // params.max = Math.min(max ?: 10, 100)   // no. of items on display
           params.max = Math.min(max ?: 25, 100)
        
        if (params.sort == null) {  // default ordering
           // params.sort = "id"
              params.sort  = "dateApproved" 
              params.order =  "desc"
        }

        if (params.query == null || params.query.trim() == "") {  // show all instances
            respond ROPA.list(params), model:[params:params, ropaInstanceCount: ROPA.count()]
        } else {    // show query results
            def result = ROPA.createCriteria().list(params) {
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
            println result.totalCount
            respond result, model:[params:params, ropaInstanceCount: result.totalCount]
        }
        return
    } 

    def search(Integer max) {
     // params.max = Math.min(max ?: 10, 100) 
        params.max = Math.min(max ?: 25, 100)
  
         if (params.sort == null) {
            params.sort = "id"
        }

        if (params.query == null || params.query.trim() == "") {  // show all instances
            render(template:"search/searchRopa", model:[params:params, domainInstanceList:ROPA.list(params), domainInstanceCount:LoanApplication.count()]) as JSON
        } else {    // show query results
            def result = ROPA.createCriteria().list(params) {
                or{
                    'customerDisplayName'{
                        or{
                            ilike("customerDisplayName","%${params.query.trim()}%")
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
}
