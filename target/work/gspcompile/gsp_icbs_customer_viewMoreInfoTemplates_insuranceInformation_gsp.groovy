import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_insuranceInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_insuranceInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.insurances[0]?.lifeInsurance)
printHtmlPart(1)
invokeTag('formatDate','g',12,['format':("MM/dd/yyyy"),'date':(customerInstance?.insurances[0]?.lifeDateOfRemittance)],-1)
printHtmlPart(2)
expressionOut.print(customerInstance?.insurances[0]?.pcic)
printHtmlPart(1)
invokeTag('formatDate','g',20,['format':("MM/dd/yyyy"),'date':(customerInstance?.insurances[0]?.pcicDateOfRemittance)],-1)
printHtmlPart(3)
expressionOut.print(customerInstance?.insurances[0]?.memBenefitProgram)
printHtmlPart(1)
invokeTag('formatDate','g',28,['format':("MM/dd/yyyy"),'date':(customerInstance?.insurances[0]?.memDateOfRemittance)],-1)
printHtmlPart(4)
expressionOut.print(customerInstance?.insurances[0]?.agfp)
printHtmlPart(1)
invokeTag('formatDate','g',36,['format':("MM/dd/yyyy"),'date':(customerInstance?.insurances[0]?.agfpDateOfRemitance)],-1)
printHtmlPart(5)
expressionOut.print(customerInstance?.insurances[0]?.fireInsurance)
printHtmlPart(1)
invokeTag('formatDate','g',44,['format':("MM/dd/yyyy"),'date':(customerInstance?.insurances[0]?.fireDateOfRemittance)],-1)
printHtmlPart(6)
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
