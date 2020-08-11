import icbs.loans.RopaTransfer
import icbs.loans.RopaCollateralDetails
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaSaleInst_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaSaleInst.gsp" }
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
expressionOut.print(createLink(controller:'ropa', action:'collectionInformationInstallment'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'ropa', action:'search'))
printHtmlPart(10)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(12)
expressionOut.print(loanApplication?.id)
printHtmlPart(13)
})
invokeTag('javascript','g',170,[:],3)
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
createTagBody(4, {->
printHtmlPart(19)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(20)
expressionOut.print(error.field)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('message','g',178,['error':("${error.field} - ${error}")],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',179,['bean':(collateralInstance),'var':("error")],4)
printHtmlPart(24)
})
invokeTag('hasErrors','g',181,['bean':(collateralInstance)],3)
printHtmlPart(25)
expressionOut.print(collateralInstance?.loan?.branch?.name)
printHtmlPart(26)
expressionOut.print(collateralInstance?.newTct)
printHtmlPart(27)
expressionOut.print(collateralInstance?.kindOfLand)
printHtmlPart(28)
expressionOut.print(collateralInstance?.location)
printHtmlPart(29)
invokeTag('formatNumber','g',202,['format':("###,###,##0.00"),'number':(collateralInstance?.landAppraisal + collateralInstance?.buildingAppraisal + collateralInstance?.otherAppraisal)],-1)
printHtmlPart(30)
invokeTag('formatNumber','g',206,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt)],-1)
printHtmlPart(31)
invokeTag('formatNumber','g',212,['format':("###,###,##0.00"),'number':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt 
                                - collateralInstance?.buildingAccDepreciation - collateralInstance?.otherAccDepreciation
                                - collateralInstance?.allowanceProbLoss - collateralInstance?.allowanceProbLossBldg - collateralInstance?.allowanceProbLossOtherProp)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',216,['name':("processBranch"),'id':("processBranch"),'value':(UserMaster.get(session.user_id).branch.id)],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',217,['name':("ropaBranch"),'id':("ropaBranch"),'value':(collateralInstance?.loan?.branch?.id)],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',218,['name':("scrGrantedAmount"),'id':("scrGrantedAmount"),'value':("")],-1)
printHtmlPart(34)
invokeTag('hiddenField','g',219,['name':("scrBalanceAmount"),'id':("scrBalanceAmount"),'value':("")],-1)
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
invokeTag('render','g',223,['template':("ropaSaleInstForm")],-1)
printHtmlPart(37)
})
invokeTag('form','g',224,['id':("create"),'url':([controller:'ropa', action:'saveRopaSaleInst']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',225,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(39)
createTagBody(3, {->
invokeTag('message','g',232,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',232,['action':("ropaForSale")],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',232,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',232,[:],1)
printHtmlPart(41)
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
