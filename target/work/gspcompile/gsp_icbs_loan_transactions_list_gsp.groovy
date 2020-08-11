import icbs.loans.LoanLedger
import icbs.loans.LoanWriteOffCollectionHist
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_transactions_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/transactions/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
for( loanLedgerInstance in (LoanLedger.findAllByLoan(loanInstance).sort{it.id}) ) {
printHtmlPart(2)
expressionOut.print(loanLedgerInstance?.id)
printHtmlPart(3)
invokeTag('formatDate','g',22,['format':("MM/dd/yyyy"),'date':(loanLedgerInstance?.txnDate)],-1)
printHtmlPart(4)
expressionOut.print(loanLedgerInstance?.txnType?.description)
printHtmlPart(4)
expressionOut.print(loanLedgerInstance?.txnTemplate?.description)
printHtmlPart(4)
expressionOut.print(loanLedgerInstance?.txnRef)
printHtmlPart(3)
expressionOut.print(loanLedgerInstance?.txnParticulars)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',27,['class':("btn btn-secondary"),'controller':("loanAdjustment"),'action':("show"),'id':(loanLedgerInstance?.id)],2)
printHtmlPart(7)
}
printHtmlPart(8)
for( writeOffInstancehist in (LoanWriteOffCollectionHist.findAllByLoan(loanInstance).sort{it.id}) ) {
printHtmlPart(9)
invokeTag('formatDate','g',50,['format':("MM/dd/yyyy"),'date':(writeOffInstancehist?.txnDate)],-1)
printHtmlPart(4)
expressionOut.print(writeOffInstancehist?.txnDescription)
printHtmlPart(3)
expressionOut.print(writeOffInstancehist?.transactBy?.name1 +' '+writeOffInstancehist?.transactBy?.name2 +' '+writeOffInstancehist?.transactBy?.name3)
printHtmlPart(3)
expressionOut.print(writeOffInstancehist?.collectedBy?.name1 +' '+writeOffInstancehist?.collectedBy?.name2 +' '+writeOffInstancehist?.collectedBy?.name3)
printHtmlPart(4)
invokeTag('formatNumber','g',54,['format':("###,##0.00"),'number':(writeOffInstancehist?.txnAmount)],-1)
printHtmlPart(7)
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
