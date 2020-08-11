import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_details_customerInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/details/_customerInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(2)
if(true && (customerInstance?.type?.id == 1)) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('formatDate','g',24,['format':("MM/dd/yyyy"),'date':(customerInstance?.birthDate)],-1)
printHtmlPart(6)
invokeTag('set','g',28,['var':("address"),'value':(customerInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(7)
if(true && (address)) {
printHtmlPart(8)
expressionOut.print(address?.address1)
printHtmlPart(9)
expressionOut.print(address?.address2)
printHtmlPart(9)
expressionOut.print(address?.town?.description)
printHtmlPart(9)
expressionOut.print(address?.address3)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
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
