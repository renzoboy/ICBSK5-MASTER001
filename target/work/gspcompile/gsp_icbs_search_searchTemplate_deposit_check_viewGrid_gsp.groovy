import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_check_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/check/_viewGrid.gsp" }
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
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',16,['id':("id"),'name':("id"),'value':(params?.id ?:depositInstance?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-check")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(8)
expressionOut.print(params?.searchQuery)
printHtmlPart(9)
})
invokeTag('form','g',32,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
expressionOut.print(domainInstance?.chequeNo)
printHtmlPart(12)
expressionOut.print(domainInstance?.chequeDate?.format('MM/dd/yyyy'))
printHtmlPart(12)
expressionOut.print(domainInstance?.payeeName)
printHtmlPart(12)
expressionOut.print(domainInstance?.payeeAcctNo)
printHtmlPart(12)
invokeTag('formatNumber','g',51,['number':(domainInstance?.chequeAmt),'format':("###,##0.00")],-1)
printHtmlPart(12)
expressionOut.print(domainInstance?.clrAcctNo)
printHtmlPart(12)
expressionOut.print(domainInstance?.status?.description)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
invokeTag('paginate','g',58,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(15)
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
