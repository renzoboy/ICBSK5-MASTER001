import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_collateral_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/collateral/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( collateral in (loanApplicationInstance?.collaterals.sort{it.id}) ) {
printHtmlPart(1)
expressionOut.print(collateral?.id)
printHtmlPart(2)
expressionOut.print(collateral?.collateralType?.description)
printHtmlPart(3)
invokeTag('formatNumber','g',19,['format':("###,##0.00"),'number':(collateral?.appraisedValue)],-1)
printHtmlPart(4)
expressionOut.print(collateral?.status?.description)
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',21,['class':("btn btn-secondary"),'controller':("collateralManagement"),'action':("show"),'id':(collateral?.id)],2)
printHtmlPart(6)
}
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
