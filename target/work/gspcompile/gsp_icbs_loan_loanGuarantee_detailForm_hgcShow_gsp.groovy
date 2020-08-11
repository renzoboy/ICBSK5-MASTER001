import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_detailForm_hgcShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/detailForm/_hgcShow.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('formatNumber','g',13,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcValueForEnrollment)],-1)
printHtmlPart(2)
invokeTag('formatDate','g',17,['format':("MM/dd/yyyy"),'date':(loanGuaranteeInstance?.hgcCoverageStartPeriod)],-1)
printHtmlPart(3)
invokeTag('formatDate','g',21,['format':("MM/dd/yyyy"),'date':(loanGuaranteeInstance?.hgcCoverageEndPeriod)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',25,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcPremiumRate)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',29,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcPremiumDue)],-1)
printHtmlPart(6)
expressionOut.print(loanGuaranteeInstance?.hgcTctNo)
printHtmlPart(7)
expressionOut.print(loanGuaranteeInstance?.hgcLocation)
printHtmlPart(8)
invokeTag('formatNumber','g',42,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcAppraisedValue)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcLoanToValueRatio)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcValueOfNewReleaseForEnrollment)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',56,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcTotalAmountReleased)],-1)
printHtmlPart(12)
invokeTag('formatDate','g',60,['format':("MM/dd/yyyy"),'date':(loanGuaranteeInstance?.hgcloanReleasedDate)],-1)
printHtmlPart(13)
expressionOut.print(loanGuaranteeInstance?.hgcCogNoOfTheFirstReleased)
printHtmlPart(2)
invokeTag('formatDate','g',68,['format':("MM/dd/yyyy"),'date':(loanGuaranteeInstance?.hgcAddCoverageStartPeriod)],-1)
printHtmlPart(3)
invokeTag('formatDate','g',72,['format':("MM/dd/yyyy"),'date':(loanGuaranteeInstance?.hgcAddCoverageEndPeriod)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.hgcAddPremiumDue)],-1)
printHtmlPart(15)
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
