import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/branch'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(7)
invokeTag('message','g',15,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(8)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(9)
invokeTag('message','g',18,['code':("default.home.label")],-1)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',19,['class':("create"),'action':("create")],2)
printHtmlPart(11)
invokeTag('message','g',23,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',31,['code':("customer.customerAcctTypeId.label"),'default':("Customer Acct Type Id")],-1)
printHtmlPart(16)
invokeTag('message','g',33,['code':("customer.genderId.label"),'default':("Gender Id")],-1)
printHtmlPart(16)
invokeTag('message','g',35,['code':("customer.customerDosriCodeId.label"),'default':("Customer Dosri Code Id")],-1)
printHtmlPart(16)
invokeTag('message','g',37,['code':("customer.customerStatusId.label"),'default':("Customer Status Id")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',39,['property':("displayId"),'title':(message(code: 'customer.displayId.label', default: 'Display Id'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',41,['property':("firstName"),'title':(message(code: 'customer.firstName.label', default: 'First Name'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( customerInstance in (customerInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: customerInstance, field: "customerAcctTypeId"))
})
invokeTag('link','g',49,['action':("show"),'id':(customerInstance.id)],3)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: customerInstance, field: "genderId"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: customerInstance, field: "customerDosriCodeId"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: customerInstance, field: "customerStatusId"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: customerInstance, field: "displayId"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: customerInstance, field: "firstName"))
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',66,['total':(customerInstanceCount ?: 0)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',69,[:],1)
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
