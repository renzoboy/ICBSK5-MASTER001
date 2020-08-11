import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigation_attachments_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/attachments/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (creditInvestigationInstance?.attachments)) {
printHtmlPart(1)
for( attachment in (creditInvestigationInstance?.attachments.sort{it.fileName}) ) {
printHtmlPart(2)
expressionOut.print(attachment?.fileName)
printHtmlPart(3)
expressionOut.print(attachment?.description)
printHtmlPart(3)
expressionOut.print(attachment?.type?.description)
printHtmlPart(4)
expressionOut.print(attachment?.id)
printHtmlPart(5)
expressionOut.print(attachment?.id)
printHtmlPart(6)
}
printHtmlPart(7)
}
else if(true && (session["attachments"])) {
printHtmlPart(1)
invokeTag('set','g',31,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( attachment in (session["attachments"]) ) {
printHtmlPart(2)
expressionOut.print(attachment?.fileName)
printHtmlPart(3)
expressionOut.print(attachment?.description)
printHtmlPart(3)
expressionOut.print(attachment?.type?.description)
printHtmlPart(4)
expressionOut.print(i)
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(8)
invokeTag('set','g',41,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('hiddenField','g',74,['name':("attachmentId"),'value':("")],-1)
printHtmlPart(11)
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
