import icbs.gl.AccountsPayable
import icbs.gl.AccountsPayableLedger
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableviewTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/viewTransactions.gsp" }
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
expressionOut.print(accountsPayableInstance.acctNo)
printHtmlPart(7)
expressionOut.print(accountsPayableInstance?.branch?.name)
printHtmlPart(8)
expressionOut.print(accountsPayableInstance.payable)
printHtmlPart(9)
expressionOut.print(accountsPayableInstance.glContra)
printHtmlPart(10)
expressionOut.print(GlAccount.findByCode(accountsPayableInstance?.glContra).name)
printHtmlPart(11)
invokeTag('formatDate','g',38,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.apCreatedDate)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',42,['format':("###,###,##0.00"),'number':(accountsPayableInstance.balance)],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',56,['property':("refDate"),'title':(message(code: 'accountsPayableLedger.refDate.label', default: 'Ref Date'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',57,['property':("valueDate"),'title':(message(code: 'accountsPayableLedger.valueDate.label', default: 'Value Date'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',58,['property':("reference"),'title':(message(code: 'accountsPayableLedger.reference.date', default: 'References'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',59,['property':("particulars"),'title':(message(code: 'accountsPayableLedger.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',60,['property':("debit"),'title':(message(code: 'accountsPayableLedger.debit.label', default: 'Debit Amount'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',61,['property':("credit"),'title':(message(code: 'accountsPayableLedger.credit.label', default: 'Credit Amount'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',62,['property':("balance"),'title':(message(code: 'accountsPayableLedger.balance.label', default: 'Balance Amount'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( accountsPayableLedgerInstance in (AccountsPayableLedger.findAllByAccountsPayable(accountsPayableInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
invokeTag('formatDate','g',68,['format':("MM/dd/yyyy"),'date':(accountsPayableLedgerInstance?.refDate)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',69,['format':("MM/dd/yyyy"),'date':(accountsPayableLedgerInstance?.valueDate)],-1)
printHtmlPart(19)
expressionOut.print(accountsPayableLedgerInstance?.reference)
printHtmlPart(19)
expressionOut.print(accountsPayableLedgerInstance?.particulars)
printHtmlPart(20)
if(true && (accountsPayableLedgerInstance?.debit == 0)) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(accountsPayableLedgerInstance?.debit)],-1)
printHtmlPart(20)
}
printHtmlPart(23)
if(true && (accountsPayableLedgerInstance?.credit == 0)) {
printHtmlPart(21)
}
else {
printHtmlPart(24)
invokeTag('formatNumber','g',82,['format':("###,###,##0.00"),'number':(accountsPayableLedgerInstance?.credit)],-1)
printHtmlPart(20)
}
printHtmlPart(24)
invokeTag('formatNumber','g',84,['format':("###,###,##0.00"),'number':(accountsPayableLedgerInstance?.balance)],-1)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
invokeTag('paginate','g',93,['total':(accountsPayableLedgerInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',95,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',99,['action':("edit"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',100,['action':("show"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(31)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',101,['action':("index"),'controller':("accountsPayable"),'id':(accountsPayableInstance.id)],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',103,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',104,[:],1)
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
