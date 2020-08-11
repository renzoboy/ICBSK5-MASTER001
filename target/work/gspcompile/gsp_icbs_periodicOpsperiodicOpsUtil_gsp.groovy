import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsperiodicOpsUtil_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/periodicOpsUtil.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/periodicOps'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('form','g',26,['name':("rebuildLoanRecoveryFrm"),'id':("rebuildLoanRecoveryFrm"),'url':([action:'rebuildLoanRecovery',controller:'periodicOps']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('link','g',43,['action':("rebuildGl"),'class':("btn btn-primary")],3)
printHtmlPart(11)
createClosureForHtmlPart(8, 3)
invokeTag('form','g',48,['name':("rebuildLoanInstFrm"),'id':("rebuildLoanInstFrm"),'url':([action:'rebuildLoanInst',controller:'periodicOps']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(12)
createClosureForHtmlPart(8, 3)
invokeTag('form','g',67,['name':("clearCheckDeposits"),'id':("clearCheckDeposits"),'url':([action:'clearCheckDeposits',controller:'periodicOps']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',82,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',85,['class':("index"),'action':("index")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',85,[:],1)
printHtmlPart(18)
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
