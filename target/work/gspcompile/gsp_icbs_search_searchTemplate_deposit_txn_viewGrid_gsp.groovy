import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_txn_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/txn/_viewGrid.gsp" }
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
invokeTag('hiddenField','g',17,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-txn")],-1)
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
expressionOut.print(domainInstance?.id)
printHtmlPart(12)
expressionOut.print(domainInstance?.txnFile?.id)
printHtmlPart(12)
expressionOut.print(domainInstance?.txnDate?.format("MM/dd/yyyy"))
printHtmlPart(13)
expressionOut.print(domainInstance?.txnType)
printHtmlPart(13)
expressionOut.print(domainInstance?.user?.username)
printHtmlPart(14)
invokeTag('formatNumber','g',57,['number':(domainInstance?.debitAmt),'format':("###,##0.00")],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',58,['number':(domainInstance?.creditAmt),'format':("###,##0.00")],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',60,['number':(domainInstance?.bal),'format':("###,##0.00")],-1)
printHtmlPart(16)
expressionOut.print(domainInstance?.currency?.code)
printHtmlPart(17)
expressionOut.print(domainInstance?.txnRef)
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',64,['type':("button"),'action':("viewTxnDetails"),'id':(domainInstance?.txnFile?.id),'controller':("deposit")],2)
printHtmlPart(20)
if(true && (domainInstance?.txnType?.id == 4)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',66,['action':("viewCheckDepDetails"),'id':(domainInstance?.txnFile?.id)],3)
printHtmlPart(20)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',73,['total':(domainInstanceCount ?: 0)],-1)
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
