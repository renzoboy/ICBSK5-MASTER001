import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnTemplate_detail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnTemplate/_detail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (txnTemplateInstance?.txnModule)) {
printHtmlPart(1)
invokeTag('message','g',5,['code':("txnTemplate.txnModule.label"),'default':("Txn Module")],-1)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance?.txnModule?.description)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (txnTemplateInstance?.txnType)) {
printHtmlPart(5)
invokeTag('message','g',14,['code':("txnTemplate.txnType.label"),'default':("Txn Type")],-1)
printHtmlPart(6)
expressionOut.print(txnTemplateInstance?.txnType?.description)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (txnTemplateInstance?.code)) {
printHtmlPart(7)
invokeTag('message','g',23,['code':("txnTemplate.code.label"),'default':("Code")],-1)
printHtmlPart(8)
invokeTag('fieldValue','g',25,['bean':(txnTemplateInstance),'field':("code")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (txnTemplateInstance?.description)) {
printHtmlPart(9)
invokeTag('message','g',32,['code':("txnTemplate.description.label"),'default':("Description")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',34,['bean':(txnTemplateInstance),'field':("description")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (txnTemplateInstance?.shortDescription)) {
printHtmlPart(11)
invokeTag('message','g',41,['code':("txnTemplate.shortDescription.label"),'default':("Short Description")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',43,['bean':(txnTemplateInstance),'field':("shortDescription")],-1)
printHtmlPart(3)
}
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
