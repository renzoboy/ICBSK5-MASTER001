import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_assetsHtmindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/assetsHtm/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(9)
invokeTag('textField','g',20,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search by Assset Type , Description and GL CODE")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('submitButton','g',22,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(12)
})
invokeTag('form','g',24,['class':("form-inline")],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("glCode"),'title':(message(code: 'AssetsHeldToMaturity.glCode.label', default: 'Gl Code'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("htmType"),'title':(message(code: 'AssetsHeldToMaturity.htmType.label', default: 'Asset Type'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',32,['property':("htmDescription"),'title':(message(code: 'AssetsHeldToMaturity.description.label', default: 'Description'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',33,['property':("reference"),'title':(message(code: 'AssetsHeldToMaturity.reference.label', default: 'Reference'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',34,['property':("amount"),'title':(message(code: 'AssetsHeldToMaturity.amount.label', default: 'Amount'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( assetsHtmInstance in (assetsHtmList) ) {
printHtmlPart(15)
if(true && (assetsHtmInstance?.status.id == 2)) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(assetsHtmInstance?.glCode)
printHtmlPart(19)
expressionOut.print(assetsHtmInstance?.htmType)
printHtmlPart(20)
expressionOut.print(assetsHtmInstance?.htmDescription)
printHtmlPart(21)
expressionOut.print(assetsHtmInstance?.reference)
printHtmlPart(22)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(assetsHtmInstance?.amount)],-1)
printHtmlPart(21)
createClosureForHtmlPart(23, 5)
invokeTag('link','g',47,['class':("btn btn-secondary"),'action':("show"),'id':(assetsHtmInstance?.id)],5)
printHtmlPart(24)
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',53,['total':(assetsHtmInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',54,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',59,['controller':("home"),'action':("landing")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',61,['action':("create")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(34)
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
