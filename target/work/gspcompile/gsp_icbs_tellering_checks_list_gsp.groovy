import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_checks_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/checks/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (txnCheckDepositInstance?.checks)) {
printHtmlPart(2)
for( check in (txnCheckDepositInstance?.checks.sort{it.description}) ) {
printHtmlPart(3)
expressionOut.print(check?.checkType?.description)
printHtmlPart(4)
expressionOut.print(check?.bank?.name)
printHtmlPart(4)
expressionOut.print(check?.acctNo)
printHtmlPart(4)
expressionOut.print(check?.checkDate)
printHtmlPart(4)
expressionOut.print(check?.checkNo)
printHtmlPart(4)
expressionOut.print(check?.checkAmt)
printHtmlPart(5)
expressionOut.print(check?.id)
printHtmlPart(6)
}
printHtmlPart(7)
}
else if(true && (session["checks"])) {
printHtmlPart(2)
invokeTag('set','g',41,['var':("i"),'value':(0)],-1)
printHtmlPart(2)
for( check in (session["checks"]) ) {
printHtmlPart(3)
expressionOut.print(check?.checkType?.description)
printHtmlPart(4)
expressionOut.print(check?.bank?.name)
printHtmlPart(4)
expressionOut.print(check?.acctNo)
printHtmlPart(4)
expressionOut.print(check?.checkDate?.format("MM/dd/yyyy"))
printHtmlPart(4)
expressionOut.print(check?.checkNo)
printHtmlPart(8)
invokeTag('formatNumber','g',49,['format':("###,###,##0.00"),'number':(check?.checkAmt)],-1)
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('set','g',54,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(2)
}
printHtmlPart(7)
}
printHtmlPart(10)
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
