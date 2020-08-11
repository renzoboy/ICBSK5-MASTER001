import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_detailForm_agfpShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/detailForm/_agfpShow.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(loanGuaranteeInstance?.agfpCommodity)
printHtmlPart(2)
invokeTag('formatNumber','g',17,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.agfpHectaresOrHeads)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',21,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.agfpGuaranteeRate)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',25,['format':("###,###,##0.00"),'number':(loanGuaranteeInstance?.agfpGuaranteeFee)],-1)
printHtmlPart(5)
expressionOut.print(loanGuaranteeInstance?.agfpReferred)
printHtmlPart(6)
expressionOut.print(loanGuaranteeInstance?.agfpRemarks)
printHtmlPart(7)
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
