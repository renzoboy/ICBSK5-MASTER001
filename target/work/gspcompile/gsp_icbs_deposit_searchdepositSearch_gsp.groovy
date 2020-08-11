import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_searchdepositSearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/search/depositSearch.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('render','g',19,['template':("/search/searchTemplate/searchDeposit")],-1)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',20,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',23,['class':(""),'action':("create"),'resource':("")],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',24,['action':("/depositInquiry")],3)
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',26,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',27,[:],1)
printHtmlPart(12)
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
