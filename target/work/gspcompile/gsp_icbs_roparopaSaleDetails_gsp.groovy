import icbs.tellering.TxnBreakdown
import icbs.gl.GlAccount
import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaSaleDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaSaleDetails.gsp" }
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
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(ropaSaleInstance.id)
printHtmlPart(11)
expressionOut.print(ropaSaleInstance?.txnFile?.id)
printHtmlPart(12)
expressionOut.print(ropaSaleInstance?.txnFile?.txnDescription)
printHtmlPart(13)
expressionOut.print(ropaSaleInstance?.ropaBranch?.name)
printHtmlPart(14)
expressionOut.print(ropaSaleInstance?.processBranch?.name)
printHtmlPart(15)
invokeTag('formatDate','g',63,['format':("MM/dd/yyyy"),'date':(ropaSaleInstance?.txnFile?.txnDate)],-1)
printHtmlPart(16)
expressionOut.print(ropaSaleInstance?.agent?.username)
printHtmlPart(17)
if(true && (ropaSaleInstance.loan)) {
printHtmlPart(18)
expressionOut.print(ropaSaleInstance?.loan?.accountNo)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(ropaSaleInstance?.loanApplication?.customer?.displayName)
printHtmlPart(21)
invokeTag('formatNumber','g',81,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.saleAmount)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',85,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.commission)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.downpayment)],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',93,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.scrAmount)],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',97,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.scrDiscount)],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',101,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.ropaLandAmt + ropaSaleInstance?.ropaBldgAmt + ropaSaleInstance?.ropaOtherAmt - ropaSaleInstance?.accDepBldg - ropaSaleInstance?.accDepOther)],-1)
printHtmlPart(27)
invokeTag('formatNumber','g',105,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.incomeAmount)],-1)
printHtmlPart(28)
expressionOut.print(ropaSaleInstance?.txnFile?.status?.description)
printHtmlPart(29)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(ropaSaleInstance?.txnFile)) ) {
printHtmlPart(30)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(31)
expressionOut.print(t?.branch?.name)
printHtmlPart(32)
expressionOut.print(t.debitAcct)
printHtmlPart(33)
if(true && (t.debitAcct)) {
printHtmlPart(34)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('formatNumber','g',138,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(37)
expressionOut.print(t.creditAcct)
printHtmlPart(33)
if(true && (t.creditAcct)) {
printHtmlPart(34)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('formatNumber','g',146,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(38)
i++
}
}
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
invokeTag('hiddenField','g',156,['name':("ropaSaleId"),'id':("ropaSaleId"),'value':(ropaSaleInstance.id)],-1)
printHtmlPart(41)
})
invokeTag('form','g',157,['id':("cancelRopaSale"),'url':([controller:'ropa', action:'cancelRopaSale']),'method':("POST")],3)
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',158,['tag':("main-content")],2)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
if(true && (ropaSaleInstance?.txnFile?.status?.id == 2)) {
printHtmlPart(44)
}
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',164,['action':("index")],3)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',177,['tag':("main-actions")],2)
printHtmlPart(48)
})
invokeTag('captureBody','sitemesh',178,[:],1)
printHtmlPart(49)
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
