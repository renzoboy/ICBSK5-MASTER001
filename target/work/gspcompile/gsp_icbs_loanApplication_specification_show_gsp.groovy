import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_specification_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/specification/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatNumber','g',10,['format':("#"),'groupingUsed':("true"),'number':(fieldValue(bean: loanApplicationInstance, field: "id"))],-1)
printHtmlPart(1)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(2)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.customer?.displayName)
})
invokeTag('link','g',18,['controller':("customer"),'action':("customerInquiry"),'id':(loanApplicationInstance?.customer?.id)],1)
printHtmlPart(3)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.product?.name)
})
invokeTag('link','g',46,['controller':("product"),'action':("show"),'id':(loanApplicationInstance?.product?.id)],1)
printHtmlPart(4)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.branch?.name)
})
invokeTag('link','g',50,['controller':("branch"),'action':("show"),'id':(loanApplicationInstance?.branch?.id)],1)
printHtmlPart(5)
expressionOut.print(loanApplicationInstance?.currency?.name)
printHtmlPart(6)
invokeTag('formatNumber','g',58,['format':("###,##0.00"),'number':(loanApplicationInstance?.amount)],-1)
printHtmlPart(7)
invokeTag('fieldValue','g',62,['bean':(loanApplicationInstance),'field':("term")],-1)
printHtmlPart(8)
invokeTag('fieldValue','g',66,['bean':(loanApplicationInstance),'field':("purpose")],-1)
printHtmlPart(9)
expressionOut.print(loanApplicationInstance?.userLoanAcctOfficer?.name1 +' '+loanApplicationInstance?.userLoanAcctOfficer?.name2 +' '+loanApplicationInstance?.userLoanAcctOfficer?.name3)
printHtmlPart(10)
invokeTag('formatDate','g',76,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance.applicationDate)],-1)
printHtmlPart(11)
if(true && (loanApplicationSpecAdd?.id)) {
printHtmlPart(12)
invokeTag('fieldValue','g',91,['bean':(loanApplicationSpecAdd),'field':("interestRate")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',95,['bean':(loanApplicationSpecAdd),'field':("serviceCharge")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',99,['bean':(loanApplicationSpecAdd?.frequency),'field':("description")],-1)
printHtmlPart(15)
if(true && (loanApplicationInstance?.product?.productType?.id == 6)) {
printHtmlPart(16)
invokeTag('fieldValue','g',104,['bean':(loanApplicationSpecAdd?.guaranteeFacility),'field':("description")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',108,['bean':(loanApplicationSpecAdd),'field':("preRelease")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('fieldValue','g',113,['bean':(loanApplicationSpecAdd),'field':("comments")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (comakers)) {
printHtmlPart(22)
for( comaker in (comakers) ) {
printHtmlPart(23)
expressionOut.print(comaker?.customer?.id)
printHtmlPart(24)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(25)
invokeTag('formatDate','g',140,['format':("MM/dd/yyyy"),'date':(comaker?.customer?.birthDate)],-1)
printHtmlPart(24)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',141,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.customer?.id)],3)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1596696691040L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
