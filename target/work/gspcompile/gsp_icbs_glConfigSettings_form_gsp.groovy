import icbs.admin.GlConfigSettings
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glConfigSettings_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glConfigSettings/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: glConfigSettingsInstance, field: 'currency', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("glConfigSettings.currency.label"),'default':("Currency")],-1)
printHtmlPart(2)
invokeTag('select','g',11,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'required':(""),'value':(glConfigSettingsInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(glConfigSettingsInstance),'field':("currency")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(glConfigSettingsInstance),'field':("currency")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glConfigSettingsInstance, field: 'revaluationPolicy', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("glConfigSettings.revaluationPolicy.label"),'default':("Revaluation Policy")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("revaluationPolicy"),'required':(""),'value':(glConfigSettingsInstance?.revaluationPolicy),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(glConfigSettingsInstance),'field':("revaluationPolicy")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(glConfigSettingsInstance),'field':("revaluationPolicy")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glConfigSettingsInstance, field: 'taxMonthEnd', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("glConfigSettings.taxMonthEnd.label"),'default':("Tax Month End")],-1)
printHtmlPart(2)
invokeTag('field','g',51,['name':("taxMonthEnd"),'type':("number"),'value':(glConfigSettingsInstance.taxMonthEnd),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(glConfigSettingsInstance),'field':("taxMonthEnd")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(glConfigSettingsInstance),'field':("taxMonthEnd")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glConfigSettingsInstance, field: 'errorAcct', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',68,['code':("glConfigSettings.errorAcct.label"),'default':("Error Acct")],-1)
printHtmlPart(2)
invokeTag('select','g',71,['id':("errorAcct"),'name':("errorAcct.id"),'from':(icbs.gl.GlAccount.list()),'optionKey':("id"),'required':(""),'value':(glConfigSettingsInstance?.errorAcct?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(glConfigSettingsInstance),'field':("errorAcct")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(glConfigSettingsInstance),'field':("errorAcct")],1)
printHtmlPart(12)
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
