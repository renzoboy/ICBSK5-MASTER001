import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_installments_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/installments/_form.gsp" }
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
invokeTag('hasErrors','g',33,['bean':(installment)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: installment, field: 'installmentDate', 'has-error'))
printHtmlPart(6)
invokeTag('customDatePicker','g',39,['name':("installmentDate"),'precision':("day"),'class':("form-control"),'value':(installment?.installmentDate)],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',45,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',46,['bean':(installment),'field':("installmentDate")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',49,['bean':(installment),'field':("installmentDate")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: installment, field: 'principalInstallmentAmount', 'has-error'))
printHtmlPart(13)
invokeTag('field','g',55,['class':("form-control"),'name':("principalInstallmentAmount"),'value':(installment?.principalInstallmentAmount)],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',61,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',62,['bean':(installment),'field':("principalInstallmentAmount")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',65,['bean':(installment),'field':("principalInstallmentAmount")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: installment, field: 'interestInstallmentAmount', 'has-error'))
printHtmlPart(15)
invokeTag('field','g',71,['class':("form-control"),'name':("interestInstallmentAmount"),'value':(installment?.interestInstallmentAmount)],-1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',78,['bean':(installment),'field':("interestInstallmentAmount")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',81,['bean':(installment),'field':("interestInstallmentAmount")],1)
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
