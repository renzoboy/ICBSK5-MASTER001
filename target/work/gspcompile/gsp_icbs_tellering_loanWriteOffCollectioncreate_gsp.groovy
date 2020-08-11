import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_loanWriteOffCollectioncreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/loanWriteOffCollection/create.gsp" }
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
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(8)
expressionOut.print(loanLedgerInstance?.loan?.id)
printHtmlPart(9)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(10)
})
invokeTag('javascript','g',68,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',69,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',74,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
invokeTag('img','g',96,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(17)
invokeTag('img','g',104,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
expressionOut.print(it)
printHtmlPart(21)
})
invokeTag('hasErrors','g',120,['bean':(txnLoanCashSpecifiedRepaymentInstance)],3)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('render','g',123,['template':("/tellering/loanWriteOffCollection/form")],-1)
printHtmlPart(23)
})
invokeTag('form','g',125,['id':("writeOffCollectionFrm"),'name':("writeOffCollectionFrm"),'url':([controller: 'tellering', action:'saveLoanWriteOffColletion']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-content")],2)
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('jasperReport','g',131,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',177,['action':("index")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',179,['tag':("main-actions")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',180,[:],1)
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
