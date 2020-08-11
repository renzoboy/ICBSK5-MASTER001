import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_collateral_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/collateral/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (loanApplicationInstance?.collaterals)) {
printHtmlPart(1)
for( collateral in (loanApplicationInstance?.collaterals.sort{it.id}) ) {
printHtmlPart(2)
expressionOut.print(collateral?.id)
printHtmlPart(3)
expressionOut.print(collateral?.collateralType?.description)
printHtmlPart(3)
invokeTag('formatNumber','g',24,['format':("###,##0.00"),'number':(collateral?.appraisedValue)],-1)
printHtmlPart(4)
expressionOut.print(collateral?.status?.description)
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',26,['class':("btn btn-secondary"),'controller':("collateralManagement"),'action':("show"),'id':(collateral?.id)],3)
printHtmlPart(7)
expressionOut.print(collateral?.id)
printHtmlPart(8)
}
printHtmlPart(9)
}
else if(true && (session["collaterals"])) {
printHtmlPart(1)
invokeTag('set','g',33,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( collateral in (session["collaterals"]) ) {
printHtmlPart(10)

if (!collateral.isAttached())
						collateral.attach()

printHtmlPart(2)
expressionOut.print(collateral?.id)
printHtmlPart(3)
expressionOut.print(collateral?.collateralType?.description)
printHtmlPart(3)
expressionOut.print(collateral?.appraisedValue)
printHtmlPart(4)
expressionOut.print(collateral?.status?.description)
printHtmlPart(11)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',44,['class':("btn btn-secondary"),'controller':("collateralManagement"),'action':("show"),'id':(collateral?.id)],3)
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(12)
invokeTag('set','g',48,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(13)
}
printHtmlPart(14)
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
