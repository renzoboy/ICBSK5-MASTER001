import icbs.gl.BillsPayable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayableshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/show.gsp" }
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
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/billsPayable'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(billsPayableInstance?.branch?.name)
printHtmlPart(11)
expressionOut.print(billsPayableInstance?.currency?.name)
printHtmlPart(12)
expressionOut.print(billsPayableInstance?.glContra)
printHtmlPart(13)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(14)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dateOpened)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',49,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dueDate)],-1)
printHtmlPart(16)
invokeTag('formatDate','g',53,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.pnDate)],-1)
printHtmlPart(17)
expressionOut.print(billsPayableInstance?.pnNo)
printHtmlPart(18)
expressionOut.print(billsPayableInstance?.pdcIssuedText)
printHtmlPart(19)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(20)
expressionOut.print(billsPayableInstance?.payee)
printHtmlPart(21)
invokeTag('formatNumber','g',73,['format':("###,###,##0.00"),'number':(billsPayableInstance?.interestRate)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',77,['format':("###,###,##0.00"),'number':(billsPayableInstance?.principal)],-1)
printHtmlPart(23)
expressionOut.print(billsPayableInstance?.status.description)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',89,['action':("edit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',90,['action':("linkLoans"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',91,['action':("viewTransactions"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',92,['action':("bpDebit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',93,['action':("bpCredit"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(28)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',94,['action':("index"),'controller':("billsPayable")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',96,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',97,[:],1)
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
