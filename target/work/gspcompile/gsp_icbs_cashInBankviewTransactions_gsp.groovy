import icbs.gl.CashInBank
import icbs.gl.CashInBankCheckbook
import icbs.gl.CashInBankLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/viewTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('render','g',17,['template':("cashInBankDetails")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',28,['property':("txnDate"),'title':(message(code: 'cashInBankLedger.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',29,['property':("valueDate"),'title':(message(code: 'cashInBankLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',30,['property':("reference"),'title':(message(code: 'cashInBankLedger.reference.date', default: 'References'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',31,['property':("particulars"),'title':(message(code: 'cashInBankLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',32,['property':("debitAmt"),'title':(message(code: 'cashInBankLedger.debitAmt.label', default: 'Debit Amount'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',33,['property':("creditAmt"),'title':(message(code: 'cashInBankLedger.creditAmt.label', default: 'Credit Amount'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',34,['property':("balanceAmt"),'title':(message(code: 'cashInBankLedger.balanceAmt.label', default: 'Balance Amount'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',35,['property':("checkbook"),'title':(message(code: 'cashInBankLedger.checkbook.label', default: 'Check Number'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( cashInBankLedgerInstance in (CashInBankLedger.findAllByCashInBank(cashInBankInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
invokeTag('formatDate','g',41,['format':("MM/dd/yyyy"),'date':(cashInBankLedgerInstance?.txnDate)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',42,['format':("MM/dd/yyyy"),'date':(cashInBankLedgerInstance?.valueDate)],-1)
printHtmlPart(15)
expressionOut.print(cashInBankLedgerInstance?.reference)
printHtmlPart(15)
expressionOut.print(cashInBankLedgerInstance?.particulars)
printHtmlPart(16)
if(true && (cashInBankLedgerInstance?.debitAmt == 0)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
invokeTag('formatNumber','g',49,['format':("###,###,##0.00"),'number':(cashInBankLedgerInstance?.debitAmt)],-1)
printHtmlPart(16)
}
printHtmlPart(19)
if(true && (cashInBankLedgerInstance?.creditAmt == 0)) {
printHtmlPart(17)
}
else {
printHtmlPart(20)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(cashInBankLedgerInstance?.creditAmt)],-1)
printHtmlPart(16)
}
printHtmlPart(20)
invokeTag('formatNumber','g',57,['format':("###,###,##0.00"),'number':(cashInBankLedgerInstance?.balanceAmt)],-1)
printHtmlPart(16)
if(true && (cashInBankLedgerInstance?.checkbook)) {
printHtmlPart(21)
if(true && (CashInBankCheckbook.findByTxnFile(cashInBankLedgerInstance?.txnFile))) {
printHtmlPart(22)
createTagBody(6, {->
expressionOut.print(cashInBankLedgerInstance?.checkbook.checkNo)
})
invokeTag('link','g',61,['class':("btn btn-secondary"),'action':("chkDetails"),'controller':("cashInBank"),'id':(cashInBankLedgerInstance?.checkbook?.id)],6)
printHtmlPart(23)
createClosureForHtmlPart(24, 6)
invokeTag('link','g',62,['class':("btn btn-secondary"),'action':("cancelChk"),'controller':("cashInBank"),'id':(cashInBankLedgerInstance?.checkbook?.id)],6)
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
invokeTag('paginate','g',80,['total':(CashInBankInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',86,['action':("show"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',87,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',89,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(38)
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
