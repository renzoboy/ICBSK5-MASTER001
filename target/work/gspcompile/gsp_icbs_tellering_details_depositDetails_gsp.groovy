import icbs.deposit.IssuePassbook
import icbs.cif.CustomerInfobase
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_depositDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_depositDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(3)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(4)
expressionOut.print(depositInstance?.customer?.dosriCode?.description)
printHtmlPart(5)
if(true && (depositInstance?.typeId == 3)) {
printHtmlPart(6)
invokeTag('formatDate','g',46,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(7)
}
else {
printHtmlPart(8)
invokeTag('formatDate','g',50,['format':("MM/dd/yyyy"),'date':(depositInstance?.dateOpened)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(depositInstance?.status)
printHtmlPart(11)
if(true && (IssuePassbook?.findAllByDepositAndCanceledAtIsNull(depositInstance)?.size()!=0)) {
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(depositInstance?.branch?.name)
printHtmlPart(15)
if(true && (depositInstance?.typeId == 3)) {
printHtmlPart(16)
invokeTag('formatNumber','g',78,['format':("###,###,##0.00"),'number':(depositInstance?.availableBalAmt)],-1)
printHtmlPart(17)
expressionOut.print(depositInstance?.interestRate)
printHtmlPart(18)
invokeTag('formatDate','g',86,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.startDate)],-1)
printHtmlPart(19)
if(true && (depositInstance?.depositInterestScheme?.fdMonthlyTransfer==true)) {
printHtmlPart(20)
invokeTag('formatDate','g',91,['format':("MM/dd/yyyy"),'date':(depositInstance?.maturityDate)],-1)
printHtmlPart(7)
}
else {
printHtmlPart(20)
invokeTag('formatDate','g',94,['format':("MM/dd/yyyy"),'date':(depositInstance?.currentRollover?.endDate)],-1)
printHtmlPart(7)
}
printHtmlPart(21)
invokeTag('formatNumber','g',99,['format':("##,###"),'number':(depositInstance?.maturityDate - depositInstance?.currentRollover?.startDate)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',103,['format':("###,###,##0.00"),'number':(depositInstance?.acrintAmt)],-1)
printHtmlPart(11)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(23)
invokeTag('formatNumber','g',108,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(11)
}
else {
printHtmlPart(24)
invokeTag('formatNumber','g',114,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.preTermInterestAmt)],-1)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (depositInstance?.type?.id==3 && depositInstance?.currentRollover?.type == 1)) {
printHtmlPart(27)
invokeTag('formatNumber','g',120,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt2)],-1)
printHtmlPart(28)
}
printHtmlPart(26)
if(true && (depositInstance?.type?.id==3 && depositInstance?.currentRollover?.type != 1)) {
printHtmlPart(27)
invokeTag('formatNumber','g',126,['format':("###,###,##0.00"),'number':(depositInstance?.currentRollover?.taxAmt1)],-1)
printHtmlPart(28)
}
else {
printHtmlPart(29)
invokeTag('formatNumber','g',132,['format':("###,###,##0.00"),'number':(depositInstance?.taxWithheld)],-1)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (CustomerInfobase.findAllByCustomerAndStatus(depositInstance?.customer,ConfigItemStatus.get(2)))) {
printHtmlPart(33)
loop:{
int i = 0
for( infobase in (CustomerInfobase.findAllByCustomerAndStatus(depositInstance?.customer,ConfigItemStatus.get(2))) ) {
printHtmlPart(34)
if(true && (infobase.status.id==2)) {
printHtmlPart(35)
expressionOut.print(fieldValue(bean: infobase, field: "infoMessage"))
printHtmlPart(36)
}
printHtmlPart(26)
i++
}
}
printHtmlPart(37)
}
printHtmlPart(38)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(39)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('hiddenField','g',161,['id':("deposit"),'name':("deposit.id"),'value':(depositInstance?.id)],-1)
printHtmlPart(42)
expressionOut.print(rollenddate)
printHtmlPart(43)
expressionOut.print(branchrundate)
printHtmlPart(44)
expressionOut.print(dateclosing)
printHtmlPart(45)
expressionOut.print(depositInstance?.netRolloverInterestAmt)
printHtmlPart(46)
expressionOut.print(depositInstance?.currentRollover?.typeId)
printHtmlPart(47)
expressionOut.print(depositInstance?.currentRollover?.interestPaymentModeId)
printHtmlPart(48)
if(true && (IssuePassbook?.findAllByDepositAndCanceledAtIsNull(depositInstance)?.size()!=0)) {
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (depositInstance?.currentRollover?.startDate == depositInstance?.branch?.runDate && depositInstance?.status?.id != 7)) {
printHtmlPart(51)
expressionOut.print(depositInstance?.availableBalAmt)
printHtmlPart(52)
expressionOut.print(depositInstance?.acrintAmt)
printHtmlPart(53)
expressionOut.print(depositInstance?.currentRollover?.taxAmt1)
printHtmlPart(54)
}
else if(true && (dateclosing == branchrundate)) {
printHtmlPart(55)
expressionOut.print(depositInstance?.availableBalAmt)
printHtmlPart(52)
expressionOut.print(depositInstance?.currentRollover?.preTermInterestAmt)
printHtmlPart(53)
expressionOut.print(depositInstance?.currentRollover?.taxAmt2)
printHtmlPart(56)
}
else if(true && (depositInstance?.currentRollover?.typeId == 2 && depositInstance?.currentRollover?.interestPaymentModeId == 1 && depositInstance?.status?.id == 2)) {
printHtmlPart(57)
expressionOut.print(depositInstance?.availableBalAmt)
printHtmlPart(58)
expressionOut.print(depositInstance?.acrintAmt)
printHtmlPart(59)
expressionOut.print(depositInstance?.currentRollover?.taxAmt1)
printHtmlPart(60)
}
else if(true && (depositInstance?.currentRollover?.typeId == 1 && depositInstance?.currentRollover?.interestPaymentModeId == 1 && depositInstance?.status?.id == 2)) {
printHtmlPart(57)
expressionOut.print(depositInstance?.availableBalAmt)
printHtmlPart(58)
expressionOut.print(depositInstance?.acrintAmt)
printHtmlPart(59)
expressionOut.print(depositInstance?.currentRollover?.taxAmt1)
printHtmlPart(60)
}
else {
printHtmlPart(61)
expressionOut.print(depositInstance?.availableBalAmt)
printHtmlPart(62)
expressionOut.print(depositInstance?.id)
printHtmlPart(63)
}
printHtmlPart(64)
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
