import icbs.admin.UserMessage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMessage_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMessage/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: userMessageInstance, field: 'recipient', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("userMessage.recipient.label"),'default':("Recipient")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("recipient"),'name':("recipient.id"),'from':(icbs.admin.UserMaster.list(sort: "username")),'optionKey':("id"),'optionValue':("name"),'required':("true"),'value':(userMessageInstance?.recipient?.id),'class':("many-to-one form-control"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',16,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',17,['bean':(userMessageInstance),'field':("recipient")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',20,['bean':(userMessageInstance),'field':("recipient")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: userMessageInstance, field: 'subject', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',27,['code':("userMessage.subject.label"),'default':("Subject")],-1)
printHtmlPart(2)
invokeTag('textField','g',30,['name':("subject"),'required':(""),'value':(userMessageInstance?.subject),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',37,['bean':(userMessageInstance),'field':("subject")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',40,['bean':(userMessageInstance),'field':("subject")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: userMessageInstance, field: 'body', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',47,['code':("userMessage.body.label"),'default':("Body")],-1)
printHtmlPart(11)
invokeTag('textArea','g',50,['name':("body"),'id':("body"),'value':(userMessageInstance?.body),'class':("form-control textarea"),'rows':("10")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',70,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',71,['bean':(userMessageInstance),'field':("body")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',74,['bean':(userMessageInstance),'field':("body")],1)
printHtmlPart(13)
invokeTag('hiddenField','g',79,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',80,['name':("sender"),'value':(session.user_id)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',81,['name':("sentAt"),'value':(new Date())],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',82,['name':("isRead"),'value':(false)],-1)
printHtmlPart(15)
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
