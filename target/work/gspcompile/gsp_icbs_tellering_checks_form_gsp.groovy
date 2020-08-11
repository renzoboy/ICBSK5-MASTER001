import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_checks_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/checks/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',24,['bean':(txnCOCIInstance)],1)
printHtmlPart(5)
invokeTag('hiddenField','g',27,['name':("deposit_id"),'id':("deposit_id"),'value':("")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'checkType', 'has-error'))
printHtmlPart(7)
invokeTag('select','g',31,['id':("checkType"),'name':("checkType.id"),'from':(icbs.admin.CheckDepositClearingType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(txnCOCIInstance?.checkType?.id),'onChange':("validateOnUs();"),'noSelection':(['': '']),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',38,['bean':(txnCOCIInstance),'field':("checkType")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',41,['bean':(txnCOCIInstance),'field':("checkType")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'bank', 'has-error'))
printHtmlPart(14)
invokeTag('select','g',49,['id':("bank"),'name':("bank.id"),'from':(icbs.admin.ClearingBank.findAllByConfigItemStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'required':(""),'optionValue':("name"),'value':(txnCOCIInstance?.bank?.id),'noSelection':(['': '']),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',56,['bean':(txnCOCIInstance),'field':("bank")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',59,['bean':(txnCOCIInstance),'field':("bank")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'acctNo', 'has-error'))
printHtmlPart(21)
invokeTag('textField','g',66,['name':("acctNo"),'required':(""),'value':(txnCOCIInstance?.acct),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',72,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',73,['bean':(txnCOCIInstance),'field':("acct")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',76,['bean':(txnCOCIInstance),'field':("acct")],1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'checkDate', 'has-error'))
printHtmlPart(23)
invokeTag('customDatePicker','g',83,['id':("checkDate"),'name':("checkDate"),'precision':("day"),'class':("form-control"),'value':(txnCOCIInstance?.checkDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(24)
expressionOut.print(txnCOCIInstance?.checkDate)
printHtmlPart(25)
createClosureForHtmlPart(26, 1)
invokeTag('javascript','g',92,[:],1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',98,['bean':(txnCOCIInstance),'field':("checkDate")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',101,['bean':(txnCOCIInstance),'field':("checkDate")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'checkNo', 'has-error'))
printHtmlPart(28)
invokeTag('textField','g',108,['name':("checkNo"),'required':(""),'value':(txnCOCIInstance?.checkNo),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',114,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',115,['bean':(txnCOCIInstance),'field':("checkNo")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',118,['bean':(txnCOCIInstance),'field':("checkNo")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'checkAmt', 'has-error'))
printHtmlPart(30)
invokeTag('textField','g',126,['type':("number"),'name':("checkAmt"),'required':(""),'value':(txnCOCIInstance?.checkAmt),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',132,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',133,['bean':(txnCOCIInstance),'field':("checkAmt")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',136,['bean':(txnCOCIInstance),'field':("checkAmt")],1)
printHtmlPart(31)
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
