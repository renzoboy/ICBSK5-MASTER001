import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCashRepayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCashRepayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(12),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(txnLoanCashRepaymentInstance?.acct)
printHtmlPart(6)
if(true && (!txnLoanCashRepaymentInstance?.acct)) {
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('hiddenField','g',23,['id':("loanId"),'name':("loanId")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',24,['id':("test_Loan"),'name':("test_Loan"),'value':("0")],-1)
printHtmlPart(10)
if(true && ((loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(11)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnLoanCashRepaymentInstance, field: 'paymentAmt', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',84,['type':("number"),'name':("paymentAmt"),'required':(""),'value':(txnLoanCashRepaymentInstance?.paymentAmt),'class':("form-control truncated"),'onkeyup':("updateBreakdown()")],-1)
printHtmlPart(15)
invokeTag('message','g',97,['code':("txnLoanCashRepayment.principalAmt.label"),'default':("Principal")],-1)
printHtmlPart(16)
invokeTag('textField','g',103,['id':("principal"),'type':("number"),'name':("principal"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',103,['name':("principalBalance"),'value':("0")],-1)
printHtmlPart(18)
invokeTag('message','g',110,['code':("txnLoanCashRepayment.interestAmt.label"),'default':("Interest")],-1)
printHtmlPart(16)
invokeTag('textField','g',116,['id':("interest"),'type':("number"),'name':("interest"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',116,['name':("interestBalance"),'value':("0")],-1)
printHtmlPart(19)
invokeTag('message','g',123,['code':("txnLoanCashRepayment.penaltyAmt.label"),'default':("Penalty")],-1)
printHtmlPart(16)
invokeTag('textField','g',129,['id':("penalty"),'type':("number"),'name':("penalty"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',129,['name':("penaltyBalance"),'value':("0")],-1)
printHtmlPart(20)
invokeTag('message','g',137,['code':("txnLoanCashRepayment.serviceChargeAmt.label"),'default':("Service Charge")],-1)
printHtmlPart(16)
invokeTag('textField','g',142,['id':("serviceCharge"),'type':("number"),'name':("serviceCharge"),'readOnly':("true"),'required':(""),'class':("form-control"),'value':("0")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',142,['name':("chargeBalance"),'value':("0")],-1)
printHtmlPart(21)
invokeTag('message','g',149,['code':("txnLoanCashRepayment.grtAmt.label"),'default':("Gross Receipts Tax")],-1)
printHtmlPart(16)
invokeTag('textField','g',155,['id':("tax"),'type':("number"),'name':("tax"),'required':(""),'readOnly':("true"),'class':("form-control"),'value':("0")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',155,['name':("taxBalance"),'value':("0")],-1)
printHtmlPart(22)
invokeTag('message','g',162,['code':("txnLoanCashRepayment.otherAmt.label"),'default':("Others")],-1)
printHtmlPart(16)
invokeTag('textField','g',168,['id':("others"),'type':("number"),'name':("others"),'required':(""),'readOnly':("true"),'class':("form-control"),'value':("0")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',168,['name':("otherBalance"),'value':("0")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: txnLoanCashRepaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',179,['code':("txnLoanCashRepayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(25)
invokeTag('textArea','g',182,['name':("txnRef"),'required':(""),'value':(txnLoanCashRepaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(26)
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
