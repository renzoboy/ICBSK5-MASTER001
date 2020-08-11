import icbs.deposit.DocInventory
import icbs.deposit.Passbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryviewSaPbDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/viewSaPbDetails.gsp" }
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
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'docInventory.label', default: 'DocInventory'))],-1)
printHtmlPart(3)
if(true && (docInventoryInstance?.type?.id == 2)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',10,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],3)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (docInventoryInstance?.type?.id == 4)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(5, 4)
invokeTag('captureTitle','sitemesh',13,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],3)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (docInventoryInstance?.type?.id == 5)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(6, 4)
invokeTag('captureTitle','sitemesh',16,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',16,[:],3)
printHtmlPart(3)
}
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(createLink(uri: '/docInventory'))
printHtmlPart(10)
})
invokeTag('captureContent','sitemesh',23,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(docInventoryInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',43,['controller':("branch"),'action':("show"),'id':(docInventoryInstance?.branch?.id)],3)
printHtmlPart(16)
expressionOut.print(docInventoryInstance?.type?.encodeAsHTML())
printHtmlPart(17)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(18)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(19)
expressionOut.print(docInventoryInstance?.usageCount)
printHtmlPart(20)
expressionOut.print(docInventoryInstance?.docParticulars)
printHtmlPart(21)
expressionOut.print(docInventoryInstance?.checkAcctNo)
printHtmlPart(22)
invokeTag('formatBoolean','g',71,['boolean':(docInventoryInstance?.isCanceled)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',75,['format':("yyyy-MM-dd"),'date':(docInventoryInstance?.canceledAt)],-1)
printHtmlPart(24)
createTagBody(3, {->
expressionOut.print(docInventoryInstance?.canceledBy?.encodeAsHTML())
})
invokeTag('link','g',79,['controller':("userMaster"),'action':("show"),'id':(docInventoryInstance?.canceledBy?.username)],3)
printHtmlPart(25)
expressionOut.print(docInventoryInstance?.status?.encodeAsHTML())
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
if(true && (docInventoryInstance?.type?.id == 2)) {
printHtmlPart(28)
invokeTag('hiddenField','g',90,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(29)
}
printHtmlPart(29)
if(true && (docInventoryInstance?.type?.id == 4)) {
printHtmlPart(30)
invokeTag('hiddenField','g',93,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(29)
}
printHtmlPart(29)
if(true && (docInventoryInstance?.type?.id == 5)) {
printHtmlPart(30)
invokeTag('hiddenField','g',96,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(29)
}
printHtmlPart(31)
invokeTag('select','g',101,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit(${docInventoryInstance.id})")],-1)
printHtmlPart(32)
expressionOut.print(params?.query)
printHtmlPart(33)
invokeTag('submitButton','g',107,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(34)
})
invokeTag('form','g',111,['name':("PbDetails"),'url':([action:'viewDetails',controller:'DocInventory'])],3)
printHtmlPart(35)
loop:{
int i = 0
for( pb in (pbInstance) ) {
printHtmlPart(36)
expressionOut.print(pb?.issuePassbook?.deposit?.acctNo)
printHtmlPart(37)
expressionOut.print(pb?.issuePassbook?.deposit?.acctName)
printHtmlPart(37)
expressionOut.print(pb?.passbookNo)
printHtmlPart(37)
invokeTag('formatDate','g',126,['date':(pb?.issuePassbook?.dateIssued),'type':("date"),'style':("LONG")],-1)
printHtmlPart(37)
expressionOut.print(pb?.status?.description)
printHtmlPart(38)
i++
}
}
printHtmlPart(39)
invokeTag('paginate','g',132,['total':(pbInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',137,['tag':("main-content")],2)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',140,['class':("list"),'action':("index")],3)
printHtmlPart(44)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',141,['class':("create"),'action':("create")],3)
printHtmlPart(46)
createClosureForHtmlPart(47, 3)
invokeTag('link','g',142,['action':("show"),'id':(docInventoryInstance.id)],3)
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',144,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',145,[:],1)
printHtmlPart(49)
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
