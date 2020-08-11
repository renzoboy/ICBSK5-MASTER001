import icbs.loans.ROPA
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaShow.gsp" }
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
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/ropa'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',16,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(ropaInstance?.balanceAmt)
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',39,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',42,['action':("edit"),'id':(ropaInstance?.id)],3)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',43,['action':("viewTransactions"),'id':(RopaInstance?.id)],3)
printHtmlPart(17)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',44,['action':("ropaDebit"),'id':(ropaInstance?.id)],3)
printHtmlPart(17)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',45,['action':("ropaCredit"),'id':(ropaInstance?.id)],3)
printHtmlPart(17)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',46,['action':("ropaExpense"),'id':(RopaInstance?.id)],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',47,['action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',49,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',50,[:],1)
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
