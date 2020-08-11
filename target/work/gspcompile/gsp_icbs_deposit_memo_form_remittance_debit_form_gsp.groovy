import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_memo_form_remittance_debit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/memo/form/remittance/debit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',10,['id':("txnType"),'name':("tnxType.id"),'value':("9")],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',11,['id':("acct"),'name':("acct.id"),'value':(adjustmentInstance?.acct?.id?:depositInstance?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: remittanceInstance, field: 'type', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("remittance.type.label"),'default':("Memo Type")],-1)
printHtmlPart(5)
invokeTag('select','g',17,['id':("type"),'name':("type.id"),'onchange':("changeMemoForm('remittance')"),'from':(icbs.lov.MemoType.findAllByStatus(true)),'optionKey':("id"),'optionValue':("description"),'value':(remittanceInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',22,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',23,['bean':(remittanceInstance),'field':("type")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',26,['bean':(remittanceInstance),'field':("type")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: remittanceInstance, field: 'txnTemplate', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',31,['code':("remittance.txnTemplate.label"),'default':("Transaction Code")],-1)
printHtmlPart(5)
invokeTag('select','g',34,['id':("txnTemplate"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(2),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':(adjustmentInstance?.txnTemplate?.id),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',39,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',40,['bean':(remittanceInstance),'field':("txnTemplate")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',43,['bean':(remittanceInstance),'field':("txnTemplate")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: remittanceInstance, field: 'amt', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',48,['code':("remittance.amt.label"),'default':("Amount")],-1)
printHtmlPart(14)
invokeTag('textField','g',51,['name':("amt"),'value':(remittanceInstance?.amt),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',56,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',57,['bean':(remittanceInstance),'field':("amt")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',60,['bean':(remittanceInstance),'field':("amt")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: remittanceInstance, field: 'txnRef', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',65,['code':("remittance.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(14)
invokeTag('textField','g',68,['name':("txnRef"),'value':(remittanceInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',73,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',74,['bean':(remittanceInstance),'field':("txnRef")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',77,['bean':(remittanceInstance),'field':("txnRef")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: remittanceInstance, field: 'txnDescription', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',82,['code':("remittance.txnDescription.label"),'default':("Description")],-1)
printHtmlPart(5)
invokeTag('textField','g',85,['name':("txnDescription"),'value':(remittanceInstance?.txnDescription),'class':("form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',90,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',91,['bean':(remittanceInstance),'field':("txnDescription")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',94,['bean':(remittanceInstance),'field':("txnDescription")],1)
printHtmlPart(17)
invokeTag('submitButton','g',99,['name':("submit"),'class':("btn btn-primary"),'id':("submitFrm1"),'style':("display:none")],-1)
printHtmlPart(18)
if(true && (flash.message == "Memo Remittance Successfully made.|success|alert")) {
printHtmlPart(19)
}
printHtmlPart(20)
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
