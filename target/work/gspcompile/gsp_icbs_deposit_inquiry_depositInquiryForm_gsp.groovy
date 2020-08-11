import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inquiry_depositInquiryForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inquiry/_depositInquiryForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(2)
invokeTag('render','g',17,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(3)
expressionOut.print(depositInstance?.status?.description)
printHtmlPart(4)
expressionOut.print(depositInstance?.branch.name)
printHtmlPart(5)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(6)
expressionOut.print(depositInstance?.product.name)
printHtmlPart(7)
invokeTag('formatNumber','g',48,['format':("#,##0.00"),'number':(depositInstance?.interestRate)],-1)
printHtmlPart(8)
expressionOut.print(depositInstance?.glLink?.description)
printHtmlPart(9)
expressionOut.print(depositInstance?.product?.currency?.name)
printHtmlPart(10)
expressionOut.print(depositInstance?.userDepositAcctOfficer?.name1)
printHtmlPart(11)
expressionOut.print(depositInstance?.userDepositAcctOfficer?.name2)
printHtmlPart(11)
expressionOut.print(depositInstance?.userDepositAcctOfficer?.name3)
printHtmlPart(12)
if(true && (depositInstance?.status?.id==7 && depositInstance?.ledgerBalAmt==0)) {
printHtmlPart(13)
invokeTag('formatNumber','g',80,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(14)
}
else {
printHtmlPart(13)
invokeTag('formatNumber','g',86,['format':("###,###,##0.00"),'number':(depositInstance?.ledgerBalAmt)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',90,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(16)
if(true && (depositInstance?.type?.id == 1)) {
printHtmlPart(17)
invokeTag('formatNumber','g',95,['format':("###,###,##0.00"),'number':(depositInstance?.passbookBalAmt)],-1)
printHtmlPart(14)
}
printHtmlPart(18)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(depositInstance?.holdBalAmt)],-1)
printHtmlPart(14)
if(true && (depositInstance?.type?.id == 3 && depositInstance?.currentRollover?.status?.id == 1)) {
printHtmlPart(19)
if(true && (depositInstance?.status?.id == 7)) {
printHtmlPart(20)
invokeTag('formatNumber','g',106,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(21)
}
else {
printHtmlPart(22)
invokeTag('formatNumber','g',112,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.normalInterestAmt)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',116,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt1)],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',120,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',124,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt2)],-1)
printHtmlPart(26)
}
printHtmlPart(27)
}
else {
printHtmlPart(22)
invokeTag('formatNumber','g',131,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',135,['format':("###,###,##0.00"),'number':(depositInstance?.lmAveBalAmt)],-1)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(32)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(33)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(34)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(35)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(36)
if(true && (signatory.status.id!=3)) {
printHtmlPart(37)
invokeTag('render','g',182,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(36)
}
printHtmlPart(19)
i++
}
}
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (depositInstance?.type?.id == 3)) {
printHtmlPart(40)
invokeTag('hiddenField','g',210,['id':("rolloverInstanceiidididid"),'name':("rolloverInstanceiidididid"),'value':(depositInstance?.id)],-1)
printHtmlPart(41)
loop:{
int i = 0
for( rolloverInstanceId in (rolloverInstance) ) {
printHtmlPart(42)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(43)
invokeTag('formatDate','g',213,['format':("MM/dd/yyyy"),'date':(rolloverInstanceId?.startDate)],-1)
printHtmlPart(44)
invokeTag('formatDate','g',214,['format':("MM/dd/yyyy"),'date':(rolloverInstanceId?.endDate)],-1)
printHtmlPart(44)
expressionOut.print(rolloverInstanceId?.status?.description)
printHtmlPart(45)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',217,['class':("btn btn-secondary"),'id':(rolloverInstanceId?.id),'action':("showRollover")],3)
printHtmlPart(47)
i++
}
}
printHtmlPart(48)
}
printHtmlPart(49)
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
