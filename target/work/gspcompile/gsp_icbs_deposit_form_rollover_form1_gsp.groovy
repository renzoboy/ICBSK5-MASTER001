import icbs.deposit.Rollover
import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_rollover_form1_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/rollover/_form1.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('textField','g',7,['id':("roll1"),'name':("roll1"),'value':(currentRollover?.type?.id)],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['id':("roll2"),'name':("roll2"),'value':(depositInstance?.currentRollover?.type?.id)],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['id':("roll3"),'name':("roll3"),'value':(interestPaymentMode)],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['id':("roll4"),'name':("roll4"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id)],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['id':("roll9"),'name':("roll9"),'value':("TESTING")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.type', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("rollover.type.label"),'default':("Rollover Type")],-1)
printHtmlPart(5)
invokeTag('select','g',17,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.type"),'name':("currentRollover.type.id"),'from':(icbs.lov.RolloverType.list()),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance? depositInstance.currentRollover?.type?.id:currentRollover.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',23,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',24,['bean':(depositInstance),'field':("currentRollover.type")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',27,['bean':(depositInstance),'field':("currentRollover.type")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.startDate', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',32,['code':("rollover.startDate.label"),'default':("Start Date")],-1)
printHtmlPart(13)
invokeTag('customDatePicker','g',36,['format':("date"),'disabled':("disabled"),'name':("currentRollover.startDate"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.startDate?:Branch?.get(1).runDate:currentRollover?.startDate)],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',42,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',43,['bean':(depositInstance),'field':("currentRollover.startDate")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',46,['bean':(depositInstance),'field':("currentRollover.startDate")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.endDate', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',51,['code':("rollover.endDate.label"),'default':("End Date")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',54,['id':("endDateCalculator"),'name':("endDateCalculator"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(17)
invokeTag('customDatePicker','g',55,['name':("currentRollover.endDate"),'onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'precision':("day"),'class':("form-control"),'value':(depositInstance?.currentRollover?.endDate)],-1)
printHtmlPart(18)
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
printHtmlPart(14)
expressionOut.print(hasErrors(bean: depositInstance, field: 'currentRollover.interestPaymentMode', 'has-error'))
printHtmlPart(19)
if(true && ((currentRollover?.type?.id==1&&depositInstance?.currentRollover?.type?.id==1)&&!interestPaymentMode)) {
printHtmlPart(20)
invokeTag('message','g',70,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(21)
invokeTag('select','g',73,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([2,3])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(22)
}
else if(true && (currentRollover?.type?.id==2||depositInstance?.currentRollover?.type?.id==2)) {
printHtmlPart(20)
invokeTag('message','g',78,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(21)
invokeTag('select','g',81,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([3])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(23)
}
else if(true && (currentRollover?.type?.id==3||depositInstance?.currentRollover?.type?.id==3)) {
printHtmlPart(20)
invokeTag('message','g',86,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(24)
invokeTag('select','g',88,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([1,2])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (currentRollover?.type?.id==1||depositInstance?.currentRollover?.type?.id==1||!interestPaymentMode)) {
printHtmlPart(20)
invokeTag('message','g',93,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(21)
invokeTag('select','g',96,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([2,3])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(27)
}
printHtmlPart(27)
if(true && (currentRollover?.type?.id==2&&depositInstance?.currentRollover?.type?.id==2)) {
printHtmlPart(20)
invokeTag('message','g',100,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(21)
invokeTag('select','g',103,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([3])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(27)
}
printHtmlPart(27)
if(true && (currentRollover?.type?.id==3&&depositInstance?.currentRollover?.type?.id==3)) {
printHtmlPart(20)
invokeTag('message','g',107,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(24)
invokeTag('select','g',109,['onchange':("changeRolloverForm(document.getElementById('currentRollover.type').value)"),'id':("currentRollover.interestPaymentMode"),'name':("currentRollover.interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([1,2])),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.currentRollover?.interestPaymentMode?.id?depositInstance?.currentRollover?.interestPaymentMode?.id:interestPaymentMode),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(28)
}
printHtmlPart(29)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',116,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',117,['bean':(depositInstance),'field':("currentRollover.interestPaymentMode")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',120,['bean':(depositInstance),'field':("currentRollover.interestPaymentMode")],1)
printHtmlPart(30)
if(true && (interestPaymentMode=='2'||depositInstance?.currentRollover?.interestPaymentMode?.id==2)) {
printHtmlPart(31)
invokeTag('hiddenField','g',124,['id':("fundedDepAcctNo"),'name':("fundedDepAcctNo"),'value':(depositInstance?.currentRollover?.fundedDeposit)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',125,['name':("currentRollover.fundedDeposit"),'id':("currentRollover.fundedDeposit.id"),'value':(depositInstance?.currentRollover?.fundedDeposit?.id)],-1)
printHtmlPart(33)
invokeTag('render','g',128,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance?.currentRollover?.fundedDeposit,boxName:'Transfer to Deposit Account'])],-1)
printHtmlPart(34)
}
printHtmlPart(35)
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
