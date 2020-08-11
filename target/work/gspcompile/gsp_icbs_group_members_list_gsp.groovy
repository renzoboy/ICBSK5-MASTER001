import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_group_members_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/members/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (groupInstance?.members)) {
printHtmlPart(1)
for( member in (groupInstance?.members.sort{it.id}) ) {
printHtmlPart(2)
expressionOut.print(member?.id)
printHtmlPart(3)
expressionOut.print(member?.displayName)
printHtmlPart(4)
expressionOut.print(member?.id)
printHtmlPart(5)
}
printHtmlPart(6)
}
printHtmlPart(6)
if(true && (session["members"])) {
printHtmlPart(1)
invokeTag('set','g',28,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( member in (session["members"]) ) {
printHtmlPart(7)
expressionOut.print(member?.id)
printHtmlPart(3)
expressionOut.print(member?.displayName)
printHtmlPart(4)
expressionOut.print(i)
printHtmlPart(8)
invokeTag('set','g',35,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(9)
}
printHtmlPart(10)
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
