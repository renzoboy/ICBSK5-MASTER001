import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_relation_showRelatedForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/relation/_showRelatedForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
loop:{
int i = 0
for( relation in (customerInstance?.relations) ) {
printHtmlPart(2)
if(true && (relation.status?.id!=3)) {
printHtmlPart(3)
createTagBody(3, {->
expressionOut.print(relation?.customer2?.customerId)
})
invokeTag('link','g',25,['action':("customerInquiry"),'id':(relation?.customer2?.id)],3)
printHtmlPart(4)
expressionOut.print(relation?.customer2?.displayName)
printHtmlPart(5)
invokeTag('set','g',31,['var':("concatenatedAddress"),'value':(relation?.customer2?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(6)
if(true && (concatenatedAddress!=null)) {
printHtmlPart(7)
expressionOut.print(concatenatedAddress.address1 +", " + concatenatedAddress.address2 +", " +concatenatedAddress.address3)
printHtmlPart(6)
}
printHtmlPart(8)
expressionOut.print(relation?.customer2?.type?.description)
printHtmlPart(8)
expressionOut.print(relation?.type?.itemValue)
printHtmlPart(9)
expressionOut.print(relation?.id)
printHtmlPart(10)
expressionOut.print(relation?.id)
printHtmlPart(11)
}
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
invokeTag('paginate','g',53,['total':(domainInstanceCount ?: 0)],-1)
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
