import icbs.loans.ScrDiscountSchedule
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanshowDiscountSchedule_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/showDiscountSchedule.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(11)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(12)
invokeTag('formatNumber','g',44,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(13)
expressionOut.print(loanInstance?.loanPerformanceId.description)
printHtmlPart(14)
expressionOut.print(loanInstance?.status.description)
printHtmlPart(15)
for( scrSchedInstance in (scrDiscountScheduleInstance) ) {
printHtmlPart(16)
expressionOut.print(scrSchedInstance?.id)
printHtmlPart(17)
invokeTag('formatDate','g',77,['format':("MM/dd/yyyy"),'date':(scrSchedInstance?.scheduleDate)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',78,['format':("###,###,##0.00"),'number':(scrSchedInstance?.debitAmt)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',79,['format':("###,###,##0.00"),'number':(scrSchedInstance?.creditAmt)],-1)
printHtmlPart(17)
expressionOut.print(scrSchedInstance?.reference)
printHtmlPart(17)
expressionOut.print(scrSchedInstance?.particulars)
printHtmlPart(18)
expressionOut.print(scrSchedInstance?.createdBy?.name1)
printHtmlPart(19)
expressionOut.print(scrSchedInstance?.createdBy?.name2)
printHtmlPart(19)
expressionOut.print(scrSchedInstance?.createdBy?.name3)
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',94,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',98,['action':("scrCreateDiscountSchedule"),'controller':("loan"),'id':(loanInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',99,['action':("show"),'controller':("loan"),'id':(loanInstance.id)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(28)
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
