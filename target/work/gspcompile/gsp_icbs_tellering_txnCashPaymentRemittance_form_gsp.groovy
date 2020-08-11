import icbs.tellering.TxnRemittance
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashPaymentRemittance_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashPaymentRemittance/_form.gsp" }
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
invokeTag('hiddenField','g',5,['id':("OtherCashPaymentRemit"),'name':("OtherCashPaymentRemit"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(21), icbs.lov.MemoTxnType.read(2),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (!txnCashPaymentRemittanceInstance?.sender)) {
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('render','g',51,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCashPaymentRemittanceInstance?.sender])],-1)
printHtmlPart(9)
if(true && (!txnCashPaymentRemittanceInstance?.beneficiary)) {
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('render','g',63,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCashPaymentRemittanceInstance?.beneficiary])],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnCashPaymentRemittanceInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',70,['type':("number"),'name':("txnAmt"),'required':(""),'value':(txnCashPaymentRemittanceInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnRemittanceInstance, field: 'controlNo', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',76,['code':("txnRemittance.controlNo.label"),'default':("Control Number")],-1)
printHtmlPart(16)
invokeTag('textField','g',79,['name':("controlNo"),'value':(txnRemittanceInstance?.controlNo),'class':("form-control")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: txnRemittanceInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',86,['code':("txnRemittance.txnParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(16)
invokeTag('textArea','g',89,['name':("txnParticulars"),'value':(txnRemittanceInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnCashReceiptRemittanceInstance, field: 'txnRef', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',95,['code':("txnCashReceiptRemittance.txnRef.label"),'default':("Payout Instructions")],-1)
printHtmlPart(20)
invokeTag('textArea','g',97,['name':("txnRef"),'value':(txnCashReceiptRemittanceInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(21)
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
