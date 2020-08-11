import icbs.tellering.TxnLoanPaymentDetails
import icbs.tellering.TxnCOCI
import icbs.loans.LoanInstallment
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanCheckSpecifiedRepayment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanCheckSpecifiedRepayment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(15),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (!txnLoanCheckSpecifiedRepaymentInstance?.acct)) {
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
expressionOut.print(hasErrors(bean: txnLoanCheckSpecifiedRepaymentInstance, field: 'paymentAmt', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',91,['type':("number"),'name':("paymentAmt"),'required':(""),'value':(txnLoanCheckSpecifiedRepaymentInstance?.paymentAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(15)
if(true && (txnCOCIInstance?.checks)) {
printHtmlPart(16)
for( check in (txnCOCIInstance?.checks.sort{it.description}) ) {
printHtmlPart(17)
expressionOut.print(check?.checkType?.description)
printHtmlPart(18)
expressionOut.print(check?.bank?.name)
printHtmlPart(18)
expressionOut.print(check?.acctNo)
printHtmlPart(18)
expressionOut.print(check?.checkDate)
printHtmlPart(18)
expressionOut.print(check?.checkNo)
printHtmlPart(18)
expressionOut.print(check?.clearingDate)
printHtmlPart(18)
expressionOut.print(check?.checkAmt)
printHtmlPart(19)
expressionOut.print(check?.id)
printHtmlPart(20)
}
printHtmlPart(9)
}
else if(true && (session["checks"])) {
printHtmlPart(16)
invokeTag('set','g',128,['var':("i"),'value':(0)],-1)
printHtmlPart(16)
for( check in (session["checks"]) ) {
printHtmlPart(17)
expressionOut.print(check?.checkType?.description)
printHtmlPart(18)
expressionOut.print(check?.bank?.name)
printHtmlPart(18)
expressionOut.print(check?.acctNo)
printHtmlPart(18)
expressionOut.print(check?.checkDate)
printHtmlPart(18)
expressionOut.print(check?.checkNo)
printHtmlPart(18)
expressionOut.print(check?.clearingDate)
printHtmlPart(18)
expressionOut.print(check?.checkAmt)
printHtmlPart(19)
expressionOut.print(i)
printHtmlPart(21)
invokeTag('set','g',143,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(16)
}
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(hasErrors(bean: txnCOCIInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',154,['code':("txnCOCI.txnAmt.label"),'default':("Check Control Total")],-1)
printHtmlPart(25)
invokeTag('textField','g',159,['id':("Check_Control_Total"),'name':("txnAmt"),'disabled':(""),'value':(fieldValue(bean: txnCOCIInstance, field: 'txnAmt')),'class':("form-control")],-1)
printHtmlPart(26)
invokeTag('message','g',171,['code':("txnLoanCheckSpecifiedRepayment.principalAmt.label"),'default':("Principal")],-1)
printHtmlPart(27)
invokeTag('textField','g',177,['type':("number"),'name':("principalInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.principalInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(28)
invokeTag('message','g',183,['code':("txnLoanCheckSpecifiedRepayment.interestAmt.label"),'default':("Interest")],-1)
printHtmlPart(27)
invokeTag('textField','g',189,['type':("number"),'name':("interestInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.interestInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(29)
invokeTag('message','g',195,['code':("txnLoanCheckSpecifiedRepayment.penaltyAmt.label"),'default':("Penalty")],-1)
printHtmlPart(27)
invokeTag('textField','g',201,['type':("number"),'name':("penaltyInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.penaltyInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(30)
invokeTag('message','g',208,['code':("txnLoanCheckSpecifiedRepayment.serviceChargeAmt.label"),'default':("Service Charge")],-1)
printHtmlPart(27)
invokeTag('textField','g',213,['type':("number"),'name':("serviceChargeInstallmentAmount"),'required':(""),'value':(loanInstallmentInstance?.serviceChargeInstallmentAmount),'class':("form-control truncated"),'onchange':("updateVar()")],-1)
printHtmlPart(31)
invokeTag('message','g',219,['code':("txnLoanCheckSpecifiedRepayment.grtAmt.label"),'default':("Gross Receipts Tax")],-1)
printHtmlPart(27)
invokeTag('textField','g',225,['type':("number"),'name':("grtAmt"),'required':(""),'value':(txnLoanCheckSpecifiedRepaymentInstance?.grtAmt),'class':("form-control truncated"),'onchange':("updateVar()"),'disabled':("disabled")],-1)
printHtmlPart(32)
invokeTag('message','g',231,['code':("txnLoanCheckSpecifiedRepayment.otherAmt.label"),'default':("Others")],-1)
printHtmlPart(27)
invokeTag('textField','g',237,['type':("number"),'name':("otherAmt"),'required':(""),'value':(txnLoanCheckSpecifiedRepaymentInstance?.otherAmt),'class':("form-control truncated"),'onchange':("updateVar()"),'disabled':("disabled")],-1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: txnLoanCheckSpecifiedRepaymentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(34)
invokeTag('message','g',246,['code':("txnLoanCheckSpecifiedRepayment.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(35)
invokeTag('textArea','g',249,['name':("txnRef"),'required':(""),'value':(txnLoanCheckSpecifiedRepaymentInstance?.txnRef),'class':("form-control")],-1)
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
