import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropashowRopaAccDepDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/showRopaAccDepDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(ropaCollateralDetails?.collateral?.owner?.displayName)
printHtmlPart(11)
expressionOut.print(ropaCollateralDetails?.formerTitle)
printHtmlPart(12)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(ropaCollateralDetails?.landAppraisal)],-1)
printHtmlPart(13)
expressionOut.print(ropaCollateralDetails?.landArea)
printHtmlPart(14)
expressionOut.print(ropaCollateralDetails?.location)
printHtmlPart(15)
invokeTag('formatDate','g',59,['format':("MM/dd/yyyy"),'date':(ropaCollateralDetails?.refDate)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(ropaCollateralDetails?.ropaBldgAmt)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',68,['format':("###,###,##0.00"),'number':(ropaCollateralDetails?.buildingAccDepreciation)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',72,['format':("###,###,##0.00"),'number':(ropaCollateralDetails?.ropaOtherAmt)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(ropaCollateralDetails?.otherAccDepreciation)],-1)
printHtmlPart(20)
for( ropaAccDepInstance in (ropaAccumulatedDepInstance) ) {
printHtmlPart(21)
expressionOut.print(ropaAccDepInstance?.id)
printHtmlPart(22)
invokeTag('formatDate','g',103,['format':("MM/dd/yyyy"),'date':(ropaAccDepInstance?.recordDate)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',104,['format':("###,###,##0.00"),'number':(ropaAccDepInstance?.debitAmt)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',105,['format':("###,###,##0.00"),'number':(ropaAccDepInstance?.creditAmt)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',106,['format':("###,###,##0.00"),'number':(ropaAccDepInstance?.otherDebitAmt)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',107,['format':("###,###,##0.00"),'number':(ropaAccDepInstance?.otherCreditAmt)],-1)
printHtmlPart(22)
expressionOut.print(ropaAccDepInstance?.reference)
printHtmlPart(22)
expressionOut.print(ropaAccDepInstance?.particulars)
printHtmlPart(23)
expressionOut.print(ropaAccDepInstance?.recordBy?.name1)
printHtmlPart(24)
expressionOut.print(ropaAccDepInstance?.recordBy?.name2)
printHtmlPart(24)
expressionOut.print(ropaAccDepInstance?.recordBy?.name3)
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',130,['controller':("ropa"),'action':("ropaCreateAccdep"),'id':(ropaCollateralDetails.id),'params':([actionType: 'debit'])],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',131,['controller':("ropa"),'action':("ropaCreateAccdep"),'id':(ropaCollateralDetails.id),'params':([actionType: 'credit'])],3)
printHtmlPart(30)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',132,['action':("collateralShow"),'controller':("ropa"),'id':(ropaCollateralDetails.id)],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',132,[:],1)
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
