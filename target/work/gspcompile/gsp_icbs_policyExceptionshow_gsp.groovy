import icbs.admin.PolicyException
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policyExceptionshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policyException/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'policyException.label', default: 'PolicyException'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/policyException'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (policyExceptionInstance?.approvingUser)) {
printHtmlPart(11)
invokeTag('message','g',24,['code':("policyException.approvingUser.label"),'default':("Approving User")],-1)
printHtmlPart(12)
createTagBody(4, {->
expressionOut.print(policyExceptionInstance?.approvingUser?.encodeAsHTML())
})
invokeTag('link','g',25,['controller':("userMaster"),'action':("show"),'id':(policyExceptionInstance?.approvingUser?.id)],4)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (policyExceptionInstance?.dateOfAction)) {
printHtmlPart(15)
invokeTag('message','g',31,['code':("policyException.dateOfAction.label"),'default':("Date Of Action")],-1)
printHtmlPart(16)
invokeTag('formatDate','g',32,['date':(policyExceptionInstance?.dateOfAction)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (policyExceptionInstance?.isApproved)) {
printHtmlPart(17)
invokeTag('message','g',38,['code':("policyException.isApproved.label"),'default':("Is Approved")],-1)
printHtmlPart(18)
invokeTag('formatBoolean','g',39,['boolean':(policyExceptionInstance?.isApproved)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (policyExceptionInstance?.dateOfRequest)) {
printHtmlPart(19)
invokeTag('message','g',45,['code':("policyException.dateOfRequest.label"),'default':("Date Of Request")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',46,['date':(policyExceptionInstance?.dateOfRequest)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (policyExceptionInstance?.module)) {
printHtmlPart(21)
invokeTag('message','g',52,['code':("policyException.module.label"),'default':("Module")],-1)
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(policyExceptionInstance?.module?.encodeAsHTML())
})
invokeTag('link','g',53,['controller':("module"),'action':("show"),'id':(policyExceptionInstance?.module?.id)],4)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (policyExceptionInstance?.recordUrl)) {
printHtmlPart(23)
invokeTag('message','g',59,['code':("policyException.recordUrl.label"),'default':("Record Url")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',60,['bean':(policyExceptionInstance),'field':("recordUrl")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (policyExceptionInstance?.requestingUser)) {
printHtmlPart(25)
invokeTag('message','g',66,['code':("policyException.requestingUser.label"),'default':("Requesting User")],-1)
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(policyExceptionInstance?.requestingUser?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("userMaster"),'action':("show"),'id':(policyExceptionInstance?.requestingUser?.id)],4)
printHtmlPart(13)
}
printHtmlPart(27)
createTagBody(3, {->
printHtmlPart(28)
createTagBody(4, {->
invokeTag('message','g',74,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',74,['class':("edit"),'action':("edit"),'resource':(policyExceptionInstance)],4)
printHtmlPart(29)
invokeTag('actionSubmit','g',75,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',77,['url':([resource:policyExceptionInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(34)
invokeTag('message','g',82,['code':("default.home.label")],-1)
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',83,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',83,['class':("list"),'action':("index")],3)
printHtmlPart(36)
createTagBody(3, {->
invokeTag('message','g',84,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',84,['class':("create"),'action':("create")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(38)
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
