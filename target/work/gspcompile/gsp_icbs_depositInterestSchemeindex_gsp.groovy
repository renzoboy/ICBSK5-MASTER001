import icbs.deposit.DepositInterestScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestSchemeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/index.gsp" }
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
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
})
invokeTag('form','g',33,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',40,['property':("code"),'title':(message(code: 'depositInterestScheme.code.label', default: 'Code'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',42,['property':("name"),'title':(message(code: 'depositInterestScheme.name.label', default: 'Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',44,['property':("interestRate"),'title':(message(code: 'depositInterestScheme.interestRate.label', default: 'Interest Rate'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',46,['property':("divisor"),'title':(message(code: 'depositInterestScheme.divisor.label', default: 'Divisor'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',48,['property':("minInterestRate"),'title':(message(code: 'depositInterestScheme.minInterestRate.label', default: 'Min Interest Rate'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',50,['property':("maxInterestRate"),'title':(message(code: 'depositInterestScheme.maxInterestRate.label', default: 'Max Interest Rate'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( depositInterestSchemeInstance in (depositInterestSchemeInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: depositInterestSchemeInstance, field: "code"))
})
invokeTag('link','g',58,['action':("show"),'id':(depositInterestSchemeInstance.id)],4)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: depositInterestSchemeInstance, field: "name"))
printHtmlPart(18)
invokeTag('formatNumber','g',62,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.interestRate)],-1)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: depositInterestSchemeInstance, field: "divisor"))
printHtmlPart(18)
invokeTag('formatNumber','g',66,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.minInterestRate)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',68,['format':("#,##0.00"),'number':(depositInterestSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(20)
expressionOut.print(depositInterestSchemeInstance?.status?.description)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',78,['total':(DepositInterestSchemeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',84,['class':("create"),'action':("create")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',87,[:],1)
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
