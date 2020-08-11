import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatch_batch_attachment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/_batch_attachment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["postedOnOff"] == 'postedOff')) {
printHtmlPart(1)
}
printHtmlPart(2)
loop:{
int i = 0
for( glBatchAttachment in (session["glattachment"]) ) {
printHtmlPart(3)
expressionOut.print(i + 1)
printHtmlPart(4)
if(true && (session["glattachmentcondtion"] == 'edit')) {
printHtmlPart(5)
if(true && (session["postedOnOff"] == 'postedOff')) {
printHtmlPart(6)
createTagBody(4, {->
expressionOut.print(glBatchAttachment?.filename)
})
invokeTag('link','g',36,['action':("downloadAttachment"),'id':(glBatchAttachment.id),'target':("_blank")],4)
printHtmlPart(7)
}
else {
printHtmlPart(8)
expressionOut.print(glBatchAttachment?.filename)
printHtmlPart(9)
}
printHtmlPart(10)
}
else {
printHtmlPart(11)
expressionOut.print(glBatchAttachment?.filename)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(glBatchAttachment?.reference)
printHtmlPart(14)
expressionOut.print(glBatchAttachment?.particulars)
printHtmlPart(15)
invokeTag('formatDate','g',49,['format':("MM/dd/yyyy"),'date':(glBatchAttachment?.uploadDate)],-1)
printHtmlPart(12)
if(true && (session["postedOnOff"] == 'postedOff')) {
printHtmlPart(16)
expressionOut.print(i)
printHtmlPart(17)
}
else {
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',57,['class':("btn btn-secondary"),'action':("downloadAttachment"),'id':(glBatchAttachment.id),'target':("_blank")],3)
printHtmlPart(20)
}
printHtmlPart(21)
i++
}
}
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
