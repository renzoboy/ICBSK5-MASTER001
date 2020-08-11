import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_history_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/history/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( loanHistoryInstance in (loanHistoryList) ) {
printHtmlPart(1)
invokeTag('formatDate','g',21,['format':("MM/dd/yyyy"),'date':(loanHistoryInstance?.dateModified)],-1)
printHtmlPart(2)
expressionOut.print(loanHistoryInstance?.activity)
printHtmlPart(2)
expressionOut.print(loanHistoryInstance?.product?.name)
printHtmlPart(3)
invokeTag('formatNumber','g',27,['format':("###,##0.00"),'number':(loanHistoryInstance.grantedAmount)],-1)
printHtmlPart(2)
expressionOut.print(loanHistoryInstance?.loanPerformanceId)
printHtmlPart(4)
expressionOut.print(loanHistoryInstance?.interestRate)
printHtmlPart(4)
invokeTag('formatDate','g',33,['format':("MM/dd/yyyy"),'date':(loanHistoryInstance?.openingDate)],-1)
printHtmlPart(2)
invokeTag('formatDate','g',35,['format':("MM/dd/yyyy"),'date':(loanHistoryInstance?.maturityDate)],-1)
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',37,['class':("btn btn-secondary"),'controller':("loan"),'action':("showHistory"),'params':([id:loanInstance.id, history:loanHistoryInstance.id])],2)
printHtmlPart(6)
i++
}
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
