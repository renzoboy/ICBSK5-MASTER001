import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_rolecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/role/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'role.label', default: 'Role'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(uri: '/role'))
printHtmlPart(4)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
createTagBody(4, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',22,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',23,['bean':(roleInstance),'var':("error")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',25,['bean':(roleInstance)],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('render','g',38,['template':("form")],-1)
printHtmlPart(19)
invokeTag('render','g',44,['template':("module")],-1)
printHtmlPart(20)
})
invokeTag('form','g',46,['id':("create"),'url':([resource:roleInstance, action:'save'])],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',51,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('submitButton','g',63,['id':("newRole"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00602', 'form#create', 'Override create new role.', null); 
                                },
                                function(){
                                    return;
                                });                    
            """)],-1)
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',64,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',64,['action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(26)
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
