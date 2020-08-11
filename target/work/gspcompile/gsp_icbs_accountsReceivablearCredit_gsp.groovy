import icbs.gl.AccountsReceivable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivablearCredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/arCredit.gsp" }
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
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (accountsReceivableInstance?.customer)) {
printHtmlPart(12)
invokeTag('render','g',29,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:accountsReceivableInstance?.customer])],-1)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(accountsReceivableInstance?.acctNo)
printHtmlPart(15)
expressionOut.print(accountsReceivableInstance?.branch?.name)
printHtmlPart(16)
expressionOut.print(accountsReceivableInstance.receivableName)
printHtmlPart(17)
expressionOut.print(accountsReceivableInstance.description)
printHtmlPart(18)
invokeTag('formatNumber','g',58,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.balance)],-1)
printHtmlPart(19)
expressionOut.print(accountsReceivableInstance.glContra)
printHtmlPart(20)
expressionOut.print(GlAccount.findByCode(accountsReceivableInstance?.glContra).name)
printHtmlPart(21)
invokeTag('formatDate','g',70,['format':("MM/dd/yyyy"),'date':(accountsReceivableInstance.bookingDate)],-1)
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(24)
invokeTag('select','g',91,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(48),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(25)
invokeTag('textField','g',97,['class':("form-control truncated"),'id':("creditAmt"),'name':("creditAmt"),'value':("")],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',100,['name':("crCredit"),'id':("crCredit"),'value':(params.id)],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',101,['name':("arXbalance"),'id':("arXbalance"),'value':(accountsReceivableInstance.balance)],-1)
printHtmlPart(28)
invokeTag('textField','g',106,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(29)
invokeTag('textField','g',112,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(30)
})
invokeTag('form','g',116,['id':("deposit"),'url':([resource:accountsReceivableInstance, action:'savecrDebit']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',154,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',159,['action':("show"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',161,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',162,[:],1)
printHtmlPart(36)
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
