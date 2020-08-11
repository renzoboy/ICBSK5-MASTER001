import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inwardCheckClearingview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inwardCheckClearing/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(2)
createClosureForHtmlPart(4, 2)
invokeTag('javascript','g',31,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',36,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('render','g',57,['template':("inwardCheckClearing/form"),'model':("")],-1)
printHtmlPart(13)
})
invokeTag('uploadForm','g',58,['name':("inwardCheckClearingForm"),'action':("viewInwardCheckClearing"),'controller':("deposit"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
loop:{
int i = 0
for( check in (domainInstance?.checks) ) {
printHtmlPart(16)
invokeTag('hiddenField','g',75,['name':("checks[${i}].chequeNo"),'value':(check?.chequeNo)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',76,['name':("checks[${i}].amt"),'value':(check?.amt)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',77,['name':("checks[${i}].brstn"),'value':(check?.brstn)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',78,['name':("checks[${i}].trancd"),'value':(check?.trancd)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',79,['name':("checks[${i}].acctNo"),'value':(check?.acctNo)],-1)
printHtmlPart(18)
expressionOut.print(i + 1)
printHtmlPart(19)
expressionOut.print(check?.acctNo)
printHtmlPart(19)
expressionOut.print(check?.chequeNo)
printHtmlPart(19)
invokeTag('formatNumber','g',83,['format':("###,###,##0.00"),'number':(check?.amt)],-1)
printHtmlPart(19)
expressionOut.print(check?.brstn)
printHtmlPart(19)
expressionOut.print(check?.trancd)
printHtmlPart(20)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',90,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',91,['bean':(domainInstance),'field':("checks[${i}].acctNo")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',93,['bean':(domainInstance),'field':("checks[${i}].acctNo")],5)
printHtmlPart(25)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',98,['bean':(domainInstance),'field':("checks[${i}].chequeNo")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',100,['bean':(domainInstance),'field':("checks[${i}].chequeNo")],5)
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',104,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',105,['bean':(domainInstance),'field':("checks[${i}].amt")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',107,['bean':(domainInstance),'field':("checks[${i}].amt")],5)
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',111,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',112,['bean':(domainInstance),'field':("checks[${i}].brstn")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',114,['bean':(domainInstance),'field':("checks[${i}].brstn")],5)
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(21)
createTagBody(6, {->
printHtmlPart(22)
invokeTag('message','g',118,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',119,['bean':(domainInstance),'field':("checks[${i}].trancd")],6)
printHtmlPart(24)
})
invokeTag('hasErrors','g',121,['bean':(domainInstance),'field':("checks[${i}].trancd")],5)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
})
invokeTag('uploadForm','g',127,['name':("processInwardCheckingForm"),'action':("processInwardCheckClearing"),'controller':("deposit"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',129,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(30)
expressionOut.print(disabledProcessing)
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',133,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',133,['action':("index")],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',136,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',139,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',140,[:],1)
printHtmlPart(35)
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
