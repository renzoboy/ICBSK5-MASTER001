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

class gsp_icbs_loanreversalSuccess_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reversalSuccess.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',16,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('textField','g',28,['name':("loanid"),'id':("loanid"),'value':(loanLedgerInstance?.loan?.id),'style':("display:none")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(loanLedgerInstance?.loan?.accountNo)
})
invokeTag('link','g',38,['action':("show"),'controller':("loan"),'id':(loanLedgerInstance?.loan?.id)],3)
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(loanLedgerInstance?.loan?.customer?.displayName)
})
invokeTag('link','g',42,['controller':("customer"),'action':("customerInquiry"),'id':(loanLedgerInstance?.loan?.customer?.id)],3)
printHtmlPart(14)
if(true && (loanLedgerInstance?.deposit)) {
printHtmlPart(15)
expressionOut.print(loanLedgerInstance?.deposit?.acctNo)
printHtmlPart(14)
}
printHtmlPart(16)
expressionOut.print(loanLedgerInstance?.txnFile?.id)
printHtmlPart(17)
expressionOut.print(loanLedgerInstance?.txnFile?.txnType?.description)
printHtmlPart(18)
expressionOut.print(loanLedgerInstance?.txnTemplate?.description)
printHtmlPart(19)
expressionOut.print(loanLedgerInstance?.txnFile?.txnRef)
printHtmlPart(20)
expressionOut.print(loanLedgerInstance?.txnFile?.txnParticulars)
printHtmlPart(21)
invokeTag('formatDate','g',72,['date':(loanLedgerInstance?.txnDate),'type':("date"),'style':("FULL")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(23)
if(true && (loanLedgerInstance?.principalDebit != 0)) {
printHtmlPart(24)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.principalDebit)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (loanLedgerInstance?.principalCredit != 0)) {
printHtmlPart(27)
invokeTag('formatNumber','g',95,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.principalCredit)],-1)
printHtmlPart(25)
}
printHtmlPart(28)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.principalBalance)],-1)
printHtmlPart(25)
if(true && (loanLedgerInstance?.interestDebit != 0)) {
printHtmlPart(29)
invokeTag('formatNumber','g',105,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.interestDebit)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (loanLedgerInstance?.interestCredit != 0)) {
printHtmlPart(30)
invokeTag('formatNumber','g',111,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.interestCredit)],-1)
printHtmlPart(25)
}
printHtmlPart(31)
invokeTag('formatNumber','g',116,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.interestBalance)],-1)
printHtmlPart(25)
if(true && (loanLedgerInstance?.penaltyDebit != 0)) {
printHtmlPart(32)
invokeTag('formatNumber','g',121,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.penaltyDebit)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (loanLedgerInstance?.penaltyCredit != 0)) {
printHtmlPart(33)
invokeTag('formatNumber','g',127,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.penaltyCredit)],-1)
printHtmlPart(25)
}
printHtmlPart(34)
invokeTag('formatNumber','g',132,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.penaltyBalance)],-1)
printHtmlPart(25)
if(true && (loanLedgerInstance?.chargesDebit != 0)) {
printHtmlPart(35)
invokeTag('formatNumber','g',137,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.chargesDebit)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (loanLedgerInstance?.chargesCredit != 0)) {
printHtmlPart(36)
invokeTag('formatNumber','g',143,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.chargesCredit)],-1)
printHtmlPart(25)
}
printHtmlPart(37)
invokeTag('formatNumber','g',148,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.chargesBalance)],-1)
printHtmlPart(38)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(loanLedgerInstance?.txnFile)) ) {
printHtmlPart(39)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(40)
expressionOut.print(t.debitAcct)
printHtmlPart(41)
if(true && (t.debitAcct)) {
printHtmlPart(42)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(43)
}
printHtmlPart(44)
invokeTag('formatNumber','g',173,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(45)
expressionOut.print(t.creditAcct)
printHtmlPart(41)
if(true && (t.creditAcct)) {
printHtmlPart(42)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(43)
}
printHtmlPart(44)
invokeTag('formatNumber','g',181,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(46)
i++
}
}
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',187,['tag':("main-content")],2)
printHtmlPart(48)
createTagBody(2, {->
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',190,['action':("viewLoanPaymentList"),'controller':("loan"),'id':(loanLedgerInstance?.loan?.id)],3)
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',190,['action':("show"),'controller':("loan"),'id':(loanLedgerInstance?.loan?.id)],3)
printHtmlPart(53)
})
invokeTag('captureContent','sitemesh',190,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',191,[:],1)
printHtmlPart(54)
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
