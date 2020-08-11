import icbs.tellering.TxnCOCI
import icbs.loans.Loan
import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositviewUnclearedDeposit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/viewUnclearedDeposit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(txnCociInstanceId?.checkNo)
printHtmlPart(12)
expressionOut.print(txnCociInstanceId?.txnRef)
printHtmlPart(13)
expressionOut.print(txnCociInstanceId?.totalChecks)
printHtmlPart(14)
invokeTag('formatNumber','g',42,['format':("##0.00000"),'number':(txnCociInstance?.txnAmt)],-1)
printHtmlPart(15)
expressionOut.print(txnCociInstanceId?.payee)
printHtmlPart(16)
expressionOut.print(txnCociInstanceId?.acctNo)
printHtmlPart(17)
expressionOut.print(txnCociInstanceId?.depAcct.id)
printHtmlPart(18)
expressionOut.print(txnCociInstanceId?.branch?.name)
printHtmlPart(19)
expressionOut.print(txnCociInstanceId?.checkType?.id)
printHtmlPart(20)
expressionOut.print(txnCociInstanceId?.bank)
printHtmlPart(21)
expressionOut.print(txnCociInstanceId?.checkNo)
printHtmlPart(22)
expressionOut.print(txnCociInstanceId?.checkAcctName)
printHtmlPart(23)
invokeTag('formatNumber','g',78,['format':("##0.00000"),'number':(txnCociInstanceId?.checkAmt)],-1)
printHtmlPart(24)
invokeTag('formatDate','g',82,['format':("MM/dd/yyyy"),'date':(txnCociInstanceId?.checkDate)],-1)
printHtmlPart(25)
invokeTag('formatDate','g',86,['format':("MM/dd/yyyy"),'date':(txnCociInstanceId?.clearingDate)],-1)
printHtmlPart(26)
expressionOut.print(txnCociInstanceId?.status?.description)
printHtmlPart(27)
expressionOut.print(txnCociInstanceId?.hash)
printHtmlPart(28)
expressionOut.print(txnCociInstanceId?.currency?.name)
printHtmlPart(29)
expressionOut.print(txnCociInstanceId?.txnFile?.txnDescription)
printHtmlPart(30)
expressionOut.print(txnCociInstanceId?.cleared)
printHtmlPart(31)
expressionOut.print(txnCociInstanceId?.user?.name)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',115,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',118,['action':("depositInquiry"),'id':(txnCociInstanceId?.depAcct.id)],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(37)
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
