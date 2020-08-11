import icbs.gl.AccountsReceivable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivableshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/show.gsp" }
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
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(6)
})
invokeTag('javascript','g',30,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(10)
})
invokeTag('captureContent','sitemesh',36,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (accountsReceivableInstance?.customer)) {
printHtmlPart(15)
invokeTag('render','g',51,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:accountsReceivableInstance?.customer])],-1)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(accountsReceivableInstance?.acctNo)
printHtmlPart(18)
expressionOut.print(accountsReceivableInstance?.branch?.name)
printHtmlPart(19)
expressionOut.print(accountsReceivableInstance.receivableName)
printHtmlPart(20)
expressionOut.print(accountsReceivableInstance.description)
printHtmlPart(21)
invokeTag('formatNumber','g',81,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.balance)],-1)
printHtmlPart(22)
expressionOut.print(accountsReceivableInstance?.currency?.code)
printHtmlPart(23)
expressionOut.print(accountsReceivableInstance.glContra)
printHtmlPart(24)
expressionOut.print(GlAccount.findByCode(accountsReceivableInstance?.glContra).name)
printHtmlPart(25)
expressionOut.print(accountsReceivableInstance.reference)
printHtmlPart(26)
invokeTag('formatDate','g',103,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.bookingDate)],-1)
printHtmlPart(27)
invokeTag('formatDate','g',107,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.maturityDate)],-1)
printHtmlPart(28)
invokeTag('formatNumber','g',111,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.requiredAllowance)],-1)
printHtmlPart(29)
expressionOut.print(accountsReceivableInstance?.user?.name)
printHtmlPart(30)
expressionOut.print(accountsReceivableInstance.status)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',128,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
if(true && (accountsReceivableInstance.status.id != 8)) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',133,['action':("edit"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],4)
printHtmlPart(36)
createClosureForHtmlPart(37, 4)
invokeTag('link','g',134,['action':("arDebit"),'id':(accountsReceivableInstance.id)],4)
printHtmlPart(36)
createClosureForHtmlPart(38, 4)
invokeTag('link','g',135,['action':("arCredit"),'id':(accountsReceivableInstance.id)],4)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (accountsReceivableInstance.balance > 0)) {
printHtmlPart(34)
createClosureForHtmlPart(41, 4)
invokeTag('link','g',138,['action':("reclassAr"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],4)
printHtmlPart(42)
}
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',140,['action':("viewTransactions"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(39)
if(true && (accountsReceivableInstance.balance == 0.00D && accountsReceivableInstance.status.id != 8)) {
printHtmlPart(34)
createClosureForHtmlPart(45, 4)
invokeTag('link','g',142,['action':("arClose"),'id':(accountsReceivableInstance.id)],4)
printHtmlPart(39)
}
printHtmlPart(43)
createClosureForHtmlPart(46, 3)
invokeTag('link','g',144,['action':("index"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',146,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',147,[:],1)
printHtmlPart(48)
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
