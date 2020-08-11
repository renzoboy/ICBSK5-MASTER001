import icbs.gl.GlSortCode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glSortCodeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glSortCode/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glSortCode.label', default: 'GlSortCode'))],-1)
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
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',26,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("sort_code"),'title':(message(code: 'glSortCode.sort_code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("sort_name"),'title':(message(code: 'glSortCode.sort_name.label', default: 'Name'))],-1)
printHtmlPart(17)
invokeTag('message','g',36,['code':("glSortCode.parent_id.label"),'default':("Type")],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',38,['property':("sort_code_status"),'title':(message(code: 'glSortCode.sort_code_status.label', default: 'Status'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( glSortCodeInstance in (glSortCodeInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glSortCodeInstance, field: "sort_code"))
})
invokeTag('link','g',46,['action':("show"),'id':(glSortCodeInstance.id)],4)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: glSortCodeInstance, field: "sort_name"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: glSortCodeInstance, field: "parent_id"))
printHtmlPart(22)
invokeTag('formatBoolean','g',52,['boolean':(glSortCodeInstance.sort_code_status)],-1)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',60,['total':(GlSortCodeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',63,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(26)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(27)
invokeTag('message','g',66,['code':("default.home.label")],-1)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',67,['class':("create"),'action':("create")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',70,[:],1)
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
