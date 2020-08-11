import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayablecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/billsPayable'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(1)
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
invokeTag('message','g',20,['error':("${error.field} - ${error}")],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',21,['bean':(billsPayableInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',23,['bean':(billsPayableInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('render','g',26,['template':("form")],-1)
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(21)
})
invokeTag('javascript','g',80,[:],4)
printHtmlPart(10)
})
invokeTag('form','g',81,['id':("create"),'url':([resource:billsPayableInstance, action:'save'])],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('submitButton','g',94,['id':("newBP"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue create Bills Payable ledger?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#create', 'Create New Bills Payable Ledger', null); 
                                },
                                function(){
                                    return;
                            }); 
                """)],-1)
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',95,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',95,['action':("index")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',98,[:],1)
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
