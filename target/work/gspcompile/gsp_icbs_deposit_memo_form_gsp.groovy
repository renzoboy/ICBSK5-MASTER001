import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_memo_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/memo/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (flash.message == "Memo Remittance Successfully made.|success|alert")) {
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',22,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(4)
invokeTag('render','g',24,['template':("memo/form/remittance/credit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',26,['name':("remitanceFormSend"),'controller':("deposit"),'action':("saveMemoRemittance")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',30,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(7)
invokeTag('render','g',32,['template':("memo/form/creditAdjustment/credit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',34,['name':("adjustmentFormSend"),'id':("adjustmentFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',38,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(9)
invokeTag('render','g',40,['template':("memo/form/billsPayment/debit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',42,['name':("billsPaymentFormSend"),'controller':("deposit"),'action':("saveMemoBillsPayment")],2)
printHtmlPart(10)
}
else if(true && (flash.message == "Bills Payment Successfully made.|success|alert")) {
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',60,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(9)
invokeTag('render','g',62,['template':("memo/form/billsPayment/debit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',64,['name':("billsPaymentFormSend"),'controller':("deposit"),'action':("saveMemoBillsPayment")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',68,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(4)
invokeTag('render','g',70,['template':("memo/form/remittance/credit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',72,['name':("remitanceFormSend"),'controller':("deposit"),'action':("saveMemoRemittance")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',76,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(7)
invokeTag('render','g',78,['template':("memo/form/creditAdjustment/credit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',80,['name':("adjustmentFormSend"),'id':("adjustmentFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],2)
printHtmlPart(12)
}
else {
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',99,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(7)
invokeTag('render','g',101,['template':("memo/form/creditAdjustment/credit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',103,['name':("adjustmentFormSend"),'id':("adjustmentFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',107,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(4)
invokeTag('render','g',109,['template':("memo/form/remittance/credit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',111,['name':("remitanceFormSend"),'controller':("deposit"),'action':("saveMemoRemittance")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(3)
invokeTag('hiddenField','g',115,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(9)
invokeTag('render','g',117,['template':("memo/form/billsPayment/debit/form")],-1)
printHtmlPart(5)
})
invokeTag('form','g',119,['name':("billsPaymentFormSend"),'controller':("deposit"),'action':("saveMemoBillsPayment")],2)
printHtmlPart(10)
}
printHtmlPart(14)
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
