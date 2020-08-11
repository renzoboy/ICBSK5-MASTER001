import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerviewCustomerCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewCustomerCollateral.gsp" }
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
for( customerCollateral in (results) ) {
printHtmlPart(9)
expressionOut.print(customerCollateral?.owner?.id)
printHtmlPart(10)
expressionOut.print(customerCollateral?.owner?.displayName)
printHtmlPart(10)
expressionOut.print(customerCollateral?.collateralType?.description)
printHtmlPart(10)
invokeTag('formatNumber','g',49,['number':(customerCollateral?.appraisedValue),'format':("###,##0.00")],-1)
printHtmlPart(10)
expressionOut.print(customerCollateral?.status?.description)
printHtmlPart(11)
expressionOut.print(customerCollateral?.id)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
invokeTag('paginate','g',74,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(14)
invokeTag('render','g',90,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(15)
invokeTag('render','g',110,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(16)
invokeTag('render','g',130,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',142,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',145,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',147,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',148,[:],1)
printHtmlPart(21)
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
