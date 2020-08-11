import icbs.gl.CfgAcctGlTemplateDet
import icbs.lov.DepositStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDetshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(cfgAcctGlTemplateDetInstance?.glDescription.encodeAsHTML())
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (cfgAcctGlTemplateDetInstance?.glAcct)) {
printHtmlPart(11)
invokeTag('message','g',28,['code':("cfgAcctGlTemplateDet.glAcct.label"),'default':("GL Account")],-1)
printHtmlPart(12)
createTagBody(4, {->
expressionOut.print(cfgAcctGlTemplateDetInstance?.glAcct?.shortName.encodeAsHTML())
printHtmlPart(13)
expressionOut.print(cfgAcctGlTemplateDetInstance?.glAcct?.code.encodeAsHTML())
printHtmlPart(14)
})
invokeTag('link','g',31,['controller':("glAccount"),'action':("show"),'id':(cfgAcctGlTemplateDetInstance?.glAcct?.id)],4)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (cfgAcctGlTemplateDetInstance?.glDescription)) {
printHtmlPart(17)
invokeTag('message','g',38,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Description")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',41,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],-1)
printHtmlPart(19)
}
printHtmlPart(16)
if(true && (cfgAcctGlTemplateDetInstance?.glTemplate)) {
printHtmlPart(20)
invokeTag('message','g',48,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Template")],-1)
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(cfgAcctGlTemplateDetInstance?.glTemplate?.description.encodeAsHTML())
})
invokeTag('link','g',51,['controller':("cfgAcctGlTemplate"),'action':("show"),'id':(cfgAcctGlTemplateDetInstance?.glTemplate?.id)],4)
printHtmlPart(19)
}
printHtmlPart(22)
if(true && (cfgAcctGlTemplateDetInstance?.glCode)) {
printHtmlPart(20)
invokeTag('message','g',58,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Gl Code")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',61,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],-1)
printHtmlPart(19)
}
printHtmlPart(24)
if(true && (cfgAcctGlTemplateDetInstance?.ordinalPos)) {
printHtmlPart(20)
invokeTag('message','g',68,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Ordinal Position")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',71,['bean':(cfgAcctGlTemplateDetInstance),'field':("ordinalPos")],-1)
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('message','g',77,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Status")],-1)
printHtmlPart(28)
if(true && (cfgAcctGlTemplateDetInstance?.glTemplate.type==1 || cfgAcctGlTemplateDetInstance?.glTemplate.type==2 || cfgAcctGlTemplateDetInstance?.glTemplate.type==3)) {
printHtmlPart(29)
expressionOut.print(icbs.lov.DepositStatus.findById(cfgAcctGlTemplateDetInstance.status))
printHtmlPart(30)
}
else {
printHtmlPart(31)
expressionOut.print(icbs.lov.LoanPerformanceId.findById(cfgAcctGlTemplateDetInstance.status))
printHtmlPart(30)
}
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',95,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',98,['controller':("CfgAcctGlTemplate"),'action':("show"),'id':(icbs.gl.CfgAcctGlTemplateDet.findById(params.id).glTemplate.id)],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',99,['controller':("CfgAcctGlTemplate"),'action':("glLinkCreateNewEntry"),'id':(icbs.gl.CfgAcctGlTemplateDet.findById(params.id).glTemplate.id)],3)
printHtmlPart(35)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',100,['controller':("CfgAcctGlTemplateDet"),'action':("updatecfgacctdet"),'id':(params.id)],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',102,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',103,[:],1)
printHtmlPart(39)
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
