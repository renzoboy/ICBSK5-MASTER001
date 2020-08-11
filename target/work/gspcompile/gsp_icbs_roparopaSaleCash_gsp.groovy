import icbs.loans.RopaTransfer
import icbs.loans.RopaCollateralDetails
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaSaleCash_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaSaleCash.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'ropa', action:'collectionInformation'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'ropa', action:'search'))
printHtmlPart(10)
expressionOut.print(loanApplication?.id)
printHtmlPart(11)
})
invokeTag('javascript','g',105,[:],3)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(18)
expressionOut.print(error.field)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',113,['error':("${error.field} - ${error}")],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',114,['bean':(collateralInstance),'var':("error")],4)
printHtmlPart(22)
})
invokeTag('hasErrors','g',116,['bean':(collateralInstance)],3)
printHtmlPart(23)
expressionOut.print(collateralInstance?.loan?.branch?.name)
printHtmlPart(24)
expressionOut.print(collateralInstance?.newTct)
printHtmlPart(25)
expressionOut.print(collateralInstance?.kindOfLand)
printHtmlPart(26)
expressionOut.print(collateralInstance?.location)
printHtmlPart(27)
invokeTag('formatNumber','g',137,['format':("###,###,##0.00"),'number':(collateralInstance?.landAppraisal + collateralInstance?.buildingAppraisal + collateralInstance?.otherAppraisal)],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',141,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt)],-1)
printHtmlPart(29)
invokeTag('formatNumber','g',147,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt 
                                - collateralInstance?.buildingAccDepreciation - collateralInstance?.otherAccDepreciation
                                - collateralInstance?.allowanceProbLoss - collateralInstance?.allowanceProbLossBldg - collateralInstance?.allowanceProbLossOtherProp)],-1)
printHtmlPart(30)
invokeTag('hiddenField','g',151,['name':("processBranch"),'id':("processBranch"),'value':(UserMaster.get(session.user_id).branch.id)],-1)
printHtmlPart(31)
invokeTag('hiddenField','g',152,['name':("ropaBranch"),'id':("ropaBranch"),'value':(RopaTransfer.findByRopaCollateralDetails(collateralInstance).loan.branch.id)],-1)
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(33)
invokeTag('render','g',157,['template':("ropaSaleCashForm")],-1)
printHtmlPart(34)
})
invokeTag('form','g',158,['id':("create"),'url':([controller:'ropa', action:'saveRopaSaleCash']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',159,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(36)
createTagBody(3, {->
invokeTag('message','g',166,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',166,['action':("ropaForSale")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',166,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',166,[:],1)
printHtmlPart(38)
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
