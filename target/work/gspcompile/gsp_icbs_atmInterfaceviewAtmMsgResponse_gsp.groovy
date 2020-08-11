import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceviewAtmMsgResponse_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/viewAtmMsgResponse.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
for( branchInstance in (AtmMsgResponse) ) {
printHtmlPart(8)
invokeTag('message','g',26,['code':("atmTerminalInstance.branch.label"),'default':("id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "id"))
printHtmlPart(10)
invokeTag('message','g',30,['code':("atmTerminalInstance.branch.label"),'default':("Date Sent")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "dateSent"))
printHtmlPart(11)
invokeTag('message','g',34,['code':("atmTerminalInstance.branch.label"),'default':("Destination Ip")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "destinationIp"))
printHtmlPart(12)
invokeTag('message','g',38,['code':("atmTerminalInstance.branch.label"),'default':("Message Content")],-1)
printHtmlPart(13)
expressionOut.print(fieldValue(bean: branchInstance, field: "msgContent"))
printHtmlPart(14)
invokeTag('message','g',42,['code':("atmTerminalInstance.branch.label"),'default':("Message Length:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "msgLength"))
printHtmlPart(15)
}
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-content")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',60,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',60,['class':("create"),'action':("create")],3)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',62,['action':("atmTerminalView")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',64,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(22)
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
