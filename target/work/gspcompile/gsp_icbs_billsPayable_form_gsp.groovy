import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayable_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'currency', 'has-error'))
printHtmlPart(1)
invokeTag('select','g',4,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(billsPayableInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',9,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',10,['bean':(billsPayableInstance),'field':("currency")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',13,['bean':(billsPayableInstance),'field':("currency")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'glContra', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',19,['name':("glContra"),'id':("glContra"),'maxlength':("25"),'required':(""),'value':(billsPayableInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',24,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',25,['bean':(billsPayableInstance),'field':("glContra")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',28,['bean':(billsPayableInstance),'field':("glContra")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',33,['code':("txnTemplate.memoTxnType.label"),'default':("Gl Acct Description")],-1)
printHtmlPart(11)
invokeTag('textField','g',36,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'maxlength':("100"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',42,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',43,['bean':(txnTemplateInstance),'field':("memoTxnType")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',46,['bean':(txnTemplateInstance),'field':("memoTxnType")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'creditorName', 'has-error'))
printHtmlPart(18)
invokeTag('textField','g',51,['name':("creditorName"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.creditorName),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',56,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',57,['bean':(billsPayableInstance),'field':("creditorName")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',60,['bean':(billsPayableInstance),'field':("creditorName")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'dateOpened', 'has-error'))
printHtmlPart(20)
invokeTag('customDatePicker','g',71,['name':("dateOpened"),'precision':("day"),'class':("form-control"),'value':(billsPayableInstance?.dateOpened)],-1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',78,['bean':(billsPayableInstance),'field':("dateOpened")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',81,['bean':(billsPayableInstance),'field':("dateOpened")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'dueDate', 'has-error'))
printHtmlPart(22)
invokeTag('customDatePicker','g',91,['name':("dueDate"),'precision':("day"),'class':("form-control"),'value':(billsPayableInstance?.dueDate)],-1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',98,['bean':(billsPayableInstance),'field':("dueDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',101,['bean':(billsPayableInstance),'field':("dueDate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'pnDate', 'has-error'))
printHtmlPart(23)
invokeTag('customDatePicker','g',111,['name':("pnDate"),'precision':("day"),'class':("form-control"),'value':(billsPayableInstance?.pnDate)],-1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',118,['bean':(billsPayableInstance),'field':("pnDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',121,['bean':(billsPayableInstance),'field':("pnDate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'pnNo', 'has-error'))
printHtmlPart(24)
invokeTag('textField','g',127,['name':("pnNo"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.pnNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',132,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',133,['bean':(billsPayableInstance),'field':("pnNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',136,['bean':(billsPayableInstance),'field':("pnNo")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'pdcIssuedText', 'has-error'))
printHtmlPart(25)
invokeTag('textField','g',142,['name':("pdcIssuedText"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.pdcIssuedText),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',147,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',148,['bean':(billsPayableInstance),'field':("pdcIssuedText")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',151,['bean':(billsPayableInstance),'field':("pdcIssuedText")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'accountName', 'has-error'))
printHtmlPart(26)
invokeTag('textField','g',157,['name':("accountName"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.accountName),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',162,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',163,['bean':(billsPayableInstance),'field':("accountName")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',166,['bean':(billsPayableInstance),'field':("accountName")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'payee', 'has-error'))
printHtmlPart(27)
invokeTag('textField','g',172,['name':("payee"),'maxlength':("50"),'required':(""),'value':(billsPayableInstance?.payee),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',177,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',178,['bean':(billsPayableInstance),'field':("payee")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',181,['bean':(billsPayableInstance),'field':("payee")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'interestRate', 'has-error'))
printHtmlPart(28)
invokeTag('field','g',189,['class':("form-control"),'type':("number"),'name':("interestRate"),'value':(billsPayableInstance?.interestRate)],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',194,['error':(it?.code)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',195,['bean':(billsPayableInstance),'field':("interestRate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',198,['bean':(billsPayableInstance),'field':("interestRate")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: billsPayableInstance, field: 'status', 'has-error'))
printHtmlPart(29)
invokeTag('select','g',206,['id':("status"),'name':("status"),'from':(icbs.lov.ConfigItemStatus.list()),'optionKey':("id"),'required':(""),'value':(billsPayableInstance?.status?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(30)
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
