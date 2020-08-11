import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_currencyedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/currency/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'currency.label', default: 'Currency'))],-1)
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
expressionOut.print(createLink(uri:'/currency'))
printHtmlPart(4)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(1)
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
invokeTag('message','g',21,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',22,['bean':(currencyInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',24,['bean':(currencyInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',26,['name':("version"),'value':(currencyInstance?.version)],-1)
printHtmlPart(17)
invokeTag('render','g',28,['template':("form")],-1)
printHtmlPart(18)
})
invokeTag('form','g',30,['id':("edit"),'url':([resource:currencyInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',31,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('actionSubmit','g',42,['action':("update"),'form':("edit"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00103', 'form#edit', 'Edit Currency.', null); // params: policyTemplate.code, form to be saved
                                },
                                function(){
                                    return;
                                }); 
                                """)],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',43,['action':("show"),'id':(currencyInstance.id)],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',45,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',46,[:],1)
printHtmlPart(23)
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
