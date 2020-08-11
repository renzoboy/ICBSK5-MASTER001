import icbs.lov.LoanApplicationStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_status_editStatus_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/status/_editStatus.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',25,['bean':(loanApplicationInstance)],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',27,['name':("id"),'id':("id"),'value':(loanApplicationInstance?.id)],-1)
printHtmlPart(5)
if(true && (loanApplicationInstance?.product?.productType?.id == 6)) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'approvalStatus', 'has-error'))
printHtmlPart(7)
invokeTag('select','g',32,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(icbs.lov.LoanApplicationStatus.findAll("from LoanApplicationStatus where id in (1,2,3,4,5,6,7,8)")),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',38,['bean':(loanApplicationInstance),'field':("approvalStatus")],4)
printHtmlPart(12)
})
invokeTag('hasErrors','g',41,['bean':(loanApplicationInstance),'field':("approvalStatus")],3)
printHtmlPart(13)
}
printHtmlPart(5)
if(true && (loanApplicationInstance?.product?.productType?.id == 7)) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: loanApplicationInstance, field: 'approvalStatus', 'has-error'))
printHtmlPart(7)
invokeTag('select','g',49,['id':("approvalStatus"),'name':("approvalStatus.id"),'from':(icbs.lov.LoanApplicationStatus.findAll("from LoanApplicationStatus where id in (1,8,9,10,11)")),'optionKey':("id"),'optionValue':("description"),'value':(loanApplicationInstance?.approvalStatus?.id),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',55,['bean':(loanApplicationInstance),'field':("approvalStatus")],4)
printHtmlPart(12)
})
invokeTag('hasErrors','g',58,['bean':(loanApplicationInstance),'field':("approvalStatus")],3)
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('form','g',62,['name':("update-status-form")],1)
printHtmlPart(15)
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
