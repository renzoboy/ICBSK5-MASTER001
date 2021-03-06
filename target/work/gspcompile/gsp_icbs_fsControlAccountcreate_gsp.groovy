import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fsControlAccountcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fsControlAccount/create.gsp" }
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
})
invokeTag('captureHead','sitemesh',6,[:],1)
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
createTagBody(4, {->
printHtmlPart(9)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(10)
expressionOut.print(error.field)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',16,['error':("${error.field} - ${error}")],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',17,['bean':(assetsHtmInstance),'var':("error")],4)
printHtmlPart(14)
})
invokeTag('hasErrors','g',19,['bean':(assetsHtmInstance)],3)
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('render','g',22,['template':("form")],-1)
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
expressionOut.print(createLink(controller:'FsControlAccount', action:'validateCodeIfExistAjax'))
printHtmlPart(18)
})
invokeTag('javascript','g',90,[:],4)
printHtmlPart(7)
})
invokeTag('form','g',91,['id':("create"),'url':([controller:'fsControlAccount', action:'saveCreate']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',97,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',97,['action':("index")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',99,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',100,[:],1)
printHtmlPart(22)
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
