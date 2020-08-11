import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagementshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/show.gsp" }
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
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller :'collateralManagement', action:'updateStatusAjax'))
printHtmlPart(5)
expressionOut.print(collateralInstance.id)
printHtmlPart(6)
expressionOut.print(createLink(controller :'collateralManagement', action:'showUpdateStatusAjax'))
printHtmlPart(7)
})
invokeTag('javascript','g',51,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',56,['tag':("breadcrumbs")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (collateralInstance?.collateralType?.id == 4)) {
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('render','g',79,['template':("details/show")],-1)
printHtmlPart(17)
if(true && (collateralInstance?.collateralType?.id == 4)) {
printHtmlPart(18)
invokeTag('render','g',83,['template':("pdc/show")],-1)
printHtmlPart(17)
}
printHtmlPart(19)
invokeTag('render','g',87,['template':("attachments/show")],-1)
printHtmlPart(20)
invokeTag('render','g',90,['template':("loanApplications/show")],-1)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',111,['tag':("main-content")],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',114,['class':("list"),'action':("index")],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',115,['controller':("collateralManagement"),'action':("edit"),'id':(collateralInstance?.id)],3)
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(19).baseParams)
printHtmlPart(28)
expressionOut.print(icbs.admin.Report.get(19).outputParam)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(19).reportUnit)
printHtmlPart(30)
expressionOut.print(collateralInstance?.id)
printHtmlPart(31)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(32)
})
invokeTag('javascript','g',125,[:],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',128,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(34)
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
