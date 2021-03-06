import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceviewAtmTxnFile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/viewAtmTxnFile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
for( branchInstance in (aa) ) {
printHtmlPart(8)
invokeTag('message','g',26,['code':("atmTerminalInstance.branch.label"),'default':("id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "id"))
printHtmlPart(10)
invokeTag('message','g',30,['code':("atmTerminalInstance.branch.label"),'default':("Account No")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "acctNo"))
printHtmlPart(11)
invokeTag('message','g',34,['code':("atmTerminalInstance.branch.label"),'default':("Account Status")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "acctStatusId"))
printHtmlPart(12)
invokeTag('message','g',38,['code':("atmTerminalInstance.branch.label"),'default':("Beneficiary id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "beneficiaryId"))
printHtmlPart(13)
invokeTag('message','g',42,['code':("atmTerminalInstance.branch.label"),'default':("Branch id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "branchId"))
printHtmlPart(13)
invokeTag('message','g',46,['code':("atmTerminalInstance.branch.label"),'default':("CHD:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "chd"))
printHtmlPart(13)
invokeTag('message','g',50,['code':("atmTerminalInstance.branch.label"),'default':("Currency id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "currencyId"))
printHtmlPart(13)
invokeTag('message','g',54,['code':("atmTerminalInstance.branch.label"),'default':("Deposit Account Id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "depAcctId"))
printHtmlPart(13)
invokeTag('message','g',58,['code':("atmTerminalInstance.branch.label"),'default':("Gl Account id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "glAcctId"))
printHtmlPart(14)
invokeTag('message','g',62,['code':("atmTerminalInstance.branch.label"),'default':("Loan Account id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "loanAcctId"))
printHtmlPart(15)
invokeTag('message','g',66,['code':("atmTerminalInstance.branch.label"),'default':("Sender id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "senderId"))
printHtmlPart(11)
invokeTag('message','g',70,['code':("atmTerminalInstance.branch.label"),'default':("Status id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "statusId"))
printHtmlPart(16)
invokeTag('message','g',74,['code':("atmTerminalInstance.branch.label"),'default':("Txn Amt:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnAmt"))
printHtmlPart(17)
invokeTag('message','g',78,['code':("atmTerminalInstance.branch.label"),'default':("Txn Code")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnCode"))
printHtmlPart(17)
invokeTag('message','g',82,['code':("atmTerminalInstance.branch.label"),'default':("Txn Date")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnDate"))
printHtmlPart(17)
invokeTag('message','g',86,['code':("atmTerminalInstance.branch.label"),'default':("Txn Description")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnDescription"))
printHtmlPart(18)
invokeTag('message','g',91,['code':("atmTerminalInstance.branch.label"),'default':("Txn Particulars:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnParticulars"))
printHtmlPart(17)
invokeTag('message','g',95,['code':("atmTerminalInstance.branch.label"),'default':("Txn Ref:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnRef"))
printHtmlPart(17)
invokeTag('message','g',99,['code':("atmTerminalInstance.branch.label"),'default':("Txn Template id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnTemplateId"))
printHtmlPart(17)
invokeTag('message','g',103,['code':("atmTerminalInstance.branch.label"),'default':("Txn Timestamp:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnTimestamp"))
printHtmlPart(17)
invokeTag('message','g',107,['code':("atmTerminalInstance.branch.label"),'default':("Txn Type:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnType"))
printHtmlPart(17)
invokeTag('message','g',111,['code':("atmTerminalInstance.branch.label"),'default':("User id:")],-1)
printHtmlPart(9)
expressionOut.print(fieldValue(bean: branchInstance, field: "userId"))
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',128,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',128,['class':("create"),'action':("create")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',130,['action':("atmTerminalView")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(26)
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
