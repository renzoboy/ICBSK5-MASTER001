import icbs.deposit.DocInventory
import icbs.deposit.Passbook
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventoryviewChkDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/viewChkDetails.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/docInventory'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',15,['tag':("breadcrumbs")],2)
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
expressionOut.print(docInventoryInstance?.branch?.name.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("branch"),'action':("show"),'id':(docInventoryInstance?.branch?.id)],3)
printHtmlPart(12)
expressionOut.print(docInventoryInstance?.type?.encodeAsHTML())
printHtmlPart(13)
expressionOut.print(docInventoryInstance?.seriesStart)
printHtmlPart(14)
expressionOut.print(docInventoryInstance?.seriesEnd)
printHtmlPart(15)
expressionOut.print(docInventoryInstance?.usageCount)
printHtmlPart(16)
expressionOut.print(docInventoryInstance?.docParticulars)
printHtmlPart(17)
expressionOut.print(docInventoryInstance?.checkAcctNo)
printHtmlPart(18)
invokeTag('formatBoolean','g',63,['boolean':(docInventoryInstance?.isCanceled)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',67,['format':("yyyy-MM-dd"),'date':(docInventoryInstance?.canceledAt)],-1)
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(docInventoryInstance?.canceledBy?.encodeAsHTML())
})
invokeTag('link','g',71,['controller':("userMaster"),'action':("show"),'id':(docInventoryInstance?.canceledBy?.username)],3)
printHtmlPart(21)
expressionOut.print(docInventoryInstance?.status?.encodeAsHTML())
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('hiddenField','g',81,['id':("id"),'name':("id"),'value':(docInventoryInstance.id)],-1)
printHtmlPart(24)
invokeTag('select','g',84,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("submit(${docInventoryInstance.id})")],-1)
printHtmlPart(25)
expressionOut.print(params?.query)
printHtmlPart(26)
invokeTag('submitButton','g',90,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(27)
})
invokeTag('form','g',94,['name':("ChkDetails"),'url':([action:'viewDetails',controller:'DocInventory'])],3)
printHtmlPart(28)
loop:{
int i = 0
for( chk in (chkInstance) ) {
printHtmlPart(29)
expressionOut.print(chk?.chequebook?.deposit?.acctNo)
printHtmlPart(30)
expressionOut.print(chk?.chequebook?.deposit?.acctName)
printHtmlPart(30)
expressionOut.print(chk?.chequeNo)
printHtmlPart(30)
invokeTag('formatDate','g',109,['date':(chk?.chequebook?.dateIssued),'type':("date"),'style':("LONG")],-1)
printHtmlPart(30)
expressionOut.print(chk?.status?.description)
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
invokeTag('paginate','g',117,['total':(chkInstanceCount?: 0),'params':(params)],-1)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-content")],2)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',124,['class':("list"),'action':("index")],3)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',125,['class':("create"),'action':("create")],3)
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',126,['action':("show"),'id':(docInventoryInstance.id)],3)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',128,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(0)
createClosureForHtmlPart(42, 1)
invokeTag('javascript','g',137,[:],1)
printHtmlPart(43)
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
