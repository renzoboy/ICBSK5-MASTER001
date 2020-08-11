import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercustomerViewMoreInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/customerViewMoreInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('render','g',19,['template':("viewMoreInfoTemplates/primaryInfo")],-1)
printHtmlPart(6)
invokeTag('render','g',24,['template':("viewMoreInfoTemplates/xform")],-1)
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',27,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('link','g',30,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
expressionOut.print(icbs.admin.Institution.get(90).paramValue)
expressionOut.print(icbs.admin.Report.get(5).baseParams)
printHtmlPart(12)
expressionOut.print(icbs.admin.Report.get(5).outputParam)
printHtmlPart(13)
expressionOut.print(icbs.admin.Report.get(5).reportUnit)
printHtmlPart(14)
expressionOut.print(customerInstance?.customerId)
printHtmlPart(15)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(16)
})
invokeTag('javascript','g',42,[:],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',44,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595574998526L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
