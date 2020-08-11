import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_fundTransfer_templates_transactionDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/fundTransfer/templates/_transactionDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['id':("fundingAcct"),'name':("fundingAcct.id"),'value':(fundTransferInstance?.fundingAcct?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("destinationAcct"),'name':("destinationAcct.id"),'value':(fundTransferInstance?.destinationAcct?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: fundTransferInstance, field: 'txnTemplate', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',13,['code':("fundTransfer.txnTemplate.label"),'default':("Transfer Type")],-1)
printHtmlPart(4)
invokeTag('select','g',16,['id':("txnTemplate"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(8))),'optionKey':("id"),'optionValue':("description"),'value':(fundTransferInstance?.txnTemplate?.id),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',21,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',22,['bean':(fundTransferInstance),'field':("txnTemplate")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',25,['bean':(fundTransferInstance),'field':("txnTemplate")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: fundTransferInstance, field: 'amt', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',32,['code':("fundTransfer.amt.label"),'default':("Amount")],-1)
printHtmlPart(12)
invokeTag('textField','g',36,['name':("amt"),'id':("amt"),'value':(fundTransferInstance?.amt),'class':("form-control truncated")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',41,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',42,['bean':(fundTransferInstance),'field':("amt")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',45,['bean':(fundTransferInstance),'field':("amt")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: fundTransferInstance, field: 'txnRef', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',53,['code':("fundTransfer.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(12)
invokeTag('textField','g',57,['name':("txnRef"),'id':("txnRef"),'value':(fundTransferInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',62,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',63,['bean':(fundTransferInstance),'field':("txnRef")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',66,['bean':(fundTransferInstance),'field':("txnRef")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: fundTransferInstance, field: 'txnDescription', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',74,['code':("fundTransfer.txnDescription.label"),'default':("Description")],-1)
printHtmlPart(12)
invokeTag('textField','g',78,['id':("txnDescription"),'name':("txnDescription"),'value':(fundTransferInstance?.txnDescription),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',83,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',84,['bean':(fundTransferInstance),'field':("txnDescription")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',87,['bean':(fundTransferInstance),'field':("txnDescription")],1)
printHtmlPart(21)
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
