import icbs.cif.CustomerInfobase
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_details_customerDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/details/_customerDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
invokeTag('hiddenField','g',11,['id':("Customer_status"),'name':("Customer_status"),'value':(customerInstance?.status)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',12,['id':("customer"),'name':("customer.id"),'value':(customerInstance?.id)],-1)
printHtmlPart(3)
if(true && (boxName)) {
expressionOut.print(boxName)
}
else {
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
expressionOut.print(customerInstance?.customerId)
})
invokeTag('link','g',21,['controller':("customer"),'action':("customerInquiry"),'id':(customerInstance?.id)],1)
printHtmlPart(6)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(10)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(9)
invokeTag('formatDate','g',39,['format':("MM/dd/yyyy"),'date':(customerInstance?.birthDate)],-1)
printHtmlPart(6)
invokeTag('set','g',42,['var':("address"),'value':(customerInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(13)
if(true && (address)) {
printHtmlPart(14)
expressionOut.print(address?.address1)
printHtmlPart(15)
expressionOut.print(address?.address2)
printHtmlPart(15)
expressionOut.print(address?.town?.description)
printHtmlPart(15)
expressionOut.print(address?.address3)
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (CustomerInfobase.findAllByCustomerAndStatus(customerInstance,ConfigItemStatus.get(2)))) {
printHtmlPart(19)
loop:{
int i = 0
for( infobase in (CustomerInfobase.findAllByCustomerAndStatus(customerInstance,ConfigItemStatus.get(2))) ) {
printHtmlPart(20)
if(true && (infobase.status.id==2)) {
printHtmlPart(21)
expressionOut.print(fieldValue(bean: infobase, field: "infoMessage"))
printHtmlPart(22)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
}
printHtmlPart(25)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(26)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(27)
}
printHtmlPart(28)
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
