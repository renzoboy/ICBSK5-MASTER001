import icbs.gl.AccountsPayable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableapClose_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/apClose.gsp" }
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
expressionOut.print(createLink(uri: '/accountsPayable'))
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
expressionOut.print(accountsPayableInstance?.branch?.name)
printHtmlPart(12)
expressionOut.print(accountsPayableInstance.payable)
printHtmlPart(13)
expressionOut.print(accountsPayableInstance.particulars)
printHtmlPart(14)
expressionOut.print(accountsPayableInstance?.currency?.code)
printHtmlPart(15)
expressionOut.print(accountsPayableInstance.glContra)
printHtmlPart(16)
invokeTag('formatDate','g',48,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.bookingDate)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(accountsPayableInstance.balance)],-1)
printHtmlPart(18)
expressionOut.print(accountsPayableInstance?.user?.name)
printHtmlPart(19)
expressionOut.print(accountsPayableInstance.status)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',65,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',69,['action':("saveApClose"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',70,['action':("show"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',72,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(27)
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
