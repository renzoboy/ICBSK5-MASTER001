import icbs.tellering.TxnLoanPaymentDetails
import icbs.tellering.TxnCOCI
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCheckRepayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCheckRepayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(13),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (!txnLoanCheckRepaymentInstance?.acct)) {
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('hiddenField','g',23,['id':("loanId"),'name':("loanId")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',24,['id':("test_Loan"),'name':("test_Loan"),'value':("0")],-1)
printHtmlPart(9)
if(true && ((loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(10)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnLoanCheckRepaymentInstance, field: 'paymentAmt', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',85,['type':("number"),'id':("paymentAmt"),'name':("paymentAmt"),'required':(""),'value':(txnLoanCheckRepaymentInstance?.paymentAmt),'class':("form-control truncated"),'onkeyup':("updateBreakdown()")],-1)
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
expressionOut.print(check?.clearingDate)
printHtmlPart(17)
expressionOut.print(check?.checkAmt)
printHtmlPart(18)
expressionOut.print(check?.id)
printHtmlPart(19)
}
printHtmlPart(8)
}
else if(true && (session["checks"])) {
printHtmlPart(15)
invokeTag('set','g',123,['var':("i"),'value':(0)],-1)
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
expressionOut.print(check?.clearingDate)
printHtmlPart(17)
expressionOut.print(check?.checkAmt)
printHtmlPart(18)
expressionOut.print(i)
printHtmlPart(20)
invokeTag('set','g',137,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(15)
}
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',148,['code':("txnCOCI.txnAmt.label"),'default':("Check Control Total")],-1)
printHtmlPart(24)
invokeTag('field','g',153,['id':("Check_Control_Total"),'name':("txnAmt"),'disabled':(""),'value':(fieldValue(bean: txnCOCIInstance, field: 'txnAmt')),'class':("form-control")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',153,['name':("totalAmtCheccckPayment"),'id':("totalAmtCheccckPayment"),'value':("")],-1)
printHtmlPart(25)
invokeTag('message','g',166,['code':("txnLoanCheckRepayment.principalAmt.label"),'default':("Principal")],-1)
printHtmlPart(26)
invokeTag('textField','g',172,['id':("principal"),'type':("number"),'name':("principal"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',172,['name':("principalBalance"),'value':("0")],-1)
printHtmlPart(28)
invokeTag('message','g',179,['code':("txnLoanCheckRepayment.interestAmt.label"),'default':("Interest")],-1)
printHtmlPart(26)
invokeTag('textField','g',185,['id':("interest"),'type':("number"),'name':("interest"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',185,['name':("interestBalance"),'value':("0")],-1)
printHtmlPart(29)
invokeTag('message','g',192,['code':("txnLoanCheckRepayment.penaltyAmt.label"),'default':("Penalty")],-1)
printHtmlPart(26)
invokeTag('textField','g',198,['id':("penalty"),'type':("number"),'name':("penalty"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',198,['name':("penaltyBalance"),'value':("0")],-1)
printHtmlPart(30)
invokeTag('message','g',206,['code':("txnLoanCheckRepayment.serviceChargeAmt.label"),'default':("Service Charge")],-1)
printHtmlPart(26)
invokeTag('textField','g',211,['id':("serviceCharge"),'type':("number"),'name':("serviceCharge"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',211,['name':("chargeBalance"),'value':("0")],-1)
printHtmlPart(31)
invokeTag('message','g',218,['code':("txnLoanCheckRepayment.grtAmt.label"),'default':("Gross Receipts Tax")],-1)
printHtmlPart(26)
invokeTag('textField','g',224,['id':("tax"),'type':("number"),'name':("tax"),'required':(""),'readOnly':("true"),'class':("form-control"),'value':("0")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',224,['name':("taxBalance"),'value':("0")],-1)
printHtmlPart(32)
invokeTag('message','g',231,['code':("txnLoanCheckRepayment.otherAmt.label"),'default':("Others")],-1)
printHtmlPart(26)
invokeTag('textField','g',237,['id':("others"),'type':("number"),'name':("others"),'required':(""),'readOnly':("true"),'class':("form-control"),'value':("0")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',237,['name':("otherBalance"),'value':("0")],-1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: txnLoanCheckRepaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(34)
invokeTag('message','g',248,['code':("txnLoanCheckRepayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(35)
invokeTag('textArea','g',251,['name':("txnRef"),'required':(""),'value':(txnLoanCheckRepaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(36)
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
