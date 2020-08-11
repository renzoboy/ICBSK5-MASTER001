import icbs.admin.GlConfigSettings
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glConfigSettingsindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glConfigSettings/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glConfigSettings.label', default: 'glConfigSettings'))],-1)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',17,['code':("glConfigSettings.currency.label"),'default':("Currency:")],-1)
printHtmlPart(9)
invokeTag('fieldValue','g',18,['bean':(glConfigSettings),'field':("currency")],-1)
printHtmlPart(10)
invokeTag('message','g',24,['code':("glConfigSettings.taxMonthEnd.label"),'default':("Tax Month End:")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',25,['bean':(glConfigSettings),'field':("taxMonthEnd")],-1)
printHtmlPart(12)
invokeTag('message','g',31,['code':("glConfigSettings.glSortCodeMask.label"),'default':("GL Sort Code Mask:")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',32,['bean':(glConfigSettings),'field':("glSortCodeMask")],-1)
printHtmlPart(14)
invokeTag('message','g',38,['code':("glConfigSettings.glAccountCodeMask.label"),'default':("GL Account Code Mask:")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',39,['bean':(glConfigSettings),'field':("glAccountCodeMask")],-1)
printHtmlPart(16)
invokeTag('message','g',45,['code':("glConfigSettings.revaluationPolicy.label"),'default':("Revaluation Policy:")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',46,['bean':(glConfigSettings),'field':("revaluationPolicy")],-1)
printHtmlPart(18)
invokeTag('message','g',52,['code':("glConfigSettings.errorAccount.label"),'default':("Error Account:")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',53,['bean':(glConfigSettings),'field':("errorAccount")],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',58,['class':("btn btn-primary edit"),'action':("edit")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',61,[:],1)
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
