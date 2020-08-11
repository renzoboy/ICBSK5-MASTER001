import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaForTransfer_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaForTransfer.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
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
invokeTag('textField','g',24,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 250px;"),'placeholder':("Search Former Title or Kind of Land")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',26,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',28,['class':("form-inline"),'url':([controller:'ropa', action:'ropaForTransfer']),'method':("POST")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',34,['property':("id"),'title':(message(code: 'GlContigentAccount.id.label', default: 'ID'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("branch"),'title':(message(code: 'GlContigentAccount.id.label', default: 'Branch'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("refDate"),'title':(message(code: 'GlContigentAccount.id.label', default: 'Date'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',37,['property':("formerTitle"),'title':(message(code: 'GlContigentAccount.id.label', default: 'Former Title'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("kindOfLand"),'title':(message(code: 'ropa.ropaDate.label', default: 'Kind of Land'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( RopaInstance in (RopaInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(RopaInstance.id)
printHtmlPart(20)
expressionOut.print(RopaInstance.loan.branch.name)
printHtmlPart(20)
invokeTag('formatDate','g',49,['format':("MM/dd/yyyy"),'date':(RopaInstance.refDate)],-1)
printHtmlPart(20)
expressionOut.print(RopaInstance.formerTitle)
printHtmlPart(20)
expressionOut.print(RopaInstance.kindOfLand)
printHtmlPart(20)
expressionOut.print(RopaInstance?.status?.description)
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',53,['class':("btn btn-secondary"),'action':("collateralShow"),'id':(RopaInstance?.id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',61,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',68,['controller':("home"),'action':("landing")],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',69,['action':("create")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',70,['action':("index")],3)
printHtmlPart(28)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',71,['action':("indexScr")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',73,['action':("printRopaSchedule")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(36)
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
