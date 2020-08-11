import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_details_depositInterestRateDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/details/_depositInterestRateDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(2)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(3)
invokeTag('formatDate','g',21,['format':("MM/dd/yyyy"),'value':("{$depositInstance?.dateOpened}")],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',25,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(5)
expressionOut.print(depositInstance?.status?.description)
printHtmlPart(6)
invokeTag('formatNumber','g',33,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: depositInstance, field: 'interestRate', 'has-error'))
printHtmlPart(8)
invokeTag('message','g',37,['code':("deposit.interestRate.label"),'default':("New Interest Rate")],-1)
printHtmlPart(9)
invokeTag('field','g',40,['name':("interestRate"),'id':("interestRate"),'value':(""),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',45,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',46,['bean':(depositInstance),'field':("interestRate")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',49,['bean':(depositInstance),'field':("interestRate")],1)
printHtmlPart(15)
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
