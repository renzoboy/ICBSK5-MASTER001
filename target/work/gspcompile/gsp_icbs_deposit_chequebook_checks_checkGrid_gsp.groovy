import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_chequebook_checks_checkGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/chequebook/checks/_checkGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
loop:{
int i = 0
for( cheque in (chequebookInstance.cheques) ) {
printHtmlPart(2)
invokeTag('formatNumber','g',21,['format':("############"),'number':(cheque?.chequeNo)],-1)
printHtmlPart(3)
invokeTag('formatDate','g',22,['format':("MM/dd/yyyy"),'date':(cheque?.chequeDate)],-1)
printHtmlPart(3)
expressionOut.print(cheque?.payeeName)
printHtmlPart(3)
invokeTag('formatNumber','g',24,['format':("############"),'number':(cheque?.payeeAcctNo)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',25,['format':("###,###,##0.00"),'number':(cheque?.chequeAmt)],-1)
printHtmlPart(3)
expressionOut.print(cheque?.clrAcctNo)
printHtmlPart(4)
i++
}
}
printHtmlPart(5)
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
