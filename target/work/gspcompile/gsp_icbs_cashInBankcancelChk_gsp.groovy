import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankcancelChk_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/cancelChk.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('render','g',15,['template':("cashInBankDetails")],-1)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'checkNo', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',26,['name':("checkNo"),'id':("checkNo"),'maxlength':("25"),'required':(""),'readonly':("readonly"),'value':(cashInBankCheckbookInstance?.checkNo),'class':("form-control")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'reference', 'has-error'))
printHtmlPart(12)
invokeTag('textField','g',32,['name':("reference"),'maxlength':("50"),'required':(""),'readonly':("readonly"),'value':(cashInBankCheckbookInstance?.reference),'class':("form-control")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'checkVoucherNo', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',37,['name':("checkVoucherNo"),'id':("checkVoucherNo"),'maxlength':("50"),'required':(""),'readonly':("readonly"),'value':(cashInBankCheckbookInstance?.checkVoucherNo),'class':("form-control")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'checkAmt', 'has-error'))
printHtmlPart(15)
invokeTag('field','g',44,['class':("form-control truncated"),'name':("checkAmt"),'readonly':("readonly"),'value':(cashInBankCheckbookInstance?.checkAmt)],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',48,['id':("cashInBankCheckbookInstance"),'name':("cashInBankCheckbookInstance"),'value':(cashInBankCheckbookInstance.id)],-1)
printHtmlPart(17)
})
invokeTag('form','g',50,['id':("deposit"),'url':([resource:cashInBankInstance, action:'saveCancelChk']),'method':("PUT")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('actionSubmit','g',65,['class':("save"),'id':("saveCancelChk"),'name':("saveCancelChk"),'action':("saveCancelChk"),'value':(message(code: 'default.button.Save.label', default: 'Save')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    """)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',66,['action':("show"),'id':(cashInBankInstance.id)],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(24)
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
