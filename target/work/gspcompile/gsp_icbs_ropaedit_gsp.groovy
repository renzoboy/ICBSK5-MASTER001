import icbs.loans.ROPA
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'ROPA.label', default: 'ROPA'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
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
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(12)
})
invokeTag('javascript','g',353,[:],2)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',354,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(15, 2)
invokeTag('captureContent','sitemesh',358,['tag':("breadcrumbs")],2)
printHtmlPart(4)
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
invokeTag('message','g',367,['error':(error)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',368,['bean':(ropaInstance),'var':("error")],4)
printHtmlPart(26)
})
invokeTag('hasErrors','g',370,['bean':(ropaInstance)],3)
printHtmlPart(27)
expressionOut.print(ropapapapaInstanceInstance?.branch?.name)
printHtmlPart(28)
invokeTag('formatDate','g',383,['format':("MM/dd/yyyy"),'date':(ropapapapaInstanceInstance?.ropaDate)],-1)
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
invokeTag('render','g',397,['template':("editForm")],-1)
printHtmlPart(31)
})
invokeTag('form','g',399,['id':("editRopa"),'name':("editRopa"),'url':([action:'updateRopa',controller:'Ropa']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',401,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',406,['action':("show"),'id':(ropapapapaInstanceInstance?.id)],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',448,['tag':("main-actions")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',449,[:],1)
printHtmlPart(38)
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
