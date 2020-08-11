import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_inquiry_customerInquiryForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/inquiry/_customerInquiryForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(2)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (customerInstance?.type.id==1)) {
printHtmlPart(5)
if(true && (customerInstance?.name5)) {
printHtmlPart(6)
expressionOut.print(customerInstance?.name3)
printHtmlPart(7)
expressionOut.print(customerInstance?.name5?.itemValue)
printHtmlPart(8)
expressionOut.print(customerInstance?.name1)
printHtmlPart(7)
expressionOut.print(customerInstance?.name2)
printHtmlPart(9)
}
else {
printHtmlPart(6)
expressionOut.print(customerInstance?.name3)
printHtmlPart(8)
expressionOut.print(customerInstance?.name1)
printHtmlPart(7)
expressionOut.print(customerInstance?.name2)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (customerInstance?.title)) {
printHtmlPart(12)
expressionOut.print(customerInstance?.title?.itemValue)
printHtmlPart(13)
}
printHtmlPart(5)
if(true && (customerInstance?.name4)) {
printHtmlPart(14)
expressionOut.print(customerInstance?.name4)
printHtmlPart(13)
}
printHtmlPart(15)
expressionOut.print(customerInstance?.gender?.description)
printHtmlPart(16)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(17)
if(true && (customerInstance?.birthDate)) {
printHtmlPart(18)
invokeTag('formatNumber','g',60,['format':("####"),'number':(((customerInstance?.branch?.runDate - customerInstance?.birthDate)/365.25).toInteger())],-1)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(customerInstance?.dosriCode?.description)
printHtmlPart(21)
}
else {
printHtmlPart(22)
expressionOut.print(customerInstance?.name1)
printHtmlPart(23)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(customerInstance?.customerId)
printHtmlPart(26)
expressionOut.print(customerInstance?.type?.description)
printHtmlPart(27)
expressionOut.print(customerInstance?.status?.description)
printHtmlPart(28)
invokeTag('set','g',109,['var':("primaryAddress"),'value':((customerInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(29)
if(true && (primaryAddress!=null)) {
printHtmlPart(30)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (customerInstance?.addresses?.size()>0)) {
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print((customerInstance?.contacts?.find{it.isPrimaryPhone ==true})?.contactValue)
printHtmlPart(37)
expressionOut.print((customerInstance?.contacts?.find{it.isPrimaryEmail ==true})?.contactValue)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595835016540L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
