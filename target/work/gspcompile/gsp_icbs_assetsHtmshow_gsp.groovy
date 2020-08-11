import icbs.gl.AssetsHeldToMaturity
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_assetsHtmshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/assetsHtm/show.gsp" }
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
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(htmInstance?.branch?.name)
printHtmlPart(13)
expressionOut.print(htmInstance?.currency?.name)
printHtmlPart(14)
expressionOut.print(htmInstance?.residentType?.description)
printHtmlPart(15)
expressionOut.print(htmInstance?.glCode)
printHtmlPart(16)
expressionOut.print(GlAccount.findByCode(htmInstance?.glCode).name)
printHtmlPart(17)
expressionOut.print(htmInstance?.htmAccrualDebitAcct)
printHtmlPart(18)
expressionOut.print(GlAccount.findByCode(htmInstance?.htmAccrualDebitAcct).name)
printHtmlPart(19)
expressionOut.print(htmInstance?.htmAccrualCredittAcct)
printHtmlPart(20)
expressionOut.print(GlAccount.findByCode(htmInstance?.htmAccrualCredittAcct).name)
printHtmlPart(21)
invokeTag('formatNumber','g',77,['format':("###,###,##0.00"),'number':(htmInstance?.amount)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',81,['format':("###,###,##0.00"),'number':(htmInstance?.interestRate)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',85,['format':("MM/dd/yyyy"),'date':(htmInstance?.valueDate)],-1)
printHtmlPart(24)
invokeTag('formatDate','g',89,['format':("MM/dd/yyyy"),'date':(htmInstance?.maturityDate)],-1)
printHtmlPart(25)
expressionOut.print(htmInstance?.htmTypeDesc?.description)
printHtmlPart(26)
invokeTag('formatNumber','g',97,['format':("###,###,##0.00"),'number':(htmInstance?.discountAmount)],-1)
printHtmlPart(27)
expressionOut.print(htmInstance?.htmDescription)
printHtmlPart(28)
expressionOut.print(htmInstance?.htmIssuer)
printHtmlPart(29)
invokeTag('formatNumber','g',109,['format':("###,###,##0.00"),'number':(htmInstance?.effectiveYield)],-1)
printHtmlPart(30)
expressionOut.print(htmInstance?.reference)
printHtmlPart(31)
invokeTag('formatDate','g',119,['format':("MM/dd/yyyy"),'date':(htmInstance?.createdDate)],-1)
printHtmlPart(32)
expressionOut.print(htmInstance?.status.description)
printHtmlPart(33)
for( htmScheduleList in (htmScheduleInstance) ) {
printHtmlPart(34)
invokeTag('formatDate','g',149,['format':("MM/dd/yyyy"),'date':(htmScheduleList?.xhtmScheduleDate)],-1)
printHtmlPart(35)
invokeTag('formatNumber','g',150,['format':("###,###,##0.00"),'number':(htmScheduleList?.amount)],-1)
printHtmlPart(35)
expressionOut.print(htmScheduleList?.status?.description)
printHtmlPart(36)
}
printHtmlPart(37)
invokeTag('formatNumber','g',160,['format':("###,###,##0.00"),'number':(totalDiscountInstance)],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',164,['format':("###,###,##0.00"),'number':(remainingDiscount)],-1)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',177,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(40)
if(true && (htmInstance.status.id != 8)) {
printHtmlPart(41)
createClosureForHtmlPart(42, 4)
invokeTag('link','g',181,['action':("edit"),'controller':("assetsHtm"),'id':(htmInstance.id)],4)
printHtmlPart(43)
createClosureForHtmlPart(44, 4)
invokeTag('link','g',182,['action':("htmDebit"),'controller':("assetsHtm"),'id':(htmInstance?.id)],4)
printHtmlPart(43)
createClosureForHtmlPart(45, 4)
invokeTag('link','g',183,['action':("htmCredit"),'controller':("assetsHtm"),'id':(htmInstance?.id)],4)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (htmInstance.amount > 0)) {
printHtmlPart(41)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',186,['action':("reclassHtm"),'controller':("assetsHtm"),'id':(htmInstance.id)],4)
printHtmlPart(49)
}
printHtmlPart(50)
createClosureForHtmlPart(51, 3)
invokeTag('link','g',189,['action':("viewMoreTransaction"),'controller':("assetsHtm"),'id':(htmInstance?.id)],3)
printHtmlPart(52)
createClosureForHtmlPart(53, 3)
invokeTag('link','g',190,['action':("index"),'controller':("assetsHtm")],3)
printHtmlPart(54)
})
invokeTag('captureContent','sitemesh',192,['tag':("main-actions")],2)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',194,[:],1)
printHtmlPart(56)
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
