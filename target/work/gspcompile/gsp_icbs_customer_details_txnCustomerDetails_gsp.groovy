import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_details_txnCustomerDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/details/_txnCustomerDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('hiddenField','g',1,['name':(field?:'customer'),'value':(customerInstance?.id)],-1)
printHtmlPart(0)
expressionOut.print(customerInstance?.id)
printHtmlPart(1)
expressionOut.print(customerInstance?.id)
printHtmlPart(2)
expressionOut.print(customerInstance?.id)
printHtmlPart(3)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(4)
invokeTag('formatDate','g',23,['format':("MM/dd/yyyy"),'date':(customerInstance?.birthDate)],-1)
printHtmlPart(5)
invokeTag('set','g',27,['var':("address"),'value':(customerInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(6)
if(true && (address)) {
printHtmlPart(7)
expressionOut.print(address?.address1)
printHtmlPart(8)
expressionOut.print(address?.address2)
printHtmlPart(8)
expressionOut.print(address?.town?.description)
printHtmlPart(8)
expressionOut.print(address?.address3)
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(12)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(13)
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
