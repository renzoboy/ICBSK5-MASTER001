import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_details_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/details/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(collateralInstance?.owner?.displayName)
printHtmlPart(1)
expressionOut.print(collateralInstance?.collateralType)
printHtmlPart(2)
invokeTag('formatNumber','g',14,['format':("###,###,##0.00"),'number':(collateralInstance?.appraisedValue)],-1)
printHtmlPart(3)
if(true && (collateralInstance?.collateralType?.id == 1)) {
printHtmlPart(4)
expressionOut.print(collateralInstance?.rem?.appraisedValueType?.description)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(collateralInstance?.description)
printHtmlPart(7)
if(true && (collateralInstance?.collateralType?.id == 1)) {
printHtmlPart(8)
invokeTag('render','g',29,['template':("rem/show")],-1)
printHtmlPart(9)
}
else if(true && (collateralInstance?.collateralType?.id == 2)) {
printHtmlPart(8)
invokeTag('render','g',32,['template':("chattel/show")],-1)
printHtmlPart(9)
}
else if(true && (collateralInstance?.collateralType?.id == 3)) {
printHtmlPart(8)
invokeTag('render','g',35,['template':("holdout/show")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(collateralInstance?.status)
printHtmlPart(11)
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
