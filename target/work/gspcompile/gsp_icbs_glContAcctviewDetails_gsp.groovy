import icbs.gl.GlContigentAccount
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctviewDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/viewDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller:'GlContAcct', action:'removeContigentAccountAjax'))
printHtmlPart(8)
})
invokeTag('javascript','g',51,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',52,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('hiddenField','g',63,['id':("idcontigent"),'name':("id"),'value':(glContAcctInstance.id)],-1)
printHtmlPart(13)
expressionOut.print(glContAcctInstance?.id)
printHtmlPart(14)
invokeTag('formatDate','g',70,['format':("MM/dd/yyyy"),'date':(glContAcctInstance?.txnDate)],-1)
printHtmlPart(15)
expressionOut.print(glContAcctInstance?.contigent?.description)
printHtmlPart(16)
invokeTag('formatNumber','g',78,['format':("###,###,##0.00"),'number':(glContAcctInstance?.creditAmt)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',82,['format':("###,###,##0.00"),'number':(glContAcctInstance?.debitAmt)],-1)
printHtmlPart(18)
expressionOut.print(glContAcctInstance?.reference)
printHtmlPart(19)
expressionOut.print(glContAcctInstance?.particulars)
printHtmlPart(20)
expressionOut.print(glContAcctInstance?.status?.description)
printHtmlPart(21)
expressionOut.print(glContAcctInstance?.createdByUser?.username)
printHtmlPart(22)
expressionOut.print(glContAcctInstance?.branch?.name)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',116,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',116,['class':("create"),'action':("create")],3)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',118,['contoller':("GlContAcct"),'action':("updatecontAcct"),'params':(['id': glContAcctInstance.id])],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',121,['action':("createcontigent")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',122,['contoller':("GlContAcct"),'action':("index")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',124,['tag':("main-actions")],2)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',126,[:],1)
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
