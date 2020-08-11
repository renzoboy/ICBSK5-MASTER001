import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingshowGlEntries_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/showGlEntries.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',16,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(txnFileInstance?.id)
printHtmlPart(7)
expressionOut.print(txnFileInstance?.txnTemplate?.description)
printHtmlPart(8)
invokeTag('formatNumber','g',33,['number':(txnFileInstance?.txnAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(9)
expressionOut.print(txnFileInstance?.txnRef)
printHtmlPart(10)
loop:{
int i = 0
for( gl in (glEntries) ) {
printHtmlPart(11)
expressionOut.print(gl?.branch?.name)
printHtmlPart(12)
if(true && (gl?.debitAcct)) {
printHtmlPart(13)
expressionOut.print(gl?.debitAcct)
printHtmlPart(14)
expressionOut.print(GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.debitAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('formatNumber','g',64,['number':(gl.debitAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(12)
if(true && (gl?.creditAcct)) {
printHtmlPart(13)
expressionOut.print(gl?.creditAcct)
printHtmlPart(14)
expressionOut.print(GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.creditAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatNumber','g',70,['number':(gl.creditAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',80,['action':("Index")],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',81,['action':("viewTellerBalancing")],3)
printHtmlPart(24)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',82,['action':("viewTellerOtherTxn")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',85,[:],1)
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
