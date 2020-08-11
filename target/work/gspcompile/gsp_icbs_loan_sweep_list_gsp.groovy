import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_sweep_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/sweep/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (session["sweepAccounts"])) {
printHtmlPart(1)
invokeTag('set','g',22,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( sweepAccounts in (session["sweepAccounts"]) ) {
printHtmlPart(2)
expressionOut.print(sweepAccounts?.depositAccount?.acctNo)
printHtmlPart(3)
expressionOut.print(sweepAccounts?.depositAccount?.acctName)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.type?.description)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.rule?.description)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.remarks)
printHtmlPart(5)
expressionOut.print(sweepAccounts?.ordinalNum)
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(8)
invokeTag('set','g',35,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('hiddenField','g',69,['name':("sweepAccountId"),'value':("")],-1)
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
