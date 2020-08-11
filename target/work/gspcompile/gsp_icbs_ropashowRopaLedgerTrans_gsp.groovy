import icbs.loans.LoanLedger
import icbs.tellering.TxnBreakdown
import icbs.gl.GlAccount
import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropashowRopaLedgerTrans_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/showRopaLedgerTrans.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('captureContent','sitemesh',18,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(ropaLedgerInstance?.txnFile)) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
expressionOut.print(t.debitAcct)
printHtmlPart(15)
if(true && (t.debitAcct)) {
printHtmlPart(16)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatNumber','g',47,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(19)
expressionOut.print(t.creditAcct)
printHtmlPart(15)
if(true && (t.creditAcct)) {
printHtmlPart(16)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',65,['action':("index")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(26)
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
