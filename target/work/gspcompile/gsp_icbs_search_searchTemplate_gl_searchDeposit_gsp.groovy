import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_gl_searchDeposit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/gl/_searchDeposit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(1)
})
invokeTag('javascript','g',6,[:],1)
printHtmlPart(2)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('hiddenField','g',12,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',13,['id':("searchDomain"),'name':("searchDomain"),'value':("gl-deposits")],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',14,['id':("branch_id"),'name':("branch_id"),'value':(params?.branch_id)],-1)
printHtmlPart(6)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(7)
expressionOut.print(params?.searchQuery)
printHtmlPart(8)
})
invokeTag('form','g',29,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(9)
invokeTag('sortableColumn','g',35,['property':("sort_code"),'title':(message(code: 'Deposit.acctNo.label', default: 'Account No'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',37,['property':("sort_name"),'title':(message(code: 'Deposit.acctName.label', default: 'Account Name'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',39,['property':("sort_name"),'title':(message(code: 'Deposit.branch.label', default: 'Branch'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(12)
expressionOut.print(fieldValue(bean: domainInstance, field: "acctNo"))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: domainInstance, field: "acctName"))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: domainInstance, field: "branch.name"))
printHtmlPart(14)
expressionOut.print(domainInstance?.id)
printHtmlPart(15)
expressionOut.print(domainInstance?.acctNo)
printHtmlPart(16)
expressionOut.print(domainInstance?.acctName)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',62,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(19)
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
