import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringreprintPassbookShow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/reprintPassbookShow.gsp" }
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
expressionOut.print(pbLedger?.acctNo)
printHtmlPart(13)
expressionOut.print(pbLedger?.acct?.acctName)
printHtmlPart(14)
expressionOut.print(pbLedger?.txnDate)
printHtmlPart(15)
expressionOut.print(pbLedger?.passbookLine)
printHtmlPart(16)
if(true && (session["type"]==1 || session["type"]==2)) {
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',74,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',78,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(21)
invokeTag('field','g',79,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(22)
})
invokeTag('form','g',82,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLine',controller:'tellering'])],4)
printHtmlPart(17)
}
else {
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
expressionOut.print(hasErrors(bean: pbLedger, field: 'passbookLine', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',88,['code':("pbLedger.passbookLine.label"),'default':("Passbook Line Number")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',92,['id':("ledgerId"),'name':("ledgerId"),'value':(fieldValue(bean: pbLedger, field: 'id'))],-1)
printHtmlPart(21)
invokeTag('field','g',93,['id':("pbl"),'name':("passbookLine"),'required':("true"),'value':(fieldValue(bean: pbLedger, field: 'passbookLine')),'class':("txn-amt form-control")],-1)
printHtmlPart(22)
})
invokeTag('form','g',96,['name':("pbLineForm"),'method':("post"),'url':([action:'savePbLineTd',controller:'tellering'])],4)
printHtmlPart(17)
}
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',98,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
expressionOut.print(message(code: 'default.button.create.label', default: 'Submit'))
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',105,['action':("index")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',107,['tag':("main-actions")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',108,[:],1)
printHtmlPart(30)
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
