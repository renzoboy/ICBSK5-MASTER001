import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_txnLogindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/txnLog/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',27,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('submitButton','g',29,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(15)
})
invokeTag('form','g',31,['class':("form-inline")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("id"),'title':(message(code: 'txnFile.id.label', default: 'Txn ID'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',40,['property':("acctNo"),'title':(message(code: 'txnFile.acctNo.label', default: 'Account No'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',42,['property':("branch"),'title':(message(code: 'txnFile.branch.label', default: 'Branch'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',44,['property':("user"),'title':(message(code: 'txnFile.user.label', default: 'User'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',46,['property':("txnType"),'title':(message(code: 'txnFile.txnType.label', default: 'Txn Type'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',48,['property':("txnDate"),'title':(message(code: 'txnFile.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',50,['property':("txnParticulars"),'title':(message(code: 'txnFile.txnParticulars.label', default: 'Particulars'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',52,['property':("txnTimestamp"),'title':(message(code: 'txnFile.txnTimestamp.label', default: 'Date/Time Stamp'))],-1)
printHtmlPart(21)
loop:{
int i = 0
for( txnFileInstance in (txnFileInstanceList) ) {
printHtmlPart(22)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(txnFileInstance.id)
})
invokeTag('link','g',60,['action':("txnLogDetails"),'id':(txnFileInstance.id)],4)
printHtmlPart(24)
expressionOut.print(fieldValue(bean: txnFileInstance, field: "acctNo"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: txnFileInstance, field: "branch.name"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: txnFileInstance, field: "user.username"))
printHtmlPart(24)
expressionOut.print(txnFileInstance.txnType.description)
printHtmlPart(26)
invokeTag('formatDate','g',70,['date':(txnFileInstance.txnDate),'format':("MM-dd-yyyy")],-1)
printHtmlPart(26)
expressionOut.print(fieldValue(bean: txnFileInstance, field: "txnParticulars"))
printHtmlPart(24)
expressionOut.print(txnFileInstance.txnTimestamp)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',82,['total':(TxnFileInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',86,['tag':("main-content")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',88,[:],1)
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
