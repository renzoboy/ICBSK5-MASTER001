import icbs.audit.AuditLog
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userLogindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userLog/index.gsp" }
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
invokeTag('sortableColumn','g',42,['property':("ipAddress"),'title':(message(code: 'auditLog.ipAddress.label', default: 'IP Address'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( auditLogInstance in (auditLogInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "userMaster.name"))
printHtmlPart(23)
expressionOut.print(auditLogInstance.date)
printHtmlPart(24)
expressionOut.print(auditLogInstance.auditType.description)
printHtmlPart(25)
expressionOut.print(auditLogInstance.description)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: auditLogInstance, field: "ipAddress"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',68,['total':(AuditLogInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('select','g',89,['id':("audittype"),'name':("audittype"),'from':(icbs.lov.AuditType.list()),'optionKey':("description"),'optionValue':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(31)
invokeTag('customDatePicker','g',96,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(33)
invokeTag('customDatePicker','g',101,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(35)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(26).baseParams)
printHtmlPart(36)
expressionOut.print(icbs.admin.Report.get(26).outputParam)
printHtmlPart(37)
expressionOut.print(icbs.admin.Report.get(26).reportUnit)
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(39)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(40)
})
invokeTag('javascript','g',123,[:],3)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',130,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',131,[:],1)
printHtmlPart(42)
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
