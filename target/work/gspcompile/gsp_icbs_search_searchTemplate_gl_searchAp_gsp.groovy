import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_gl_searchAp_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/gl/_searchAp.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(1)
})
invokeTag('javascript','g',7,[:],1)
printHtmlPart(2)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('hiddenField','g',13,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',14,['id':("searchDomain"),'name':("searchDomain"),'value':("gl-aps")],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',15,['id':("branch_id"),'name':("branch_id"),'value':(params?.branch_id)],-1)
printHtmlPart(6)
invokeTag('select','g',19,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(7)
expressionOut.print(params?.searchQuery)
printHtmlPart(8)
})
invokeTag('form','g',30,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(9)
invokeTag('sortableColumn','g',37,['property':("id"),'title':(message(code: 'aps.id', default: 'ID'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',39,['property':("glaccount"),'title':(message(code: 'aps.glaccount.label', default: 'GL Account No.'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',41,['property':("clientname"),'title':(message(code: 'aps.clientname.label', default: 'Client'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',43,['property':("reference"),'title':(message(code: 'aps.reference.label', default: 'Reference'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',45,['property':("amount"),'title':(message(code: 'aps.amount.label', default: 'Amount'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',47,['property':("transdate"),'title':(message(code: 'aps.transdate.label', default: 'Transaction Date'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(13)
expressionOut.print(fieldValue(bean: domainInstance, field: "id"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "glaccount"))
printHtmlPart(14)
expressionOut.print(fieldValue(bean: domainInstance, field: "clientname"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: domainInstance, field: "reference"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: domainInstance, field: "amount"))
printHtmlPart(16)
invokeTag('formatDate','g',65,['format':("MM/dd/yyyy"),'date':(domainInstance.transdate)],-1)
printHtmlPart(17)
expressionOut.print(domainInstance?.id)
printHtmlPart(18)
expressionOut.print(domainInstance?.glaccount)
printHtmlPart(19)
expressionOut.print(domainInstance?.clientname)
printHtmlPart(20)
expressionOut.print(domainInstance?.amount)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',80,['total':(domainInstanceCount ?: 0)],-1)
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
