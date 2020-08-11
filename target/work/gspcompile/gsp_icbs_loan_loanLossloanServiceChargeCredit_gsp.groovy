import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanLossloanServiceChargeCredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanLoss/loanServiceChargeCredit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',16,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',16,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(7)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(8)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(9)
invokeTag('formatDate','g',36,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',40,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',44,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(14)
invokeTag('select','g',56,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(62),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
invokeTag('field','g',62,['class':("form-control truncated"),'id':("creditAmt"),'name':("creditAmt"),'value':("")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',65,['name':("serviceChargeCreditId"),'id':("serviceChargeCreditId"),'value':(params.id)],-1)
printHtmlPart(17)
invokeTag('field','g',70,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(18)
invokeTag('field','g',76,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(19)
})
invokeTag('form','g',80,['id':("deposit"),'url':([controller:loan, action:'loanServiceChargeCreditTransaction']),'method':("PUT")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('submitButton','g',94,['id':("saveScCredit"),'name':("saveScCredit"),'value':(message(code: 'default.button.Save.label', default: 'Save')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override edit Service Charge Credit.', null); 
                                },
                                function(){
                                    return;
                                });     
                        """)],-1)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',95,['action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',98,[:],1)
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
