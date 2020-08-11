import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenanceresidentTypeInstanceCreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/residentTypeInstanceCreate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/lovMaintenance'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('eachError','g',17,['bean':(residentTypeInstance),'var':("error")],4)
printHtmlPart(12)
})
invokeTag('hasErrors','g',19,['bean':(residentTypeInstance)],3)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('hiddenField','g',22,['name':("id"),'value':(residentTypeInstance?.id)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',23,['name':("version"),'value':(residentTypeInstance?.version)],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: residentTypeInstance, field: 'code', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',27,['code':("residentTypeInstance.code.label"),'default':("Code")],-1)
printHtmlPart(17)
invokeTag('textField','g',30,['name':("code"),'maxlength':("100"),'required':(""),'value':(residentTypeInstance?.code),'class':("form-control")],-1)
printHtmlPart(18)
createTagBody(4, {->
printHtmlPart(19)
createTagBody(5, {->
printHtmlPart(20)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',37,['bean':(residentTypeInstance),'field':("code")],5)
printHtmlPart(22)
})
invokeTag('hasErrors','g',40,['bean':(residentTypeInstance),'field':("code")],4)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: residentTypeInstance, field: 'description', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',45,['code':("residentTypeInstance.description.label"),'default':("Description")],-1)
printHtmlPart(17)
invokeTag('textField','g',48,['name':("description"),'maxlength':("100"),'required':(""),'value':(residentTypeInstance?.description),'class':("form-control")],-1)
printHtmlPart(18)
createTagBody(4, {->
printHtmlPart(19)
createTagBody(5, {->
printHtmlPart(25)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',55,['bean':(residentTypeInstance),'field':("description")],5)
printHtmlPart(22)
})
invokeTag('hasErrors','g',58,['bean':(residentTypeInstance),'field':("description")],4)
printHtmlPart(26)
invokeTag('hiddenField','g',61,['name':("status"),'value':("true")],-1)
printHtmlPart(27)
invokeTag('actionSubmit','g',63,['class':("btn btn-primary"),'action':("residentTypeInstanceSave"),'value':(message(code: 'default.button.created.label', default: 'Save')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to create this resident type?')}');")],-1)
printHtmlPart(28)
})
invokeTag('form','g',64,['controller':("lovMaintenance"),'action':("residentTypeInstanceSave")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',71,['action':("customerResidentTypeIndex")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(34)
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
