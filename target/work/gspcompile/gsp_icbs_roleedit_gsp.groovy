import icbs.admin.Role
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roleedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/role/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'role.label', default: 'Role'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(uri: '/role'))
printHtmlPart(4)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
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
invokeTag('message','g',23,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',24,['bean':(roleInstance),'var':("error")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',26,['bean':(roleInstance)],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',38,['name':("version"),'value':(roleInstance?.version)],-1)
printHtmlPart(19)
invokeTag('render','g',40,['template':("form")],-1)
printHtmlPart(20)
invokeTag('render','g',46,['template':("module")],-1)
printHtmlPart(21)
})
invokeTag('form','g',48,['id':("edit"),'url':([resource:roleInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('actionSubmit','g',64,['id':("editRole"),'name':("edit"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00603', 'form#edit', 'Override edit new role.', null); 
                                },
                                function(){
                                    return;
                                });                    
            """)],-1)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',65,['action':("show"),'id':(roleInstance.id)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',78,[:],1)
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
