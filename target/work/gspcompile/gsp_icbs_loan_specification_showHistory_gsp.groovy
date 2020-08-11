import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_specification_showHistory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/specification/_showHistory.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.product?.name)
})
invokeTag('link','g',9,['controller':("product"),'action':("show"),'id':(loanApplicationInstance?.product?.id)],1)
printHtmlPart(2)
if(true && (loanInstance?.branch?.id == null)) {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(loanApplicationInstance?.branch?.name)
})
invokeTag('link','g',14,['controller':("branch"),'action':("show"),'id':(loanApplicationInstance?.branch?.id)],2)
printHtmlPart(2)
}
else {
printHtmlPart(3)
createTagBody(2, {->
expressionOut.print(loanInstance?.branch?.name)
})
invokeTag('link','g',20,['controller':("branch"),'action':("show"),'id':(loanInstance?.branch?.id)],2)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(loanInstance?.currency?.name)
printHtmlPart(6)
invokeTag('formatNumber','g',29,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(7)
expressionOut.print(loanInstance?.ownershipType?.description)
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(loanInstance?.interestIncomeScheme?.name)
})
invokeTag('link','g',37,['controller':("interestIncomeScheme"),'action':("show"),'id':(loanInstance?.interestIncomeScheme?.id)],1)
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(loanInstance?.currentPenaltyScheme?.name)
})
invokeTag('link','g',41,['controller':("penaltyIncomeScheme"),'action':("show"),'id':(loanInstance?.currentPenaltyScheme?.id)],1)
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(loanInstance?.pastDuePenaltyScheme?.name)
})
invokeTag('link','g',45,['controller':("penaltyIncomeScheme"),'action':("show"),'id':(loanInstance?.pastDuePenaltyScheme?.id)],1)
printHtmlPart(11)
invokeTag('formatNumber','g',49,['format':("###,###,##0.00"),'number':(loanInstance?.interestRate)],-1)
printHtmlPart(12)
if(true && (loanInstance?.currentPenaltyScheme?.type?.id == 1)) {
printHtmlPart(13)
invokeTag('formatNumber','g',54,['format':("###,###,##0.00"),'number':(loanInstance?.penaltyAmount)],-1)
printHtmlPart(2)
}
else if(true && (loanInstance?.currentPenaltyScheme?.type?.id == 1)) {
printHtmlPart(14)
expressionOut.print(loanInstance?.penaltyRate)
printHtmlPart(15)
}
else {
printHtmlPart(16)
invokeTag('formatNumber','g',66,['format':("###,###,##0.00"),'number':(loanInstance?.serviceCharge)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (loanInstance?.interestIncomeScheme?.installmentCalcType?.id == 1)) {
printHtmlPart(19)
expressionOut.print(loanInstance?.term)
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(loanInstance?.frequency?.description)
printHtmlPart(22)
expressionOut.print(loanInstance?.numInstallments)
printHtmlPart(23)
if(true && (loanInstance?.interestIncomeScheme?.installmentCalcType?.id == 2 || loanInstance?.interestIncomeScheme?.installmentCalcType?.id == 5)) {
printHtmlPart(24)
expressionOut.print(loanInstance?.balloonInstallments)
printHtmlPart(25)
}
printHtmlPart(18)
}
printHtmlPart(26)
invokeTag('formatDate','g',93,['format':("MM/dd/yyyy"),'date':(loanInstance?.applicationDate)],-1)
printHtmlPart(27)
invokeTag('formatDate','g',97,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(28)
invokeTag('formatDate','g',101,['format':("MM/dd/yyyy"),'date':(loanInstance?.interestStartDate)],-1)
printHtmlPart(29)
invokeTag('formatDate','g',105,['format':("MM/dd/yyyy"),'date':(loanInstance?.firstInstallmentDate)],-1)
printHtmlPart(30)
invokeTag('formatDate','g',109,['format':("MM/dd/yyyy"),'date':(loanInstance?.maturityDate)],-1)
printHtmlPart(31)
expressionOut.print(loanInstance?.status?.description)
printHtmlPart(32)
invokeTag('message','g',118,['code':("loan.accountNo.label"),'default':("Account No.")],-1)
printHtmlPart(33)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(34)
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
