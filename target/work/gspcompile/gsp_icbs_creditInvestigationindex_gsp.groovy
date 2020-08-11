import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
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
invokeTag('select','g',29,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',32,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Borrower Name")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',34,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
})
invokeTag('form','g',39,[:],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',45,['property':("id"),'title':(message(code: 'creditInvestigation.id.label', default: 'ID'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',47,['property':("id"),'title':(message(code: 'creditInvestigation.loanApplication.label', default: 'Loan Application'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( creditInvestigationInstance in (creditInvestigationInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(20)
expressionOut.print(creditInvestigationInstance?.loanApplication?.branch?.name)
printHtmlPart(21)
expressionOut.print(creditInvestigationInstance?.loanApplication?.id)
printHtmlPart(20)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(22)
invokeTag('formatDate','g',62,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.ciCreatedDate)],-1)
printHtmlPart(20)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',63,['class':("btn btn-secondary"),'action':("show"),'id':(creditInvestigationInstance.id)],4)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',70,['total':(CreditInvestigationInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',77,['class':("create"),'action':("create"),'params':([creditType: 'secured'])],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',78,['class':("create"),'action':("create"),'params':([creditType: 'unsecured'])],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',78,[:],1)
printHtmlPart(32)
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
