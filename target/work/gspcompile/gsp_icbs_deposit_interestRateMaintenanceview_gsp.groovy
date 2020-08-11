import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_interestRateMaintenanceview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/interestRateMaintenance/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(5)
createClosureForHtmlPart(8, 3)
invokeTag('hasErrors','g',36,['bean':(depositInstance)],3)
printHtmlPart(5)
createClosureForHtmlPart(8, 3)
invokeTag('hasErrors','g',48,['bean':(depositInterestSchemeInstance)],3)
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('hiddenField','g',50,['name':("deposit"),'value':(depositInstance?.id)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',51,['name':("type"),'checked':("checked"),'id':("type"),'value':("1")],-1)
printHtmlPart(10)
invokeTag('render','g',54,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(11)
invokeTag('render','g',57,['template':("/deposit/details/depositInterestRateDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(12)
})
invokeTag('form','g',61,['name':("interestRateMaintenanceForm"),'action':("updateInterestRate")],3)
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
if(true && (depositInstance)) {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(depositInstance?.id)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',131,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',132,[:],1)
printHtmlPart(19)
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
