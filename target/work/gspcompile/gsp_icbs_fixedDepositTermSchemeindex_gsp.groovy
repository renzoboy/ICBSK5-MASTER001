import icbs.deposit.FixedDepositTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositTermSchemeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositTermScheme/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'fixedDepositTermScheme.label', default: 'FixedDepositTermScheme'))],-1)
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
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(13)
})
invokeTag('form','g',33,[:],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',39,['property':("code"),'title':(message(code: 'fixedDepositTermScheme.code.label', default: 'Code'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',41,['property':("description"),'title':(message(code: 'fixedDepositTermScheme.description.label', default: 'Description'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',43,['property':("value"),'title':(message(code: 'fixedDepositTermScheme.value.label', default: 'Value'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',45,['property':("termMin"),'title':(message(code: 'fixedDepositTermScheme.termMin.label', default: 'Term Min'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',47,['property':("termMax"),'title':(message(code: 'fixedDepositTermScheme.termMax.label', default: 'Term Max'))],-1)
printHtmlPart(16)
invokeTag('message','g',49,['code':("fixedDepositTermScheme.status.label"),'default':("Status")],-1)
printHtmlPart(17)
loop:{
int i = 0
for( fixedDepositTermSchemeInstance in (fixedDepositTermSchemeInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: fixedDepositTermSchemeInstance, field: "code"))
})
invokeTag('link','g',57,['action':("show"),'id':(fixedDepositTermSchemeInstance.id)],4)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: fixedDepositTermSchemeInstance, field: "description"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: fixedDepositTermSchemeInstance, field: "value"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: fixedDepositTermSchemeInstance, field: "termMin"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: fixedDepositTermSchemeInstance, field: "termMax"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: fixedDepositTermSchemeInstance, field: "status"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',75,['total':(FixedDepositTermSchemeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',81,['class':("create"),'action':("create")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',84,[:],1)
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
