import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnTemplateupdateTxnTemplate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnTemplate/updateTxnTemplate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'txnTemplate.label', default: 'TxnTemplate'))],-1)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',18,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',19,['bean':(txnTemplateInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',21,['bean':(txnTemplateInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('render','g',24,['template':("formEdit")],-1)
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
expressionOut.print(createLink(controller:'TxnTemplate', action:'getTxnTypeCodeAjax'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingCodeAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller:'TxnTemplate', action:'updateTxnTemplateAjax'))
printHtmlPart(22)
})
invokeTag('javascript','g',442,[:],4)
printHtmlPart(23)
})
invokeTag('form','g',443,['url':([resource:txnTemplateInstance, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',445,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(27)
invokeTag('message','g',448,['code':("default.home.label")],-1)
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',450,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',450,['class':("list"),'action':("index")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',452,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',453,[:],1)
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
