import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_inwardClearingPointerindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/inwardClearingPointer/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'inwardClearingPointer.label', default: 'InwardClearingPointer'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',34,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',37,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Code or Name")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',39,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
})
invokeTag('form','g',44,[:],3)
printHtmlPart(15)
loop:{
int i = 0
for( InwardClearingPointerInstance in (inwardClearingPointerInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(InwardClearingPointerInstance?.description)
printHtmlPart(18)
expressionOut.print(InwardClearingPointerInstance?.inwardBRSTN)
printHtmlPart(19)
expressionOut.print(InwardClearingPointerInstance?.txnTemplate?.description)
printHtmlPart(20)
expressionOut.print(i)
printHtmlPart(21)
expressionOut.print(InwardClearingPointerInstance?.id)
printHtmlPart(22)
expressionOut.print(createLink(controller:'InwardClearingPointer', action:'deleteInwardClearingPointer'))
printHtmlPart(23)
expressionOut.print(i)
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
invokeTag('hiddenField','g',120,['id':("inwardClearId${i}"),'name':("inwardClearId"),'value':(InwardClearingPointerInstance?.id)],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(27)
invokeTag('textField','g',123,['id':("description${i}"),'name':("description"),'value':(InwardClearingPointerInstance?.description),'class':("form-control")],-1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(29)
invokeTag('textField','g',127,['id':("inwardBRSTN${i}"),'name':("inwardBRSTN"),'value':(InwardClearingPointerInstance?.inwardBRSTN),'class':("form-control")],-1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(30)
invokeTag('select','g',131,['id':("txnTemplatePointer${i}"),'name':("txnTemplatePointer"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(10),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':(InwardClearingPointerInstance?.txnTemplate?.description),'class':("form-control")],-1)
printHtmlPart(31)
expressionOut.print(i)
printHtmlPart(32)
createTagBody(5, {->
printHtmlPart(33)
expressionOut.print(createLink(controller:'InwardClearingPointer', action:'editInwardClearingPointer'))
printHtmlPart(34)
})
invokeTag('javascript','g',197,[:],5)
printHtmlPart(35)
})
invokeTag('form','g',201,['name':("editInwardClearingPointerModal"),'id':("editInwardClearingPointerModal${i}"),'controller':("InwardClearingPointer"),'action':("editInwardClearingPointer")],4)
printHtmlPart(36)
i++
}
}
printHtmlPart(37)
invokeTag('paginate','g',210,['total':(interestIncomeSchemeInstanceCount ?: 0)],-1)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',213,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',217,['class':("icc"),'controller':("deposit"),'action':("viewInwardCheckClearing")],3)
printHtmlPart(41)
createTagBody(3, {->
printHtmlPart(42)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(43)
invokeTag('textField','g',236,['id':("description"),'name':("description"),'value':(""),'class':("form-control")],-1)
printHtmlPart(44)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(45)
invokeTag('textField','g',240,['id':("inwardBRSTN"),'name':("inwardBRSTN"),'value':(""),'class':("form-control")],-1)
printHtmlPart(44)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(46)
invokeTag('select','g',244,['id':("txnTemplatePointer"),'name':("txnTemplatePointer"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(7),icbs.lov.MemoTxnType.read(10),[sort:"code", order:"asc"])),'optionKey':("id"),'optionValue':("description"),'value':("1"),'class':("form-control")],-1)
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('javascript','g',280,[:],4)
printHtmlPart(49)
})
invokeTag('form','g',284,['name':("newInwardClearingPointerFormSend"),'id':("newInwardClearingPointerFormSend"),'controller':("InwardClearingPointer"),'action':("saveInwardClearingPointer")],3)
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',289,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',290,[:],1)
printHtmlPart(51)
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
