import icbs.gl.CashInBank
import icbs.gl.CashInBankCheckbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankchkDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/chkDetails.gsp" }
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
expressionOut.print(cashInBankCheckbookInstance?.checkNo)
printHtmlPart(10)
expressionOut.print(cashInBankCheckbookInstance?.checkVoucherNo)
printHtmlPart(11)
expressionOut.print(cashInBankCheckbookInstance?.reference)
printHtmlPart(12)
invokeTag('formatDate','g',35,['format':("MM/dd/yyyy"),'date':(cashInBankCheckbookInstance?.checkDate)],-1)
printHtmlPart(13)
expressionOut.print(cashInBankCheckbookInstance?.payee)
printHtmlPart(14)
expressionOut.print(cashInBankCheckbookInstance?.particulars)
printHtmlPart(15)
invokeTag('formatDate','g',47,['format':("MM/dd/yyyy"),'date':(cashInBankCheckbookInstance?.releaseDate)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',51,['format':("###,###,##0.00"),'number':(cashInBankCheckbookInstance?.checkAmt)],-1)
printHtmlPart(17)
expressionOut.print(cashInBankCheckbookInstance?.issuedBy?.name)
printHtmlPart(18)
expressionOut.print(cashInBankCheckbookInstance?.createdBy?.name)
printHtmlPart(19)
expressionOut.print(cashInBankCheckbookInstance?.checkStatus?.description)
printHtmlPart(20)
if(true && (cashInBankCheckbookInstance?.txnFile)) {
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(cashInBankCheckbookInstance?.txnFile.id)
})
invokeTag('link','g',69,['action':("showGlEntries"),'controller':("tellering"),'id':(cashInBankCheckbookInstance?.txnFile.id)],4)
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',84,['action':("show"),'controller':("cashInBank"),'id':(cashInBankCheckbookInstance.cashInBank.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',85,['action':("index"),'controller':("cashInBank")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',88,[:],1)
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
