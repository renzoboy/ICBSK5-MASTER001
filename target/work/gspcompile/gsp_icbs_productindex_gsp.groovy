import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_productindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
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
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(4)
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
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',39,['property':("productType"),'title':(message(code: 'product.productType.label', default: 'Type'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',41,['property':("name"),'title':(message(code: 'product.name.label', default: 'Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',43,['property':("configItemStatus"),'title':(message(code: 'product.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( productInstance in (productInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: productInstance, field: "code").padLeft(3, '0'))
})
invokeTag('link','g',51,['action':("show"),'id':(productInstance.id)],4)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: productInstance, field: "productType.description"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: productInstance, field: "name"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: productInstance, field: "configItemStatus.description"))
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',65,['total':(ProductInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',71,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',71,['class':("create"),'action':("create")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(28)
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
