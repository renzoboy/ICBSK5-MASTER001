import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_financialDetails_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/financialDetails/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',14,['var':("x"),'value':(0)],-1)
printHtmlPart(1)
invokeTag('set','g',15,['var':("y"),'value':(0)],-1)
printHtmlPart(1)
invokeTag('set','g',16,['var':("z"),'value':(0)],-1)
printHtmlPart(2)
for( financialDetail in (loanApplicationInstance?.financialDetails.sort{it.description}) ) {
printHtmlPart(3)
expressionOut.print(financialDetail?.description)
printHtmlPart(4)
invokeTag('formatNumber','g',20,['number':(financialDetail?.value),'format':("###,##0.00")],-1)
printHtmlPart(5)
expressionOut.print(financialDetail?.type?.description)
printHtmlPart(6)
if(true && (financialDetail?.type?.description=='Expense')) {
printHtmlPart(7)
invokeTag('set','g',23,['var':("x"),'value':(x + financialDetail?.value)],-1)
printHtmlPart(8)
}
else if(true && (financialDetail?.type?.description=='Income')) {
printHtmlPart(7)
invokeTag('set','g',26,['var':("y"),'value':(y + financialDetail?.value)],-1)
printHtmlPart(8)
}
else if(true && (financialDetail?.type?.description=='Others')) {
printHtmlPart(7)
invokeTag('set','g',29,['var':("z"),'value':(z + financialDetail?.value)],-1)
printHtmlPart(8)
}
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('formatNumber','g',38,['format':("###,##0.00"),'number':(y)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',42,['format':("###,##0.00"),'number':(x)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',46,['format':("###,##0.00"),'number':(z)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',50,['format':("###,##0.00"),'number':(y-x)],-1)
printHtmlPart(14)
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
