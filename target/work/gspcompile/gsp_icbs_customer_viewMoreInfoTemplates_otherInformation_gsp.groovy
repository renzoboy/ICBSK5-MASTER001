import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_otherInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_otherInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (customerInstance?.religion)) {
printHtmlPart(1)
expressionOut.print(customerInstance?.religion?.description)
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (customerInstance?.noOfDependent)) {
printHtmlPart(4)
expressionOut.print(customerInstance?.noOfDependent)
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (customerInstance?.motherMaidenName)) {
printHtmlPart(5)
expressionOut.print(customerInstance?.motherMaidenName)
printHtmlPart(6)
}
printHtmlPart(3)
if(true && (customerInstance?.fatherName)) {
printHtmlPart(7)
expressionOut.print(customerInstance?.fatherName)
printHtmlPart(8)
}
printHtmlPart(3)
if(true && (customerInstance?.civilStatus?.id == 65)) {
printHtmlPart(9)
expressionOut.print(customerInstance?.spouseLastName)
printHtmlPart(10)
expressionOut.print(customerInstance?.spouseFirstName)
printHtmlPart(11)
expressionOut.print(customerInstance?.spouseMiddleName)
printHtmlPart(12)
invokeTag('formatDate','g',37,['format':("MM/dd/yyyy"),'date':(customerInstance?.spouseBirthDate)],-1)
printHtmlPart(13)
expressionOut.print(customerInstance?.spouseContactNo)
printHtmlPart(2)
}
printHtmlPart(14)
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
