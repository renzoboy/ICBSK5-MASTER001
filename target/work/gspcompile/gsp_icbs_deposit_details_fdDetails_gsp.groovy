import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_details_fdDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/details/_fdDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("depositFromSearch"),'name':("depositFromSearch"),'value':(depositInstance?.id)],-1)
printHtmlPart(2)
expressionOut.print(boxName?boxName:"Fixed Deposit Details")
printHtmlPart(3)
invokeTag('formatNumber','g',15,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(4)
invokeTag('formatDate','g',18,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.endDate)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',22,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.normalInterestAmt)],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',26,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt * depositInstance?.depositTaxChargeScheme?.taxRate.div(100))],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',30,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',34,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt2)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',38,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.normalInterestAmt - (depositInstance?.acrintAmt * depositInstance?.depositTaxChargeScheme?.taxRate.div(100)))],-1)
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
