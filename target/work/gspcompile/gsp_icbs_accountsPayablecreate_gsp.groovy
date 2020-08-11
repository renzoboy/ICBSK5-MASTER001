import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayablecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/create.gsp" }
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
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(6)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(7)
})
invokeTag('javascript','g',40,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(createLink(uri: '/accountsPayable'))
printHtmlPart(10)
})
invokeTag('captureContent','sitemesh',46,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(17)
expressionOut.print(error.field)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',55,['error':("${error.field} - ${error}")],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',56,['bean':(accountsPayableInstance),'var':("error")],4)
printHtmlPart(21)
})
invokeTag('hasErrors','g',58,['bean':(accountsPayableInstance)],3)
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('render','g',62,['template':("form")],-1)
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(26)
})
invokeTag('javascript','g',164,[:],4)
printHtmlPart(14)
})
invokeTag('form','g',165,['id':("create"),'url':([resource:accountsPayableInstance, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',167,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',171,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',171,['action':("index")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',173,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',174,[:],1)
printHtmlPart(30)
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
