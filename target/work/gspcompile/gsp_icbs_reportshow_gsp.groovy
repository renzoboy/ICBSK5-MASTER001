import icbs.admin.Report
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_reportshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/show.gsp" }
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
if(true && (reportInstance?.name)) {
printHtmlPart(10)
invokeTag('message','g',20,['code':("report.name.label"),'default':("Name")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',22,['bean':(reportInstance),'field':("name")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (reportInstance?.reportGroup)) {
printHtmlPart(14)
invokeTag('message','g',29,['code':("report.reportGroup.label"),'default':("Report Group")],-1)
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(reportInstance?.reportGroup?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("reportGroup"),'action':("show"),'id':(reportInstance?.reportGroup?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (reportInstance?.reportType)) {
printHtmlPart(16)
invokeTag('message','g',38,['code':("report.reportType.label"),'default':("Report Type")],-1)
printHtmlPart(17)
createTagBody(4, {->
expressionOut.print(reportInstance?.reportType?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("reportType"),'action':("show"),'id':(reportInstance?.reportType?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (reportInstance?.sourceFile)) {
printHtmlPart(18)
invokeTag('message','g',47,['code':("report.sourceFile.label"),'default':("Source File")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',49,['bean':(reportInstance),'field':("sourceFile")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (reportInstance?.remarks)) {
printHtmlPart(20)
invokeTag('message','g',56,['code':("report.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',58,['bean':(reportInstance),'field':("remarks")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (reportInstance?.configItemStatus)) {
printHtmlPart(22)
invokeTag('message','g',65,['code':("report.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(23)
expressionOut.print(reportInstance?.configItemStatus?.description)
printHtmlPart(12)
}
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('form','g',74,['id':("show"),'url':([resource:reportInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',79,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',79,['class':("create"),'action':("create")],3)
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',80,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',80,['action':("edit"),'resource':(reportInstance)],3)
printHtmlPart(29)
invokeTag('actionSubmit','g',81,['form':("show"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',84,[:],1)
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
