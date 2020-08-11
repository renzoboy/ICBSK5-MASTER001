import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_loanDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_loanDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(loanInstance?.id)
printHtmlPart(2)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(3)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(4)
expressionOut.print(loanInstance?.customer?.dosriCode?.description)
printHtmlPart(5)
invokeTag('formatDate','g',31,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(6)
expressionOut.print(loanInstance?.status)
printHtmlPart(7)
expressionOut.print(loanInstance?.balanceAmount)
printHtmlPart(8)
expressionOut.print(loanInstance?.interestBalanceAmount)
printHtmlPart(9)
expressionOut.print(loanInstance?.penaltyBalanceAmount)
printHtmlPart(10)
expressionOut.print(loanInstance?.serviceChargeBalanceAmount)
printHtmlPart(11)
expressionOut.print(loanInstance?.taxBalanceAmount)
printHtmlPart(12)
invokeTag('formatNumber','g',60,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(loanInstance?.interestBalanceAmount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',68,['format':("###,###,##0.00"),'number':(loanInstance?.penaltyBalanceAmount)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',72,['format':("###,###,##0.00"),'number':(loanInstance?.serviceChargeBalanceAmount)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(loanInstance?.taxBalanceAmount)],-1)
printHtmlPart(17)
expressionOut.print(0)
printHtmlPart(18)
invokeTag('formatNumber','g',85,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(loanInstance?.totalNetProceeds - loanInstance?.totalDisbursementAmount)],-1)
printHtmlPart(20)
if(true && (loanInstance?.customer?.infobases)) {
printHtmlPart(21)
loop:{
int i = 0
for( infobase in (loanInstance?.customer?.infobases) ) {
printHtmlPart(22)
if(true && (infobase.status.id==2)) {
printHtmlPart(23)
expressionOut.print(fieldValue(bean: infobase, field: "infoMessage"))
printHtmlPart(24)
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
}
printHtmlPart(27)
if(true && ((loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(28)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (loanInstance?.id)) {
printHtmlPart(31)
expressionOut.print(loanInstance?.id)
printHtmlPart(32)
expressionOut.print(loanInstance?.totalNetProceeds - loanInstance?.totalDisbursementAmount)
printHtmlPart(33)
expressionOut.print(loanInstance?.totalDisbursementAmount)
printHtmlPart(34)
}
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
