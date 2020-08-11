import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
invokeTag('javascript','asset',7,['src':("depositHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'depositInterestScheme', action:'addGraduatedFormAjax'))
printHtmlPart(5)
})
invokeTag('javascript','g',22,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(uri: '/depositInterestScheme'))
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',28,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(16)
expressionOut.print(error.field)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',37,['error':(error)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',38,['bean':(depositInterestSchemeInstance),'var':("error")],4)
printHtmlPart(20)
})
invokeTag('hasErrors','g',40,['bean':(depositInterestSchemeInstance)],3)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('render','g',43,['template':("form")],-1)
printHtmlPart(22)
})
invokeTag('form','g',48,['id':("DepositInterestSchemeForm"),'url':([resource:depositInterestSchemeInstance, action:'save'])],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',50,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('submitButton','g',61,['name':("create"),'id':("newDepositIntScheme"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01002', 'form#DepositInterestSchemeForm', 'Override new Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                            
                        """)],-1)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',63,['class':("list"),'action':("index")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',76,[:],1)
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
