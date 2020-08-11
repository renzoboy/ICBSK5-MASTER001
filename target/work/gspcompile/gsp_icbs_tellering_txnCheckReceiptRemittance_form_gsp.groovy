import icbs.tellering.TxnRemittance
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckReceiptRemittance_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckReceiptRemittance/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("txnDepIDSender"),'id':("txnDepIDSender"),'value':(customerInstance?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',3,['name':("txnDepIDBenef"),'id':("txnDepIDBenef"),'value':(customerInstance?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',4,['name':("txnIdent"),'id':("txnIdent")],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',5,['id':("CashReceiptCheckRemit"),'name':("CashReceiptCheckRemit"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(20), icbs.lov.MemoTxnType.read(2),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (!txnCheckReceiptRemittanceInstance?.sender)) {
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('render','g',27,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCheckReceiptRemittanceInstance?.sender])],-1)
printHtmlPart(9)
if(true && (!txnCheckReceiptRemittanceInstance?.beneficiary)) {
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('render','g',39,['template':("/customer/details/txnCustomerDetails"),'model':([customerInstance:txnCheckReceiptRemittanceInstance?.beneficiary])],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnCheckReceiptRemittanceInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',46,['id':("remittanceAmt"),'type':("number"),'name':("txnAmt"),'required':(""),'value':(txnCheckReceiptRemittanceInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(14)
if(true && (txnCOCIInstance?.checks)) {
printHtmlPart(15)
for( check in (txnCOCIInstance?.checks.sort{it.description}) ) {
printHtmlPart(16)
expressionOut.print(check?.checkType?.description)
printHtmlPart(17)
expressionOut.print(check?.bank?.name)
printHtmlPart(17)
expressionOut.print(check?.acctNo)
printHtmlPart(17)
expressionOut.print(check?.checkDate)
printHtmlPart(17)
expressionOut.print(check?.checkNo)
printHtmlPart(17)
expressionOut.print(check?.checkAmt)
printHtmlPart(18)
expressionOut.print(check?.id)
printHtmlPart(19)
}
printHtmlPart(20)
}
else if(true && (session["checks"])) {
printHtmlPart(15)
invokeTag('set','g',85,['var':("i"),'value':(0)],-1)
printHtmlPart(15)
for( check in (session["checks"]) ) {
printHtmlPart(16)
expressionOut.print(check?.checkType?.description)
printHtmlPart(17)
expressionOut.print(check?.bank?.name)
printHtmlPart(17)
expressionOut.print(check?.acctNo)
printHtmlPart(17)
expressionOut.print(check?.checkDate)
printHtmlPart(17)
expressionOut.print(check?.checkNo)
printHtmlPart(17)
expressionOut.print(check?.checkAmt)
printHtmlPart(18)
expressionOut.print(i)
printHtmlPart(21)
invokeTag('set','g',98,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(15)
}
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(hasErrors(bean: txnCheckReceiptRemittanceInstance, field: 'controlNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',107,['code':("txnCheckReceiptRemittance.controlNo.label"),'default':("Control Number")],-1)
printHtmlPart(25)
invokeTag('textField','g',110,['name':("controlNo"),'value':(txnCheckReceiptRemittanceInstance?.controlNo),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: txnCheckReceiptRemittanceInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',117,['code':("txnCheckReceiptRemittance.txnParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(25)
invokeTag('textArea','g',120,['name':("txnParticulars"),'value':(txnCheckReceiptRemittanceInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: txnCheckReceiptRemittanceInstance, field: 'txnRef', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',126,['code':("txnCheckReceiptRemittance.txnRef.label"),'default':("Payout Instructions")],-1)
printHtmlPart(30)
invokeTag('textArea','g',128,['name':("txnRef"),'value':(txnCheckReceiptRemittanceInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(31)
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
