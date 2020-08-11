import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerviewLoanComakerRelationship_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewLoanComakerRelationship.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("customerHelper.js")],-1)
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',15,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',20,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('render','g',23,['template':("details/customerDetails"),'model':([customerInstance:customerInstance,boxName:'CIF INFO'])],-1)
printHtmlPart(8)
loop:{
int i = 0
for( customerLoanComakerDetails in (resultqueryall) ) {
printHtmlPart(9)
expressionOut.print(customerLoanComakerDetails?.customer_id)
printHtmlPart(10)
expressionOut.print(customerLoanComakerDetails?.display_name)
printHtmlPart(10)
expressionOut.print(customerLoanComakerDetails?.account_no)
printHtmlPart(10)
expressionOut.print(customerLoanComakerDetails?.description)
printHtmlPart(11)
expressionOut.print(customerLoanComakerDetails?.customer_id)
printHtmlPart(12)
expressionOut.print(customerLoanComakerDetails?.id)
printHtmlPart(13)
expressionOut.print(customerLoanComakerDetails?.loan_application_id)
printHtmlPart(14)
i++
}
}
printHtmlPart(15)
invokeTag('paginate','g',93,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(16)
invokeTag('render','g',109,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(17)
invokeTag('render','g',129,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(18)
invokeTag('render','g',149,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',161,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',164,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',166,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',167,[:],1)
printHtmlPart(23)
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
