import icbs.cif.Code
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_codeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/code/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'depositInterestScheme.label', default: 'DepositInterestScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',20,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
})
invokeTag('form','g',30,[:],3)
printHtmlPart(12)
invokeTag('message','g',37,['code':("code.type.label"),'default':("Type")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',39,['property':("value"),'title':(message(code: 'code.value.label', default: 'Value'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( codeInstance in (codeInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: codeInstance, field: "type.itemValue"))
})
invokeTag('link','g',48,['action':("show"),'id':(codeInstance.id)],4)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: codeInstance, field: "value"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',59,['total':(CodeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',65,['class':("create"),'action':("create")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(24)
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
