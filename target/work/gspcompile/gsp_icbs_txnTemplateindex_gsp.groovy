import icbs.admin.TxnTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnTemplateindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnTemplate/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'txnTemplate.label', default: 'TxnTemplate'))],-1)
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
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
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
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([200, 300]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',37,['property':("code"),'title':(message(code: 'txnTemplate.code.label', default: 'Code'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',39,['property':("description"),'title':(message(code: 'txnTemplate.description.label', default: 'Description'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',41,['property':("shortDescription"),'title':(message(code: 'txnTemplate.shortDescription.label', default: 'Short Description'))],-1)
printHtmlPart(19)
invokeTag('message','g',43,['code':("txnTemplate.txnModule.label"),'default':("Txn Module")],-1)
printHtmlPart(20)
invokeTag('message','g',45,['code':("txnTemplate.txnType.label"),'default':("Txn Type")],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',46,['property':("configItemStatus"),'title':(message(code: 'txnTemplate.shortDescription.label', default: 'Status'))],-1)
printHtmlPart(22)
loop:{
int i = 0
for( txnTemplateInstance in (txnTemplateInstanceList) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: txnTemplateInstance, field: "code"))
})
invokeTag('link','g',54,['action':("show"),'id':(txnTemplateInstance.id)],4)
printHtmlPart(25)
expressionOut.print(fieldValue(bean: txnTemplateInstance, field: "description"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: txnTemplateInstance, field: "shortDescription"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: txnTemplateInstance, field: "txnType.description"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: txnTemplateInstance, field: "txnModule.description"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: txnTemplateInstance, field: "configItemStatus.description"))
printHtmlPart(28)
i++
}
}
printHtmlPart(29)
invokeTag('paginate','g',71,['total':(TxnTemplateInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(33)
invokeTag('message','g',77,['code':("default.home.label")],-1)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',78,['action':("create")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(37)
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
