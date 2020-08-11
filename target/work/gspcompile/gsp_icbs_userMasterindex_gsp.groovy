import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMasterindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
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
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('select','g',35,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(13)
invokeTag('textField','g',39,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('submitButton','g',41,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(16)
})
invokeTag('form','g',43,['class':("form-inline")],3)
printHtmlPart(17)
invokeTag('sortableColumn','g',50,['property':("username"),'title':(message(code: 'userMaster.username.label', default: 'Username'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',52,['property':("name1"),'title':(message(code: 'userMaster.name1.label', default: 'Full Name'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',54,['property':("branch"),'title':(message(code: 'userMaster.branch.label', default: 'Branch'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',56,['property':("designation"),'title':(message(code: 'userMaster.designation.label', default: 'Designation'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',58,['property':("configItemStatus"),'title':(message(code: 'currency.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',60,['property':("isLocked"),'title':(message(code: 'userMaster.isLocked.label', default: 'Locked'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',62,['property':("isTellerBalanced"),'title':(message(code: 'userMaster.isTellerBalanced.label', default: 'Balanced'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',64,['property':("expiryDate"),'title':(message(code: 'userMaster.expiryDate.label', default: 'Expiry Date'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( userMasterInstance in (userMasterInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: userMasterInstance, field: "username"))
})
invokeTag('link','g',72,['action':("show"),'id':(userMasterInstance.id)],4)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "name1") + " " + fieldValue(bean: userMasterInstance, field: "name2") + " " + fieldValue(bean: userMasterInstance, field: "name3"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "branch.name"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "designation.description"))
printHtmlPart(25)
if(true && (userMasterInstance.configItemStatus.description == 'Active')) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(19)
if(true && (userMasterInstance.isLocked)) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (userMasterInstance.isTellerBalanced)) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(31)
invokeTag('formatDate','g',101,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.expiryDate)],-1)
printHtmlPart(32)
i++
}
}
printHtmlPart(33)
invokeTag('paginate','g',110,['total':(UserMasterInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(34)
invokeTag('jasperReport','g',113,['action':("createReport"),'controller':("userMaster"),'format':("PDF"),'jasper':("users"),'name':("All Users")],-1)
printHtmlPart(35)
invokeTag('jasperReport','g',115,['action':("createReport"),'controller':("userMaster"),'format':("XLS"),'jasper':("users"),'name':("All Users")],-1)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',125,['tag':("main-content")],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',128,['code':("default.new.user"),'args':([entityName]),'default':("New User")],-1)
})
invokeTag('link','g',128,['class':("create"),'action':("create")],3)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',130,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',131,[:],1)
printHtmlPart(40)
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
