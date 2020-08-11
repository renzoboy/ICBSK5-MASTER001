import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_classification_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/classification/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: loanInstance, field: 'performanceClassificationScheme1', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("loan.performanceClassificationScheme.label"),'default':("Performance Classification Scheme 1")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: loanInstance, field: 'performanceClassificationScheme2', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',15,['code':("loan.performanceClassificationScheme.label"),'default':("Performance Classification Scheme 2")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: loanInstance, field: 'performanceClassificationScheme3', 'has-error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("loan.performanceClassificationScheme.label"),'default':("Performance Classification Scheme 3")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: loanInstance, field: 'performanceClassificationScheme4', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',33,['code':("loan.performanceClassificationScheme.label"),'default':("Performance Classification Scheme 4")],-1)
printHtmlPart(8)
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
