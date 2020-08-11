import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_search_searchLoanAccount_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/search/_searchLoanAccount.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'loanApplication', action:'searchAccount'))
printHtmlPart(2)
})
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([25 , 50 , 75 , 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(5)
expressionOut.print(params?.query)
printHtmlPart(6)
invokeTag('hiddenField','g',29,['name':("searchType"),'value':("0")],-1)
printHtmlPart(7)
})
invokeTag('form','g',33,['id':("searchForm"),'name':("searchForm"),'url':([controller:loanApplication, action:'searchAccount'])],1)
printHtmlPart(8)
invokeTag('sortableColumn','g',40,['property':("accntNumber"),'title':(message(code: 'loan.accntNumber', default: 'Account Number'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',42,['property':("customer.displayName"),'title':(message(code: 'loanApplication.customer.label', default: 'Customer Name'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',44,['property':("product.name"),'title':(message(code: 'loanApplication.address.label', default: 'Address'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',46,['property':("amount"),'title':(message(code: 'loanApplication.dateGranted.label', default: 'Date Granted'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',48,['property':("applicationDate"),'defaultOrder':("desc"),'title':(message(code: 'loanApplication.maturityDate.label', default: 'Maturity Date'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',50,['property':("applicationDate"),'title':(message(code: 'loanApplication.amountGranted.label', default: 'Amount Granted'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',52,['property':("applicationDate"),'title':(message(code: 'loanApplication.amountBalance.label', default: 'Account Balance'))],-1)
printHtmlPart(14)
expressionOut.print(params.actionTemplate)
printHtmlPart(15)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(16)
expressionOut.print(domainInstance.accountNo)
printHtmlPart(17)
expressionOut.print(domainInstance.customer.displayName)
printHtmlPart(17)
expressionOut.print(domainInstance.customer.addresses.address1[0])
printHtmlPart(18)
expressionOut.print(domainInstance.customer.addresses.address2[0])
printHtmlPart(17)
invokeTag('formatDate','g',63,['format':("MM/dd/yyyy"),'date':(domainInstance?.dateApproved)],-1)
printHtmlPart(17)
invokeTag('formatDate','g',64,['format':("MM/dd/yyyy"),'date':(domainInstance?.maturityDate)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',65,['format':("###,##0.00"),'number':(domainInstance?.grantedAmount)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',66,['format':("###,##0.00"),'number':(domainInstance?.balanceAmount)],-1)
printHtmlPart(19)
if(true && (params.actionTemplate)) {
printHtmlPart(20)
invokeTag('hiddenField','g',69,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(20)
invokeTag('render','g',70,['template':("actionTemplate/${params.actionTemplate}"),'model':([domainInstance:domainInstance])],-1)
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(domainInstance?.id)
printHtmlPart(22)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',81,['total':(domainInstanceCount ?: 0),'params':([sa:1])],-1)
printHtmlPart(25)
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
