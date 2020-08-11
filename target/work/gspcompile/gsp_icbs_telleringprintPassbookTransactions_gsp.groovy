import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringprintPassbookTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/printPassbookTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('captureContent','sitemesh',19,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(pbLedger?.id)
printHtmlPart(13)
expressionOut.print(pbLedger?.acctNo)
printHtmlPart(14)
expressionOut.print(pbLedger?.acct?.acctName)
printHtmlPart(15)
if(true && (session["type"]==1 || session["type"]==2 || session["type"]==4)) {
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',64,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',68,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(20)
invokeTag('field','g',69,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(21)
})
invokeTag('form','g',72,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLine',controller:'tellering'])],4)
printHtmlPart(16)
}
else {
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',78,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',82,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(20)
invokeTag('field','g',83,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(21)
})
invokeTag('form','g',86,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLineTd',controller:'tellering'])],4)
printHtmlPart(16)
}
printHtmlPart(3)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
expressionOut.print(message(code: 'default.button.create.label', default: 'Submit'))
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',95,['action':("index")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-actions")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',98,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1596079417644L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
