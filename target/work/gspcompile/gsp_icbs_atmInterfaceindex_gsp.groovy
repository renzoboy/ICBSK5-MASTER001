import icbs.atm.AtmTxn
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'AtmTxn.label', default: 'ATM Interface'))],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('captureContent','sitemesh',19,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('select','g',30,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(14)
invokeTag('textField','g',34,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 150px;"),'placeholder':("Search")],-1)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('submitButton','g',36,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(17)
})
invokeTag('form','g',38,['class':("form-inline")],3)
printHtmlPart(18)
invokeTag('sortableColumn','g',45,['property':("txnDate"),'title':(message(code: 'AtmTxn.txnDate.label', default: 'Txn Date'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',47,['property':("mti"),'title':(message(code: 'AtmTxn.mti.label', default: 'MTI'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',49,['property':("acct1"),'title':(message(code: 'AtmTxn.acct1.label', default: 'Acct1'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',51,['property':("atmCardNumber"),'title':(message(code: 'AtmTxn.atmCardNumber.label', default: 'Atm Card Number'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',53,['property':("txnCode"),'title':(message(code: 'AtmTxn.txnCode.label', default: 'Txn Code'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',55,['property':("txnAmt"),'title':(message(code: 'AtmTxn.txnAmt.label', default: 'Txn Amt'))],-1)
printHtmlPart(21)
invokeTag('sortableColumn','g',57,['property':("txnRef"),'title':(message(code: 'AtmTxn.txnRef.label', default: 'Txn Ref'))],-1)
printHtmlPart(22)
loop:{
int i = 0
for( branchInstance in (atmTxnListInstance) ) {
printHtmlPart(23)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(24)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnDate"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: branchInstance, field: "mti"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: branchInstance, field: "acct1"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: branchInstance, field: "atmCardNumber"))
printHtmlPart(26)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnCode"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnAmt"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnRef"))
printHtmlPart(28)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',82,['class':("btn btn-primary"),'controller':("ATMInterface"),'action':("viewAtmInterface"),'id':(branchInstance.id),'params':(['atmtxnid': branchInstance.id])],4)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
invokeTag('paginate','g',89,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',92,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',98,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',98,['class':("create"),'action':("create")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',100,['action':("atmTerminalView")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',102,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',103,[:],1)
printHtmlPart(37)
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
