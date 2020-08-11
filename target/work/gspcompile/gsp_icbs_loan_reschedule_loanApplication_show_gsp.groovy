import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_loanApplication_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/loanApplication/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(1)
expressionOut.print(loanApplicationInstance?.product?.id)
printHtmlPart(2)
expressionOut.print(loanApplicationInstance?.product?.name)
printHtmlPart(3)
expressionOut.print(loanApplicationInstance?.amount)
printHtmlPart(4)
expressionOut.print(loanApplicationInstance?.term)
printHtmlPart(5)
invokeTag('formatDate','g',8,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(6)
invokeTag('message','g',13,['code':("loanApplication.customer.label"),'default':("Customer")],-1)
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(8)
expressionOut.print(loanApplicationInstance?.customer?.birthDate)
printHtmlPart(9)
invokeTag('set','g',25,['var':("primaryAddress"),'value':(loanApplicationInstance?.customer?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(10)
if(true && (primaryAddress)) {
printHtmlPart(11)
invokeTag('set','g',27,['var':("primaryAddress"),'value':(primaryAddress?.address1 + ', ' + primaryAddress?.address2 +', ' +primaryAddress?.address3)],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
invokeTag('set','g',30,['var':("primaryAddress"),'value':("")],-1)
printHtmlPart(12)
}
printHtmlPart(14)
expressionOut.print(primaryAddress)
printHtmlPart(15)
if(true && ((loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(16)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',50,['code':("loanApplication.product.label"),'default':("Product")],-1)
printHtmlPart(19)
expressionOut.print(loanApplicationInstance?.product?.name)
printHtmlPart(20)
invokeTag('message','g',58,['code':("loanApplication.branch.label"),'default':("Branch")],-1)
printHtmlPart(21)
expressionOut.print(loanApplicationInstance?.branch?.name)
printHtmlPart(6)
invokeTag('message','g',66,['code':("loanApplication.currency.label"),'default':("Currency")],-1)
printHtmlPart(21)
expressionOut.print(loanApplicationInstance?.currency?.name)
printHtmlPart(6)
invokeTag('message','g',74,['code':("loanApplication.amount.label"),'default':("Amount")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',77,['bean':(loanApplicationInstance),'field':("amount")],-1)
printHtmlPart(6)
invokeTag('message','g',82,['code':("loanApplication.term.label"),'default':("Term")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',85,['bean':(loanApplicationInstance),'field':("term")],-1)
printHtmlPart(6)
invokeTag('message','g',90,['code':("loanApplication.purpose.label"),'default':("Purpose")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',93,['bean':(loanApplicationInstance),'field':("purpose")],-1)
printHtmlPart(6)
invokeTag('message','g',98,['code':("loanApplication.applicationDate.label"),'default':("Application Date")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',101,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(6)
invokeTag('message','g',106,['code':("loanApplication.status.label"),'default':("Status")],-1)
printHtmlPart(21)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(22)
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
