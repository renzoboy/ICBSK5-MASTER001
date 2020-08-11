import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inquirydepositInquiry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inquiry/depositInquiry.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createClosureForHtmlPart(5, 2)
invokeTag('javascript','g',12,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(8, 2)
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('render','g',20,['template':("inquiry/depositInquiryForm")],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(14)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(15)
}
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',52,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',55,['action':("depositSearch")],3)
printHtmlPart(19)
if(true && (!params?.module)) {
printHtmlPart(20)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 5)
invokeTag('link','g',59,['action':("depositViewMoreInformation"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(26, 5)
invokeTag('link','g',65,['class':("edit"),'action':("edit"),'resource':(depositInstance)],5)
printHtmlPart(23)
}
else {
printHtmlPart(27)
}
printHtmlPart(25)
if(true && (depositInstance?.type?.id == 2)) {
printHtmlPart(21)
createClosureForHtmlPart(28, 5)
invokeTag('link','g',71,['action':("viewCheckbook"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(29)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(30)
if(true && (depositInstance?.branch?.id == UserMaster?.get(session.user_id)?.branch?.id)) {
printHtmlPart(31)
createClosureForHtmlPart(32, 6)
invokeTag('link','g',78,['action':("viewPassbook"),'id':(depositInstance.id)],6)
printHtmlPart(33)
}
else {
printHtmlPart(34)
}
printHtmlPart(25)
}
else {
printHtmlPart(35)
}
printHtmlPart(25)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(21)
createClosureForHtmlPart(36, 5)
invokeTag('link','g',88,['action':("viewCTD"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(37)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(38, 5)
invokeTag('link','g',94,['action':("viewHold"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(39)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(40)
createClosureForHtmlPart(41, 5)
invokeTag('link','g',101,['action':("viewStandingOrder"),'id':(depositInstance.id)],5)
printHtmlPart(42)
}
else {
printHtmlPart(43)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(44, 5)
invokeTag('link','g',109,['action':("viewMemo"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(45)
}
printHtmlPart(20)
if(true && (depositInstance?.product?.productType.id!=1 && depositInstance?.product?.productType.id!=3)) {
printHtmlPart(21)
createClosureForHtmlPart(46, 5)
invokeTag('link','g',116,['action':("viewStopPaymentOrder"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(47)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(48)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(31)
createClosureForHtmlPart(49, 6)
invokeTag('link','g',123,['action':("viewDepositStatus"),'id':(depositInstance.id)],6)
printHtmlPart(50)
}
else {
printHtmlPart(51)
createClosureForHtmlPart(52, 6)
invokeTag('link','g',126,['action':("viewDepositStatus"),'id':(depositInstance.id)],6)
printHtmlPart(50)
}
printHtmlPart(25)
}
else {
printHtmlPart(53)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(54, 5)
invokeTag('link','g',133,['action':("viewInterestRateMaintenance"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(55)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(56, 5)
invokeTag('link','g',139,['action':("viewSweep"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(57)
}
printHtmlPart(25)
if(true && (depositInstance?.status?.id == 6)) {
printHtmlPart(58)
}
else {
printHtmlPart(21)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',148,['action':("viewFundTransfer"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(21)
createClosureForHtmlPart(60, 5)
invokeTag('link','g',151,['action':("viewClearChecksManually"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(61)
}
printHtmlPart(25)
if(true && (depositInstance?.type?.id == 3)) {
printHtmlPart(21)
createClosureForHtmlPart(62, 5)
invokeTag('link','g',157,['action':("viewManualFdRollover"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(63)
}
printHtmlPart(25)
if(true && (depositInstance)) {
printHtmlPart(64)
}
else {
printHtmlPart(65)
}
printHtmlPart(66)
}
else {
printHtmlPart(25)
if(true && (depositInstance&&params.module=="edit")) {
printHtmlPart(21)
createClosureForHtmlPart(26, 5)
invokeTag('link','g',172,['class':("edit"),'action':("edit"),'resource':(depositInstance)],5)
printHtmlPart(23)
}
printHtmlPart(67)
if(true && (depositInstance&&params.module=="checkbook")) {
printHtmlPart(21)
createClosureForHtmlPart(28, 5)
invokeTag('link','g',176,['action':("viewCheckbook"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (depositInstance&&params.module=="passbook")) {
printHtmlPart(21)
createClosureForHtmlPart(32, 5)
invokeTag('link','g',180,['action':("viewPassbook"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(20)
if(true && (depositInstance&&params.module=="ctd"&&depositInstance?.type?.id==3)) {
printHtmlPart(21)
createClosureForHtmlPart(68, 5)
invokeTag('link','g',184,['action':("viewCTD"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(67)
if(true && (depositInstance&&params.module=="hold")) {
printHtmlPart(21)
createClosureForHtmlPart(38, 5)
invokeTag('link','g',188,['action':("viewHold"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(67)
if(true && (depositInstance&&params.module=="standingorder")) {
printHtmlPart(40)
createClosureForHtmlPart(41, 5)
invokeTag('link','g',193,['action':("viewStandingOrder"),'id':(depositInstance.id)],5)
printHtmlPart(42)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="memo")) {
printHtmlPart(21)
createClosureForHtmlPart(44, 5)
invokeTag('link','g',198,['action':("viewMemo"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="spo")) {
printHtmlPart(21)
createClosureForHtmlPart(46, 5)
invokeTag('link','g',201,['action':("viewStopPaymentOrder"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(67)
if(true && (depositInstance&&params.module=="close")) {
printHtmlPart(48)
if(true && (depositInstance?.status?.id!=7)) {
printHtmlPart(31)
createClosureForHtmlPart(49, 6)
invokeTag('link','g',206,['action':("viewDepositStatus"),'id':(depositInstance.id)],6)
printHtmlPart(50)
}
else {
printHtmlPart(51)
createClosureForHtmlPart(52, 6)
invokeTag('link','g',209,['action':("viewDepositStatus"),'id':(depositInstance.id)],6)
printHtmlPart(50)
}
printHtmlPart(25)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="irm")) {
printHtmlPart(21)
createClosureForHtmlPart(54, 5)
invokeTag('link','g',213,['action':("viewInterestRateMaintenance"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="sweep")) {
printHtmlPart(21)
createClosureForHtmlPart(56, 5)
invokeTag('link','g',216,['action':("viewSweep"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="fundtransfer")) {
printHtmlPart(21)
createClosureForHtmlPart(59, 5)
invokeTag('link','g',219,['action':("viewFundTransfer"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="clearchecksmanually")) {
printHtmlPart(21)
createClosureForHtmlPart(60, 5)
invokeTag('link','g',222,['action':("viewClearChecksManually"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(25)
if(true && (depositInstance&&params.module=="manualfdrollover"&&depositInstance?.type?.id==3)) {
printHtmlPart(21)
createClosureForHtmlPart(62, 5)
invokeTag('link','g',225,['action':("viewManualFdRollover"),'id':(depositInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(69)
}
printHtmlPart(66)
if(true && (depositInstance&&params.module=="transferDepositBranch")) {
printHtmlPart(70)
createClosureForHtmlPart(71, 4)
invokeTag('link','g',230,['action':("createTransferDepositBranch"),'id':(depositInstance.id)],4)
printHtmlPart(72)
}
printHtmlPart(73)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(74)
invokeTag('message','g',232,['code':("default.home.label")],-1)
printHtmlPart(75)
})
invokeTag('captureContent','sitemesh',234,['tag':("main-actions")],2)
printHtmlPart(76)
})
invokeTag('captureBody','sitemesh',235,[:],1)
printHtmlPart(77)
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
