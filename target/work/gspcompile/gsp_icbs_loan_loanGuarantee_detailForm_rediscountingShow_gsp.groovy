import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_detailForm_rediscountingShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/detailForm/_rediscountingShow.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatDate','g',10,['format':("MM/dd/yyyy"),'date':(loanRediscountingInstance?.dateGranted)],-1)
printHtmlPart(1)
invokeTag('formatDate','g',14,['format':("MM/dd/yyyy"),'date':(loanRediscountingInstance?.maturityDate)],-1)
printHtmlPart(2)
expressionOut.print(loanRediscountingInstance?.pnNo)
printHtmlPart(3)
expressionOut.print(loanRediscountingInstance?.loanRediscountingPartner?.description)
printHtmlPart(4)
expressionOut.print(loanRediscountingInstance?.loanRediscountingStatus?.description)
printHtmlPart(5)
for( collateral in (getLoanAppCollInstance?.collaterals.sort{it.id}) ) {
printHtmlPart(6)
expressionOut.print(collateral?.id)
printHtmlPart(7)
expressionOut.print(collateral?.collateralType?.description)
printHtmlPart(8)
invokeTag('formatNumber','g',47,['format':("###,##0.00"),'number':(collateral?.appraisedValue)],-1)
printHtmlPart(9)
expressionOut.print(collateral?.status?.description)
printHtmlPart(7)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',49,['class':("btn btn-secondary"),'controller':("collateralManagement"),'action':("show"),'id':(collateral?.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
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
