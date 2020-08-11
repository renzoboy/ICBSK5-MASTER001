import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_passbookview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/passbook/view.gsp" }
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
expressionOut.print(createLink(controller : 'deposit', action:'createPassbookAjax'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'createPassbookAjax'))
printHtmlPart(5)
expressionOut.print(depositInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller : 'deposit', action:'savePassbookAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'deposit', action:'editPassbookAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'deposit', action:'updatePassbookAjax'))
printHtmlPart(11)
})
invokeTag('javascript','g',88,[:],2)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',89,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',93,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('render','g',97,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(15)
invokeTag('render','g',101,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(16)
invokeTag('render','g',107,['template':("/search/searchTemplate/deposit/passbook/viewGrid")],-1)
printHtmlPart(17)
invokeTag('render','g',118,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(18)
invokeTag('render','g',139,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',151,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
if(true && (depositInstance)) {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(depositInstance?.id)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',167,['tag':("main-actions")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',168,[:],1)
printHtmlPart(25)
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
