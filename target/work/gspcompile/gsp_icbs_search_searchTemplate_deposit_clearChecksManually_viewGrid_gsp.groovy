import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_search_searchTemplate_deposit_clearChecksManually_viewGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/search/searchTemplate/deposit/clearChecksManually/_viewGrid.gsp" }
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
invokeTag('hiddenField','g',16,['id':("searchDomain"),'name':("searchDomain"),'value':("deposit-clearChecksManually")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',17,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(7)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([10, 20, 30, 40]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(8)
expressionOut.print(params?.searchQuery)
printHtmlPart(9)
})
invokeTag('form','g',42,['id':("searchForm"),'name':("searchForm"),'style':("display:none")],1)
printHtmlPart(10)
loop:{
int i = 0
for( coci in (icbs.tellering.TxnCOCI.findAll{depAcct==depositInstance}) ) {
printHtmlPart(11)
if(true && (coci?.cleared == 'false' && coci?.status?.id == 2 && coci?.checkStatus?.id != 5)) {
printHtmlPart(12)
invokeTag('hiddenField','g',61,['name':("id"),'value':(coci?.id),'disabled':("disabled")],-1)
printHtmlPart(13)
expressionOut.print(coci?.checkNo)
printHtmlPart(14)
expressionOut.print(coci?.checkType?.description)
printHtmlPart(14)
expressionOut.print(coci?.acctNo)
printHtmlPart(14)
expressionOut.print(coci?.bank?.name)
printHtmlPart(14)
invokeTag('formatNumber','g',66,['number':(coci?.checkAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',67,['format':("yyyy-MM-dd"),'date':(coci?.clearingDate)],-1)
printHtmlPart(14)
expressionOut.print(coci?.status?.description)
printHtmlPart(15)
expressionOut.print(coci?.id)
printHtmlPart(16)
expressionOut.print(coci?.id)
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',80,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(20)
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
