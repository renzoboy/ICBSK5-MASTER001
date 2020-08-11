import icbs.deposit.DocInventory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'docInventory.label', default: 'DocInventory'))],-1)
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
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/docInventory'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(docInventoryInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',34,['controller':("branch"),'action':("show"),'id':(docInventoryInstance?.branch?.id)],3)
printHtmlPart(14)
expressionOut.print(docInventoryInstance?.type?.encodeAsHTML())
printHtmlPart(15)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(16)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(17)
expressionOut.print(docInventoryInstance?.usageCount)
printHtmlPart(18)
expressionOut.print(docInventoryInstance?.docParticulars)
printHtmlPart(19)
expressionOut.print(docInventoryInstance?.checkAcctNo)
printHtmlPart(20)
invokeTag('formatBoolean','g',62,['boolean':(docInventoryInstance?.isCanceled)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',66,['format':("yyyy-MM-dd"),'date':(docInventoryInstance?.canceledAt)],-1)
printHtmlPart(22)
createTagBody(3, {->
expressionOut.print(docInventoryInstance?.canceledBy?.encodeAsHTML())
})
invokeTag('link','g',70,['controller':("userMaster"),'action':("show"),'id':(docInventoryInstance?.canceledBy?.username)],3)
printHtmlPart(23)
expressionOut.print(docInventoryInstance?.status?.encodeAsHTML())
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',83,['class':("list"),'action':("index")],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',84,['class':("create"),'action':("create")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',87,['action':("edit"),'id':(docInventoryInstance.id)],3)
printHtmlPart(31)
if(true && (docInventoryInstance.status.id == 1)) {
printHtmlPart(32)
createTagBody(4, {->
printHtmlPart(33)
invokeTag('actionSubmit','g',91,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',92,['url':([id:docInventoryInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (docInventoryInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(32)
createTagBody(4, {->
printHtmlPart(37)
invokeTag('actionSubmit','g',97,['action':("cancel"),'value':("Cancel"),'onclick':("return confirm('${message(code: 'default.button.cancel.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',98,['url':([id:docInventoryInstance.id, action:'cancel']),'method':("POST")],4)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (docInventoryInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(32)
createTagBody(4, {->
printHtmlPart(37)
invokeTag('actionSubmit','g',104,['action':("delete"),'value':("Delete"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(38)
})
invokeTag('form','g',105,['url':([id:docInventoryInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(39)
}
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',108,['action':("viewDetails"),'id':(docInventoryInstance.id)],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',110,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',111,[:],1)
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
