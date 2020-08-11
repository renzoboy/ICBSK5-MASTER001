import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropacreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(11)
})
invokeTag('javascript','g',294,[:],2)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',295,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('captureContent','sitemesh',299,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(22)
expressionOut.print(error.field)
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('message','g',314,['error':("${error.field} - ${error}")],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',315,['bean':(ropaInstance),'var':("error")],4)
printHtmlPart(26)
})
invokeTag('hasErrors','g',317,['bean':(ropaInstance)],3)
printHtmlPart(19)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('render','g',320,['template':("form")],-1)
printHtmlPart(28)
})
invokeTag('form','g',322,['id':("create"),'url':([controller:'ropa', action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',324,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(30)
createTagBody(3, {->
invokeTag('message','g',329,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',329,['action':("index")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',333,['tag':("main-actions")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',334,[:],1)
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
