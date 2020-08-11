import icbs.loans.RopaCollateralDetails
import icbs.loans.ROPA
import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_collateralInformation_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/collateralInformation/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('hiddenField','g',20,['id':("ropaId"),'name':("ropaId"),'value':(ropapapapaInstance?.id)],-1)
printHtmlPart(3)
loop:{
int i = 0
for( ropaCollateralDetailsInstance in (RopaCollateralDetails.findAllByRopa(ropapapapaInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(4)
if(true && (ropaCollateralDetailsInstance?.collateral?.collateralType.id < 3)) {
printHtmlPart(5)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(6)
expressionOut.print(ropaCollateralDetailsInstance?.collateral.id)
printHtmlPart(7)
invokeTag('hiddenField','g',25,['id':("reymartID"),'name':("reymartID"),'value':(ropaCollateralDetailsInstance?.collateral.id)],-1)
printHtmlPart(8)
invokeTag('formatDate','g',26,['format':("MM/dd/yyyy"),'date':(ropaCollateralDetailsInstance?.refDate)],-1)
printHtmlPart(9)
expressionOut.print(ropaCollateralDetailsInstance?.collateral?.description)
printHtmlPart(9)
expressionOut.print(ropaCollateralDetailsInstance?.collateral?.collateralType?.description)
printHtmlPart(9)
expressionOut.print(ropaCollateralDetailsInstance?.status?.description)
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',31,['class':("btn btn-secondary"),'id':(ropaCollateralDetailsInstance?.id),'params':(['ropaId': ropapapapaInstance?.id]),'action':("collateralShow")],4)
printHtmlPart(12)
}
printHtmlPart(3)
i++
}
}
printHtmlPart(13)
expressionOut.print(createLink(controller:'ropa', action:'collateralShow'))
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',52,[:],1)
printHtmlPart(15)
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
