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

class gsp_icbs_loanAdjustmentshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanAdjustment/show.gsp" }
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
printHtmlPart(3)
if(true && (loanLedgerInstance?.loan?.product?.productType?.id == 6)) {
printHtmlPart(4)
createTagBody(3, {->
createClosureForHtmlPart(5, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(6)
}
printHtmlPart(3)
if(true && (loanLedgerInstance?.loan?.product?.productType?.id == 7)) {
printHtmlPart(4)
createTagBody(3, {->
createClosureForHtmlPart(7, 4)
invokeTag('captureTitle','sitemesh',14,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],3)
printHtmlPart(6)
}
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',20,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('textField','g',33,['name':("loanid"),'id':("loanid"),'value':(loanLedgerInstance?.loan?.id),'style':("display:none")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(loanLedgerInstance?.loan?.accountNo)
})
invokeTag('link','g',41,['action':("show"),'controller':("loan"),'id':(loanLedgerInstance?.loan?.id)],3)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(loanLedgerInstance?.loan?.customer?.displayName)
})
invokeTag('link','g',45,['controller':("customer"),'action':("customerInquiry"),'id':(loanLedgerInstance?.loan?.customer?.id)],3)
printHtmlPart(17)
if(true && (loanLedgerInstance?.deposit)) {
printHtmlPart(18)
expressionOut.print(loanLedgerInstance?.deposit?.acctNo)
printHtmlPart(17)
}
printHtmlPart(19)
expressionOut.print(loanLedgerInstance?.txnFile?.id)
printHtmlPart(20)
expressionOut.print(loanLedgerInstance?.txnType?.description)
printHtmlPart(21)
expressionOut.print(loanLedgerInstance?.txnTemplate?.description)
printHtmlPart(22)
expressionOut.print(loanLedgerInstance?.txnRef)
printHtmlPart(23)
expressionOut.print(loanLedgerInstance?.txnParticulars)
printHtmlPart(24)
invokeTag('formatDate','g',75,['date':(loanLedgerInstance?.txnDate),'type':("date"),'style':("FULL")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',79,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(26)
if(true && (loanLedgerInstance?.principalDebit != 0)) {
printHtmlPart(27)
invokeTag('formatNumber','g',91,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.principalDebit)],-1)
printHtmlPart(17)
}
printHtmlPart(28)
if(true && (loanLedgerInstance?.principalCredit != 0)) {
printHtmlPart(29)
invokeTag('formatNumber','g',97,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.principalCredit)],-1)
printHtmlPart(17)
}
printHtmlPart(30)
invokeTag('formatNumber','g',102,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.principalBalance)],-1)
printHtmlPart(17)
if(true && (loanLedgerInstance?.interestDebit != 0)) {
printHtmlPart(31)
invokeTag('formatNumber','g',107,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.interestDebit)],-1)
printHtmlPart(17)
}
printHtmlPart(28)
if(true && (loanLedgerInstance?.interestCredit != 0)) {
printHtmlPart(32)
invokeTag('formatNumber','g',113,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.interestCredit)],-1)
printHtmlPart(17)
}
printHtmlPart(33)
invokeTag('formatNumber','g',118,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.interestBalance)],-1)
printHtmlPart(17)
if(true && (loanLedgerInstance?.penaltyDebit != 0)) {
printHtmlPart(34)
invokeTag('formatNumber','g',123,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.penaltyDebit)],-1)
printHtmlPart(17)
}
printHtmlPart(28)
if(true && (loanLedgerInstance?.penaltyCredit != 0)) {
printHtmlPart(35)
invokeTag('formatNumber','g',129,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.penaltyCredit)],-1)
printHtmlPart(17)
}
printHtmlPart(36)
invokeTag('formatNumber','g',134,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.penaltyBalance)],-1)
printHtmlPart(17)
if(true && (loanLedgerInstance?.chargesDebit != 0)) {
printHtmlPart(37)
invokeTag('formatNumber','g',139,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.chargesDebit)],-1)
printHtmlPart(17)
}
printHtmlPart(28)
if(true && (loanLedgerInstance?.chargesCredit != 0)) {
printHtmlPart(38)
invokeTag('formatNumber','g',145,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.chargesCredit)],-1)
printHtmlPart(17)
}
printHtmlPart(39)
invokeTag('formatNumber','g',150,['format':("###,###,##0.00"),'number':(loanLedgerInstance?.chargesBalance)],-1)
printHtmlPart(40)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(loanLedgerInstance?.txnFile)) ) {
printHtmlPart(41)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(42)
expressionOut.print(t.debitAcct)
printHtmlPart(43)
if(true && (t.debitAcct)) {
printHtmlPart(44)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(45)
}
printHtmlPart(46)
invokeTag('formatNumber','g',174,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(47)
expressionOut.print(t.creditAcct)
printHtmlPart(43)
if(true && (t.creditAcct)) {
printHtmlPart(44)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(45)
}
printHtmlPart(46)
invokeTag('formatNumber','g',182,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(48)
i++
}
}
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',188,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(50)
createClosureForHtmlPart(51, 3)
invokeTag('link','g',190,['action':("create")],3)
printHtmlPart(52)
createClosureForHtmlPart(53, 3)
invokeTag('link','g',191,['action':("index")],3)
printHtmlPart(54)
createClosureForHtmlPart(55, 3)
invokeTag('link','g',191,['target':("_blank"),'controller':("loanAdjustment"),'action':("printValidation")],3)
printHtmlPart(56)
createClosureForHtmlPart(57, 3)
invokeTag('link','g',192,['action':("index")],3)
printHtmlPart(58)
})
invokeTag('captureContent','sitemesh',194,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',196,[:],1)
printHtmlPart(59)
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
