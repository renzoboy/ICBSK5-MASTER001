import icbs.tellering.TxnLoanPaymentDetails
import icbs.loans.LoanInstallment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCashSpecifiedRepayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCashSpecifiedRepayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(14),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (!txnLoanCashSpecifiedRepaymentInstance?.acct)) {
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('hiddenField','g',24,['id':("loanId"),'name':("loanId")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',25,['id':("_prin_"),'name':("_prin_")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',26,['id':("_interest"),'name':("_interest")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',27,['id':("_penalty"),'name':("_penalty")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',28,['id':("_service"),'name':("_service")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',29,['id':("_tax"),'name':("_tax")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',30,['id':("totalBreakdown"),'name':("totalBreakdown")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',31,['id':("test_Loan"),'name':("test_Loan"),'value':("0")],-1)
printHtmlPart(10)
if(true && ((loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(11)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnLoanCashSpecifiedRepaymentInstance, field: 'paymentAmt', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',91,['type':("number"),'name':("paymentAmt"),'required':(""),'value':(txnLoanCashSpecifiedRepaymentInstance?.paymentAmt),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(15)
invokeTag('message','g',103,['code':("txnLoanCashSpecifiedRepayment.principalAmt.label"),'default':("Principal")],-1)
printHtmlPart(16)
invokeTag('textField','g',109,['type':("number"),'name':("principalInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.principalInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(17)
invokeTag('message','g',115,['code':("txnLoanCashSpecifiedRepayment.interestAmt.label"),'default':("Interest")],-1)
printHtmlPart(16)
invokeTag('textField','g',121,['type':("number"),'name':("interestInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.interestInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(18)
invokeTag('message','g',127,['code':("txnLoanCashSpecifiedRepayment.penaltyAmt.label"),'default':("Penalty")],-1)
printHtmlPart(16)
invokeTag('textField','g',133,['type':("number"),'name':("penaltyInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.penaltyInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(19)
invokeTag('message','g',140,['code':("txnLoanCashSpecifiedRepayment.serviceChargeAmt.label"),'default':("Service Charge")],-1)
printHtmlPart(16)
invokeTag('textField','g',145,['type':("number"),'name':("serviceChargeInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.serviceChargeInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(20)
invokeTag('message','g',151,['code':("txnLoanCashSpecifiedRepayment.grtAmt.label"),'default':("Gross Receipts Tax")],-1)
printHtmlPart(16)
invokeTag('textField','g',157,['type':("number"),'name':("grtAmt"),'required':(""),'value':(txnLoanCashSpecifiedRepaymentInstance?.grtAmt),'class':("form-control truncated"),'onchange':("updateVar()"),'disabled':("disabled")],-1)
printHtmlPart(21)
invokeTag('message','g',163,['code':("txnLoanCashSpecifiedRepayment.otherAmt.label"),'default':("Others")],-1)
printHtmlPart(16)
invokeTag('textField','g',169,['type':("number"),'name':("otherAmt"),'required':(""),'value':(txnLoanCashSpecifiedRepaymentInstance?.otherAmt),'class':("form-control truncated"),'onchange':("updateVar()"),'disabled':("disabled")],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: txnLoanCashSpecifiedRepaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',178,['code':("txnLoanCashSpecifiedRepayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(24)
invokeTag('textArea','g',181,['name':("txnRef"),'required':(""),'value':(txnLoanCashSpecifiedRepaymentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(25)
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
