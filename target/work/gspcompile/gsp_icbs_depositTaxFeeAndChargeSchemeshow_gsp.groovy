import icbs.deposit.DepositTaxFeeAndChargeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/depositTaxFeeAndChargeScheme'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (depositTaxFeeAndChargeSchemeInstance?.code)) {
printHtmlPart(12)
invokeTag('message','g',30,['code':("depositTaxFeeAndChargeScheme.code.label"),'default':("Code")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',31,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("code")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.type)) {
printHtmlPart(12)
invokeTag('message','g',36,['code':("depositTaxFeeAndChargeScheme.type.label"),'default':("Type")],-1)
printHtmlPart(16)
expressionOut.print(depositTaxFeeAndChargeSchemeInstance?.type?.encodeAsHTML())
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.taxRate)) {
printHtmlPart(12)
invokeTag('message','g',42,['code':("depositTaxFeeAndChargeScheme.taxRate.label"),'default':("Tax Rate")],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',43,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.taxRate)],-1)
printHtmlPart(18)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeRate)) {
printHtmlPart(12)
invokeTag('message','g',48,['code':("depositTaxFeeAndChargeScheme.feeRate.label"),'default':("Fee Rate")],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',49,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.feeRate)],-1)
printHtmlPart(20)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeAmt)) {
printHtmlPart(12)
invokeTag('message','g',54,['code':("depositTaxFeeAndChargeScheme.feeAmt.label"),'default':("Fee Amt")],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.feeAmt)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.chargeRate)) {
printHtmlPart(12)
invokeTag('message','g',60,['code':("depositTaxFeeAndChargeScheme.chargeRate.label"),'default':("Charge Rate")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',61,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.chargeRate)],-1)
printHtmlPart(20)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.chargeAmt)) {
printHtmlPart(12)
invokeTag('message','g',66,['code':("depositTaxFeeAndChargeScheme.chargeAmt.label"),'default':("Charge Amt")],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',67,['format':("###,###,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.chargeAmt)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.specialCalculation)) {
printHtmlPart(12)
invokeTag('message','g',72,['code':("depositTaxFeeAndChargeScheme.specialCalculation.label"),'default':("Special Calculation")],-1)
printHtmlPart(24)
expressionOut.print(depositTaxFeeAndChargeSchemeInstance?.specialCalculation?.encodeAsHTML())
printHtmlPart(25)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeBaseAmtCondition)) {
printHtmlPart(12)
invokeTag('message','g',78,['code':("depositTaxFeeAndChargeScheme.feeBaseAmtCondition.label"),'default':("Fee Base Amt Condition")],-1)
printHtmlPart(26)
invokeTag('formatBoolean','g',79,['boolean':(depositTaxFeeAndChargeSchemeInstance?.feeBaseAmtCondition)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeCountCondition)) {
printHtmlPart(12)
invokeTag('message','g',84,['code':("depositTaxFeeAndChargeScheme.feeCountCondition.label"),'default':("Fee Count Condition")],-1)
printHtmlPart(27)
invokeTag('formatBoolean','g',85,['boolean':(depositTaxFeeAndChargeSchemeInstance?.feeCountCondition)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.gracePeriod)) {
printHtmlPart(12)
invokeTag('message','g',90,['code':("depositTaxFeeAndChargeScheme.gracePeriod.label"),'default':("Grace Period")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',91,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("gracePeriod")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.feeRateBasis)) {
printHtmlPart(12)
invokeTag('message','g',96,['code':("depositTaxFeeAndChargeScheme.feeRateBasis.label"),'default':("Fee Rate Basis")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',97,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("feeRateBasis")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.chargeRateBasis)) {
printHtmlPart(12)
invokeTag('message','g',102,['code':("depositTaxFeeAndChargeScheme.chargeRateBasis.label"),'default':("Charge Rate Basis")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',103,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("chargeRateBasis")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.isApplyToClosingBal)) {
printHtmlPart(12)
invokeTag('message','g',108,['code':("depositTaxFeeAndChargeScheme.isApplyToClosingBal.label"),'default':("Is Apply To Closing Bal")],-1)
printHtmlPart(31)
invokeTag('formatBoolean','g',109,['boolean':(depositTaxFeeAndChargeSchemeInstance?.isApplyToClosingBal)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.minAmtException)) {
printHtmlPart(12)
invokeTag('message','g',114,['code':("depositTaxFeeAndChargeScheme.minAmtException.label"),'default':("Min Amt Exception")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',115,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("minAmtException")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositTaxFeeAndChargeSchemeInstance?.description)) {
printHtmlPart(12)
invokeTag('message','g',120,['code':("depositTaxFeeAndChargeScheme.description.label"),'default':("Description")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',121,['bean':(depositTaxFeeAndChargeSchemeInstance),'field':("description")],-1)
printHtmlPart(14)
}
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-content")],2)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',130,['class':("list"),'action':("index")],3)
printHtmlPart(38)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',131,['class':("create"),'action':("create")],3)
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',133,['action':("edit"),'id':(depositTaxFeeAndChargeSchemeInstance.id)],3)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',135,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(43)
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
