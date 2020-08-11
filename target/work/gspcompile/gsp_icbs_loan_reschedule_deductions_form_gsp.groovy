import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_deductions_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/deductions/_form.gsp" }
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
invokeTag('select','g',32,['class':("form-control"),'id':("deductionScheme"),'name':("scheme.id"),'from':(product?.loanDeductionSchemes?.sort{it.id}),'optionKey':("id"),'optionValue':("name"),'value':(deduction?.scheme?.id),'onchange':("updateDeductionForm()")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: deduction, field: 'amount', 'has-error'))
printHtmlPart(7)
invokeTag('field','g',39,['class':("form-control"),'name':("deductionAmount"),'value':(deduction?.amount)],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',45,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',46,['bean':(deduction),'field':("amount")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',49,['bean':(deduction),'field':("amount")],1)
printHtmlPart(13)
invokeTag('field','g',55,['class':("form-control"),'name':("deductionFixedAmount"),'value':(deduction?.scheme?.amount),'readonly':("true")],-1)
printHtmlPart(14)
invokeTag('field','g',61,['class':("form-control"),'name':("deductionRate"),'value':(deduction?.scheme?.rate),'readonly':("true")],-1)
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
