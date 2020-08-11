import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_membershipInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_membershipInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.membership?.membershipType?.description)
printHtmlPart(1)
invokeTag('formatDate','g',12,['format':("MM/dd/yyyy"),'date':(customerInstance?.membership?.membershipDate)],-1)
printHtmlPart(2)
expressionOut.print(customerInstance?.membership?.refferedBy)
printHtmlPart(3)
expressionOut.print(customerInstance?.membership?.relationship?.itemValue)
printHtmlPart(4)
invokeTag('formatDate','g',24,['format':("MM/dd/yyyy"),'date':(customerInstance?.membership?.dateCreated)],-1)
printHtmlPart(5)
expressionOut.print(customerInstance?.membership?.createdBy?.username)
printHtmlPart(6)
expressionOut.print(customerInstance?.membership?.status?.description)
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
