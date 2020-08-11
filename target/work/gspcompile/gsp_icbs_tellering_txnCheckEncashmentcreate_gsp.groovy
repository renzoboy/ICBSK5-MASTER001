import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckEncashmentcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckEncashment/create.gsp" }
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
invokeTag('javascript','asset',12,['src':("telleringHelper.js")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(8)
})
invokeTag('javascript','g',62,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',66,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(11, 2)
invokeTag('captureContent','sitemesh',71,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
invokeTag('img','g',93,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(15)
invokeTag('img','g',101,['dir':("images"),'file':("transactionslip.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && ((depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(18)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (depositInstance?.customer?.attachments?.find{it.isPrimarySig==true})?.id ))
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(21)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(22)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(23)
if(true && (signatory.status.id!=3)) {
printHtmlPart(24)
invokeTag('render','g',158,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(23)
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(28)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
expressionOut.print(it)
printHtmlPart(31)
createTagBody(4, {->
printHtmlPart(32)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(33)
expressionOut.print(error.field)
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('message','g',205,['error':(error)],-1)
printHtmlPart(36)
})
invokeTag('eachError','g',206,['bean':(txnCheckEncashmentInstance),'var':("error")],4)
printHtmlPart(37)
})
invokeTag('hasErrors','g',210,['bean':(txnCheckEncashmentInstance)],3)
printHtmlPart(38)
createTagBody(3, {->
printHtmlPart(39)
invokeTag('render','g',212,['template':("txnCheckEncashment/form"),'model':([txnCheckEncashmentInstance:txnCheckEncashmentInstance])],-1)
printHtmlPart(38)
})
invokeTag('form','g',213,['name':("txnCheckEncashmentForm"),'action':("saveTellerCheckEncashmentTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',215,['tag':("main-content")],2)
printHtmlPart(41)
createClosureForHtmlPart(12, 2)
invokeTag('jasperReport','g',219,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(42)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',227,['action':("index")],3)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',291,['tag':("main-actions")],2)
printHtmlPart(46)
})
invokeTag('captureBody','sitemesh',292,[:],1)
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
