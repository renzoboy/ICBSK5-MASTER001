import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_standingOrder_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/standingOrder/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("id"),'value':(standingOrderInstance?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("fundingDeposit"),'name':("fundingDeposit.id"),'value':(standingOrderInstance?.fundingDeposit?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'fundedDeposit', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',13,['code':("standingOrder.fundedDeposit.label"),'default':("Transfer to Account")],-1)
printHtmlPart(4)
if(true && (!standingOrderInstance?.id)) {
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('hiddenField','g',21,['id':("fundedDeposit"),'name':("fundedDeposit.id"),'value':(standingOrderInstance?.fundedDeposit?.id)],-1)
printHtmlPart(7)
invokeTag('textField','g',22,['id':("fundedDeposit"),'name':("fundedDeposit.acctNo"),'disabled':("disabled"),'value':(standingOrderInstance?.fundedDeposit?.acctNo)],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',28,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',29,['bean':(standingOrderInstance),'field':("fundedDeposit")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',32,['bean':(standingOrderInstance),'field':("fundedDeposit")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'type', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',37,['code':("standingOrder.type.label"),'default':("Type")],-1)
printHtmlPart(15)
invokeTag('select','g',40,['id':("type"),'onchange':("updateForm()"),'name':("type.id"),'from':(icbs.lov.StandingOrderType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(standingOrderInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',46,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',47,['bean':(standingOrderInstance),'field':("type")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',50,['bean':(standingOrderInstance),'field':("type")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'freq', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',57,['code':("standingOrder.freq.label"),'default':("Freq")],-1)
printHtmlPart(15)
invokeTag('select','g',60,['id':("freq"),'name':("freq.id"),'from':(icbs.lov.StandingOrderFreq.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(standingOrderInstance?.freq?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',66,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',67,['bean':(standingOrderInstance),'field':("freq")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',70,['bean':(standingOrderInstance),'field':("freq")],1)
printHtmlPart(18)
if(true && (standingOrderInstance?.type?.id==1||!standingOrderInstance?.type)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'fundFixedAmt', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',76,['code':("standingOrder.fundFixedAmt.label"),'default':("Fund Fixed Amt")],-1)
printHtmlPart(23)
invokeTag('field','g',79,['name':("fundFixedAmt"),'value':(fieldValue(bean: standingOrderInstance, field: 'fundFixedAmt')),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',85,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',86,['bean':(standingOrderInstance),'field':("fundFixedAmt")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',89,['bean':(standingOrderInstance),'field':("fundFixedAmt")],1)
printHtmlPart(24)
if(true && (standingOrderInstance?.type?.id==2)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'percent', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',96,['code':("standingOrder.percent.label"),'default':("Percent")],-1)
printHtmlPart(23)
invokeTag('field','g',99,['name':("percent"),'value':(fieldValue(bean: standingOrderInstance, field: 'percent')),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',105,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',106,['bean':(standingOrderInstance),'field':("percent")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',109,['bean':(standingOrderInstance),'field':("percent")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'retries', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',116,['code':("standingOrder.retries.label"),'default':("Retries")],-1)
printHtmlPart(15)
invokeTag('field','g',119,['name':("retries"),'type':("number"),'value':(standingOrderInstance.retries),'required':(""),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',125,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',126,['bean':(standingOrderInstance),'field':("retries")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',129,['bean':(standingOrderInstance),'field':("retries")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: standingOrderInstance, field: 'status', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',136,['code':("standingOrder.status.label"),'default':("Status")],-1)
printHtmlPart(23)
invokeTag('select','g',139,['id':("status"),'name':("status.id"),'from':(icbs.lov.StandingOrderStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(standingOrderInstance?.status?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',145,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',146,['bean':(standingOrderInstance),'field':("status")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',149,['bean':(standingOrderInstance),'field':("status")],1)
printHtmlPart(29)
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
