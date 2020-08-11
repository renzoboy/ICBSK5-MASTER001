import icbs.gl.TxnGlLink
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnGlLinkshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnGlLink/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'txnGlLink.label', default: 'TxnGlLink'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (txnGlLinkInstance?.status)) {
printHtmlPart(10)
invokeTag('message','g',30,['code':("txnGlLink.status.label"),'default':("Status")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',32,['bean':(txnGlLinkInstance),'field':("status")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (txnGlLinkInstance?.description)) {
printHtmlPart(14)
invokeTag('message','g',39,['code':("txnGlLink.description.label"),'default':("Description")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',41,['bean':(txnGlLinkInstance),'field':("description")],-1)
printHtmlPart(12)
}
printHtmlPart(16)
if(true && (txnGlLinkInstance?.links)) {
printHtmlPart(17)
for( l in (txnGlLinkInstance.links) ) {
printHtmlPart(18)
createTagBody(5, {->
expressionOut.print(l?.description.encodeAsHTML())
})
invokeTag('link','g',53,['controller':("cfgGlLinkEntry"),'action':("show"),'id':(l.id)],5)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',62,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',64,['class':("list"),'action':("index")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',64,['class':("create"),'action':("create")],3)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',69,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',69,['class':("edit"),'action':("edit"),'resource':(txnGlLinkInstance)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(28)
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
