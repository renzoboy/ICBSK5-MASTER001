import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glSortCodecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glSortCode/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'glSortCode.label', default: 'GlSortCode'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',23,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',24,['bean':(glSortCodeInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',26,['bean':(glSortCodeInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('render','g',29,['template':("form")],-1)
printHtmlPart(17)
invokeTag('submitButton','g',33,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',36,['id':("create"),'url':([resource:glSortCodeInstance, action:'save'])],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',38,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(21)
invokeTag('message','g',42,['code':("default.home.label")],-1)
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',43,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',43,['class':("list"),'action':("index")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(24)
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
