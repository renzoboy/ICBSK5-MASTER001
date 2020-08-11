import icbs.deposit.DepositInterestScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemechangeInt_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/changeInt.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
invokeTag('javascript','asset',8,['src':("depositHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'depositInterestScheme', action:'addGraduatedFormAjax'))
printHtmlPart(5)
})
invokeTag('javascript','g',23,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',35,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',36,['bean':(depositInterestSchemeInstance),'var':("error")],4)
printHtmlPart(18)
})
invokeTag('hasErrors','g',39,['bean':(depositInterestSchemeInstance)],3)
printHtmlPart(19)
if(true && (depositInterestSchemeInstance?.code)) {
printHtmlPart(20)
invokeTag('message','g',44,['code':("depositInterestScheme.code.label"),'default':("Code")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',45,['bean':(depositInterestSchemeInstance),'field':("code")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (depositInterestSchemeInstance?.name)) {
printHtmlPart(24)
invokeTag('message','g',51,['code':("depositInterestScheme.name.label"),'default':("Name")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',52,['bean':(depositInterestSchemeInstance),'field':("name")],-1)
printHtmlPart(22)
}
printHtmlPart(26)
if(true && (depositInterestSchemeInstance?.depositInterestStart)) {
printHtmlPart(24)
invokeTag('message','g',57,['code':("depositInterestScheme.depositInterestStart.label"),'default':("Deposit Interest Start")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',58,['bean':(depositInterestSchemeInstance),'field':("depositInterestStart.description")],-1)
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.interestRate)) {
printHtmlPart(29)
invokeTag('message','g',63,['code':("depositInterestScheme.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(30)
invokeTag('formatNumber','g',64,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.interestRate)],-1)
printHtmlPart(31)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.divisor)) {
printHtmlPart(32)
invokeTag('message','g',69,['code':("depositInterestScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',70,['bean':(depositInterestSchemeInstance),'field':("divisor")],-1)
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.minInterestRate)) {
printHtmlPart(34)
invokeTag('message','g',75,['code':("depositInterestScheme.minInterestRate.label"),'default':("Min Interest Rate")],-1)
printHtmlPart(35)
invokeTag('formatNumber','g',76,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.minInterestRate)],-1)
printHtmlPart(31)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.maxInterestRate)) {
printHtmlPart(36)
invokeTag('message','g',81,['code':("depositInterestScheme.maxInterestRate.label"),'default':("Max Interest Rate")],-1)
printHtmlPart(37)
invokeTag('formatNumber','g',82,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(31)
}
printHtmlPart(26)
if(true && (depositInterestSchemeInstance?.fdPostMaturityRate)) {
printHtmlPart(29)
invokeTag('message','g',87,['code':("depositInterestScheme.fdPostMaturityRate.label"),'default':("FD Post Maturity Interest Rate")],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',88,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.fdPostMaturityRate)],-1)
printHtmlPart(31)
}
printHtmlPart(39)
if(true && (depositInterestSchemeInstance?.fdMonthlyTransfer)) {
printHtmlPart(40)
invokeTag('message','g',93,['code':("depositInterestScheme.fdMonthlyTransfer.label"),'default':("FD Monthly Transfer")],-1)
printHtmlPart(41)
invokeTag('formatBoolean','g',94,['boolean':(depositInterestSchemeInstance?.fdMonthlyTransfer)],-1)
printHtmlPart(22)
}
printHtmlPart(42)
if(true && (depositInterestSchemeInstance?.minBalanceToEarnInterest)) {
printHtmlPart(43)
invokeTag('message','g',99,['code':("depositInterestScheme.minBalanceToEarnInterest.label"),'default':("Min Balance To Earn Interest")],-1)
printHtmlPart(44)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(depositInterestSchemeInstance?.minBalanceToEarnInterest)],-1)
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.canChangeInterestRate)) {
printHtmlPart(45)
invokeTag('message','g',105,['code':("depositInterestScheme.canChangeInterestRate.label"),'default':("Can Change Interest Rate")],-1)
printHtmlPart(46)
invokeTag('formatBoolean','g',106,['boolean':(depositInterestSchemeInstance?.canChangeInterestRate)],-1)
printHtmlPart(22)
}
printHtmlPart(26)
if(true && (depositInterestSchemeInstance?.isAccrual)) {
printHtmlPart(47)
invokeTag('message','g',111,['code':("depositInterestScheme.isAccrual.label"),'default':("Is Accrual")],-1)
printHtmlPart(48)
invokeTag('formatBoolean','g',112,['boolean':(depositInterestSchemeInstance?.isAccrual)],-1)
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.depositCapitalizationFreq)) {
printHtmlPart(49)
invokeTag('message','g',117,['code':("depositInterestScheme.depositCapitalizationFreq.label"),'default':("Deposit Capitalization Freq")],-1)
printHtmlPart(50)
expressionOut.print(depositInterestSchemeInstance?.depositCapitalizationFreq?.encodeAsHTML())
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.depositInterestCalculation)) {
printHtmlPart(51)
invokeTag('message','g',123,['code':("depositInterestScheme.depositInterestCalculation.label"),'default':("Deposit Interest Calculation:")],-1)
printHtmlPart(52)
expressionOut.print(depositInterestSchemeInstance?.depositInterestCalculation.description)
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.status)) {
printHtmlPart(53)
invokeTag('message','g',129,['code':("depositInterestScheme.status.label"),'default':("Status")],-1)
printHtmlPart(54)
expressionOut.print(depositInterestSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(22)
}
printHtmlPart(28)
if(true && (depositInterestSchemeInstance?.isGraduated)) {
printHtmlPart(55)
invokeTag('message','g',135,['code':("depositInterestScheme.isGraduated.label"),'default':("Is Graduated")],-1)
printHtmlPart(56)
invokeTag('formatBoolean','g',136,['boolean':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(22)
}
printHtmlPart(57)
for( product in (depositInterestSchemeInstance.products) ) {
printHtmlPart(58)
expressionOut.print(product.name)
printHtmlPart(59)
}
printHtmlPart(60)
createTagBody(3, {->
printHtmlPart(61)
invokeTag('hiddenField','g',149,['name':("version"),'value':(depositInterestSchemeInstance?.version)],-1)
printHtmlPart(62)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'interestRate', 'has-error'))
printHtmlPart(63)
invokeTag('message','g',154,['code':("depositInterestScheme.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(64)
invokeTag('field','g',157,['name':("interestRate"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'interestRate')),'class':("form-control")],-1)
printHtmlPart(65)
createTagBody(4, {->
printHtmlPart(66)
createTagBody(5, {->
printHtmlPart(67)
invokeTag('message','g',162,['error':(it)],-1)
printHtmlPart(68)
})
invokeTag('eachError','g',163,['bean':(depositInterestSchemeInstance),'field':("interestRate")],5)
printHtmlPart(69)
})
invokeTag('hasErrors','g',166,['bean':(depositInterestSchemeInstance),'field':("interestRate")],4)
printHtmlPart(70)
if(true && (depositInterestSchemeInstance?.isGraduated==true)) {
printHtmlPart(71)
invokeTag('render','g',172,['template':("form/graduated/graduatedInfo")],-1)
printHtmlPart(72)
}
printHtmlPart(28)
})
invokeTag('form','g',175,['id':("DepositInterestSchemeForm"),'url':([resource:depositInterestSchemeInstance, action:'saveIntRate']),'method':("PUT")],3)
printHtmlPart(73)
})
invokeTag('captureContent','sitemesh',177,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(74)
invokeTag('submitButton','g',180,['name':("saveIntRate"),'id':("saveIntRate"),'value':(message(code: 'default.button.update.label', default: 'Change Interest Rate')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Save?')}');")],-1)
printHtmlPart(75)
createClosureForHtmlPart(76, 3)
invokeTag('link','g',182,['class':("list"),'action':("show"),'id':(depositInterestSchemeInstance.id)],3)
printHtmlPart(77)
})
invokeTag('captureContent','sitemesh',191,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',192,[:],1)
printHtmlPart(78)
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
