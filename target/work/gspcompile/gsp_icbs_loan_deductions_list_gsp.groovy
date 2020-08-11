import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_deductions_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/deductions/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (loanInstance?.status)) {
printHtmlPart(1)
if(true && (loanInstance?.status.id == 1 || loanInstance?.loanPerformanceId.id == 2)) {
printHtmlPart(2)
}
printHtmlPart(1)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (session["deductions"])) {
printHtmlPart(5)
invokeTag('set','g',26,['var':("i"),'value':(0)],-1)
printHtmlPart(6)
invokeTag('set','g',27,['var':("x"),'value':(0)],-1)
printHtmlPart(5)
for( deduction in (session["deductions"]) ) {
printHtmlPart(7)
invokeTag('set','g',30,['var':("type"),'value':(deduction?.scheme?.type.id)],-1)
printHtmlPart(8)
expressionOut.print(deduction?.scheme?.name)
printHtmlPart(9)
expressionOut.print(deduction?.scheme?.type?.description)
printHtmlPart(10)
invokeTag('formatNumber','g',33,['format':("###,##0.00"),'number':(deduction?.amount)],-1)
printHtmlPart(11)
expressionOut.print(i)
printHtmlPart(12)
expressionOut.print(i)
printHtmlPart(13)
invokeTag('set','g',38,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(14)
invokeTag('set','g',39,['var':("x"),'value':(x + deduction?.amount)],-1)
printHtmlPart(5)
}
printHtmlPart(15)
invokeTag('formatNumber','g',44,['format':("###,##0.00"),'number':(x)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('hiddenField','g',77,['name':("deductionId"),'value':("")],-1)
printHtmlPart(18)
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
