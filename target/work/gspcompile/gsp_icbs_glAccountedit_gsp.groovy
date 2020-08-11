import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccountedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'glAccount.label', default: 'GlAccount'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller: 'search', action:'search', params:[searchDomain: "gl-sortcode"]))
printHtmlPart(4)
})
invokeTag('javascript','g',25,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(uri: '/glAccount'))
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',31,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(16)
expressionOut.print(error.field)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',40,['error':(error)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',41,['bean':(glAccountInstance),'var':("error")],4)
printHtmlPart(20)
})
invokeTag('hasErrors','g',43,['bean':(glAccountInstance)],3)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('hiddenField','g',45,['name':("version"),'value':(glAccountInstance?.version)],-1)
printHtmlPart(22)
invokeTag('render','g',47,['template':("form")],-1)
printHtmlPart(23)
})
invokeTag('form','g',49,['id':("edit"),'url':([resource:glAccountInstance, action:'update']),'method':("PUT"),'name':("update")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',51,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',54,['class':("list"),'action':("index")],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',55,['class':("create"),'action':("create")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(31)
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
