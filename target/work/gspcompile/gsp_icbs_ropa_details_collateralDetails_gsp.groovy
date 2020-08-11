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

class gsp_icbs_ropa_details_collateralDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/details/_collateralDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(collateralInstance?.collateral?.owner?.displayName)
printHtmlPart(2)
invokeTag('formatDate','g',14,['format':("MM/dd/yyyy"),'date':(collateralInstance?.ropa.runDateCreated)],-1)
printHtmlPart(3)
expressionOut.print(collateralInstance?.formerTitle)
printHtmlPart(4)
expressionOut.print(collateralInstance?.kindOfLand)
printHtmlPart(5)
expressionOut.print(collateralInstance?.location)
printHtmlPart(6)
expressionOut.print(collateralInstance?.landArea)
printHtmlPart(7)
invokeTag('formatNumber','g',34,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaLandAmt)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',38,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaBldgAmt)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',42,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaOtherAmt)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',50,['format':("###,###,##0.00"),'number':(collateralInstance?.buildingAccDepreciation)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',54,['format':("###,###,##0.00"),'number':(collateralInstance?.otherAccDepreciation)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',58,['format':("###,###,##0.00"),'number':(collateralInstance?.buildingAccDepreciation + collateralInstance?.otherAccDepreciation)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',62,['format':("###,###,##0.00"),'number':(collateralInstance?.allowanceProbLoss)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',66,['format':("###,###,##0.00"),'number':(collateralInstance?.allowanceProbLossBldg)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',70,['format':("###,###,##0.00"),'number':(collateralInstance?.allowanceProbLossOtherProp)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',74,['format':("###,###,##0.00"),'number':(collateralInstance?.allowanceProbLoss + collateralInstance?.allowanceProbLossBldg + collateralInstance?.allowanceProbLossOtherProp)],-1)
printHtmlPart(18)
invokeTag('set','g',78,['var':("netBookValue"),'value':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt - collateralInstance?.buildingAccDepreciation - collateralInstance?.otherAccDepreciation - collateralInstance?.allowanceProbLoss - collateralInstance?.allowanceProbLossBldg - collateralInstance?.allowanceProbLossOtherProp)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',79,['format':("###,###,##0.00"),'number':(netBookValue)],-1)
printHtmlPart(20)
expressionOut.print(collateralInstance?.status)
printHtmlPart(21)
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
