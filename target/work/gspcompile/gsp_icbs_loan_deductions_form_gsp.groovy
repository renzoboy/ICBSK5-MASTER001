import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_deductions_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/deductions/_form.gsp" }
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
invokeTag('hasErrors','g',26,['bean':(deduction)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: deduction, field: 'scheme', 'has-error'))
printHtmlPart(6)
invokeTag('select','g',32,['class':("many-to-one form-control"),'id':("deductionScheme"),'name':("scheme.id"),'from':(product?.loanDeductionSchemes?.findAll{it.status.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(deduction?.scheme?.id),'onchange':("updateDeductionForm()")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',39,['bean':(deduction),'field':("scheme")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',42,['bean':(deduction),'field':("scheme")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: deduction, field: 'amount', 'has-error'))
printHtmlPart(13)
invokeTag('field','g',49,['id':("deductionAmount"),'name':("deductionAmount"),'value':(deduction?.amount),'onkeyup':("AddComma()"),'class':("form-control truncated")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',55,['bean':(deduction),'field':("amount")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',58,['bean':(deduction),'field':("amount")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: deduction, field: 'rate', 'has-error'))
printHtmlPart(16)
invokeTag('field','g',65,['class':("form-control truncated"),'name':("deductionRate"),'value':(deduction?.rate),'onkeyup':("updateDeductionAmount(2)")],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',72,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',73,['bean':(deduction),'field':("rate")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',76,['bean':(deduction),'field':("rate")],1)
printHtmlPart(18)
invokeTag('field','g',82,['class':("form-control"),'name':("deductionRateAmount"),'readonly':("true")],-1)
printHtmlPart(19)
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
