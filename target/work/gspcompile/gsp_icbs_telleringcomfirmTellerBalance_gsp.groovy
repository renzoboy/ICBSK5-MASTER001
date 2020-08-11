import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_telleringcomfirmTellerBalance_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/comfirmTellerBalance.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
if(true && (isUserBalanced == true)) {
printHtmlPart(7)
expressionOut.print(msgContent)
printHtmlPart(8)
}
else {
printHtmlPart(9)
expressionOut.print(msgContent)
printHtmlPart(10)
}
printHtmlPart(11)
loop:{
int i = 0
for( txnTellerB in (txnBalanceTeller) ) {
printHtmlPart(12)
expressionOut.print(txnTellerB?.currency?.name)
printHtmlPart(13)
invokeTag('formatNumber','g',45,['format':("###,###,##0.00"),'number':(txnTellerB?.cashIn)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(txnTellerB?.cashOut)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',47,['format':("###,###,##0.00"),'number':(txnTellerB?.cashIn - txnTellerB?.cashOut)],-1)
printHtmlPart(15)
if(true && (txnTellerB?.isBalance == true)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',64,['class':("index"),'action':("index"),'controller':("tellering")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',67,[:],1)
printHtmlPart(24)
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
