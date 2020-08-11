import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuaranteeUpdateloanGuaranteeDetail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/UpdateloanGuaranteeDetail.gsp" }
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
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(8)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(9)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(10)
invokeTag('formatDate','g',32,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',36,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',40,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('hiddenField','g',54,['name':("loanInstance"),'value':(loanInstance.id)],-1)
printHtmlPart(15)
invokeTag('render','g',57,['template':("/loan/loanGuarantee/form/agriRefundPool")],-1)
printHtmlPart(16)
invokeTag('render','g',62,['template':("/loan/loanGuarantee/form/smallBusinessGuaranAndFee")],-1)
printHtmlPart(17)
invokeTag('render','g',65,['template':("/loan/loanGuarantee/form/homeGuaranteeCorp")],-1)
printHtmlPart(18)
})
invokeTag('form','g',71,['id':("loan-form"),'url':([controller:loan, action:'saveGuarantee']),'onsubmit':("return alertify.alert('Please wait... Processing....')")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('submitButton','g',84,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to create this Loan guarantee?',
                                function(){
                                    checkIfAllowed('LON00500', 'form#loan-form', 'Open New Loan Guarantee', null);;
                                },
                                function(){
                                    return;
                                }); 
                        """)],-1)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',87,['class':("list"),'action':("loanGurantee"),'id':(loanInstance.id)],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-actions")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',89,[:],1)
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