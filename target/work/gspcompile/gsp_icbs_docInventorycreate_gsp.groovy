import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventorycreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'docInventory.label', default: 'DocInventory'))],-1)
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
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/docInventory'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
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
createTagBody(4, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',26,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',27,['bean':(docInventoryInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',29,['bean':(docInventoryInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('render','g',33,['template':("form"),'model':([readonly:'false'])],-1)
printHtmlPart(19)
})
invokeTag('form','g',35,['id':("docInventoryForm"),'url':([resource:docInventoryInstance, action:'save'])],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',37,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',61,['class':("list"),'action':("index")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(24)
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
