import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_reports_listingview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/reports/listing/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',17,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',18,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',18,[:],2)
printHtmlPart(2)
createClosureForHtmlPart(2, 2)
invokeTag('javascript','g',20,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',21,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('textField','g',28,['name':("acctNo"),'value':(depositInstance?.acctNo),'disabled':("disabled"),'class':("form-control")],-1)
printHtmlPart(6)
invokeTag('render','g',34,['template':("/customer/details/customerDetails"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(7)
invokeTag('render','g',38,['template':("/deposit/details/depositDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(8)
invokeTag('render','g',44,['template':("passbook/viewGrid")],-1)
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',85,['tag':("main-content")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
if(true && (depositInstance)) {
printHtmlPart(12)
}
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',93,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');")],3)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',95,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',96,[:],1)
printHtmlPart(16)
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
