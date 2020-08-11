import icbs.tellering.TxnBreakdown
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_transactionBreakdownshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/transactionBreakdown/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'transactionBreakdown.label', default: 'TxnBreakdown'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (transactionBreakdownInstance?.debitAcct)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("transactionBreakdown.debitAcct.label"),'default':("Debit Acct")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',22,['bean':(transactionBreakdownInstance),'field':("debitAcct")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (transactionBreakdownInstance?.creditAcct)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("transactionBreakdown.creditAcct.label"),'default':("Credit Acct")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',31,['bean':(transactionBreakdownInstance),'field':("creditAcct")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (transactionBreakdownInstance?.debitAmt)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("transactionBreakdown.debitAmt.label"),'default':("Debit Amt")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(transactionBreakdownInstance),'field':("debitAmt")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (transactionBreakdownInstance?.creditAmt)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("transactionBreakdown.creditAmt.label"),'default':("Credit Amt")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',49,['bean':(transactionBreakdownInstance),'field':("creditAmt")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (transactionBreakdownInstance?.txnDate)) {
printHtmlPart(19)
invokeTag('message','g',56,['code':("transactionBreakdown.txnDate.label"),'default':("Txn Date")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',58,['date':(transactionBreakdownInstance?.txnDate)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (transactionBreakdownInstance?.currency)) {
printHtmlPart(21)
invokeTag('message','g',65,['code':("transactionBreakdown.currency.label"),'default':("Currency")],-1)
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(transactionBreakdownInstance?.currency?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("currency"),'action':("show"),'id':(transactionBreakdownInstance?.currency?.id)],4)
printHtmlPart(11)
}
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',75,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',75,['class':("edit"),'action':("edit"),'resource':(transactionBreakdownInstance)],4)
printHtmlPart(25)
invokeTag('actionSubmit','g',76,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(26)
})
invokeTag('form','g',78,['url':([resource:transactionBreakdownInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(30)
invokeTag('message','g',83,['code':("default.home.label")],-1)
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',84,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',84,['class':("list"),'action':("index")],3)
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',85,['class':("create"),'action':("create")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(34)
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
