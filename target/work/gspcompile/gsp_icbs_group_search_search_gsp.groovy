import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_group_search_search_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/search/_search.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'group', action:'search'))
printHtmlPart(2)
})
invokeTag('javascript','g',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm "),'onchange':("searchVar.searchMe();")],-1)
printHtmlPart(5)
expressionOut.print(params?.query)
printHtmlPart(6)
invokeTag('hiddenField','g',29,['name':("searchType"),'value':("0")],-1)
printHtmlPart(7)
})
invokeTag('form','g',33,['id':("searchForm"),'name':("searchForm"),'url':([controller:group, action:'search'])],1)
printHtmlPart(8)
invokeTag('sortableColumn','g',40,['property':("id"),'title':("ID")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',42,['property':("name"),'title':("Name")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',44,['property':("parent.name"),'title':("Parent")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',46,['property':("meetinDate"),'title':("Meeting Date")],-1)
printHtmlPart(10)
loop:{
int i = 0
for( domainInstance in (domainInstanceList) ) {
printHtmlPart(11)
expressionOut.print(domainInstance?.id)
printHtmlPart(12)
expressionOut.print(domainInstance?.name)
printHtmlPart(12)
expressionOut.print(domainInstance?.parent?.name)
printHtmlPart(12)
invokeTag('formatDate','g',60,['format':("MM/dd/yyyy"),'date':(domainInstance?.meetingDate)],-1)
printHtmlPart(13)
if(true && (params.actionTemplate)) {
printHtmlPart(14)
invokeTag('hiddenField','g',63,['id':("actionTemplate"),'name':("actionTemplate"),'value':(params.actionTemplate)],-1)
printHtmlPart(14)
invokeTag('render','g',64,['template':("actionTemplate/${params.actionTemplate}"),'model':([groupInstance:domainInstance])],-1)
printHtmlPart(14)
}
else {
printHtmlPart(15)
expressionOut.print(domainInstance?.id)
printHtmlPart(16)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
invokeTag('paginate','g',75,['total':(domainInstanceCount ?: 0)],-1)
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
