import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanaccountTypeValidator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/accountTypeValidator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'loan', action:'applicationCollectInformation'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'ropa', action:'search'))
printHtmlPart(10)
expressionOut.print(loanApplication?.id)
printHtmlPart(11)
})
invokeTag('javascript','g',115,[:],3)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',123,['name':("id"),'id':("id"),'value':(params?.id)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',126,['code':("loan.loanApplication.label"),'default':("Account Application ")],-1)
printHtmlPart(19)
invokeTag('field','g',129,['name':("loanApplication"),'id':("loanApplication"),'type':("number"),'value':(loanInstance?.loanApplication?.id),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(22)
invokeTag('message','g',134,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',135,['bean':(loanInstance),'field':("loanApplication")],5)
printHtmlPart(24)
})
invokeTag('hasErrors','g',138,['bean':(loanInstance),'field':("loanApplication")],4)
printHtmlPart(25)
if(true && (!reschedule)) {
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('form','g',181,['id':("create"),'url':([controller:'ropa', action:'saveRopaSaleCash']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',183,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
invokeTag('message','g',187,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',187,['action':("ropaForSale")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',189,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',190,[:],1)
printHtmlPart(31)
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
