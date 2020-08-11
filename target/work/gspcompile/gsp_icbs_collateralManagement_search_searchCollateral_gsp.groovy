import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_search_searchCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/search/_searchCollateral.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'collateralManagement', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',17,['class':("create"),'action':("create"),'controller':("collateralManagement")],2)
printHtmlPart(7)
expressionOut.print(params?.query)
printHtmlPart(8)
invokeTag('hiddenField','g',30,['name':("searchType"),'value':("0")],-1)
printHtmlPart(9)
})
invokeTag('form','g',34,['id':("searchForm"),'name':("searchForm"),'url':([controller:collateralManagement, action:'search'])],1)
printHtmlPart(10)
invokeTag('sortableColumn','g',41,['property':("id"),'title':("ID")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',43,['property':("collateralType.owner.displayName"),'title':("Owner")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',45,['property':("collateralType.description"),'title':("Type")],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',47,['property':("appraisedValue"),'title':("Appraised Value")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',49,['property':("description"),'title':("Description")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',51,['property':("status.description"),'title':("Status")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(15)
expressionOut.print(fieldValue(bean: domainInstance, field: "id"))
printHtmlPart(16)
expressionOut.print(domainInstance?.owner?.displayName)
printHtmlPart(17)
expressionOut.print(domainInstance?.collateralType?.description)
printHtmlPart(18)
invokeTag('formatNumber','g',65,['format':("###,##0.00"),'number':(domainInstance?.appraisedValue)],-1)
printHtmlPart(19)
expressionOut.print(domainInstance?.description)
printHtmlPart(20)
expressionOut.print(domainInstance?.status?.description)
printHtmlPart(21)
if(true && (params.actionTemplate)) {
printHtmlPart(22)
invokeTag('hiddenField','g',71,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(22)
invokeTag('render','g',72,['template':("actionTemplate/${params.actionTemplate}"),'model':([collateralInstance:domainInstance])],-1)
printHtmlPart(22)
}
else {
printHtmlPart(23)
expressionOut.print(domainInstance?.id)
printHtmlPart(24)
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',83,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(27)
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
