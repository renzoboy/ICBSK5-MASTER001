import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policyedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policy/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'policy.label', default: 'Policy'))],-1)
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
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(uri: '/policy'))
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(3)
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
invokeTag('message','g',24,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',25,['bean':(policyInstance),'var':("error")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',27,['bean':(policyInstance)],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('hiddenField','g',42,['name':("version"),'value':(policyInstance?.version)],-1)
printHtmlPart(19)
invokeTag('render','g',44,['template':("form")],-1)
printHtmlPart(20)
invokeTag('render','g',50,['template':("txnTemplate")],-1)
printHtmlPart(21)
invokeTag('render','g',56,['template':("role")],-1)
printHtmlPart(22)
invokeTag('render','g',62,['template':("approver")],-1)
printHtmlPart(23)
})
invokeTag('form','g',67,['name':("edit"),'id':("edit"),'url':([resource:policyInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',70,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('actionSubmit','g',81,['id':("editPolicy"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00403', 'form#edit', 'Created a new policy.', null);                             
                                    },
                                function(){
                                    return;
                                });                             
                        """)],-1)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',82,['action':("show"),'id':(policyInstance.id)],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-actions")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',95,[:],1)
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
