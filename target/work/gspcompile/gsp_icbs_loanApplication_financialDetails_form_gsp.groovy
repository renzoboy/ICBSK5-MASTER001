import icbs.loans.FinancialDetail
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_financialDetails_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/financialDetails/_form.gsp" }
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
invokeTag('hasErrors','g',25,['bean':(financialDetail)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: financialDetail, field: 'description', 'has-error'))
printHtmlPart(6)
invokeTag('textArea','g',31,['name':("description"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(financialDetail?.description),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',38,['bean':(financialDetail?.description),'field':("description")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',41,['bean':(financialDetail),'field':("description")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: financialDetail, field: 'value', 'has-error'))
printHtmlPart(13)
invokeTag('field','g',48,['type':("text"),'name':("value"),'value':(financialDetail?.value),'onkeyup':("AddComma()"),'class':("form-control truncated")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',55,['bean':(financialDetail?.value),'field':("value")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',58,['bean':(financialDetail),'field':("value")],1)
printHtmlPart(16)
invokeTag('select','g',64,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.LoanFinancialInfoType.list()),'optionKey':("id"),'optionValue':("description"),'value':(financialDetail?.type?.id)],-1)
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
