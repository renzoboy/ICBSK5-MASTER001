import icbs.loans.RopaCollateralDetails
import icbs.loans.ROPA
import icbs.loans.Collateral
import icbs.lov.AppraisedValueType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_details_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/details/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(collateralInstance?.collateral?.owner?.displayName)
printHtmlPart(2)
expressionOut.print(collateralInstance?.formerTitle)
printHtmlPart(3)
invokeTag('formatNumber','g',18,['format':("###,###,##0.00"),'number':(collateralInstance?.landAppraisal)],-1)
printHtmlPart(4)
expressionOut.print(collateralInstance?.landArea)
printHtmlPart(5)
expressionOut.print(collateralInstance?.location)
printHtmlPart(6)
expressionOut.print(collateralInstance?.loan.accountNo)
printHtmlPart(7)
invokeTag('formatDate','g',34,['format':("MM/dd/yyyy"),'date':(collateralInstance?.refDate)],-1)
printHtmlPart(8)
expressionOut.print(collateralInstance?.status)
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
