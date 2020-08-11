import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_reportsview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/reports/view.gsp" }
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
invokeTag('javascript','asset',11,['src':("customerHelper.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(6)
})
invokeTag('javascript','g',22,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',46,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',47,['bean':(fundTransferInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',51,['bean':(fundTransferInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('hiddenField','g',55,['name':("type"),'value':("individual")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',56,['name':("_format"),'value':("PDF")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',57,['name':("_name"),'value':("Individual CIF REPORT")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',58,['name':("_file"),'value':("customers")],-1)
printHtmlPart(20)
invokeTag('render','g',61,['template':("/customer/details/customerDetails"),'model':([customerInstance:customerInstance,boxName:'Customer Information'])],-1)
printHtmlPart(21)
})
invokeTag('form','g',66,['action':("createReport")],3)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',71,['action':("customerSearch"),'onclick':("return confirm('Are you sure you want to return to Customer Search?');")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(25)
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
