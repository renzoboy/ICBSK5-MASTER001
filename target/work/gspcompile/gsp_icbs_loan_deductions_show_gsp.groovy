import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_deductions_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/deductions/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( deduction in (loanInstance?.loanDeductions.sort{it.scheme.id}) ) {
printHtmlPart(1)
invokeTag('set','g',17,['var':("type"),'value':(deduction?.scheme?.type.id)],-1)
printHtmlPart(2)
expressionOut.print(deduction?.scheme?.name)
printHtmlPart(3)
expressionOut.print(deduction?.scheme?.type?.description)
printHtmlPart(4)
invokeTag('formatNumber','g',20,['format':("###,##0.00"),'number':(deduction?.amount)],-1)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('formatNumber','g',31,['format':("###,##0.00"),'number':(totalDeductions)],-1)
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
