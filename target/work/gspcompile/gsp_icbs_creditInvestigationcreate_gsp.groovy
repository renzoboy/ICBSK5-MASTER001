import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(1)
if(true && (creditTypeAction == "secured")) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',7,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],3)
printHtmlPart(4)
}
else {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(5, 4)
invokeTag('captureTitle','sitemesh',10,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],3)
printHtmlPart(4)
}
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller:'loanApplication', action:'unsecAndSecuredApplicationCheckerAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showAttachmentsAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'creditInvestigation', action:'addAttachmentAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller: 'creditInvestigation', action:'showAddAttachmentAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'creditInvestigation', action:'updateAttachmentAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'creditInvestigation', action:'showUpdateAttachmentAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'creditInvestigation', action:'deleteAttachmentAjax'))
printHtmlPart(15)
expressionOut.print(loanApplication?.id)
printHtmlPart(16)
})
invokeTag('javascript','g',200,[:],2)
printHtmlPart(17)
})
invokeTag('captureHead','sitemesh',201,[:],1)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('captureContent','sitemesh',205,['tag':("breadcrumbs")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(21)
if(true && (flash.message)) {
printHtmlPart(22)
expressionOut.print(flash.message)
printHtmlPart(23)
}
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('hasErrors','g',228,['bean':(creditInvestigationInstance)],3)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('render','g',239,['template':("details/form")],-1)
printHtmlPart(27)
invokeTag('render','g',242,['template':("attachments/list")],-1)
printHtmlPart(28)
invokeTag('render','g',245,['template':("checklist")],-1)
printHtmlPart(29)
})
invokeTag('uploadForm','g',248,['id':("credit-investigation-form"),'url':([controller:creditInvestigation, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',250,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('submitButton','g',261,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('LON00401', 'form#credit-investigation-form', 'Save Credit Investigation', null); 
                                },
                                function(){
                                    return;
                                });                          
                    """)],-1)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',271,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',273,['tag':("main-actions")],2)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',274,[:],1)
printHtmlPart(35)
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
