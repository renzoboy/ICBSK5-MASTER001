import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_customer_customerverification_customerType_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/customer/customerverification/_customerType.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: customerInstance, field: 'type', 'has-error'))
printHtmlPart(2)
invokeTag('select','g',14,['id':("type"),'name':("type.id"),'from':(icbs.lov.CustomerType.findAllByStatus(true)),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',19,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',20,['bean':(customerInstance),'field':("type")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',23,['bean':(customerInstance),'field':("type")],1)
printHtmlPart(8)
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
