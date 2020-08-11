import icbs.cif.CustomerInfobase
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_details_newCustomerDetailedInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/details/_newCustomerDetailedInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
invokeTag('hiddenField','g',10,['id':("Customer_status"),'name':("Customer_status"),'value':(customerInstance?.status)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',11,['id':("customer"),'name':("customer.id"),'value':(customerInstance?.id)],-1)
printHtmlPart(2)
if(true && (boxName)) {
expressionOut.print(boxName)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(5)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (customerInstance?.type.id==1)) {
printHtmlPart(8)
expressionOut.print(customerInstance?.name3)
printHtmlPart(9)
expressionOut.print(customerInstance?.name1)
printHtmlPart(10)
expressionOut.print(customerInstance?.name2)
printHtmlPart(11)
expressionOut.print(customerInstance?.dosriCode?.description)
printHtmlPart(12)
}
else {
printHtmlPart(8)
expressionOut.print(customerInstance?.name1)
printHtmlPart(13)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(1, {->
expressionOut.print(customerInstance?.customerId)
})
invokeTag('link','g',44,['controller':("customer"),'action':("customerInquiry"),'id':(customerInstance?.id)],1)
printHtmlPart(16)
invokeTag('set','g',46,['var':("primaryAddress"),'value':((customerInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(17)
if(true && (primaryAddress!=null)) {
printHtmlPart(18)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(16)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print((customerInstance?.contacts?.find{it.isPrimaryPhone ==true})?.contactValue)
printHtmlPart(21)
expressionOut.print((customerInstance?.contacts?.find{it.isPrimaryEmail ==true})?.contactValue)
printHtmlPart(22)
if(true && (CustomerInfobase.findAllByCustomerAndStatus(customerInstance,ConfigItemStatus.get(2)))) {
printHtmlPart(23)
loop:{
int i = 0
for( infobase in (CustomerInfobase.findAllByCustomerAndStatus(customerInstance,ConfigItemStatus.get(2))) ) {
printHtmlPart(24)
if(true && (infobase.status.id==2)) {
printHtmlPart(25)
expressionOut.print(fieldValue(bean: infobase, field: "infoMessage"))
printHtmlPart(26)
}
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
}
printHtmlPart(29)
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
