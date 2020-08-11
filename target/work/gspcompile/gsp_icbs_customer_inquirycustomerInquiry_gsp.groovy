import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_inquirycustomerInquiry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/inquiry/customerInquiry.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',8,['src':("customerHelper.js")],-1)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller : 'customer', action:'getCustomerUpdateStatusFormAjax'))
printHtmlPart(4)
expressionOut.print(customerInstance?.id)
printHtmlPart(5)
expressionOut.print(createLink(controller : 'customer', action:'getCustomerUpdateCreditLimitFormAjax'))
printHtmlPart(4)
expressionOut.print(customerInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateInquiryFormAjax'))
printHtmlPart(4)
expressionOut.print(customerInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateStatusAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateCreditLimitAjax'))
printHtmlPart(9)
})
invokeTag('javascript','g',63,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',64,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(11, 2)
invokeTag('captureContent','sitemesh',68,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('render','g',71,['template':("inquiry/customerInquiryForm")],-1)
printHtmlPart(13)
loop:{
int i = 0
for( address in (customerInstance?.addresses) ) {
printHtmlPart(14)
if(true && (address.statusId==2)) {
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(16)
expressionOut.print(address?.type.description)
printHtmlPart(17)
if(true && (address?.isPrimary)) {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(address?.address1)
printHtmlPart(20)
expressionOut.print(address?.address2)
printHtmlPart(20)
expressionOut.print(address?.town)
printHtmlPart(20)
expressionOut.print(address?.address3)
printHtmlPart(21)
if(true && (address?.postalCode)) {
printHtmlPart(22)
expressionOut.print(address?.postalCode)
}
printHtmlPart(23)
if(true && (address?.phone1)) {
printHtmlPart(24)
expressionOut.print(address?.phone1)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (address?.phone2)) {
printHtmlPart(24)
expressionOut.print(address?.phone2)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(27)
if(true && (address?.phone3)) {
printHtmlPart(24)
expressionOut.print(address?.phone3)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(28)
if(true && (address?.phone4)) {
printHtmlPart(24)
expressionOut.print(address?.phone4)
printHtmlPart(17)
}
else {
printHtmlPart(25)
}
printHtmlPart(29)
if(true && (address?.isMailing)) {
printHtmlPart(30)
}
printHtmlPart(24)
if(true && (address?.isMortaged)) {
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (address?.isOwned)) {
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(35)
i++
}
}
printHtmlPart(36)
invokeTag('render','g',149,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(37)
invokeTag('render','g',171,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(38)
invokeTag('render','g',193,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(39)
loop:{
int i = 0
for( deposit in (customerInstance?.deposits) ) {
printHtmlPart(40)
expressionOut.print(deposit?.product?.name)
printHtmlPart(41)
createTagBody(4, {->
expressionOut.print(deposit.acctNo)
})
invokeTag('link','g',212,['action':("depositInquiry"),'controller':("deposit"),'id':(deposit?.id)],4)
printHtmlPart(41)
expressionOut.print(deposit?.status?.description)
printHtmlPart(42)
i++
}
}
printHtmlPart(43)
loop:{
int i = 0
for( loan in (customerInstance?.loans) ) {
printHtmlPart(44)
expressionOut.print(loan?.product?.name)
printHtmlPart(45)
createTagBody(4, {->
expressionOut.print(loan.accountNo)
})
invokeTag('link','g',238,['action':("show"),'controller':("loan"),'id':(loan?.id)],4)
printHtmlPart(41)
expressionOut.print(loan?.status?.description)
printHtmlPart(42)
i++
}
}
printHtmlPart(46)
invokeTag('render','g',271,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(47)
createClosureForHtmlPart(48, 3)
invokeTag('link','g',272,['action':("create"),'controller':("deposit"),'params':([customerFromCIFPage:customerInstance.id])],3)
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',273,['action':("create"),'controller':("loanApplication"),'params':([cid:customerInstance.id])],3)
printHtmlPart(49)
createClosureForHtmlPart(51, 3)
invokeTag('link','g',274,['action':("createScr"),'controller':("loanApplication"),'params':([cid:customerInstance.id])],3)
printHtmlPart(52)
})
invokeTag('captureContent','sitemesh',282,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(53)
invokeTag('render','g',285,['template':("inquiry/action/action")],-1)
printHtmlPart(54)
})
invokeTag('captureContent','sitemesh',287,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',288,[:],1)
printHtmlPart(55)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595562017504L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
