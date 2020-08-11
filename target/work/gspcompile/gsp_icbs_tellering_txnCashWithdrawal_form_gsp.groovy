import icbs.tellering.TxnDepositAcctLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashWithdrawal_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashWithdrawal/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("depAmt"),'name':("depAmt"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(5),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.requirePassbook)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(5)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (!txnCashWithdrawalInstance?.acct)) {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('render','g',50,['template':("/tellering/details/depositDetails"),'model':([depositInstance:txnCashWithdrawalInstance?.acct])],-1)
printHtmlPart(10)
if(true && (txnCashWithdrawalInstance?.acct)) {
printHtmlPart(11)
invokeTag('render','g',52,['template':("/tellering/details/signatureDetails"),'model':([depositInstance:txnCashWithdrawalInstance?.acct])],-1)
printHtmlPart(11)
invokeTag('render','g',53,['template':("/tellering/details/signatoryDetails"),'model':([depositInstance:txnCashWithdrawalInstance?.acct])],-1)
printHtmlPart(10)
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnCashWithdrawalInstance?.acct, field: 'availableBalAmt', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',61,['type':("number"),'readonly':("true"),'name':("passbookBal"),'id':("passbookBal"),'required':(""),'value':(txnCashWithdrawalInstance?.acct?.availableBalAmt),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnCashWithdrawalInstance, field: 'debitAmt', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',71,['type':("number"),'id':("debitAmt"),'name':("debitAmt"),'required':(""),'value':(txnCashWithdrawalInstance?.debitAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnCashWithdrawalInstance, field: 'txnRef', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',78,['code':("txnCashWithdrawal.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(18)
invokeTag('textArea','g',81,['id':("txnRef"),'name':("txnRef"),'required':(""),'value':(txnCashWithdrawalInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(19)
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
