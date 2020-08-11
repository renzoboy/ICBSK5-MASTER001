import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanCancelPaymentindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanCancelPayment/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'TxnLoanPaymentDetails.label', default: 'Loan Payments'))],-1)
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
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',27,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',29,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',31,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("id"),'title':("Txn ID")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("loan.accountNo"),'title':("Loan Account")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("loan.customer.displayName"),'title':("Borrower's Name")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("txnFile.txnDate"),'title':("Transaction Date")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',41,['property':("txnFile.txnAmt"),'title':("Transaction Amt")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',42,['property':("txnRef"),'title':("Transaction Reference")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( txnLoanPaymentDetailsInstance in (txnLoanPaymentDetailsInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(20)
expressionOut.print(txnLoanPaymentDetailsInstance?.acctNo)
printHtmlPart(21)
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
printHtmlPart(21)
invokeTag('formatDate','g',52,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance?.txnDate)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(20)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(20)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',55,['class':("btn btn-secondary"),'action':("reverseLoanPaymentTxn"),'id':(txnLoanPaymentDetailsInstance.id)],4)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',62,['total':(TxnLoanPaymentDetailsInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',65,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',68,['class':("create"),'action':("create")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(31)
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
