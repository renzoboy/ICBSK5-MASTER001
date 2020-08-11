import icbs.cif.CustomerInfobase
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanApplication_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanApplication/_show.gsp" }
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
if(true && (loanApplicationInstance?.product?.productType?.id == 7)) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.id)
})
invokeTag('link','g',19,['controller':("loanApplication"),'action':("show"),'id':(loanApplicationInstance?.id)],1)
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.customer?.displayName)
})
invokeTag('link','g',23,['controller':("customer"),'action':("customerInquiry"),'id':(loanApplicationInstance?.customer?.id)],1)
printHtmlPart(12)
invokeTag('formatDate','g',27,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.customer?.birthDate)],-1)
printHtmlPart(13)
invokeTag('set','g',29,['var':("primaryAddress"),'value':(loanApplicationInstance?.customer?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(0)
if(true && (primaryAddress)) {
printHtmlPart(14)
invokeTag('set','g',31,['var':("primaryAddress"),'value':(primaryAddress?.address1 + ', ' + primaryAddress?.address2 +', ' +primaryAddress?.address3)],-1)
printHtmlPart(0)
}
else {
printHtmlPart(14)
invokeTag('set','g',34,['var':("primaryAddress"),'value':("")],-1)
printHtmlPart(0)
}
printHtmlPart(15)
expressionOut.print(primaryAddress)
printHtmlPart(13)
if(true && (CustomerInfobase.findAllByCustomerAndStatus(loanApplicationInstance?.customer,ConfigItemStatus.get(2)))) {
printHtmlPart(16)
loop:{
int i = 0
for( infobase in (CustomerInfobase.findAllByCustomerAndStatus(loanApplicationInstance?.customer,ConfigItemStatus.get(2))) ) {
printHtmlPart(17)
if(true && (infobase.status.id==2)) {
printHtmlPart(18)
expressionOut.print(fieldValue(bean: infobase, field: "infoMessage"))
printHtmlPart(19)
}
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
}
printHtmlPart(22)
if(true && ((loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(23)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (loanApplicationInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.product?.name)
})
invokeTag('link','g',68,['controller':("product"),'action':("show"),'id':(loanApplicationInstance?.product?.id)],1)
printHtmlPart(27)
createTagBody(1, {->
expressionOut.print(loanApplicationInstance?.branch?.name)
})
invokeTag('link','g',72,['controller':("branch"),'action':("show"),'id':(loanApplicationInstance?.branch?.id)],1)
printHtmlPart(28)
expressionOut.print(loanApplicationInstance?.currency?.name)
printHtmlPart(29)
if(true && ((loanApplicationInstance))) {
printHtmlPart(10)
invokeTag('formatNumber','g',81,['format':("###,###,##0.00"),'number':(loanApplicationInstance.amount)],-1)
printHtmlPart(30)
}
else {
printHtmlPart(25)
}
printHtmlPart(31)
invokeTag('fieldValue','g',89,['bean':(loanApplicationInstance),'field':("term")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',93,['bean':(loanApplicationInstance),'field':("purpose")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',97,['bean':(loanApplicationInstance),'field':("accountOfficer")],-1)
printHtmlPart(34)
invokeTag('formatDate','g',101,['format':("MM/dd/yyyy"),'date':(loanApplicationInstance?.applicationDate)],-1)
printHtmlPart(35)
expressionOut.print(loanApplicationInstance?.approvalStatus?.description)
printHtmlPart(36)
invokeTag('hiddenField','g',106,['name':("loanApp-product-type"),'id':("loanApp-product-type"),'value':(loanApplicationInstance?.product?.productType?.id)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',107,['name':("loanApp-status-id"),'id':("loanApp-status-id"),'value':(loanApplicationInstance?.approvalStatus?.id)],-1)
printHtmlPart(38)
if(true && (comakers)) {
printHtmlPart(39)
for( comaker in (comakers) ) {
printHtmlPart(40)
expressionOut.print(comaker?.customer?.id)
printHtmlPart(41)
expressionOut.print(comaker?.customer?.displayName)
printHtmlPart(42)
invokeTag('formatDate','g',130,['format':("MM/dd/yyyy"),'date':(comaker?.customer?.birthDate)],-1)
printHtmlPart(41)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',131,['class':("btn btn-secondary"),'controller':("customer"),'action':("customerInquiry"),'id':(comaker?.customer?.id)],3)
printHtmlPart(44)
}
printHtmlPart(45)
}
printHtmlPart(0)
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
