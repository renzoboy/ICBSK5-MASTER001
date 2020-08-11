import icbs.deposit.DocInventory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'docInventory.label', default: 'DocInventory'))],-1)
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
printHtmlPart(5)
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
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('select','g',26,['id':("searchType"),'name':("searchType"),'from':(icbs.lov.DocInventoryType.list(sort: "description")),'optionKey':("id"),'onchange':("this.form.submit()"),'optionValue':("description"),'required':(""),'value':(params?.searchType),'class':("many-to-one form-control")],-1)
printHtmlPart(13)
expressionOut.print(params?.query)
printHtmlPart(14)
invokeTag('submitButton','g',31,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(15)
})
invokeTag('form','g',35,[:],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',40,['property':("type"),'title':(message(code: 'docInventory.type.label', default: 'Document Inventory Type'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',41,['property':("branch"),'title':(message(code: 'docInventory.seriesStart.label', default: 'Branch'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',42,['property':("seriesStart"),'title':(message(code: 'docInventory.seriesStart.label', default: 'Series Start'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',43,['property':("seriesEnd"),'title':(message(code: 'docInventory.seriesEnd.label', default: 'Series End'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',44,['property':("isCanceled"),'title':(message(code: 'docInventory.isCanceled.label', default: 'Is Canceled'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',45,['property':("canceledAt"),'title':(message(code: 'docInventory.canceledAt.label', default: 'Canceled At'))],-1)
printHtmlPart(18)
invokeTag('message','g',46,['code':("docInventory.canceledBy.label"),'default':("Canceled By")],-1)
printHtmlPart(19)
loop:{
int i = 0
for( docInventoryInstance in (docInventoryInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(fieldValue(bean: docInventoryInstance, field: "type.description"))
printHtmlPart(22)
expressionOut.print(docInventoryInstance?.branch?.name)
printHtmlPart(23)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(22)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(24)
invokeTag('formatBoolean','g',59,['boolean':(docInventoryInstance.isCanceled)],-1)
printHtmlPart(22)
invokeTag('formatDate','g',60,['format':("yyyy-MM-dd"),'date':(docInventoryInstance.canceledAt)],-1)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: docInventoryInstance, field: "canceledBy.username"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: docInventoryInstance, field: "status.description"))
printHtmlPart(25)
if(true && (docInventoryInstance.usageCount > 0)) {
printHtmlPart(26)
createClosureForHtmlPart(27, 5)
invokeTag('link','g',65,['action':("show"),'id':(docInventoryInstance.id),'class':("btn btn-primary")],5)
printHtmlPart(28)
}
else {
printHtmlPart(29)
createClosureForHtmlPart(30, 5)
invokeTag('link','g',70,['action':("edit"),'id':(docInventoryInstance.id),'class':("btn btn-primary")],5)
printHtmlPart(31)
createClosureForHtmlPart(27, 5)
invokeTag('link','g',71,['action':("show"),'id':(docInventoryInstance.id),'class':("btn btn-primary")],5)
printHtmlPart(28)
}
printHtmlPart(32)
i++
}
}
printHtmlPart(33)
invokeTag('paginate','g',80,['total':(DocInventoryInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',86,['class':("create"),'action':("create")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(38)
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
