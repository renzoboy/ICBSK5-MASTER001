import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_searchcustomerSearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/search/customerSearch.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('render','g',19,['template':("/search/searchTemplate/searchCustomer")],-1)
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('jasperReport','g',22,['action':("createReport"),'controller':("customer"),'format':("PDF"),'jasper':("customers"),'name':("CLL PDF")],3)
printHtmlPart(8)
invokeTag('jasperReport','g',23,['action':("createReport"),'import value':("icbs.Admin.Branch"),'controller':("customer"),'format':("XLS"),'jasper':("customers"),'name':("CLL XLS")],-1)
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',24,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',27,['class':(""),'action':("create"),'resource':("")],3)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',28,['class':(""),'action':("viewCustomerReports"),'resource':("")],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',30,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',31,[:],1)
printHtmlPart(17)
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
