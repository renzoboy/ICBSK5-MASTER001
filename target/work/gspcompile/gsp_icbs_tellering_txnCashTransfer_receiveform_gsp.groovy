import icbs.tellering.TxnTellerCash
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashTransfer_receiveform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashTransfer/_receiveform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (sourcetxn) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.txn_ref)
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('message','g',190,['code':("txnCashTransfer.user.label"),'default':("Source Teller")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: txnCashTransferInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(6)
invokeTag('message','g',201,['code':("txnCashTransfer.txnAmt.label"),'default':("Total Cash Transferred")],-1)
printHtmlPart(7)
expressionOut.print(txnCashTransferInstance?.txnAmt)
printHtmlPart(8)
expressionOut.print(txnCashTransferInstance?.txnRef)
printHtmlPart(9)
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
