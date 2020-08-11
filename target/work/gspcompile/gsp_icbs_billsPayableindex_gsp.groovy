import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayableindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',10,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',18,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',22,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width:500px;"),'placeholder':("Search")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',24,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',26,['class':("form-inline")],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',33,['property':("accountName"),'title':(message(code: 'billsPayable.accountName.label', default: 'Account Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',34,['property':("creditorName"),'title':(message(code: 'billsPayable.creditorName.label', default: 'Creditor Name'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',35,['property':("dateOpened"),'title':(message(code: 'billsPayable.dateOpened.label', default: 'Date Opened'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',36,['property':("dueDate"),'title':(message(code: 'billsPayable.dueDate.date', default: 'Due Date'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',37,['property':("pnNo"),'title':(message(code: 'billsPayable.pnNo.label', default: 'Pn No'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("currency"),'title':(message(code: 'billsPayable.currency.label', default: 'Currency'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',39,['property':("pricipal"),'title':(message(code: 'billsPayable.prncipal.label', default: 'Principal'))],-1)
printHtmlPart(18)
loop:{
int i = 0
for( billsPayableInstance in (billsPayableInstanceList) ) {
printHtmlPart(17)
if(true && (billsPayableInstance?.status.id == 2)) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
expressionOut.print(billsPayableInstance?.branch?.name)
printHtmlPart(21)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(21)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(21)
invokeTag('formatDate','g',50,['format':("MM/dd/yyyy"),'date':(billsPayableInstance?.dateOpened)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',51,['format':("MM/dd/yyyy"),'date':(billsPayableInstance?.dueDate)],-1)
printHtmlPart(21)
expressionOut.print(billsPayableInstance?.pnNo)
printHtmlPart(21)
expressionOut.print(billsPayableInstance?.currency?.code)
printHtmlPart(21)
invokeTag('formatNumber','g',54,['format':("###,###,##0.00"),'number':(billsPayableInstance?.principal)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 5)
invokeTag('link','g',55,['class':("btn btn-secondary"),'action':("show"),'id':(billsPayableInstance.id)],5)
printHtmlPart(23)
}
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',63,['total':(billsPayableInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',66,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',70,['controller':("home"),'action':("landing")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',71,['controller':("billsPayable"),'action':("create")],3)
printHtmlPart(30)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',72,['controller':("home"),'action':("landing")],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(34)
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
