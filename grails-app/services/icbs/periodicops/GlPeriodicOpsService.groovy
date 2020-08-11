package icbs.periodicops

import grails.transaction.Transactional
import icbs.admin.Branch
import icbs.lov.ConfigItemStatus
import icbs.tellering.TxnFile
import icbs.tellering.TxnBreakdown
import icbs.admin.UserMaster
import icbs.admin.Institution
import icbs.admin.TxnTemplate
import icbs.admin.Holiday
import icbs.lov.TxnType
import icbs.gl.GlAccount
import icbs.admin.BranchHoliday
import groovy.time.TimeCategory
import groovy.sql.Sql
import icbs.gl.HtmSchedule
import icbs.gl.AssetsHeldToMaturity

@Transactional
class GlPeriodicOpsService {
    
    def GlTransactionService
    def sessionFactory
    def dataSource
    
    def htmRealization(Date currentDate,Branch branch, UserMaster user){
        println("====================== START HTM REALIZATION POSTING SECTION ============================== ")
        println("currentDate: "+currentDate)
        println("branch: "+branch)
        def db = new Sql(dataSource)
        
        def sqlstmt  = "select A.id from htm_schedule A " +
            " inner join assets_held_to_maturity B on B.id = A.assets_held_to_maturity_id " +
            " where A.xhtm_schedule_date = '"+currentDate.format('yyyy-MM-dd')+"' and B.branch_id = "+branch.id
        println("sqlstmt: "+sqlstmt)
        
        def htmInstanceSchedxx = db.rows(sqlstmt)
        println("htmInstanceSchedxx: "+htmInstanceSchedxx)
        Integer i = 0
        
        for(htmSched in htmInstanceSchedxx){
            println("htmSched: "+htmSched)
            def htmScheduleInstance = HtmSchedule.get(htmSched.id)
            println("htmScheduleInstance: "+htmScheduleInstance)
            def txTmp = TxnTemplate.get(Institution.findByParamCode("GLS.60480").paramValue.toInteger())
            
            def tx = new TxnFile(currency: htmScheduleInstance.assetsHeldToMaturity.currency,
            status:ConfigItemStatus.read(2), txnAmt:htmScheduleInstance.amount, 
            txnCode:txTmp.code, txnDate:branch.runDate, txnDescription:'HTM Realization',
            txnParticulars:'To realize HTM discounts', txnRef:htmScheduleInstance.id,
            txnTemplate:txTmp, txnTimeStamp: new Date().toTimestamp(), txnType: txTmp.txnType,
            user:user,branch:branch)
            
        
            tx.save(flush:true)
            println("tx: "+tx)
            def txDr = new TxnBreakdown(branch:tx.branch, 
                debitAcct:htmScheduleInstance.assetsHeldToMaturity.htmAccrualDebitAcct,
                debitAmt:tx.txnAmt, txnDate:tx.txnDate, txnFile:tx, user:tx.user)
            
            def txCr = new TxnBreakdown(branch:tx.branch, 
                creditAcct:htmScheduleInstance.assetsHeldToMaturity.htmAccrualCredittAcct,
                creditAmt:tx.txnAmt, txnDate:tx.txnDate, txnFile:tx, user:tx.user)

            txDr.save(flush:true)

            txCr.save(flush:true)

            println("HTM Schedule posting htmScheduleInstance id: "+htmScheduleInstance.id)
            htmScheduleInstance.status = ConfigItemStatus.get(9)
            htmScheduleInstance.save(flush: true)
            
            i++
            if (i > 50){
                cleanUpGlGorm()
                i = 0
            }
        }
        println("===============  DONE POSTING HTM DISCOUNT REALIZATION ====================")
    }
    def cleanUpGlGorm() {
        def session = sessionFactory.currentSession
        session.flush()
        session.clear()
        //propertyInstanceMap.get().clear()
        def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP
        propertyInstanceMap.get().clear()
        
    }
}
