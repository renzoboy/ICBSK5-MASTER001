import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_details_depositDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/details/_depositDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("depositFromSearch"),'name':("depositFromSearch"),'value':(depositInstance?.id)],-1)
printHtmlPart(2)
expressionOut.print(boxName?boxName:"Deposit Account Information")
printHtmlPart(3)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(4)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(5)
expressionOut.print(depositInstance?.branch?.name)
printHtmlPart(6)
expressionOut.print(depositInstance?.product?.name)
printHtmlPart(7)
invokeTag('formatDate','g',32,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',36,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(9)
expressionOut.print(depositInstance?.status?.description)
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
