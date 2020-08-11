import icbs.tellering.TxnBillsPayment
import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnBillsPayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnBillsPayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'customer', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("loanApplication.customer.label"),'default':("Customer Name")],-1)
printHtmlPart(3)
invokeTag('field','g',8,['name':("customer-name"),'value':(accountsPayableInstance?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',9,['id':("customer"),'name':("customer.id"),'value':(accountsPayableInstance?.customer?.id)],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(it)
printHtmlPart(7)
})
invokeTag('hasErrors','g',13,['bean':(accountsPayableInstance),'field':("customer")],1)
printHtmlPart(8)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(3),[sort:"code", order:"asc"])) ) {
printHtmlPart(9)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(10)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(11)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnBillsPaymentInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',64,['id':("txnAmt"),'name':("txnAmt"),'required':(""),'value':(txnBillsPaymentInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: txnBillsPaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',71,['code':("txnBillsPayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(17)
invokeTag('textArea','g',72,['name':("txnRef"),'id':("txnRef"),'required':(""),'value':(txnBillsPaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnBillsPaymentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',79,['code':("txnBillsPayment.txnParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(17)
invokeTag('textArea','g',84,['name':("txnParticulars"),'id':("txnParticulars"),'value':(txnBillsPaymentInstance?.txnParticulars),'class':("form-control")],-1)
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
