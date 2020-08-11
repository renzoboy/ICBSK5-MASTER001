import icbs.loans.ROPA
import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropacollateralShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/collateralShow.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',16,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(uri: '/ropa'))
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',20,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('render','g',102,['template':("details/collateralDetails")],-1)
printHtmlPart(14)
invokeTag('render','g',105,['template':("details/additionalDetails")],-1)
printHtmlPart(15)
invokeTag('render','g',111,['template':("details/ropaLedgerTransactions")],-1)
printHtmlPart(16)
invokeTag('render','g',114,['template':("details/ropaAllowance")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',116,['id':("collateralInstance"),'name':("collateralInstance"),'value':(collateralInstance)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',117,['id':("loanBal"),'name':("loanBal"),'value':(loanBal)],-1)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
invokeTag('hiddenField','g',132,['id':("id"),'name':("id"),'value':(collateralInstance?.id)],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(22)
invokeTag('textField','g',137,['id':("allowanceProbLoss"),'name':("allowanceProbLoss"),'value':(collateralInstance?.allowanceProbLoss),'class':("form-control truncated")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(24)
invokeTag('textField','g',142,['id':("allowanceProbLossBldg"),'name':("allowanceProbLossBldg"),'value':(collateralInstance?.allowanceProbLossBldg),'class':("form-control truncated")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(26)
invokeTag('textField','g',146,['id':("allowanceProbLossOtherProp"),'name':("allowanceProbLossOtherProp"),'value':(collateralInstance?.allowanceProbLossOtherProp),'class':("form-control truncated")],-1)
printHtmlPart(27)
})
invokeTag('form','g',151,['onsubmit':("callLoadingDialog();"),'name':("allowanceProbLoses"),'url':([action:'probableLosesSaveUpdateDebit',controller:'ropa']),'method':("POST")],3)
printHtmlPart(28)
createTagBody(3, {->
printHtmlPart(29)
invokeTag('hiddenField','g',171,['id':("id"),'name':("id"),'value':(collateralInstance?.id)],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(22)
invokeTag('textField','g',176,['id':("allowanceProbLossCr"),'name':("allowanceProbLossCr"),'value':(collateralInstance?.allowanceProbLoss),'class':("form-control truncated")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(24)
invokeTag('textField','g',181,['id':("allowanceProbLossBldgCr"),'name':("allowanceProbLossBldgCr"),'value':(collateralInstance?.allowanceProbLossBldg),'class':("form-control truncated")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(26)
invokeTag('textField','g',185,['id':("allowanceProbLossOtherPropCr"),'name':("allowanceProbLossOtherPropCr"),'value':(collateralInstance?.allowanceProbLossOtherProp),'class':("form-control truncated")],-1)
printHtmlPart(27)
})
invokeTag('form','g',190,['onsubmit':("callLoadingDialog();"),'name':("allowanceProbLosesCr"),'url':([action:'probableLosesSaveUpdateCredit',controller:'ropa']),'method':("POST")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',201,['tag':("main-content")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
if(true && (isSold == true)) {
printHtmlPart(33)
}
else {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',208,['action':("ropaSale"),'controller':("ropa"),'id':(collateralInstance?.id),'params':(['idRopa': params?.ropaId])],4)
printHtmlPart(36)
}
printHtmlPart(37)
if(true && (collateralInstance?.status?.id==1)) {
printHtmlPart(18)
if(true && (collateralInstance?.loan?.balanceAmount <= 0)) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
createClosureForHtmlPart(40, 5)
invokeTag('link','g',215,['name':("transfer"),'action':("transferToRopaGSP"),'controller':("ropa"),'id':(collateralInstance?.id),'params':(['idRopa': params?.ropaId])],5)
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (isCollateralLinkedToOtherLoan == true)) {
printHtmlPart(18)
if(true && (collateralInstance?.status?.id==6)) {
printHtmlPart(34)
createClosureForHtmlPart(44, 5)
invokeTag('link','g',220,['name':("transfer"),'action':("specialtransferToRopaGSP"),'controller':("ropa"),'id':(collateralInstance?.id),'params':(['idRopa': params?.ropaId])],5)
printHtmlPart(41)
}
printHtmlPart(43)
}
else {
printHtmlPart(45)
}
printHtmlPart(42)
if(true && (collateralInstance?.status?.id==6)) {
printHtmlPart(46)
createClosureForHtmlPart(47, 4)
invokeTag('link','g',227,['action':("ropaSaleCash"),'controller':("ropa"),'id':(collateralInstance?.id)],4)
printHtmlPart(48)
createClosureForHtmlPart(49, 4)
invokeTag('link','g',228,['action':("ropaSaleInst"),'controller':("ropa"),'id':(collateralInstance?.id)],4)
printHtmlPart(48)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',229,['action':("showRopaAccDepDetails"),'controller':("ropa"),'id':(params?.id)],4)
printHtmlPart(48)
createClosureForHtmlPart(51, 4)
invokeTag('link','g',230,['action':("ropaDebitCap"),'controller':("ropa"),'id':(collateralInstance?.id)],4)
printHtmlPart(48)
createClosureForHtmlPart(52, 4)
invokeTag('link','g',231,['action':("ropaCreditCap"),'controller':("ropa"),'id':(collateralInstance?.id)],4)
printHtmlPart(53)
}
printHtmlPart(54)
createClosureForHtmlPart(55, 3)
invokeTag('link','g',235,['action':("editCollateral"),'controller':("ropa"),'id':(collateralInstance?.id)],3)
printHtmlPart(56)
createClosureForHtmlPart(57, 3)
invokeTag('link','g',236,['action':("index")],3)
printHtmlPart(58)
})
invokeTag('captureContent','sitemesh',238,['tag':("main-actions")],2)
printHtmlPart(59)
})
invokeTag('captureBody','sitemesh',239,[:],1)
printHtmlPart(60)
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
