import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsclearCheckDeposits_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/clearCheckDeposits.gsp" }
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
createTagBody(3, {->
printHtmlPart(7)
expressionOut.print(hasErrors(bean: assetsHtmInstance, field: 'valueDate', 'has-error'))
printHtmlPart(8)
invokeTag('customDatePicker','g',51,['id':("depClearingDate"),'name':("depClearingDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
createTagBody(5, {->
printHtmlPart(11)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',58,['bean':(assetsHtmInstance),'field':("depClearingDate")],5)
printHtmlPart(13)
})
invokeTag('hasErrors','g',61,['bean':(assetsHtmInstance),'field':("depClearingDate")],4)
printHtmlPart(14)
})
invokeTag('form','g',64,['id':("depGetClearChecks"),'url':([controller:'periodicOps', action:'saveClearCheckDeposits']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(15)
invokeTag('hiddenField','g',65,['id':("branchRunDate"),'name':("branchRunDate"),'value':(g.formatDate(date: (runDate), format: 'MM/dd/yyyy'))],-1)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-content")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',72,['class':("index"),'action':("index")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',73,['class':("periodicOpsUtil"),'action':("periodicOpsUtil")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(24)
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
