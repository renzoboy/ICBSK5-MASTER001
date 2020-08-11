import icbs.tellering.TxnCOCI
import icbs.tellering.TxnDepositAcctLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckEncashment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckEncashment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(6),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.requirePassbook)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(5)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (!txnCheckEncashmentInstance?.acct)) {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('render','g',51,['template':("/tellering/details/depositDetails"),'model':([depositInstance:txnCheckEncashmentInstance?.acct])],-1)
printHtmlPart(10)
if(true && (txnCheckEncashmentInstance?.acct)) {
printHtmlPart(11)
invokeTag('render','g',53,['template':("/tellering/details/signatureDetails"),'model':([depositInstance:txnCheckEncashmentInstance?.acct])],-1)
printHtmlPart(11)
invokeTag('render','g',54,['template':("/tellering/details/signatoryDetails"),'model':([depositInstance:txnCheckEncashmentInstance?.acct])],-1)
printHtmlPart(10)
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnCheckEncashmentInstance, field: 'passbookBal', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',63,['type':("number"),'name':("passbookBal"),'required':(""),'value':(""),'class':("form-control truncated"),'readonly':("true")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnCheckEncashmentInstance, field: 'payee', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',72,['code':("txnCheckEncashment.payee.label"),'default':("Payee")],-1)
printHtmlPart(16)
invokeTag('textField','g',76,['id':("payee"),'name':("payee"),'value':(txnCheckEncashmentInstance?.payee),'class':("form-control")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: txnCheckEncashmentInstance, field: 'checkDate', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',83,['code':("txnCheckEncashment.checkDate.label"),'default':("Check Date")],-1)
printHtmlPart(19)
invokeTag('customDatePicker','g',87,['name':("checkDate"),'precision':("day"),'class':("form-control"),'value':(txnCheckEncashmentInstance?.checkDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: txnCheckEncashmentInstance, field: 'checkNo', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',94,['code':("txnCheckEncashment.checkNo.label"),'default':("Check Number")],-1)
printHtmlPart(22)
invokeTag('textField','g',97,['type':("number"),'id':("checkNo"),'name':("checkNo"),'required':(""),'value':(txnCheckEncashmentInstance?.checkNo),'class':("form-control")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: txnCheckEncashmentInstance, field: 'checkAmt', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',104,['code':("txnCheckEncashment.checkAmt.label"),'default':("Check Amount")],-1)
printHtmlPart(19)
invokeTag('textField','g',108,['type':("number"),'id':("checkAmt"),'name':("checkAmt"),'required':(""),'value':(txnCheckEncashmentInstance?.checkAmt),'class':("form-control truncated")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: txnCheckEncashmentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',115,['code':("txnCheckEncashment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(16)
invokeTag('textArea','g',119,['name':("txnRef"),'value':(txnCheckEncashmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(27)
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
