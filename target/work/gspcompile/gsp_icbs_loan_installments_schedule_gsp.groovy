import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_installments_schedule_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/installments/_schedule.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',25,['var':("advInterest"),'value':(loanInstance?.advInterest ?: 0)],-1)
printHtmlPart(1)
invokeTag('set','g',26,['var':("totalPrincipal"),'value':(0)],-1)
printHtmlPart(1)
invokeTag('set','g',27,['var':("totalInterest"),'value':(advInterest)],-1)
printHtmlPart(1)
invokeTag('set','g',28,['var':("totalServiceCharges"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('formatNumber','g',33,['format':("###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',39,['format':("###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(4)
invokeTag('formatDate','g',44,['format':("MM-dd-yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(5)
if(true && (advInterest > 0)) {
printHtmlPart(6)
invokeTag('formatNumber','g',49,['format':("###,##0.00"),'number':(advInterest)],-1)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('formatNumber','g',53,['format':("###,##0.00"),'number':(totalDeductions)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',54,['format':("###,##0.00"),'number':(loanInstance?.grantedAmount - (totalDeductions + advInterest))],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',55,['format':("###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(9)
invokeTag('set','g',58,['var':("prevBalance"),'value':(loanInstance?.grantedAmount)],-1)
printHtmlPart(1)
for( loanInstallment in (loanInstance?.loanInstallments?.sort{it.sequenceNo}) ) {
printHtmlPart(10)
invokeTag('set','g',61,['var':("balance"),'value':((prevBalance - loanInstallment?.principalInstallmentAmount).round(2))],-1)
printHtmlPart(11)
expressionOut.print(loanInstallment?.sequenceNo)
printHtmlPart(12)
invokeTag('formatDate','g',63,['format':("MM-dd-yyyy"),'date':(loanInstallment?.installmentDate)],-1)
printHtmlPart(13)
invokeTag('set','g',65,['var':("principal"),'value':(loanInstallment?.principalInstallmentAmount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',66,['format':("###,##0.00"),'number':(principal)],-1)
printHtmlPart(15)
invokeTag('set','g',67,['var':("interest"),'value':(loanInstallment?.interestInstallmentAmount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',68,['format':("###,##0.00"),'number':(interest)],-1)
printHtmlPart(15)
invokeTag('set','g',69,['var':("serviceCharge"),'value':(loanInstallment?.serviceChargeInstallmentAmount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',70,['format':("###,##0.00"),'number':(serviceCharge)],-1)
printHtmlPart(13)
invokeTag('set','g',72,['var':("cashFlow"),'value':(loanInstallment?.totalInstallmentAmount * -1)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',73,['format':("###,##0.00"),'number':(cashFlow)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',74,['format':("###,##0.00"),'number':(balance)],-1)
printHtmlPart(15)
invokeTag('set','g',75,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(6)
invokeTag('set','g',76,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(6)
invokeTag('set','g',77,['var':("totalInterest"),'value':(totalInterest +interest)],-1)
printHtmlPart(6)
invokeTag('set','g',78,['var':("totalServiceCharges"),'value':(totalServiceCharges + serviceCharge)],-1)
printHtmlPart(11)
expressionOut.print(loanInstallment?.status?.description)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('formatNumber','g',86,['format':("###,##0.00"),'number':(totalPrincipal)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',87,['format':("###,##0.00"),'number':(totalInterest)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',88,['format':("###,##0.00"),'number':(totalServiceCharges)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',89,['format':("###,##0.00"),'number':(totalDeductions)],-1)
printHtmlPart(19)
invokeTag('message','g',100,['code':("loan.grantedAmount.label"),'default':("Granted Amount")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',103,['format':("###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(21)
invokeTag('message','g',108,['code':("loan.effectiveInterestRate.label"),'default':("Effective Interest Rate")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',111,['format':("###,##0.00"),'number':(loanInstance?.effectiveInterestRate)],-1)
printHtmlPart(22)
invokeTag('message','g',116,['code':("loan.monthlyInterestRate.label"),'default':("Monthly Interest Rate")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',119,['format':("###,##0.00"),'number':(loanInstance?.monthlyInterestRate)],-1)
printHtmlPart(22)
invokeTag('message','g',124,['code':("loan.totalNetProceeds.label"),'default':("Total Net Proceeds")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',127,['format':("###,##0.00"),'number':(loanInstance?.totalNetProceeds)],-1)
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
