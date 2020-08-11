import icbs.loans.LoanEIRSchedule
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_advancedInterests_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/advancedInterests/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( eirSchedule in (loanInstance?.loanEIRSchedules?.sort{it.transferDate}) ) {
printHtmlPart(1)
expressionOut.print(i + 1)
printHtmlPart(2)
invokeTag('formatDate','g',19,['format':("MM-dd-yyyy"),'date':(eirSchedule?.transferDate)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',20,['number':(eirSchedule?.uidAmount),'format':("###,##0.00")],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',21,['number':(eirSchedule?.serviceChargeAmount),'format':("###,##0.00")],-1)
printHtmlPart(4)
i++
}
}
printHtmlPart(5)
invokeTag('formatNumber','g',34,['number':(totalUID),'format':("###,##0.00")],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',35,['number':(totalUIDServiceCharge),'format':("###,##0.00")],-1)
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
