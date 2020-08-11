import icbs.gl.GlSortCode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glSortCodeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glSortCode/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glSortCode.label', default: 'Gl Sort Code'))],-1)
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
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (glSortCodeInstance?.sort_code)) {
printHtmlPart(10)
invokeTag('message','g',30,['code':("glSortCode.sort_code.label"),'default':("GL Sort Code")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',32,['bean':(glSortCodeInstance),'field':("sort_code")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (glSortCodeInstance?.sort_name)) {
printHtmlPart(14)
invokeTag('message','g',39,['code':("glSortCode.sort_name.label"),'default':("Sort Code Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',41,['bean':(glSortCodeInstance),'field':("sort_name")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (glSortCodeInstance?.parent_id)) {
printHtmlPart(16)
invokeTag('message','g',48,['code':("glSortCode.parent_id.label"),'default':("Parent ID")],-1)
printHtmlPart(17)
createTagBody(4, {->
expressionOut.print(glSortCodeInstance?.parent_id?.encodeAsHTML())
})
invokeTag('link','g',50,['controller':("glAcctType"),'action':("show"),'id':(glSortCodeInstance?.parent_id?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (glSortCodeInstance?.sort_code_status)) {
printHtmlPart(18)
invokeTag('message','g',57,['code':("glSortCode.sort_code_status.label"),'default':("Sort Code Status")],-1)
printHtmlPart(19)
invokeTag('formatBoolean','g',59,['boolean':(glSortCodeInstance?.sort_code_status)],-1)
printHtmlPart(12)
}
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(21)
createTagBody(4, {->
invokeTag('message','g',68,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',68,['class':("edit"),'action':("edit"),'resource':(glSortCodeInstance)],4)
printHtmlPart(22)
invokeTag('actionSubmit','g',69,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(23)
})
invokeTag('form','g',72,['url':([resource:glSortCodeInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(27)
invokeTag('message','g',77,['code':("default.home.label")],-1)
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',78,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',78,['class':("list"),'action':("index")],3)
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',79,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',79,['class':("create"),'action':("create")],3)
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',80,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',80,['class':("edit"),'action':("edit"),'resource':(glSortCodeInstance)],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('form','g',85,['id':("deleteSC"),'url':([resource:glSortCodeInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',102,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',103,[:],1)
printHtmlPart(32)
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
