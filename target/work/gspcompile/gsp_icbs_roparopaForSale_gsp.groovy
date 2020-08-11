import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaForSale_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaForSale.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(ropaInstanceList)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
loop:{
int i = 0
for( ropaCollateralDetailsInstance in (ropaList) ) {
printHtmlPart(10)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(11)
expressionOut.print(ropaCollateralDetailsInstance?.collateral.id)
printHtmlPart(12)
invokeTag('hiddenField','g',36,['id':("reymartID"),'name':("reymartID"),'value':(ropaCollateralDetailsInstance?.collateral.id)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',37,['format':("MM/dd/yyyy"),'date':(ropaCollateralDetailsInstance?.refDate)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',38,['format':("###,###,##0.00"),'number':(ropaCollateralDetailsInstance?.collateral?.appraisedValue)],-1)
printHtmlPart(14)
expressionOut.print(ropaCollateralDetailsInstance?.collateral?.description)
printHtmlPart(14)
expressionOut.print(ropaCollateralDetailsInstance?.collateral?.collateralType?.description)
printHtmlPart(14)
expressionOut.print(ropaCollateralDetailsInstance?.status?.description)
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',42,['class':("btn btn-secondary"),'id':(ropaCollateralDetailsInstance?.id),'params':(['ropaId': ropapapapaInstance?.id]),'action':("collateralShow")],4)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',49,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',53,['controller':("home"),'action':("landing")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',54,['action':("index")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',55,['action':("printRopaSchedule")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',57,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(26)
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
