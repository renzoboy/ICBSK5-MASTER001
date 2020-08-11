import icbs.gl.AssetsHeldToMaturity
import icbs.gl.AssetsHeldToMaturityLedger
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_assetsHtmviewMoreTransaction_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/assetsHtm/viewMoreTransaction.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(htmVmtInstance?.branch?.name)
printHtmlPart(12)
expressionOut.print(htmVmtInstance.htmDescription)
printHtmlPart(13)
invokeTag('formatNumber','g',43,['format':("###,###,##0.00"),'number':(htmVmtInstance.amount)],-1)
printHtmlPart(14)
expressionOut.print(htmVmtInstance.glCode)
printHtmlPart(15)
expressionOut.print(GlAccount.findByCode(htmVmtInstance?.glCode).name)
printHtmlPart(16)
invokeTag('formatDate','g',55,['format':("MM/dd/yyyy"),'date':(htmVmtInstance?.createdDate)],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',72,['property':("refDate"),'title':(message(code: 'AssetsHeldToMaturityLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',73,['property':("valueDate"),'title':(message(code: 'AssetsHeldToMaturityLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',74,['property':("reference"),'title':(message(code: 'AssetsHeldToMaturityLedger.reference.date', default: 'References'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',75,['property':("particulars"),'title':(message(code: 'AssetsHeldToMaturityLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',76,['property':("debit"),'title':(message(code: 'AssetsHeldToMaturityLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',77,['property':("credit"),'title':(message(code: 'AssetsHeldToMaturityLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',78,['property':("balance"),'title':(message(code: 'AssetsHeldToMaturityLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( assetsHtmLedgerInstance in (htmLedgerInstance) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
invokeTag('formatDate','g',84,['format':("MM/dd/yyyy"),'date':(assetsHtmLedgerInstance?.refDate)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',85,['format':("MM/dd/yyyy"),'date':(assetsHtmLedgerInstance?.valueDate)],-1)
printHtmlPart(23)
expressionOut.print(assetsHtmLedgerInstance?.reference)
printHtmlPart(23)
expressionOut.print(assetsHtmLedgerInstance?.particulars)
printHtmlPart(24)
if(true && (assetsHtmLedgerInstance?.debit == 0)) {
printHtmlPart(25)
}
else {
printHtmlPart(26)
invokeTag('formatNumber','g',92,['format':("###,###,##0.00"),'number':(assetsHtmLedgerInstance?.debit)],-1)
printHtmlPart(24)
}
printHtmlPart(27)
if(true && (assetsHtmLedgerInstance?.credit == 0)) {
printHtmlPart(25)
}
else {
printHtmlPart(28)
invokeTag('formatNumber','g',98,['format':("###,###,##0.00"),'number':(assetsHtmLedgerInstance?.credit)],-1)
printHtmlPart(24)
}
printHtmlPart(28)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(assetsHtmLedgerInstance?.balance)],-1)
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
invokeTag('paginate','g',108,['total':(assetsHtmInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',139,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',143,['action':("show"),'id':(htmVmtInstance?.id)],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',144,['action':("index"),'controller':("assetsHtm"),'id':(htmInstance?.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',146,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',147,[:],1)
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
