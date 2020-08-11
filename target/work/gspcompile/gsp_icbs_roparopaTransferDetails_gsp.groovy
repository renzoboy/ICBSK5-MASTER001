import icbs.loans.LoanLedger
import icbs.tellering.TxnBreakdown
import icbs.gl.GlAccount
import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaTransferDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaTransferDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
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
expressionOut.print(ropaTransferInstance.id)
printHtmlPart(11)
expressionOut.print(ropaTransferInstance?.txnFile?.id)
printHtmlPart(12)
expressionOut.print(ropaTransferInstance?.txnFile?.txnDescription)
printHtmlPart(13)
invokeTag('formatDate','g',56,['format':("MM/dd/yyyy"),'date':(ropaTransferInstance?.txnFile?.txnDate)],-1)
printHtmlPart(14)
expressionOut.print(ropaTransferInstance?.txnFile?.acctNo)
printHtmlPart(15)
expressionOut.print(ropaTransferInstance?.txnFile?.branch?.name)
printHtmlPart(16)
invokeTag('formatNumber','g',68,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.transferAmount)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',72,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.marketValueLand)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.marketValueBuilding)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',80,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.marketValueOther)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',84,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.ropaLandAmount)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',88,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.ropaBuildingAmount)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',92,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.otherGlAmount)],-1)
printHtmlPart(23)
expressionOut.print(ropaTransferInstance?.txnFile?.status?.description)
printHtmlPart(24)
expressionOut.print(ropaTransferInstance?.txnFile?.txnRef)
printHtmlPart(25)
expressionOut.print(ropaTransferInstance?.txnFile?.txnParticulars)
printHtmlPart(26)
loop:{
int i = 0
for( t in (TxnBreakdown.findAllByTxnFile(ropaTransferInstance?.txnFile)) ) {
printHtmlPart(27)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(28)
expressionOut.print(t.debitAcct)
printHtmlPart(29)
if(true && (t.debitAcct)) {
printHtmlPart(30)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('formatNumber','g',130,['format':("###,###,##0.00"),'number':(t.debitAmt)],-1)
printHtmlPart(33)
expressionOut.print(t.creditAcct)
printHtmlPart(29)
if(true && (t.creditAcct)) {
printHtmlPart(30)
expressionOut.print(GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('formatNumber','g',138,['format':("###,###,##0.00"),'number':(t.creditAmt)],-1)
printHtmlPart(34)
i++
}
}
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('hiddenField','g',148,['name':("ropaTransferId"),'id':("ropaTransferId"),'value':(ropaTransferInstance.id)],-1)
printHtmlPart(37)
})
invokeTag('form','g',149,['id':("cancelRopaTransfer"),'url':([controller:'ropa', action:'cancelRopaTransfer']),'method':("POST")],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',151,['tag':("main-content")],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
if(true && (ropaTransferInstance?.txnFile?.status?.id == 2)) {
printHtmlPart(41)
}
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',158,['action':("index")],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',171,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',173,[:],1)
printHtmlPart(45)
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
