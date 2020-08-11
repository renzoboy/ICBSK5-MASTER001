import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuaranteeagfpInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/agfpInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(7)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(8)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(9)
invokeTag('formatDate','g',32,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',36,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',40,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('hiddenField','g',46,['name':("loanInstance"),'value':(loanInstance.id)],-1)
printHtmlPart(14)
invokeTag('render','g',47,['template':("/loan/loanGuarantee/form/agriRefundPool")],-1)
printHtmlPart(15)
})
invokeTag('form','g',48,['id':("loan-form"),'url':([controller:loan, action:'saveAgfpInformation']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',50,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('submitButton','g',61,['id':("save"),'name':("save"),'value':("Save"),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to create this Loan guarantee?',
                                function(){
                                    checkIfAllowed('LON00500', 'form#loan-form', 'Open New Loan Guarantee', null);;
                                },
                                function(){
                                    return;
                                }); 
                        """)],-1)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',64,['class':("list"),'action':("loanGurantee"),'id':(loanInstance.id)],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(21)
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
