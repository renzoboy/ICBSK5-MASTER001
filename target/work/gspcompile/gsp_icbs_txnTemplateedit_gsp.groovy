import icbs.admin.TxnTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnTemplateedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnTemplate/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'txnTemplate.label', default: 'TxnTemplate'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/txnTemplate'))
printHtmlPart(6)
createClosureForHtmlPart(7, 3)
invokeTag('link','g',12,['action':("show"),'resource':(txnTemplateInstance)],3)
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(15)
expressionOut.print(error.field)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',23,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',24,['bean':(txnTemplateInstance),'var':("error")],4)
printHtmlPart(19)
})
invokeTag('hasErrors','g',26,['bean':(txnTemplateInstance)],3)
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('hiddenField','g',38,['name':("version"),'value':(txnTemplateInstance?.version)],-1)
printHtmlPart(22)
invokeTag('render','g',40,['template':("detail")],-1)
printHtmlPart(23)
invokeTag('render','g',46,['template':("charge")],-1)
printHtmlPart(24)
})
invokeTag('form','g',48,['id':("edit"),'url':([resource:txnTemplateInstance, action:'saveCharge']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('actionSubmit','g',56,['form':("edit"),'action':("saveCharge"),'value':(message(code: 'default.button.save.label', default: 'Save'))],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',57,['action':("show"),'id':(txnTemplateInstance.id)],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',59,['tag':("main-actions")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(31)
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
