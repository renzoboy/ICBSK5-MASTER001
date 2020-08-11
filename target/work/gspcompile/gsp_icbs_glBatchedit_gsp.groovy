import icbs.gl.GlBatch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'General Ledger Batch'))],-1)
printHtmlPart(2)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(3)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(2)
}
else {
printHtmlPart(5)
createTagBody(3, {->
createClosureForHtmlPart(6, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(2)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'glBatch',action:'getBatchByBatchIdAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'glBatch',action:'getBatchDetailsAjax'))
printHtmlPart(10)
expressionOut.print(glBatchHdrInstance?.batchId)
printHtmlPart(11)
expressionOut.print(createLink(controller:'glBatch',action:'updateBatchGLTransactions'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'glBatch',action:'saveGLBatchTransactions'))
printHtmlPart(13)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(14)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'GlBatch',action:'addAttachment'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'GlBatch',action:'removeAttachment'))
printHtmlPart(17)
})
invokeTag('javascript','g',147,[:],2)
printHtmlPart(18)
})
invokeTag('captureHead','sitemesh',148,[:],1)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(createLink(uri: '/glBatch'))
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',153,['tag':("breadcrumbs")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
if(true && (flash.message)) {
printHtmlPart(24)
expressionOut.print(flash.message)
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
createTagBody(4, {->
printHtmlPart(28)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(29)
expressionOut.print(error.field)
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('message','g',165,['error':(error)],-1)
printHtmlPart(32)
})
invokeTag('eachError','g',166,['bean':(glBatchInstance),'var':("error")],4)
printHtmlPart(33)
})
invokeTag('hasErrors','g',168,['bean':(glBatchInstance)],3)
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(35)
invokeTag('render','g',180,['template':("form")],-1)
printHtmlPart(36)
})
invokeTag('form','g',182,['url':([resource:glBatchInstance, action:'save'])],3)
printHtmlPart(37)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
invokeTag('render','g',200,['template':("transactions_table")],-1)
printHtmlPart(41)
invokeTag('render','g',204,['template':("batch_attachment")],-1)
printHtmlPart(42)
invokeTag('render','g',209,['template':("modal")],-1)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',213,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(44)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(45)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(46)
invokeTag('message','g',217,['code':("default.home.label")],-1)
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',218,['class':("list"),'action':("index")],4)
printHtmlPart(49)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',219,['class':("create"),'action':("create")],4)
printHtmlPart(51)
}
else {
printHtmlPart(52)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(46)
invokeTag('message','g',222,['code':("default.home.label")],-1)
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',223,['class':("list"),'action':("index")],4)
printHtmlPart(49)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',224,['class':("create"),'action':("create")],4)
printHtmlPart(49)
createClosureForHtmlPart(53, 4)
invokeTag('link','g',225,['class':("approve"),'action':("approve"),'id':(glBatchHdrInstance?.batchId),'params':(['bId': glBatchHdrInstance?.batchId])],4)
printHtmlPart(49)
createClosureForHtmlPart(54, 4)
invokeTag('link','g',226,['class':("printGlBatch"),'target':("_blank"),'action':("printGlBatch"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],4)
printHtmlPart(49)
createClosureForHtmlPart(55, 4)
invokeTag('link','g',227,['class':("voucherDetailsCheck"),'action':("voucherDetailsCheck"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],4)
printHtmlPart(49)
createClosureForHtmlPart(56, 4)
invokeTag('link','g',228,['class':("printGlBatchVoucher"),'target':("_blank"),'action':("printGlBatchVoucher"),'id':(glBatchHdrInstance?.id),'params':(['Bid': glBatchHdrInstance?.id])],4)
printHtmlPart(57)
}
printHtmlPart(58)
})
invokeTag('captureContent','sitemesh',232,['tag':("main-actions")],2)
printHtmlPart(59)
})
invokeTag('captureBody','sitemesh',234,[:],1)
printHtmlPart(60)
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
