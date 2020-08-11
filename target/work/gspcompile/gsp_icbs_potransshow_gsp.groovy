import accounting.bankpayables.AccountsPayables
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_potransshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/potrans/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'accountsPayables.label', default: 'accountsPayables'))],-1)
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
expressionOut.print(createLink(uri: '/potrans'))
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
if(true && (accountsPayablesInstance?.reference)) {
printHtmlPart(12)
invokeTag('message','g',25,['code':("payables.reference.label"),'default':("Reference")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',27,['bean':(accountsPayablesInstance),'field':("reference")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (accountsPayablesInstance?.amount)) {
printHtmlPart(16)
invokeTag('message','g',34,['code':("payables.amount.label"),'default':("Amount")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',36,['bean':(accountsPayablesInstance),'field':("amount")],-1)
printHtmlPart(14)
}
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('actionSubmit','g',45,['class':("btn btn-primary"),'action':("update"),'value':(message(code: 'default.button.Disburse.label', default: 'Disburse'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',47,['url':([resource:accountsPayablesInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',49,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',52,['code':("default.newupdate.label"),'args':([entityName]),'default':("New AP")],-1)
})
invokeTag('link','g',52,['class':("create"),'action':("create")],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',53,['action':("edit"),'id':(accountsPayablesInstance.id)],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',55,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(27)
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
