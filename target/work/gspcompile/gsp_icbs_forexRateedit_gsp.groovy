import icbs.admin.ForexRate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_forexRateedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/forexRate/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'forexRate.label', default: 'ForexRate'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
createTagBody(4, {->
printHtmlPart(9)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(10)
expressionOut.print(error.field)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',18,['error':(error)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',19,['bean':(forexRateInstance),'var':("error")],4)
printHtmlPart(14)
})
invokeTag('hasErrors','g',21,['bean':(forexRateInstance)],3)
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('hiddenField','g',23,['name':("version"),'value':(forexRateInstance?.version)],-1)
printHtmlPart(16)
invokeTag('render','g',25,['template':("form")],-1)
printHtmlPart(17)
invokeTag('actionSubmit','g',29,['class':("hidden"),'id':("updateForexRatebtn"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',31,['url':([resource:forexRateInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',33,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(21)
invokeTag('message','g',37,['code':("default.home.label")],-1)
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',38,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',38,['class':("list"),'action':("index")],3)
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',39,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',39,['class':("create"),'action':("create")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',52,['tag':("main-actions")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',54,[:],1)
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
