import icbs.admin.CustomerGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroupindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customerGroup.label', default: 'CustomerGroup'))],-1)
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
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
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
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',25,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',27,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',29,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("code"),'title':(message(code: 'customerGroup.code.label', default: 'Code'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',37,['property':("name"),'title':(message(code: 'customerGroup.name.label', default: 'Name'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',39,['property':("name"),'title':(message(code: 'customerGroup.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(19)
loop:{
int i = 0
for( customerGroupInstance in (customerGroupInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
if(true && (customerGroupInstance?.configItemStatusId==2)) {
printHtmlPart(22)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: customerGroupInstance, field: "code"))
})
invokeTag('link','g',47,['action':("show"),'id':(customerGroupInstance.id)],5)
printHtmlPart(23)
expressionOut.print(fieldValue(bean: customerGroupInstance, field: "name"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: customerGroupInstance, field: "configItemStatus.description"))
printHtmlPart(25)
}
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',58,['total':(customerGroupInstanceCount ?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',63,['action':("create")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',65,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',66,[:],1)
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
