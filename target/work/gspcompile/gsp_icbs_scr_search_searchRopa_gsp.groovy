import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_scr_search_searchRopa_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/scr/search/_searchRopa.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
expressionOut.print(createLink(controller:'scr', action:'search'))
printHtmlPart(1)
})
invokeTag('javascript','g',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('select','g',15,['name':("max"),'value':(params.max),'from':([25 , 50 , 75 , 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(4)
expressionOut.print(params?.query)
printHtmlPart(5)
invokeTag('hiddenField','g',28,['name':("searchType"),'value':("0")],-1)
printHtmlPart(6)
})
invokeTag('form','g',32,['id':("searchForm"),'name':("searchForm"),'url':([controller:scr, action:'search'])],1)
printHtmlPart(7)
invokeTag('sortableColumn','g',39,['property':("id"),'title':(message(code: 'ROPA.id', default: 'ID'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',41,['property':("loanAcctNo"),'title':(message(code: 'ROPA.loanAcctNo.label', default: 'Loan Account'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',43,['property':("glContraLitigationExp"),'title':(message(code: 'ROPA.glContraLitigationExp.label', default: 'GL Contra Litigation'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',45,['property':("glContraRopa"),'title':(message(code: 'ROPA.glContraRopa.label', default: 'GL Contra ROPA'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',47,['property':("glContraBldg"),'title':(message(code: 'ROPA.glContraBldg.label', default: 'GL Contra Building'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',49,['property':("loanBalance"),'title':(message(code: 'ROPA.loanBalance.label', default: 'Loan Balance'))],-1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
expressionOut.print(fieldValue(bean: domainInstance, field: "id"))
printHtmlPart(12)
expressionOut.print(domainInstance?.loanAcctNo)
printHtmlPart(13)
expressionOut.print(domainInstance?.glContraLitigationExp)
printHtmlPart(13)
expressionOut.print(domainInstance?.glContraRopa)
printHtmlPart(13)
expressionOut.print(domainInstance?.glContraBldg)
printHtmlPart(13)
expressionOut.print(domainInstance?.loanBalance)
printHtmlPart(14)
expressionOut.print(domainInstance?.id)
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',79,['total':(domainInstanceCount ?: 0)],-1)
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
