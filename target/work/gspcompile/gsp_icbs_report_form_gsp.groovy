import icbs.admin.Report
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_report_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: reportInstance, field: 'name', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("report.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("name"),'maxlength':("100"),'required':(""),'value':(reportInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(reportInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(reportInstance),'field':("name")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: reportInstance, field: 'reportGroup', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("report.reportGroup.label"),'default':("Report Group")],-1)
printHtmlPart(10)
invokeTag('select','g',31,['id':("reportGroup"),'name':("reportGroup.id"),'from':(icbs.lov.ReportGroup.list()),'optionKey':("id"),'value':(reportInstance?.reportGroup?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(reportInstance),'field':("reportGroup")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(reportInstance),'field':("reportGroup")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: reportInstance, field: 'reportType', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',48,['code':("report.reportType.label"),'default':("Report Type")],-1)
printHtmlPart(10)
invokeTag('select','g',51,['id':("reportType"),'name':("reportType.id"),'from':(icbs.lov.ReportType.list()),'optionKey':("id"),'value':(reportInstance?.reportType?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(reportInstance),'field':("reportType")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(reportInstance),'field':("reportType")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: reportInstance, field: 'sourceFile', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',68,['code':("report.sourceFile.label"),'default':("Source File")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(reportInstance),'field':("sourceFile")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(reportInstance),'field':("sourceFile")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: reportInstance, field: 'remarks', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',88,['code':("report.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(10)
invokeTag('textArea','g',91,['name':("remarks"),'value':(reportInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',98,['bean':(reportInstance),'field':("remarks")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',101,['bean':(reportInstance),'field':("remarks")],1)
printHtmlPart(15)
invokeTag('hiddenField','g',106,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',1,['name':("sourceFile"),'value':("/web-app")],-1)
printHtmlPart(17)
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
