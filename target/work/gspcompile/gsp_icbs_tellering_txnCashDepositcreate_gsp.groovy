import icbs.admin.TxnTemplate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashDepositcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashDeposit/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(5)
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(6)
invokeTag('javascript','asset',13,['src':("checkPassbookBal.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("telleringHelper.js")],-1)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit", module:"deposit" ]))
printHtmlPart(10)
})
invokeTag('javascript','g',40,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',41,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',46,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(14)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(15)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(18)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(19)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(20)
if(true && (signatory.status.id!=3)) {
printHtmlPart(21)
invokeTag('render','g',99,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(20)
}
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(25)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(26)
if(true && (flash.message)) {
printHtmlPart(27)
expressionOut.print(flash.message)
printHtmlPart(28)
invokeTag('img','g',147,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(29)
invokeTag('img','g',155,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(30)
invokeTag('img','g',175,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(31)
expressionOut.print(passbookline)
printHtmlPart(32)
expressionOut.print(id)
printHtmlPart(33)
expressionOut.print(jrxmlTcId)
printHtmlPart(34)
}
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
expressionOut.print(it)
printHtmlPart(37)
})
invokeTag('hasErrors','g',195,['bean':(txnCashDepositInstance)],3)
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('render','g',199,['template':("txnCashDeposit/form"),'model':([txnCashDepositInstance:txnCashDepositInstance])],-1)
printHtmlPart(39)
})
invokeTag('form','g',201,['name':("txnCashDepositForm"),'action':("saveTellerCashDepositTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',203,['tag':("main-content")],2)
printHtmlPart(41)
createClosureForHtmlPart(42, 2)
invokeTag('jasperReport','g',207,['action':("printPassbookTransactions"),'controller':("tellering"),'format':("PDF"),'name':("Passbook"),'jasper':("Transaction")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(43)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(44)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',265,['action':("index")],3)
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',267,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',268,[:],1)
printHtmlPart(47)
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
