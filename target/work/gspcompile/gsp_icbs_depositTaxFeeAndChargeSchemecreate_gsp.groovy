import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',57,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',58,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/depositTaxFeeAndChargeScheme'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',63,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(15)
expressionOut.print(error.field)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',72,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',73,['bean':(depositTaxFeeAndChargeSchemeInstance),'var':("error")],4)
printHtmlPart(19)
})
invokeTag('hasErrors','g',75,['bean':(depositTaxFeeAndChargeSchemeInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(20)
invokeTag('render','g',78,['template':("form")],-1)
printHtmlPart(21)
})
invokeTag('form','g',81,['id':("depositTaxChargeSchemeForm"),'url':([resource:depositTaxFeeAndChargeSchemeInstance, action:'save'])],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('submitButton','g',95,['name':("create"),'id':("newDepositTaxFeeChargeScheme"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue create?',
                                function(){
                                    checkIfAllowed('CFG01402', 'form#depositTaxChargeSchemeForm', 'Override create Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                             
                        """)],-1)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',96,['class':("list"),'action':("index")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',107,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',108,[:],1)
printHtmlPart(27)
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
