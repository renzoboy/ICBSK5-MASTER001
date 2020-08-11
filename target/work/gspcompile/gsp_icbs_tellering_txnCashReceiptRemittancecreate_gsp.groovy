import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashReceiptRemittancecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashReceiptRemittance/create.gsp" }
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
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(5)
invokeTag('javascript','asset',13,['src':("telleringHelper.js")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'tellering', action:'showCustomerDetailsAjax'))
printHtmlPart(9)
})
invokeTag('javascript','g',34,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(12, 2)
invokeTag('captureContent','sitemesh',40,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
invokeTag('img','g',62,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
invokeTag('img','g',70,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(17)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(21)
expressionOut.print(error.field)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('message','g',94,['error':(error)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',95,['bean':(txnCashReceiptRemittanceInstance),'var':("error")],4)
printHtmlPart(25)
})
invokeTag('hasErrors','g',99,['bean':(txnCashReceiptRemittanceInstance)],3)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('render','g',101,['template':("txnCashReceiptRemittance/form"),'model':([txnCashReceiptRemittanceInstance:txnCashReceiptRemittanceInstance])],-1)
printHtmlPart(13)
})
invokeTag('form','g',102,['name':("txnCashReceiptRemittanceForm"),'action':("saveTellerOtherCashReceiptRemittanceTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-content")],2)
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('jasperReport','g',107,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(30)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',147,['action':("index")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-actions")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',150,[:],1)
printHtmlPart(35)
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
