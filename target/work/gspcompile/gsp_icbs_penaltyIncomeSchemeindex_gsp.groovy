import icbs.loans.PenaltyIncomeScheme
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_penaltyIncomeSchemeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/penaltyIncomeScheme/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'penaltyIncomeScheme.label', default: 'PenaltyIncomeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(2)
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
invokeTag('select','g',30,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',33,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Code or Name")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',35,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
})
invokeTag('form','g',40,[:],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',46,['property':("code"),'title':(message(code: 'penaltyIncomeScheme.code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',48,['property':("name"),'title':(message(code: 'penaltyIncomeScheme.name.label', default: 'Name'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',50,['property':("basis"),'title':(message(code: 'penaltyIncomeScheme.basis.label', default: 'Basis'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',52,['property':("status"),'title':(message(code: 'penaltyIncomeScheme.status.label', default: 'Status'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( penaltyIncomeSchemeInstance in (penaltyIncomeSchemeInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
expressionOut.print(penaltyIncomeSchemeInstance?.code)
printHtmlPart(21)
expressionOut.print(penaltyIncomeSchemeInstance?.name)
printHtmlPart(22)
expressionOut.print(penaltyIncomeSchemeInstance?.basis?.description)
printHtmlPart(21)
expressionOut.print(penaltyIncomeSchemeInstance.status?.description)
printHtmlPart(23)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',68,['class':("btn btn-secondary"),'action':("show"),'id':(penaltyIncomeSchemeInstance.id)],4)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',75,['total':(penaltyIncomeSchemeInstanceCount ?: 0)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',82,['class':("create"),'action':("create")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',82,[:],1)
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
