import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenancefirmSizeInstanceEdit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/firmSizeInstanceEdit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'firmSize.label', default: 'FirmSize'))],-1)
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
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',19,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',20,['bean':(firmSizeInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',22,['bean':(firmSizeInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',33,['name':("id"),'value':(firmSizeInstance?.id)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',34,['name':("version"),'value':(firmSizeInstance?.version)],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: firmSizeInstance, field: 'code', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',38,['code':("firmSizeInstance.code.label"),'default':("Code")],-1)
printHtmlPart(22)
invokeTag('textField','g',41,['name':("code"),'maxlength':("100"),'required':(""),'value':(firmSizeInstance?.code),'class':("form-control")],-1)
printHtmlPart(23)
createTagBody(4, {->
printHtmlPart(24)
createTagBody(5, {->
printHtmlPart(25)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',48,['bean':(firmSizeInstance),'field':("code")],5)
printHtmlPart(27)
})
invokeTag('hasErrors','g',51,['bean':(firmSizeInstance),'field':("code")],4)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: firmSizeInstance, field: 'description', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',56,['code':("frimSizeInstance.description.label"),'default':("Description")],-1)
printHtmlPart(22)
invokeTag('textField','g',59,['name':("description"),'maxlength':("100"),'required':(""),'value':(firmSizeInstance?.description),'class':("form-control")],-1)
printHtmlPart(23)
createTagBody(4, {->
printHtmlPart(24)
createTagBody(5, {->
printHtmlPart(25)
invokeTag('message','g',65,['error':(it)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',66,['bean':(firmSizeInstance),'field':("description")],5)
printHtmlPart(27)
})
invokeTag('hasErrors','g',69,['bean':(firmSizeInstance),'field':("description")],4)
printHtmlPart(30)
invokeTag('actionSubmit','g',74,['class':("btn btn-primary"),'action':("firmSizeInstanceUpdate"),'value':(message(code: 'default.button.save.label', default: 'Save')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to update this firm size?')}');")],-1)
printHtmlPart(31)
})
invokeTag('form','g',75,['controller':("lovMaintenance"),'action':("firmSIzeInstanceUpdate")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',83,['action':("sizeOfFirmIndex")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(37)
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
