import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMastercreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
expressionOut.print(createLink(action:'generatePassword', 'controller':'userMaster'))
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/userMaster'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',23,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('render','g',52,['template':("form"),'model':(['mode':'create'])],-1)
printHtmlPart(15)
invokeTag('render','g',57,['template':("role")],-1)
printHtmlPart(16)
})
invokeTag('form','g',59,['name':("create"),'id':("create"),'url':([resource:userMasterInstance, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('submitButton','g',75,['name':("create"),'id':("createuser"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00502', 'form#create', 'Create New User.', null); 
                                },
                                function(){
                                    return;
                                }); 
                """)],-1)
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',77,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',77,['action':("index")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(21)
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
