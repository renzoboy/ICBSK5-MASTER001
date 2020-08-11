import icbs.gl.AccountsReceivable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_assetsHtmhtmCredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/assetsHtm/htmCredit.gsp" }
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
expressionOut.print(htmCreditInstance?.branch?.name)
printHtmlPart(12)
expressionOut.print(htmCreditInstance?.htmDescription)
printHtmlPart(13)
invokeTag('formatNumber','g',79,['format':("###,###,##0.00"),'number':(htmCreditInstance.amount)],-1)
printHtmlPart(14)
expressionOut.print(htmCreditInstance.glCode)
printHtmlPart(15)
expressionOut.print(GlAccount.findByCode(htmCreditInstance?.glCode).name)
printHtmlPart(16)
invokeTag('formatDate','g',91,['format':("MM/dd/yyyy"),'date':(htmCreditInstance?.createdDate)],-1)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(19)
invokeTag('select','g',111,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(57),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(20)
invokeTag('field','g',117,['class':("form-control truncated"),'id':("creditAmt"),'name':("creditAmt"),'value':("")],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',120,['name':("htmCredit"),'id':("htmCredit"),'value':(htmCreditInstance?.id)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',121,['name':("htmAmountExist"),'id':("htmAmountExist"),'value':(htmCreditInstance.amount)],-1)
printHtmlPart(23)
invokeTag('field','g',126,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(24)
invokeTag('field','g',132,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(25)
})
invokeTag('form','g',136,['id':("creditHtm"),'url':([controller:assetsHtm, action:'savehtmCredit']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',139,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',144,['action':("show"),'id':(htmCreditInstance.id)],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',146,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',147,[:],1)
printHtmlPart(31)
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
