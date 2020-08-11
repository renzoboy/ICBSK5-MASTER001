import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
if(true && (creditTypeAction == "secured")) {
printHtmlPart(3)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',9,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],3)
printHtmlPart(5)
}
else {
printHtmlPart(3)
createTagBody(3, {->
createClosureForHtmlPart(6, 4)
invokeTag('captureTitle','sitemesh',12,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],3)
printHtmlPart(5)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'loanApplication', action:'unsecAndSecuredApplicationCheckerAjax'))
printHtmlPart(9)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(10)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showAttachmentsAjax2'))
printHtmlPart(11)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(12)
expressionOut.print(createLink(controller:'creditInvestigation', action:'addAttachmentAjax2'))
printHtmlPart(13)
expressionOut.print(createLink(controller: 'creditInvestigation', action:'showAddAttachmentAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'creditInvestigation', action:'updateAttachmentAjax2'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showUpdateAttachmentAjax2'))
printHtmlPart(16)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(17)
expressionOut.print(createLink(controller:'creditInvestigation', action:'deleteAttachmentAjax2'))
printHtmlPart(18)
})
invokeTag('javascript','g',163,[:],2)
printHtmlPart(19)
})
invokeTag('captureHead','sitemesh',164,[:],1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('captureContent','sitemesh',168,['tag':("breadcrumbs")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(22)
if(true && (flash.message)) {
printHtmlPart(23)
expressionOut.print(flash.message)
printHtmlPart(24)
}
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('hasErrors','g',191,['bean':(creditInvestigationInstance)],3)
printHtmlPart(25)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('hiddenField','g',194,['name':("version"),'value':(creditInvestigationInstance?.version)],-1)
printHtmlPart(28)
invokeTag('render','g',204,['template':("details/form")],-1)
printHtmlPart(29)
invokeTag('render','g',207,['template':("attachments/list")],-1)
printHtmlPart(30)
invokeTag('render','g',210,['template':("checklist")],-1)
printHtmlPart(31)
})
invokeTag('form','g',213,['id':("credit-investigation-form"),'url':([controller:creditInvestigation, action:'update', id:creditInvestigationInstance?.id]),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',215,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',232,['class':("list"),'action':("show"),'id':(creditInvestigationInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',234,['tag':("main-actions")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',235,[:],1)
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
