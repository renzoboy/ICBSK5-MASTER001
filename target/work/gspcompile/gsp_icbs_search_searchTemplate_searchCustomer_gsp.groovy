import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_searchCustomer_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/_searchCustomer.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',11,[:],1)
printHtmlPart(3)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',16,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(6)
invokeTag('select','g',20,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',21,['class':("create"),'action':("create"),'controller':("customer")],2)
printHtmlPart(9)
expressionOut.print(params?.searchQuery)
printHtmlPart(10)
})
invokeTag('form','g',31,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(11)
invokeTag('sortableColumn','g',36,['property':("type"),'title':(message(code: 'customer.type.label', default: 'Customer Type'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',37,['property':("customerId"),'title':(message(code: 'customer.customerId.label', default: 'Customer Id'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',38,['property':("branch"),'title':(message(code: 'customer.branch.label', default: 'Branch'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',39,['property':("displayName"),'title':(message(code: 'customer.displayName.label', default: 'Display Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',41,['property':("birthDate"),'title':(message(code: 'customer.birthDate.label', default: 'Birth Date'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',42,['property':("status"),'title':(message(code: 'customer.status.label', default: 'Status'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(15)
expressionOut.print(fieldValue(bean: domainInstance, field: "type.description"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: domainInstance, field: "customerId"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: domainInstance, field: "branch.name"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: domainInstance, field: "displayName"))
printHtmlPart(17)
invokeTag('set','g',54,['var':("primaryAddress"),'value':((domainInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(18)
if(true && (primaryAddress!=null)) {
printHtmlPart(19)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.address3)
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(domainInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(16)
expressionOut.print(domainInstance?.status?.description)
printHtmlPart(23)
expressionOut.print(domainInstance?.createdBy?.username)
printHtmlPart(24)
expressionOut.print(domainInstance?.lastUpdatedBy?.username)
printHtmlPart(25)
if(true && (params.actionTemplate)) {
printHtmlPart(18)
invokeTag('hiddenField','g',68,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(18)
invokeTag('render','g',69,['template':("actionTemplate/${params.actionTemplate}"),'model':([customerInstance:domainInstance])],-1)
printHtmlPart(26)
}
else {
printHtmlPart(27)
expressionOut.print(domainInstance?.id)
printHtmlPart(28)
}
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
invokeTag('paginate','g',82,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(31)
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
