import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccountindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glAccount.label', default: 'GlAccount'))],-1)
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
if(true && (flash.success)) {
printHtmlPart(9)
expressionOut.print(flash.success)
printHtmlPart(10)
}
else if(true && (flash.error)) {
printHtmlPart(11)
expressionOut.print(flash.error)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('select','g',28,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(15)
invokeTag('textField','g',32,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 350px;"),'placeholder':("Search")],-1)
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('submitButton','g',34,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(18)
})
invokeTag('form','g',34,['class':("form-inline")],3)
printHtmlPart(19)
invokeTag('sortableColumn','g',41,['property':("name"),'title':(message(code: 'glAccount.name.label', default: 'Name'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',42,['property':("code"),'title':(message(code: 'glAccount.code.label', default: 'Code'))],-1)
printHtmlPart(21)
invokeTag('message','g',44,['code':("glAccount.currency.label"),'default':("Currency")],-1)
printHtmlPart(22)
invokeTag('message','g',46,['code':("glAccount.branch.label"),'default':("Branch")],-1)
printHtmlPart(23)
invokeTag('message','g',47,['code':("glAccount.type.label"),'default':("Type")],-1)
printHtmlPart(24)
invokeTag('message','g',49,['code':("glAccount.parent.label"),'default':("Parent")],-1)
printHtmlPart(25)
loop:{
int i = 0
for( glAccountInstance in (glAccountInstanceList) ) {
printHtmlPart(26)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: glAccountInstance, field: "name"))
})
invokeTag('link','g',57,['action':("show"),'id':(glAccountInstance.id)],4)
printHtmlPart(28)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "code"))
printHtmlPart(29)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "currency.name"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "branch.name"))
printHtmlPart(30)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "type"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: glAccountInstance, field: "parent.sort_name"))
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
invokeTag('paginate','g',75,['total':(GlAccountInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(34)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(35)
invokeTag('message','g',81,['code':("default.home.label")],-1)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',82,['class':("create"),'action':("create")],3)
printHtmlPart(38)
expressionOut.print(createLink(uri: '/glSortCode'))
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(37).baseParams)
printHtmlPart(41)
expressionOut.print(icbs.admin.Report.get(37).outputParam)
printHtmlPart(42)
expressionOut.print(icbs.admin.Report.get(37).reportUnit)
printHtmlPart(43)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(44)
})
invokeTag('javascript','g',91,[:],3)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',93,[:],1)
printHtmlPart(46)
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
