import icbs.gl.AccountsPayable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanscrCreateDiscountSchedule_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/scrCreateDiscountSchedule.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/showDiscountSchedule'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(12)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(13)
invokeTag('formatNumber','g',39,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(14)
expressionOut.print(loanInstance?.loanPerformanceId.description)
printHtmlPart(15)
expressionOut.print(loanInstance?.status.description)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('customDatePicker','g',63,['id':("scheduleDate"),'name':("scheduleDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(18)
invokeTag('field','g',70,['class':("form-control truncated"),'id':("debitAmt"),'name':("debitAmt"),'value':("")],-1)
printHtmlPart(19)
invokeTag('field','g',79,['class':("form-control truncated"),'id':("creditAmt"),'name':("creditAmt"),'value':("")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',84,['name':("loanId"),'id':("loanId"),'value':(params?.id)],-1)
printHtmlPart(21)
invokeTag('field','g',89,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(22)
invokeTag('field','g',95,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(23)
})
invokeTag('form','g',99,['id':("scrDiscount"),'url':([action:'saveScrDiscountSchedule', controller: 'loan']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('javascript','g',153,[:],3)
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',154,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',159,['action':("showDiscountSchedule"),'controller':("loan"),'id':(loanInstance.id)],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',160,['action':("show"),'controller':("loan"),'id':(loanInstance.id)],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',162,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',163,[:],1)
printHtmlPart(32)
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
