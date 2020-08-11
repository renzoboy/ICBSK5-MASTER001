import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_serviceCharges_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/serviceCharges/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["serviceCharges"])) {
printHtmlPart(1)
invokeTag('set','g',19,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( serviceCharge in (session["serviceCharges"]) ) {
printHtmlPart(2)
invokeTag('set','g',22,['var':("type"),'value':(serviceCharge?.scheme?.type.id)],-1)
printHtmlPart(3)
expressionOut.print(serviceCharge?.scheme?.name)
printHtmlPart(4)
expressionOut.print(serviceCharge?.scheme?.type?.description)
printHtmlPart(5)
if(true && (type == 2)) {
printHtmlPart(6)
expressionOut.print(serviceCharge?.rate)
printHtmlPart(7)
}
else {
printHtmlPart(6)
expressionOut.print(serviceCharge?.amount)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(i)
printHtmlPart(10)
expressionOut.print(i)
printHtmlPart(11)
invokeTag('set','g',35,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('hiddenField','g',68,['name':("serviceChargeId"),'value':("")],-1)
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
