import icbs.tellering.TxnBillsPayment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckBillsPayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckBillsPayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',3,['id':("CashReceiptCheckBills"),'name':("CashReceiptCheckBills"),'value':("0")],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',4,['name':("txnDepID"),'id':("txnDepID"),'value':(customerInstance?.id)],-1)
printHtmlPart(2)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(20), icbs.lov.MemoTxnType.read(3),[sort:"code", order:"asc"])) ) {
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(5)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (!txnCheckBillsPaymentInstance?.beneficiary)) {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('render','g',25,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCheckBillsPaymentInstance?.beneficiary])],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: txnCheckBillsPaymentInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(11)
invokeTag('textField','g',32,['type':("number"),'name':("txnAmt"),'required':(""),'value':(txnCheckBillsPaymentInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(12)
if(true && (txnCOCIInstance?.checks)) {
printHtmlPart(13)
for( check in (txnCOCIInstance?.checks.sort{it.description}) ) {
printHtmlPart(14)
expressionOut.print(check?.checkType?.description)
printHtmlPart(15)
expressionOut.print(check?.bank?.name)
printHtmlPart(15)
expressionOut.print(check?.acctNo)
printHtmlPart(15)
expressionOut.print(check?.checkDate)
printHtmlPart(15)
expressionOut.print(check?.checkNo)
printHtmlPart(15)
expressionOut.print(check?.checkAmt)
printHtmlPart(16)
expressionOut.print(check?.id)
printHtmlPart(17)
}
printHtmlPart(18)
}
else if(true && (session["checks"])) {
printHtmlPart(13)
invokeTag('set','g',70,['var':("i"),'value':(0)],-1)
printHtmlPart(13)
for( check in (session["checks"]) ) {
printHtmlPart(14)
expressionOut.print(check?.checkType?.description)
printHtmlPart(15)
expressionOut.print(check?.bank?.name)
printHtmlPart(15)
expressionOut.print(check?.acctNo)
printHtmlPart(15)
expressionOut.print(check?.checkDate)
printHtmlPart(15)
expressionOut.print(check?.checkNo)
printHtmlPart(15)
expressionOut.print(check?.checkAmt)
printHtmlPart(16)
expressionOut.print(i)
printHtmlPart(19)
invokeTag('set','g',83,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(13)
}
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(hasErrors(bean: txnCheckBillsPaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',92,['code':("txnCheckBillsPayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(23)
invokeTag('textArea','g',95,['name':("txnRef"),'required':(""),'value':(txnCheckBillsPaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: txnCheckBillsPaymentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',102,['code':("txnCheckBillsPayment.txnParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(23)
invokeTag('textArea','g',105,['name':("txnParticulars"),'maxlength':("100"),'value':(txnCheckBillsPaymentInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(26)
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
