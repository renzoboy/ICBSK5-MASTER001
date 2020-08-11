import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_detailForm_sbgfcShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/detailForm/_sbgfcShow.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(loanGuaranteeInstance?.sbgfcMainOfficeAddress)
printHtmlPart(2)
expressionOut.print(loanGuaranteeInstance?.sbgfcPosition)
printHtmlPart(3)
invokeTag('formatNumber','g',21,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.sbgfcNetWorth)],-1)
printHtmlPart(4)
expressionOut.print(loanGuaranteeInstance?.sbgfcNatureOfBusiness)
printHtmlPart(5)
expressionOut.print(loanGuaranteeInstance?.sbgfcBusinessType)
printHtmlPart(6)
expressionOut.print(loanGuaranteeInstance?.sbgfcStartOfBusinessOperation)
printHtmlPart(7)
expressionOut.print(loanGuaranteeInstance?.sbgfcAssetSize)
printHtmlPart(8)
expressionOut.print(loanGuaranteeInstance?.sbgfcNumberOfEmployees)
printHtmlPart(9)
expressionOut.print(loanGuaranteeInstance?.sbgfcTypeOfLoan)
printHtmlPart(10)
expressionOut.print(loanGuaranteeInstance?.sbgfcPurposeOfLoan)
printHtmlPart(11)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.sbgfcOutstandingBalance)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',57,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.sbgfcDsc)],-1)
printHtmlPart(13)
if(true && (loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints == null || loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints == "" || loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints == 0.00)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
expressionOut.print(loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (loanGuaranteeInstance?.sbgfcInitialBrrGrade == null || loanGuaranteeInstance?.sbgfcInitialBrrGrade == "" || loanGuaranteeInstance?.sbgfcInitialBrrGrade == 0.00)) {
printHtmlPart(14)
}
else {
printHtmlPart(18)
expressionOut.print(loanGuaranteeInstance?.sbgfcInitialBrrGrade)
printHtmlPart(16)
}
printHtmlPart(19)
expressionOut.print(loanGuaranteeInstance?.sbgfcBrrTotalPoints)
printHtmlPart(20)
expressionOut.print(loanGuaranteeInstance?.sbgfcBrrGrade)
printHtmlPart(21)
expressionOut.print(loanGuaranteeInstance?.sbgfcTypeOfCollateral)
printHtmlPart(22)
expressionOut.print(loanGuaranteeInstance?.sbgfcMarketValue)
printHtmlPart(23)
expressionOut.print(loanGuaranteeInstance?.sbgfcLoanValue)
printHtmlPart(24)
expressionOut.print(loanGuaranteeInstance?.sbgfcBusinessName)
printHtmlPart(25)
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
