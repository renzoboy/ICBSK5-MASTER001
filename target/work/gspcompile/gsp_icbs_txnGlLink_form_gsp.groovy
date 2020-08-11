import icbs.gl.TxnGlLink
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnGlLink_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnGlLink/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: txnGlLinkInstance, field: 'status', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("txnGlLink.status.label"),'default':("Status")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("status"),'required':(""),'value':(txnGlLinkInstance?.status),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',16,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',17,['bean':(txnGlLinkInstance),'field':("status")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',20,['bean':(txnGlLinkInstance),'field':("status")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnGlLinkInstance, field: 'description', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',27,['code':("txnGlLink.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',30,['name':("description"),'required':(""),'value':(txnGlLinkInstance?.description),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',37,['bean':(txnGlLinkInstance),'field':("description")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',40,['bean':(txnGlLinkInstance),'field':("description")],1)
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
