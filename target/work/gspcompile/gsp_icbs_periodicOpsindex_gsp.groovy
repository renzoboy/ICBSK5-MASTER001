import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("periodicOpsHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller : 'periodicOps', action:'startOfDayProgressAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfDayProgressAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfMonthProgressAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfYearProgressAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'periodicOps', action:'startOfDay'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfDay'))
printHtmlPart(11)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfMonth'))
printHtmlPart(12)
expressionOut.print(createLink(controller : 'periodicOps', action:'endOfYear'))
printHtmlPart(13)
})
invokeTag('javascript','g',89,[:],2)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',90,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('captureContent','sitemesh',94,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('customDatePicker','g',120,['disabled':("disabled"),'name':("startOfDayDate"),'precision':("day"),'class':("form-control"),'value':(Branch.get(1).runDate)],-1)
printHtmlPart(21)
expressionOut.print(createLink(controller : 'periodicOps', action:'getStartOfDayReport'))
printHtmlPart(22)
invokeTag('customDatePicker','g',157,['disabled':("disabled"),'name':("endOfDayDate"),'precision':("day"),'class':("form-control"),'value':(Branch.get(1).runDate)],-1)
printHtmlPart(23)
expressionOut.print(createLink(controller : 'periodicOps', action:'getEndOfDayReport'))
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',200,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(25)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',204,['class':("lockSystem"),'action':("lockSystem")],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',205,['class':("unlockSystem"),'action':("unlockSystem")],3)
printHtmlPart(28)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',206,['class':("EODCheck"),'action':("EODCheck")],3)
printHtmlPart(28)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',207,['class':("eodReports"),'action':("eodReport")],3)
printHtmlPart(28)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',208,['class':("eomReports"),'action':("eomReport")],3)
printHtmlPart(28)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',209,['class':("periodicOpsUtil"),'action':("periodicOpsUtil")],3)
printHtmlPart(28)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',210,['class':("periodicOpsLog"),'action':("periodicOpsLog")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',212,['tag':("main-actions")],2)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',213,[:],1)
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
