import icbs.loans.LoanLedger
import icbs.loans.ROPA
import icbs.loans.RopaSaleDetails
import icbs.loans.RopaTransfer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_transactions_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/transactions/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
for( ropaTransferInstance in (RopaTransfer.findAllByRopa(ropapapapaInstance).sort{it.id}) ) {
printHtmlPart(2)
for( loanLedgerInstance in (LoanLedger.findAllByLoan(ropaTransferInstance?.loan).sort{it.id}) ) {
printHtmlPart(3)
if(true && (loanLedgerInstance?.txnFile?.txnType?.id == 38)) {
printHtmlPart(4)
expressionOut.print(loanLedgerInstance?.id)
printHtmlPart(5)
expressionOut.print(loanLedgerInstance?.txnFile?.loanAcct?.accountNo)
printHtmlPart(5)
expressionOut.print(loanLedgerInstance?.txnFile?.loanAcct?.customer?.displayName)
printHtmlPart(5)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(loanLedgerInstance?.txnDate)],-1)
printHtmlPart(5)
expressionOut.print(loanLedgerInstance?.txnFile?.txnType?.description)
printHtmlPart(5)
expressionOut.print(loanLedgerInstance?.txnFile?.txnCode)
printHtmlPart(5)
expressionOut.print(loanLedgerInstance?.txnRef)
printHtmlPart(5)
expressionOut.print(loanLedgerInstance?.txnParticulars)
printHtmlPart(6)
createClosureForHtmlPart(7, 4)
invokeTag('link','g',35,['class':("btn btn-secondary"),'controller':("loanAdjustment"),'action':("show"),'id':(loanLedgerInstance?.id)],4)
printHtmlPart(8)
}
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(11)
for( ropaSaleInstance in (RopaSaleDetails.findAllByRopa(ropapapapaInstance).sort{it.id}) ) {
printHtmlPart(2)
if(true && (ropaSaleInstance?.txnFile?.txnType?.id == 66)) {
printHtmlPart(12)
expressionOut.print(ropaSaleInstance?.id)
printHtmlPart(13)
invokeTag('formatDate','g',64,['format':("MM/dd/yyyy"),'date':(ropaSaleInstance?.txnFile?.txnDate)],-1)
printHtmlPart(14)
expressionOut.print(ropaSaleInstance?.txnFile?.txnType?.description)
printHtmlPart(13)
expressionOut.print(ropaSaleInstance?.txnFile?.txnCode)
printHtmlPart(14)
expressionOut.print(ropaSaleInstance?.txnFile?.txnRef)
printHtmlPart(13)
expressionOut.print(ropaSaleInstance?.txnFile?.txnParticulars)
printHtmlPart(15)
createClosureForHtmlPart(7, 3)
invokeTag('link','g',69,['class':("btn btn-secondary"),'controller':("tellering"),'action':("showGlEntries"),'id':(ropaSaleInstance?.txnFile?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
}
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
