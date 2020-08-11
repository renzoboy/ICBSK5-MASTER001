import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringreverseTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/reverseTxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
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
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('fieldValue','g',26,['bean':(reverseTransactionFileInstance),'field':("id")],-1)
printHtmlPart(8)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(reverseTransactionFileInstance?.txnDate)],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',34,['bean':(reverseTransactionFileInstance),'field':("txnType.description")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',38,['bean':(reverseTransactionFileInstance),'field':("acctNo")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',42,['bean':(reverseTransactionFileInstance),'field':("branch.name")],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(reverseTransactionFileInstance?.txnAmt)],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',51,['bean':(reverseTransactionFileInstance),'field':("txnCode")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',55,['bean':(reverseTransactionFileInstance),'field':("txnTemplate.description")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',59,['bean':(reverseTransactionFileInstance),'field':("txnDescription")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',63,['bean':(reverseTransactionFileInstance),'field':("txnRef")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',67,['bean':(reverseTransactionFileInstance),'field':("txnParticulars")],-1)
printHtmlPart(18)
expressionOut.print(getRefereceAndParticularsReverseInstance.txnParticulars.toString().replace("[", "").replace("]", ""))
printHtmlPart(19)
expressionOut.print(getRefereceAndParticularsReverseInstance.txnReference.toString().replace("[", "").replace("]", ""))
printHtmlPart(20)
invokeTag('fieldValue','g',79,['bean':(reverseTransactionFileInstance),'field':("status.description")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',83,['bean':(reverseTransactionFileInstance),'field':("user.username")],-1)
printHtmlPart(22)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printValidationSlip', params: [txnFile:reverseTransactionFileInstance.id]))
printHtmlPart(23)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(20).baseParams)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(20).outputParam)
printHtmlPart(25)
expressionOut.print(icbs.admin.Report.get(20).reportUnit)
printHtmlPart(26)
expressionOut.print(reverseTransactionFileInstance.id)
printHtmlPart(27)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(28)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(62).baseParams)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(62).outputParam)
printHtmlPart(25)
expressionOut.print(icbs.admin.Report.get(62).reportUnit)
printHtmlPart(29)
expressionOut.print(reverseTransactionFileInstance.id)
printHtmlPart(27)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(30)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printTransactionSlip', params: [txnFile:reverseTransactionFileInstance.id]))
printHtmlPart(31)
invokeTag('img','g',124,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(32)
invokeTag('img','g',129,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(33)
invokeTag('img','g',139,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',142,['action':("printPassbookTransactions"),'params':([txnId: reverseTransactionFileInstance.id])],3)
printHtmlPart(36)
expressionOut.print(passbookline)
printHtmlPart(37)
expressionOut.print(id)
printHtmlPart(38)
expressionOut.print(jrxmlTcId)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',151,['tag':("main-content")],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(42)
invokeTag('message','g',154,['code':("default.home.label")],-1)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',155,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',155,[:],1)
printHtmlPart(44)
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
