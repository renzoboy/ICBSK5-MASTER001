import icbs.tellering.TxnRemittance
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashReceiptRemittance_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashReceiptRemittance/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("txnDepIDSender"),'id':("txnDepIDSender"),'value':(customerInstance?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',3,['name':("txnDepIDBenef"),'id':("txnDepIDBenef"),'value':(customerInstance?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',4,['name':("txnIdent"),'id':("txnIdent")],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',5,['id':("CashReceiptRemittance"),'name':("CashReceiptRemittance"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(2),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (!txnCashReceiptRemittanceInstance?.sender)) {
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('render','g',26,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCashReceiptRemittanceInstance?.sender])],-1)
printHtmlPart(8)
if(true && (!txnCashReceiptRemittanceInstance?.beneficiary)) {
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('render','g',38,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCashReceiptRemittanceInstance?.beneficiary])],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(12)
invokeTag('textField','g',45,['type':("number"),'id':("txnAmt"),'name':("txnAmt"),'required':(""),'value':(txnCashReceiptRemittanceInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'controlNo', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',51,['code':("txnCashReceiptRemittance.controlNo.label"),'default':("Control Number")],-1)
printHtmlPart(15)
invokeTag('textField','g',54,['name':("controlNo"),'value':(txnCashReceiptRemittanceInstance?.controlNo),'class':("form-control")],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',61,['code':("txnCashReceiptRemittance.txnParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(15)
invokeTag('textArea','g',64,['name':("txnParticulars"),'value':(txnCashReceiptRemittanceInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnRef', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',70,['code':("txnCashReceiptRemittance.txnRef.label"),'default':("Payout Instructions")],-1)
printHtmlPart(19)
invokeTag('textArea','g',72,['name':("txnRef"),'value':(txnCashReceiptRemittanceInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(20)
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
