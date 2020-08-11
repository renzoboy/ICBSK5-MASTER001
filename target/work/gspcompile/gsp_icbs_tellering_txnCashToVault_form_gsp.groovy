import icbs.tellering.TxnTellerCash
import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashToVault_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashToVault/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(23),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(hasErrors(bean: txnCashToVaultInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(5)
invokeTag('message','g',123,['code':("txnCashToVault.txnAmt.label"),'default':("Total Cash ")],-1)
printHtmlPart(6)
invokeTag('field','g',126,['name':("txnAmt"),'required':("true"),'value':(fieldValue(bean: txnCashToVaultInstance, field: 'txnAmt')),'class':("form-control truncated")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: txnCashTpVaultInstance, field: 'txnRef', 'has-error'))
printHtmlPart(8)
invokeTag('message','g',139,['code':("txnCashToVault.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(6)
invokeTag('textArea','g',142,['id':("txnRef"),'name':("txnRef"),'required':("true"),'value':(txnCashToVaultInstance?.txnRef),'class':("form-control")],-1)
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
