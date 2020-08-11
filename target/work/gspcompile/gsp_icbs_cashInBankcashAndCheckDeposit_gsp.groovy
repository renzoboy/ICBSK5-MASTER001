import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankcashAndCheckDeposit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/cashAndCheckDeposit.gsp" }
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
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(13)
invokeTag('select','g',36,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(45),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
invokeTag('field','g',42,['class':("form-control truncated"),'id':("cashDeposit"),'name':("cashDeposit"),'value':("")],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',45,['name':("cashInBankId"),'id':("cashInBankId"),'value':(params.id)],-1)
printHtmlPart(16)
invokeTag('field','g',49,['class':("form-control truncated"),'id':("checkDeposit"),'name':("checkDeposit"),'value':("")],-1)
printHtmlPart(17)
invokeTag('field','g',55,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(18)
invokeTag('field','g',61,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(19)
})
invokeTag('form','g',65,['id':("deposit"),'url':([resource:cashInBankInstance, action:'saveDeposit']),'method':("PUT")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('actionSubmit','g',80,['class':("save"),'id':("saveDeposit"),'name':("saveDeposit"),'action':("saveDeposit"),'value':(message(code: 'default.button.Save.label', default: 'Save')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    """)],-1)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',81,['action':("show"),'id':(cashInBankInstance.id)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',84,[:],1)
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
