import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_sweep_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/sweep/_viewGrid.gsp" }
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
invokeTag('hiddenField','g',15,['id':("id"),'name':("id"),'value':(params?.id ?:depositInstance?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',16,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-sweep")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar2.searchMe();")],-1)
printHtmlPart(8)
expressionOut.print(params?.searchQuery)
printHtmlPart(9)
})
invokeTag('form','g',31,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
invokeTag('hiddenField','g',49,['name':("id"),'value':(domainInstance?.id),'disabled':("disabled")],-1)
printHtmlPart(12)
expressionOut.print(domainInstance?.id)
printHtmlPart(13)
expressionOut.print(domainInstance?.fundedDeposit?.acctNo)
printHtmlPart(13)
expressionOut.print(domainInstance?.fundedDeposit?.acctName)
printHtmlPart(13)
expressionOut.print(domainInstance?.rule?.description)
printHtmlPart(13)
expressionOut.print(domainInstance?.status?.description)
printHtmlPart(13)
expressionOut.print(domainInstance?.remarks)
printHtmlPart(13)
expressionOut.print(domainInstance?.ordinalNum)
printHtmlPart(13)
expressionOut.print(domainInstance?.dateCreated?.format("MM/dd/yyyy"))
printHtmlPart(13)
expressionOut.print(domainInstance?.createdBy?.username)
printHtmlPart(14)
expressionOut.print(domainInstance?.id)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',66,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(17)
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
