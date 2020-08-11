import icbs.loans.LoanLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanAdjustmentindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanAdjustment/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loanLedger.label', default: 'LoanLedger'))],-1)
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
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',29,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',32,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Account Application ID")],-1)
printHtmlPart(12)
invokeTag('submitButton','g',34,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(13)
})
invokeTag('form','g',39,[:],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',45,['property':("id"),'title':("ID")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',46,['property':("loan.accountNo"),'title':("Account")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',47,['property':("loan.customer.displayName"),'title':("Borrower's Name")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',48,['property':("txnType.description"),'title':("Transaction Type")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',49,['property':("txnTemplate.description"),'title':("Transaction Code")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',50,['property':("txnRef"),'title':("Transaction Reference")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( loanLedgerInstance in (loanLedgerInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(loanLedgerInstance?.id)
printHtmlPart(19)
expressionOut.print(loanLedgerInstance?.loan?.accountNo)
printHtmlPart(20)
expressionOut.print(loanLedgerInstance?.loan?.customer?.displayName)
printHtmlPart(20)
expressionOut.print(loanLedgerInstance?.txnType?.description)
printHtmlPart(19)
expressionOut.print(loanLedgerInstance?.txnTemplate?.description)
printHtmlPart(19)
expressionOut.print(loanLedgerInstance?.txnRef)
printHtmlPart(19)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',63,['class':("btn btn-secondary"),'action':("show"),'id':(loanLedgerInstance.id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',70,['total':(LoanLedgerInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',76,['action':("create")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(29)
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
