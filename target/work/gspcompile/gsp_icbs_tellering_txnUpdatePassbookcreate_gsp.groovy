import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnUpdatePassbookcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnUpdatePassbook/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
expressionOut.print(resource(dir: 'js', file: 'customerSearch.js'))
printHtmlPart(5)
invokeTag('javascript','asset',9,['src':("checkPassbookBal.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',10,['src':("telleringHelper.js")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(controller : 'tellering', action:'changeDepositDetails'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(9)
})
invokeTag('javascript','g',22,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(12, 2)
invokeTag('captureContent','sitemesh',28,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('render','g',30,['template':("txnUpdatePassbook/form")],-1)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',31,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',35,['action':("index")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',37,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',38,[:],1)
printHtmlPart(19)
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
