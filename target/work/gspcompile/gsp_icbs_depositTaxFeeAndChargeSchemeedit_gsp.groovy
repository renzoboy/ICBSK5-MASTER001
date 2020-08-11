import icbs.deposit.DepositTaxFeeAndChargeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemeedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',58,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',59,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/depositTaxFeeAndChargeScheme'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',64,['tag':("breadcrumbs")],2)
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
invokeTag('message','g',73,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',74,['bean':(depositTaxFeeAndChargeSchemeInstance),'var':("error")],4)
printHtmlPart(19)
})
invokeTag('hasErrors','g',76,['bean':(depositTaxFeeAndChargeSchemeInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(20)
invokeTag('hiddenField','g',78,['name':("version"),'value':(depositTaxFeeAndChargeSchemeInstance?.version)],-1)
printHtmlPart(21)
invokeTag('render','g',80,['template':("form")],-1)
printHtmlPart(22)
})
invokeTag('form','g',83,['id':("depositTaxChargeSchemeForm"),'url':([resource:depositTaxFeeAndChargeSchemeInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('submitButton','g',97,['name':("create"),'id':("editDepositTaxFeeChargeScheme"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to continue transaction?',
                                function(){
                                    checkIfAllowed('CFG01403', 'form#depositTaxChargeSchemeForm', 'Override edit Deposit Interest Scheme.', null);
                                },
                                function(){
                                    return;
                                });                                 
                            """)],-1)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',98,['class':("list"),'action':("show"),'id':(depositTaxFeeAndChargeSchemeInstance.id)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',111,[:],1)
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
