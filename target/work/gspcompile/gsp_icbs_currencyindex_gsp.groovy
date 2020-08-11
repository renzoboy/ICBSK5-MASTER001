import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_currencyindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/currency/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'currency.label', default: 'Currency'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
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
invokeTag('sortableColumn','g',35,['property':("code"),'title':(message(code: 'currency.code.label', default: 'Code'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("name"),'title':(message(code: 'currency.name.label', default: 'Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("configItemStatus"),'title':(message(code: 'currency.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( currencyInstance in (currencyInstanceList) ) {
printHtmlPart(18)
if(true && (currencyInstance.configItemStatusId==2)) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: currencyInstance, field: "code"))
})
invokeTag('link','g',47,['action':("show"),'id':(currencyInstance.id)],5)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: currencyInstance, field: "name"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: currencyInstance, field: "configItemStatus.description"))
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',58,['total':(currencyInstanceCount ?: 0)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',61,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',64,['controller':("currency"),'action':("create")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',67,[:],1)
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
