import icbs.admin.Report
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_reportindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'report.label', default: 'Report'))],-1)
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
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('select','g',19,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(10)
invokeTag('textField','g',23,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 4)
invokeTag('submitButton','g',25,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(13)
})
invokeTag('form','g',27,['class':("form-inline")],3)
printHtmlPart(14)
invokeTag('sortableColumn','g',34,['property':("name"),'title':(message(code: 'report.name.label', default: 'Name'))],-1)
printHtmlPart(15)
invokeTag('message','g',36,['code':("report.reportGroup.label"),'default':("Report Group")],-1)
printHtmlPart(16)
invokeTag('message','g',38,['code':("report.reportType.label"),'default':("Report Type")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',40,['property':("remarks"),'title':(message(code: 'report.remarks.label', default: 'Remarks'))],-1)
printHtmlPart(15)
invokeTag('message','g',42,['code':("report.configItemStatus.label"),'default':("Status")],-1)
printHtmlPart(18)
loop:{
int i = 0
for( reportInstance in (reportInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: reportInstance, field: "name"))
})
invokeTag('link','g',50,['action':("show"),'id':(reportInstance.id)],4)
printHtmlPart(21)
expressionOut.print(fieldValue(bean: reportInstance, field: "reportGroup.description"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: reportInstance, field: "reportType.description"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: reportInstance, field: "remarks"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: reportInstance, field: "configItemStatus.description"))
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',66,['total':(ReportInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',72,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',72,['class':("create"),'action':("create")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',75,[:],1)
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
