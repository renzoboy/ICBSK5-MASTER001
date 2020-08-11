import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_search_searchRopa_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/search/_searchRopa.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'loanApplication', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('select','g',17,['name':("max"),'value':(params.max),'from':([25 , 50 , 75 , 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(5)
expressionOut.print(params?.query)
printHtmlPart(6)
invokeTag('hiddenField','g',30,['name':("searchType"),'value':("0")],-1)
printHtmlPart(7)
})
invokeTag('form','g',34,['id':("searchForm"),'name':("searchForm"),'url':([controller:loanApplication, action:'search'])],1)
printHtmlPart(8)
invokeTag('sortableColumn','g',41,['property':("id"),'title':(message(code: 'loanApplication.id', default: 'ID'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',43,['property':("customer.displayName"),'title':(message(code: 'loanApplication.customer.label', default: 'Customer Name'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',45,['property':("product.name"),'title':(message(code: 'loanApplication.product.label', default: 'Product'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',47,['property':("amount"),'title':(message(code: 'loanApplication.amount.label', default: 'Amount'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',49,['property':("applicationDate"),'defaultOrder':("desc"),'title':(message(code: 'loanApplication.applicationDate.label', default: 'Application Date'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',51,['property':("applicationDate"),'title':(message(code: 'loanApplication.approvalStatus.label', default: 'Status'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "id"))
printHtmlPart(15)
expressionOut.print(domainInstance?.customer?.displayName)
printHtmlPart(16)
expressionOut.print(domainInstance?.product?.name)
printHtmlPart(17)
invokeTag('formatNumber','g',65,['format':("###,##0.00"),'number':(domainInstance?.amount)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',67,['format':("MM/dd/yyyy"),'date':(domainInstance?.applicationDate)],-1)
printHtmlPart(18)
expressionOut.print(domainInstance?.approvalStatus)
printHtmlPart(19)
if(true && (params.actionTemplate)) {
printHtmlPart(20)
invokeTag('hiddenField','g',73,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(20)
invokeTag('render','g',74,['template':("actionTemplate/${params.actionTemplate}"),'model':([loanApplicationInstance:domainInstance])],-1)
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
invokeTag('paginate','g',85,['total':(domainInstanceCount ?: 0)],-1)
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
