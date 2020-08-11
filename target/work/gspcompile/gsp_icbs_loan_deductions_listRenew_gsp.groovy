import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_deductions_listRenew_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/deductions/_listRenew.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["deductions"])) {
printHtmlPart(1)
invokeTag('set','g',19,['var':("i"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',20,['var':("x"),'value':(0)],-1)
printHtmlPart(1)
for( deduction in (session["deductions"]) ) {
printHtmlPart(3)
invokeTag('set','g',23,['var':("type"),'value':(deduction?.scheme?.type.id)],-1)
printHtmlPart(4)
expressionOut.print(deduction?.scheme?.name)
printHtmlPart(5)
expressionOut.print(deduction?.scheme?.type?.description)
printHtmlPart(6)
invokeTag('formatNumber','g',26,['format':("###,##0.00"),'number':(deduction?.amount)],-1)
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('set','g',31,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(10)
invokeTag('set','g',32,['var':("x"),'value':(x + deduction?.amount)],-1)
printHtmlPart(1)
}
printHtmlPart(11)
invokeTag('formatNumber','g',37,['format':("###,##0.00"),'number':(x)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('hiddenField','g',70,['name':("deductionId"),'value':("")],-1)
printHtmlPart(14)
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
