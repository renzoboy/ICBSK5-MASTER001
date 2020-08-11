import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_sweep_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/sweep/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( sweepAccounts in (loanInstance?.sweepAccounts) ) {
printHtmlPart(1)
expressionOut.print(sweepAccounts?.depositAccount?.acctNo)
printHtmlPart(2)
expressionOut.print(sweepAccounts?.depositAccount?.acctName)
printHtmlPart(3)
expressionOut.print(sweepAccounts?.type?.description)
printHtmlPart(3)
expressionOut.print(sweepAccounts?.rule?.description)
printHtmlPart(3)
expressionOut.print(sweepAccounts?.remarks)
printHtmlPart(4)
expressionOut.print(sweepAccounts?.ordinalNum)
printHtmlPart(5)
}
printHtmlPart(6)
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
