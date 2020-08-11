import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_businessInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_businessInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.businesses[0]?.name)
printHtmlPart(1)
expressionOut.print(customerInstance?.businesses[0]?.lProject)
printHtmlPart(2)
expressionOut.print(customerInstance?.businesses[0]?.address1)
printHtmlPart(3)
expressionOut.print(customerInstance?.businesses[0]?.address2)
printHtmlPart(3)
expressionOut.print(customerInstance?.businesses[0]?.address3)
printHtmlPart(4)
invokeTag('formatDate','g',20,['format':("MM/dd/yyyy"),'date':(customerInstance?.businesses[0]?.registrationDate)],-1)
printHtmlPart(5)
expressionOut.print(customerInstance?.businesses[0]?.faxNo)
printHtmlPart(6)
expressionOut.print(customerInstance?.businesses[0]?.eMail)
printHtmlPart(7)
expressionOut.print(customerInstance?.businesses[0]?.remittance)
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
