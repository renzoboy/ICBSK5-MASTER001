import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_chattel_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/chattel/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(collateralInstance?.chattel?.identificationNo)
printHtmlPart(1)
expressionOut.print(collateralInstance?.chattel?.acquisitionCost)
printHtmlPart(2)
invokeTag('formatDate','g',12,['date':(collateralInstance?.chattel?.acquisitionDate),'type':("date"),'style':("FULL")],-1)
printHtmlPart(3)
expressionOut.print(collateralInstance?.chattel?.insuranceType)
printHtmlPart(4)
expressionOut.print(collateralInstance?.chattel?.orNo)
printHtmlPart(5)
invokeTag('formatDate','g',24,['date':(collateralInstance?.chattel?.orDate),'type':("date"),'style':("FULL")],-1)
printHtmlPart(6)
expressionOut.print(collateralInstance?.chattel?.crNo)
printHtmlPart(7)
invokeTag('formatDate','g',32,['date':(collateralInstance?.chattel?.crDate),'type':("date"),'style':("FULL")],-1)
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
