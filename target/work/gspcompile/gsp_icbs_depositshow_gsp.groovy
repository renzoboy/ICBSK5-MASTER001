import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'deposit.label', default: 'Deposit'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(3)
expressionOut.print(depositInstance?.acctNo)
})
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
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(11)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(depositInstance?.customer?.customerId)
})
invokeTag('link','g',38,['controller':("customer"),'action':("customerInquiry"),'id':(depositInstance?.customer?.id)],3)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(depositInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',42,['controller':("branch"),'action':("show"),'id':(depositInstance?.branch?.id)],3)
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(depositInstance?.type?.encodeAsHTML())
})
invokeTag('link','g',46,['controller':("depositType"),'action':("show"),'id':(depositInstance?.type?.id)],3)
printHtmlPart(17)
invokeTag('fieldValue','g',50,['bean':(depositInstance),'field':("acctNo")],-1)
printHtmlPart(18)
if(true && (depositInstance?.acctNoFormat)) {
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(depositInstance?.acctNoFormat?.encodeAsHTML())
})
invokeTag('link','g',55,['controller':("acctNoFormat"),'action':("show"),'id':(depositInstance?.acctNoFormat?.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.ownershipType)) {
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(depositInstance?.ownershipType?.encodeAsHTML())
})
invokeTag('link','g',61,['controller':("ownershipType"),'action':("show"),'id':(depositInstance?.ownershipType?.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.sigRules)) {
printHtmlPart(23)
invokeTag('fieldValue','g',67,['bean':(depositInstance),'field':("sigRules")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.sigRemarks)) {
printHtmlPart(24)
invokeTag('fieldValue','g',73,['bean':(depositInstance),'field':("sigRemarks")],-1)
printHtmlPart(20)
}
printHtmlPart(25)
if(true && (depositInstance?.signatories)) {
printHtmlPart(26)
for( s in (depositInstance.signatories) ) {
printHtmlPart(27)
createTagBody(5, {->
expressionOut.print(s.id)
})
invokeTag('link','g',80,['controller':("signatory"),'action':("show"),'id':(s.id)],5)
printHtmlPart(28)
}
printHtmlPart(29)
}
printHtmlPart(21)
if(true && (depositInstance?.depositInterestScheme)) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(depositInstance?.depositInterestScheme?.encodeAsHTML())
})
invokeTag('link','g',87,['controller':("depositInterestScheme"),'action':("show"),'id':(depositInstance?.depositInterestScheme?.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.depositTaxChargeScheme)) {
printHtmlPart(31)
createTagBody(4, {->
expressionOut.print(depositInstance?.depositTaxChargeScheme?.encodeAsHTML())
})
invokeTag('link','g',93,['controller':("depositTaxFeeAndChargeScheme"),'action':("show"),'id':(depositInstance?.depositTaxChargeScheme?.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.fixedDepositPreTermScheme)) {
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(depositInstance?.fixedDepositPreTermScheme?.encodeAsHTML())
})
invokeTag('link','g',99,['controller':("fixedDepositPreTermScheme"),'action':("show"),'id':(depositInstance?.fixedDepositPreTermScheme?.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.dateOpened)) {
printHtmlPart(33)
invokeTag('formatDate','g',105,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.dateClosed)) {
printHtmlPart(34)
invokeTag('formatDate','g',111,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateClosed)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (depositInstance?.status)) {
printHtmlPart(35)
createTagBody(4, {->
expressionOut.print(depositInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',117,['controller':("depositStatus"),'action':("show"),'id':(depositInstance?.status?.id)],4)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.statusChangeDate)) {
printHtmlPart(37)
invokeTag('formatDate','g',123,['format':("MM/dd/yyyy"),'date':(depositInstance?.statusChangeDate)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.ledgerBalAmt)) {
printHtmlPart(38)
invokeTag('fieldValue','g',129,['bean':(depositInstance),'field':("ledgerBalAmt")],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.availableBalAmt)) {
printHtmlPart(39)
invokeTag('formatNumber','g',135,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(36)
}
printHtmlPart(40)
if(true && (depositInstance?.passbookBalAmt)) {
printHtmlPart(41)
invokeTag('formatNumber','g',141,['format':("###,###,##0.00"),'number':(depositInstance?.passbookBalAmt)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.interestBalAmt)) {
printHtmlPart(42)
invokeTag('formatNumber','g',147,['format':("###,###,##0.00"),'number':(depositInstance?.interestBalAmt)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.lmAveBalAmt)) {
printHtmlPart(43)
invokeTag('formatNumber','g',153,['format':("###,###,##0.00"),'number':(depositInstance?.lmAveBalAmt)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.interestRate)) {
printHtmlPart(44)
invokeTag('formatNumber','g',159,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(45)
}
printHtmlPart(21)
if(true && (depositInstance?.acrintAmt)) {
printHtmlPart(46)
invokeTag('formatNumber','g',165,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.acrintDate)) {
printHtmlPart(47)
invokeTag('formatDate','g',171,['date':(depositInstance?.acrintDate)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.debitAcrintAmt)) {
printHtmlPart(48)
invokeTag('fieldValue','g',177,['bean':(depositInstance),'field':("debitAcrintAmt")],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.debitAcrintDate)) {
printHtmlPart(49)
invokeTag('formatDate','g',183,['format':("MM/dd/yyyy"),'date':(depositInstance?.debitAcrintDate)],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.passbooks)) {
printHtmlPart(50)
for( p in (depositInstance.passbooks) ) {
printHtmlPart(51)
createTagBody(5, {->
expressionOut.print(s?.encodeAsHTML())
})
invokeTag('link','g',191,['controller':("passbook"),'action':("show"),'id':(p.id)],5)
printHtmlPart(52)
}
printHtmlPart(53)
}
printHtmlPart(21)
if(true && (depositInstance?.txnWithdrawalsCounterMonthly)) {
printHtmlPart(54)
invokeTag('fieldValue','g',198,['bean':(depositInstance),'field':("txnWithdrawalsCounterMonthly")],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.txnWithdrawalsCounterCummulative)) {
printHtmlPart(55)
invokeTag('fieldValue','g',204,['bean':(depositInstance),'field':("txnWithdrawalsCounterCummulative")],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.lastCapitalizationDate)) {
printHtmlPart(56)
invokeTag('formatDate','g',210,['format':("MM/dd/yyyy"),'date':(depositInstance?.lastCapitalizationDate)],-1)
printHtmlPart(36)
}
printHtmlPart(40)
if(true && (depositInstance?.currency)) {
printHtmlPart(57)
invokeTag('fieldValue','g',216,['bean':(depositInstance),'field':("currency")],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.isSweep)) {
printHtmlPart(58)
invokeTag('formatBoolean','g',222,['boolean':(depositInstance?.isSweep)],-1)
printHtmlPart(36)
}
printHtmlPart(40)
if(true && (depositInstance?.txnDepCounterCummulative)) {
printHtmlPart(59)
invokeTag('fieldValue','g',228,['bean':(depositInstance),'field':("txnDepCounterCummulative")],-1)
printHtmlPart(36)
}
printHtmlPart(21)
if(true && (depositInstance?.txnDepCounterMonthly)) {
printHtmlPart(60)
invokeTag('fieldValue','g',234,['bean':(depositInstance),'field':("txnDepCounterMonthly")],-1)
printHtmlPart(36)
}
printHtmlPart(61)
createTagBody(3, {->
printHtmlPart(62)
createTagBody(4, {->
invokeTag('message','g',249,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',249,['class':("edit"),'action':("edit"),'resource':(depositInstance)],4)
printHtmlPart(63)
invokeTag('actionSubmit','g',250,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(64)
})
invokeTag('form','g',252,['url':([resource:depositInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(65)
})
invokeTag('captureContent','sitemesh',255,['tag':("main-content")],2)
printHtmlPart(66)
createTagBody(2, {->
printHtmlPart(67)
createClosureForHtmlPart(68, 3)
invokeTag('link','g',258,['action':("depositInquiry"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(69)
createTagBody(3, {->
invokeTag('message','g',259,['code':("default.button.edit.label"),'default':("Edit")],-1)
printHtmlPart(70)
})
invokeTag('link','g',259,['class':("edit"),'action':("edit"),'resource':(depositInstance)],3)
printHtmlPart(71)
})
invokeTag('captureContent','sitemesh',261,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',262,[:],1)
printHtmlPart(72)
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
