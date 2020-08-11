import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_rem_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/rem/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatNumber','g',3,['format':("##,###,###,##0.00"),'number':(collateralInstance?.rem?.landArea)],-1)
printHtmlPart(1)
expressionOut.print(collateralInstance?.rem?.tctNo)
printHtmlPart(2)
expressionOut.print(collateralInstance?.rem?.lotNo)
printHtmlPart(3)
expressionOut.print(collateralInstance?.rem?.location)
printHtmlPart(4)
expressionOut.print(collateralInstance?.rem?.otherOwners)
printHtmlPart(5)
expressionOut.print(collateralInstance?.rem?.registryOfDeeds)
printHtmlPart(6)
invokeTag('formatDate','g',27,['date':(collateralInstance?.rem?.dateOfIssuance),'type':("date"),'style':("FULL")],-1)
printHtmlPart(7)
expressionOut.print(collateralInstance?.rem?.encumberances)
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
