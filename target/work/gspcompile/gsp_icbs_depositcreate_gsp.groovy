import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'deposit.label', default: 'Deposit'))],-1)
printHtmlPart(1)
invokeTag('javascript','asset',7,['src':("depositHelper.js")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller : 'deposit', action:'changeRolloverFormAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'changeDepositFormAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller : 'deposit', action:'changeDepositFormAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'deposit', action:'addSignatoryFormAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'deposit', action:'showDepositDetailsAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(12)
})
invokeTag('javascript','g',209,[:],2)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',211,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('captureContent','sitemesh',215,['tag':("breadcrumbs")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(21)
createTagBody(4, {->
printHtmlPart(22)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(23)
expressionOut.print(error.field)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('message','g',230,['error':(error)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',231,['bean':(depositInstance),'var':("error")],4)
printHtmlPart(27)
})
invokeTag('hasErrors','g',233,['bean':(depositInstance)],3)
printHtmlPart(28)
if(true && (firstCreate==true)) {
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
invokeTag('hiddenField','g',237,['name':("firstCreate"),'value':(firstCreate)],-1)
printHtmlPart(31)
invokeTag('render','g',241,['template':("form/deposit/typeAndProduct")],-1)
printHtmlPart(32)
})
invokeTag('form','g',244,['id':("saveDepositForm"),'url':([controller:'deposit',action:'create']),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(28)
}
else {
printHtmlPart(33)
createTagBody(4, {->
printHtmlPart(34)
invokeTag('hiddenField','g',248,['name':("firstCreate"),'value':(firstCreate)],-1)
printHtmlPart(35)
invokeTag('render','g',250,['template':("form")],-1)
printHtmlPart(36)
})
invokeTag('form','g',252,['id':("saveDepositForm"),'url':([resource:depositInstance,controller:'deposit', action:'save']),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(28)
}
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',255,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(38)
if(true && (!firstCreate)) {
printHtmlPart(39)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(40)
expressionOut.print(message(code: 'default.button.create.label', default: 'Create'))
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',281,['tag':("main-actions")],2)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',282,[:],1)
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
