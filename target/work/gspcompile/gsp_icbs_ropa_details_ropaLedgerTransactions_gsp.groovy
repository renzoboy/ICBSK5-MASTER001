import icbs.loans.ROPALedger
import icbs.loans.RopaTransfer
import icbs.loans.RopaSaleDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_details_ropaLedgerTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/details/_ropaLedgerTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
for( ropaLedgerInstance in (ROPALedger.findAllByRopa(collRopaInstance).sort{it.id}) ) {
printHtmlPart(2)
expressionOut.print(ropaLedgerInstance?.id)
printHtmlPart(3)
invokeTag('formatDate','g',23,['format':("MM/dd/yyyy"),'date':(ropaLedgerInstance?.txnDate)],-1)
printHtmlPart(4)
expressionOut.print(ropaLedgerInstance?.reference)
printHtmlPart(4)
expressionOut.print(ropaLedgerInstance?.particulars)
printHtmlPart(5)
if(true && (ropaLedgerInstance?.debitAmt == 0)) {
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('formatNumber','g',30,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.debitAmt)],-1)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (ropaLedgerInstance?.creditAmt == 0)) {
printHtmlPart(10)
}
else {
printHtmlPart(11)
invokeTag('formatNumber','g',36,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.creditAmt)],-1)
printHtmlPart(8)
}
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',38,['class':("btn btn-secondary"),'controller':("ropa"),'action':("showRopaLedgerTrans"),'id':(ropaLedgerInstance?.id)],2)
printHtmlPart(14)
}
printHtmlPart(15)
loop:{
int i = 0
for( ropaTransferInstance in (RopaTransfer.findAllByRopaCollateralDetails(collateralInstance)) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
invokeTag('formatDate','g',62,['format':("MM/dd/yyyy"),'date':(ropaTransferInstance?.txnFile?.txnDate)],-1)
printHtmlPart(18)
expressionOut.print(ropaTransferInstance?.txnFile?.id)
printHtmlPart(18)
expressionOut.print(ropaTransferInstance?.txnFile?.txnRef)
printHtmlPart(18)
expressionOut.print(ropaTransferInstance?.txnFile?.txnParticulars)
printHtmlPart(19)
invokeTag('formatNumber','g',66,['format':("###,###,##0.00"),'number':(ropaTransferInstance?.transferAmount)],-1)
printHtmlPart(18)
expressionOut.print(ropaTransferInstance?.txnFile?.status?.description)
printHtmlPart(18)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',68,['class':("btn btn-secondary"),'action':("ropaTransferDetails"),'id':(ropaTransferInstance?.id)],2)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
loop:{
int i = 0
for( ropaSaleInstance in (RopaSaleDetails.findAllByRopaCollateralDetails(collateralInstance)) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
invokeTag('formatDate','g',92,['format':("MM/dd/yyyy"),'date':(ropaSaleInstance?.txnFile?.txnDate)],-1)
printHtmlPart(18)
expressionOut.print(ropaSaleInstance?.txnFile?.id)
printHtmlPart(18)
expressionOut.print(ropaSaleInstance?.txnFile?.txnRef)
printHtmlPart(18)
expressionOut.print(ropaSaleInstance?.txnFile?.txnParticulars)
printHtmlPart(19)
invokeTag('formatNumber','g',96,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.saleAmount)],-1)
printHtmlPart(18)
expressionOut.print(ropaSaleInstance?.txnFile?.status?.description)
printHtmlPart(18)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',98,['class':("btn btn-secondary"),'action':("ropaSaleDetails"),'id':(ropaSaleInstance?.id)],2)
printHtmlPart(21)
i++
}
}
printHtmlPart(23)
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
