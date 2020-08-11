import icbs.gl.GlContigentAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'ContigentAccount.label', default: 'Contigent Account'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
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
invokeTag('sortableColumn','g',37,['property':("id"),'title':(message(code: 'GlContigentAccount.id.label', default: 'ID'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',38,['property':("txnDate"),'title':(message(code: 'GlContigentAccount.txnDate.label', default: 'Transaction Date'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',39,['property':("accountNo"),'title':(message(code: 'GlContigentAccount.contigentId.label', default: 'Account Number'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',40,['property':("particulars"),'title':(message(code: 'GlContigentAccount.particulars.label', default: 'Particulars'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',41,['property':("currentCustodian"),'title':(message(code: 'GlContigentAccount.particulars.label', default: 'Current Custodian'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( ContigentInstance in (GlContigentAccountList) ) {
printHtmlPart(19)
if(true && (ContigentInstance?.status?.description=='Active')) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
expressionOut.print(fieldValue(bean: ContigentInstance, field: "id"))
printHtmlPart(23)
invokeTag('formatDate','g',50,['format':("MM/dd/yyyy"),'date':(ContigentInstance.txnDate)],-1)
printHtmlPart(24)
expressionOut.print(ContigentInstance.accountNo)
printHtmlPart(24)
expressionOut.print(ContigentInstance.particulars)
printHtmlPart(24)
expressionOut.print(ContigentInstance.currentCustodian)
printHtmlPart(25)
createClosureForHtmlPart(26, 5)
invokeTag('link','g',55,['class':("btn btn-secondary"),'controller':("GlContAcct"),'action':("viewDetails"),'id':(ContigentInstance.id)],5)
printHtmlPart(27)
}
printHtmlPart(28)
i++
}
}
printHtmlPart(29)
invokeTag('paginate','g',64,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-content")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',71,['action':("createcontigent")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(35)
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
