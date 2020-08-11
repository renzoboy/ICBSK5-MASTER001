import icbs.loans.ROPA
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/show.gsp" }
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
invokeTag('render','g',37,['template':("ropaInformation/show")],-1)
printHtmlPart(12)
invokeTag('render','g',41,['template':("collateralInformation/show")],-1)
printHtmlPart(13)
invokeTag('render','g',44,['template':("transactions/show")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',48,['id':("ropaid"),'name':("ropaid"),'value':(params.id)],-1)
printHtmlPart(4)
})
invokeTag('captureContent','sitemesh',49,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',52,['action':("edit"),'controller':("ropa"),'id':(ropapapapaInstance?.id)],3)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',53,['action':("index")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',56,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(21)
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
