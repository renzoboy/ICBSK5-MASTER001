import icbs.audit.AuditLog
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_overrideLogindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/overrideLog/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'auditLog.label', default: 'AuditLog'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',25,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',27,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',29,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('message','g',35,['code':("auditLog.auditType.label"),'default':("User")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',37,['property':("date"),'title':(message(code: 'auditLog.date.label', default: 'Date/Time'))],-1)
printHtmlPart(18)
invokeTag('message','g',39,['code':("auditLog.module.label"),'default':("Activity")],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',41,['property':("ipAddress"),'title':(message(code: 'auditLog.ipAddress.label', default: 'IP Address'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( auditLogInstance in (auditLogInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "userMaster.name"))
printHtmlPart(23)
invokeTag('formatDate','g',52,['date':(auditLogInstance.date)],-1)
printHtmlPart(24)
if(true && (auditLogInstance.recordUrl)) {
printHtmlPart(25)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "recordUrl"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "module.name"))
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(auditLogInstance.description)
printHtmlPart(29)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "ipAddress"))
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
invokeTag('paginate','g',70,['total':(AuditLogInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(5)
createClosureForHtmlPart(33, 2)
invokeTag('captureContent','sitemesh',77,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(34)
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
