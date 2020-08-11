import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercustomerInfobase_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/customerInfobase.gsp" }
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
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',12,['src':("customerHelper.js")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(2)
createTagBody(3, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'Customer', action:'removeCustomerInfoBaseAjax'))
printHtmlPart(7)
})
invokeTag('javascript','g',59,[:],3)
printHtmlPart(8)
invokeTag('render','g',61,['template':("details/customerDetails"),'model':([customerInstance:customerInstance,boxName:'CIF INFO'])],-1)
printHtmlPart(9)
invokeTag('set','g',74,['var':("i"),'value':(0)],-1)
printHtmlPart(10)
for( infobase in (result) ) {
printHtmlPart(11)
if(true && (infobase.status?.id!=3)) {
printHtmlPart(12)
expressionOut.print(infobase?.refDate.format("MM/dd/yyyy"))
printHtmlPart(13)
expressionOut.print(infobase?.infoMessage)
printHtmlPart(14)
expressionOut.print(infobase?.user?.username)
printHtmlPart(15)
expressionOut.print(infobase.id)
printHtmlPart(16)
expressionOut.print(params?.id)
printHtmlPart(17)
}
printHtmlPart(11)
invokeTag('set','g',96,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(10)
}
printHtmlPart(18)
invokeTag('paginate','g',100,['total':(domainInstanceCount ?: 0)],-1)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',106,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
if(true && (customerInstance)) {
printHtmlPart(21)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(22)
invokeTag('textArea','g',124,['class':("form-control"),'name':("infoMessage"),'id':("infoMessage"),'value':(""),'rows':("6"),'cols':("40")],-1)
printHtmlPart(23)
createTagBody(4, {->
printHtmlPart(24)
expressionOut.print(params.id)
printHtmlPart(25)
expressionOut.print(createLink(controller:'customer', action: 'createCustomerInfoBaseAjax'))
printHtmlPart(26)
expressionOut.print(params.id)
printHtmlPart(27)
})
invokeTag('javascript','g',169,[:],4)
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',178,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',180,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',181,[:],1)
printHtmlPart(33)
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
