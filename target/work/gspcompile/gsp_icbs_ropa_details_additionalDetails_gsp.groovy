import icbs.loans.RopaCollateralDetails
import icbs.loans.ROPA
import icbs.loans.Collateral
import icbs.lov.AppraisedValueType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_details_additionalDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/details/_additionalDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('formatDate','g',11,['format':("MM/dd/yyyy"),'date':(collateralInstance?.forClosureDate)],-1)
printHtmlPart(2)
invokeTag('formatDate','g',15,['format':("MM/dd/yyyy"),'date':(collateralInstance?.certificateDate)],-1)
printHtmlPart(3)
invokeTag('formatDate','g',19,['format':("MM/dd/yyyy"),'date':(collateralInstance?.certificateRegistrationDate)],-1)
printHtmlPart(4)
invokeTag('formatDate','g',23,['format':("MM/dd/yyyy"),'date':(collateralInstance?.notarizationOfDacionDate)],-1)
printHtmlPart(5)
invokeTag('formatDate','g',27,['format':("MM/dd/yyyy"),'date':(collateralInstance?.cosExpiryDateOfRedemption)],-1)
printHtmlPart(6)
invokeTag('formatDate','g',31,['format':("MM/dd/yyyy"),'date':(collateralInstance?.consolidatedDate)],-1)
printHtmlPart(7)
expressionOut.print(collateralInstance?.consolidatedTitleNumber)
printHtmlPart(8)
invokeTag('formatNumber','g',39,['format':("###,###,##0.00"),'number':(collateralInstance?.fireInsuranceAmt)],-1)
printHtmlPart(9)
expressionOut.print(collateralInstance?.fireInsurancePolicyNo)
printHtmlPart(10)
invokeTag('formatDate','g',47,['format':("MM/dd/yyyy"),'date':(collateralInstance?.fireInsuranceStartDate)],-1)
printHtmlPart(11)
invokeTag('formatDate','g',51,['format':("MM/dd/yyyy"),'date':(collateralInstance?.fireInsuranceEndDate)],-1)
printHtmlPart(12)
invokeTag('formatDate','g',55,['format':("MM/dd/yyyy"),'date':(collateralInstance?.latestRatrDate)],-1)
printHtmlPart(13)
if(true && (collateralInstance?.appraisedBy)) {
printHtmlPart(14)
expressionOut.print(collateralInstance?.appraisedBy.name1)
printHtmlPart(15)
expressionOut.print(collateralInstance?.appraisedBy.name2)
printHtmlPart(15)
expressionOut.print(collateralInstance?.appraisedBy.name3)
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('formatDate','g',72,['format':("MM/dd/yyyy"),'date':(collateralInstance?.appraisalDate)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(collateralInstance?.landAppraisal)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',80,['format':("###,###,##0.00"),'number':(collateralInstance?.buildingAppraisal)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',84,['format':("###,###,##0.00"),'number':(collateralInstance?.otherAppraisal)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',88,['format':("###,###,##0.00"),'number':(collateralInstance?.landAppraisal + collateralInstance?.buildingAppraisal + collateralInstance?.otherAppraisal)],-1)
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
