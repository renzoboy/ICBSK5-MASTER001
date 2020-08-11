import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnFDInterestWithdrawalcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnFDInterestWithdrawal/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(5)
invokeTag('javascript','asset',14,['src':("telleringHelper.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',15,['src':("checkPassbookBal.js")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit", customFilter: 3]))
printHtmlPart(9)
})
invokeTag('javascript','g',66,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',67,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(12, 2)
invokeTag('captureContent','sitemesh',72,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(14)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(17)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(18)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(19)
if(true && (signatory.status.id!=3)) {
printHtmlPart(20)
invokeTag('render','g',125,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(19)
}
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(24)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(25)
if(true && (flash.message)) {
printHtmlPart(26)
expressionOut.print(flash.message)
printHtmlPart(27)
invokeTag('img','g',172,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(28)
invokeTag('img','g',181,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(29)
invokeTag('img','g',201,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(30)
expressionOut.print(passbookline)
printHtmlPart(31)
expressionOut.print(id)
printHtmlPart(32)
expressionOut.print(jrxmlTcId)
printHtmlPart(33)
}
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(35)
expressionOut.print(it)
printHtmlPart(36)
})
invokeTag('hasErrors','g',222,['bean':(txnFDInterestWithdrawalInstance)],3)
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(37)
invokeTag('render','g',224,['template':("txnFDInterestWithdrawal/form"),'model':([txnFDInterestWithdrawalInstance:txnFDInterestWithdrawalInstance,depositInstance:depositInstance])],-1)
printHtmlPart(34)
})
invokeTag('form','g',225,['name':("txnFDInterestWithdrawalForm"),'action':("saveTellerFDInterestWithdrawalTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',227,['tag':("main-content")],2)
printHtmlPart(38)
createClosureForHtmlPart(39, 2)
invokeTag('jasperReport','g',231,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',313,['action':("index")],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',315,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',316,[:],1)
printHtmlPart(45)
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
