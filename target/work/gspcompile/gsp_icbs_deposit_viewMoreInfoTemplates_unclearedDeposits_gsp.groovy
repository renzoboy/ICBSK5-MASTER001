import icbs.tellering.TxnCOCI
import icbs.lov.CheckStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_viewMoreInfoTemplates_unclearedDeposits_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/viewMoreInfoTemplates/_unclearedDeposits.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
if(true && (flash.message)) {
printHtmlPart(1)
expressionOut.print(flash.message)
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('sortableColumn','g',13,['property':("bank"),'title':(message(code: 'TxnCOCI.bank.label', default: 'Clearing Bank'))],-1)
printHtmlPart(4)
invokeTag('sortableColumn','g',14,['property':("checkNo"),'title':(message(code: 'TxnCOCI.checkNo.label', default: 'Check Number'))],-1)
printHtmlPart(4)
invokeTag('sortableColumn','g',15,['property':("checkAcctName"),'title':(message(code: 'TxnCOCI.checkAcctName.label', default: 'Check Account Name'))],-1)
printHtmlPart(4)
invokeTag('sortableColumn','g',16,['property':("checkAmt"),'title':(message(code: 'TxnCOCI.checkAmt.label', default: 'Check Amount'))],-1)
printHtmlPart(4)
invokeTag('sortableColumn','g',17,['property':("clearingDate"),'title':(message(code: 'TxnCOCI.clearingDate.label', default: 'Clearing Date'))],-1)
printHtmlPart(4)
invokeTag('sortableColumn','g',18,['property':("checkStatus"),'title':(message(code: 'TxnCOCI.clearingDate.label', default: 'Check Status'))],-1)
printHtmlPart(5)
loop:{
int i = 0
for( txnCociInstance in (TxnCOCI.findAllByDepAcctAndCheckStatusNotEqual(depositInstance,icbs.lov.CheckStatus.get(5),[sort: "id", order: "asc"])) ) {
printHtmlPart(6)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(7)
expressionOut.print(txnCociInstance?.bank?.name)
printHtmlPart(8)
expressionOut.print(txnCociInstance?.checkNo)
printHtmlPart(8)
expressionOut.print(txnCociInstance?.checkAcctName)
printHtmlPart(9)
invokeTag('formatNumber','g',28,['format':("###,###,##0.00"),'number':(txnCociInstance?.checkAmt)],-1)
printHtmlPart(8)
invokeTag('formatDate','g',29,['format':("MM/dd/yyyy"),'date':(txnCociInstance?.clearingDate)],-1)
printHtmlPart(8)
expressionOut.print(txnCociInstance?.checkStatus.description)
printHtmlPart(8)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',31,['class':("btn btn-secondary"),'action':("viewUnclearedDeposit"),'id':(txnCociInstance.id)],2)
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
invokeTag('paginate','g',37,['total':(txnCociInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(13)
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
