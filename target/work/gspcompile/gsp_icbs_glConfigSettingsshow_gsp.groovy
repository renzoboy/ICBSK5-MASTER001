import icbs.admin.GlConfigSettings
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glConfigSettingsshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glConfigSettings/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glConfigSettings.label', default: 'GlConfigSettings'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (glConfigSettingsInstance?.currency)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("glConfigSettings.currency.label"),'default':("Currency")],-1)
printHtmlPart(10)
createTagBody(4, {->
expressionOut.print(glConfigSettingsInstance?.currency?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("currency"),'action':("show"),'id':(glConfigSettingsInstance?.currency?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glConfigSettingsInstance?.revaluationPolicy)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("glConfigSettings.revaluationPolicy.label"),'default':("Revaluation Policy")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',31,['bean':(glConfigSettingsInstance),'field':("revaluationPolicy")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glConfigSettingsInstance?.taxMonthEnd)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("glConfigSettings.taxMonthEnd.label"),'default':("Tax Month End")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(glConfigSettingsInstance),'field':("taxMonthEnd")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glConfigSettingsInstance?.errorAcct)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("glConfigSettings.errorAcct.label"),'default':("Error Acct")],-1)
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(glConfigSettingsInstance?.errorAcct?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("glAccount"),'action':("show"),'id':(glConfigSettingsInstance?.errorAcct?.id)],4)
printHtmlPart(11)
}
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
createTagBody(4, {->
invokeTag('message','g',57,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',57,['class':("edit"),'action':("edit"),'resource':(glConfigSettingsInstance)],4)
printHtmlPart(21)
invokeTag('actionSubmit','g',58,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(22)
})
invokeTag('form','g',60,['url':([resource:glConfigSettingsInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(26)
invokeTag('message','g',65,['code':("default.home.label")],-1)
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',66,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',66,['class':("list"),'action':("index")],3)
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',67,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',67,['class':("create"),'action':("create")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(30)
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
