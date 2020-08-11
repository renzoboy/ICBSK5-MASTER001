import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayable_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'customer', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("loanApplication.customer.label"),'default':("Customer Name")],-1)
printHtmlPart(2)
invokeTag('field','g',7,['name':("customer-name"),'value':(accountsPayableInstance?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',8,['id':("customer"),'name':("customer.id"),'value':(accountsPayableInstance?.customer?.id)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(it)
printHtmlPart(6)
})
invokeTag('hasErrors','g',12,['bean':(accountsPayableInstance),'field':("customer")],1)
printHtmlPart(7)
if(true && (accountsPayableInstance?.balance > 0)) {
printHtmlPart(8)
}
else {
printHtmlPart(0)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(9)
invokeTag('select','g',56,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(50),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(10)
}
printHtmlPart(0)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'currency', 'has-error'))
printHtmlPart(11)
invokeTag('select','g',61,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(accountsPayableInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',64,['bean':(accountsPayableInstance),'field':("currency")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',65,['bean':(accountsPayableInstance),'field':("currency")],1)
printHtmlPart(17)
if(true && (accountsPayableInstance?.balance > 0)) {
printHtmlPart(0)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'balance', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',76,['code':("txnTemplate.memoTxnType.label"),'default':("Balance")],-1)
printHtmlPart(19)
invokeTag('textField','g',78,['readonly':("true"),'name':("existbalance"),'id':("existbalance"),'value':(accountsPayableInstance?.balance),'class':("form-control truncated")],-1)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',84,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',84,['bean':(txnTemplateInstance),'field':("memoTxnType")],3)
printHtmlPart(24)
})
invokeTag('hasErrors','g',86,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'glContra', 'has-error'))
printHtmlPart(26)
invokeTag('textField','g',96,['name':("glContra"),'id':("glContra"),'required':(""),'value':(accountsPayableInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',98,['bean':(accountsPayableInstance),'field':("glContra")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',99,['bean':(accountsPayableInstance),'field':("glContra")],2)
printHtmlPart(10)
}
else {
printHtmlPart(0)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'balance', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',106,['code':("txnTemplate.memoTxnType.label"),'default':("Balance")],-1)
printHtmlPart(19)
invokeTag('textField','g',112,['name':("existbalance"),'id':("existbalance"),'value':(accountsPayableInstance?.balance),'onblur':("updateBalance();"),'class':("form-control truncated")],-1)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',118,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',118,['bean':(txnTemplateInstance),'field':("memoTxnType")],3)
printHtmlPart(24)
})
invokeTag('hasErrors','g',120,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'glContra', 'has-error'))
printHtmlPart(26)
invokeTag('textField','g',130,['name':("glContra"),'id':("glContra"),'required':(""),'value':(accountsPayableInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('message','g',131,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',132,['bean':(accountsPayableInstance),'field':("glContra")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',133,['bean':(accountsPayableInstance),'field':("glContra")],2)
printHtmlPart(27)
}
printHtmlPart(28)
invokeTag('hiddenField','g',135,['name':("balance"),'id':("balance"),'value':("")],-1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',144,['code':("txnTemplate.memoTxnType.label"),'default':("Gl Acct Description")],-1)
printHtmlPart(30)
invokeTag('textField','g',147,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(31)
createTagBody(1, {->
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('message','g',152,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',152,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(24)
})
invokeTag('hasErrors','g',154,['bean':(txnTemplateInstance),'field':("memoTxnType")],1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'payable', 'has-error'))
printHtmlPart(33)
invokeTag('textField','g',163,['id':("payable"),'name':("payable"),'required':(""),'value':(accountsPayableInstance?.payable),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',165,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',166,['bean':(accountsPayableInstance),'field':("payable")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',167,['bean':(accountsReceivableInstance),'field':("payable")],1)
printHtmlPart(34)
invokeTag('hiddenField','g',169,['name':("accountsPayableId"),'id':("accountsPayableId"),'value':(params.id)],-1)
printHtmlPart(0)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'particulars', 'has-error'))
printHtmlPart(35)
invokeTag('textField','g',179,['id':("reference"),'name':("reference"),'required':(""),'value':(accountsPayableInstance?.reference),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',181,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',182,['bean':(accountsPayableInstance),'field':("reference")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',183,['bean':(accountsPayableInstance),'field':("reference")],1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: accountsPayableInstance, field: 'particulars', 'has-error'))
printHtmlPart(37)
invokeTag('textField','g',193,['id':("particulars"),'name':("particulars"),'required':(""),'value':(accountsPayableInstance?.particulars),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',195,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',196,['bean':(accountsPayableInstance),'field':("particulars")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',197,['bean':(accountsPayableInstance),'field':("particulars")],1)
printHtmlPart(10)
invokeTag('hiddenField','g',200,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
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
