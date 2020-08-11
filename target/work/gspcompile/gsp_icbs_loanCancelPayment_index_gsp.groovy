import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanCancelPayment_index_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanCancelPayment/_index.gsp" }
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
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',26,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',30,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Search value")],-1)
printHtmlPart(12)
invokeTag('submitButton','g',32,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(13)
})
invokeTag('form','g',37,[:],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',43,['property':("id"),'title':("Txn ID")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',44,['property':("loan.accountNo"),'title':("Loan Account")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',45,['property':("loan.customer.displayName"),'title':("Borrower's Name")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',46,['property':("txnFile.txnDate"),'title':("Transaction Date")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',47,['property':("txnFile.txnAmt"),'title':("Transaction Amt")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',48,['property':("txnRef"),'title':("Transaction Reference")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( txnLoanPaymentDetailsInstance in (txnLoanPaymentDetailsInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.acctNo)
printHtmlPart(20)
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
printHtmlPart(20)
invokeTag('formatDate','g',58,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance?.txnDate)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',59,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(19)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(19)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',61,['class':("btn btn-secondary"),'action':("reverseLoanPaymentTxn"),'id':(txnLoanPaymentDetailsInstance.id)],4)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',68,['total':(txnLoanPaymentDetailInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(26)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(27)
invokeTag('message','g',74,['code':("default.home.label")],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(29)
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
