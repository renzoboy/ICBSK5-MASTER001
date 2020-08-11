import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCashRepaymentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCashRepayment/create.gsp" }
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
expressionOut.print(createLink(controller : 'loan', action:'search', params:[searchDomain: "loan"]))
printHtmlPart(10)
})
invokeTag('javascript','g',156,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',157,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',162,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
invokeTag('img','g',184,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(17)
invokeTag('img','g',192,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(18)
}
printHtmlPart(14)
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
invokeTag('message','g',216,['error':(error)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',217,['bean':(txnLoanCashRepaymentInstance),'var':("error")],4)
printHtmlPart(26)
})
invokeTag('hasErrors','g',221,['bean':(txnLoanCashRepaymentInstance)],3)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('render','g',223,['template':("txnLoanCashRepayment/form"),'model':([txnLoanCashRepaymentInstance:txnLoanCashRepaymentInstance])],-1)
printHtmlPart(14)
})
invokeTag('form','g',224,['name':("txnLoanCashRepaymentForm"),'action':("saveTellerLoanCashRepaymentTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',226,['tag':("main-content")],2)
printHtmlPart(29)
createClosureForHtmlPart(30, 2)
invokeTag('jasperReport','g',230,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',269,['action':("index")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',271,['tag':("main-actions")],2)
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',272,[:],1)
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
