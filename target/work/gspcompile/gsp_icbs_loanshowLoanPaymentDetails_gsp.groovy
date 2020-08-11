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

class gsp_icbs_loanshowLoanPaymentDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/showLoanPaymentDetails.gsp" }
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
else {
printHtmlPart(11)
if(true && (loanReversalHist)) {
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('textField','g',39,['name':("loanid"),'id':("loanid"),'value':(loanLedgerInstance?.loan?.id),'style':("display:none")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.accountNo)
})
invokeTag('link','g',50,['action':("show"),'controller':("loan"),'id':(txnLoanPaymentDetailsInstance?.acct?.id)],3)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
})
invokeTag('link','g',54,['controller':("customer"),'action':("customerInquiry"),'id':(txnLoanPaymentDetailsInstance?.acct?.customer?.id)],3)
printHtmlPart(17)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(18)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.txnType?.description)
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.txnTemplate?.description)
printHtmlPart(20)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(21)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.txnParticulars)
printHtmlPart(22)
invokeTag('formatDate','g',79,['date':(txnLoanPaymentDetailsInstance?.txnDate),'type':("date"),'style':("FULL")],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',83,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(24)
if(true && (loanLedgerDetails?.principalDebit != 0)) {
printHtmlPart(25)
invokeTag('formatNumber','g',96,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.principalDebit)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (loanLedgerDetails?.principalCredit != 0)) {
printHtmlPart(28)
invokeTag('formatNumber','g',102,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.principalCredit)],-1)
printHtmlPart(26)
}
printHtmlPart(29)
invokeTag('formatNumber','g',107,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.principalBalance)],-1)
printHtmlPart(26)
if(true && (loanLedgerDetails?.interestDebit != 0)) {
printHtmlPart(30)
invokeTag('formatNumber','g',112,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.interestDebit)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (loanLedgerDetails?.interestCredit != 0)) {
printHtmlPart(31)
invokeTag('formatNumber','g',118,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.interestCredit)],-1)
printHtmlPart(26)
}
printHtmlPart(32)
invokeTag('formatNumber','g',123,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.interestBalance)],-1)
printHtmlPart(26)
if(true && (loanLedgerDetails?.penaltyDebit != 0)) {
printHtmlPart(33)
invokeTag('formatNumber','g',128,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.penaltyDebit)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (loanLedgerDetails?.penaltyCredit != 0)) {
printHtmlPart(34)
invokeTag('formatNumber','g',134,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.penaltyCredit)],-1)
printHtmlPart(26)
}
printHtmlPart(35)
invokeTag('formatNumber','g',139,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.penaltyBalance)],-1)
printHtmlPart(26)
if(true && (loanLedgerDetails?.chargesDebit != 0)) {
printHtmlPart(36)
invokeTag('formatNumber','g',144,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.chargesDebit)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (loanLedgerDetails?.chargesCredit != 0)) {
printHtmlPart(37)
invokeTag('formatNumber','g',150,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.chargesCredit)],-1)
printHtmlPart(26)
}
printHtmlPart(38)
invokeTag('formatNumber','g',155,['format':("###,###,##0.00"),'number':(loanLedgerDetails?.chargesBalance)],-1)
printHtmlPart(39)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(txnLoanPaymentDetailsInstance?.txnFile)) ) {
printHtmlPart(40)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(41)
expressionOut.print(t.debitAcct)
printHtmlPart(42)
if(true && (t.debitAcct)) {
printHtmlPart(43)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(42)
}
printHtmlPart(44)
invokeTag('formatNumber','g',180,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(45)
expressionOut.print(t.creditAcct)
printHtmlPart(42)
if(true && (t.creditAcct)) {
printHtmlPart(43)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(42)
}
printHtmlPart(44)
invokeTag('formatNumber','g',188,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(46)
i++
}
}
printHtmlPart(47)
if(true && (loanReversalHist)) {
printHtmlPart(48)
}
else {
printHtmlPart(49)
createTagBody(4, {->
printHtmlPart(50)
invokeTag('field','g',209,['class':("form-control"),'type':("Text"),'id':("txtReference"),'name':("txtReference"),'value':("")],-1)
printHtmlPart(51)
invokeTag('hiddenField','g',212,['name':("loanPaymentDetailId"),'id':("loanPaymentDetailId"),'value':(txnLoanPaymentDetailsInstance?.id)],-1)
printHtmlPart(52)
invokeTag('textArea','g',216,['name':("txtParticulars"),'id':("txtParticulars"),'value':(""),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(53)
})
invokeTag('form','g',220,['id':("loanReverseForm"),'url':([controller: 'loan', action:'loanReversePayment']),'method':("POST"),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(54)
}
printHtmlPart(55)
})
invokeTag('captureContent','sitemesh',251,['tag':("main-content")],2)
printHtmlPart(56)
createTagBody(2, {->
printHtmlPart(57)
if(true && (loanReversalHist)) {
printHtmlPart(58)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
createClosureForHtmlPart(61, 3)
invokeTag('link','g',262,['action':("viewLoanPaymentList"),'controller':("loan"),'id':(txnLoanPaymentDetailsInstance?.acct?.id)],3)
printHtmlPart(62)
createClosureForHtmlPart(63, 3)
invokeTag('link','g',263,['action':("show"),'controller':("loan"),'id':(txnLoanPaymentDetailsInstance?.acct?.id)],3)
printHtmlPart(64)
})
invokeTag('captureContent','sitemesh',266,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',267,[:],1)
printHtmlPart(65)
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
