import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_stopPaymentOrderview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/stopPaymentOrder/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller : 'deposit', action:'createStopPaymentOrderAjax'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(7)
expressionOut.print(params?.deposit)
printHtmlPart(8)
expressionOut.print(createLink(controller : 'deposit', action:'createStopPaymentOrderAjax'))
printHtmlPart(9)
expressionOut.print(depositInstance?.id)
printHtmlPart(10)
expressionOut.print(createLink(controller : 'deposit', action:'saveStopPaymentOrderAjax'))
printHtmlPart(11)
expressionOut.print(depositInstance?.id)
printHtmlPart(12)
expressionOut.print(createLink(controller : 'deposit', action:'editStopPaymentOrderAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller : 'deposit', action:'updateStopPaymentOrderAjax'))
printHtmlPart(14)
})
invokeTag('javascript','g',59,[:],2)
printHtmlPart(15)
})
invokeTag('captureHead','sitemesh',60,[:],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(16, 2)
invokeTag('captureContent','sitemesh',64,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('render','g',68,['template':("/customer/details/customerDetails"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(18)
invokeTag('render','g',72,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(19)
invokeTag('render','g',77,['template':("/search/searchTemplate/deposit/stopPaymentOrder/viewGrid")],-1)
printHtmlPart(20)
invokeTag('render','g',88,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(21)
invokeTag('render','g',107,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',118,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
if(true && (depositInstance)) {
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(depositInstance?.id)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',133,['tag':("main-actions")],2)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',134,[:],1)
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
