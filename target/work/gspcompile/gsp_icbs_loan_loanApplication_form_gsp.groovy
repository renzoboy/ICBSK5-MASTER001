import icbs.lov.ProductType
import icbs.loans.LoanApplication
import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanApplication_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanApplication/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(2)
if(true && (loanApplication?.product?.productType?.id == 7)) {
printHtmlPart(3)
invokeTag('message','g',9,['code':("loan.loanApplication.label"),'default':("Account Application")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('message','g',15,['code':("loan.loanApplication.label"),'default':("Account Application")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('field','g',19,['name':("loanApplication"),'type':("number"),'value':(loanInstance?.loanApplication?.id),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',25,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',26,['bean':(loanInstance),'field':("loanApplication")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',29,['bean':(loanInstance),'field':("loanApplication")],1)
printHtmlPart(13)
if(true && (!reschedule)) {
printHtmlPart(14)
}
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
