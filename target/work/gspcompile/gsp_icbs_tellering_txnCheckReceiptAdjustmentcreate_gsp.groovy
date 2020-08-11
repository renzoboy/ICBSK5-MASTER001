import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckReceiptAdjustmentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckReceiptAdjustment/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
invokeTag('javascript','asset',12,['src':("telleringHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(10)
})
invokeTag('javascript','g',87,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',126,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',130,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
invokeTag('img','g',168,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
expressionOut.print(it)
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(22)
expressionOut.print(error.field)
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('message','g',192,['error':(error)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',193,['bean':(txnCheckReceiptAdjustmentInstance),'var':("error")],4)
printHtmlPart(26)
})
invokeTag('hasErrors','g',197,['bean':(txnCheckReceiptAdjustmentInstance)],3)
printHtmlPart(27)
createTagBody(3, {->
printHtmlPart(28)
invokeTag('render','g',199,['template':("txnCheckReceiptAdjustment/form"),'model':([txnCheckReceiptAdjustmentInstance:txnCheckReceiptAdjustmentInstance])],-1)
printHtmlPart(18)
})
invokeTag('form','g',200,['name':("txnCheckReceiptAdjustmentForm"),'action':("saveTellerOtherCheckReceiptAdjustmentTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',202,['tag':("main-content")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('jasperReport','g',206,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',251,['action':("index")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',253,['tag':("main-actions")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',254,[:],1)
printHtmlPart(37)
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
