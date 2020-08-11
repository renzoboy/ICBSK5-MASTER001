import icbs.loans.RopaCollateralDetails
import icbs.loans.ROPA
import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_rem_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/rem/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('formatNumber','g',6,['format':("##,###,###,##0.00"),'number':(collateralInstance?.collateral?.rem?.landArea)],-1)
printHtmlPart(2)
expressionOut.print(collateralInstance?.collateral?.rem?.tctNo)
printHtmlPart(3)
expressionOut.print(collateralInstance?.collateral?.rem?.lotNo)
printHtmlPart(4)
expressionOut.print(collateralInstance?.collateral?.rem?.location)
printHtmlPart(5)
expressionOut.print(collateralInstance?.collateral?.rem?.otherOwners)
printHtmlPart(6)
expressionOut.print(collateralInstance?.collateral?.rem?.registryOfDeeds)
printHtmlPart(7)
invokeTag('formatDate','g',30,['date':(collateralInstance?.collateral?.rem?.dateOfIssuance),'type':("date"),'style':("FULL")],-1)
printHtmlPart(8)
expressionOut.print(collateralInstance?.collateral?.rem?.encumberances)
printHtmlPart(9)
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
