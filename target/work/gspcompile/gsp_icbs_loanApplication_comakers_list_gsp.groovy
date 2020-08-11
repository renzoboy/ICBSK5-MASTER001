import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_comakers_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/comakers/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (comakers)) {
printHtmlPart(1)
for( comaker in (comakers.sort{it.customer.id}) ) {
printHtmlPart(2)
expressionOut.print(comaker?.customer?.id)
printHtmlPart(3)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(4)
invokeTag('formatDate','g',24,['format':("MM/dd/yyyy"),'date':(comaker?.customer?.birthDate)],-1)
printHtmlPart(3)
createClosureForHtmlPart(5, 3)
invokeTag('link','g',25,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.customer?.id)],3)
printHtmlPart(6)
expressionOut.print(comaker?.id)
printHtmlPart(7)
}
printHtmlPart(8)
}
else if(true && (session["comakers"])) {
printHtmlPart(1)
invokeTag('set','g',28,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( comaker in (session["comakers"]) ) {
printHtmlPart(2)
expressionOut.print(comaker?.id)
printHtmlPart(3)
expressionOut.print(comaker?.displayName)
printHtmlPart(4)
invokeTag('formatDate','g',34,['format':("MM/dd/yyyy"),'date':(comaker?.birthDate)],-1)
printHtmlPart(3)
createClosureForHtmlPart(5, 3)
invokeTag('link','g',38,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.id)],3)
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('set','g',39,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(10)
}
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
