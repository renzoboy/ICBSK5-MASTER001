import icbs.loans.LoanRestructureHist
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_restructureDetails_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/restructureDetails/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( restructureHist in (LoanRestructureHist.findAllByLoan(loanInstance).sort{it.id}) ) {
printHtmlPart(1)
expressionOut.print(restructureHist?.id)
printHtmlPart(2)
invokeTag('formatDate','g',20,['format':("MM/dd/yyyy"),'date':(restructureHist?.restructuredDate)],-1)
printHtmlPart(2)
invokeTag('formatNumber','g',21,['format':("###,###,##0.00"),'number':(restructureHist?.amount)],-1)
printHtmlPart(2)
expressionOut.print(restructureHist?.status?.description)
printHtmlPart(2)
expressionOut.print(restructureHist?.restructuredBy?.username)
printHtmlPart(3)
}
printHtmlPart(4)
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
