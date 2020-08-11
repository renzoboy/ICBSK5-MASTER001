import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_attachments_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/attachments/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( attachment in (ropaCollateralDetailsInstance?.attachments.sort{it.fileName}) ) {
printHtmlPart(1)
expressionOut.print(attachment?.fileName)
printHtmlPart(2)
expressionOut.print(attachment?.description)
printHtmlPart(2)
expressionOut.print(attachment?.type?.description)
printHtmlPart(2)
createClosureForHtmlPart(3, 2)
invokeTag('link','g',20,['class':("btn btn-secondary"),'target':("_blank"),'action':("showAttachment"),'id':(attachment?.id)],2)
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',20,['class':("btn btn-secondary"),'action':("downloadAttachment"),'id':(attachment?.id)],2)
printHtmlPart(6)
}
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
