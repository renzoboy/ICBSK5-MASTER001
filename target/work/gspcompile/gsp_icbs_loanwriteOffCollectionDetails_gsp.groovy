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

class gsp_icbs_loanwriteOffCollectionDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/writeOffCollectionDetails.gsp" }
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
invokeTag('textField','g',28,['name':("loanid"),'id':("loanid"),'value':(collectionInstance?.loan?.id),'style':("display:none")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(collectionInstance?.loan?.accountNo)
})
invokeTag('link','g',38,['action':("show"),'controller':("loan"),'id':(collectionInstance?.loan?.id)],3)
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(collectionInstance?.loan?.customer?.displayName)
})
invokeTag('link','g',42,['controller':("customer"),'action':("customerInquiry"),'id':(collectionInstance?.loan?.customer?.id)],3)
printHtmlPart(14)
expressionOut.print(collectionInstance?.txnFile?.id)
printHtmlPart(15)
expressionOut.print(collectionInstance?.txnFile?.txnType?.description)
printHtmlPart(16)
expressionOut.print(collectionInstance?.txnFile?.txnTemplate?.code)
printHtmlPart(17)
expressionOut.print(collectionInstance?.txnFile?.txnRef)
printHtmlPart(18)
expressionOut.print(collectionInstance?.txnFile?.txnParticulars)
printHtmlPart(19)
invokeTag('formatDate','g',67,['date':(collectionInstance?.txnDate),'type':("date"),'style':("FULL")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',72,['format':("###,###,##0.00"),'number':(collectionInstance?.txnAmount)],-1)
printHtmlPart(21)
expressionOut.print(collectionInstance?.collectedBy?.name1)
printHtmlPart(22)
expressionOut.print(collectionInstance?.collectedBy?.name2)
printHtmlPart(22)
expressionOut.print(collectionInstance?.collectedBy?.name3)
printHtmlPart(23)
expressionOut.print(collectionInstance?.transactBy?.name1)
printHtmlPart(22)
expressionOut.print(collectionInstance?.transactBy?.name2)
printHtmlPart(22)
expressionOut.print(collectionInstance?.transactBy?.name3)
printHtmlPart(24)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(collectionInstance?.txnFile)) ) {
printHtmlPart(25)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(26)
expressionOut.print(t.debitAcct)
printHtmlPart(27)
if(true && (t.debitAcct)) {
printHtmlPart(28)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(27)
}
printHtmlPart(29)
invokeTag('formatNumber','g',106,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(30)
expressionOut.print(t.creditAcct)
printHtmlPart(27)
if(true && (t.creditAcct)) {
printHtmlPart(28)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(27)
}
printHtmlPart(29)
invokeTag('formatNumber','g',114,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',126,['action':("loanWriteOffCollectionList"),'controller':("loan"),'id':(collectionInstance?.loan.id)],3)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',127,['action':("show"),'controller':("loan"),'id':(collectionInstance?.loan.id)],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',129,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',130,[:],1)
printHtmlPart(39)
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
