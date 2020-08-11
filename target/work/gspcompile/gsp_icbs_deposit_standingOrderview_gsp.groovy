import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_standingOrderview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/standingOrder/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller : 'deposit', action:'createStandingOrderAjax'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'createStandingOrderAjax'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller : 'deposit', action:'saveStandingOrderAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'deposit', action:'editStandingOrderAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'deposit', action:'updateStandingOrderAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(12)
})
invokeTag('javascript','g',65,[:],2)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',66,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(14, 2)
invokeTag('captureContent','sitemesh',70,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('render','g',74,['template':("/customer/details/customerDetails"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(16)
invokeTag('render','g',78,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(17)
invokeTag('render','g',84,['template':("/search/searchTemplate/deposit/standingOrder/viewGrid")],-1)
printHtmlPart(18)
invokeTag('render','g',95,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(19)
invokeTag('render','g',114,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',125,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
if(true && (depositInstance)) {
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(depositInstance?.id)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',140,['tag':("main-actions")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',141,[:],1)
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
