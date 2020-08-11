import icbs.tellering.TxnDepositAcctLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashDeposit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashDeposit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('textField','g',2,['disable':("disabled"),'name':("pb"),'style':("display:none")],-1)
printHtmlPart(0)
invokeTag('textField','g',3,['id':("depAmt"),'name':("depAmt"),'value':("0"),'style':("display:none")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(3),[sort:"code", order:"asc"])) ) {
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
if(true && (!txnCashDepositInstance?.acct)) {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('render','g',25,['template':("/tellering/details/depositDetails"),'model':([depositInstance:txnCashDepositInstance?.acct])],-1)
printHtmlPart(10)
if(true && (txnCashDepositInstance?.acct)) {
printHtmlPart(11)
invokeTag('render','g',28,['template':("/tellering/details/signatureDetails"),'model':([depositInstance:txnCashDepositInstance?.acct])],-1)
printHtmlPart(12)
invokeTag('render','g',29,['template':("/tellering/details/signatoryDetails"),'model':([depositInstance:txnCashDepositInstance?.acct])],-1)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnCashDepositInstance, field: 'passbookBal', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',38,['id':("passbookBal"),'name':("passbookBal"),'required':(""),'value':(txnCashDepositInstance?.passbookBal),'class':("form-control truncated")],-1)
printHtmlPart(10)
invokeTag('textField','g',39,['id':("passbooksw"),'name':("passbooksw"),'value':(txnCashDepositInstance?.passbookBal),'class':("form-control"),'style':("display:none")],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnCashDepositInstance, field: 'creditAmt', 'has-error'))
printHtmlPart(17)
expressionOut.print(txnCashDepositInstance?.creditAmt)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnCashDepositInstance, field: 'txnRef', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',56,['code':("txnCashDeposit.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(20)
invokeTag('textArea','g',59,['id':("txnRef"),'name':("txnRef"),'required':(""),'value':(txnCashDepositInstance?.txnRef),'class':("form-control")],-1)
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
