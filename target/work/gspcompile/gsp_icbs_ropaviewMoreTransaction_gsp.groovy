import icbs.loans.ROPA
import icbs.loans.ROPALedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaviewMoreTransaction_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/viewMoreTransaction.gsp" }
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
expressionOut.print(createLink(uri: '/ropa'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(moretramnsactionInstance?.branch?.name)
printHtmlPart(9)
invokeTag('formatDate','g',27,['format':("MM/dd/yyyy"),'date':(moretramnsactionInstance?.ropaDate)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',31,['format':("###,###,##0.00"),'number':(moretramnsactionInstance?.loanBalance)],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',48,['property':("txnDate"),'title':(message(code: 'ROPALedger.txnDate.label', default: 'Ref Date'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',49,['property':("valueDate"),'title':(message(code: 'ROPALedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',50,['property':("reference"),'title':(message(code: 'ROPALedger.reference.date', default: 'References'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',51,['property':("particulars"),'title':(message(code: 'ROPALedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',52,['property':("debitAmt"),'title':(message(code: 'ROPALedger.debitAmt.label', default: 'Debit Amount'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',53,['property':("creditAmt"),'title':(message(code: 'ROPALedger.creditAmt.label', default: 'Credit Amount'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',54,['property':("balanceAmt"),'title':(message(code: 'ROPALedger.balanceAmt.label', default: 'Balance Amount'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( ropaLedgerInstance in (ROPALedger.findAllByRopa(moretramnsactionInstance)) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
invokeTag('formatDate','g',60,['format':("MM/dd/yyyy"),'date':(ropaLedgerInstance?.txnDate)],-1)
printHtmlPart(17)
invokeTag('formatDate','g',61,['format':("MM/dd/yyyy"),'date':(ropaLedgerInstance?.valueDate)],-1)
printHtmlPart(17)
expressionOut.print(ropaLedgerInstance?.reference)
printHtmlPart(17)
expressionOut.print(ropaLedgerInstance?.particulars)
printHtmlPart(18)
if(true && (ropaLedgerInstance?.debitAmt == 0)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
invokeTag('formatNumber','g',68,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.debitAmt)],-1)
printHtmlPart(18)
}
printHtmlPart(21)
if(true && (ropaLedgerInstance?.creditAmt == 0)) {
printHtmlPart(19)
}
else {
printHtmlPart(22)
invokeTag('formatNumber','g',74,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.creditAmt)],-1)
printHtmlPart(18)
}
printHtmlPart(22)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.balanceAmt)],-1)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',84,['total':(assetsHtmInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',114,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',117,['action':("index")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',118,['action':("show"),'id':(moretramnsactionInstance?.id)],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(32)
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
