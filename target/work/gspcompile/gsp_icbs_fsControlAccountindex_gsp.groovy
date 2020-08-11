import icbs.gl.FsControlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fsControlAccountindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fsControlAccount/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
invokeTag('select','g',16,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(9)
invokeTag('textField','g',20,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search by Code and Description")],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('submitButton','g',22,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(12)
})
invokeTag('form','g',24,['class':("form-inline")],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("account"),'title':(message(code: 'AssetsHeldToMaturity.glCode.label', default: 'Account Code '))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("description"),'title':(message(code: 'AssetsHeldToMaturity.htmType.label', default: 'Description'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("status"),'title':(message(code: 'AssetsHeldToMaturity.description.label', default: 'status'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( fsControlAccountInstance in (fsControlAccountList) ) {
printHtmlPart(14)
if(true && (fsControlAccountInstance?.status.id == 2)) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(fsControlAccountInstance?.id)
printHtmlPart(18)
expressionOut.print(fsControlAccountInstance?.account)
printHtmlPart(19)
expressionOut.print(fsControlAccountInstance?.description)
printHtmlPart(20)
expressionOut.print(fsControlAccountInstance?.status?.description)
printHtmlPart(20)
createClosureForHtmlPart(21, 5)
invokeTag('link','g',43,['class':("btn btn-secondary"),'action':("show"),'id':(fsControlAccountInstance?.id)],5)
printHtmlPart(22)
}
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',50,['total':(fsControlAccountInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',57,['controller':("home"),'action':("landing")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',58,['action':("create")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(32)
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
