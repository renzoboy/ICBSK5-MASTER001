import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_loans_customerBasicInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/loans/_customerBasicInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.displayName ?: "")
printHtmlPart(1)
invokeTag('formatDate','g',6,['format':("MM/dd/yyyy"),'date':(customerInstance?.birthDate ?: "")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("primaryAddress"),'value':((customerInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(3)
if(true && (primaryAddress != null)) {
printHtmlPart(4)
expressionOut.print(primaryAddress?.address1 + ", " + primaryAddress?.address2 +", " +primaryAddress?.address3)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(7)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('formatNumber','g',20,['format':("###,###,##0.00"),'number':(totReleased)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',21,['format':("###,###,##0.00"),'number':(totBalance)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',22,['format':("###,###,##0"),'number':(totCount)],-1)
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
