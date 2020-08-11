import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_viewMoreInfoTemplates_accountAndBalance_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/viewMoreInfoTemplates/_accountAndBalance.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatDate','g',9,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(1)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(2)
invokeTag('formatDate','g',14,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.startDate)],-1)
printHtmlPart(3)
if(true && (depositInstance?.depositInterestScheme?.fdMonthlyTransfer==true)) {
printHtmlPart(4)
invokeTag('formatDate','g',19,['format':("MM/dd/yyyy"),'date':(depositInstance?.maturityDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
invokeTag('formatDate','g',22,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.endDate)],-1)
printHtmlPart(5)
}
printHtmlPart(7)
invokeTag('formatNumber','g',27,['format':("##,###"),'number':(depositInstance?.maturityDate - depositInstance?.currentRollover?.startDate)],-1)
printHtmlPart(1)
}
printHtmlPart(8)
invokeTag('formatNumber','g',32,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',36,['format':("###############"),'id':("NoPass"),'number':(depositInstance.passBookNo)],-1)
printHtmlPart(1)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(10)
expressionOut.print(depositInstance?.currentRollover?.type)
printHtmlPart(11)
expressionOut.print(depositInstance?.currentRollover?.interestPaymentMode?.description)
printHtmlPart(12)
createTagBody(2, {->
expressionOut.print(depositInstance?.currentRollover?.fundedDeposit?.acctNo)
})
invokeTag('link','g',49,['action':("depositInquiry"),'id':(depositInstance?.currentRollover?.fundedDeposit?.id)],2)
printHtmlPart(1)
}
printHtmlPart(13)
invokeTag('formatDate','g',54,['format':("MM/dd/yyyy"),'date':(depositInstance?.lastTxnDate)],-1)
printHtmlPart(14)
invokeTag('formatDate','g',58,['format':("MM/dd/yyyy"),'date':(depositInstance?.statusChangeDate)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',62,['format':("MM/dd/yyyy"),'date':(depositInstance?.lastCapitalizationDate)],-1)
printHtmlPart(16)
expressionOut.print(depositInstance?.userDepositAcctOfficer?.name1)
printHtmlPart(17)
expressionOut.print(depositInstance?.userDepositAcctOfficer?.name2)
printHtmlPart(17)
expressionOut.print(depositInstance?.userDepositAcctOfficer?.name3)
printHtmlPart(18)
invokeTag('formatNumber','g',81,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',85,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(depositInstance?.passbookBalAmt)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',93,['format':("###,###,##0.00"),'number':(depositInstance?.holdBalAmt)],-1)
printHtmlPart(22)
if(true && (depositInstance?.type?.id == 3 && depositInstance?.currentRollover?.status?.id == 1)) {
printHtmlPart(23)
if(true && (depositInstance?.status?.id == 7)) {
printHtmlPart(24)
invokeTag('formatNumber','g',99,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('formatNumber','g',105,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.normalInterestAmt)],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',109,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(25)
}
printHtmlPart(27)
}
else {
printHtmlPart(28)
invokeTag('formatNumber','g',116,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(29)
}
printHtmlPart(30)
invokeTag('formatNumber','g',121,['format':("###,###,##0.00"),'number':(depositInstance?.lmAveBalAmt)],-1)
printHtmlPart(31)
invokeTag('formatNumber','g',125,['format':("###,###,##0.00"),'number':(depositInstance?.unclearedCheckBalAmt)],-1)
printHtmlPart(32)
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
