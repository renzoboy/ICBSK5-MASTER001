import icbs.lov.LoanFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanPerformanceClassificationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanPerformanceClassification/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'loanPerformanceClassification.label', default: 'LoanPerformanceClassification'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/loanPerformanceClassification'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',18,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',42,['code':("loanPerformanceClassification.code.label"),'default':("Code")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',45,['bean':(loanPerformanceClassificationInstance),'field':("code")],-1)
printHtmlPart(14)
invokeTag('message','g',50,['code':("loanPerformanceClassification.name.label"),'default':("Name")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',53,['bean':(loanPerformanceClassificationInstance),'field':("name")],-1)
printHtmlPart(15)
invokeTag('message','g',58,['code':("loanPerformanceClassification.prevClassification.label"),'default':("Previous Classification")],-1)
printHtmlPart(13)
expressionOut.print(loanPerformanceClassificationInstance?.prevClassification?.description)
printHtmlPart(15)
invokeTag('message','g',66,['code':("loanPerformanceClassification.newClassification.label"),'default':("New Classification")],-1)
printHtmlPart(13)
expressionOut.print(loanPerformanceClassificationInstance?.newClassification?.description)
printHtmlPart(14)
invokeTag('message','g',74,['code':("loanPerformanceClassification.type.label"),'default':("Type")],-1)
printHtmlPart(13)
expressionOut.print(loanPerformanceClassificationInstance?.type?.description)
printHtmlPart(16)
if(true && (loanPerformanceClassificationInstance.type.id == 1)) {
printHtmlPart(17)
invokeTag('message','g',83,['code':("loanPerformanceClassification.thresholdAmount.label"),'default':("Threshold Amount")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',86,['bean':(loanPerformanceClassificationInstance),'field':("thresholdAmount")],-1)
printHtmlPart(16)
}
else if(true && (loanPerformanceClassificationInstance.type.id == 2)) {
printHtmlPart(17)
invokeTag('message','g',93,['code':("loanPerformanceClassification.thresholdFreq.label"),'default':("Threshold Frequency")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',96,['bean':(loanPerformanceClassificationInstance),'field':("thresholdFreq")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',102,['code':("loanPerformanceClassification.status.label"),'default':("Status")],-1)
printHtmlPart(13)
expressionOut.print(loanPerformanceClassificationInstance?.status?.description)
printHtmlPart(20)
for( product in (loanPerformanceClassificationInstance?.products) ) {
printHtmlPart(21)
expressionOut.print(product?.name)
printHtmlPart(22)
}
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',125,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',127,['class':("list"),'action':("index")],3)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',128,['action':("edit"),'controller':("loanPerformanceClassification"),'id':(loanPerformanceClassificationInstance.id)],3)
printHtmlPart(28)
if(true && (loanPerformanceClassificationInstance.status.id == 1)) {
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
invokeTag('actionSubmit','g',135,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(31)
})
invokeTag('form','g',136,['url':([controller:loanPerformanceClassification, id:loanPerformanceClassificationInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (loanPerformanceClassificationInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
invokeTag('actionSubmit','g',140,['action':("delete"),'value':("Delete"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(31)
})
invokeTag('form','g',140,['url':([controller:loanPerformanceClassification, id:loanPerformanceClassificationInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(34)
}
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',140,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',140,[:],1)
printHtmlPart(36)
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
