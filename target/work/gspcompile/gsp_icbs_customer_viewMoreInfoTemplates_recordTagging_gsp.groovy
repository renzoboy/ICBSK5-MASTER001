import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_recordTagging_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_recordTagging.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(customerInstance?.pepDescription)
printHtmlPart(1)
expressionOut.print(customerInstance?.amla)
printHtmlPart(2)
expressionOut.print(customerInstance?.sourceOfIncome)
printHtmlPart(3)
expressionOut.print(customerInstance?.customerCode3?.description)
printHtmlPart(4)
expressionOut.print(customerInstance?.customerCode2?.description)
printHtmlPart(5)
expressionOut.print(customerInstance?.customerCode1?.description)
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
