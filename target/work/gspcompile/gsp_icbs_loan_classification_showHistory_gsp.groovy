import icbs.loans.LoanLossProvisionDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_classification_showHistory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/classification/_showHistory.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(loanInstance?.loanKindOfLoan?.description)
printHtmlPart(1)
expressionOut.print(loanInstance?.loanType?.description)
printHtmlPart(2)
expressionOut.print(loanInstance?.loanProject?.description)
printHtmlPart(3)
expressionOut.print(loanInstance?.ageInArrears)
printHtmlPart(4)
expressionOut.print(loanInstance?.loanProvisionBsp?.description)
printHtmlPart(5)
expressionOut.print(loanInstance?.loanProvision?.description)
printHtmlPart(6)
expressionOut.print(loanInstance?.loanPerformanceId?.description)
printHtmlPart(7)
expressionOut.print(loanInstance?.loanSecurity?.description)
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(loanInstance?.glLink?.description)
})
invokeTag('link','g',43,['controller':("cfgAcctGlTemplate"),'action':("show"),'id':(loanInstance?.glLink?.id)],1)
printHtmlPart(9)
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
