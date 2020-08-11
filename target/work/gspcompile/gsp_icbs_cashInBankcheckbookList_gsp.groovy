import icbs.gl.CashInBank
import icbs.gl.CashInBankCheckbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankcheckbookList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/checkbookList.gsp" }
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
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('render','g',16,['template':("cashInBankDetails")],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',24,['property':("checkNo"),'title':(message(code: 'CashInBankCheckbook.checkNo.label', default: 'Chk#'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("checkDate"),'title':(message(code: 'CashInBankCheckbook.checkDate.label', default: 'Date'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',26,['property':("payee"),'title':(message(code: 'CashInBankCheckbook.payee.label', default: 'Payee'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("checkAmt"),'title':(message(code: 'CashInBankCheckbook.checkAmt.date', default: 'Amount'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("checkStatus"),'title':(message(code: 'CashInBankCheckbook.checkStatus.label', default: 'Status'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( cbInstance in (CashInBankCheckbook.findAllByCashInBank(cashInBankInstance)) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
expressionOut.print(cbInstance?.checkNo)
printHtmlPart(16)
invokeTag('formatDate','g',36,['format':("MM/dd/yyyy"),'date':(cbInstance?.checkDate)],-1)
printHtmlPart(16)
expressionOut.print(cbInstance?.payee)
printHtmlPart(17)
invokeTag('formatNumber','g',38,['format':("###,###,###,##0.00"),'number':(cbInstance?.checkAmt)],-1)
printHtmlPart(16)
expressionOut.print(cbInstance?.checkStatus)
printHtmlPart(18)
createClosureForHtmlPart(19, 4)
invokeTag('link','g',41,['class':("btn btn-secondary"),'action':("chkDetails"),'id':(cbInstance.id)],4)
printHtmlPart(20)
if(true && (cbInstance.releaseDate == null && cbInstance?.checkDate != null)) {
printHtmlPart(21)
createClosureForHtmlPart(22, 5)
invokeTag('link','g',43,['class':("btn btn-secondary"),'action':("chkDisburse"),'id':(cbInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',83,['action':("show"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',84,['action':("createCb"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(29)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',85,['action':("createCheckTransaction"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(29)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',86,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-actions")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',90,[:],1)
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
