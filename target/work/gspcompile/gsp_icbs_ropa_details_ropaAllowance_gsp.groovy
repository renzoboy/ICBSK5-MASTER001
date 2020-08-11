import icbs.loans.RopaAllowanceLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_details_ropaAllowance_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/details/_ropaAllowance.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( ropaLedgerInstance in (RopaAllowanceLedger.findAllByRopa(collRopaInstance).sort{it.id}) ) {
printHtmlPart(1)
expressionOut.print(ropaLedgerInstance?.id)
printHtmlPart(2)
invokeTag('formatDate','g',23,['format':("MM/dd/yyyy"),'date':(ropaLedgerInstance?.recordDate)],-1)
printHtmlPart(2)
expressionOut.print(ropaLedgerInstance?.particulars)
printHtmlPart(3)
if(true && (ropaLedgerInstance?.landDebit == 0)) {
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('formatNumber','g',29,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.landDebit)],-1)
printHtmlPart(3)
}
printHtmlPart(6)
if(true && (ropaLedgerInstance?.landCredit == 0)) {
printHtmlPart(4)
}
else {
printHtmlPart(7)
invokeTag('formatNumber','g',35,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.landCredit)],-1)
printHtmlPart(3)
}
printHtmlPart(8)
if(true && (ropaLedgerInstance?.bldgDebit == 0)) {
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('formatNumber','g',41,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.bldgDebit)],-1)
printHtmlPart(3)
}
printHtmlPart(6)
if(true && (ropaLedgerInstance?.bldgCredit == 0)) {
printHtmlPart(4)
}
else {
printHtmlPart(7)
invokeTag('formatNumber','g',47,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.bldgCredit)],-1)
printHtmlPart(3)
}
printHtmlPart(8)
if(true && (ropaLedgerInstance?.otherDebitAmt == 0)) {
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.otherDebitAmt)],-1)
printHtmlPart(3)
}
printHtmlPart(6)
if(true && (ropaLedgerInstance?.otherCreditAmt == 0)) {
printHtmlPart(4)
}
else {
printHtmlPart(7)
invokeTag('formatNumber','g',59,['format':("###,###,##0.00"),'number':(ropaLedgerInstance?.otherCreditAmt)],-1)
printHtmlPart(3)
}
printHtmlPart(9)
}
printHtmlPart(10)
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
