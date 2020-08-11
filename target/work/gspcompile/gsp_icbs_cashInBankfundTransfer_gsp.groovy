import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankfundTransfer_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/fundTransfer.gsp" }
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
invokeTag('message','g',21,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',22,['bean':(cashInBankInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',24,['bean':(cashInBankInstance)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(19)
invokeTag('select','g',30,['id':("drTxnType"),'name':("drTxnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(44),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'bankName', 'has-error'))
printHtmlPart(21)
invokeTag('select','g',36,['id':("drBank"),'name':("drBank"),'from':(icbs.gl.CashInBank.findAllByStatus(icbs.lov.DepositStatus.read(2))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(23)
invokeTag('select','g',43,['id':("crTxnType"),'name':("crTxnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(43),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'bankName', 'has-error'))
printHtmlPart(24)
invokeTag('select','g',49,['id':("crBank"),'name':("crBank"),'from':(icbs.gl.CashInBank.findAllByStatus(icbs.lov.DepositStatus.read(2))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(25)
invokeTag('field','g',56,['class':("form-control truncated"),'id':("debitAdjustment"),'name':("debitAdjustment"),'value':("")],-1)
printHtmlPart(26)
invokeTag('field','g',63,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(27)
invokeTag('field','g',69,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(28)
})
invokeTag('form','g',74,['id':("create"),'url':([resource:cashInBankInstance, action:'saveFundTransfer'])],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('submitButton','g',87,['id':("newFT"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue Cash in Bank Fund Transfer Transaction?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#create', 'Create New Cash in Bank Checkbook', null); 
                                },
                                function(){
                                    return;
                            }); 
                """)],-1)
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',88,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',88,['action':("index")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(33)
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
