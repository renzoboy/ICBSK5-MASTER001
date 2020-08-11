import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanwriteOff_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/writeOff.gsp" }
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
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'loan', action:'showLoanApplicationAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(6)
expressionOut.print(loanInstance?.id)
printHtmlPart(7)
expressionOut.print(loanInstance?.interestIncomeScheme?.id)
printHtmlPart(8)
expressionOut.print(loanInstance?.currentPenaltyScheme?.id)
printHtmlPart(9)
expressionOut.print(loanInstance?.pastDuePenaltyScheme?.id)
printHtmlPart(10)
expressionOut.print(createLink(controller :'loan', action:'getProductSchemesAjax'))
printHtmlPart(11)
expressionOut.print(session['installments']?.size())
printHtmlPart(12)
expressionOut.print(createLink(controller:'loan', 
			                      action:'getSchemeDetailsAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'loan', action:'showInstallmentsAjax'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'loan', action:'addInstallmentAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller: 'loan', action:'showAddInstallmentAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller:'loan', action:'updateInstallmentAjax'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'loan', action:'showUpdateInstallmentAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'loan', action:'deleteInstallmentAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller:'loan', action:'showServiceChargesAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller:'loan', action:'addServiceChargeAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller:'loan', action:'showAddServiceChargeAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller:'loan', action:'updateServiceChargeAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller:'loan', action:'showUpdateServiceChargeAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller :'loan', action:'getAmortizedChargeSchemeInfoAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller:'loan', action:'deleteServiceChargeAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller:'loan', action:'showDeductionsAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller:'loan', action:'addDeductionAjax'))
printHtmlPart(30)
expressionOut.print(createLink(controller: 'loan', action:'showAddDeductionAjax'))
printHtmlPart(31)
expressionOut.print(createLink(controller:'loan', action:'showAddDeductionAjax'))
printHtmlPart(32)
expressionOut.print(createLink(controller:'loan', action:'updateDeductionAjax'))
printHtmlPart(33)
expressionOut.print(createLink(controller:'loan', action:'showUpdateDeductionAjax'))
printHtmlPart(34)
expressionOut.print(createLink(controller :'loan', action:'getTermAjax'))
printHtmlPart(35)
expressionOut.print(createLink(controller :'loan', action:'getDeductionSchemeInfoAjax'))
printHtmlPart(36)
expressionOut.print(createLink(controller:'loan', action:'deleteDeductionAjax'))
printHtmlPart(37)
expressionOut.print(createLink(controller:'loan', action:'showSweepAccountsAjax'))
printHtmlPart(38)
expressionOut.print(createLink(controller:'loan', action:'addSweepAccountAjax'))
printHtmlPart(39)
expressionOut.print(createLink(controller:'loan', action:'showAddSweepAccountAjax'))
printHtmlPart(40)
expressionOut.print(createLink(controller:'loan', action:'updateSweepAccountAjax'))
printHtmlPart(41)
expressionOut.print(createLink(controller:'loan', action:'showUpdateSweepAccountAjax'))
printHtmlPart(42)
expressionOut.print(createLink(controller:'loan', action:'deleteSweepAccountAjax'))
printHtmlPart(43)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(44)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(45)
expressionOut.print(loanInstance?.loanApplication?.id)
printHtmlPart(46)
})
invokeTag('javascript','g',866,[:],2)
printHtmlPart(47)
})
invokeTag('captureHead','sitemesh',867,[:],1)
printHtmlPart(47)
createTagBody(1, {->
printHtmlPart(48)
createClosureForHtmlPart(49, 2)
invokeTag('captureContent','sitemesh',871,['tag':("breadcrumbs")],2)
printHtmlPart(48)
createTagBody(2, {->
printHtmlPart(50)
if(true && (flash.message)) {
printHtmlPart(51)
expressionOut.print(flash.message)
printHtmlPart(52)
}
printHtmlPart(53)
createTagBody(3, {->
printHtmlPart(54)
expressionOut.print(module)
printHtmlPart(55)
})
invokeTag('hasErrors','g',899,['bean':(loanInstance)],3)
printHtmlPart(53)
createTagBody(3, {->
printHtmlPart(56)
invokeTag('hiddenField','g',902,['name':("version"),'value':(loanInstance?.version)],-1)
printHtmlPart(56)
invokeTag('hiddenField','g',903,['name':("activity"),'value':("Write-Off")],-1)
printHtmlPart(57)
invokeTag('set','g',916,['var':("writeOff"),'value':(true)],-1)
printHtmlPart(58)
invokeTag('render','g',918,['template':("loanApplication/form")],-1)
printHtmlPart(59)
invokeTag('render','g',921,['template':("specification/form")],-1)
printHtmlPart(60)
invokeTag('render','g',924,['template':("classification/form")],-1)
printHtmlPart(61)
invokeTag('render','g',927,['template':("serviceCharges/list")],-1)
printHtmlPart(62)
invokeTag('render','g',930,['template':("deductions/list")],-1)
printHtmlPart(63)
invokeTag('render','g',933,['template':("installments/list")],-1)
printHtmlPart(64)
invokeTag('render','g',936,['template':("sweep/list")],-1)
printHtmlPart(65)
})
invokeTag('form','g',939,['id':("loan-form"),'url':([resource:loanInstance, action:'update']),'method':("PUT"),'onsubmit':("return alertify.alert('Please wait... Processing....')")],3)
printHtmlPart(66)
})
invokeTag('captureContent','sitemesh',941,['tag':("main-content")],2)
printHtmlPart(48)
createTagBody(2, {->
printHtmlPart(67)
invokeTag('submitButton','g',952,['name':("save"),'value':("Save"),'onclick':("""    
                    alertify.confirm(AppTitle,'Are you sure you want to create this transaction?',
                    function(){
                        jQuery('#loan-form').submit()
                    },
                    function(){
                        return;
                    });                        
                    """)],-1)
printHtmlPart(68)
createClosureForHtmlPart(69, 3)
invokeTag('link','g',953,['controller':(module),'action':("show"),'id':(loanInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(70)
})
invokeTag('captureContent','sitemesh',955,['tag':("main-actions")],2)
printHtmlPart(47)
})
invokeTag('captureBody','sitemesh',956,[:],1)
printHtmlPart(71)
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
