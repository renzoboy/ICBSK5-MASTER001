import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnBillsPaymentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnBillsPayment/create.gsp" }
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
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(11)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(12)
})
invokeTag('javascript','g',64,[:],2)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',65,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(15, 2)
invokeTag('captureContent','sitemesh',70,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
invokeTag('img','g',92,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(19)
invokeTag('img','g',100,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('render','g',108,['template':("txnBillsPayment/form"),'model':([txnBillsPaymentInstance:txnBillsPaymentInstance])],-1)
printHtmlPart(16)
})
invokeTag('form','g',109,['name':("txnBillsPaymentForm"),'action':("saveTellerOtherCashReceiptBillsPaymentTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',148,['tag':("main-content")],2)
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('jasperReport','g',151,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',155,['action':("index")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',157,['tag':("main-actions")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',158,[:],1)
printHtmlPart(30)
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
