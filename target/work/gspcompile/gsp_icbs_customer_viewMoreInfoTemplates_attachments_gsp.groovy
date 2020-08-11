import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_attachments_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_attachments.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( attachment in (customerInstance.attachments) ) {
printHtmlPart(1)
if(true && (attachment.status.id==2)) {
printHtmlPart(2)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(3)
expressionOut.print(fieldValue(bean: attachment, field: "type.description"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: attachment, field: "fileName"))
printHtmlPart(5)
if(true && (attachment?.id!=null)) {
printHtmlPart(6)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: attachment?.id))
printHtmlPart(7)
expressionOut.print(createLink(controller:'Attachment', action:'download', id: attachment?.id))
printHtmlPart(8)
}
printHtmlPart(9)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
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
