import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanreschedule_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(1)
if(true && (module == "loanRestructure")) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',9,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],3)
printHtmlPart(4)
}
else {
printHtmlPart(5)
createTagBody(3, {->
createClosureForHtmlPart(6, 4)
invokeTag('captureTitle','sitemesh',13,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],3)
printHtmlPart(4)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'loan', action:'showLoanApplicationAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(10)
expressionOut.print(loanInstance?.id)
printHtmlPart(11)
expressionOut.print(loanInstance?.interestIncomeScheme?.id)
printHtmlPart(12)
expressionOut.print(loanInstance?.currentPenaltyScheme?.id)
printHtmlPart(13)
expressionOut.print(loanInstance?.pastDuePenaltyScheme?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'getProductSchemesAjax'))
printHtmlPart(15)
expressionOut.print(session['installments']?.size())
printHtmlPart(16)
expressionOut.print(createLink(controller:'loan', 
			                      action:'getSchemeDetailsAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller :'customer', action:'showLoanApplicationAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'loan', action:'addInstallmentAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller: 'loan', action:'showAddInstallmentAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller: 'loan', action:'showImportInstallmentAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller:'loan', action:'updateInstallmentAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller:'loan', action:'showUpdateInstallmentAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller:'loan', action:'deleteInstallmentAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller:'loan', action:'showServiceChargesAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller:'loan', action:'addServiceChargeAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller:'loan', action:'showAddServiceChargeAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller:'loan', action:'updateServiceChargeAjax'))
printHtmlPart(30)
expressionOut.print(createLink(controller:'loan', action:'showUpdateServiceChargeAjax'))
printHtmlPart(31)
expressionOut.print(createLink(controller :'loan', action:'getAmortizedChargeSchemeInfoAjax'))
printHtmlPart(32)
expressionOut.print(createLink(controller:'loan', action:'deleteServiceChargeAjax'))
printHtmlPart(33)
expressionOut.print(createLink(controller:'loan', action:'showDeductionsAjax'))
printHtmlPart(34)
expressionOut.print(createLink(controller:'loan', action:'addDeductionAjax'))
printHtmlPart(35)
expressionOut.print(createLink(controller: 'loan', action:'showAddDeductionAjax'))
printHtmlPart(36)
expressionOut.print(createLink(controller:'loan', action:'showAddDeductionAjax'))
printHtmlPart(37)
expressionOut.print(createLink(controller:'loan', action:'updateDeductionAjax'))
printHtmlPart(38)
expressionOut.print(createLink(controller:'loan', action:'showUpdateDeductionAjax'))
printHtmlPart(39)
expressionOut.print(createLink(controller :'loan', action:'getTermAjax'))
printHtmlPart(40)
expressionOut.print(createLink(controller :'loan', action:'getDeductionSchemeInfoAjax'))
printHtmlPart(41)
expressionOut.print(createLink(controller:'loan', action:'deleteDeductionAjax'))
printHtmlPart(42)
expressionOut.print(createLink(controller:'loan', action:'showSweepAccountsAjax'))
printHtmlPart(43)
expressionOut.print(createLink(controller:'loan', action:'addSweepAccountAjax'))
printHtmlPart(44)
expressionOut.print(createLink(controller:'loan', action:'showAddSweepAccountAjax'))
printHtmlPart(45)
expressionOut.print(createLink(controller:'loan', action:'updateSweepAccountAjax'))
printHtmlPart(46)
expressionOut.print(createLink(controller:'loan', action:'showUpdateSweepAccountAjax'))
printHtmlPart(47)
expressionOut.print(createLink(controller:'loan', action:'deleteSweepAccountAjax'))
printHtmlPart(48)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(49)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(50)
expressionOut.print(createLink(controller:'loan',action:'importInstallmentss'))
printHtmlPart(51)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(52)
expressionOut.print(loanInstance?.loanApplication?.id ?: loanApplication?.id)
printHtmlPart(53)
})
invokeTag('javascript','g',1171,[:],2)
printHtmlPart(54)
})
invokeTag('captureHead','sitemesh',1172,[:],1)
printHtmlPart(55)
createTagBody(1, {->
printHtmlPart(56)
createClosureForHtmlPart(57, 2)
invokeTag('captureContent','sitemesh',1176,['tag':("breadcrumbs")],2)
printHtmlPart(56)
createTagBody(2, {->
printHtmlPart(58)
if(true && (flash.message)) {
printHtmlPart(59)
expressionOut.print(flash.message)
printHtmlPart(60)
}
printHtmlPart(61)
createTagBody(3, {->
printHtmlPart(62)
expressionOut.print(module)
printHtmlPart(63)
})
invokeTag('hasErrors','g',1204,['bean':(loanInstance)],3)
printHtmlPart(61)
createTagBody(3, {->
printHtmlPart(64)
invokeTag('hiddenField','g',1207,['name':("version"),'value':(loanInstance?.version)],-1)
printHtmlPart(65)
if(true && (module == "loanReschedule" && ((loanInstance?.loanPerformanceId.id == 1 || loanInstance?.loanPerformanceId.id == 5 || loanInstance?.loanPerformanceId.id == 6) && loanInstance?.status?.id == 4))) {
printHtmlPart(66)
invokeTag('hiddenField','g',1209,['name':("activity"),'value':("Reschedule")],-1)
printHtmlPart(65)
}
else {
printHtmlPart(66)
invokeTag('hiddenField','g',1212,['name':("activity"),'value':("Restructure")],-1)
printHtmlPart(65)
}
printHtmlPart(67)
invokeTag('set','g',1233,['var':("reschedule"),'value':(true)],-1)
printHtmlPart(68)
invokeTag('render','g',1235,['template':("loanApplication/form")],-1)
printHtmlPart(69)
invokeTag('render','g',1238,['template':("specification/form")],-1)
printHtmlPart(70)
invokeTag('render','g',1241,['template':("classification/form")],-1)
printHtmlPart(71)
invokeTag('render','g',1245,['template':("serviceCharges/list")],-1)
printHtmlPart(72)
invokeTag('render','g',1250,['template':("deductions/list")],-1)
printHtmlPart(73)
invokeTag('render','g',1254,['template':("installments/list")],-1)
printHtmlPart(74)
})
invokeTag('form','g',1258,['id':("loan-form"),'url':([resource:loanInstance, action:'update']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(75)
})
invokeTag('captureContent','sitemesh',1260,['tag':("main-content")],2)
printHtmlPart(56)
createTagBody(2, {->
printHtmlPart(76)
if(true && (module == "loanRestructure" && (loanInstance?.loanPerformanceId.id == 2 || loanInstance?.loanPerformanceId.id == 3))) {
printHtmlPart(77)
}
else if(true && (module == "loanReschedule" && ((loanInstance?.loanPerformanceId.id == 1 || loanInstance?.loanPerformanceId.id == 5 || loanInstance?.loanPerformanceId.id == 6 ) && loanInstance?.status?.id == 4))) {
printHtmlPart(78)
}
printHtmlPart(79)
expressionOut.print(module)
printHtmlPart(80)
expressionOut.print(loanInstance.id)
printHtmlPart(81)
})
invokeTag('captureContent','sitemesh',1311,['tag':("main-actions")],2)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',1312,[:],1)
printHtmlPart(82)
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
