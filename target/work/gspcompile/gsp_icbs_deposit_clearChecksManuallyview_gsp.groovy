import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_clearChecksManuallyview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/clearChecksManually/view.gsp" }
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
expressionOut.print(createLink(controller : 'deposit', action:'editClearChecksManuallyAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'updateClearChecksManuallyAjax'))
printHtmlPart(8)
})
invokeTag('javascript','g',77,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',78,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',82,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('render','g',86,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(12)
invokeTag('render','g',89,['template':("details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(13)
invokeTag('render','g',94,['template':("/search/searchTemplate/deposit/clearChecksManually/viewGrid")],-1)
printHtmlPart(14)
invokeTag('render','g',105,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',116,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(depositInstance?.id)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(18)
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
