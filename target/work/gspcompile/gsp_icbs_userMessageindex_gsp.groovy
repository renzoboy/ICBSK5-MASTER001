import icbs.admin.UserMessage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMessageindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMessage/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'userMessage.label', default: 'UserMessage'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',55,['code':("userMessage.sender.label"),'default':("Sender")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',56,['property':("subject"),'title':(message(code: 'userMessage.subject.label', default: 'Subject'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',58,['property':("body"),'title':(message(code: 'userMessage.body.label', default: 'Body'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',64,['property':("sentAt"),'title':(message(code: 'userMessage.sentAt.label', default: 'Sent At'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( userMessageInstance in (userMessageInstanceList) ) {
printHtmlPart(14)
if(true && (userMessageInstance.configItemStatusId==2)) {
printHtmlPart(15)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sender.name"))
printHtmlPart(16)
if(true && (userMessageInstance.isRead == true)) {
printHtmlPart(17)
createTagBody(6, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',84,['action':("show"),'id':(userMessageInstance.id)],6)
printHtmlPart(16)
}
else {
printHtmlPart(18)
createTagBody(6, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',88,['action':("show"),'id':(userMessageInstance.id),'class':("bold")],6)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(fieldValue(bean: userMessageInstance, field: 'body'))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sentAt"))
printHtmlPart(22)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',99,['action':("create")],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',101,['action':("outbox")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',102,['tag':("main-actions")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(32)
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
