import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanloanReclassification_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanReclassification.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('hiddenField','g',26,['name':("loanId"),'id':("loanId"),'value':(loanInstance?.id)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanPerformanceId', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',29,['code':("loan.loanPerformanceId.label"),'default':("Loan Status")],-1)
printHtmlPart(14)
invokeTag('select','g',32,['id':("newLoanPerformanceID"),'name':("newLoanPerformanceID"),'from':(icbs.lov.LoanPerformanceId.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanPerformanceId?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
})
invokeTag('form','g',35,['name':("myForm"),'url':([action:'updateLoanPerformaceNow',controller:'loan']),'method':("POST")],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',37,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',41,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(19)
expressionOut.print(createLink(controller:'Loan', action:'updateLoanPerformaceNow'))
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',86,[:],1)
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
