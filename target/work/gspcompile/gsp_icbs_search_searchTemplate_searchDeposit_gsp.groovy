import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_searchDeposit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/_searchDeposit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(3)
})
invokeTag('javascript','g',11,[:],1)
printHtmlPart(4)
expressionOut.print(params.module)
printHtmlPart(5)
expressionOut.print(params.actionTemplate)
printHtmlPart(6)
invokeTag('select','g',24,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'"onchange':("searchVar.searchMe();")],-1)
printHtmlPart(7)
expressionOut.print(params?.searchQuery)
printHtmlPart(8)
invokeTag('sortableColumn','g',53,['property':("acctNo"),'title':(message(code: 'deposit.acctNo.label', default: 'Deposit ID'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',55,['property':("type"),'title':(message(code: 'deposit.type.label', default: 'Deposit Type'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',58,['property':("customer"),'title':(message(code: 'deposit.customer.label', default: 'Primary Owner '))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',59,['property':("dateOpened"),'title':(message(code: 'deposit.dateOpened.label', default: 'Date Opened'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',61,['property':("branch"),'title':(message(code: 'deposit.branch.label', default: 'Branch'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',67,['property':("status"),'title':(message(code: 'deposit.status.label', default: 'Status'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(13)
expressionOut.print(fieldValue(bean: domainInstance, field: "acctNo"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "type.description"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: domainInstance, field: "customer.displayName"))
printHtmlPart(14)
expressionOut.print(domainInstance?.dateOpened?.format("MM/dd/yyyy"))
printHtmlPart(14)
expressionOut.print(domainInstance?.branch?.name)
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "status.description"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "ownershipType.description"))
printHtmlPart(16)
if(true && (params.actionTemplate)) {
printHtmlPart(17)
invokeTag('hiddenField','g',86,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(18)
invokeTag('render','g',88,['template':("actionTemplate/${params.actionTemplate}"),'model':([depositInstance:domainInstance])],-1)
printHtmlPart(19)
}
else {
printHtmlPart(20)
expressionOut.print(domainInstance?.id)
printHtmlPart(21)
expressionOut.print(domainInstance?.acctNo)
printHtmlPart(22)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',100,['total':(domainInstanceCount ?: 0)],-1)
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
