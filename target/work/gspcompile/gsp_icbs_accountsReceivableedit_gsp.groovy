import icbs.gl.AccountsReceivable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivableedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/edit.gsp" }
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
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(6)
expressionOut.print(accountsReceivableInstance?.customer?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(8)
})
invokeTag('javascript','g',158,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',159,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',164,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(18)
expressionOut.print(error.field)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',173,['error':("${error.field} - ${error}")],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',174,['bean':(accountsReceivableInstance),'var':("error")],4)
printHtmlPart(22)
})
invokeTag('hasErrors','g',176,['bean':(accountsReceivableInstance)],3)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('render','g',180,['template':("form")],-1)
printHtmlPart(25)
})
invokeTag('form','g',182,['id':("update"),'url':([controller:'accountsReceivable',action:'updateAccountsReceivable']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',184,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',188,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',188,['action':("index")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',190,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',191,[:],1)
printHtmlPart(29)
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