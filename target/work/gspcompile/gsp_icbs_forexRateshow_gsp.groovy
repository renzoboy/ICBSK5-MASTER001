import icbs.admin.ForexRate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_forexRateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/forexRate/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'forexRate.label', default: 'ForexRate'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/forexRate'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(forexRateInstance?.currency?.name)
})
invokeTag('link','g',38,['controller':("currency"),'action':("show"),'id':(forexRateInstance?.currency?.id)],3)
printHtmlPart(12)
invokeTag('formatDate','g',42,['format':("MM/dd/yyyy"),'date':(forexRateInstance.txnDate)],-1)
printHtmlPart(13)
invokeTag('formatNumber','g',46,['format':("###,###,##0.00"),'number':(forexRateInstance?.rate)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',50,['format':("###,###,##0.00"),'number':(forexRateInstance?.pdsRate)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',54,['format':("###,###,##0.00"),'number':(forexRateInstance?.historicalRate)],-1)
printHtmlPart(16)
if(true && (forexRateInstance?.refRate)) {
printHtmlPart(17)
invokeTag('formatNumber','g',59,['format':("###,###,##0.00"),'number':(forexRateInstance?.refRate)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (forexRateInstance?.buyRate1)) {
printHtmlPart(20)
invokeTag('formatNumber','g',65,['format':("###,###,##0.00"),'number':(forexRateInstance?.buyRate1)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (forexRateInstance?.buyRate2)) {
printHtmlPart(21)
invokeTag('formatNumber','g',71,['format':("###,###,##0.00"),'number':(forexRateInstance?.buyRate2)],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (forexRateInstance?.buyRate3)) {
printHtmlPart(23)
invokeTag('formatNumber','g',77,['format':("###,###,##0.00"),'number':(forexRateInstance?.buyRate3)],-1)
printHtmlPart(18)
}
printHtmlPart(24)
if(true && (forexRateInstance?.buyRate4)) {
printHtmlPart(25)
invokeTag('formatNumber','g',83,['format':("###,###,##0.00"),'number':(forexRateInstance?.buyRate4)],-1)
printHtmlPart(18)
}
printHtmlPart(26)
if(true && (forexRateInstance?.buyRate5)) {
printHtmlPart(27)
invokeTag('formatNumber','g',89,['format':("###,###,##0.00"),'number':(forexRateInstance?.buyRate5)],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (forexRateInstance?.sellRate1)) {
printHtmlPart(28)
invokeTag('formatNumber','g',95,['format':("###,###,##0.00"),'number':(forexRateInstance?.sellRate1)],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (forexRateInstance?.sellRate2)) {
printHtmlPart(29)
invokeTag('formatNumber','g',101,['format':("###,###,##0.00"),'number':(forexRateInstance?.sellRate2)],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (forexRateInstance?.sellRate3)) {
printHtmlPart(30)
invokeTag('formatNumber','g',107,['format':("###,###,##0.00"),'number':(forexRateInstance?.sellRate3)],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (forexRateInstance?.sellRate4)) {
printHtmlPart(31)
invokeTag('formatNumber','g',113,['format':("###,###,##0.00"),'number':(forexRateInstance?.sellRate4)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (forexRateInstance?.sellRate5)) {
printHtmlPart(32)
invokeTag('formatNumber','g',119,['format':("###,###,##0.00"),'number':(forexRateInstance?.sellRate5)],-1)
printHtmlPart(18)
}
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
invokeTag('actionSubmit','g',128,['class':("hidden"),'id':("deleteforexRate"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete'))],-1)
printHtmlPart(35)
})
invokeTag('form','g',130,['url':([resource:forexRateInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-content")],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(39)
invokeTag('message','g',135,['code':("default.home.label")],-1)
printHtmlPart(40)
createTagBody(3, {->
invokeTag('message','g',136,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',136,['class':("list"),'action':("index")],3)
printHtmlPart(41)
createTagBody(3, {->
invokeTag('message','g',137,['code':("default.newupdate.label"),'args':([entityName]),'default':("New Forex Rate")],-1)
})
invokeTag('link','g',137,['class':("create"),'action':("create")],3)
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',138,['action':("edit"),'id':(forexRateInstance.id)],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',153,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',154,[:],1)
printHtmlPart(44)
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
