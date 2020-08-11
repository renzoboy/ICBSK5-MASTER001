import icbs.gl.AssetsHeldToMaturity
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_assetsHtm_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/assetsHtm/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
invokeTag('hiddenField','g',3,['name':("idto"),'id':("idto"),'value':(params.id)],-1)
printHtmlPart(1)
if(true && (assetsHtmInstance?.amount > 0)) {
printHtmlPart(0)
}
else {
printHtmlPart(2)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(3)
invokeTag('select','g',11,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(56),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
}
printHtmlPart(2)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'currency', 'has-error'))
printHtmlPart(5)
invokeTag('select','g',18,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(assetsHtmInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',23,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',24,['bean':(assetsHtmInstance),'field':("currency")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',27,['bean':(assetsHtmInstance),'field':("currency")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(12)
invokeTag('select','g',33,['id':("residentType"),'name':("residentType"),'from':(icbs.lov.ResidentType.findAll{status == true}),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(assetsHtmInstance?.residentType?.id),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
if(true && (assetsHtmInstance?.amount > 0)) {
printHtmlPart(2)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',39,['name':("xglCode"),'id':("xglCode"),'required':(""),'value':(assetsHtmInstance?.glCode),'onblur':("validateGlCode();"),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',40,['name':("glCode"),'id':("glCode"),'value':(assetsHtmInstance?.glCode)],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',45,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',46,['bean':(assetsHtmInstance),'field':("glCode")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',49,['bean':(assetsHtmInstance),'field':("glCode")],2)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'depcontra', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',54,['code':("txnTemplate.memoTxnType.label"),'default':("GL Acct Description")],-1)
printHtmlPart(22)
invokeTag('textField','g',57,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'value':(GlAccount.findByCode(assetsHtmInstance?.glCode).name),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',64,['bean':(txnTemplateInstance),'field':("memoTxnType")],3)
printHtmlPart(25)
})
invokeTag('hasErrors','g',67,['bean':(assetsHtmInstance),'field':("memoTxnType")],2)
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',74,['name':("glCode"),'id':("glCode"),'required':(""),'value':(assetsHtmInstance?.glCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',79,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',80,['bean':(assetsHtmInstance),'field':("glCode")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',83,['bean':(assetsHtmInstance),'field':("glCode")],2)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'depcontra', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',88,['code':("txnTemplate.memoTxnType.label"),'default':("GL Acct Description")],-1)
printHtmlPart(22)
invokeTag('textField','g',91,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',98,['bean':(txnTemplateInstance),'field':("memoTxnType")],3)
printHtmlPart(25)
})
invokeTag('hasErrors','g',101,['bean':(assetsHtmInstance),'field':("memoTxnType")],2)
printHtmlPart(26)
}
printHtmlPart(29)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error'))
printHtmlPart(30)
invokeTag('textField','g',109,['name':("htmAccrualDebitAcct"),'id':("htmAccrualDebitAcct"),'required':(""),'value':(assetsHtmInstance?.htmAccrualDebitAcct),'onblur':("validateHtmDebitGl();"),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',114,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',115,['bean':(assetsHtmInstance),'field':("htmAccrualDebitAcct")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',118,['bean':(assetsHtmInstance),'field':("htmAccrualDebitAcct")],1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',124,['code':("txnTemplate.memoTxnType.label"),'default':("Debit GL Description")],-1)
printHtmlPart(22)
invokeTag('textField','g',127,['readonly':("true"),'name':("htmAccrualDebitAcctDescription"),'id':("htmAccrualDebitAcctDescription"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',133,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',134,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',137,['bean':(txnTemplateInstance),'field':("memoTxnType")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error'))
printHtmlPart(33)
invokeTag('textField','g',142,['name':("htmAccrualCredittAcct"),'id':("htmAccrualCredittAcct"),'required':(""),'value':(assetsHtmInstance?.htmAccrualCredittAcct),'onblur':("validateHtmCreditGl();"),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',147,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',148,['bean':(assetsHtmInstance),'field':("htmAccrualCredittAcct")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',151,['bean':(assetsHtmInstance),'field':("htmAccrualCredittAcct")],1)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',157,['code':("txnTemplate.memoTxnType.label"),'default':("Credit GL Description")],-1)
printHtmlPart(22)
invokeTag('textField','g',160,['readonly':("true"),'name':("htmAccrualCreditAcctDescription"),'id':("htmAccrualCreditAcctDescription"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('message','g',166,['error':(it)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',167,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',170,['bean':(txnTemplateInstance),'field':("memoTxnType")],1)
printHtmlPart(26)
if(true && (assetsHtmInstance?.amount > 0)) {
printHtmlPart(2)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'amount', 'has-error'))
printHtmlPart(34)
invokeTag('field','g',178,['class':("form-control truncated"),'id':("viewhtmAmount"),'name':("viewhtmAmount"),'value':(assetsHtmInstance?.amount),'readonly':("true")],-1)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',183,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',184,['bean':(assetsHtmInstance),'field':("amount")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',187,['bean':(assetsHtmInstance),'field':("amount")],2)
printHtmlPart(4)
}
else {
printHtmlPart(27)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'amount', 'has-error'))
printHtmlPart(34)
invokeTag('field','g',196,['class':("form-control truncated"),'id':("htmAmount"),'name':("amount"),'value':(assetsHtmInstance?.amount)],-1)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',201,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',202,['bean':(assetsHtmInstance),'field':("amount")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',205,['bean':(assetsHtmInstance),'field':("amount")],2)
printHtmlPart(4)
}
printHtmlPart(2)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'interestRate', 'has-error'))
printHtmlPart(35)
invokeTag('field','g',213,['class':("form-control"),'style':("text-align:right;"),'id':("interestRate"),'name':("interestRate"),'value':(assetsHtmInstance?.interestRate)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',218,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',219,['bean':(assetsHtmInstance),'field':("interestRate")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',222,['bean':(assetsHtmInstance),'field':("interestRate")],1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'valueDate', 'has-error'))
printHtmlPart(37)
invokeTag('customDatePicker','g',230,['id':("valueDate"),'name':("valueDate"),'precision':("day"),'class':("form-control"),'value':(assetsHtmInstance?.valueDate)],-1)
printHtmlPart(38)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',236,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',237,['bean':(assetsHtmInstance),'field':("valueDate")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',240,['bean':(assetsHtmInstance),'field':("valueDate")],1)
printHtmlPart(39)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(40)
invokeTag('customDatePicker','g',246,['id':("maturityDate"),'name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(assetsHtmInstance?.maturityDate)],-1)
printHtmlPart(38)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',252,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',253,['bean':(assetsHtmInstance),'field':("maturityDate")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',256,['bean':(assetsHtmInstance),'field':("maturityDate")],1)
printHtmlPart(39)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'htmType', 'has-error'))
printHtmlPart(41)
invokeTag('select','g',261,['id':("htmTypeDesc"),'name':("htmTypeDesc"),'from':(icbs.gl.HtmType.findAll{status == true}),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(assetsHtmInstance?.status?.id),'class':("many-to-one form-control"),'onchange':("updateHtmForm(this.value);")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',266,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',267,['bean':(assetsHtmInstance),'field':("htmTypeDesc")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',270,['bean':(assetsHtmInstance),'field':("htmTypeDesc")],1)
printHtmlPart(42)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'discountAmount', 'has-error'))
printHtmlPart(43)
invokeTag('field','g',277,['class':("form-control truncated"),'id':("discountAmount"),'name':("discountAmount"),'value':(assetsHtmInstance?.discountAmount)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',282,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',283,['bean':(assetsHtmInstance),'field':("discountAmount")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',286,['bean':(assetsHtmInstance),'field':("discountAmount")],1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'description', 'has-error'))
printHtmlPart(44)
invokeTag('textField','g',293,['name':("xHtmDesc"),'id':("xHtmDesc"),'required':(""),'value':("BROKER/DEALER"),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',294,['name':("htmDescription"),'id':("htmDescription"),'value':("BROKER/DEALER")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',299,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',300,['bean':(assetsHtmInstance),'field':("htmDescription")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',303,['bean':(assetsHtmInstance),'field':("htmDescription")],1)
printHtmlPart(39)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'htmIssuer', 'has-error'))
printHtmlPart(45)
invokeTag('textField','g',308,['name':("htmIssuer"),'id':("htmIssuer"),'required':(""),'value':(assetsHtmInstance?.htmIssuer),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',313,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',314,['bean':(assetsHtmInstance),'field':("htmIssuer")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',317,['bean':(assetsHtmInstance),'field':("htmIssuer")],1)
printHtmlPart(46)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'effectiveYield', 'has-error'))
printHtmlPart(47)
invokeTag('field','g',323,['class':("form-control"),'style':("text-align:right;"),'id':("effectiveYield"),'name':("effectiveYield"),'value':(assetsHtmInstance?.effectiveYield)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',330,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',332,['bean':(assetsHtmInstance),'field':("effectiveYield")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',334,['bean':(assetsHtmInstance),'field':("effectiveYield")],1)
printHtmlPart(48)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'reference', 'has-error'))
printHtmlPart(49)
invokeTag('textField','g',338,['name':("reference"),'id':("reference"),'required':(""),'value':(assetsHtmInstance?.reference),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',343,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',344,['bean':(assetsHtmInstance),'field':("reference")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',347,['bean':(assetsHtmInstance),'field':("reference")],1)
printHtmlPart(50)
invokeTag('hiddenField','g',353,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',354,['id':("branchRunDate"),'name':("branchRunDate"),'value':(g.formatDate(date: (runDate), format: 'MM/dd/yyyy'))],-1)
printHtmlPart(0)
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
