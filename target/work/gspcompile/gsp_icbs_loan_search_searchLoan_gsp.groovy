import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_search_searchLoan_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/search/_searchLoan.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'loan', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(5)
expressionOut.print(params?.query)
printHtmlPart(6)
invokeTag('hiddenField','g',29,['name':("searchType"),'value':("0")],-1)
printHtmlPart(7)
})
invokeTag('form','g',33,['id':("searchForm"),'name':("searchForm"),'url':([controller:loan, action:'search'])],1)
printHtmlPart(8)
invokeTag('sortableColumn','g',40,['property':("id"),'title':(message(code: 'loan.id', default: 'ID'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',42,['property':("accountNo"),'title':(message(code: 'loan.accountNo.label', default: 'Account No.'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',44,['property':("customer.displayName"),'title':(message(code: 'loan.customer.label', default: 'Customer'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',46,['property':("product.name"),'title':(message(code: 'loan.product.label', default: 'Product'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',48,['property':("amount"),'title':(message(code: 'loan.amount.label', default: 'Amount'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',50,['property':("openingDate"),'title':(message(code: 'loan.openingDate.label', default: 'Opening Date'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(12)
invokeTag('formatNumber','g',59,['format':("########0"),'number':(domainInstance?.id)],-1)
printHtmlPart(13)
expressionOut.print(domainInstance?.accountNo)
printHtmlPart(13)
expressionOut.print(domainInstance?.customer?.displayName)
printHtmlPart(14)
expressionOut.print(domainInstance?.product?.name)
printHtmlPart(14)
invokeTag('formatNumber','g',67,['format':("###,###,##0.00"),'number':(domainInstance?.grantedAmount)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',69,['format':("MM/dd/yyyy"),'date':(domainInstance.openingDate)],-1)
printHtmlPart(16)
expressionOut.print(domainInstance.branch.name)
printHtmlPart(17)
if(true && (params.actionTemplate)) {
printHtmlPart(18)
invokeTag('hiddenField','g',73,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(18)
invokeTag('render','g',74,['template':("actionTemplate/${params.actionTemplate}"),'model':([loanInstance:domainInstance])],-1)
printHtmlPart(18)
}
else {
printHtmlPart(19)
expressionOut.print(domainInstance?.id)
printHtmlPart(20)
}
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',85,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(23)
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
