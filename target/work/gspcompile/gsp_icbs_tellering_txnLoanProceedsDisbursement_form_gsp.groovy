import icbs.tellering.TxnLoanPaymentDetails
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnLoanProceedsDisbursement_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnLoanProceedsDisbursement/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(11),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (!txnLoanProceedsDisbursementInstance?.acct)) {
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('hiddenField','g',46,['id':("loanId"),'name':("loanId")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',47,['id':("Net_Proceeds"),'name':("Net_Proceeds")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',48,['id':("Net_Disburse"),'name':("Net_Disburse")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',49,['id':("DisburseAmt"),'name':("DisburseAmt")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',50,['id':("TotalProceeds"),'name':("TotalProceeds"),'value':("0")],-1)
printHtmlPart(9)
if(true && ((loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(10)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnLoanProceedsDisbursementInstance, field: 'totalNetProceeds', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',97,['id':("totalNetProceeds"),'type':("number"),'name':("totalNetProceeds"),'required':(""),'class':("form-control truncated"),'onkeyup':("updateBreakdown()")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnLoanProceedsDisbursementInstance, field: 'txnRef', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',103,['code':("txnLoanProceedsDisbursement.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(16)
invokeTag('textArea','g',106,['name':("txnRef"),'required':(""),'value':(txnLoanProceedsDisbursementInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(17)
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
