import icbs.gl.AccountsPayable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/accountsPayable'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (accountsPayableInstance?.customer)) {
printHtmlPart(13)
invokeTag('render','g',28,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:accountsPayableInstance?.customer])],-1)
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(accountsPayableInstance.acctNo)
printHtmlPart(16)
expressionOut.print(accountsPayableInstance?.branch?.name)
printHtmlPart(17)
expressionOut.print(accountsPayableInstance.payable)
printHtmlPart(18)
expressionOut.print(accountsPayableInstance.glContra)
printHtmlPart(19)
expressionOut.print(GlAccount.findByCode(accountsPayableInstance?.glContra).name)
printHtmlPart(20)
invokeTag('formatNumber','g',63,['format':("###,###,##0.00"),'number':(accountsPayableInstance.balance)],-1)
printHtmlPart(21)
expressionOut.print(accountsPayableInstance?.currency?.code)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance.reference)
printHtmlPart(23)
expressionOut.print(accountsPayableInstance.particulars)
printHtmlPart(24)
invokeTag('formatDate','g',81,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.bookingDate)],-1)
printHtmlPart(25)
invokeTag('formatDate','g',85,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.apCreatedDate)],-1)
printHtmlPart(26)
expressionOut.print(accountsPayableInstance?.user?.name1)
printHtmlPart(27)
expressionOut.print(accountsPayableInstance?.user?.name2)
printHtmlPart(27)
expressionOut.print(accountsPayableInstance?.user?.name3)
printHtmlPart(28)
expressionOut.print(accountsPayableInstance.status)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
if(true && (accountsPayableInstance.status.id != 8)) {
printHtmlPart(32)
createClosureForHtmlPart(33, 4)
invokeTag('link','g',108,['action':("edit"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],4)
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',109,['action':("apDebit"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],4)
printHtmlPart(36)
createClosureForHtmlPart(37, 4)
invokeTag('link','g',110,['action':("apCredit"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],4)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (accountsPayableInstance.balance > 0)) {
printHtmlPart(32)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',113,['action':("reclassAp"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],4)
printHtmlPart(41)
}
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',115,['action':("viewTransactions"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(44)
if(true && (accountsPayableInstance.balance == 0.00D && accountsPayableInstance.status.id != 8)) {
printHtmlPart(32)
createClosureForHtmlPart(45, 4)
invokeTag('link','g',118,['action':("apClose"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],4)
printHtmlPart(38)
}
printHtmlPart(46)
createClosureForHtmlPart(47, 3)
invokeTag('link','g',120,['action':("index"),'controller':("accountsPayable")],3)
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',122,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',123,[:],1)
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
