import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_rollover_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/rollover/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatDate','g',11,['format':("MM/dd/yyyy"),'date':(rolloverId?.startDate)],-1)
printHtmlPart(1)
invokeTag('formatDate','g',15,['format':("MM/dd/yyyy"),'date':(rolloverId?.endDate)],-1)
printHtmlPart(2)
expressionOut.print(rolloverId?.type?.description)
printHtmlPart(3)
invokeTag('formatNumber','g',23,['format':("###,###,##0.00"),'number':(rolloverId?.principalAmt)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',27,['format':("###,###,##0.00"),'number':(rolloverId?.normalInterestAmt)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',31,['format':("###,###,##0.00"),'number':(rolloverId?.preTermInterestAmt)],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',35,['format':("###,###,##0.00"),'number':(rolloverId?.taxAmt1)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',39,['format':("###,###,##0.00"),'number':(rolloverId?.taxAmt2)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',43,['format':("###,###,##0.00"),'number':(rolloverId?.taxAmt3)],-1)
printHtmlPart(9)
expressionOut.print(rolloverId?.status?.description)
printHtmlPart(10)
expressionOut.print(rolloverId?.interestPaymentMode?.description)
printHtmlPart(11)
expressionOut.print(rolloverId?.fundedDeposit?.id)
printHtmlPart(12)
invokeTag('formatNumber','g',59,['format':("###,###,##0.00"),'number':(rolloverId?.postMaturityInterestRate)],-1)
printHtmlPart(13)
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
