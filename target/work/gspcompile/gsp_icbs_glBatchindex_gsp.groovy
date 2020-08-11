import icbs.gl.GlBatchHdr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glBatchHdr.label', default: 'GL Batch Transactions'))],-1)
printHtmlPart(1)
if(true && (postedOnOff=='postedOff')) {
printHtmlPart(2)
createTagBody(3, {->
createTagBody(4, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(1)
}
else {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(1)
}
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'glBatch',action:'processBatchAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'glBatch',action:'getGLAcctByBranch'))
printHtmlPart(7)
})
invokeTag('javascript','g',18,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',23,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.error)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (flash.error)) {
printHtmlPart(15)
expressionOut.print(flash.error)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('select','g',45,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(19)
invokeTag('textField','g',49,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('submitButton','g',51,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(22)
})
invokeTag('form','g',53,['class':("form-inline")],3)
printHtmlPart(23)
invokeTag('sortableColumn','g',58,['property':("id"),'title':(message(code: 'glBatchHdr.id.label', default: 'Batch Series'))],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',59,['property':("batchId"),'title':(message(code: 'glBatchHdr.batchId.label', default: 'Batch ID'))],-1)
printHtmlPart(25)
invokeTag('message','g',60,['code':("glBatchHdr.errorGl.label"),'default':("Batch Name")],-1)
printHtmlPart(26)
invokeTag('sortableColumn','g',62,['property':("batchType"),'title':(message(code: 'glBatchHdr.batchType.label', default: 'Branch'))],-1)
printHtmlPart(27)
invokeTag('sortableColumn','g',64,['property':("batchParticulars"),'title':(message(code: 'glBatchHdr.batchParticulars.label', default: 'Total Debits'))],-1)
printHtmlPart(28)
invokeTag('message','g',66,['code':("glBatchHdr.loanAcct.label"),'default':("Total Credits")],-1)
printHtmlPart(29)
invokeTag('sortableColumn','g',68,['property':("batchStatus"),'title':(message(code: 'glBatchHdr.batchStatus.label', default: 'Batch Status'))],-1)
printHtmlPart(30)
loop:{
int i = 0
for( glBatchHdrInstance in (glBatchHdrInstanceList) ) {
printHtmlPart(31)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(32)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "id"))
printHtmlPart(33)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
})
invokeTag('link','g',84,['action':("edit"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(35)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchName"))
printHtmlPart(36)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "branch.name"))
printHtmlPart(37)
invokeTag('formatNumber','g',90,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalDebit)],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',91,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalCredit)],-1)
printHtmlPart(39)
expressionOut.print(glBatchHdrInstance.status.description)
printHtmlPart(40)
if(true && (postedOnOff=='postedOff')) {
printHtmlPart(41)
expressionOut.print(glBatchHdrInstance.batchId)
printHtmlPart(42)
expressionOut.print(glBatchHdrInstance.batchId)
printHtmlPart(43)
if(true && (glBatchHdrInstance.status.id == 2)) {
printHtmlPart(44)
}
else {
printHtmlPart(45)
createClosureForHtmlPart(46, 6)
invokeTag('link','g',101,['class':("btn btn-primary btn-xs"),'action':("edit"),'id':(glBatchHdrInstance.id)],6)
printHtmlPart(47)
}
printHtmlPart(48)
createClosureForHtmlPart(49, 5)
invokeTag('link','g',103,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance.id),'params':([glBatchHdrInstance: glBatchHdrInstance, bId:glBatchHdrInstance.id])],5)
printHtmlPart(47)
invokeTag('hiddenField','g',104,['id':("glBatchhid${i}"),'name':("glBatchhid"),'value':(glBatchHdrInstance.id)],-1)
printHtmlPart(50)
expressionOut.print(i)
printHtmlPart(51)
expressionOut.print(createLink(controller:'GlBatch',action:'cancelBatchAjax'))
printHtmlPart(52)
}
else {
printHtmlPart(53)
createClosureForHtmlPart(54, 5)
invokeTag('link','g',157,['class':("btn btn-primary btn-xs"),'action':("edit"),'id':(glBatchHdrInstance.id),'params':([showview: 'posted'])],5)
printHtmlPart(47)
createClosureForHtmlPart(49, 5)
invokeTag('link','g',158,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance.id),'params':([glBatchHdrInstance: glBatchHdrInstance, bId:glBatchHdrInstance.id])],5)
printHtmlPart(55)
}
printHtmlPart(56)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "createdBy.username"))
printHtmlPart(57)
i++
}
}
printHtmlPart(58)
invokeTag('paginate','g',170,['total':(GlBatchHdrInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(59)
if(true && (postedOnOff=='postedOn')) {
printHtmlPart(60)
createClosureForHtmlPart(61, 4)
invokeTag('link','g',173,['class':("prevDaysArchive"),'action':("prevDaysArchive")],4)
printHtmlPart(14)
}
printHtmlPart(62)
})
invokeTag('captureContent','sitemesh',177,['tag':("main-content")],2)
printHtmlPart(63)
createTagBody(2, {->
printHtmlPart(64)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(65)
invokeTag('message','g',181,['code':("default.home.label")],-1)
printHtmlPart(66)
createTagBody(3, {->
invokeTag('message','g',182,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',182,['class':("create"),'action':("create")],3)
printHtmlPart(67)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',183,['action':("index"),'class':("btn btn-primary btn-xs"),'params':([showview: 'posted'])],3)
printHtmlPart(69)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(70)
invokeTag('customDatePicker','g',202,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(71)
createTagBody(3, {->
printHtmlPart(72)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(21).baseParams)
printHtmlPart(73)
expressionOut.print(icbs.admin.Report.get(21).outputParam)
printHtmlPart(74)
expressionOut.print(icbs.admin.Report.get(21).reportUnit)
printHtmlPart(75)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(76)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(77)
})
invokeTag('javascript','g',222,[:],3)
printHtmlPart(78)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(70)
invokeTag('customDatePicker','g',247,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(79)
createTagBody(3, {->
printHtmlPart(80)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(23).baseParams)
printHtmlPart(73)
expressionOut.print(icbs.admin.Report.get(23).outputParam)
printHtmlPart(74)
expressionOut.print(icbs.admin.Report.get(23).reportUnit)
printHtmlPart(81)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(76)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(77)
})
invokeTag('javascript','g',267,[:],3)
printHtmlPart(82)
})
invokeTag('captureContent','sitemesh',278,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',279,[:],1)
printHtmlPart(83)
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
