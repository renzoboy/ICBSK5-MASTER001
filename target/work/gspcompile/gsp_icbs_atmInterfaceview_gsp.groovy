import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
loop:{
int i = 0
for( branchInstance in (atmTxnInstanceList) ) {
printHtmlPart(7)
invokeTag('message','g',22,['code':("atmTerminalInstance.branch.label"),'default':("id:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "id"))
printHtmlPart(9)
invokeTag('message','g',26,['code':("atmTerminalInstance.branch.label"),'default':("Account1:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "acct1"))
printHtmlPart(10)
invokeTag('message','g',30,['code':("atmTerminalInstance.branch.label"),'default':("Account2:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "acct2"))
printHtmlPart(11)
invokeTag('message','g',34,['code':("atmTerminalInstance.branch.label"),'default':("Atm Card Number:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "atmCardNumber"))
printHtmlPart(11)
invokeTag('message','g',38,['code':("atmTerminalInstance.branch.label"),'default':("Atm Terminal:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "atmTerminal"))
printHtmlPart(12)
invokeTag('message','g',42,['code':("atmTerminalInstance.branch.label"),'default':("Balance1:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "bal1"))
printHtmlPart(12)
invokeTag('message','g',46,['code':("atmTerminalInstance.branch.label"),'default':("Balance2:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "bal2"))
printHtmlPart(12)
invokeTag('message','g',50,['code':("atmTerminalInstance.branch.label"),'default':("Is Revesed:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "isReversed"))
printHtmlPart(13)
invokeTag('message','g',54,['code':("atmTerminalInstance.branch.label"),'default':("MTI:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "mti"))
printHtmlPart(14)
invokeTag('message','g',58,['code':("atmTerminalInstance.branch.label"),'default':("Request Message id:")],-1)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',60,['class':("btn-info"),'controller':("ATMInterface"),'action':("viewAtmMsgRequest"),'id':(branchInstance.requestMsgId),'params':(['atmtxnid': branchInstance.requestMsgId])],4)
printHtmlPart(10)
invokeTag('message','g',63,['code':("atmTerminalInstance.branch.label"),'default':("Response Date:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "responseDate"))
printHtmlPart(17)
invokeTag('message','g',67,['code':("atmTerminalInstance.branch.label"),'default':("Response Message id:")],-1)
printHtmlPart(18)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',69,['class':("btn-info"),'controller':("ATMInterface"),'action':("viewAtmMsgResponse"),'id':(branchInstance.responseMsgId),'params':(['atmtxnid': branchInstance.responseMsgId])],4)
printHtmlPart(19)
invokeTag('message','g',72,['code':("atmTerminalInstance.branch.label"),'default':("Reversal Date:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "reversalDate"))
printHtmlPart(19)
invokeTag('message','g',76,['code':("atmTerminalInstance.branch.label"),'default':("Status id:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "statusId"))
printHtmlPart(19)
invokeTag('message','g',80,['code':("atmTerminalInstance.branch.label"),'default':("Txn Amt:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnAmt"))
printHtmlPart(19)
invokeTag('message','g',84,['code':("atmTerminalInstance.branch.label"),'default':("Txn Charge Amt:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnChargeAmt"))
printHtmlPart(19)
invokeTag('message','g',88,['code':("atmTerminalInstance.branch.label"),'default':("Txn Code:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnCode"))
printHtmlPart(19)
invokeTag('message','g',92,['code':("atmTerminalInstance.branch.label"),'default':("Txn Date:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnDate"))
printHtmlPart(19)
invokeTag('message','g',96,['code':("atmTerminalInstance.branch.label"),'default':("Txn File1:")],-1)
printHtmlPart(20)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',97,['class':("btn-info"),'controller':("ATMInterface"),'action':("viewAtmTxnFile"),'id':(branchInstance.txnFile1),'params':(['atmtxnid': branchInstance.txnFile1])],4)
printHtmlPart(19)
invokeTag('message','g',100,['code':("atmTerminalInstance.branch.label"),'default':("Txn File2:")],-1)
printHtmlPart(20)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',101,['class':("btn-info"),'controller':("ATMInterface"),'action':("viewAtmTxnFile"),'id':(branchInstance.txnFile2),'params':(['atmtxnid': branchInstance.txnFile2])],4)
printHtmlPart(19)
invokeTag('message','g',104,['code':("atmTerminalInstance.branch.label"),'default':("Txn Ref:")],-1)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: branchInstance, field: "txnRef"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',112,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',119,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',119,['class':("create"),'action':("create")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',121,['action':("atmTerminalView")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(28)
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
