import icbs.gl.BillsPayable
import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayablelinkLoans_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/linkLoans.gsp" }
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
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'billsPayable', action:'deleteLinkLoans'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'billsPayable', action:'validateExistingAssignLoan'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'billsPayable', action:'assignLoan'))
printHtmlPart(9)
})
invokeTag('javascript','g',127,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',128,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(createLink(uri: '/billsPayable'))
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',133,['tag':("breadcrumbs")],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('hiddenField','g',139,['name':("myFarewellID"),'id':("myFarewellID"),'value':(billsPayableInstance?.id)],-1)
printHtmlPart(15)
expressionOut.print(billsPayableInstance?.glContra)
printHtmlPart(16)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(17)
invokeTag('formatDate','g',150,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dateOpened)],-1)
printHtmlPart(18)
invokeTag('formatDate','g',154,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.dueDate)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',158,['format':("MM/dd/yyyy"),'date':(billsPayableInstance.pnDate)],-1)
printHtmlPart(20)
expressionOut.print(billsPayableInstance?.pnNo)
printHtmlPart(21)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(22)
expressionOut.print(billsPayableInstance?.payee)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('hiddenField','g',179,['name':("loanloan"),'id':("loanloan"),'value':(loanInstance?.id)],-1)
printHtmlPart(25)
invokeTag('hiddenField','g',180,['id':("idnibp"),'name':("idnibp"),'value':(params.id)],-1)
printHtmlPart(26)
})
invokeTag('form','g',182,['id':("deposit"),'url':([controller:BillsPayable, action:'assignLoan']),'method':("POST")],3)
printHtmlPart(2)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('hiddenField','g',184,['id':("id"),'name':("id"),'value':(billsPayableInstance.id)],-1)
printHtmlPart(28)
invokeTag('select','g',187,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("submit(${billsPayableInstance.id})")],-1)
printHtmlPart(29)
expressionOut.print(params?.query)
printHtmlPart(30)
invokeTag('submitButton','g',193,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(31)
})
invokeTag('form','g',197,['name':("LinkLoansDetails"),'url':([action:'linkLoans',controller:'BillsPayable'])],3)
printHtmlPart(32)
for( bplli in (billPayableLinkLoansInstance) ) {
printHtmlPart(33)
invokeTag('hiddenField','g',211,['id':("did"),'name':("did"),'value':(bplli?.id)],-1)
printHtmlPart(34)
expressionOut.print(bplli?.billsPayable?.accountName)
printHtmlPart(35)
expressionOut.print(bplli?.loan?.accountNo)
printHtmlPart(35)
invokeTag('formatDate','g',214,['date':(bplli?.linkDate),'type':("date"),'style':("LONG")],-1)
printHtmlPart(35)
expressionOut.print(bplli?.user?.username)
printHtmlPart(35)
expressionOut.print(bplli?.status?.description)
printHtmlPart(36)
expressionOut.print(bplli.id)
printHtmlPart(37)
}
printHtmlPart(38)
invokeTag('paginate','g',222,['total':(billPayableLinkLoansInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',228,['tag':("main-content")],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
createClosureForHtmlPart(42, 3)
invokeTag('link','g',232,['action':("show"),'controller':("billsPayable"),'id':(billsPayableInstance.id)],3)
printHtmlPart(43)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',234,['action':("index"),'controller':("billsPayable")],3)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',236,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',237,[:],1)
printHtmlPart(46)
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
