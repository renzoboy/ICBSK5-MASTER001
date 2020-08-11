import icbs.tellering.TxnBreakdown
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_transactionBreakdown_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/transactionBreakdown/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: transactionBreakdownInstance, field: 'debitAcct', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("transactionBreakdown.debitAcct.label"),'default':("Debit Acct")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("debitAcct"),'required':(""),'value':(transactionBreakdownInstance?.debitAcct),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(transactionBreakdownInstance),'field':("debitAcct")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(transactionBreakdownInstance),'field':("debitAcct")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: transactionBreakdownInstance, field: 'creditAcct', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("transactionBreakdown.creditAcct.label"),'default':("Credit Acct")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("creditAcct"),'required':(""),'value':(transactionBreakdownInstance?.creditAcct),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(transactionBreakdownInstance),'field':("creditAcct")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(transactionBreakdownInstance),'field':("creditAcct")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: transactionBreakdownInstance, field: 'debitAmt', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("transactionBreakdown.debitAmt.label"),'default':("Debit Amt")],-1)
printHtmlPart(2)
invokeTag('textField','g',51,['name':("debitAmt"),'required':(""),'value':(transactionBreakdownInstance?.debitAmt),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(transactionBreakdownInstance),'field':("debitAmt")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(transactionBreakdownInstance),'field':("debitAmt")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: transactionBreakdownInstance, field: 'creditAmt', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',68,['code':("transactionBreakdown.creditAmt.label"),'default':("Credit Amt")],-1)
printHtmlPart(12)
invokeTag('textField','g',71,['name':("creditAmt"),'value':(transactionBreakdownInstance?.creditAmt),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(transactionBreakdownInstance),'field':("creditAmt")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(transactionBreakdownInstance),'field':("creditAmt")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: transactionBreakdownInstance, field: 'txnDate', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("transactionBreakdown.txnDate.label"),'default':("Txn Date")],-1)
printHtmlPart(12)
invokeTag('customDatePicker','g',91,['name':("txnDate"),'precision':("day"),'class':("form-control"),'value':(transactionBreakdownInstance?.txnDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',98,['bean':(transactionBreakdownInstance),'field':("txnDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',101,['bean':(transactionBreakdownInstance),'field':("txnDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: transactionBreakdownInstance, field: 'currency', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',108,['code':("transactionBreakdown.currency.label"),'default':("Currency")],-1)
printHtmlPart(12)
invokeTag('select','g',111,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'value':(transactionBreakdownInstance?.currency?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',118,['bean':(transactionBreakdownInstance),'field':("currency")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',121,['bean':(transactionBreakdownInstance),'field':("currency")],1)
printHtmlPart(15)
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
