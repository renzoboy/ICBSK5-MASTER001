import icbs.admin.GlConfigSettings
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glConfigSettingsedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glConfigSettings/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glConfigSettings.label', default: 'LoanConfigSettings'))],-1)
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
invokeTag('eachError','g',18,['bean':(glConfigSettings),'var':("error")],4)
printHtmlPart(13)
})
invokeTag('hasErrors','g',20,['bean':(glConfigSettings)],3)
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(14)
expressionOut.print(hasErrors(bean: glConfigSettings, field: 'currency', 'error'))
printHtmlPart(15)
invokeTag('message','g',26,['code':("glConfigSettings.currency.label"),'default':("Currency:")],-1)
printHtmlPart(16)
invokeTag('field','g',29,['class':("form-control"),'name':("currency"),'value':(glConfigSettings.currency),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: glConfigSettings, field: 'taxMonthEnd', 'error'))
printHtmlPart(18)
invokeTag('message','g',34,['code':("glConfigSettings.taxMonthEnd.label"),'default':("Tax Month End:")],-1)
printHtmlPart(16)
invokeTag('field','g',37,['class':("form-control"),'name':("taxMonthEnd"),'type':("number"),'value':(glConfigSettings.taxMonthEnd),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: glConfigSettings, field: 'glSortCodeMask', 'error'))
printHtmlPart(19)
invokeTag('message','g',42,['code':("glConfigSettings.glSortCodeMask.label"),'default':("GL Sort Code Mask:")],-1)
printHtmlPart(16)
invokeTag('field','g',45,['class':("form-control"),'name':("glSortCodeMask"),'value':(glConfigSettings.glSortCodeMask),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: glConfigSettings, field: 'glAccountCodeMask', 'error'))
printHtmlPart(20)
invokeTag('message','g',50,['code':("glConfigSettings.glAccountCodeMask.label"),'default':("Account Sort Code Mask:")],-1)
printHtmlPart(16)
invokeTag('field','g',53,['class':("form-control"),'name':("glAccountCodeMask"),'value':(glConfigSettings.glAccountCodeMask),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: glConfigSettings, field: 'revaluationPolicy', 'error'))
printHtmlPart(21)
invokeTag('message','g',58,['code':("glConfigSettings.revaluationPolicy.label"),'default':("Revaluation Policy:")],-1)
printHtmlPart(16)
invokeTag('field','g',61,['class':("form-control"),'name':("revaluationPolicy"),'value':(glConfigSettings.revaluationPolicy),'required':("")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: glConfigSettings, field: 'errorAccount', 'error'))
printHtmlPart(22)
invokeTag('message','g',66,['code':("glConfigSettings.errorAccount.label"),'default':("Error Account:")],-1)
printHtmlPart(16)
invokeTag('field','g',69,['class':("form-control"),'name':("errorAccount"),'value':(glConfigSettings.errorAccount),'required':("")],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',72,['name':("update"),'value':("true")],-1)
printHtmlPart(24)
invokeTag('actionSubmit','g',75,['class':("btn btn-primary save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(25)
})
invokeTag('form','g',77,['action':("update"),'method':("PUT")],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-content")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(26)
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
