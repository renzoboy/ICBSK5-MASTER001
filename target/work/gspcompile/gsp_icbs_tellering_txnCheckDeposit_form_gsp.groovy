import icbs.tellering.TxnDepositAcctLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckDeposit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckDeposit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(4),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.requirePassbook)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('hiddenField','g',15,['id':("deposit_no"),'name':("deposit_no"),'value':(deposit)],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',16,['id':("depAmt"),'name':("depAmt"),'value':("0")],-1)
printHtmlPart(8)
if(true && (!txnCheckDepositInstance?.acct)) {
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('render','g',26,['template':("/tellering/details/depositDetails"),'model':([depositInstance:txnCheckDepositInstance?.acct])],-1)
printHtmlPart(11)
if(true && (txnCheckDepositInstance?.acct)) {
printHtmlPart(12)
invokeTag('render','g',28,['template':("/tellering/details/signatureDetails"),'model':([depositInstance:txnCheckDepositInstance?.acct])],-1)
printHtmlPart(12)
invokeTag('render','g',29,['template':("/tellering/details/signatoryDetails"),'model':([depositInstance:txnCheckDepositInstance?.acct])],-1)
printHtmlPart(11)
}
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnCheckDepositInstance, field: 'passbookBal', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',37,['type':("number"),'readonly':("true"),'name':("passbookBal"),'required':(""),'value':(txnCheckDepositInstance?.passbookBal),'class':("form-control truncated")],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: txnCheckDepositInstance, field: 'creditAmt', 'has-error'))
printHtmlPart(16)
invokeTag('textField','g',47,['type':("number"),'id':("creditAmt"),'name':("creditAmt"),'required':(""),'value':(txnCheckDepositInstance?.creditAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(17)
if(true && (txnCheckDepositInstance?.checks)) {
printHtmlPart(12)
for( check in (txnCheckDepositInstance?.checks.sort{it.description}) ) {
printHtmlPart(18)
expressionOut.print(check?.checkType?.description)
printHtmlPart(19)
expressionOut.print(check?.bank?.name)
printHtmlPart(19)
expressionOut.print(check?.acctNo)
printHtmlPart(19)
expressionOut.print(check?.checkDate?.format("MM-dd-yyyy"))
printHtmlPart(20)
expressionOut.print(check?.checkNo)
printHtmlPart(19)
expressionOut.print(check?.checkAmt)
printHtmlPart(21)
expressionOut.print(check?.id)
printHtmlPart(22)
}
printHtmlPart(11)
}
else if(true && (session["checks"])) {
printHtmlPart(12)
invokeTag('set','g',86,['var':("i"),'value':(0)],-1)
printHtmlPart(12)
for( check in (session["checks"]) ) {
printHtmlPart(18)
expressionOut.print(check?.checkType?.description)
printHtmlPart(19)
expressionOut.print(check?.bank?.name)
printHtmlPart(19)
expressionOut.print(check?.acctNo)
printHtmlPart(19)
expressionOut.print(check?.checkDate)
printHtmlPart(20)
expressionOut.print(check?.checkNo)
printHtmlPart(19)
expressionOut.print(check?.checkAmt)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(23)
invokeTag('set','g',99,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(12)
}
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('field','g',109,['id':("checkCTotal"),'name':("txnAmt"),'disabled':(""),'value':(fieldValue(bean: txnCOCIInstance, field: 'txnAmt')),'class':("form-control truncated")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: txnCheckDepositInstance, field: 'txnRef', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',116,['code':("txnCheckDeposit.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(28)
invokeTag('textArea','g',119,['id':("txnRef"),'name':("txnRef"),'required':(""),'value':(txnCheckDepositInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(29)
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
