import icbs.tellering.TxnTellerCash
import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancing_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.Currency.findAllByConfigItemStatus(icbs.lov.ConfigItemStatus.read(2))) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.code + ' - ' + txnTemplateInstance.name)
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(hasErrors(bean: tellerBalancingInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(5)
invokeTag('message','g',98,['code':("tellerBalancing.txnAmt.label"),'default':("Enter Total Cash Amount")],-1)
printHtmlPart(6)
invokeTag('field','g',102,['placeholder':("Enter Total Cash Amount"),'name':("txnAmt"),'value':("0"),'class':("txn-amt form-control ")],-1)
printHtmlPart(7)
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
