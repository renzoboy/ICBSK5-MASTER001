import icbs.admin.Form
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_formshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'form.label', default: 'Form'))],-1)
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
expressionOut.print(createLink(uri: '/form'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (formInstance?.name)) {
printHtmlPart(12)
invokeTag('message','g',24,['code':("form.name.label"),'default':("Name")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',26,['bean':(formInstance),'field':("name")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (formInstance?.sourceFile)) {
printHtmlPart(16)
invokeTag('message','g',33,['code':("form.sourceFile.label"),'default':("Source File")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',35,['bean':(formInstance),'field':("sourceFile")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (formInstance?.configItemStatus)) {
printHtmlPart(18)
invokeTag('message','g',42,['code':("form.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(19)
expressionOut.print(formInstance?.configItemStatus?.description)
printHtmlPart(14)
}
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('form','g',51,['id':("show"),'url':([resource:formInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(23)
createClosureForHtmlPart(24, 2)
invokeTag('captureContent','sitemesh',57,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(25)
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
