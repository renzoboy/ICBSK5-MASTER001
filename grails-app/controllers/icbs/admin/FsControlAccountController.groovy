package icbs.admin

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import groovy.sql.Sql
import groovy.json.JsonBuilder			
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.gl.GlAccount
import icbs.admin.Branch
import icbs.lov.ConfigItemStatus
import java.lang.*
import icbs.admin.Institution
import groovy.time.TimeCategory
import java.text.SimpleDateFormat
import java.util.Formatter.DateTime
import java.util.Date
import java.math.*;
import java.lang.Math;
import icbs.gl.FsControlAccount
import icbs.audit.AuditLog
class FsControlAccountController {

   static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def dataSource
    def auditLogService
    def index(Integer max) {
        println("params: "+params)
        params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            //params.sort = "code"
        }

        if (params.query == null) {  // show all instances 
            def fsControlAccountList = FsControlAccount.createCriteria().list(params) {
                
                 order("id", "asc")
            }
            respond fsControlAccountList, model:[fsControlAccountList: fsControlAccountList,fsControlAccountInstanceCount: fsControlAccountList.totalCount]
        }
        else {    // show query results
            def fsControlAccountList = FsControlAccount.createCriteria().list(params) {
                or {
                    ilike("account","%${params.query}%")
                    ilike("description","%${params.query}%")
                }
                order("id", "asc")
            }
            respond fsControlAccountList, model:[fsControlAccountList: fsControlAccountList,fsControlAccountInstanceCount: fsControlAccountList.totalCount]
        }
    }
    def create(){
        
    }
    def saveCreate(){
        def fsControlAccountInstance = new FsControlAccount(account: params?.account,description: params?.description,
            status:ConfigItemStatus.get(2), createdBy: UserMaster.get(session.user_id),xCreatedDate: UserMaster.get(session.user_id).branch.runDate)
        fsControlAccountInstance.save(flush:true)
        
        flash.message = "New FS Control Account Successfully Created.. "
        
        def description = fsControlAccountInstance.account + " - " + fsControlAccountInstance.description + ' was created by ' + UserMaster.get(session.user_id).username
       auditLogService.insert('180', 'ADM01100', description, 'FS CONTROL ACCOUNT', null, null, null, fsControlAccountInstance.id)
        
        redirect(action: "show",controller: "fsControlAccount",id:fsControlAccountInstance.id)
    }
    def edit(){
        def fsControlAccountInstance = FsControlAccount.get(params?.id.toInteger())
        [fsControlAccountInstance:fsControlAccountInstance]
    }
    def saveEdit(){
        
        def fsControlAccountInstance = FsControlAccount.get(params?.fsControlId.toInteger())
        fsControlAccountInstance.account = params?.account
        fsControlAccountInstance.description = params?.description
        fsControlAccountInstance.status = ConfigItemStatus.get(params?.status.id)
        fsControlAccountInstance.save(flush:true)
        
        flash.message = "FS Control Account Successfully Updated.. "
        
        def description = fsControlAccountInstance.account + " - " + fsControlAccountInstance.description + ' was editted by ' + UserMaster.get(session.user_id).username
       auditLogService.insert('180', 'ADM01100', description, 'FS CONTROL ACCOUNT', null, null, null, fsControlAccountInstance.id)
        
        redirect(action: "show",controller: "fsControlAccount",id:fsControlAccountInstance.id)
    }
    def show(){
        def fsControlAccountInstance = FsControlAccount.get(params?.id.toInteger())
        [fsControlAccountInstance:fsControlAccountInstance]
    }
    def validateCodeIfExistAjax(){
        def json = request.JSON
        def sql = new Sql(dataSource)
        def queryallsss
        if(json.fsaccountId == "" || json.fsaccountId == null){
            queryallsss = "select * from fs_control_account where account = '"+json.account.toString()+"'"
        }else{
            queryallsss = "select * from fs_control_account where account = '"+json.account.toString()+"' and id <> "+json.fsaccountId.toInteger()
        }
        
        def resultqueryall = sql.rows(queryallsss)
        render resultqueryall as JSON    
    }
}
