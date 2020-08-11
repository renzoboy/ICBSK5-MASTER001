import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_primaryInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_primaryInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(1)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (customerInstance?.type.id==1)) {
printHtmlPart(4)
if(true && (customerInstance?.name5)) {
printHtmlPart(5)
expressionOut.print(customerInstance?.name3)
printHtmlPart(6)
expressionOut.print(customerInstance?.name5?.itemValue)
printHtmlPart(7)
expressionOut.print(customerInstance?.name1)
printHtmlPart(6)
expressionOut.print(customerInstance?.name2)
printHtmlPart(8)
}
else {
printHtmlPart(5)
expressionOut.print(customerInstance?.name3)
printHtmlPart(7)
expressionOut.print(customerInstance?.name1)
printHtmlPart(6)
expressionOut.print(customerInstance?.name2)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (customerInstance?.displayName)) {
printHtmlPart(11)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.title?.itemValue)) {
printHtmlPart(13)
expressionOut.print(customerInstance?.title?.itemValue)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.name4)) {
printHtmlPart(14)
expressionOut.print(customerInstance?.name4)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.gender)) {
printHtmlPart(15)
expressionOut.print(customerInstance?.gender?.description)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.birthDate)) {
printHtmlPart(16)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(12)
}
printHtmlPart(17)
}
else {
printHtmlPart(10)
if(true && (customerInstance?.name1)) {
printHtmlPart(18)
expressionOut.print(customerInstance?.name1)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.birthDate)) {
printHtmlPart(19)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(12)
}
printHtmlPart(17)
}
printHtmlPart(10)
if(true && (customerInstance?.customerId)) {
printHtmlPart(20)
expressionOut.print(customerInstance?.customerId)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.type)) {
printHtmlPart(21)
expressionOut.print(customerInstance?.type?.description)
printHtmlPart(12)
}
printHtmlPart(10)
if(true && (customerInstance?.civilStatus)) {
printHtmlPart(4)
if(true && (customerInstance?.type)) {
printHtmlPart(22)
expressionOut.print(customerInstance?.civilStatus?.itemValue)
printHtmlPart(23)
}
printHtmlPart(4)
if(true && (customerInstance?.birthPlace)) {
printHtmlPart(24)
expressionOut.print(customerInstance?.birthPlace)
printHtmlPart(23)
}
printHtmlPart(4)
if(true && (customerInstance?.nationality)) {
printHtmlPart(25)
expressionOut.print(customerInstance?.nationality?.itemValue)
printHtmlPart(23)
}
printHtmlPart(10)
}
printHtmlPart(26)
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
