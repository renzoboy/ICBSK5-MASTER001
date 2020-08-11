import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(module)
printHtmlPart(5)
})
invokeTag('javascript','g',17,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(title)
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',22,['tag':("breadcrumbs")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('select','g',38,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(16)
invokeTag('textField','g',41,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Account No.")],-1)
printHtmlPart(17)
invokeTag('submitButton','g',43,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',48,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(14)
})
invokeTag('form','g',49,[:],3)
printHtmlPart(19)
invokeTag('sortableColumn','g',55,['property':("id"),'title':(message(code: 'loan.id', default: 'ID'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',57,['property':("accountNo"),'title':(message(code: 'loan.accountNo.label', default: 'Account No.'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',59,['property':("customer.displayName"),'title':(message(code: 'loan.customer.label', default: 'Customer'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',61,['property':("product.name"),'title':(message(code: 'loan.product.label', default: 'Product'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',63,['property':("amount"),'title':(message(code: 'loan.amount.label', default: 'Amount'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',65,['property':("openingDate"),'title':(message(code: 'loan.openingDate.label', default: 'Opening Date'))],-1)
printHtmlPart(23)
invokeTag('sortableColumn','g',67,['property':("glCode"),'title':(message(code: 'loan.glCode.label', default: 'GL Code'))],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',68,['property':("status"),'title':(message(code: 'loan.status.label', default: 'Status'))],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',69,['property':("balance"),'title':(message(code: 'loan.status.label', default: 'Balance'))],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',70,['property':("maturityDate"),'title':(message(code: 'loan.status.label', default: 'Maturity Date'))],-1)
printHtmlPart(26)
loop:{
int i = 0
for( loanInstance in (loanInstanceList) ) {
printHtmlPart(27)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(28)
expressionOut.print(fieldValue(bean: loanInstance, field: "id"))
printHtmlPart(29)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(30)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(31)
expressionOut.print(loanInstance?.product?.name)
printHtmlPart(32)
invokeTag('formatNumber','g',87,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(33)
invokeTag('formatDate','g',89,['format':("MM/dd/yyyy"),'date':(loanInstance.openingDate)],-1)
printHtmlPart(34)
expressionOut.print(loanInstance?.branch?.name)
printHtmlPart(35)
expressionOut.print(loanInstance?.glLink?.description)
printHtmlPart(36)
expressionOut.print(loanInstance?.status?.description)
printHtmlPart(37)
invokeTag('formatNumber','g',93,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(34)
invokeTag('formatDate','g',94,['format':("MM/dd/yyyy"),'date':(loanInstance.maturityDate)],-1)
printHtmlPart(38)
createClosureForHtmlPart(39, 4)
invokeTag('link','g',95,['class':("btn btn-secondary"),'controller':(module),'action':("show"),'id':(loanInstance.id)],4)
printHtmlPart(40)
i++
}
}
printHtmlPart(41)
invokeTag('paginate','g',103,['total':(LoanInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',106,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(43)
if(true && (module == 'loan')) {
printHtmlPart(44)
createClosureForHtmlPart(45, 4)
invokeTag('link','g',110,['class':("create"),'action':("create")],4)
printHtmlPart(46)
}
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',113,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',114,[:],1)
printHtmlPart(48)
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
