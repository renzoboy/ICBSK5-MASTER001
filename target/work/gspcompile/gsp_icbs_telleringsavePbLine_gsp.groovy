import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringsavePbLine_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/savePbLine.gsp" }
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
expressionOut.print(pbLedger?.acctNo)
printHtmlPart(10)
expressionOut.print(pbLedger?.acct?.acctName)
printHtmlPart(11)
expressionOut.print(pbLineNo)
printHtmlPart(12)
expressionOut.print(g.createLink(controller: 'tellering', action: 'printToPassbookTransactions', params: [pbPrintLine:pbPrintLine]))
printHtmlPart(13)
invokeTag('img','g',60,['dir':("images"),'file':("passbook-icon.jpg"),'width':("35"),'height':("35")],-1)
printHtmlPart(14)
expressionOut.print(passbookline)
printHtmlPart(15)
expressionOut.print(id)
printHtmlPart(16)
expressionOut.print(jrxmlTcId)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',71,['action':("index")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',71,['tag':("main-actions")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(23)
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
