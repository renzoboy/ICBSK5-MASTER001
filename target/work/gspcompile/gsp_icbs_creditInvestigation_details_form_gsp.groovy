import icbs.loans.CreditInvestigation
import icbs.lov.LoanApplicationStatusNR
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigation_details_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/details/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (creditTypeAction == "secured")) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('hiddenField','g',11,['name':("securedUnsec"),'id':("securedUnsec"),'value':(creditTypeAction)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("creditInvestigation.loanApplication.label"),'default':("Account Application")],-1)
printHtmlPart(7)
invokeTag('field','g',17,['name':("loanApplication"),'type':("number"),'value':(creditInvestigationInstance?.loanApplication?.id),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',18,['name':("loanAppSecOrUnsecId"),'id':("loanAppSecOrUnsecId"),'value':("")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',23,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',24,['bean':(creditInvestigationInstance),'field':("loanApplication")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',27,['bean':(creditInvestigationInstance),'field':("loanApplication")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',36,['code':("creditInvestigation.loanApplication.customer.label"),'default':("Borrower Name")],-1)
printHtmlPart(15)
invokeTag('textField','g',40,['name':("borrowerName"),'id':("borrowerName"),'value':(creditInvestigationInstance?.loanApplication?.customer?.displayName),'readonly':("true"),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',45,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',46,['bean':(accountsReceivableInstance),'field':("status")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',49,['bean':(creditInvestigationInstance),'field':("status")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',54,['code':("creditInvestigation.loanApplication.amount.label"),'default':("Amount Applied")],-1)
printHtmlPart(15)
invokeTag('textField','g',58,['name':("amount"),'id':("amount"),'value':(creditInvestigationInstance?.loanApplication?.amount),'readonly':("true"),'class':("form-control truncated")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',64,['bean':(accountsReceivableInstance),'field':("status")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',67,['bean':(creditInvestigationInstance),'field':("status")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'status', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',72,['code':("creditInvestigation.status.label"),'default':("Status")],-1)
printHtmlPart(15)
invokeTag('select','g',76,['id':("status"),'name':("status.id"),'from':(icbs.lov.LoanApplicationStatusNR.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(creditInvestigationInstance?.status?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',81,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',82,['bean':(accountsReceivableInstance),'field':("status")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',85,['bean':(creditInvestigationInstance),'field':("status")],1)
printHtmlPart(21)
if(true && (creditTypeAction == "secured")) {
printHtmlPart(22)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'folderReceivedByBranchDept', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',94,['code':("creditInvestigation.folderReceivedByBranchDept.label"),'default':("Date Folder Received by Branches Dept")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',97,['name':("folderReceivedByBranchDept"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.folderReceivedByBranchDept)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',103,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',104,['bean':(creditInvestigationInstance),'field':("folderReceivedByBranchDept")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',107,['bean':(creditInvestigationInstance),'field':("folderReceivedByBranchDept")],2)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'folderTransToCau', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',118,['code':("creditInvestigation.folderTransToCau.label"),'default':("Date Received by Credit Department")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',121,['name':("folderTransToCau"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.folderTransToCau)],-1)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',129,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',130,['bean':(creditInvestigationInstance),'field':("folderTransToCau")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',133,['bean':(creditInvestigationInstance),'field':("folderTransToCau")],2)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'assignedToCi', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',139,['code':("creditInvestigation.assignedToCi.label"),'default':("Date Assigned to Credit Investigator")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',142,['name':("assignedToCi"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.assignedToCi)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',148,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',149,['bean':(creditInvestigationInstance),'field':("assignedToCi")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',152,['bean':(creditInvestigationInstance),'field':("assignedToCi")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'deadlineAssignedToCreCom', 'has-error'))
printHtmlPart(37)
invokeTag('message','g',157,['code':("creditInvestigation.deadlineAssignedToCreCom.label"),'default':("Deadline")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',160,['name':("deadlineAssignedToCreCom"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.deadlineAssignedToCreCom)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',166,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',167,['bean':(creditInvestigationInstance),'field':("deadlineAssignedToCreCom")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',170,['bean':(creditInvestigationInstance),'field':("deadlineAssignedToCreCom")],2)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'dateSubByCreditInvestigator', 'has-error'))
printHtmlPart(39)
invokeTag('message','g',177,['code':("creditInvestigation.dateSubByCreditInvestigator.label"),'default':("Date Submitted by Credit Investigator")],-1)
printHtmlPart(40)
invokeTag('customDatePicker','g',181,['name':("dateSubByCreditInvestigator"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.dateSubByCreditInvestigator)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',187,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',188,['bean':(creditInvestigationInstance),'field':("dateSubByCreditInvestigator")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',191,['bean':(creditInvestigationInstance),'field':("dateSubByCreditInvestigator")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'assignedToAnalyst', 'has-error'))
printHtmlPart(41)
invokeTag('message','g',196,['code':("creditInvestigation.assignedToAnalyst.label"),'default':("Date Assigned to Analyst")],-1)
printHtmlPart(40)
invokeTag('customDatePicker','g',200,['name':("assignedToAnalyst"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.assignedToAnalyst)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',206,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',207,['bean':(creditInvestigationInstance),'field':("assignedToAnalyst")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',210,['bean':(creditInvestigationInstance),'field':("assignedToAnalyst")],2)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'deadlineSubAnalystreport', 'has-error'))
printHtmlPart(42)
invokeTag('message','g',217,['code':("creditInvestigation.deadlineSubAnalystreport.label"),'default':("Deadline")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',220,['name':("deadlineSubAnalystreport"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.deadlineSubAnalystreport)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',226,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',227,['bean':(creditInvestigationInstance),'field':("deadlineSubAnalystreport")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',230,['bean':(creditInvestigationInstance),'field':("deadlineSubAnalystreport")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'submitAnalystRep', 'has-error'))
printHtmlPart(43)
invokeTag('message','g',235,['code':("creditInvestigation.submitAnalystRep.label"),'default':("Date Submitted By Analyst ")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',238,['name':("submitAnalystRep"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.submitAnalystRep)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',244,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',245,['bean':(creditInvestigationInstance),'field':("submitAnalystRep")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',248,['bean':(creditInvestigationInstance),'field':("submitAnalystRep")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'reviewDateByManager', 'has-error'))
printHtmlPart(44)
invokeTag('message','g',253,['code':("creditInvestigation.reviewDateByManager.label"),'default':("Date Approved by Manager ")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',256,['name':("reviewDateByManager"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.reviewDateByManager)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',262,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',263,['bean':(creditInvestigationInstance),'field':("reviewDateByManager")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',266,['bean':(creditInvestigationInstance),'field':("reviewDateByManager")],2)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'schedForCac', 'has-error'))
printHtmlPart(45)
invokeTag('message','g',272,['code':("creditInvestigation.schedForCac.label"),'default':("Date Scheduled for CAC")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',275,['name':("schedForCac"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.schedForCac)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',281,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',282,['bean':(creditInvestigationInstance),'field':("schedForCac")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',285,['bean':(creditInvestigationInstance),'field':("schedForCac")],2)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'actualCac', 'has-error'))
printHtmlPart(46)
invokeTag('message','g',291,['code':("creditInvestigation.actualCac.label"),'default':("Date Actual CAC")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',294,['name':("actualCac"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.actualCac)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',300,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',301,['bean':(creditInvestigationInstance),'field':("actualCac")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',304,['bean':(creditInvestigationInstance),'field':("actualCac")],2)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'schedCrecom', 'has-error'))
printHtmlPart(47)
invokeTag('message','g',310,['code':("creditInvestigation.schedCrecom.label"),'default':("Date Scheduled Crecom")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',313,['name':("schedCrecom"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.schedCrecom)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',319,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',320,['bean':(creditInvestigationInstance),'field':("schedCrecom")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',323,['bean':(creditInvestigationInstance),'field':("schedCrecom")],2)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'actualCrecom', 'has-error'))
printHtmlPart(48)
invokeTag('message','g',329,['code':("creditInvestigation.actualCrecom.label"),'default':("Date Actual Crecom")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',332,['name':("actualCrecom"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.actualCrecom)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',338,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',339,['bean':(creditInvestigationInstance),'field':("actualCrecom")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',342,['bean':(creditInvestigationInstance),'field':("actualCrecom")],2)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'ci', 'has-error'))
printHtmlPart(49)
invokeTag('message','g',349,['code':("creditInvestigation.ci.label"),'default':("Credit Investigator")],-1)
printHtmlPart(50)
invokeTag('select','g',353,['id':("ci"),'name':("ci.id"),'from':(icbs.admin.UserMaster.list()),'noSelection':(['null':'No Credit Investigator']),'optionKey':("id"),'optionValue':("username"),'required':(""),'value':(creditInvestigationInstance?.ci?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(52)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('message','g',358,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',359,['bean':(accountsReceivableInstance),'field':("ci")],3)
printHtmlPart(53)
})
invokeTag('hasErrors','g',362,['bean':(creditInvestigationInstance),'field':("ci")],2)
printHtmlPart(54)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'analyst', 'has-error'))
printHtmlPart(55)
invokeTag('message','g',369,['code':("creditInvestigation.analyst.label"),'default':("Analyst")],-1)
printHtmlPart(50)
invokeTag('select','g',373,['id':("analyst"),'name':("analyst.id"),'from':(icbs.admin.UserMaster.list()),'optionKey':("id"),'optionValue':("username"),'required':(""),'value':(creditInvestigationInstance?.analyst?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(52)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('message','g',378,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',379,['bean':(accountsReceivableInstance),'field':("analyst")],3)
printHtmlPart(53)
})
invokeTag('hasErrors','g',382,['bean':(creditInvestigationInstance),'field':("analyst")],2)
printHtmlPart(54)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'approvalDate', 'has-error'))
printHtmlPart(56)
invokeTag('message','g',389,['code':("creditInvestigation.approvalDate.label"),'default':("Lending Authority Approval Date")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',392,['name':("approvalDate"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.approvalDate)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',398,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',399,['bean':(creditInvestigationInstance),'field':("approvalDate")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',402,['bean':(creditInvestigationInstance),'field':("approvalDate")],2)
printHtmlPart(57)
}
printHtmlPart(58)
if(true && (creditTypeAction == "unsecured")) {
printHtmlPart(22)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'folderReceivedByBranchDept', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',411,['code':("creditInvestigation.folderReceivedByBranchDept.label"),'default':("Date Endorsed to Branch Department")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',414,['name':("unsecfolderReceivedByBranchDept"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.folderReceivedByBranchDept)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',420,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',420,['bean':(creditInvestigationInstance),'field':("folderReceivedByBranchDept")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',423,['bean':(creditInvestigationInstance),'field':("folderReceivedByBranchDept")],2)
printHtmlPart(59)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'folderReceivedByBranchDept', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',429,['code':("creditInvestigation.folderReceivedByBranchDept.label"),'default':("Date Accepted By Branch Department")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',432,['name':("unsecfolderTransToCau"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.folderTransToCau)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',438,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',438,['bean':(creditInvestigationInstance),'field':("folderTransToCau")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',441,['bean':(creditInvestigationInstance),'field':("folderTransToCau")],2)
printHtmlPart(60)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'assignedToCi', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',453,['code':("creditInvestigation.folderTransToCau.label"),'default':("Date Endorsed to Credit Manager")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',456,['name':("unsecassignedToCi"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.assignedToCi)],-1)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',464,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',464,['bean':(creditInvestigationInstance),'field':("assignedToCi")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',467,['bean':(creditInvestigationInstance),'field':("assignedToCi")],2)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'schedForCi', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',474,['code':("creditInvestigation.assignedToCi.label"),'default':("Date Endorsed to CRC")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',477,['name':("unsecschedForCi"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.schedForCi)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',483,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',483,['bean':(creditInvestigationInstance),'field':("schedForCi")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',486,['bean':(creditInvestigationInstance),'field':("schedForCi")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'performedCi', 'has-error'))
printHtmlPart(56)
invokeTag('message','g',492,['code':("creditInvestigation.deadlineAssignedToCreCom.label"),'default':("Date of Endorsement for approval")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',495,['name':("unsecperformedCi"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.performedCi)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',501,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',501,['bean':(creditInvestigationInstance),'field':("performedCi")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',504,['bean':(creditInvestigationInstance),'field':("performedCi")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'assignedToAnalyst', 'has-error'))
printHtmlPart(41)
invokeTag('message','g',510,['code':("creditInvestigation.deadlineAssignedToCreCom.label"),'default':("Date approval of President")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',513,['name':("unsecassignedToAnalyst"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.assignedToAnalyst)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',519,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',519,['bean':(creditInvestigationInstance),'field':("assignedToAnalyst")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',522,['bean':(creditInvestigationInstance),'field':("assignedToAnalyst")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'schedForAnalyst', 'has-error'))
printHtmlPart(56)
invokeTag('message','g',528,['code':("creditInvestigation.schedForAnalyst.label"),'default':("Date Endorsement of approval to Branch")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',531,['name':("unsecschedForAnalyst"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.schedForAnalyst)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',537,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',537,['bean':(creditInvestigationInstance),'field':("schedForAnalyst")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',540,['bean':(creditInvestigationInstance),'field':("schedForAnalyst")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'recommendation', 'has-error'))
printHtmlPart(56)
invokeTag('message','g',546,['code':("creditInvestigation.deadlineAssignedToCreCom.label"),'default':("Reason for Return")],-1)
printHtmlPart(24)
invokeTag('textArea','g',549,['name':("unsecrecommendation"),'value':(creditInvestigationInstance?.recommendation),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',555,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',555,['bean':(creditInvestigationInstance),'field':("recommendation")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',558,['bean':(creditInvestigationInstance),'field':("recommendation")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'performedByAnalyst', 'has-error'))
printHtmlPart(56)
invokeTag('message','g',564,['code':("creditInvestigation.performedByAnalyst.label"),'default':("Date Return to Branch")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',567,['name':("unsecperformedByAnalyst"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.performedByAnalyst)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',573,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',573,['bean':(creditInvestigationInstance),'field':("performedByAnalyst")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',576,['bean':(creditInvestigationInstance),'field':("performedByAnalyst")],2)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: creditInvestigationInstance, field: 'submitAnalystRep', 'has-error'))
printHtmlPart(56)
invokeTag('message','g',582,['code':("creditInvestigation.submitAnalystRep.label"),'default':("Date Return to Branches Department")],-1)
printHtmlPart(24)
invokeTag('customDatePicker','g',585,['name':("unsecsubmitAnalystRep"),'precision':("day"),'class':("form-control"),'value':(creditInvestigationInstance?.submitAnalystRep)],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',591,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',591,['bean':(creditInvestigationInstance),'field':("submitAnalystRep")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',594,['bean':(creditInvestigationInstance),'field':("submitAnalystRep")],2)
printHtmlPart(57)
}
printHtmlPart(61)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1592209176000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
