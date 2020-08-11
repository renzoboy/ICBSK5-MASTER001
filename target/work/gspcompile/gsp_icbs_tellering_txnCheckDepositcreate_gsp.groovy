import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckDepositcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckDeposit/create.gsp" }
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
invokeTag('javascript','asset',13,['src':("telleringHelper.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',14,['src':("checkPassbookBal.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',15,['src':("checkCheckType.js")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(9)
expressionOut.print(createLink(controller:'tellering', action:'showChecksAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'tellering', action:'addCheckAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'tellering', action:'deleteCheckAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller: 'tellering', action:'showAddCheckAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'tellering', action:'changeForm'))
printHtmlPart(14)
})
invokeTag('javascript','g',118,[:],2)
printHtmlPart(15)
})
invokeTag('captureHead','sitemesh',158,[:],1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(17, 2)
invokeTag('captureContent','sitemesh',163,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(18)
if(true && ((txnCheckDepositInstance?.acct?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(19)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(20)
}
printHtmlPart(21)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(22)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(23)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(24)
if(true && (signatory.status.id!=3)) {
printHtmlPart(25)
invokeTag('render','g',233,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(24)
}
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(29)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(30)
if(true && (flash.message)) {
printHtmlPart(31)
expressionOut.print(flash.message)
printHtmlPart(32)
invokeTag('img','g',280,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(33)
invokeTag('img','g',288,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(34)
invokeTag('img','g',308,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(35)
expressionOut.print(passbookline)
printHtmlPart(36)
expressionOut.print(id)
printHtmlPart(37)
expressionOut.print(jrxmlTcId)
printHtmlPart(38)
}
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
expressionOut.print(it)
printHtmlPart(41)
createTagBody(4, {->
printHtmlPart(42)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(43)
expressionOut.print(error.field)
printHtmlPart(44)
}
printHtmlPart(45)
invokeTag('message','g',338,['error':(error)],-1)
printHtmlPart(46)
})
invokeTag('eachError','g',339,['bean':(txnCheckDepositInstance),'var':("error")],4)
printHtmlPart(47)
})
invokeTag('hasErrors','g',343,['bean':(txnCheckDepositInstance)],3)
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(48)
invokeTag('render','g',346,['template':("txnCheckDeposit/form"),'model':([txnCheckDepositInstance:txnCheckDepositInstance])],-1)
printHtmlPart(49)
})
invokeTag('form','g',347,['name':("txnCheckDepositForm"),'action':("saveTellerCheckDepositTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',349,['tag':("main-content")],2)
printHtmlPart(50)
createClosureForHtmlPart(51, 2)
invokeTag('jasperReport','g',353,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(52)
createTagBody(2, {->
printHtmlPart(53)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(54)
createClosureForHtmlPart(55, 3)
invokeTag('link','g',424,['action':("index")],3)
printHtmlPart(56)
})
invokeTag('captureContent','sitemesh',427,['tag':("main-actions")],2)
printHtmlPart(57)
})
invokeTag('captureBody','sitemesh',428,[:],1)
printHtmlPart(58)
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
