import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fsControlAccountshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fsControlAccount/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/fsControlAccount'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(fsControlAccountInstance?.id)
printHtmlPart(13)
expressionOut.print(fsControlAccountInstance?.account)
printHtmlPart(14)
expressionOut.print(fsControlAccountInstance?.description)
printHtmlPart(15)
expressionOut.print(fsControlAccountInstance?.status?.description)
printHtmlPart(16)
invokeTag('formatDate','g',52,['format':("MM/dd/yyyy"),'date':(fsControlAccountInstance.xCreatedDate)],-1)
printHtmlPart(17)
expressionOut.print(fsControlAccountInstance?.createdBy?.name1)
printHtmlPart(18)
expressionOut.print(fsControlAccountInstance?.createdBy?.name2)
printHtmlPart(18)
expressionOut.print(fsControlAccountInstance?.createdBy?.name3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',70,['action':("edit"),'controller':("fsControlAccount"),'id':(fsControlAccountInstance.id)],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',71,['action':("create"),'controller':("fsControlAccount"),'id':(fsControlAccountInstance.id)],3)
printHtmlPart(22)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',72,['action':("index"),'controller':("fsControlAccount")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',77,[:],1)
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
