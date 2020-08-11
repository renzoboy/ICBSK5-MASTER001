import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_passbook_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/passbook/_viewGrid.gsp" }
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
invokeTag('hiddenField','g',16,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-passbook")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
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
invokeTag('hiddenField','g',45,['name':("id"),'value':(domainInstance?.id),'disabled':("disabled")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',46,['name':("deposit_id"),'id':("deposit_id"),'value':(domainInstance?.deposit?.id)],-1)
printHtmlPart(13)
expressionOut.print(domainInstance?.passbook?.passbookNo)
printHtmlPart(14)
expressionOut.print(domainInstance?.dateIssued?.format("MM/dd/yyyy"))
printHtmlPart(14)
expressionOut.print(domainInstance?.issuedBy?.username)
printHtmlPart(14)
expressionOut.print(domainInstance?.remarks)
printHtmlPart(14)
expressionOut.print(domainInstance?.passbook?.status)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(domainInstance?.passbook?.passbookNo)
printHtmlPart(17)
expressionOut.print(domainInstance?.id)
printHtmlPart(18)
invokeTag('hiddenField','g',57,['name':("passbookNo"),'value':(domainInstance?.passbook?.passbookNo)],-1)
printHtmlPart(19)
})
invokeTag('form','g',59,['controller':("deposit"),'action':("printPassbookCover"),'target':("_blank")],2)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',114,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(22)
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
