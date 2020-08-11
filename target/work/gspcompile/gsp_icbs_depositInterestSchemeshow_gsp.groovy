import icbs.deposit.DepositInterestScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/depositInterestScheme'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (depositInterestSchemeInstance?.code)) {
printHtmlPart(14)
invokeTag('message','g',49,['code':("depositInterestScheme.code.label"),'default':("Code")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',50,['bean':(depositInterestSchemeInstance),'field':("code")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (depositInterestSchemeInstance?.name)) {
printHtmlPart(18)
invokeTag('message','g',55,['code':("depositInterestScheme.name.label"),'default':("Name")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',56,['bean':(depositInterestSchemeInstance),'field':("name")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.depositInterestStart)) {
printHtmlPart(18)
invokeTag('message','g',61,['code':("depositInterestScheme.depositInterestStart.label"),'default':("Deposit Interest Start")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',62,['bean':(depositInterestSchemeInstance),'field':("depositInterestStart.description")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (depositInterestSchemeInstance?.interestRate)) {
printHtmlPart(24)
invokeTag('message','g',67,['code':("depositInterestScheme.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',68,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.interestRate)],-1)
printHtmlPart(26)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.divisor)) {
printHtmlPart(27)
invokeTag('message','g',73,['code':("depositInterestScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',74,['bean':(depositInterestSchemeInstance),'field':("divisor")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.minInterestRate)) {
printHtmlPart(29)
invokeTag('message','g',79,['code':("depositInterestScheme.minInterestRate.label"),'default':("Min Interest Rate")],-1)
printHtmlPart(30)
invokeTag('formatNumber','g',80,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.minInterestRate)],-1)
printHtmlPart(31)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.maxInterestRate)) {
printHtmlPart(32)
invokeTag('message','g',85,['code':("depositInterestScheme.maxInterestRate.label"),'default':("Max Interest Rate")],-1)
printHtmlPart(33)
invokeTag('formatNumber','g',86,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(31)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.fdPostMaturityRate)) {
printHtmlPart(24)
invokeTag('message','g',91,['code':("depositInterestScheme.fdPostMaturityRate.label"),'default':("FD Post Maturity Interest Rate")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',92,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.fdPostMaturityRate)],-1)
printHtmlPart(31)
}
printHtmlPart(34)
if(true && (depositInterestSchemeInstance?.fdMonthlyTransfer)) {
printHtmlPart(35)
invokeTag('message','g',97,['code':("depositInterestScheme.fdMonthlyTransfer.label"),'default':("FD Monthly Transfer")],-1)
printHtmlPart(36)
invokeTag('formatBoolean','g',98,['boolean':(depositInterestSchemeInstance?.fdMonthlyTransfer)],-1)
printHtmlPart(37)
}
printHtmlPart(23)
if(true && (depositInterestSchemeInstance?.minBalanceToEarnInterest)) {
printHtmlPart(38)
invokeTag('message','g',103,['code':("depositInterestScheme.minBalanceToEarnInterest.label"),'default':("Min Balance To Earn Interest")],-1)
printHtmlPart(39)
invokeTag('formatNumber','g',104,['format':("###,###,##0.00"),'number':(depositInterestSchemeInstance?.minBalanceToEarnInterest)],-1)
printHtmlPart(40)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.canChangeInterestRate)) {
printHtmlPart(41)
invokeTag('message','g',110,['code':("depositInterestScheme.canChangeInterestRate.label"),'default':("Can Change Interest Rate")],-1)
printHtmlPart(42)
invokeTag('formatBoolean','g',111,['boolean':(depositInterestSchemeInstance?.canChangeInterestRate)],-1)
printHtmlPart(37)
}
printHtmlPart(43)
if(true && (depositInterestSchemeInstance?.isAccrual)) {
printHtmlPart(44)
invokeTag('message','g',116,['code':("depositInterestScheme.isAccrual.label"),'default':("Is Accrual")],-1)
printHtmlPart(45)
invokeTag('formatBoolean','g',117,['boolean':(depositInterestSchemeInstance?.isAccrual)],-1)
printHtmlPart(37)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.depositCapitalizationFreq)) {
printHtmlPart(46)
invokeTag('message','g',122,['code':("depositInterestScheme.depositCapitalizationFreq.label"),'default':("Deposit Capitalization Freq")],-1)
printHtmlPart(47)
expressionOut.print(depositInterestSchemeInstance?.depositCapitalizationFreq?.encodeAsHTML())
printHtmlPart(37)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.depositInterestCalculation)) {
printHtmlPart(48)
invokeTag('message','g',128,['code':("depositInterestScheme.depositInterestCalculation.label"),'default':("Deposit Interest Calculation:")],-1)
printHtmlPart(49)
expressionOut.print(depositInterestSchemeInstance?.depositInterestCalculation.description)
printHtmlPart(37)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.status)) {
printHtmlPart(50)
invokeTag('message','g',134,['code':("depositInterestScheme.status.label"),'default':("Status")],-1)
printHtmlPart(51)
expressionOut.print(depositInterestSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(37)
}
printHtmlPart(21)
if(true && (depositInterestSchemeInstance?.isGraduated)) {
printHtmlPart(52)
invokeTag('message','g',140,['code':("depositInterestScheme.isGraduated.label"),'default':("Is Graduated")],-1)
printHtmlPart(53)
invokeTag('formatBoolean','g',141,['boolean':(depositInterestSchemeInstance?.isGraduated)],-1)
printHtmlPart(37)
}
printHtmlPart(54)
invokeTag('sortableColumn','g',152,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(55)
invokeTag('sortableColumn','g',153,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(56)
loop:{
int i = 0
for( product in (depositInterestSchemeInstance.products) ) {
printHtmlPart(57)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(58)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',159,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(59)
expressionOut.print(product.name)
printHtmlPart(60)
i++
}
}
printHtmlPart(61)
})
invokeTag('captureContent','sitemesh',170,['tag':("main-content")],2)
printHtmlPart(62)
createTagBody(2, {->
printHtmlPart(63)
createClosureForHtmlPart(64, 3)
invokeTag('link','g',173,['class':("list"),'action':("index")],3)
printHtmlPart(65)
createClosureForHtmlPart(66, 3)
invokeTag('link','g',174,['class':("create"),'action':("create")],3)
printHtmlPart(67)
if(true && (depositInterestSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(68)
createClosureForHtmlPart(69, 4)
invokeTag('link','g',177,['action':("edit"),'controller':("DepositInterestScheme"),'id':(depositInterestSchemeInstance.id)],4)
printHtmlPart(70)
}
printHtmlPart(3)
if(true && (depositInterestSchemeInstance.status.id == 1)) {
printHtmlPart(71)
createTagBody(4, {->
printHtmlPart(72)
invokeTag('actionSubmit','g',181,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(73)
})
invokeTag('form','g',182,['url':([id:depositInterestSchemeInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(70)
}
printHtmlPart(74)
if(true && (depositInterestSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(68)
createClosureForHtmlPart(72, 4)
invokeTag('form','g',187,['id':("deleteDepositInterestSchemeForm"),'url':([id:depositInterestSchemeInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(72)
invokeTag('actionSubmit','g',196,['id':("deleteDepositIntScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01004', 'form#deleteDepositInterestSchemeForm', 'Override edit Deposit Interest Scheme.', null); 
                                },
                                function(){
                                    return;
                                });                                
                            """)],-1)
printHtmlPart(75)
}
printHtmlPart(68)
createClosureForHtmlPart(76, 3)
invokeTag('link','g',199,['action':("changeInt"),'controller':("DepositInterestScheme"),'id':(depositInterestSchemeInstance.id)],3)
printHtmlPart(77)
})
invokeTag('captureContent','sitemesh',210,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',211,[:],1)
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
