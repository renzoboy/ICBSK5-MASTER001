import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_pdc_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/pdc/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( pdc in (collateralInstance?.pdcs.sort{it.accountNo}) ) {
printHtmlPart(1)
expressionOut.print(pdc?.accountNo)
printHtmlPart(2)
expressionOut.print(pdc?.checkNo)
printHtmlPart(2)
invokeTag('formatNumber','g',21,['format':("###,###,##0.00"),'number':(pdc?.amount)],-1)
printHtmlPart(3)
expressionOut.print(pdc?.bank)
printHtmlPart(3)
invokeTag('formatBoolean','g',23,['boolean':(pdc?.onUs)],-1)
printHtmlPart(3)
invokeTag('formatDate','g',24,['format':("MM/dd/yyyy"),'date':(pdc?.pdcDate)],-1)
printHtmlPart(4)
}
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
