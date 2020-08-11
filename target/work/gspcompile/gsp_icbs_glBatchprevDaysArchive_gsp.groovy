import icbs.gl.GlBatchHdr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchprevDaysArchive_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/prevDaysArchive.gsp" }
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
invokeTag('javascript','g',16,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.error)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (flash.error)) {
printHtmlPart(13)
expressionOut.print(flash.error)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('select','g',40,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(17)
invokeTag('textField','g',44,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 4)
invokeTag('submitButton','g',46,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(20)
})
invokeTag('form','g',48,['class':("form-inline")],3)
printHtmlPart(21)
invokeTag('sortableColumn','g',53,['property':("id"),'title':(message(code: 'glBatchHdr.id.label', default: 'Batch Series'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',54,['property':("batchId"),'title':(message(code: 'glBatchHdr.batchId.label', default: 'Batch ID'))],-1)
printHtmlPart(23)
invokeTag('sortableColumn','g',55,['property':("txnDate"),'title':(message(code: 'glBatchHdr.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(24)
invokeTag('message','g',56,['code':("glBatchHdr.errorGl.label"),'default':("Batch Name")],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',57,['property':("batchType"),'title':(message(code: 'glBatchHdr.batchType.label', default: 'Branch'))],-1)
printHtmlPart(26)
invokeTag('sortableColumn','g',58,['property':("batchParticulars"),'title':(message(code: 'glBatchHdr.batchParticulars.label', default: 'Total Debits'))],-1)
printHtmlPart(24)
invokeTag('message','g',59,['code':("glBatchHdr.loanAcct.label"),'default':("Total Credits")],-1)
printHtmlPart(27)
invokeTag('sortableColumn','g',60,['property':("batchStatus"),'title':(message(code: 'glBatchHdr.batchStatus.label', default: 'Batch Status'))],-1)
printHtmlPart(28)
loop:{
int i = 0
for( glBatchHdrInstance in (glBatchHdrInstanceList) ) {
printHtmlPart(29)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(30)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "id"))
printHtmlPart(31)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
printHtmlPart(31)
invokeTag('formatDate','g',70,['format':("MM/dd/yyyy"),'date':(glBatchHdrInstance?.txnDate)],-1)
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchId"))
})
invokeTag('link','g',71,['action':("edit"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(33)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "batchName"))
printHtmlPart(34)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "branch.name"))
printHtmlPart(35)
invokeTag('formatNumber','g',74,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalDebit)],-1)
printHtmlPart(36)
invokeTag('formatNumber','g',75,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalCredit)],-1)
printHtmlPart(37)
expressionOut.print(glBatchHdrInstance.status.description)
printHtmlPart(38)
createClosureForHtmlPart(39, 4)
invokeTag('link','g',78,['class':("btn btn-primary btn-xs"),'action':("edit"),'id':(glBatchHdrInstance.id),'params':([showview: 'posted'])],4)
printHtmlPart(40)
createClosureForHtmlPart(41, 4)
invokeTag('link','g',79,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance.id),'params':([glBatchHdrInstance: glBatchHdrInstance, bId:glBatchHdrInstance.id])],4)
printHtmlPart(42)
expressionOut.print(fieldValue(bean: glBatchHdrInstance, field: "createdBy.username"))
printHtmlPart(43)
i++
}
}
printHtmlPart(44)
invokeTag('paginate','g',88,['total':(GlBatchHdrInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',92,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(46)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(47)
invokeTag('message','g',95,['code':("default.home.label")],-1)
printHtmlPart(48)
createTagBody(3, {->
invokeTag('message','g',96,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',96,['class':("create"),'action':("create")],3)
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',97,['action':("index"),'class':("btn btn-primary btn-xs"),'params':([showview: 'posted'])],3)
printHtmlPart(51)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(52)
invokeTag('customDatePicker','g',114,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(53)
createTagBody(3, {->
printHtmlPart(54)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(21).baseParams)
printHtmlPart(55)
expressionOut.print(icbs.admin.Report.get(21).outputParam)
printHtmlPart(56)
expressionOut.print(icbs.admin.Report.get(21).reportUnit)
printHtmlPart(57)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(58)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(59)
})
invokeTag('javascript','g',134,[:],3)
printHtmlPart(60)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(52)
invokeTag('customDatePicker','g',159,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(61)
createTagBody(3, {->
printHtmlPart(62)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(23).baseParams)
printHtmlPart(55)
expressionOut.print(icbs.admin.Report.get(23).outputParam)
printHtmlPart(56)
expressionOut.print(icbs.admin.Report.get(23).reportUnit)
printHtmlPart(63)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(58)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(59)
})
invokeTag('javascript','g',179,[:],3)
printHtmlPart(64)
})
invokeTag('captureContent','sitemesh',190,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',191,[:],1)
printHtmlPart(65)
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
