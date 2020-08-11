import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_deductions_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/deductions/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["deductions"])) {
printHtmlPart(1)
invokeTag('set','g',19,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( deduction in (session["deductions"]) ) {
printHtmlPart(2)
invokeTag('set','g',22,['var':("type"),'value':(deduction?.scheme?.type.id)],-1)
printHtmlPart(3)
expressionOut.print(deduction?.scheme?.name)
printHtmlPart(4)
expressionOut.print(deduction?.scheme?.type?.description)
printHtmlPart(5)
if(true && (type == 2)) {
printHtmlPart(6)
expressionOut.print(deduction?.scheme?.rate)
printHtmlPart(7)
}
else {
printHtmlPart(6)
expressionOut.print(deduction?.amount)
printHtmlPart(5)
}
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(9)
expressionOut.print(i)
printHtmlPart(10)
invokeTag('set','g',35,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('hiddenField','g',68,['name':("deductionId"),'value':("")],-1)
printHtmlPart(13)
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
