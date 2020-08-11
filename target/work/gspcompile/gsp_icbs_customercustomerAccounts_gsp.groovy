import icbs.gl.AccountsReceivable
import icbs.gl.AccountsPayable
import icbs.loans.LoanApplicationComaker
import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercustomerAccounts_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/customerAccounts.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',16,['src':("customerHelper.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',21,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(8)
invokeTag('set','g',34,['var':("primaryAddress"),'value':((customerInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(9)
if(true && (primaryAddress!=null)) {
printHtmlPart(10)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(14)
loop:{
int i = 0
for( deposit in (customerInstance?.deposits) ) {
printHtmlPart(15)
expressionOut.print(deposit?.product?.name)
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(deposit?.acctNo)
})
invokeTag('link','g',72,['action':("depositInquiry"),'controller':("deposit"),'id':(deposit?.id)],4)
printHtmlPart(17)
invokeTag('formatNumber','g',74,['format':("###,###,##0.00"),'number':(deposit?.ledgerBalAmt)],-1)
printHtmlPart(17)
expressionOut.print(deposit?.status?.description)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
loop:{
int p = 0
for( thesignatories in (icbs.deposit.Signatory.findAllBySignatory(customerInstance)) ) {
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(thesignatories?.deposit?.acctName)
})
invokeTag('link','g',93,['target':("_blank"),'action':("customerInquiry"),'controller':("customer"),'id':(thesignatories?.deposit?.customer?.id)],4)
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(thesignatories?.deposit?.acctNo)
})
invokeTag('link','g',95,['action':("depositInquiry"),'controller':("deposit"),'id':(thesignatories?.deposit?.id)],4)
printHtmlPart(21)
expressionOut.print(thesignatories?.deposit?.status?.description)
printHtmlPart(22)
p++
}
}
printHtmlPart(23)
loop:{
int i = 0
for( loan in (customerInstance?.loans) ) {
printHtmlPart(20)
expressionOut.print(loan?.product?.name)
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(loan?.accountNo)
})
invokeTag('link','g',114,['action':("show"),'controller':("loan"),'id':(loan?.id)],4)
printHtmlPart(21)
invokeTag('formatNumber','g',115,['format':("###,###,##0.00"),'number':(loan?.balanceAmount)],-1)
printHtmlPart(21)
expressionOut.print(loan?.status?.description)
printHtmlPart(22)
i++
}
}
printHtmlPart(24)
loop:{
int i = 0
for( CM in (LoanApplicationComaker.findAllByCustomer(customerInstance)) ) {
printHtmlPart(25)
if(true && (Loan.findByLoanApplication(CM?.loanApplication))) {
printHtmlPart(26)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(27)
expressionOut.print(CM?.loanApplication?.customer?.displayName)
printHtmlPart(28)
expressionOut.print(Loan.findByLoanApplication(CM?.loanApplication)?.accountNo)
printHtmlPart(28)
invokeTag('formatNumber','g',140,['format':("###,###,##0.00"),'number':(Loan.findByLoanApplication(CM?.loanApplication)?.balanceAmount)],-1)
printHtmlPart(28)
expressionOut.print(Loan.findByLoanApplication(CM?.loanApplication)?.status?.description)
printHtmlPart(29)
}
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',145,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',150,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',152,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',153,[:],1)
printHtmlPart(35)
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
