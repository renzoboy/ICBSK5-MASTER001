import icbs.loans.LoanApplicationComaker
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loancreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/create.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'loan', action:'showLoanApplicationAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(7)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(loanInstance?.interestIncomeScheme?.id)
printHtmlPart(9)
expressionOut.print(loanInstance?.currentPenaltyScheme?.id)
printHtmlPart(10)
expressionOut.print(loanInstance?.pastDuePenaltyScheme?.id)
printHtmlPart(11)
expressionOut.print(createLink(controller :'loan', action:'getProductSchemesAjax'))
printHtmlPart(12)
expressionOut.print(session['installments']?.size())
printHtmlPart(13)
expressionOut.print(createLink(controller:'loan', 
			                      action:'getSchemeDetailsAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller :'customer', action:'showLoanApplicationAjax'))
printHtmlPart(15)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller:'loan', action:'addInstallmentAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'loan', action:'showAddInstallmentAjax'))
printHtmlPart(19)
expressionOut.print(createLink(controller: 'loan', action:'showImportInstallmentAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'loan', action:'updateInstallmentAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller:'loan', action:'showUpdateInstallmentAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller:'loan', action:'deleteInstallmentAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller:'loan', action:'showServiceChargesAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller:'loan', action:'addServiceChargeAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller:'loan', action:'showAddServiceChargeAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller:'loan', action:'updateServiceChargeAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller:'loan', action:'showUpdateServiceChargeAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller :'loan', action:'getAmortizedChargeSchemeInfoAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller:'loan', action:'deleteServiceChargeAjax'))
printHtmlPart(30)
expressionOut.print(createLink(controller:'loan', action:'showDeductionsAjax'))
printHtmlPart(31)
expressionOut.print(createLink(controller:'loan', action:'addDeductionAjax'))
printHtmlPart(32)
expressionOut.print(createLink(controller: 'loan', action:'showAddDeductionAjax'))
printHtmlPart(33)
expressionOut.print(createLink(controller:'loan', action:'showAddDeductionAjax'))
printHtmlPart(34)
expressionOut.print(createLink(controller:'loan', action:'updateDeductionAjax'))
printHtmlPart(35)
expressionOut.print(createLink(controller:'loan', action:'showUpdateDeductionAjax'))
printHtmlPart(36)
expressionOut.print(createLink(controller :'loan', action:'getTermAjax'))
printHtmlPart(37)
expressionOut.print(createLink(controller :'loan', action:'getDeductionSchemeInfoAjax'))
printHtmlPart(38)
expressionOut.print(createLink(controller:'loan', action:'deleteDeductionAjax'))
printHtmlPart(39)
expressionOut.print(createLink(controller:'loan', action:'showSweepAccountsAjax'))
printHtmlPart(40)
expressionOut.print(createLink(controller:'loan', action:'addSweepAccountAjax'))
printHtmlPart(41)
expressionOut.print(createLink(controller:'loan', action:'showAddSweepAccountAjax'))
printHtmlPart(42)
expressionOut.print(createLink(controller:'loan', action:'updateSweepAccountAjax'))
printHtmlPart(43)
expressionOut.print(createLink(controller:'loan', action:'showUpdateSweepAccountAjax'))
printHtmlPart(44)
expressionOut.print(createLink(controller:'loan', action:'deleteSweepAccountAjax'))
printHtmlPart(45)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(46)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(47)
expressionOut.print(createLink(controller:'loan',action:'importInstallmentss'))
printHtmlPart(48)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(49)
expressionOut.print(loanInstance?.loanApplication?.id ?: loanApplication?.id)
printHtmlPart(50)
})
invokeTag('javascript','g',1077,[:],2)
printHtmlPart(51)
})
invokeTag('captureHead','sitemesh',1078,[:],1)
printHtmlPart(52)
createTagBody(1, {->
printHtmlPart(53)
createClosureForHtmlPart(54, 2)
invokeTag('captureContent','sitemesh',1082,['tag':("breadcrumbs")],2)
printHtmlPart(53)
createTagBody(2, {->
printHtmlPart(55)
if(true && (flash.message)) {
printHtmlPart(56)
expressionOut.print(flash.message)
printHtmlPart(57)
}
printHtmlPart(58)
createTagBody(3, {->
printHtmlPart(59)
expressionOut.print(it)
printHtmlPart(60)
})
invokeTag('hasErrors','g',1102,['bean':(loanInstance)],3)
printHtmlPart(58)
createTagBody(3, {->
printHtmlPart(61)
invokeTag('render','g',1117,['template':("loanApplication/form")],-1)
printHtmlPart(62)
invokeTag('render','g',1120,['template':("specification/form")],-1)
printHtmlPart(63)
invokeTag('render','g',1123,['template':("classification/form")],-1)
printHtmlPart(64)
invokeTag('render','g',1126,['template':("serviceCharges/list")],-1)
printHtmlPart(65)
invokeTag('render','g',1129,['template':("deductions/list")],-1)
printHtmlPart(66)
invokeTag('render','g',1132,['template':("installments/list")],-1)
printHtmlPart(67)
})
invokeTag('form','g',1135,['id':("loan-form"),'url':([resource:loanInstance, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(68)
})
invokeTag('captureContent','sitemesh',1137,['tag':("main-content")],2)
printHtmlPart(53)
createTagBody(2, {->
printHtmlPart(69)
invokeTag('submitButton','g',1141,['id':("save"),'name':("save"),'value':("Save"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Save?')}');")],-1)
printHtmlPart(70)
invokeTag('submitButton','g',1158,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to create this Account?',
                                function(){
                                    checkIfAllowed('LON00500', 'form#loan-form', 'Open New Account', null);;
                                },
                                function(){
                                    return;
                                }); 
                        """)],-1)
printHtmlPart(71)
createClosureForHtmlPart(72, 3)
invokeTag('link','g',1159,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(73)
})
invokeTag('captureContent','sitemesh',1161,['tag':("main-actions")],2)
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',1162,[:],1)
printHtmlPart(74)
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
