import icbs.admin.Form
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_formindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form/index.gsp" }
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
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',25,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',27,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',29,['class':("form-inline")],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',36,['property':("name"),'title':(message(code: 'form.name.label', default: 'Name'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',38,['property':("sourceFile"),'title':(message(code: 'form.sourceFile.label', default: 'Source File'))],-1)
printHtmlPart(16)
invokeTag('message','g',40,['code':("form.configItemStatus.label"),'default':("Status")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( formInstance in (formInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: formInstance, field: "name"))
})
invokeTag('link','g',48,['action':("show"),'id':(formInstance.id)],4)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: formInstance, field: "sourceFile"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: formInstance, field: "configItemStatus.description"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',60,['total':(FormInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',63,['tag':("main-content")],2)
printHtmlPart(24)
createClosureForHtmlPart(25, 2)
invokeTag('captureContent','sitemesh',67,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',68,[:],1)
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
