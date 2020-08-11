import icbs.loans.ROPA
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaTransferSuccess_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaTransferSuccess.gsp" }
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
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/ropa'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',15,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('render','g',28,['template':("ropaTransfer/show")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',30,['id':("ropaid"),'name':("ropaid"),'value':(params.id)],-1)
printHtmlPart(4)
})
invokeTag('captureContent','sitemesh',31,['tag':("main-content")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',34,['action':("edit"),'controller':("ropa"),'id':(ropapapapaInstance?.id)],3)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',35,['action':("viewMoreTransaction"),'controller':("ropa"),'id':(ropapapapaInstance?.id)],3)
printHtmlPart(16)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',36,['action':("ropaDebit"),'controller':("ropa"),'id':(ropapapapaInstance?.id)],3)
printHtmlPart(16)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',37,['action':("ropaCredit"),'controller':("ropa"),'id':(ropapapapaInstance?.id)],3)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',38,['action':("index")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',40,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',41,[:],1)
printHtmlPart(23)
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
