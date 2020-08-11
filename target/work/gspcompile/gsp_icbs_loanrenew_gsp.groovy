import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanrenew_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/renew.gsp" }
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
if(true && (module == 'loanRenewal')) {
printHtmlPart(2)
createTagBody(3, {->
createTagBody(4, {->
printHtmlPart(3)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(4)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(5)
})
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(6)
}
else if(true && (module == 'loanROPA')) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(7, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(6)
}
printHtmlPart(1)
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
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'loan', action:'addInstallmentAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller: 'loan', action:'showAddInstallmentAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller:'loan', action:'updateInstallmentAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller:'loan', action:'showUpdateInstallmentAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller:'loan', action:'deleteInstallmentAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller:'loan', action:'showServiceChargesAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller:'loan', action:'addServiceChargeAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller:'loan', action:'showAddServiceChargeAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller:'loan', action:'updateServiceChargeAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller:'loan', action:'showUpdateServiceChargeAjax'))
printHtmlPart(30)
expressionOut.print(createLink(controller :'loan', action:'getAmortizedChargeSchemeInfoAjax'))
printHtmlPart(31)
expressionOut.print(createLink(controller:'loan', action:'deleteServiceChargeAjax'))
printHtmlPart(32)
expressionOut.print(createLink(controller:'loan', action:'showDeductionsAjax'))
printHtmlPart(33)
expressionOut.print(createLink(controller:'loan', action:'addDeductionAjax'))
printHtmlPart(34)
expressionOut.print(createLink(controller: 'loan', action:'showAddDeductionAjax'))
printHtmlPart(35)
expressionOut.print(createLink(controller:'loan', action:'showAddDeductionAjax'))
printHtmlPart(36)
expressionOut.print(createLink(controller:'loan', action:'updateDeductionAjax'))
printHtmlPart(37)
expressionOut.print(createLink(controller:'loan', action:'showUpdateDeductionAjax'))
printHtmlPart(38)
expressionOut.print(createLink(controller :'loan', action:'getTermAjax'))
printHtmlPart(39)
expressionOut.print(createLink(controller :'loan', action:'getDeductionSchemeInfoAjax'))
printHtmlPart(40)
expressionOut.print(createLink(controller:'loan', action:'deleteDeductionAjax'))
printHtmlPart(41)
expressionOut.print(createLink(controller:'loan', action:'showSweepAccountsAjax'))
printHtmlPart(42)
expressionOut.print(createLink(controller:'loan', action:'addSweepAccountAjax'))
printHtmlPart(43)
expressionOut.print(createLink(controller:'loan', action:'showAddSweepAccountAjax'))
printHtmlPart(44)
expressionOut.print(createLink(controller:'loan', action:'updateSweepAccountAjax'))
printHtmlPart(45)
expressionOut.print(createLink(controller:'loan', action:'showUpdateSweepAccountAjax'))
printHtmlPart(46)
expressionOut.print(createLink(controller:'loan', action:'deleteSweepAccountAjax'))
printHtmlPart(47)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(48)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(49)
expressionOut.print(loanInstance?.loanApplication?.id)
printHtmlPart(50)
})
invokeTag('javascript','g',883,[:],2)
printHtmlPart(51)
})
invokeTag('captureHead','sitemesh',884,[:],1)
printHtmlPart(52)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(53, 2)
invokeTag('captureContent','sitemesh',888,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(54)
if(true && (flash.message)) {
printHtmlPart(55)
expressionOut.print(flash.message)
printHtmlPart(56)
}
printHtmlPart(57)
createTagBody(3, {->
printHtmlPart(58)
expressionOut.print(module)
printHtmlPart(59)
})
invokeTag('hasErrors','g',916,['bean':(loanInstance)],3)
printHtmlPart(57)
createTagBody(3, {->
printHtmlPart(60)
invokeTag('hiddenField','g',919,['name':("version"),'value':(loanInstance?.version)],-1)
printHtmlPart(60)
invokeTag('hiddenField','g',920,['name':("activity"),'value':("Renewal")],-1)
printHtmlPart(61)
invokeTag('hiddenField','g',921,['name':("loanInstance"),'value':(loanInstance?.id)],-1)
printHtmlPart(62)
invokeTag('render','g',935,['template':("loanApplication/form")],-1)
printHtmlPart(63)
invokeTag('render','g',938,['template':("specification/form")],-1)
printHtmlPart(64)
invokeTag('render','g',941,['template':("classification/form")],-1)
printHtmlPart(65)
invokeTag('render','g',944,['template':("serviceCharges/list")],-1)
printHtmlPart(66)
invokeTag('render','g',947,['template':("deductions/listRenew")],-1)
printHtmlPart(67)
invokeTag('render','g',950,['template':("installments/list")],-1)
printHtmlPart(68)
invokeTag('render','g',953,['template':("sweep/list")],-1)
printHtmlPart(69)
})
invokeTag('form','g',956,['id':("loan-form"),'url':([resource:loanInstance, action:'saveNew']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(70)
})
invokeTag('captureContent','sitemesh',958,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(71)
invokeTag('submitButton','g',973,['name':("save"),'value':("Save"),'onclick':("""   
                    if(${loanInstance?.interestIncomeScheme?.id} == null)
                    {
                        notify.message('Unable to continue transaction. No interest scheme!|error|alert');return;   
                    }    
                    alertify.confirm(AppTitle,'Are you sure you want to create this transaction?',
                    function(){
                        jQuery('#loan-form').submit()
                    },
                    function(){
                        return;
                    });                        
                    """)],-1)
printHtmlPart(72)
createClosureForHtmlPart(73, 3)
invokeTag('link','g',974,['controller':("loan"),'action':("index"),'id':(loanInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(74)
})
invokeTag('captureContent','sitemesh',976,['tag':("main-actions")],2)
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',977,[:],1)
printHtmlPart(75)
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
