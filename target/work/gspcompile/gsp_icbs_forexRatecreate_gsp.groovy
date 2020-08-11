import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_forexRatecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/forexRate/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'forexRate.label', default: 'ForexRate'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/forexRate'))
printHtmlPart(5)
})
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
expressionOut.print(error.field)
printHtmlPart(16)
invokeTag('message','g',22,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',23,['bean':(forexRateInstance),'var':("error")],4)
printHtmlPart(18)
})
invokeTag('hasErrors','g',25,['bean':(forexRateInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('render','g',28,['template':("form")],-1)
printHtmlPart(20)
invokeTag('submitButton','g',30,['class':("hidden"),'id':("subbtn"),'name':("create"),'form':("create"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(10)
})
invokeTag('form','g',31,['id':("create"),'url':([resource:forexRateInstance, action:'save'])],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',33,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',37,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',37,['action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',50,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',51,[:],1)
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
