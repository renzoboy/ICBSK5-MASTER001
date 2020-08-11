import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositviewTxnDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/viewTxnDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(txnFileInstance?.id)
printHtmlPart(6)
expressionOut.print(txnFileInstance?.txnTemplate?.description)
printHtmlPart(7)
expressionOut.print(txnFileInstance?.branch?.name)
printHtmlPart(8)
expressionOut.print(txnFileInstance?.acctNo)
printHtmlPart(9)
if(true && (depAcct)) {
printHtmlPart(10)
expressionOut.print(txnFileInstance?.depAcct?.customer?.displayName)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (loanAcct)) {
printHtmlPart(10)
expressionOut.print(txnFileInstance?.loanAcct?.customer?.displayName)
printHtmlPart(11)
}
printHtmlPart(13)
invokeTag('formatNumber','g',49,['number':(txnFileInstance?.txnAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',53,['date':(txnFileInstance.txnDate),'format':("MM-dd-yyyy")],-1)
printHtmlPart(15)
expressionOut.print(txnFileInstance?.txnRef)
printHtmlPart(16)
expressionOut.print(txnFileInstance?.txnDescription)
printHtmlPart(17)
expressionOut.print(txnFileInstance?.txnParticulars)
printHtmlPart(18)
expressionOut.print(txnFileInstance?.txnTimestamp)
printHtmlPart(19)
expressionOut.print(txnFileInstance?.user?.username)
printHtmlPart(20)
loop:{
int i = 0
for( gl in (glEntries) ) {
printHtmlPart(21)
if(true && (gl?.debitAcct)) {
printHtmlPart(22)
expressionOut.print(gl?.debitAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.debitAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('formatNumber','g',98,['number':(gl.debitAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(25)
if(true && (gl?.creditAcct)) {
printHtmlPart(22)
expressionOut.print(gl?.creditAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.creditAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(23)
}
printHtmlPart(26)
invokeTag('formatNumber','g',104,['number':(gl.creditAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',111,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',114,['action':("depositInquiry"),'id':(txnFileInstance?.depAcct?.id)],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',115,['action':("viewTellerBalancing"),'id':(txnFileInstance.id)],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',117,['tag':("main-actions")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',118,[:],1)
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
