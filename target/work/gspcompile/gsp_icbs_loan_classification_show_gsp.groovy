import icbs.loans.LoanLossProvisionDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_classification_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/classification/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(1)
expressionOut.print(loanInstance?.ageInArrears)
printHtmlPart(2)
expressionOut.print(loanInstance?.loanPerformanceId?.description)
printHtmlPart(3)
expressionOut.print(loanInstance?.loanSecurity?.description)
printHtmlPart(4)
}
else {
printHtmlPart(5)
expressionOut.print(loanInstance?.loanKindOfLoan?.description)
printHtmlPart(6)
expressionOut.print(loanInstance?.loanType?.description)
printHtmlPart(7)
expressionOut.print(loanInstance?.loanProject?.description)
printHtmlPart(8)
expressionOut.print(loanInstance?.ageInArrears)
printHtmlPart(9)
expressionOut.print(loanInstance?.loanProvisionBsp?.description)
printHtmlPart(10)
expressionOut.print(loanInstance?.loanProvision?.description)
printHtmlPart(11)
expressionOut.print(loanInstance?.loanPerformanceId?.description)
printHtmlPart(3)
expressionOut.print(loanInstance?.loanSecurity?.description)
printHtmlPart(4)
}
printHtmlPart(12)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(13)
createTagBody(2, {->
expressionOut.print(loanInstance?.glLink?.description)
})
invokeTag('link','g',63,['controller':("cfgAcctGlTemplate"),'action':("show"),'id':(loanInstance?.glLink?.id)],2)
printHtmlPart(4)
}
else {
printHtmlPart(13)
createTagBody(2, {->
expressionOut.print(loanInstance?.glLink?.description)
})
invokeTag('link','g',70,['controller':("cfgAcctGlTemplate"),'action':("show"),'id':(loanInstance?.glLink?.id)],2)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(16)
if(true && (LoanLossProvisionDetail.findByLoan(loanInstance))) {
printHtmlPart(17)
invokeTag('formatNumber','g',77,['format':("###,##0.00"),'number':(LoanLossProvisionDetail.findByLoan(loanInstance).totalProvision)],-1)
printHtmlPart(18)
expressionOut.print(LoanLossProvisionDetail.findByLoan(loanInstance).remarks)
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(16)
if(true && (LoanLossProvisionDetail.findByLoan(loanInstance))) {
printHtmlPart(21)
invokeTag('formatNumber','g',92,['format':("###,##0.00"),'number':(LoanLossProvisionDetail.findByLoan(loanInstance).uidBalance)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',98,['format':("###,##0.00"),'number':(LoanLossProvisionDetail.findByLoan(loanInstance).loanServiceCharge)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',104,['format':("###,##0.00"),'number':(LoanLossProvisionDetail.findByLoan(loanInstance).otherDeferredCredit)],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',109,['format':("###,##0.00"),'number':(LoanLossProvisionDetail.findByLoan(loanInstance).totalProvision)],-1)
printHtmlPart(25)
expressionOut.print(LoanLossProvisionDetail.findByLoan(loanInstance).remarks)
printHtmlPart(19)
}
printHtmlPart(26)
}
printHtmlPart(27)
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
