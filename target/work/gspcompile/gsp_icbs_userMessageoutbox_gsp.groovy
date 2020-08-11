import icbs.admin.UserMessage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMessageoutbox_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMessage/outbox.gsp" }
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
invokeTag('captureHead','sitemesh',41,[:],1)
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
invokeTag('message','g',56,['code':("userMessage.recipient.label"),'default':("Recipient")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',58,['property':("subject"),'title':(message(code: 'userMessage.subject.label', default: 'Subject'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',64,['property':("body"),'title':(message(code: 'userMessage.body.label', default: 'Body'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',69,['property':("sentAt"),'title':(message(code: 'userMessage.sentAt.label', default: 'Sent At'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( userMessageInstance in (userMessageInstanceList) ) {
printHtmlPart(14)
if(true && (userMessageInstance.configItemStatusId==2)) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "recipient.name"))
printHtmlPart(17)
if(true && (userMessageInstance.isRead == true)) {
printHtmlPart(18)
createTagBody(6, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',82,['action':("show"),'id':(userMessageInstance.id)],6)
printHtmlPart(17)
}
else {
printHtmlPart(19)
createTagBody(6, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',87,['action':("show"),'id':(userMessageInstance.id),'class':("bold")],6)
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(fieldValue(bean: userMessageInstance, field: 'body'))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sentAt"))
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',99,['total':(UserMessageInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',99,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',100,['action':("create")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',101,['action':("index")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',101,[:],1)
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
