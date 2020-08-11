import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsperiodicOpsLog_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/periodicOpsLog.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(2)
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
invokeTag('select','g',25,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
})
invokeTag('form','g',27,['class':("form-inline"),'url':([action:'periodicOpsLog',controller:'periodicOps']),'method':("POST")],3)
printHtmlPart(12)
loop:{
int i = 0
for( periodicOpsLogInstance in (periodicOpsLogList) ) {
printHtmlPart(13)
invokeTag('formatDate','g',40,['format':("MM/dd/yyyy"),'date':(periodicOpsLogInstance.runDate)],-1)
printHtmlPart(14)
expressionOut.print(periodicOpsLogInstance.startTime)
printHtmlPart(14)
expressionOut.print(periodicOpsLogInstance.endTime)
printHtmlPart(14)
expressionOut.print(periodicOpsLogInstance.processUID)
printHtmlPart(14)
expressionOut.print(periodicOpsLogInstance.periodicOpsProcess.processDescription)
printHtmlPart(14)
expressionOut.print(periodicOpsLogInstance?.user?.name1)
printHtmlPart(15)
expressionOut.print(periodicOpsLogInstance?.user?.name2)
printHtmlPart(15)
expressionOut.print(periodicOpsLogInstance?.user?.name3)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
invokeTag('paginate','g',52,['total':(periodicOpsLogInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',57,['class':("index"),'action':("index")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',59,['class':("lockSystem"),'action':("lockSystem")],3)
printHtmlPart(23)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',62,['class':("unlockSystem"),'action':("unlockSystem")],3)
printHtmlPart(23)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',63,['class':("EODCheck"),'action':("EODCheck")],3)
printHtmlPart(23)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',66,['class':("eodReports"),'action':("eodReport")],3)
printHtmlPart(23)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',67,['class':("eomReports"),'action':("eomReport")],3)
printHtmlPart(23)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',68,['class':("periodicOpsUtil"),'action':("periodicOpsUtil")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',69,[:],1)
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
