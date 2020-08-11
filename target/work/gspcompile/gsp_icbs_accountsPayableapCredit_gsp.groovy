import icbs.gl.AccountsPayable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableapCredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/apCredit.gsp" }
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
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (accountsPayableInstance?.customer)) {
printHtmlPart(12)
invokeTag('render','g',28,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:accountsPayableInstance?.customer])],-1)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(accountsPayableInstance.acctNo)
printHtmlPart(15)
expressionOut.print(accountsPayableInstance?.branch?.name)
printHtmlPart(16)
expressionOut.print(accountsPayableInstance.payable)
printHtmlPart(17)
expressionOut.print(accountsPayableInstance?.currency?.code)
printHtmlPart(18)
expressionOut.print(accountsPayableInstance.glContra)
printHtmlPart(19)
expressionOut.print(GlAccount.findByCode(accountsPayableInstance?.glContra).name)
printHtmlPart(20)
invokeTag('formatDate','g',67,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.apCreatedDate)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',71,['format':("###,###,##0.00"),'number':(accountsPayableInstance.balance)],-1)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance?.user?.name1)
printHtmlPart(23)
expressionOut.print(accountsPayableInstance?.user?.name2)
printHtmlPart(23)
expressionOut.print(accountsPayableInstance?.user?.name3)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(26)
invokeTag('select','g',93,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(50),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(27)
invokeTag('field','g',99,['class':("form-control truncated"),'id':("creditAmt"),'name':("creditAmt"),'value':("")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',102,['name':("apCredit"),'id':("apCredit"),'value':(params.id)],-1)
printHtmlPart(29)
invokeTag('field','g',107,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(30)
invokeTag('field','g',113,['class':("form-control"),'type':("Text"),'id':("txparticulars"),'name':("txparticulars"),'value':("")],-1)
printHtmlPart(31)
})
invokeTag('form','g',117,['id':("deposit"),'url':([resource:accountsPayableInstance, action:'saveapCredit']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('javascript','g',160,[:],3)
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',161,['tag':("main-content")],2)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',166,['action':("show"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',168,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',169,[:],1)
printHtmlPart(38)
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
