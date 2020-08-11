import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(cashInBankInstance?.branch?.name)
printHtmlPart(11)
expressionOut.print(cashInBankInstance?.type?.description)
printHtmlPart(12)
expressionOut.print(cashInBankInstance?.currency?.code)
printHtmlPart(13)
expressionOut.print(cashInBankInstance?.bankName)
printHtmlPart(14)
expressionOut.print(cashInBankInstance?.bankBranch)
printHtmlPart(15)
expressionOut.print(cashInBankInstance?.bankAddress)
printHtmlPart(16)
expressionOut.print(cashInBankInstance?.acctNo)
printHtmlPart(17)
invokeTag('formatNumber','g',57,['format':("##0.00000"),'number':(cashInBankInstance?.intRate)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',61,['format':("###,###,##0.00"),'number':(cashInBankInstance?.balance)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',65,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.openDate)],-1)
printHtmlPart(20)
invokeTag('formatDate','g',69,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.maturityDate)],-1)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.user?.name)
printHtmlPart(22)
invokeTag('formatDate','g',77,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.createDate)],-1)
printHtmlPart(23)
expressionOut.print(cashInBankInstance?.glContra)
printHtmlPart(24)
expressionOut.print(cashInBankInstance?.status?.description)
printHtmlPart(25)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(cashInBankInstance?.balance)],-1)
printHtmlPart(26)
expressionOut.print(cashInBankInstance?.remarks)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',98,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
if(true && (cashInBankInstance.status.id == 2)) {
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',103,['action':("edit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(32)
}
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',105,['action':("viewTransactions"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(32)
if(true && (cashInBankInstance.type.id == 2)) {
printHtmlPart(35)
if(true && (cashInBankInstance.status.id == 2)) {
printHtmlPart(36)
createClosureForHtmlPart(37, 5)
invokeTag('link','g',108,['action':("createCb"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],5)
printHtmlPart(38)
createClosureForHtmlPart(39, 5)
invokeTag('link','g',109,['action':("checkbookList"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],5)
printHtmlPart(40)
createClosureForHtmlPart(41, 5)
invokeTag('link','g',110,['action':("createCheckTransaction"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],5)
printHtmlPart(42)
}
printHtmlPart(43)
}
else {
printHtmlPart(35)
if(true && (cashInBankInstance.status.id == 2)) {
printHtmlPart(36)
createClosureForHtmlPart(44, 5)
invokeTag('link','g',115,['action':("cashWithdrawal"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],5)
printHtmlPart(42)
}
printHtmlPart(45)
}
printHtmlPart(43)
if(true && (cashInBankInstance.status.id == 2)) {
printHtmlPart(30)
createClosureForHtmlPart(46, 4)
invokeTag('link','g',119,['action':("cashAndCheckDeposit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',120,['action':("cibDebit"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(47)
createClosureForHtmlPart(49, 4)
invokeTag('link','g',121,['action':("creditAdjustment"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],4)
printHtmlPart(47)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',122,['action':("cibClose"),'id':(cashInBankInstance.id)],4)
printHtmlPart(32)
}
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',124,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(53)
createClosureForHtmlPart(54, 3)
invokeTag('link','g',125,['controller':("cashInBank"),'action':("bankRecon"),'id':(cashInBankInstance?.acctNo)],3)
printHtmlPart(55)
})
invokeTag('captureContent','sitemesh',129,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',130,[:],1)
printHtmlPart(56)
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
