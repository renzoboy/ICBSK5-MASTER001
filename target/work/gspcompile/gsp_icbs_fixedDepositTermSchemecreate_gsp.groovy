import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositTermSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositTermScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'fixedDepositTermScheme.label', default: 'FixedDepositTermScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/fixedDepositTermScheme'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
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
invokeTag('message','g',21,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',22,['bean':(fixedDepositTermSchemeInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',24,['bean':(fixedDepositTermSchemeInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('render','g',27,['template':("form")],-1)
printHtmlPart(19)
})
invokeTag('form','g',29,['id':("fixedDepositTermSchemeForm"),'url':([resource:fixedDepositTermSchemeInstance, action:'save'])],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',31,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('submitButton','g',43,['name':("create"),'id':("newfixedDepositTermScheme"),'class':("btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01502', 'form#fixedDepositTermSchemeForm', 'Override new fixed deposit term scheme form.', null);
                                },
                                function(){
                                    return;
                                });                            
                        """)],-1)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',44,['class':("list"),'action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',55,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(25)
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
