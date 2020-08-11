import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (atmTerminalInstance?.terminalCode)) {
printHtmlPart(8)
invokeTag('message','g',18,['code':("atmTerminalInstance.terminalCode.label"),'default':("ATM Terminal Code")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',19,['bean':(atmTerminalInstance),'field':("terminalCode")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (atmTerminalInstance?.remarks)) {
printHtmlPart(8)
invokeTag('message','g',24,['code':("atmTerminalInstance.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',25,['bean':(atmTerminalInstance),'field':("remarks")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (atmTerminalInstance?.branch)) {
printHtmlPart(8)
invokeTag('message','g',30,['code':("atmTerminalInstance.branch.label"),'default':("Assigned Branch")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',31,['bean':(atmTerminalInstance),'field':("branch.name")],-1)
printHtmlPart(10)
}
printHtmlPart(12)
if(true && (atmTerminalInstance?.terminalStatus)) {
printHtmlPart(8)
invokeTag('message','g',36,['code':("atmTerminalInstance.terminalStatus.label"),'default':("Terminal Status")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',37,['bean':(atmTerminalInstance),'field':("terminalStatus.description")],-1)
printHtmlPart(10)
}
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',42,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',46,['action':("edit"),'controller':("ATMInterface"),'id':(atmTerminalInstance.id)],3)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',47,['action':("detailView"),'id':(atmTerminalInstance.id)],3)
printHtmlPart(17)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',48,['action':("atmTerminalView")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',50,['tag':("main-actions")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',52,[:],1)
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
