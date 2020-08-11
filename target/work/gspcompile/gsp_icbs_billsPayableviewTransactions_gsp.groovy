import icbs.gl.BillsPayable
import icbs.gl.BillsPayableLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayableviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/viewTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/billsPayable'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(9)
expressionOut.print(billsPayableInstance?.glContra)
printHtmlPart(10)
expressionOut.print(billsPayableInstance?.branch?.name)
printHtmlPart(11)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(12)
invokeTag('formatDate','g',31,['format':("MM/dd/yyyy"),'date':(billsPayableInstance?.dateOpened)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',35,['format':("###,###,##0.00"),'number':(billsPayableInstance?.principal)],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',49,['property':("refDate"),'title':(message(code: 'billsPayableLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',50,['property':("valueDate"),'title':(message(code: 'billsPayableLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',51,['property':("reference"),'title':(message(code: 'billsPayableLedger.reference.date', default: 'References'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',52,['property':("particulars"),'title':(message(code: 'billsPayableLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',53,['property':("debit"),'title':(message(code: 'billsPayableLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',54,['property':("credit"),'title':(message(code: 'billsPayableLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',55,['property':("balance"),'title':(message(code: 'billsPayableLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( billsPayableLedgerInstance in (BillsPayableLedger.findAllByBillsPayable(billsPayableInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
invokeTag('formatDate','g',61,['format':("MM/dd/yyyy"),'date':(billsPayableLedgerInstance?.refDate)],-1)
printHtmlPart(20)
invokeTag('formatDate','g',62,['format':("MM/dd/yyyy"),'date':(billsPayableLedgerInstance?.valueDate)],-1)
printHtmlPart(20)
expressionOut.print(billsPayableLedgerInstance?.reference)
printHtmlPart(20)
expressionOut.print(billsPayableLedgerInstance?.particulars)
printHtmlPart(21)
if(true && (billsPayableLedgerInstance?.debit == 0)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
invokeTag('formatNumber','g',69,['format':("###,###,##0.00"),'number':(billsPayableLedgerInstance?.debit)],-1)
printHtmlPart(21)
}
printHtmlPart(24)
if(true && (billsPayableLedgerInstance?.credit == 0)) {
printHtmlPart(22)
}
else {
printHtmlPart(25)
invokeTag('formatNumber','g',75,['format':("###,###,##0.00"),'number':(billsPayableLedgerInstance?.credit)],-1)
printHtmlPart(21)
}
printHtmlPart(25)
invokeTag('formatNumber','g',77,['format':("###,###,##0.00"),'number':(billsPayableLedgerInstance?.balance)],-1)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',86,['total':(billsPayableLedgerInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',92,['action':("edit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',93,['action':("show"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(32)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',94,['action':("index"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',96,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',97,[:],1)
printHtmlPart(36)
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
