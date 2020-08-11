import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_ropadDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/_ropadDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(ropadebitInstance?.loanAcctNo)
printHtmlPart(1)
expressionOut.print(ropadebitInstance?.customerDisplayName)
printHtmlPart(2)
expressionOut.print(ropadebitInstance?.branch?.name)
printHtmlPart(3)
invokeTag('formatDate','g',13,['format':("MM/dd/yyyy"),'date':(ropadebitInstance?.ropaDate)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',17,['format':("###,###,##0.00"),'number':(ropadebitInstance?.loanBalance)],-1)
printHtmlPart(5)
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
