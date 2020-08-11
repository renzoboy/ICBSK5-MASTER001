import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_reprintGrid_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/reprintGrid/_viewGrid.gsp" }
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
invokeTag('javascript','g',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',15,['id':("id"),'name':("id"),'value':(params?.id ?:depositInstance?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',16,['id':("type"),'name':("type"),'value':(params?.type ?:depositInstance?.type?.id)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("searchDomain"),'name':("searchDomain"),'value':("depositreprint")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',18,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(8)
invokeTag('customDatePicker','g',25,['name':("txndate"),'id':("txndate"),'value':(""),'precision':("day"),'class':("form-control")],-1)
printHtmlPart(9)
})
invokeTag('form','g',32,['id':("searchForm"),'name':("searchForm")],1)
printHtmlPart(10)
if(true && (params.type == '3')) {
printHtmlPart(11)
loop:{
int i = 0
for( Fd in (domainInstanceList) ) {
printHtmlPart(12)
expressionOut.print(Fd?.id)
printHtmlPart(13)
expressionOut.print(Fd?.txnDate?.format("MM/dd/yyyy"))
printHtmlPart(13)
expressionOut.print(Fd?.txnType)
printHtmlPart(14)
invokeTag('formatNumber','g',84,['format':("###,###,##0.00"),'number':(Fd.debitAmt)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',85,['format':("###,###,##0.00"),'number':(Fd.creditAmt)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',86,['format':("###,###,##0.00"),'number':(Fd.bal)],-1)
printHtmlPart(13)
expressionOut.print(Fd?.currency?.code)
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: Fd, field: "passbookLine").padLeft(3, '0'))
})
invokeTag('link','g',88,['action':("reprintPassbookShow"),'controller':("tellering"),'id':(Fd?.id)],3)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',94,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(18)
if(true && (params.type == '2')) {
printHtmlPart(19)
}
printHtmlPart(20)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(12)
expressionOut.print(domainInstance?.id)
printHtmlPart(13)
expressionOut.print(domainInstance?.txnDate?.format("MM/dd/yyyy"))
printHtmlPart(13)
expressionOut.print(domainInstance?.txnType)
printHtmlPart(21)
if(true && (params.type == '2')) {
printHtmlPart(22)
if(true && (domainInstance?.txnFile?.txnTemplate?.id == 12 || domainInstance?.txnFile?.txnTemplate?.id == 13 || domainInstance?.txnFile?.txnTemplate?.id == 17 || domainInstance?.txnFile?.txnTemplate?.id == 19)) {
printHtmlPart(23)
expressionOut.print(domainInstance?.txnRef)
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('formatNumber','g',130,['format':("###,###,##0.00"),'number':(domainInstance?.debitAmt)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',131,['format':("###,###,##0.00"),'number':(domainInstance?.creditAmt)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',132,['format':("###,###,##0.00"),'number':(domainInstance?.bal)],-1)
printHtmlPart(28)
expressionOut.print(domainInstance?.currency?.code)
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: domainInstance, field: "passbookLine").padLeft(3, '0'))
})
invokeTag('link','g',134,['action':("reprintPassbookShow"),'controller':("tellering"),'id':(domainInstance.id)],3)
printHtmlPart(15)
i++
}
}
printHtmlPart(29)
invokeTag('paginate','g',140,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(30)
}
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
