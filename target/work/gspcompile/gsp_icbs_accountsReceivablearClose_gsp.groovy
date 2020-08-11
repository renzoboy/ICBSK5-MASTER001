import icbs.gl.AccountsReceivable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivablearClose_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/arClose.gsp" }
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
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(accountsReceivableInstance?.branch?.name)
printHtmlPart(12)
expressionOut.print(accountsReceivableInstance.receivableName)
printHtmlPart(13)
expressionOut.print(accountsReceivableInstance.description)
printHtmlPart(14)
expressionOut.print(accountsReceivableInstance.reference)
printHtmlPart(15)
expressionOut.print(accountsReceivableInstance?.currency?.code)
printHtmlPart(16)
expressionOut.print(accountsReceivableInstance.glContra)
printHtmlPart(17)
invokeTag('formatDate','g',52,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.bookingDate)],-1)
printHtmlPart(18)
invokeTag('formatDate','g',56,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.maturityDate)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',60,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.requiredAllowance)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.balance)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',68,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.requiredValuationReserves)],-1)
printHtmlPart(22)
expressionOut.print(accountsReceivableInstance?.user?.name)
printHtmlPart(23)
expressionOut.print(accountsReceivableInstance.status)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',85,['action':("saveArClose"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',86,['action':("show"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(31)
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
