import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashTransferreceive_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashTransfer/receive.gsp" }
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
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',21,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',57,[:],3)
printHtmlPart(9)
invokeTag('hiddenField','g',60,['id':("txnfile"),'name':("myField"),'value':(session["transactionFileId"])],-1)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('render','g',62,['template':("txnCashTransfer/receiveform"),'model':([txnCashTransferInstance:txnCashTransferInstance,sourcetxn:sourcetxn])],-1)
printHtmlPart(10)
invokeTag('actionSubmit','g',63,['id':("tlrcashsave"),'value':("Sum"),'action':("receiveTellerCashTransferSave"),'style':("display:none")],-1)
printHtmlPart(11)
invokeTag('actionSubmit','g',64,['id':("tlrcashcancel"),'value':("Difference"),'action':("receiveTellerCashCancel"),'style':("display:none")],-1)
printHtmlPart(7)
})
invokeTag('form','g',65,['name':("txnCashTransferForm"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printValidationSlip', params: [txnFile:session.transactionFileId]))
printHtmlPart(15)
invokeTag('img','g',86,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-content")],2)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('jasperReport','g',96,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(message(code: 'Receive', default: 'Receive'))
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',101,['action':("index")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',150,['tag':("main-actions")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',151,[:],1)
printHtmlPart(25)
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
