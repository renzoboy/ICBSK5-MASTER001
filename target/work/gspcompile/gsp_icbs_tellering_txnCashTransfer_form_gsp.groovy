import icbs.tellering.TxnTellerCash
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashTransfer_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashTransfer/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(2),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: txnCashTransferInstance, field: 'user', 'has-error'))
printHtmlPart(6)
invokeTag('message','g',156,['code':("txnCashTransfer.user.label"),'default':("Destination Teller")],-1)
printHtmlPart(7)
invokeTag('select','g',160,['id':("user"),'name':("user"),'from':(jList),'optionKey':("id"),'optionValue':("name"),'value':(txnCashTransferInstance?.user?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnCashTransferInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',166,['code':("txnCashTransfer.txnAmt.label"),'default':("Total Cash Transferred")],-1)
printHtmlPart(10)
invokeTag('field','g',171,['type':("text"),'id':("txnAmt"),'name':("txnAmt"),'value':(fieldValue(bean: txnCashTransferInstance, field: 'txnAmt')),'onkeyup':("numberFormat();"),'step':("0.001"),'class':("txn-amt form-control")],-1)
printHtmlPart(11)
expressionOut.print(fieldValue(bean: txnCashTransferInstance, field: 'txnAmt'))
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnCashTransferInstance, field: 'txnRef', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',188,['code':("txnCashTransfer.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(7)
invokeTag('textArea','g',192,['name':("txnRef"),'value':(txnCashTransferInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(14)
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
