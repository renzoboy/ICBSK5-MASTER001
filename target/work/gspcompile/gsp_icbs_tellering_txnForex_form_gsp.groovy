import icbs.tellering.TxnForex
import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnForex_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnForex/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(23))) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(hasErrors(bean: txnForexInstance, field: 'exchangeRate', 'has-error'))
printHtmlPart(5)
invokeTag('message','g',17,['code':("txnForex.exchangeRate.label"),'default':("Exchange Rate")],-1)
printHtmlPart(6)
invokeTag('field','g',21,['name':("exchangeRate"),'required':("true"),'value':(fieldValue(bean: txnForexInstance, field: 'exchangeRate')),'class':("txn-amt form-control")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: txnForexInstance, field: 'receivedAmt', 'has-error'))
printHtmlPart(8)
invokeTag('message','g',27,['code':("txnForex.receivedAmt.label"),'default':("Received Amount")],-1)
printHtmlPart(6)
invokeTag('field','g',31,['name':("receivedAmt"),'required':("true"),'value':(fieldValue(bean: txnForexInstance, field: 'receivedAmt')),'class':("txn-amt form-control")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: txnForexInstance, field: 'paidOutAmt', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',37,['code':("txnForex.paidOutAmt.label"),'default':("Paid Out Amount")],-1)
printHtmlPart(6)
invokeTag('field','g',41,['name':("paidOutAmt"),'required':("true"),'value':(fieldValue(bean: txnForexInstance, field: 'paidOutAmt')),'class':("txn-amt form-control")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: txnForexInstance, field: 'chargesAmt', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',47,['code':("txnForex.chargesAmt.label"),'default':("Charges Amount")],-1)
printHtmlPart(6)
invokeTag('field','g',51,['name':("chargesAmt"),'required':("true"),'value':(fieldValue(bean: txnForexInstance, field: 'chargesAmt')),'class':("txn-amt form-control")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: txnForexInstance, field: 'netAmtPaidOut', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',57,['code':("txnForex.netAmtPaidOut.label"),'default':("Net Amount Paid Out")],-1)
printHtmlPart(6)
invokeTag('field','g',61,['name':("netAmtPaidOut"),'required':("true"),'value':(fieldValue(bean: txnForexInstance, field: 'netAmtPaidOut')),'class':("txn-amt form-control")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: txnForexInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',67,['code':("txnForex.txnParticulars.label"),'default':("Transaction Particulars")],-1)
printHtmlPart(6)
invokeTag('textArea','g',71,['name':("txnParticulars"),'required':("true"),'value':(txnForexInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(13)
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
