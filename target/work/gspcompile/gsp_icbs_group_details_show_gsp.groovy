import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_group_details_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/details/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(groupInstance?.name)
printHtmlPart(1)
expressionOut.print(groupInstance?.description)
printHtmlPart(2)
expressionOut.print(groupInstance?.type?.description)
printHtmlPart(3)
expressionOut.print(groupInstance?.parent?.name)
printHtmlPart(4)
invokeTag('formatDate','g',25,['format':("MM/dd/yyyy"),'date':(groupInstance?.meetingDate)],-1)
printHtmlPart(5)
invokeTag('formatDate','g',31,['format':("MM/dd/yyyy"),'date':(groupInstance?.dateCreated)],-1)
printHtmlPart(6)
expressionOut.print(groupInstance?.status?.description)
printHtmlPart(7)
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
