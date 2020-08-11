import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckToCOCIcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckToCOCI/create.gsp" }
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
createClosureForHtmlPart(5, 2)
invokeTag('javascript','g',21,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',79,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(8, 2)
invokeTag('captureContent','sitemesh',84,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(2)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
invokeTag('img','g',107,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
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
invokeTag('eachError','g',123,['bean':(txnCashTransferInstance),'var':("error")],4)
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(18)
expressionOut.print(error.field)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',133,['error':(error)],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',134,['bean':(txnCheckToCOCIInstance),'var':("error")],4)
printHtmlPart(22)
})
invokeTag('hasErrors','g',138,['bean':(txnCheckToCOCIInstance)],3)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('render','g',141,['template':("txnCheckToCOCI/form"),'model':([txnCheckToCOCIInstance:txnCheckToCOCIInstance])],-1)
printHtmlPart(12)
})
invokeTag('form','g',142,['name':("txnCheckToCOCIForm"),'action':("saveTellerCheckToCOCITxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',144,['tag':("main-content")],2)
printHtmlPart(26)
createClosureForHtmlPart(27, 2)
invokeTag('jasperReport','g',148,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',164,['action':("index"),'onclick':("return confirm('Are you sure you want to return to the Tellering Index page?');")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',166,['tag':("main-actions")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',167,[:],1)
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
