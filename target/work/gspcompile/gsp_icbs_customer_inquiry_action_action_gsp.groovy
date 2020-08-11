import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_inquiry_action_action_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/inquiry/action/_action.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('link','g',9,['class':(""),'action':("customerSearch")],1)
printHtmlPart(3)
if(true && (customerInstance)) {
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',11,['action':("customerViewMoreInformation"),'id':(customerInstance.id)],2)
printHtmlPart(3)
}
else {
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (customerInstance&&customerInstance.status?.id!=3)) {
printHtmlPart(4)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',17,['class':("edit"),'action':("edit"),'resource':(customerInstance)],2)
printHtmlPart(3)
}
else {
printHtmlPart(9)
}
printHtmlPart(7)
if(true && (customerInstance)) {
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',23,['controller':("customer"),'action':("customerAccounts"),'id':(customerInstance.id)],2)
printHtmlPart(3)
}
else {
printHtmlPart(12)
}
printHtmlPart(10)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',28,['controller':("customer"),'action':("customerMembership"),'id':(customerInstance.id)],1)
printHtmlPart(3)
if(true && (customerInstance?.type?.id==1&&customerInstance.status?.id!=3)) {
printHtmlPart(4)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',30,['action':("customerShowRelated"),'id':(customerInstance?.id)],2)
printHtmlPart(3)
}
printHtmlPart(7)
if(true && (customerInstance?.type?.id!=1&&customerInstance.status?.id!=3)) {
printHtmlPart(4)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',33,['action':("customerShowRelated"),'id':(customerInstance?.id)],2)
printHtmlPart(3)
}
printHtmlPart(7)
if(true && (customerInstance)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (customerInstance&&customerInstance.status?.id!=3)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (customerInstance&&customerInstance.status?.id==2)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',54,['action':("customerInfobase"),'id':(customerInstance?.id)],1)
printHtmlPart(26)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',55,['class':(""),'action':("create"),'resource':("")],1)
printHtmlPart(28)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(29)
invokeTag('message','g',57,['code':("default.home.label")],-1)
printHtmlPart(30)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',59,['action':("viewLoanComakerRelationship"),'id':(customerInstance?.id)],1)
printHtmlPart(32)
createClosureForHtmlPart(33, 1)
invokeTag('link','g',61,['action':("viewCustomerCollateral"),'id':(customerInstance?.id)],1)
printHtmlPart(34)
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
