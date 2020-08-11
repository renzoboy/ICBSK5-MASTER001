import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/create.gsp" }
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
expressionOut.print(resource(dir: 'css', file: 'cashfromvault.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'js', file: 'cashfromvault.js'))
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('javascript','g',35,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',36,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',41,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',52,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',53,['bean':(txnCashFromVaultInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',57,['bean':(txnCashFromVaultInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('render','g',60,['template':("tellerBalancing/form"),'model':([txnBalancing:txnBalancing])],-1)
printHtmlPart(20)
})
invokeTag('form','g',61,['id':("tellerbBalancingForm"),'name':("tellerbBalancingForm"),'action':("comfirmTellerBalance"),'controller':("tellering"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',63,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',67,['action':("index"),'onclick':("return confirm('Are you sure you want to return to the Tellering Index page?');")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',81,['action':("viewTellerCashTxn")],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',82,['action':("viewTellerOtherTxn")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',85,[:],1)
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
