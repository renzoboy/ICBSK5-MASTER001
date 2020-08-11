import icbs.loans.LoanConfigSettings
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanConfigSettingsindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanConfigSettings/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loanConfigSettings.label', default: 'LoanConfigSettings'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',17,['code':("loanConfigSettings.interestDecimalPlaces.label"),'default':("Interest Decimal Places")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',19,['bean':(loanConfigSettings),'field':("interestDecimalPlaces")],-1)
printHtmlPart(10)
invokeTag('message','g',23,['code':("loanConfigSettings.penaltyDecimalPlaces.label"),'default':("Penalty Decimal Places")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',25,['bean':(loanConfigSettings),'field':("penaltyDecimalPlaces")],-1)
printHtmlPart(12)
invokeTag('message','g',29,['code':("loanConfigSettings.taxDecimalPlaces.label"),'default':("Tax Decimal Places")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',31,['bean':(loanConfigSettings),'field':("taxDecimalPlaces")],-1)
printHtmlPart(14)
invokeTag('message','g',35,['code':("loanConfigSettings.hasApplicationProcessing.label"),'default':("Activate Loan Application Processing")],-1)
printHtmlPart(15)
invokeTag('formatBoolean','g',37,['boolean':(loanConfigSettings?.hasApplicationProcessing)],-1)
printHtmlPart(16)
invokeTag('message','g',41,['code':("loanConfigSettings.applicationRegistrationKey.label"),'default':("Loan Application Registration Key")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',43,['bean':(loanConfigSettings),'field':("applicationRegistrationKey")],-1)
printHtmlPart(18)
invokeTag('message','g',47,['code':("loanConfigSettings.applicationLicenseKey.label"),'default':("Loan Application License Key")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',49,['bean':(loanConfigSettings),'field':("applicationLicenseKey")],-1)
printHtmlPart(20)
invokeTag('message','g',53,['code':("loanConfigSettings.hasRemediationProcessing.label"),'default':("Activate Loan Remediation Processing")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',55,['boolean':(loanConfigSettings?.hasRemediationProcessing)],-1)
printHtmlPart(22)
invokeTag('message','g',59,['code':("loanConfigSettings.remediationRegistrationKey.label"),'default':("Loan Remediation Registration Key")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',61,['bean':(loanConfigSettings),'field':("remediationRegistrationKey")],-1)
printHtmlPart(24)
invokeTag('message','g',65,['code':("loanConfigSettings.remediationLicenseKey.label"),'default':("Loan Remediation License Key")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',67,['bean':(loanConfigSettings),'field':("remediationLicenseKey")],-1)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',71,['class':("btn btn-primary edit"),'action':("edit")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(29)
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
