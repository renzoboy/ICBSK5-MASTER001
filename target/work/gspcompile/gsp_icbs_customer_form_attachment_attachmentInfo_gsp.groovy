import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_attachment_attachmentInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/attachment/_attachmentInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(2)
invokeTag('render','g',11,['template':("form/attachment/onetomany/attachment"),'model':(['attachment':customerInstance?.attachments[0],'i':0,'type':1 ,'canDelete':'false','isPrimaryPhoto':'true'])],-1)
printHtmlPart(3)
invokeTag('render','g',16,['template':("form/attachment/onetomany/attachment"),'model':(['attachment':customerInstance?.attachments[1],'i':1,'type':2 ,'canDelete':'false','isPrimarySig':'true'])],-1)
printHtmlPart(4)
}
printHtmlPart(5)
loop:{
int i = 0
for( attachment in (customerInstance.attachments) ) {
printHtmlPart(6)
if(true && ((attachment?.type?.code=='030'||attachment?.type?.code=='040'||attachment?.type?.code=='050')&& attachment?.status?.id==2)) {
printHtmlPart(7)
invokeTag('render','g',24,['template':("form/attachment/onetomany/attachment"),'model':(['attachment':attachment,'i':i])],-1)
printHtmlPart(8)
}
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
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
