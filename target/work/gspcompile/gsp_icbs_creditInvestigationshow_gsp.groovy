import icbs.loans.CreditInvestigation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'creditInvestigation.label', default: 'CreditInvestigation'))],-1)
printHtmlPart(2)
if(true && (secUnsecTag == "unsec")) {
printHtmlPart(3)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',10,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],3)
printHtmlPart(5)
}
else {
printHtmlPart(6)
createTagBody(3, {->
createClosureForHtmlPart(7, 4)
invokeTag('captureTitle','sitemesh',13,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],3)
printHtmlPart(5)
}
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
if(true && (secUnsecTag == "unsec")) {
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',26,['tag':("breadcrumbs")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(15)
if(true && (flash.message)) {
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('render','g',47,['template':("details/show")],-1)
printHtmlPart(19)
invokeTag('render','g',50,['template':("attachments/show")],-1)
printHtmlPart(20)
invokeTag('render','g',53,['template':("checklist"),'model':([creditInvestigationInstance:creditInvestigationInstance])],-1)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',57,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
if(true && (secUnsecTag == "unsec")) {
printHtmlPart(24)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',62,['action':("edit"),'controller':("creditInvestigation"),'id':(creditInvestigationInstance.id),'params':([creditType: 'unsecured'])],4)
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',63,['class':("list"),'action':("index")],4)
printHtmlPart(28)
}
else {
printHtmlPart(29)
createClosureForHtmlPart(30, 4)
invokeTag('link','g',66,['class':("list"),'action':("index")],4)
printHtmlPart(26)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',67,['action':("edit"),'controller':("creditInvestigation"),'id':(creditInvestigationInstance.id),'params':([creditType: 'secured'])],4)
printHtmlPart(32)
}
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(17).baseParams)
printHtmlPart(35)
expressionOut.print(icbs.admin.Report.get(17).outputParam)
printHtmlPart(36)
expressionOut.print(icbs.admin.Report.get(17).reportUnit)
printHtmlPart(37)
expressionOut.print(creditInvestigationInstance?.id)
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(39)
})
invokeTag('javascript','g',78,[:],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(41)
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
