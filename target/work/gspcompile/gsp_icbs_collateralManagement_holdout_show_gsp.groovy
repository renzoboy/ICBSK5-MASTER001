import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_holdout_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/holdout/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(collateralInstance?.holdout?.accountNo)
printHtmlPart(1)
expressionOut.print(collateralInstance?.holdout?.accountType)
printHtmlPart(2)
invokeTag('formatNumber','g',11,['format':("###,###,##0.00"),'number':(collateralInstance?.holdout?.amount)],-1)
printHtmlPart(3)
expressionOut.print(collateralInstance?.holdout?.bank)
printHtmlPart(4)
invokeTag('formatBoolean','g',19,['boolean':(collateralInstance?.holdout?.onUs)],-1)
printHtmlPart(5)
invokeTag('formatDate','g',23,['date':(collateralInstance?.holdout?.holdoutDate),'type':("date"),'style':("FULL")],-1)
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
