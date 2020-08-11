import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBank_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'type', 'has-error'))
printHtmlPart(1)
invokeTag('select','g',6,['id':("type"),'name':("type.id"),'from':(icbs.lov.DepositType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(cashInBankInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',11,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',12,['bean':(cashInBankInstance),'field':("type")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',15,['bean':(cashInBankInstance),'field':("type")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'currency', 'has-error'))
printHtmlPart(8)
invokeTag('select','g',22,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(cashInBankInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',27,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',28,['bean':(cashInBankInstance),'field':("currency")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',31,['bean':(cashInBankInstance),'field':("currency")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'bankName', 'has-error'))
printHtmlPart(9)
invokeTag('textField','g',37,['name':("bankName"),'maxlength':("30"),'required':(""),'value':(cashInBankInstance?.bankName),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',42,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',43,['bean':(cashInBankInstance),'field':("bankName")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',46,['bean':(cashInBankInstance),'field':("bankName")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'bankBranch', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',52,['name':("bankBranch"),'maxlength':("25"),'required':(""),'value':(cashInBankInstance?.bankBranch),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',58,['bean':(cashInBankInstance),'field':("bankBranch")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',61,['bean':(cashInBankInstance),'field':("bankBranch")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'bankAddress', 'has-error'))
printHtmlPart(11)
invokeTag('textField','g',67,['name':("bankAddress"),'maxlength':("50"),'required':(""),'value':(cashInBankInstance?.bankAddress),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',72,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',73,['bean':(cashInBankInstance),'field':("bankAddress")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',76,['bean':(cashInBankInstance),'field':("bankAddress")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'acctNo', 'has-error'))
printHtmlPart(12)
invokeTag('textField','g',82,['name':("acctNo"),'maxlength':("25"),'required':(""),'value':(cashInBankInstance?.acctNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',87,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',88,['bean':(cashInBankInstance),'field':("acctNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',91,['bean':(cashInBankInstance),'field':("acctNo")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'intRate', 'has-error'))
printHtmlPart(13)
invokeTag('field','g',99,['class':("form-control"),'type':("number"),'name':("intRate"),'value':(fieldValue(bean: cashInBankInstance, field: 'intRate'))],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',104,['error':(it?.code)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',105,['bean':(cashInBankInstance),'field':("intRate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',108,['bean':(cashInBankInstance),'field':("intRate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'openDate', 'has-error'))
printHtmlPart(14)
invokeTag('customDatePicker','g',118,['name':("openDate"),'precision':("day"),'class':("form-control"),'value':(cashInBankInstance?.openDate)],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',124,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',125,['bean':(cashInBankInstance),'field':("openDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',128,['bean':(cashInBankInstance),'field':("openDate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(16)
invokeTag('customDatePicker','g',135,['name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(cashInBankInstance?.maturityDate)],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',141,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',142,['bean':(cashInBankInstance),'field':("maturityDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',145,['bean':(cashInBankInstance),'field':("maturityDate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'glContra', 'has-error'))
printHtmlPart(17)
invokeTag('textField','g',151,['name':("glContra"),'id':("glContra"),'maxlength':("25"),'required':(""),'value':(cashInBankInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',156,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',157,['bean':(cashInBankInstance),'field':("glContra")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',160,['bean':(cashInBankInstance),'field':("glContra")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',166,['code':("txnTemplate.memoTxnType.label"),'default':("Gl Acct Description")],-1)
printHtmlPart(20)
invokeTag('textField','g',169,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'maxlength':("100"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',175,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',176,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',179,['bean':(txnTemplateInstance),'field':("memoTxnType")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'remarks', 'has-error'))
printHtmlPart(27)
invokeTag('textField','g',185,['name':("remarks"),'maxlength':("100"),'required':(""),'value':(cashInBankInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',190,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',191,['bean':(cashInBankInstance),'field':("remarks")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',194,['bean':(cashInBankInstance),'field':("remarks")],1)
printHtmlPart(28)
invokeTag('hiddenField','g',1,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
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
