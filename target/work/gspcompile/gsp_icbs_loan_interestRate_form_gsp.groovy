import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_interestRate_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/interestRate/_form.gsp" }
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
invokeTag('hasErrors','g',24,['bean':(loanInstance)],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',26,['name':("id"),'id':("id"),'value':(loanInstance?.id)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',27,['name':("activity"),'value':("Repricing")],-1)
printHtmlPart(5)
if(true && (loanInstance?.interestIncomeScheme?.advInterestType?.id == 1)) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: loanInstance, field: 'interestRate', 'has-error'))
printHtmlPart(7)
invokeTag('field','g',32,['class':("form-control"),'type':("numeric"),'id':("interestRate"),'name':("interestRate"),'value':(fieldValue(bean: loanInstance, field: 'interestRate'))],-1)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',38,['bean':(loanInstance),'field':("interestRate")],4)
printHtmlPart(12)
})
invokeTag('hasErrors','g',41,['bean':(loanInstance),'field':("interestRate")],3)
printHtmlPart(13)
}
else {
printHtmlPart(14)
invokeTag('field','g',46,['class':("form-control"),'type':("numeric"),'id':("interestRate"),'name':("interestRate"),'readonly':("readonly"),'value':(fieldValue(bean: loanInstance, field: 'interestRate'))],-1)
printHtmlPart(5)
}
printHtmlPart(15)
})
invokeTag('form','g',49,['name':("update-interest-rate-form")],1)
printHtmlPart(16)
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
