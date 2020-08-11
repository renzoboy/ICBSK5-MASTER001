import icbs.admin.TxnTemplate
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnTemplateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnTemplate/show.gsp" }
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
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'txnTemplate.label', default: 'TxnTemplate'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri:'/txnTemplate'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',15,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (txnTemplateInstance?.txnModule)) {
printHtmlPart(12)
expressionOut.print(txnTemplateInstance?.txnModule?.description)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.txnType)) {
printHtmlPart(15)
expressionOut.print(txnTemplateInstance?.txnType?.description)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.code)) {
printHtmlPart(16)
invokeTag('fieldValue','g',51,['bean':(txnTemplateInstance),'field':("code")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.description)) {
printHtmlPart(17)
invokeTag('fieldValue','g',57,['bean':(txnTemplateInstance),'field':("description")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.shortDescription)) {
printHtmlPart(18)
invokeTag('fieldValue','g',63,['bean':(txnTemplateInstance),'field':("shortDescription")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.minAmt)) {
printHtmlPart(19)
invokeTag('fieldValue','g',69,['bean':(txnTemplateInstance),'field':("minAmt")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.maxAmt)) {
printHtmlPart(20)
invokeTag('fieldValue','g',75,['bean':(txnTemplateInstance),'field':("maxAmt")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.amlaCode)) {
printHtmlPart(21)
invokeTag('fieldValue','g',81,['bean':(txnTemplateInstance),'field':("amlaCode")],-1)
printHtmlPart(13)
}
printHtmlPart(22)
if(true && (txnTemplateInstance?.defContraAcct)) {
printHtmlPart(23)
invokeTag('fieldValue','g',87,['bean':(txnTemplateInstance),'field':("defContraAcct")],-1)
printHtmlPart(24)
expressionOut.print(GlAccount.findByCode(txnTemplateInstance?.defContraAcct).name)
printHtmlPart(13)
}
printHtmlPart(25)
if(true && (txnTemplateInstance?.requireTxnReference)) {
printHtmlPart(26)
invokeTag('fieldValue','g',97,['bean':(txnTemplateInstance),'field':("requireTxnReference")],-1)
printHtmlPart(13)
}
printHtmlPart(27)
if(true && (txnTemplateInstance?.validationCopyNo)) {
printHtmlPart(28)
invokeTag('fieldValue','g',103,['bean':(txnTemplateInstance),'field':("validationCopyNo")],-1)
printHtmlPart(13)
}
printHtmlPart(29)
if(true && (txnTemplateInstance?.validationFormCode)) {
printHtmlPart(30)
invokeTag('fieldValue','g',109,['bean':(txnTemplateInstance),'field':("validationFormCode")],-1)
printHtmlPart(13)
}
printHtmlPart(31)
if(true && (txnTemplateInstance?.currency)) {
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(txnTemplateInstance?.currency?.name)
})
invokeTag('link','g',115,['controller':("currency"),'action':("show"),'id':(txnTemplateInstance?.currency?.id)],4)
printHtmlPart(13)
}
printHtmlPart(29)
if(true && (txnTemplateInstance?.requirePassbook)) {
printHtmlPart(33)
expressionOut.print(txnTemplateInstance?.requirePassbook?.description)
printHtmlPart(13)
}
printHtmlPart(34)
if(true && (txnTemplateInstance?.atmOnlyTxn)) {
printHtmlPart(35)
expressionOut.print(txnTemplateInstance?.atmOnlyTxn?.description)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.interbranchTxn)) {
printHtmlPart(36)
expressionOut.print(txnTemplateInstance?.interbranchTxn?.description)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.systemOnlyTxn)) {
printHtmlPart(37)
invokeTag('formatBoolean','g',139,['boolean':(txnTemplateInstance?.systemOnlyTxn)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (txnTemplateInstance?.memoTxnType)) {
printHtmlPart(38)
expressionOut.print(txnTemplateInstance?.memoTxnType?.description)
printHtmlPart(13)
}
printHtmlPart(27)
if(true && (txnTemplateInstance?.batchTxn)) {
printHtmlPart(39)
expressionOut.print(txnTemplateInstance?.batchTxn?.description)
printHtmlPart(13)
}
printHtmlPart(29)
if(true && (txnTemplateInstance?.configItemStatus)) {
printHtmlPart(40)
expressionOut.print(txnTemplateInstance?.configItemStatus?.description)
printHtmlPart(13)
}
printHtmlPart(41)
for( charge in (txnTemplateInstance.charges) ) {
printHtmlPart(42)
expressionOut.print(charge.description)
printHtmlPart(43)
}
printHtmlPart(44)
createClosureForHtmlPart(45, 3)
invokeTag('form','g',179,['url':([resource:txnTemplateInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',181,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(47)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(48)
invokeTag('message','g',184,['code':("default.home.label")],-1)
printHtmlPart(49)
createClosureForHtmlPart(50, 3)
invokeTag('link','g',185,['class':("edit"),'action':("updateTxnTemplate"),'id':(txnTemplateInstance?.id)],3)
printHtmlPart(51)
createClosureForHtmlPart(52, 3)
invokeTag('link','g',186,['action':("create")],3)
printHtmlPart(51)
createTagBody(3, {->
invokeTag('message','g',187,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',187,['class':("list"),'action':("index")],3)
printHtmlPart(53)
})
invokeTag('captureContent','sitemesh',190,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',191,[:],1)
printHtmlPart(54)
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
