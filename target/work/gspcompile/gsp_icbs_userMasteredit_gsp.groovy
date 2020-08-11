import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMasteredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
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
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/userMaster'))
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
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
invokeTag('message','g',31,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',32,['bean':(userMasterInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',35,['bean':(userMasterInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',47,['name':("version"),'value':(userMasterInstance?.version)],-1)
printHtmlPart(20)
invokeTag('render','g',49,['template':("form"),'model':(['mode':'edit'])],-1)
printHtmlPart(21)
invokeTag('render','g',55,['template':("role")],-1)
printHtmlPart(22)
})
invokeTag('form','g',57,['id':("edit"),'url':([resource:userMasterInstance, action:'update']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('actionSubmit','g',73,['id':("edituser"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00503', 'form#edit', 'Edit User Information.', null); 
                                },
                                function(){
                                    return;
                                });
                """)],-1)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',74,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',74,['action':("index")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(28)
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
