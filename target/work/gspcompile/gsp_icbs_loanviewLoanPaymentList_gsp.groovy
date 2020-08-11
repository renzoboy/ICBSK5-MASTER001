import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanviewLoanPaymentList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/viewLoanPaymentList.gsp" }
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
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('select','g',25,['name':("max"),'value':(params.max),'from':([5, 10, 15, 25]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(13)
invokeTag('textField','g',28,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Search by Particulars")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',30,['name':("id"),'id':("id"),'value':(loanInstance?.id)],-1)
printHtmlPart(15)
invokeTag('submitButton','g',31,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(16)
})
invokeTag('form','g',37,['url':([action:'viewLoanPaymentList',controller:'loan']),'method':("POST")],3)
printHtmlPart(17)
invokeTag('sortableColumn','g',44,['property':("txnFile"),'title':("Transaction ID")],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',46,['property':("txnRef"),'title':("Transaction Reference")],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',47,['property':("paymentAmt"),'title':("Transaction Amount")],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',48,['property':("txnDate"),'title':("Txn Date")],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',49,['property':("currency"),'title':("currency")],-1)
printHtmlPart(20)
loop:{
int i = 0
for( txnLoanPaymentDetailsInstance in (loanPayments) ) {
printHtmlPart(21)
if(true && (txnLoanPaymentDetailsInstance?.txnFile?.txnType?.id != 26 && txnLoanPaymentDetailsInstance?.txnFile?.txnType?.id != 27)) {
printHtmlPart(22)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(23)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.id)
printHtmlPart(24)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnFile?.txnDescription)
printHtmlPart(24)
expressionOut.print(txnLoanPaymentDetailsInstance?.txnRef)
printHtmlPart(25)
invokeTag('formatNumber','g',63,['format':("###,###,##0.00"),'number':(txnLoanPaymentDetailsInstance?.paymentAmt)],-1)
printHtmlPart(24)
invokeTag('formatDate','g',64,['format':("MM/dd/yyyy"),'date':(txnLoanPaymentDetailsInstance.txnDate)],-1)
printHtmlPart(24)
expressionOut.print(txnLoanPaymentDetailsInstance?.currency?.code)
printHtmlPart(26)
createClosureForHtmlPart(27, 5)
invokeTag('link','g',67,['class':("btn btn-info"),'action':("showLoanPaymentDetails"),'id':(txnLoanPaymentDetailsInstance?.id)],5)
printHtmlPart(28)
}
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',79,['controller':("home"),'action':("landing")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',80,['action':("show"),'controller':("loan"),'id':(params?.id)],3)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',81,['action':("printSchedule")],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',83,[:],1)
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
