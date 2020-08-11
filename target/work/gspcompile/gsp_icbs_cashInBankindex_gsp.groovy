import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/index.gsp" }
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
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',19,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',23,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width:500px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',25,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',27,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',33,['property':("bankName"),'title':(message(code: 'cashInBank.bankName.label', default: 'Bank Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("branch"),'title':(message(code: 'cashInBank.branch.label', default: 'Branch'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("acctNo"),'title':(message(code: 'cashInBank.acctNo.label', default: 'Account Number'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',36,['property':("type"),'title':(message(code: 'cashInBank.type.label', default: 'Account Type'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',37,['property':("openDate"),'title':(message(code: 'cashInBank.openDate.date', default: 'Opening Date'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("currency"),'title':(message(code: 'cashInBank.currency.label', default: 'Currency'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',39,['property':("balance"),'title':(message(code: 'cashInBank.balance.label', default: 'Balance'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( cashInBankInstance in (cashInBankInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
expressionOut.print(cashInBankInstance?.bankName)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.bankBranch)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.acctNo)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.type)
printHtmlPart(21)
invokeTag('formatDate','g',50,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.openDate)],-1)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.currency?.code)
printHtmlPart(21)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(cashInBankInstance?.balance)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',53,['class':("btn btn-secondary"),'action':("show"),'id':(cashInBankInstance.id)],4)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',60,['total':(CashInBankInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',63,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',67,['controller':("home"),'action':("landing")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',68,['controller':("cashInBank"),'action':("create")],3)
printHtmlPart(29)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',69,['controller':("cashInBank"),'action':("fundTransfer")],3)
printHtmlPart(29)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',70,['controller':("home"),'action':("landing")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',72,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(34)
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
