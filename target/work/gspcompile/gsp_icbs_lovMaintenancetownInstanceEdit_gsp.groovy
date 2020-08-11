import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenancetownInstanceEdit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/townInstanceEdit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'town.label', default: 'Town'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/lovMaintenance'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
createTagBody(4, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',19,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',20,['bean':(townInstance),'var':("error")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',22,['bean':(townInstance)],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',33,['name':("id"),'value':(townInstance?.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',34,['name':("version"),'value':(townInstance?.version)],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: townInstance, field: 'code', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',38,['code':("townInstance.code.label"),'default':("Code")],-1)
printHtmlPart(21)
invokeTag('textField','g',41,['name':("code"),'maxlength':("100"),'required':(""),'value':(townInstance?.code),'class':("form-control")],-1)
printHtmlPart(22)
createTagBody(4, {->
printHtmlPart(23)
createTagBody(5, {->
printHtmlPart(24)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',48,['bean':(townInstance),'field':("code")],5)
printHtmlPart(26)
})
invokeTag('hasErrors','g',51,['bean':(townInstance),'field':("code")],4)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: townInstance, field: 'description', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',56,['code':("townTypeInstance.description.label"),'default':("Description")],-1)
printHtmlPart(21)
invokeTag('textField','g',59,['name':("description"),'maxlength':("100"),'required':(""),'value':(townInstance?.description),'class':("form-control")],-1)
printHtmlPart(22)
createTagBody(4, {->
printHtmlPart(23)
createTagBody(5, {->
printHtmlPart(24)
invokeTag('message','g',65,['error':(it)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',66,['bean':(townInstance),'field':("description")],5)
printHtmlPart(26)
})
invokeTag('hasErrors','g',69,['bean':(townInstance),'field':("description")],4)
printHtmlPart(29)
invokeTag('actionSubmit','g',74,['class':("btn btn-primary"),'action':("townInstanceUpdate"),'value':(message(code: 'default.button.save.label', default: 'Save')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to update this town?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',75,['controller':("lovMaintenance"),'action':("townInstanceUpdate")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',83,['action':("townAndMunicipalityIndex")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(36)
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
