import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBanksaveFundTransfer_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/saveFundTransfer.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(txSource.id)
printHtmlPart(9)
expressionOut.print(txDest.id)
printHtmlPart(10)
invokeTag('formatNumber','g',29,['format':("##0.00000"),'number':(txSource?.txnAmt)],-1)
printHtmlPart(11)
expressionOut.print(txSource?.txnRef)
printHtmlPart(12)
expressionOut.print(txSource?.txnParticulars)
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',44,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',48,['controller':("home"),'action':("landing")],3)
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',49,['controller':("cashInBank"),'action':("index")],3)
printHtmlPart(17)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',50,['controller':("cashInBank"),'action':("create")],3)
printHtmlPart(17)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',51,['controller':("cashInBank"),'action':("fundTransfer")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',53,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(22)
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
