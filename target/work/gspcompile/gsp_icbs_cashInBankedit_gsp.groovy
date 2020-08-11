import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'cashInBank.label', default: 'CashInBank'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
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
invokeTag('message','g',22,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',23,['bean':(clearingBankInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',25,['bean':(clearingBankInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',28,['name':("ccashInnBank"),'id':("ccashInnBank"),'value':(params.id)],-1)
printHtmlPart(20)
invokeTag('render','g',29,['template':("form")],-1)
printHtmlPart(21)
})
invokeTag('form','g',31,['id':("edit"),'url':([action:'update',controller:'cashInBank',resource:cashInBankInstance]),'method':("POST")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',33,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('actionSubmit','g',45,['class':("save"),'id':("editClearingBank"),'name':("edit"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#edit', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    """)],-1)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',46,['action':("show"),'id':(cashInBankInstance.id)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',48,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',49,[:],1)
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
