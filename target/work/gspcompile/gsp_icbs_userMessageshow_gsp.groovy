import icbs.admin.UserMessage
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMessageshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMessage/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'userMessage.label', default: 'UserMessage'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (userMessageInstance?.sender)) {
printHtmlPart(10)
invokeTag('message','g',26,['code':("userMessage.sender.label"),'default':("Sender")],-1)
printHtmlPart(11)
expressionOut.print(userMessageInstance?.sender?.name1)
printHtmlPart(12)
expressionOut.print(userMessageInstance?.sender?.name2)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (userMessageInstance?.recipient)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("userMessage.recipient.label"),'default':("Recipient")],-1)
printHtmlPart(16)
expressionOut.print(userMessageInstance?.recipient?.name1)
printHtmlPart(12)
expressionOut.print(userMessageInstance?.recipient?.name2)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (userMessageInstance?.subject)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("userMessage.subject.label"),'default':("Subject")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',46,['bean':(userMessageInstance),'field':("subject")],-1)
printHtmlPart(13)
}
printHtmlPart(19)
if(true && (userMessageInstance?.body)) {
printHtmlPart(20)
invokeTag('message','g',53,['code':("userMessage.body.label"),'default':("Body")],-1)
printHtmlPart(21)
expressionOut.print(userMessageInstance?.body)
printHtmlPart(22)
expressionOut.print(userMessageInstance?.body)
printHtmlPart(23)
}
printHtmlPart(14)
if(true && (userMessageInstance?.sentAt)) {
printHtmlPart(24)
invokeTag('message','g',105,['code':("userMessage.sentAt.label"),'default':("Sent At")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',107,['bean':(userMessageInstance),'field':("sentAt")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (userMessageInstance?.parentMessage)) {
printHtmlPart(26)
invokeTag('message','g',114,['code':("userMessage.parentMessage.label"),'default':("Parent Message")],-1)
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(userMessageInstance?.parentMessage?.encodeAsHTML())
})
invokeTag('link','g',116,['controller':("userMessage"),'action':("show"),'id':(userMessageInstance?.parentMessage?.id)],4)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (userMessageInstance?.configItemStatus)) {
printHtmlPart(28)
invokeTag('message','g',123,['code':("userMessage.configItemStatus.label"),'default':("Status")],-1)
printHtmlPart(29)
expressionOut.print(userMessageInstance?.configItemStatus?.description)
printHtmlPart(13)
}
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('form','g',132,['id':("show"),'url':([resource:userMessageInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',134,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
if(true && (userMessageInstance?.recipient == UserMaster.get(session.user_id))) {
printHtmlPart(35)
createClosureForHtmlPart(36, 4)
invokeTag('link','g',138,['action':("reply"),'id':(userMessageInstance.id)],4)
printHtmlPart(37)
}
printHtmlPart(38)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',140,['class':("create"),'action':("create")],3)
printHtmlPart(40)
invokeTag('actionSubmit','g',141,['form':("show"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',143,['tag':("main-actions")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',148,[:],1)
printHtmlPart(43)
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
