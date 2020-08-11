import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_branchindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/branch/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'branch.label', default: 'Branch'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
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
invokeTag('select','g',24,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',28,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',30,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',32,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',39,['property':("code"),'title':(message(code: 'branch.code.label', default: 'Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',41,['property':("name"),'title':(message(code: 'branch.name.label', default: 'Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',43,['property':("swiftCode"),'title':(message(code: 'branch.swiftCode.label', default: 'Swift Code'))],-1)
printHtmlPart(17)
invokeTag('message','g',45,['code':("branch.region.label"),'default':("Region")],-1)
printHtmlPart(18)
invokeTag('message','g',47,['code':("branch.branchRunStatus.label"),'default':("Run Status")],-1)
printHtmlPart(18)
invokeTag('message','g',49,['code':("branch.status.label"),'default':("Branch Status")],-1)
printHtmlPart(19)
loop:{
int i = 0
for( branchInstance in (branchInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: branchInstance, field: "code").padLeft(3, '0'))
})
invokeTag('link','g',57,['action':("show"),'id':(branchInstance.id)],4)
printHtmlPart(22)
expressionOut.print(fieldValue(bean: branchInstance, field: "name"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: branchInstance, field: "swiftCode"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: branchInstance, field: "region.itemValue"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "branchRunStatus.description"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: branchInstance, field: "status.description"))
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',75,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',82,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',82,['class':("create"),'action':("create")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',84,['action':("noCreate")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',87,[:],1)
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
