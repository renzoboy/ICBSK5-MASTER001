import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_details_txnAcctDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/details/_txnAcctDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(1)
invokeTag('formatDate','g',12,['format':("MM/dd/yyyy"),'date':(customerInstance?.birthDate)],-1)
printHtmlPart(2)
invokeTag('set','g',16,['var':("address"),'value':(customerInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(3)
if(true && (address)) {
printHtmlPart(4)
expressionOut.print(address?.address1)
printHtmlPart(5)
expressionOut.print(address?.address2)
printHtmlPart(5)
expressionOut.print(address?.town?.description)
printHtmlPart(5)
expressionOut.print(address?.address3)
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(9)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(10)
}
printHtmlPart(11)
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
