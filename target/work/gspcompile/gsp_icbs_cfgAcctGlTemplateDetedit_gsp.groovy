import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDetedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(cfgAcctGlTemplateDetInstance?.glDescription.encodeAsHTML())
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
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
invokeTag('message','g',21,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',22,['bean':(cfgAcctGlTemplateDetInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',24,['bean':(cfgAcctGlTemplateDetInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',26,['name':("version"),'value':(cfgAcctGlTemplateDetInstance?.version)],-1)
printHtmlPart(19)
invokeTag('render','g',28,['template':("form")],-1)
printHtmlPart(20)
})
invokeTag('form','g',30,['url':([resource:cfgAcctGlTemplateDetInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',31,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('actionSubmit','g',36,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',38,['action':("show"),'id':(cfgAcctGlTemplateDetInstance.id)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',38,['tag':("main-actions")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',39,[:],1)
printHtmlPart(27)
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
