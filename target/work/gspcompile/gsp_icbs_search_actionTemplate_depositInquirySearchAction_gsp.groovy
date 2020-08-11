import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_actionTemplate_depositInquirySearchAction_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/actionTemplate/_depositInquirySearchAction.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (depositInstance.status.description == 'Closed' && params.module != 'memo')) {
printHtmlPart(2)
createClosureForHtmlPart(3, 2)
invokeTag('link','g',12,['class':("btn btn-secondary"),'controller':("deposit"),'action':("depositInquiry"),'params':([module:'close']),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to query this Deposit Account?');")],2)
printHtmlPart(4)
}
else {
printHtmlPart(2)
createClosureForHtmlPart(3, 2)
invokeTag('link','g',17,['class':("btn btn-secondary"),'controller':("deposit"),'action':("depositInquiry"),'params':(params),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to query this Deposit Account?');")],2)
printHtmlPart(4)
}
printHtmlPart(5)
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
