import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (!customerInstance?.id&&customerInstance?.type?.id == 1)) {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (!customerInstance?.id&&customerInstance?.type?.id != 1)) {
printHtmlPart(4)
}
printHtmlPart(3)
if(true && (customerInstance?.type?.id<2)) {
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(7)
invokeTag('render','g',28,['template':("form/customer/customerverification/private")],-1)
printHtmlPart(3)
}
else {
printHtmlPart(7)
invokeTag('render','g',31,['template':("form/customer/customerverification/corporation")],-1)
printHtmlPart(3)
}
printHtmlPart(8)
invokeTag('render','g',35,['template':("form/customer/othercustomerinfo/otherCustomerInfo")],-1)
printHtmlPart(9)
invokeTag('render','g',37,['template':("form/contact/contactInfo")],-1)
printHtmlPart(10)
invokeTag('render','g',40,['template':("form/address/addrInfo")],-1)
printHtmlPart(11)
invokeTag('render','g',44,['template':("form/beneficiary/beneficiaryInfo")],-1)
printHtmlPart(12)
invokeTag('render','g',46,['template':("form/insurance/insuranceInfo")],-1)
printHtmlPart(13)
invokeTag('render','g',50,['template':("form/jointviews/employmentsAndBusinessInfo")],-1)
printHtmlPart(14)
if(true && (!customerInstance?.id)) {
printHtmlPart(15)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
invokeTag('render','g',57,['template':("form/relation/relationInfoBusiness"),'model':([customerRelationshipType:customerInstance?.type?.id])],-1)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(3)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(20)
invokeTag('render','g',62,['template':("form/education/educationInfo")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('render','g',65,['template':("form/jointviews/extendedAndAttachmentInfo")],-1)
printHtmlPart(23)
invokeTag('render','g',69,['template':("form/jointviews/presentedIdsAndOtherAcctsInfo")],-1)
printHtmlPart(24)
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
