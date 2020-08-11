import icbs.gl.CfgAcctGlTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/index.gsp" }
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
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',37,['property':("description"),'title':(message(code: 'cfgAcctGlTemplate.description.label', default: 'Description'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',39,['property':("type"),'title':(message(code: 'cfgAcctGlTemplate.type.label', default: 'Type'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( cfgAcctGlTemplateInstance in (cfgAcctGlTemplateInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateInstance, field: "description"))
})
invokeTag('link','g',47,['action':("show"),'id':(cfgAcctGlTemplateInstance.id)],4)
printHtmlPart(21)
if(true && (cfgAcctGlTemplateInstance.type==1)) {
printHtmlPart(22)
}
else if(true && (cfgAcctGlTemplateInstance.type==2)) {
printHtmlPart(23)
}
else if(true && (cfgAcctGlTemplateInstance.type==3)) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(fieldValue(bean: cfgAcctGlTemplateInstance, field: "type"))
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',70,['total':(CfgAcctGlTemplateInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(30)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(31)
invokeTag('message','g',76,['code':("default.home.label")],-1)
printHtmlPart(32)
expressionOut.print(createLink(uri: '/CfgAcctGlTemplateDet'))
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',79,['action':("glLinkEntry")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(36)
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
