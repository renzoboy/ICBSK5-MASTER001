import icbs.gl.AccountsReceivable
import icbs.gl.AccountsReceivableLedger
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivableviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/viewTransactions.gsp" }
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
expressionOut.print(accountsReceivableInstance?.acctNo)
printHtmlPart(12)
expressionOut.print(accountsReceivableInstance?.branch?.name)
printHtmlPart(13)
expressionOut.print(accountsReceivableInstance.receivableName)
printHtmlPart(14)
expressionOut.print(accountsReceivableInstance.description)
printHtmlPart(15)
invokeTag('formatNumber','g',49,['format':("###,###,##0.00"),'number':(accountsReceivableInstance.balance)],-1)
printHtmlPart(16)
expressionOut.print(accountsReceivableInstance.glContra)
printHtmlPart(17)
expressionOut.print(GlAccount.findByCode(accountsReceivableInstance?.glContra).name)
printHtmlPart(18)
invokeTag('sortableColumn','g',74,['property':("refDate"),'title':(message(code: 'accountsReceivableLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',75,['property':("valueDate"),'title':(message(code: 'accountsReceivableLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',76,['property':("reference"),'title':(message(code: 'accountsReceivableLedger.reference.date', default: 'References'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',77,['property':("particulars"),'title':(message(code: 'accountsReceivableLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',78,['property':("debit"),'title':(message(code: 'accountsReceivableLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',79,['property':("credit"),'title':(message(code: 'accountsReceivableLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',80,['property':("balance"),'title':(message(code: 'accountsReceivableLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(21)
loop:{
int i = 0
for( accountsReceivableLedgerInstance in (AccountsReceivableLedger.findAllByAccountsReceivable(accountsReceivableInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(22)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(23)
invokeTag('formatDate','g',86,['format':("MM/dd/yyyy"),'date':(accountsReceivableLedgerInstance?.refDate)],-1)
printHtmlPart(24)
invokeTag('formatDate','g',87,['format':("MM/dd/yyyy"),'date':(accountsReceivableLedgerInstance?.valueDate)],-1)
printHtmlPart(24)
expressionOut.print(accountsReceivableLedgerInstance?.reference)
printHtmlPart(24)
expressionOut.print(accountsReceivableLedgerInstance?.particulars)
printHtmlPart(25)
if(true && (accountsReceivableLedgerInstance?.debit == 0)) {
printHtmlPart(26)
}
else {
printHtmlPart(27)
invokeTag('formatNumber','g',94,['format':("###,###,##0.00"),'number':(accountsReceivableLedgerInstance?.debit)],-1)
printHtmlPart(25)
}
printHtmlPart(28)
if(true && (accountsReceivableLedgerInstance?.credit == 0)) {
printHtmlPart(26)
}
else {
printHtmlPart(29)
invokeTag('formatNumber','g',100,['format':("###,###,##0.00"),'number':(accountsReceivableLedgerInstance?.credit)],-1)
printHtmlPart(25)
}
printHtmlPart(29)
invokeTag('formatNumber','g',102,['format':("###,###,##0.00"),'number':(accountsReceivableLedgerInstance?.balance)],-1)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
invokeTag('paginate','g',111,['total':(accountsReceivableInstanceCount?: 0),'params':(params)],-1)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',113,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',117,['action':("show"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',118,['action':("index"),'controller':("accountsReceivable"),'id':(accountsReceivableInstance.id)],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(39)
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
