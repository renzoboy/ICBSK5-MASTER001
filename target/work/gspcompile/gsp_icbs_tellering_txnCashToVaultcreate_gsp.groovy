import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashToVaultcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashToVault/create.gsp" }
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
expressionOut.print(resource(dir: 'css', file: 'cashtovault.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'js', file: 'cashtovault.js'))
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('javascript','g',69,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',70,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',75,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
invokeTag('img','g',97,['dir':("images"),'file':("validate.png"),'width':("35"),'height':("35")],-1)
printHtmlPart(14)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(15)
expressionOut.print(it)
printHtmlPart(16)
})
invokeTag('hasErrors','g',112,['bean':(txnCashToVaultInstance)],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('render','g',114,['template':("txnCashToVault/form"),'model':([txnCashToVaultInstance:txnCashToVaultInstance])],-1)
printHtmlPart(11)
})
invokeTag('form','g',115,['name':("txnCashToVaultForm"),'action':("saveTellerCashToVaultTxn"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',117,['tag':("main-content")],2)
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('jasperReport','g',121,['action':("printSLIP"),'controller':("tellering"),'format':("PDF"),'name':("TRANSACTION"),'jasper':("SLIP")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',126,['action':("index"),'onclick':("return confirm('Are you sure you want to return to the Tellering Index page?');")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',192,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',193,[:],1)
printHtmlPart(26)
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
