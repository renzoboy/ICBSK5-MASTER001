import icbs.loans.LoanLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_balance_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/balance/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( installment in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sort{it.sequenceNo}) ) {
printHtmlPart(1)
expressionOut.print(installment?.sequenceNo)
printHtmlPart(2)
invokeTag('formatDate','g',20,['format':("MM-dd-yyyy"),'date':(installment?.installmentDate)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',21,['format':("###,##0.00"),'number':(installment?.principalInstallmentAmount - installment?.principalInstallmentPaid)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',22,['format':("###,##0.00"),'number':(installment?.interestInstallmentAmount - installment?.interestInstallmentPaid)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',23,['format':("###,##0.00"),'number':(installment?.penaltyInstallmentAmount - installment?.penaltyInstallmentPaid)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',24,['format':("###,##0.00"),'number':(installment?.serviceChargeInstallmentAmount - installment?.serviceChargeInstallmentPaid)],-1)
printHtmlPart(6)
}
printHtmlPart(7)
for( totalpri in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentAmount}) ) {
printHtmlPart(8)
for( totalpripd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.principalInstallmentPaid}) ) {
printHtmlPart(8)
for( totalint in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentAmount}) ) {
printHtmlPart(9)
for( totalintpd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.interestInstallmentPaid}) ) {
printHtmlPart(8)
for( totalpen in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.penaltyInstallmentAmount}) ) {
printHtmlPart(8)
for( totalpenpd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.penaltyInstallmentPaid}) ) {
printHtmlPart(8)
for( totalser in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.serviceChargeInstallmentAmount}) ) {
printHtmlPart(8)
for( totalserpd in (loanInstance?.loanInstallments.findAll{it.status.id == 3L || it.status.id == 4L}.sum{it.serviceChargeInstallmentPaid}) ) {
printHtmlPart(10)
invokeTag('formatNumber','g',38,['format':("###,##0.00"),'number':(totalpri - totalpripd)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',39,['format':("###,##0.00"),'number':(totalint - totalintpd)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',40,['format':("###,##0.00"),'number':(totalpen - totalpenpd)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',41,['format':("###,##0.00"),'number':(totalser - totalserpd)],-1)
printHtmlPart(12)
}
printHtmlPart(8)
}
printHtmlPart(8)
}
printHtmlPart(8)
}
printHtmlPart(8)
}
printHtmlPart(13)
}
printHtmlPart(8)
}
printHtmlPart(8)
}
printHtmlPart(14)
invokeTag('formatNumber','g',71,['format':("###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',72,['format':("###,##0.00"),'number':(loanInstance?.interestBalanceAmount)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',73,['format':("###,##0.00"),'number':(loanInstance?.penaltyBalanceAmount)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',74,['format':("###,##0.00"),'number':(loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',75,['format':("###,##0.00"),'number':(loanInstance?.balanceAmount + loanInstance?.interestBalanceAmount + loanInstance?.penaltyBalanceAmount + loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(17)
if(true && (loanInstance?.status.id < 6)) {
printHtmlPart(18)
invokeTag('formatNumber','g',86,['format':("###,##0.00"),'number':(loanInstance?.overduePrincipalBalance)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',90,['format':("###,##0.00"),'number':(loanInstance?.overduePrincipalBalance + loanInstance?.interestBalanceAmount + loanInstance?.penaltyBalanceAmount + loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(20)
if(true && (loanInstance?.numInstallments == 1)) {
printHtmlPart(8)
invokeTag('formatNumber','g',96,['format':("###,##0.00"),'number':(loanInstance?.interestBalanceAmount)],-1)
printHtmlPart(21)
}
else {
printHtmlPart(8)
invokeTag('formatNumber','g',99,['format':("###,##0.00"),'number':(intToDate)],-1)
printHtmlPart(21)
}
printHtmlPart(22)
}
else {
printHtmlPart(23)
invokeTag('formatNumber','g',112,['format':("###,##0.00"),'number':("0.00")],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',116,['format':("###,##0.00"),'number':("0.00")],-1)
printHtmlPart(20)
if(true && (loanInstance?.numInstallments == 1)) {
printHtmlPart(8)
invokeTag('formatNumber','g',122,['format':("###,##0.00"),'number':("0.00")],-1)
printHtmlPart(21)
}
else {
printHtmlPart(8)
invokeTag('formatNumber','g',125,['format':("###,##0.00"),'number':("0.00")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(24)
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
