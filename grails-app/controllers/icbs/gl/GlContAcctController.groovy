package icbs.gl
import icbs.admin.Branch
import icbs.lov.ContigentAccount
import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.gl.GlContigentAccount
import groovy.json.JsonBuilder

import static org.springframework.http.HttpStatus.*
import java.util.*
import java.text.SimpleDateFormat
import java.util.Date
import groovy.sql.Sql

import grails.transaction.Transactional
import icbs.atm.AtmTxn
import icbs.tellering.*
import icbs.tellering.TxnFile
import grails.converters.JSON
import icbs.loans.Loan

class GlContAcctController {

     static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def datasource
       
     def index(Integer max) {
        
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
           def GlContigentAccountList = GlContigentAccount.createCriteria().list(params) {
               //order(ColumnName,ColumnOrderBy)
               
            }
            println("result value: "+GlContigentAccountList)
            //respond GlContigentAccountList, model:[BranchInstanceCount: GlContigentAccountList.totalCount]
            [GlContigentAccountList:GlContigentAccountList,BranchInstanceCount: GlContigentAccountList.totalCount,]
        }
        else{
             def GlContigentAccountList = GlContigentAccount.createCriteria().list(params) {

                eq("accountNo",params.query)
            }
           [GlContigentAccountList:GlContigentAccountList,BranchInstanceCount: GlContigentAccountList.totalCount]
        }  
    }
    
    
    //show list of contigent accounts
    def viewDetails(GlContigentAccount glcontacct){
        println("glcontacct: "+glcontacct)
        println("viewDetails params: "+params.id)
        def glContAcctInstance = GlContigentAccount.get(params.id)
        [glContAcctInstance:glContAcctInstance]
    }
    //insert values to table createContingentAccounts
    def createcontigent(){

    }
    def savecontigent(){
        println("params contigent: "+params)
        def loanInstance = params.loan.id
        def contiGent
        println("branch id: "+UserMaster.get(session.user_id).branch)
        
        def glcontacct = new GlContigentAccount()
        glcontacct.branch = UserMaster.get(session.user_id).branch
        glcontacct.contigent = ContigentAccount.get(params.contigent)
        glcontacct.createdByUser = UserMaster.get(session.user_id)
        //glcontacct.creditAmt = creditAmtvalue
        //glcontacct.debitAmt = debitAmtvalue
        glcontacct.particulars = params.particulars.toString()
        glcontacct.reference = params.reference.toString()
        glcontacct.status = ConfigItemStatus.get(2)
        glcontacct.txnDate = Branch.get(1).runDate
        glcontacct.timestamp = new Date()
        glcontacct.remarks = params.remarks.toString()
        glcontacct.registeredMortgage = params.registeredMortgage ? (params.registeredMortgage.toString().replaceAll(",","")).toDouble() : null
        glcontacct.currentCustodian = params.currentCustodian.toString()
        glcontacct.nominalValue = params.nominalValue ? (params.nominalValue.toString().replaceAll(",","")).toInteger() : null
        glcontacct.titleNo = params.titleNo.toString()
        glcontacct.loan = Loan.get(params.loan.id)
        glcontacct.accountNo = params.accountNo.toString()
        glcontacct.save(flush:true,failOnError: true)
        redirect(action: "viewDetails", id:glcontacct.id)
    }
    // update or edit specific ContigentAccounts
    def updatecontAcct(){
        
      println("params: "+params)
      def GlContAccts = GlContigentAccount.get(params.id)
      [GlContAccts:GlContAccts]
        
    }
    def updatecontAcctajax(){
        println("update params: "+params)
        def loanididid = ""
        if(params.loan.id == "" || params.loan.id == null){
            println("OLD LOAN ID")
            loanididid = Loan.get(params.oldloan)
        }else{
            println("NEW LOAN ID")
            loanididid =  Loan.get(params.loan.id)
        }
        def glcontacct = GlContigentAccount.get(params.contigentID)
        //glcontacct.branch = UserMaster.get(session.user_id).branch
        glcontacct.contigent = ContigentAccount.get(params.contigent)
        //glcontacct.createdByUser = UserMaster.get(session.user_id)
        //glcontacct.creditAmt = creditAmtvalue
        //glcontacct.debitAmt = debitAmtvalue
        glcontacct.particulars = params.particulars.toString()
        glcontacct.reference = params.reference.toString()
        glcontacct.status = ConfigItemStatus.get(params.status)
        //glcontacct.txnDate = Branch.get(1).runDate
        //glcontacct.timestamp = new Date()
        glcontacct.remarks = params.remarks.toString()
        glcontacct.registeredMortgage = params.registeredMortgage ? (params.registeredMortgage.toString().replaceAll(",","")).toDouble() : null
        glcontacct.currentCustodian = params.currentCustodian.toString()
        glcontacct.nominalValue = params.nominalValue ? (params.nominalValue.toString().replaceAll(",","")).toInteger() : null
        glcontacct.titleNo = params.titleNo.toString()
        glcontacct.loan = loanididid
        glcontacct.accountNo = loanididid.accountNo
        glcontacct.save(flush:true,failOnError: true)
        redirect(action: "viewDetails", id:glcontacct.id)
    }
    
    def removeContigentAccountAjax(){
        
        def GlContAccts = GlContigentAccount.get(params.id)
        GlContAccts.status = ConfigItemStatus.get(3);
        GlContAccts.save flush:true
        
       def messageConfirm = "Successfully Removed Contigent Account!"
       println(messageConfirm)
            //respond GlContigentAccountList, model:[BranchInstanceCount: GlContigentAccountList.totalCount]
       redirect(action:"index",model:[messageConfirmInstance:messageConfirm])
        
    }
    
    
}
