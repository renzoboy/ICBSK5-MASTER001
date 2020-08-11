import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_employmentInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_employmentInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.employments[0]?.employerName)
printHtmlPart(1)
expressionOut.print(customerInstance?.employments[0]?.address1)
printHtmlPart(2)
expressionOut.print(customerInstance?.employments[0]?.address2)
printHtmlPart(2)
expressionOut.print(customerInstance?.employments[0]?.address3)
printHtmlPart(3)
expressionOut.print(customerInstance?.employments[0]?.yearStart)
printHtmlPart(4)
expressionOut.print(customerInstance?.employments[0]?.yearEnd)
printHtmlPart(5)
expressionOut.print(customerInstance?.employments[0]?.designation)
printHtmlPart(6)
expressionOut.print(customerInstance?.employments[0]?.employmentId)
printHtmlPart(7)
expressionOut.print(customerInstance?.employments[0]?.depedEmploymentId)
printHtmlPart(8)
expressionOut.print(customerInstance?.employments[0]?.region?.itemValue)
printHtmlPart(9)
expressionOut.print(customerInstance?.employments[0]?.contactNo)
printHtmlPart(10)
expressionOut.print(customerInstance?.employments[0]?.faxNo)
printHtmlPart(11)
expressionOut.print(customerInstance?.employments[0]?.eMail)
printHtmlPart(12)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(customerInstance?.employments[0]?.monthlyIncome)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',56,['format':("###,###,##0.00"),'number':(customerInstance?.employments[0]?.salary)],-1)
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
