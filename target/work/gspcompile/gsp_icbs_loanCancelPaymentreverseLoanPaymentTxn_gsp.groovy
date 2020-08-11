import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanCancelPaymentreverseLoanPaymentTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanCancelPayment/reverseLoanPaymentTxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'txnLoanPaymentDetails.label', default: 'txnLoanPaymentDetails'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.accountNo)
})
invokeTag('link','g',33,['action':("show"),'controller':("loan"),'id':(txnLoanPaymentDetailsInstance?.acct?.id)],3)
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(txnLoanPaymentDetailsInstance?.acct?.customer?.displayName)
})
invokeTag('link','g',37,['controller':("customer"),'action':("customerInquiry"),'id':(txnLoanPaymentDetailsInstance?.acct?.customer?.id)],3)
printHtmlPart(12)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(13)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(14)
invokeTag('formatDate','g',49,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance?.txnDate)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.txnFile?.txnAmt)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',57,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.principalAmt)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',61,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.interestAmt)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',65,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.penaltyAmt)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',69,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.serviceChargeAmt)],-1)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(3, 3)
invokeTag('link','g',78,['action':("create")],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',79,['action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-actions")],2)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(25)
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
