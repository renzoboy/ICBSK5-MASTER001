import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_update_statusview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/update/status/view.gsp" }
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
createTagBody(3, {->
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
invokeTag('message','g',34,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',35,['bean':(depositInstance),'field':("status")],4)
printHtmlPart(12)
})
invokeTag('hasErrors','g',39,['bean':(depositInstance)],3)
printHtmlPart(13)
invokeTag('render','g',42,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(14)
invokeTag('render','g',46,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(15)
invokeTag('render','g',51,['template':("update/status/form"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(17)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (depositInstance.status.description == 'Closed')) {
printHtmlPart(21)
expressionOut.print(depositInstance?.id)
printHtmlPart(22)
}
else {
printHtmlPart(23)
expressionOut.print(depositInstance?.id)
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',98,[:],1)
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
