import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchapproveBatch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/approveBatch.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/glBatch'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',27,['code':("glBatchHdrInstance.batchId.label"),'default':("Batch ID")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(glBatchHdrInstance),'field':("batchId")],-1)
printHtmlPart(13)
invokeTag('message','g',31,['code':("glBatchHdrInstance.batchName.label"),'default':("Batch Name")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',32,['bean':(glBatchHdrInstance),'field':("batchName")],-1)
printHtmlPart(15)
invokeTag('message','g',35,['code':("glBatchHdrInstance.valueDate.label"),'default':("Batch Name")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',36,['format':("MM/dd/yyyy"),'date':(glBatchHdrInstance?.valueDate)],-1)
printHtmlPart(16)
invokeTag('set','g',53,['var':("batchOk"),'value':(0)],-1)
printHtmlPart(17)
loop:{
int i = 0
for( glBatch in (glBatchInstance) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(glBatch.lineNo)
printHtmlPart(20)
if(true && (glBatch.debit != 0)) {
printHtmlPart(21)
expressionOut.print(glBatch.debitAccount)
printHtmlPart(20)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (glBatch.credit != 0)) {
printHtmlPart(21)
expressionOut.print(glBatch.creditAccount)
printHtmlPart(20)
}
else {
printHtmlPart(22)
}
printHtmlPart(24)
if(true && (glBatch.debit != 0)) {
printHtmlPart(25)
invokeTag('formatNumber','g',70,['format':("###,###,##0.00"),'number':(glBatch?.debit)],-1)
printHtmlPart(20)
}
else {
printHtmlPart(22)
}
printHtmlPart(24)
if(true && (glBatch.credit != 0)) {
printHtmlPart(25)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(glBatch?.credit)],-1)
printHtmlPart(20)
}
else {
printHtmlPart(22)
}
printHtmlPart(26)
expressionOut.print(glBatch.reference)
printHtmlPart(27)
expressionOut.print(glBatch.particulars)
printHtmlPart(28)
if(true && (glBatch.lineStatus)) {
printHtmlPart(29)
invokeTag('set','g',86,['var':("batchOk"),'value':(1)],-1)
printHtmlPart(30)
expressionOut.print(glBatch.lineStatus)
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
i++
}
}
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',98,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',101,['class':("btn btn-primary btn-xs"),'action':("edit"),'id':(glBatchHdrInstance.id)],3)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',102,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance.id)],3)
printHtmlPart(39)
if(true && (batchOk==0)) {
printHtmlPart(40)
createClosureForHtmlPart(41, 4)
invokeTag('link','g',104,['class':("btn btn-primary btn-xs"),'target':("_blank"),'action':("glBatchApproval"),'id':(glBatchHdrInstance.id)],4)
printHtmlPart(39)
}
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',106,['class':("btn btn-primary btn-xs"),'action':("index")],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',108,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',109,[:],1)
printHtmlPart(45)
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
