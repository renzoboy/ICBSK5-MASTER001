import icbs.deposit.Rollover
import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_rollover_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/rollover/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('textField','g',6,['id':("roll1"),'name':("roll1"),'value':("CURROLTYPEID+ ${currentRollover?.type?.id}")],-1)
printHtmlPart(2)
invokeTag('textField','g',7,['id':("roll2"),'name':("roll2"),'value':("DEPCURROLTYPE+ ${depositInstance?.currentRollover?.type?.id}")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['id':("roll3"),'name':("roll3"),'value':("INTPAYMODE+ ${interestPaymentMode}")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['id':("roll4"),'name':("roll4"),'value':("DEPINTMODID+ ${depositInstance?.currentRollover?.interestPaymentMode?.id}")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.type', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',12,['code':("rollover.type.label"),'default':("Rollover Type")],-1)
printHtmlPart(5)
invokeTag('select','g',15,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.type"),'name':("currentRollover.type.id"),'from':(icbs.lov.RolloverType.list()),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance? depositInstance.currentRollover?.type?.id:currentRollover.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',21,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',22,['bean':(depositInstance),'field':("currentRollover.type")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',25,['bean':(depositInstance),'field':("currentRollover.type")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.startDate', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',30,['code':("rollover.startDate.label"),'default':("Start Date")],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',33,['name':("currentRollover.startDate"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.startDate?:Branch?.get(1).runDate.format("MM/dd/yyyy"):currentRollover?.startDate.format("MM/dd/yyyy"))],-1)
printHtmlPart(14)
invokeTag('field','g',34,['format':("date"),'readonly':("true"),'name':("currentRollover.startDate"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.startDate?:Branch?.get(1).runDate.format("MM/dd/yyyy"):currentRollover?.startDate.format("MM/dd/yyyy"))],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',40,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',41,['bean':(depositInstance),'field':("currentRollover.startDate")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',44,['bean':(depositInstance),'field':("currentRollover.startDate")],1)
printHtmlPart(15)
invokeTag('hiddenField','g',48,['id':("endDateCalculator"),'name':("endDateCalculator"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.endDate', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',51,['code':("rollover.endDate.label"),'default':("End Date")],-1)
printHtmlPart(18)
invokeTag('field','g',54,['name':("currentRollover.endDate"),'readonly':("true"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(19)
invokeTag('customDatePicker','g',55,['name':("currentRollover.endDate"),'precision':("day"),'class':("form-control"),'onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(20)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',60,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',61,['bean':(depositInstance),'field':("currentRollover.endDate")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',64,['bean':(depositInstance),'field':("currentRollover.endDate")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.interestPaymentMode', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',69,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(23)
invokeTag('select','g',71,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.getAll()),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(24)
if(true && ((currentRollover?.type?.id==1 || depositInstance?.currentRollover?.type?.id==1))) {
printHtmlPart(25)
invokeTag('message','g',75,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(26)
invokeTag('select','g',77,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([2,3])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(27)
}
else if(true && (currentRollover?.type?.id==2 || depositInstance?.currentRollover?.type?.id==2)) {
printHtmlPart(25)
invokeTag('message','g',82,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(26)
invokeTag('select','g',84,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([3])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(27)
}
else if(true && (currentRollover?.type?.id==3 || depositInstance?.currentRollover?.type?.id==3)) {
printHtmlPart(25)
invokeTag('message','g',89,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(26)
invokeTag('select','g',91,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([1,2])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(28)
}
else if(true && (!currentRollover?.type?.id && !depositInstance?.currentRollover?.type?.id && !interestPaymentMode)) {
printHtmlPart(25)
invokeTag('message','g',96,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(26)
invokeTag('select','g',98,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.getAll()),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(29)
}
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',106,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',107,['bean':(depositInstance),'field':("currentRollover.interestPaymentMode")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',110,['bean':(depositInstance),'field':("currentRollover.interestPaymentMode")],1)
printHtmlPart(30)
if(true && (interestPaymentMode=='2'||depositInstance?.currentRollover?.interestPaymentMode?.id==2)) {
printHtmlPart(31)
invokeTag('hiddenField','g',114,['name':("currentRollover.fundedDeposit"),'id':("currentRollover.fundedDeposit.id"),'value':(currentRollover?.fundedDeposit?.id)],-1)
printHtmlPart(31)
invokeTag('hiddenField','g',115,['name':("oldfundedDeposit"),'id':("oldfundedDeposit.id"),'value':(currentRollover?.fundedDeposit?.id)],-1)
printHtmlPart(32)
invokeTag('render','g',118,['template':("/deposit/details/depositDetails"),'model':([depositInstance:currentRollover?.fundedDeposit,boxName:'Transfer to Deposit Account'])],-1)
printHtmlPart(33)
}
printHtmlPart(34)
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
