import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaindexScr_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/indexScr.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
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
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',20,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',24,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 250px;"),'placeholder':("Search By Account No")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',26,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',28,['class':("form-inline"),'url':([action:'indexScr',controller:'ropa']),'method':("POST")],3)
printHtmlPart(15)
loop:{
int i = 0
for( ropaSaleDetailsInstance in (ropaSaleDetailsList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(ropaSaleDetailsInstance?.loan?.accountNo)
printHtmlPart(18)
invokeTag('hiddenField','g',47,['id':("reymartID"),'name':("reymartID"),'value':(ropaSaleDetailsInstance?.collateral.id)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',48,['format':("MM/dd/yyyy"),'date':(ropaSaleDetailsInstance?.txnFile?.txnDate)],-1)
printHtmlPart(20)
expressionOut.print(ropaSaleDetailsInstance?.loan?.customer?.displayName)
printHtmlPart(20)
expressionOut.print(ropaSaleDetailsInstance?.loan?.status?.description)
printHtmlPart(20)
invokeTag('formatNumber','g',51,['format':("###,###,##0.00"),'number':(ropaSaleDetailsInstance?.scrAmount)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(ropaSaleDetailsInstance?.saleAmount)],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',53,['class':("btn btn-secondary"),'controller':("loan"),'action':("show"),'id':(Loan.findByLoanApplication(ropaSaleDetailsInstance?.loanApplication).id)],4)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',60,['total':(ropaSaleDetailsInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',63,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',67,['controller':("home"),'action':("landing")],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',68,['controller':("loanApplication"),'action':("createScr")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',69,['action':("index")],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',70,['action':("ropaForTransfer")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',71,['action':("printRopaSchedule")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',74,[:],1)
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
