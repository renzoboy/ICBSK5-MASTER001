import icbs.tellering.TxnTellerCash
import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashFromVault_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashFromVault/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(1),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(hasErrors(bean: txnCashFromVaultInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',114,['code':("txnCashFromVault.txnAmt.label"),'default':("Total Cash Received")],-1)
printHtmlPart(8)
invokeTag('field','g',118,['id':("txnAmt"),'name':("txnAmt"),'required':("true"),'value':(fieldValue(bean: txnCashFromVaultInstance, field: 'txnAmt')),'class':("form-control truncated")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: txnCashFromVaultInstance, field: 'txnRef', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',133,['code':("txnCashFromVault.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(8)
invokeTag('textArea','g',137,['id':("txnRef"),'name':("txnRef"),'required':("true"),'value':(txnCashFromVaultInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1592209176000L
public static final String EXPRESSION_CODEC = 'none'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
