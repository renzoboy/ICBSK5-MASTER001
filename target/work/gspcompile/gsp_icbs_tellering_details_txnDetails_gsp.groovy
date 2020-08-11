import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_txnDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_txnDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'tellering', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(5)
expressionOut.print(params?.query)
printHtmlPart(6)
invokeTag('hiddenField','g',29,['name':("searchType"),'value':("0")],-1)
printHtmlPart(7)
})
invokeTag('form','g',33,['id':("searchForm"),'name':("searchForm"),'url':([controller:tellering, action:'search'])],1)
printHtmlPart(8)
invokeTag('sortableColumn','g',40,['property':("id"),'title':(message(code: 'txnFile.id', default: 'ID'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',42,['property':("code"),'title':("Transaction Code")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',44,['property':("acctNo"),'title':("Account Number")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',46,['property':("txnAmt"),'title':("Transaction Amount")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',47,['property':("txnDescription"),'title':("TXN Description")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',48,['property':("txnRef"),'title':("Reference")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',49,['property':("txnParticulars"),'title':("Particulars")],-1)
printHtmlPart(11)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(12)
expressionOut.print(fieldValue(bean: domainInstance, field: "id"))
printHtmlPart(13)
expressionOut.print(domainInstance?.txnCode)
printHtmlPart(13)
expressionOut.print(domainInstance?.acctNo)
printHtmlPart(14)
invokeTag('formatNumber','g',63,['number':(domainInstance?.txnAmt),'format':("###,##0.00")],-1)
printHtmlPart(15)
expressionOut.print(domainInstance?.txnDescription)
printHtmlPart(15)
expressionOut.print(domainInstance?.txnRef)
printHtmlPart(16)
expressionOut.print(domainInstance?.txnParticulars)
printHtmlPart(17)
if(true && (params.actionTemplate)) {
printHtmlPart(10)
invokeTag('hiddenField','g',69,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(10)
invokeTag('render','g',70,['template':("actionTemplate/${params.actionTemplate}"),'model':([txnFileInstance:domainInstance])],-1)
printHtmlPart(10)
}
else {
printHtmlPart(18)
expressionOut.print(domainInstance?.id)
printHtmlPart(19)
}
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',81,['total':(domainInstanceCount ?: 0)],-1)
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
