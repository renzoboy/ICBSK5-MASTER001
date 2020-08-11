import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_writeOffview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/writeOff/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(7)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(8)
invokeTag('formatNumber','g',27,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',31,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(10)
invokeTag('formatDate','g',35,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(11)
invokeTag('formatDate','g',39,['format':("MM/dd/yyyy"),'date':(loanInstance?.maturityDate)],-1)
printHtmlPart(12)
invokeTag('formatDate','g',43,['format':("MM/dd/yyyy"),'date':(loanInstance?.lastTransactionDate)],-1)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(35))) ) {
printHtmlPart(15)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(16)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loan', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',59,['code':("loan.label"),'default':("Reference")],-1)
printHtmlPart(20)
invokeTag('field','g',62,['name':("reference"),'class':("form-control")],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loan', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',67,['code':("loan.label"),'default':("Particulars")],-1)
printHtmlPart(20)
invokeTag('field','g',70,['name':("particulars"),'class':("form-control")],-1)
printHtmlPart(22)
})
invokeTag('form','g',72,['id':("transfers"),'name':("transfers"),'url':([controller:loan, action:'transferW', id:loanInstance.id]),'method':("POST")],3)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
if(true && (loanInstance?.status?.id <= 5)) {
printHtmlPart(25)
invokeTag('actionSubmit','g',86,['id':("transfer"),'action':("transferW"),'value':("Transfer Account to Write off"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to continue Write-Off transaction?',    
                                function(){
                                    checkIfAllowed('LON01900', 'form#transfers', 'Transfer to Write off', null);
                                },
                                function(){
                                    return;
                                });                        
                    """)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',88,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(30)
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
