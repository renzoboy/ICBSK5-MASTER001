import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_searchLoan_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/_searchLoan.gsp" }
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
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',15,['id':("searchDomain"),'name':("searchDomain"),'value':("loan")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',16,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("module"),'name':("module"),'value':(params.module)],-1)
printHtmlPart(7)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(8)
expressionOut.print(params?.searchQuery)
printHtmlPart(9)
})
invokeTag('form','g',41,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(10)
invokeTag('sortableColumn','g',46,['property':("accountNo"),'title':(message(code: 'loan.accountNo.label', default: 'Loan ID'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',48,['property':("status"),'title':(message(code: 'loan.status.label', default: 'Status'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(13)
expressionOut.print(fieldValue(bean: domainInstance, field: "acctNo"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "type.description"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "customer.displayName"))
printHtmlPart(14)
expressionOut.print(domainInstance?.dateOpened?.format("MM/dd/yyyy"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "status.description"))
printHtmlPart(15)
if(true && (params.actionTemplate)) {
printHtmlPart(16)
invokeTag('hiddenField','g',61,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(17)
invokeTag('render','g',63,['template':("actionTemplate/${params.actionTemplate}"),'model':([depositInstance:domainInstance])],-1)
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
invokeTag('paginate','g',76,['total':(domainInstanceCount ?: 0)],-1)
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
