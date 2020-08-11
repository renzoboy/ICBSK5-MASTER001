import icbs.cif.CustomerInfobase
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_loanApplication_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/loanApplication/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(2)
expressionOut.print(loanApplicationInstance?.product?.id)
printHtmlPart(3)
expressionOut.print(loanApplicationInstance?.amount)
printHtmlPart(4)
expressionOut.print(loanApplicationInstance?.term)
printHtmlPart(5)
invokeTag('formatDate','g',8,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(6)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(8)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(9)
expressionOut.print(loanApplicationInstance?.product?.name)
printHtmlPart(10)
invokeTag('formatNumber','g',26,['format':("###,###,##0.00"),'number':(loanApplicationInstance.amount)],-1)
printHtmlPart(11)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(12)
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
