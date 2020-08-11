import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_contactInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_contactInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( contact in (customerInstance.contacts) ) {
printHtmlPart(1)
if(true && (contact?.status.id == 2)) {
printHtmlPart(2)
expressionOut.print(fieldValue(bean: contact, field: "type.itemValue"))
printHtmlPart(3)
expressionOut.print(fieldValue(bean: contact, field: "contactValue"))
printHtmlPart(3)
expressionOut.print(fieldValue(bean: contact, field: "isPrimaryEmail"))
printHtmlPart(3)
expressionOut.print(fieldValue(bean: contact, field: "isPrimaryPhone"))
printHtmlPart(4)
}
printHtmlPart(5)
i++
}
}
printHtmlPart(6)
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
