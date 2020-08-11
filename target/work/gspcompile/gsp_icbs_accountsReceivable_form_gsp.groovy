import icbs.cif.Customer
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivable_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'customer', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("loanApplication.customer.label"),'default':("Customer Name")],-1)
printHtmlPart(3)
invokeTag('field','g',9,['name':("customer-name"),'value':(accountsReceivableInstance?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',10,['id':("customer"),'name':("customer.id"),'value':(accountsReceivableInstance?.customer?.id)],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(it)
printHtmlPart(7)
})
invokeTag('hasErrors','g',14,['bean':(accountsReceivableInstance),'field':("customer")],1)
printHtmlPart(8)
if(true && (accountsReceivableInstance?.balance > 0)) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(11)
invokeTag('select','g',61,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(47),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
}
printHtmlPart(10)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'currency', 'has-error'))
printHtmlPart(13)
invokeTag('select','g',66,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(accountsReceivableInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',68,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',69,['bean':(accountsReceivableInstance),'field':("currency")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',70,['bean':(accountsReceivableInstance),'field':("currency")],1)
printHtmlPart(12)
invokeTag('hiddenField','g',73,['id':("branchRunDate"),'name':("branchRunDate"),'value':(g.formatDate(date: (runDate), format: 'MM/dd/yyyy'))],-1)
printHtmlPart(0)
if(true && (accountsReceivableInstance)) {
printHtmlPart(4)
invokeTag('hiddenField','g',77,['id':("accountsReceivableId"),'name':("accountsReceivableId"),'value':(params?.id)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',81,['id':("xarCreatedDate"),'name':("xarCreatedDate"),'value':(g.formatDate(date: (accountsReceivableInstance?.arCreatedDate), format: 'MM/dd/yyyy'))],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (accountsReceivableInstance?.balance > 0)) {
printHtmlPart(10)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'balance', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',86,['code':("txnTemplate.memoTxnType.label"),'default':("Balance*")],-1)
printHtmlPart(22)
invokeTag('textField','g',88,['readonly':("true"),'name':("errexistbalance"),'id':("errexistbalance"),'value':(accountsReceivableInstance?.balance),'class':("form-control truncated")],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',91,['name':("existbalance"),'id':("existbalance"),'value':(accountsReceivableInstance?.balance)],-1)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
invokeTag('message','g',94,['error':(it)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',94,['bean':(accountsReceivableInstance),'field':("memoTxnType")],3)
printHtmlPart(27)
})
invokeTag('hasErrors','g',96,['bean':(accountsReceivableInstance),'field':("memoTxnType")],2)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error'))
printHtmlPart(29)
invokeTag('textField','g',106,['name':("glContra"),'id':("glContra"),'required':(""),'value':(accountsReceivableInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('message','g',107,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',108,['bean':(accountsReceivableInstance),'field':("glContra")],3)
printHtmlPart(18)
})
invokeTag('hasErrors','g',109,['bean':(accountsReceivableInstance),'field':("glContra")],2)
printHtmlPart(12)
}
else {
printHtmlPart(10)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'balance', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',117,['code':("txnTemplate.memoTxnType.label"),'default':("Balance*")],-1)
printHtmlPart(22)
invokeTag('textField','g',122,['name':("existbalance"),'id':("existbalance"),'value':(accountsReceivableInstance?.balance),'onblur':("updateBalance();"),'class':("form-control truncated")],-1)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
invokeTag('message','g',128,['error':(it)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',128,['bean':(accountsReceivableInstance),'field':("memoTxnType")],3)
printHtmlPart(27)
})
invokeTag('hasErrors','g',130,['bean':(accountsReceivableInstance),'field':("memoTxnType")],2)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error'))
printHtmlPart(29)
invokeTag('textField','g',140,['name':("glContra"),'id':("glContra"),'required':(""),'value':(accountsReceivableInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('message','g',141,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',142,['bean':(accountsReceivableInstance),'field':("glContra")],3)
printHtmlPart(18)
})
invokeTag('hasErrors','g',143,['bean':(accountsReceivableInstance),'field':("glContra")],2)
printHtmlPart(31)
}
printHtmlPart(0)
invokeTag('hiddenField','g',145,['name':("balance"),'id':("balance"),'value':("")],-1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',154,['code':("txnTemplate.memoTxnType.label"),'default':("Gl Acct Description")],-1)
printHtmlPart(33)
invokeTag('textField','g',157,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'maxlength':("100"),'value':(""),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(34)
createTagBody(1, {->
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('message','g',162,['error':(it)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',162,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(27)
})
invokeTag('hasErrors','g',164,['bean':(txnTemplateInstance),'field':("memoTxnType")],1)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'requiredAllowance', 'has-error'))
printHtmlPart(36)
invokeTag('field','g',173,['class':("form-control truncated"),'id':("requiredAllowance"),'name':("requiredAllowance"),'value':(accountsReceivableInstance?.requiredAllowance)],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',177,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',177,['bean':(accountsReceivableInstance),'field':("requiredAllowance")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',178,['bean':(accountsReceivableInstance),'field':("requiredAllowance")],1)
printHtmlPart(37)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(38)
invokeTag('customDatePicker','g',188,['id':("maturityDate"),'name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(accountsReceivableInstance?.maturityDate)],-1)
printHtmlPart(39)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',193,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',193,['bean':(accountsReceivableInstance),'field':("maturityDate")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',194,['bean':(accountsReceivableInstance),'field':("maturityDate")],1)
printHtmlPart(37)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'receivableName', 'has-error'))
printHtmlPart(40)
invokeTag('textField','g',204,['id':("receivableName"),'name':("receivableName"),'required':(""),'value':(accountsReceivableInstance?.receivableName),'class':("form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',207,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',207,['bean':(accountsReceivableInstance),'field':("receivableName")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',208,['bean':(accountsReceivableInstance),'field':("receivableName")],1)
printHtmlPart(41)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'description', 'has-error'))
printHtmlPart(42)
invokeTag('textField','g',219,['name':("description"),'id':("description"),'required':(""),'value':(accountsReceivableInstance?.description),'class':("form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',222,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',222,['bean':(accountsReceivableInstance),'field':("description")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',223,['bean':(accountsReceivableInstance),'field':("description")],1)
printHtmlPart(41)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'reference', 'has-error'))
printHtmlPart(43)
invokeTag('textField','g',234,['id':("reference"),'name':("reference"),'maxlength':("100"),'required':(""),'value':(accountsReceivableInstance?.reference),'class':("form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',236,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',237,['bean':(accountsReceivableInstance),'field':("reference")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',238,['bean':(accountsReceivableInstance),'field':("reference")],1)
printHtmlPart(12)
invokeTag('hiddenField','g',241,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
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
