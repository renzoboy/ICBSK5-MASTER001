import icbs.loans.LoanLossProvisionDetail
import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanLossloanUidDebit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanLoss/loanUidDebit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',17,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',18,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',18,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(8)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(9)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(10)
invokeTag('formatDate','g',38,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',42,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(15)
invokeTag('select','g',59,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(58),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
invokeTag('field','g',65,['class':("form-control truncated"),'id':("debitAmt"),'name':("debitAmt"),'value':("")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',68,['name':("uidDebit"),'id':("uidDebit"),'value':(params.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',69,['name':("ididid"),'id':("ididid"),'value':(params.id)],-1)
printHtmlPart(19)
invokeTag('field','g',74,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(20)
invokeTag('field','g',80,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(21)
})
invokeTag('form','g',84,['id':("deposit"),'url':([controller:loan, action:'saveUidDebit']),'method':("PUT")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('submitButton','g',98,['id':("saveUidDebit"),'name':("saveUidDebit"),'value':(message(code: 'default.button.Save.label', default: 'Save')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override edit UID Debit.', null); 
                                },
                                function(){
                                    return;
                                });     
                        """)],-1)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',99,['action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(28)
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
