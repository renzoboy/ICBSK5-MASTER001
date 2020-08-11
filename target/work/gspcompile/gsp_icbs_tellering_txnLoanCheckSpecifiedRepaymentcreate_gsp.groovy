import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCheckSpecifiedRepaymentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCheckSpecifiedRepayment/create.gsp" }
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
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(15)
})
invokeTag('javascript','g',171,[:],2)
printHtmlPart(16)
})
invokeTag('captureHead','sitemesh',211,[:],1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(18, 2)
invokeTag('captureContent','sitemesh',216,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(19)
if(true && (flash.message)) {
printHtmlPart(20)
expressionOut.print(flash.message)
printHtmlPart(21)
invokeTag('img','g',254,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(22)
invokeTag('img','g',262,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(23)
}
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(it)
printHtmlPart(26)
createTagBody(4, {->
printHtmlPart(27)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(28)
expressionOut.print(error.field)
printHtmlPart(29)
}
printHtmlPart(30)
invokeTag('message','g',286,['error':(error)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',287,['bean':(txnLoanCheckSpecifiedRepaymentInstance),'var':("error")],4)
printHtmlPart(32)
})
invokeTag('hasErrors','g',291,['bean':(txnLoanCheckSpecifiedRepaymentInstance)],3)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(33)
invokeTag('render','g',294,['template':("txnLoanCheckSpecifiedRepayment/form"),'model':([txnLoanCheckSpecifiedRepaymentInstance:txnLoanCheckSpecifiedRepaymentInstance])],-1)
printHtmlPart(24)
})
invokeTag('form','g',295,['name':("txnLoanCheckSpecifiedRepaymentForm"),'action':("saveTellerLoanCheckSpecifiedRepaymentTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',297,['tag':("main-content")],2)
printHtmlPart(35)
createClosureForHtmlPart(36, 2)
invokeTag('jasperReport','g',301,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',365,['action':("index")],3)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',367,['tag':("main-actions")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',368,[:],1)
printHtmlPart(43)
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
