import icbs.gl.AssetsHeldToMaturity
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_assetsHtmhtmDebit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/assetsHtm/htmDebit.gsp" }
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
expressionOut.print(htmDebitInstance?.branch?.name)
printHtmlPart(12)
expressionOut.print(htmDebitInstance?.htmDescription)
printHtmlPart(13)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(htmDebitInstance.amount)],-1)
printHtmlPart(14)
expressionOut.print(htmDebitInstance.glCode)
printHtmlPart(15)
expressionOut.print(GlAccount.findByCode(htmDebitInstance?.glCode).name)
printHtmlPart(16)
invokeTag('formatDate','g',88,['format':("MM/dd/yyyy"),'date':(htmDebitInstance?.createdDate)],-1)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(19)
invokeTag('select','g',109,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(56),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(20)
invokeTag('field','g',115,['class':("form-control truncated"),'id':("debitAmt"),'name':("debitAmt"),'value':("")],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',119,['name':("htmDebit"),'id':("htmDebit"),'value':(htmDebitInstance?.id)],-1)
printHtmlPart(22)
invokeTag('field','g',123,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(23)
invokeTag('field','g',129,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(24)
})
invokeTag('form','g',133,['id':("debitHtm"),'url':([controller:assetsHtm, action:'savehtmDebit']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',136,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',141,['action':("show"),'id':(htmDebitInstance.id)],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',143,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',144,[:],1)
printHtmlPart(30)
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
