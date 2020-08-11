import icbs.loans.LoanConfigSettings
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanConfigSettingsedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanConfigSettings/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loanConfigSettings.label', default: 'LoanConfigSettings'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(7)
createTagBody(4, {->
printHtmlPart(8)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(9)
expressionOut.print(error.field)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',17,['error':(error)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',18,['bean':(loanConfigSettings),'var':("error")],4)
printHtmlPart(13)
})
invokeTag('hasErrors','g',20,['bean':(loanConfigSettings)],3)
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'interestDecimalPlaces', 'error'))
printHtmlPart(15)
invokeTag('message','g',25,['code':("loanConfigSettings.interestDecimalPlaces.label"),'default':("Interest Decimal Places")],-1)
printHtmlPart(16)
invokeTag('field','g',28,['class':("form-control"),'name':("interestDecimalPlaces"),'type':("number"),'value':(loanConfigSettings.interestDecimalPlaces),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'penaltyDecimalPlaces', 'error'))
printHtmlPart(18)
invokeTag('message','g',33,['code':("loanConfigSettings.penaltyDecimalPlaces.label"),'default':("Penalty Decimal Places")],-1)
printHtmlPart(16)
invokeTag('field','g',36,['class':("form-control"),'name':("penaltyDecimalPlaces"),'type':("number"),'value':(loanConfigSettings.penaltyDecimalPlaces),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'taxDecimalPlaces', 'error'))
printHtmlPart(19)
invokeTag('message','g',41,['code':("loanConfigSettings.taxDecimalPlaces.label"),'default':("Tax Decimal Places")],-1)
printHtmlPart(16)
invokeTag('field','g',44,['class':("form-control"),'name':("taxDecimalPlaces"),'type':("number"),'value':(loanConfigSettings.taxDecimalPlaces),'required':("")],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'hasApplicationProcessing', 'error'))
printHtmlPart(21)
invokeTag('message','g',49,['code':("loanConfigSettings.hasApplicationProcessing.label"),'default':("Activate Loan Application Processing")],-1)
printHtmlPart(22)
invokeTag('checkBox','g',52,['class':("form-control"),'name':("hasApplicationProcessing"),'value':(loanConfigSettings?.hasApplicationProcessing)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'applicationRegistrationKey', 'error'))
printHtmlPart(23)
invokeTag('message','g',57,['code':("loanConfigSettings.applicationRegistrationKey.label"),'default':("Loan Application Registration Key")],-1)
printHtmlPart(16)
invokeTag('textField','g',60,['class':("form-control"),'name':("applicationRegistrationKey"),'maxlength':("10"),'required':(""),'value':(loanConfigSettings?.applicationRegistrationKey)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'applicationLicenseKey', 'error'))
printHtmlPart(24)
invokeTag('message','g',65,['code':("loanConfigSettings.applicationLicenseKey.label"),'default':("Loan Application License Key")],-1)
printHtmlPart(16)
invokeTag('textField','g',68,['class':("form-control"),'name':("applicationLicenseKey"),'maxlength':("10"),'required':(""),'value':(loanConfigSettings?.applicationLicenseKey)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'hasRemediationProcessing', 'error'))
printHtmlPart(25)
invokeTag('message','g',73,['code':("loanConfigSettings.hasRemediationProcessing.label"),'default':("Activate Loan Remediation Processing")],-1)
printHtmlPart(22)
invokeTag('checkBox','g',76,['class':("form-control"),'name':("hasRemediationProcessing"),'value':(loanConfigSettings?.hasRemediationProcessing)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'remediationRegistrationKey', 'error'))
printHtmlPart(26)
invokeTag('message','g',81,['code':("loanConfigSettings.remediationRegistrationKey.label"),'default':("Loan Remediation Registration Key")],-1)
printHtmlPart(16)
invokeTag('textField','g',84,['class':("form-control"),'name':("remediationRegistrationKey"),'maxlength':("10"),'required':(""),'value':(loanConfigSettings?.remediationRegistrationKey)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanConfigSettings, field: 'remediationLicenseKey', 'error'))
printHtmlPart(27)
invokeTag('message','g',89,['code':("loanConfigSettings.remediationLicenseKey.label"),'default':("Loan Remediation License Key")],-1)
printHtmlPart(16)
invokeTag('textField','g',92,['class':("form-control"),'name':("remediationLicenseKey"),'maxlength':("10"),'required':(""),'value':(loanConfigSettings?.remediationLicenseKey)],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',95,['name':("update"),'value':("true")],-1)
printHtmlPart(29)
invokeTag('actionSubmit','g',98,['class':("btn btn-primary save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(30)
})
invokeTag('form','g',100,['action':("update"),'method':("PUT")],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-content")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(31)
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
