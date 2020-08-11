import icbs.gl.CfgAcctGlTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplate.label', default: 'CfgAcctGlTemplate'))],-1)
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
expressionOut.print(createLink(uri: '/cfgAcctGlTemplate'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (cfgAcctGlTemplateInstance?.description)) {
printHtmlPart(10)
invokeTag('fieldValue','g',21,['bean':(cfgAcctGlTemplateInstance),'field':("description")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (cfgAcctGlTemplateInstance?.type)) {
printHtmlPart(13)
invokeTag('fieldValue','g',25,['bean':(cfgAcctGlTemplateInstance),'field':("type")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('select','g',32,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',34,['id':("templateid"),'name':("templateid"),'value':(params.id)],-1)
printHtmlPart(18)
invokeTag('textField','g',38,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 4)
invokeTag('submitButton','g',40,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(21)
})
invokeTag('form','g',42,['class':("form-inline"),'action':("show")],3)
printHtmlPart(22)
invokeTag('sortableColumn','g',49,['property':("id"),'title':(message(code: 'cfgAcctGlTemplate.description.label', default: 'id'))],-1)
printHtmlPart(23)
invokeTag('sortableColumn','g',51,['property':("glCode"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Gl Code'))],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',52,['property':("glDescription"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Gl Description'))],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',54,['property':("ordinalPos"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Gl Ordinal Pos'))],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',55,['property':("status"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Status'))],-1)
printHtmlPart(26)
for( link in (cfgAcctGlTemplateInstance.links) ) {
printHtmlPart(27)
expressionOut.print(link.id)
printHtmlPart(28)
expressionOut.print(link.glCode)
printHtmlPart(28)
expressionOut.print(link.glDescription)
printHtmlPart(29)
expressionOut.print(link.ordinalPos)
printHtmlPart(28)
expressionOut.print(link.status)
printHtmlPart(28)
createClosureForHtmlPart(30, 4)
invokeTag('link','g',72,['controller':("cfgAcctGlTemplateDet"),'action':("show"),'id':(link.id)],4)
printHtmlPart(31)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateInstance, field: "type"))
printHtmlPart(32)
}
printHtmlPart(33)
invokeTag('paginate','g',111,['total':(CfgAcctGlTemplateInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',114,['tag':("main-content")],2)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',120,['class':("list"),'action':("index")],3)
printHtmlPart(38)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',123,['action':("glLinkCreateNewEntry"),'id':(params.id)],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',126,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',127,[:],1)
printHtmlPart(41)
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
