import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_details_depositDetails2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/details/_depositDetails2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(2)
expressionOut.print(depositInstance?.branch?.name)
printHtmlPart(3)
expressionOut.print(depositInstance?.product?.name)
printHtmlPart(4)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(5)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(6)
expressionOut.print(depositInstance?.status?.description)
printHtmlPart(7)
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
