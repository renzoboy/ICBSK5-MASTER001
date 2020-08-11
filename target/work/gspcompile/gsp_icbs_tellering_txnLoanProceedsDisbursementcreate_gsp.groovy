import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanProceedsDisbursementcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanProceedsDisbursement/create.gsp" }
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
expressionOut.print(createLink(controller : 'tellering', action:'changeLoanDetails'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'tellering', action:'changeLoanDetails'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'loan', action:'search', params:[searchDomain: "loan", flag: flag_]))
printHtmlPart(10)
})
invokeTag('javascript','g',72,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',73,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',78,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
invokeTag('img','g',100,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(17)
invokeTag('img','g',108,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
expressionOut.print(it)
printHtmlPart(21)
createTagBody(4, {->
printHtmlPart(22)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(23)
expressionOut.print(error.field)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('message','g',132,['error':(error)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',133,['bean':(txnLoanProceedsDisbursementInstance),'var':("error")],4)
printHtmlPart(27)
})
invokeTag('hasErrors','g',137,['bean':(txnLoanProceedsDisbursementInstance)],3)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(28)
invokeTag('render','g',140,['template':("txnLoanProceedsDisbursement/form"),'model':([txnLoanProceedsDisbursementInstance:txnLoanProceedsDisbursementInstance])],-1)
printHtmlPart(19)
})
invokeTag('form','g',141,['name':("txnLoanProceedsDisbursementForm"),'action':("saveTellerLoanProceedsDisbursementTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',143,['tag':("main-content")],2)
printHtmlPart(30)
createClosureForHtmlPart(31, 2)
invokeTag('jasperReport','g',147,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',204,['action':("index")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',206,['tag':("main-actions")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',207,[:],1)
printHtmlPart(38)
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
