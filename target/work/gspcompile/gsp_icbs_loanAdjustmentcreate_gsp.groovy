import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanAdjustmentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanAdjustment/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(6)
expressionOut.print(createLink(controller: 'search', action:'search', params:[searchDomain: 'deposit']))
printHtmlPart(7)
expressionOut.print(createLink(controller:'loanAdjustment', action:'getTxnTemplatesAjax'))
printHtmlPart(8)
expressionOut.print(message(code: 'default.button.delete.confirm.message', default: 'Are you sure?'))
printHtmlPart(9)
expressionOut.print(loanLedgerInstance?.loan?.id)
printHtmlPart(10)
expressionOut.print(loanLedgerInstance?.deposit?.id)
printHtmlPart(11)
})
invokeTag('javascript','g',201,[:],2)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',202,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('captureContent','sitemesh',206,['tag':("breadcrumbs")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(15)
if(true && (flash.message)) {
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
}
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
if(true && (loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.disbursement.excess'))) {
printHtmlPart(20)
}
else if(true && (loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.principalBalance.excess'))) {
printHtmlPart(21)
}
else if(true && (loanLedgerInstance.errors?.allErrors*.code.contains('loanAdjustment.principalBalance.belowZero'))) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
})
invokeTag('hasErrors','g',239,['bean':(loanLedgerInstance)],3)
printHtmlPart(25)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('render','g',243,['template':("form")],-1)
printHtmlPart(27)
})
invokeTag('form','g',245,['id':("loan-adjustment-form"),'url':([controller:loanAdjustment, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',247,['tag':("main-content")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('submitButton','g',258,['id':("adjust"),'name':("save"),'value':("Save"),'onclick':("""
                    alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('LON00900', 'form#loan-adjustment-form', 'Create loan adjustment', null);
                                },
                                function(){
                                    return;
                                });                        
                    """)],-1)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',268,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',270,['tag':("main-actions")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',271,[:],1)
printHtmlPart(33)
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
