import icbs.tellering.TxnBreakdown
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_transactionBreakdownindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/transactionBreakdown/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'transactionBreakdown.label', default: 'TxnBreakdown'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',21,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',23,['name':("search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',26,[:],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',32,['property':("debitAcct"),'title':(message(code: 'transactionBreakdown.debitAcct.label', default: 'Debit Acct'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',34,['property':("creditAcct"),'title':(message(code: 'transactionBreakdown.creditAcct.label', default: 'Credit Acct'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',36,['property':("debitAmt"),'title':(message(code: 'transactionBreakdown.debitAmt.label', default: 'Debit Amt'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',38,['property':("creditAmt"),'title':(message(code: 'transactionBreakdown.creditAmt.label', default: 'Credit Amt'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',40,['property':("txnDate"),'title':(message(code: 'transactionBreakdown.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(16)
invokeTag('message','g',42,['code':("transactionBreakdown.currency.label"),'default':("Currency")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( transactionBreakdownInstance in (transactionBreakdownInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: transactionBreakdownInstance, field: "debitAcct"))
})
invokeTag('link','g',50,['action':("show"),'id':(transactionBreakdownInstance.id)],4)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: transactionBreakdownInstance, field: "creditAcct"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: transactionBreakdownInstance, field: "debitAmt"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: transactionBreakdownInstance, field: "creditAmt"))
printHtmlPart(20)
invokeTag('formatDate','g',58,['date':(transactionBreakdownInstance.txnDate)],-1)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: transactionBreakdownInstance, field: "currency"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',68,['total':(TransactionBreakdownInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(24)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(25)
invokeTag('message','g',74,['code':("default.home.label")],-1)
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',75,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',75,['class':("create"),'action':("create")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(28)
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
