import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_interestRateMaintenance_tempview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/interestRateMaintenance/temp/view.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'interestRateFormAjax'))
printHtmlPart(5)
})
invokeTag('javascript','g',17,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(7)
createClosureForHtmlPart(10, 3)
invokeTag('hasErrors','g',41,['bean':(depositInstance)],3)
printHtmlPart(7)
createClosureForHtmlPart(10, 3)
invokeTag('hasErrors','g',53,['bean':(depositInterestSchemeInstance)],3)
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('hiddenField','g',55,['name':("deposit"),'value':(depositInstance?.id)],-1)
printHtmlPart(12)
invokeTag('render','g',64,['template':("interestRateMaintenance/template/allAccounts")],-1)
printHtmlPart(13)
invokeTag('textField','g',81,['name':("deposit"),'value':(depositInstance?.id),'disabled':("disabled"),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('render','g',87,['template':("/customer/details/customerDetails"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(15)
invokeTag('render','g',90,['template':("/deposit/details/depositInterestRateDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(16)
})
invokeTag('form','g',94,['name':("interestRateMaintenanceForm"),'action':("updateInterestRate")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',133,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
if(true && (depositInstance)) {
printHtmlPart(20)
}
printHtmlPart(11)
if(true && (depositInstance)) {
printHtmlPart(21)
}
printHtmlPart(11)
if(true && (depositInstance)) {
printHtmlPart(22)
}
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',147,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',150,[:],1)
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
