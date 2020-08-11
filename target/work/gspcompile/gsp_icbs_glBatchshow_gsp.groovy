import icbs.gl.GlBatch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glBatch.label', default: 'General Ledger Batch'))],-1)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (glBatchInstance?.amount)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("glBatch.amount.label"),'default':("Amount")],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',22,['format':("###,###,##0.00"),'number':(glBatchInstance?.amount)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.batchId)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("glBatch.batchId.label"),'default':("Batch Id")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',31,['bean':(glBatchInstance),'field':("batchId")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.batchType)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("glBatch.batchType.label"),'default':("Batch Type")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(glBatchInstance),'field':("batchType")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.creditGL)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("glBatch.creditGL.label"),'default':("Credit GL")],-1)
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(glBatchInstance?.creditGL?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("glAccount"),'action':("show"),'id':(glBatchInstance?.creditGL?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.debitGl)) {
printHtmlPart(19)
invokeTag('message','g',56,['code':("glBatch.debitGl.label"),'default':("Debit Gl")],-1)
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(glBatchInstance?.debitGl?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("glAccount"),'action':("show"),'id':(glBatchInstance?.debitGl?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.lineNo)) {
printHtmlPart(21)
invokeTag('message','g',65,['code':("glBatch.lineNo.label"),'default':("Line No")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',67,['bean':(glBatchInstance),'field':("lineNo")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.lineStatus)) {
printHtmlPart(23)
invokeTag('message','g',74,['code':("glBatch.lineStatus.label"),'default':("Line Status")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',76,['bean':(glBatchInstance),'field':("lineStatus")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.particulars)) {
printHtmlPart(25)
invokeTag('message','g',83,['code':("glBatch.particulars.label"),'default':("Particulars")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',85,['bean':(glBatchInstance),'field':("particulars")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.recordDate)) {
printHtmlPart(27)
invokeTag('message','g',92,['code':("glBatch.recordDate.label"),'default':("Record Date")],-1)
printHtmlPart(28)
invokeTag('formatDate','g',94,['date':(glBatchInstance?.recordDate)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.reference)) {
printHtmlPart(29)
invokeTag('message','g',101,['code':("glBatch.reference.label"),'default':("Reference")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',103,['bean':(glBatchInstance),'field':("reference")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchInstance?.txnType)) {
printHtmlPart(31)
invokeTag('message','g',110,['code':("glBatch.txnType.label"),'default':("Txn Type")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',112,['bean':(glBatchInstance),'field':("txnType")],-1)
printHtmlPart(11)
}
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
createTagBody(4, {->
invokeTag('message','g',120,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',120,['class':("edit"),'action':("edit"),'resource':(glBatchInstance)],4)
printHtmlPart(35)
invokeTag('actionSubmit','g',121,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(36)
})
invokeTag('form','g',123,['url':([resource:glBatchInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',125,['tag':("main-content")],2)
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(40)
invokeTag('message','g',128,['code':("default.home.label")],-1)
printHtmlPart(41)
createTagBody(3, {->
invokeTag('message','g',129,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',129,['class':("list"),'action':("index")],3)
printHtmlPart(42)
createTagBody(3, {->
invokeTag('message','g',130,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',130,['class':("create"),'action':("create")],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(44)
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
