import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/edit.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'deposit.label', default: 'Deposit'))],-1)
printHtmlPart(1)
invokeTag('javascript','asset',8,['src':("depositHelper.js")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller : 'deposit', action:'changeRolloverFormAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'addSignatoryFormAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'deposit', action:'showDepositDetailsAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(11)
})
invokeTag('javascript','g',89,[:],2)
printHtmlPart(12)
})
invokeTag('captureHead','sitemesh',90,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('captureContent','sitemesh',94,['tag':("breadcrumbs")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
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
invokeTag('message','g',109,['error':(error)],-1)
printHtmlPart(26)
})
invokeTag('eachError','g',110,['bean':(depositInstance),'var':("error")],4)
printHtmlPart(27)
})
invokeTag('hasErrors','g',112,['bean':(depositInstance)],3)
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(28)
invokeTag('hiddenField','g',115,['name':("version"),'value':(depositInstance?.version)],-1)
printHtmlPart(29)
invokeTag('render','g',117,['template':("form")],-1)
printHtmlPart(30)
})
invokeTag('form','g',119,['id':("saveDepositForm"),'url':([resource:depositInstance, action:'update']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-content")],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(32)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(33)
expressionOut.print(depositInstance?.id)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',141,['tag':("main-actions")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',143,[:],1)
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
