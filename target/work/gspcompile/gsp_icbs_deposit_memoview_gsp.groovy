import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_memoview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/memo/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'changeMemoFormAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller : 'deposit', action:'changeMemoFormAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'deposit', action:'changeMemoFormAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(9)
})
invokeTag('javascript','g',70,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',71,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(11, 2)
invokeTag('captureContent','sitemesh',75,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (flash.errors)) {
printHtmlPart(16)
expressionOut.print(it)
printHtmlPart(17)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
})
invokeTag('hasErrors','g',115,['bean':(billsPaymentInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(20)
})
invokeTag('hasErrors','g',123,['bean':(remittanceInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(it)
printHtmlPart(19)
})
invokeTag('hasErrors','g',133,['bean':(adjustmentInstance)],3)
printHtmlPart(21)
invokeTag('render','g',136,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(22)
invokeTag('render','g',140,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(23)
if(true && (depositInstance.type.id == 3)) {
printHtmlPart(24)
invokeTag('render','g',146,['template':("/deposit/details/fdDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(25)
}
printHtmlPart(26)
loop:{
int i = 0
for( domainInstance in (TxnFileInstance) ) {
printHtmlPart(27)
expressionOut.print(domainInstance?.id)
printHtmlPart(28)
expressionOut.print(domainInstance?.txnDate?.format("MM/dd/yyyy"))
printHtmlPart(29)
expressionOut.print(domainInstance?.txnType)
printHtmlPart(29)
expressionOut.print(domainInstance?.user?.username)
printHtmlPart(30)
invokeTag('formatNumber','g',174,['number':(domainInstance?.txnAmt),'format':("###,##0.00")],-1)
printHtmlPart(31)
expressionOut.print(domainInstance?.currency?.code)
printHtmlPart(32)
expressionOut.print(domainInstance?.txnRef)
printHtmlPart(33)
if(true && (domainInstance?.txnType?.id == 9)) {
printHtmlPart(34)
}
printHtmlPart(35)
if(true && (domainInstance?.txnType?.id == 7)) {
printHtmlPart(36)
}
printHtmlPart(37)
i++
}
}
printHtmlPart(38)
invokeTag('paginate','g',200,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',205,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(40)
invokeTag('hiddenField','g',208,['id':("depositIdx"),'name':("depositIdx"),'value':(depositInstance.id)],-1)
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',209,['action':("#"),'data-toggle':("modal"),'data-target':("#modalMemoDebit"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',210,['action':("#"),'data-toggle':("modal"),'data-target':("#modalMemoCreedit"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(43)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',211,['action':("depositDebitMemoBills"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(43)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',212,['action':("depositDebitMemoRem"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(43)
createClosureForHtmlPart(47, 3)
invokeTag('link','g',213,['action':("depositCreditMemoRem"),'id':(depositInstance.id),'resource':(depositInstance)],3)
printHtmlPart(48)
expressionOut.print(depositInstance?.id)
printHtmlPart(49)
if(true && (flash.message == "Memo Adjustment successfully made.|success|alert")) {
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (flash.message == "Memo Remittance Successfully made.|success|alert")) {
printHtmlPart(52)
}
printHtmlPart(51)
if(true && (flash.message == "Bills Payment Successfully made.|success|alert")) {
printHtmlPart(53)
}
printHtmlPart(54)
createTagBody(3, {->
printHtmlPart(55)
invokeTag('hiddenField','g',266,['id':("type"),'name':("type"),'value':("1")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',267,['id':("acct"),'name':("acct.id"),'value':(adjustmentInstance?.acct?.id?:depositInstance?.id)],-1)
printHtmlPart(56)
invokeTag('hiddenField','g',270,['id':("typeDebit"),'name':("typeDebit"),'value':("1")],-1)
printHtmlPart(57)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(58)
invokeTag('select','g',273,['id':("txnTemplateDebit"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(59)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(60)
invokeTag('textField','g',278,['id':("AjustmentAmtDebit"),'name':("amt"),'value':(adjustmentInstance?.amt),'class':("form-control truncated")],-1)
printHtmlPart(61)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(62)
invokeTag('textField','g',283,['id':("AdjustRefDebit"),'name':("txnRef"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(63)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(64)
invokeTag('textField','g',287,['id':("txnDescriptionssDebit"),'name':("txnDescription"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(65)
if(true && (flash.message == "Memo Adjustment successfully made.|success|alert")) {
printHtmlPart(66)
}
printHtmlPart(67)
createClosureForHtmlPart(68, 4)
invokeTag('javascript','g',342,[:],4)
printHtmlPart(69)
})
invokeTag('form','g',346,['name':("adjustmentMemoDebitFormSend"),'id':("adjustmentMemoDebitFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],3)
printHtmlPart(70)
createTagBody(3, {->
printHtmlPart(71)
invokeTag('hiddenField','g',361,['id':("type"),'name':("type"),'value':("2")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',362,['id':("acct"),'name':("acct.id"),'value':(adjustmentInstance?.acct?.id?:depositInstance?.id)],-1)
printHtmlPart(72)
invokeTag('hiddenField','g',365,['id':("typeCredit"),'name':("typeCredit"),'value':("2")],-1)
printHtmlPart(57)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(58)
invokeTag('select','g',368,['id':("txnTemplateCredit"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(9),icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':("1"),'class':("form-control")],-1)
printHtmlPart(61)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(60)
invokeTag('textField','g',373,['id':("AjustmentAmtCredit"),'name':("amt"),'value':(adjustmentInstance?.amt),'class':("form-control truncated")],-1)
printHtmlPart(63)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(62)
invokeTag('textField','g',377,['id':("AdjustRefCredit"),'name':("txnRef"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(63)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(64)
invokeTag('textField','g',381,['id':("txnDescriptionssCredit"),'name':("txnDescription"),'value':(adjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(73)
if(true && (flash.message == "Memo Adjustment successfully made.|success|alert")) {
printHtmlPart(74)
}
printHtmlPart(67)
createClosureForHtmlPart(75, 4)
invokeTag('javascript','g',437,[:],4)
printHtmlPart(76)
})
invokeTag('form','g',442,['name':("adjustmentMemoCreditFormSend"),'id':("adjustmentMemoCreditFormSend"),'controller':("deposit"),'action':("saveMemoAdjustment")],3)
printHtmlPart(77)
})
invokeTag('captureContent','sitemesh',447,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',448,[:],1)
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
