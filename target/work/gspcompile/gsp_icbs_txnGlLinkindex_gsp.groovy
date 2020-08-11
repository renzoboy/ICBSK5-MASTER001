import icbs.gl.TxnGlLink
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnGlLinkindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnGlLink/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'txnGlLink.label', default: 'TxnGlLink'))],-1)
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
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',26,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',31,['property':("description"),'title':(message(code: 'txnGlLink.description.label', default: 'Description'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',33,['property':("status"),'title':(message(code: 'txnGlLink.status.label', default: 'Status'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( txnGlLinkInstance in (txnGlLinkInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: txnGlLinkInstance, field: "description"))
})
invokeTag('link','g',43,['action':("show"),'id':(txnGlLinkInstance.id)],4)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: txnGlLinkInstance, field: "status"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',53,['total':(TxnGlLinkInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',56,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',59,['class':("create"),'action':("create")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',61,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(27)
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
