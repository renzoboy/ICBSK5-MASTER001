import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanloanWriteOffCollectionList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanWriteOffCollectionList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('sortableColumn','g',25,['property':("branch"),'title':(message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Branch'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',27,['property':("loan.accountNo"),'title':(message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Loan Account No '))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',29,['property':("currency"),'title':(message(code: 'SssOnlinePaymentDetail.ername.label', default: 'Currency'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',32,['property':("txnDescription"),'title':(message(code: 'SssOnlinePaymentDetail.indiEename.label', default: 'txnDescription'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',35,['property':("txnAmount"),'title':(message(code: 'SssOnlinePaymentDetail.amount.label', default: 'Collection Amount'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',36,['property':("txnDate"),'title':(message(code: 'SssOnlinePaymentDetail.amount.label', default: 'Collection Date'))],-1)
printHtmlPart(10)
loop:{
int i = 0
for( writeOffCollectionInstance in (loanWriteOffCollectionInstance) ) {
printHtmlPart(11)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(12)
expressionOut.print(writeOffCollectionInstance?.branch?.name)
printHtmlPart(13)
expressionOut.print(writeOffCollectionInstance?.loan.accountNo)
printHtmlPart(13)
expressionOut.print(writeOffCollectionInstance?.currency?.name)
printHtmlPart(13)
expressionOut.print(writeOffCollectionInstance.txnDescription)
printHtmlPart(13)
invokeTag('formatNumber','g',41,['format':("###,###,##0.00"),'number':(writeOffCollectionInstance?.txnAmount)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy"),'date':(writeOffCollectionInstance?.txnDate)],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',47,['class':("btn btn-secondary"),'action':("writeOffCollectionDetails"),'controller':("loan"),'id':(writeOffCollectionInstance.id)],4)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',50,['total':(loanWriteOffCollectionInstance ?: 0),'params':(params)],-1)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',50,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',52,['action':("show"),'controller':("loan"),'id':(loanWriteOffCollectionInstance?.loan.id)],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-actions")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',53,[:],1)
printHtmlPart(22)
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
