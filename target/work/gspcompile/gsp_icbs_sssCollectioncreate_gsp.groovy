import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_sssCollectioncreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sssCollection/create.gsp" }
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
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',18,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',24,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
invokeTag('img','g',46,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
expressionOut.print(it)
printHtmlPart(15)
})
invokeTag('eachError','g',62,['bean':(txnReceiptAdjustmentInstance),'var':("error")],4)
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(18)
expressionOut.print(error.field)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',73,['error':(error)],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',74,['bean':(txnReceiptAdjustmentInstance),'var':("error")],4)
printHtmlPart(22)
})
invokeTag('hasErrors','g',78,['bean':(txnReceiptAdjustmentInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('render','g',81,['template':("form")],-1)
printHtmlPart(8)
})
invokeTag('form','g',82,['name':("txnReceiptAdjustmentForm"),'action':("save"),'controller':("sssCollection"),'onsubmit':("return alertify.alert('Please wait... Processing....')")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-content")],2)
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('jasperReport','g',88,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',120,['action':("index")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-actions")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(33)
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
