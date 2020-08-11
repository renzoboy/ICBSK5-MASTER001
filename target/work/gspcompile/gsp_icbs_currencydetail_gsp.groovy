import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_currencydetail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/currency/detail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('set','g',16,['var':("entityName"),'value':(message(code: 'currency.label', default: 'Currency'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',17,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',17,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(uri:'/currency'))
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',23,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(money.code)
printHtmlPart(11)
expressionOut.print(money.name)
printHtmlPart(12)
expressionOut.print(money.id)
printHtmlPart(13)
for( _it419896848 in (moneydetail) ) {
changeItVariable(_it419896848)
printHtmlPart(14)
expressionOut.print(it.id)
printHtmlPart(15)
expressionOut.print(it.index)
printHtmlPart(16)
expressionOut.print(it.shortdescription)
printHtmlPart(17)
expressionOut.print(it.longdescription)
printHtmlPart(18)
expressionOut.print(it.currencyvalue)
printHtmlPart(19)
expressionOut.print(it.index)
printHtmlPart(20)
expressionOut.print(it.shortdescription)
printHtmlPart(21)
expressionOut.print(it.longdescription)
printHtmlPart(21)
expressionOut.print(it.currencyvalue)
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',89,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',114,['action':("index")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',117,['tag':("main-actions")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(28)
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
