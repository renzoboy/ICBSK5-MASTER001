import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsPayableindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsPayable/index.gsp" }
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
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('select','g',25,['name':("max"),'value':(params.max),'from':([5, 10, 15, 25]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(13)
invokeTag('textField','g',28,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Search by Account No or Particulars")],-1)
printHtmlPart(14)
invokeTag('submitButton','g',30,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(15)
})
invokeTag('form','g',36,['url':([action:'index',controller:'accountsPayable']),'method':("POST")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',44,['property':("id"),'title':(message(code: 'accountsPayable.id.label', default: 'ID'))],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',47,['property':("payable"),'title':(message(code: 'accountsPayable.description.label', default: 'Payable'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',48,['property':("bookingDate"),'title':(message(code: 'accountsPayable.bookingDate.label', default: 'Booking date'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',49,['property':("balance"),'title':(message(code: 'accountsPayable.balance.label', default: 'Balance'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',50,['property':("particulars"),'title':(message(code: 'accountsPayable.currency.label', default: 'Particulars'))],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',51,['property':("status"),'title':("Status")],-1)
printHtmlPart(19)
loop:{
int i = 0
for( accountsPayableInstance in (accountsPayableInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(accountsPayableInstance?.id)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance?.acctNo)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance?.branch?.name)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance?.payable)
printHtmlPart(23)
invokeTag('formatDate','g',63,['format':("MM/dd/yyyy"),'date':(accountsPayableInstance.bookingDate)],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(accountsPayableInstance?.balance)],-1)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance?.particulars)
printHtmlPart(22)
expressionOut.print(accountsPayableInstance?.status?.description)
printHtmlPart(22)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',67,['class':("btn btn-info"),'action':("show"),'id':(accountsPayableInstance?.id)],4)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',74,['total':(AccountsPayableInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',80,['controller':("home"),'action':("landing")],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',81,['action':("create")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',82,['action':("printSchedule")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',85,[:],1)
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
