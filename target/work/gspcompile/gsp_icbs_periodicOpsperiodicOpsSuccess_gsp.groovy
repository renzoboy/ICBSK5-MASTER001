import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsperiodicOpsSuccess_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/periodicOpsSuccess.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
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
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/periodicOps'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (periodicLogInstance?.periodicOpsProcess?.id == 1)) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(periodicLogInstance.startTime)
printHtmlPart(11)
expressionOut.print(periodicLogInstance.endTime)
printHtmlPart(12)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy "),'date':(periodicLogInstance.runDate)],-1)
printHtmlPart(13)
expressionOut.print(periodicLogInstance.user?.name1)
printHtmlPart(14)
expressionOut.print(periodicLogInstance.user?.name2)
printHtmlPart(14)
expressionOut.print(periodicLogInstance.user?.name3)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',55,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',60,['class':("index"),'action':("index")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(20)
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
