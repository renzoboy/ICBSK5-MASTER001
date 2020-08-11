import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnInquiry2view_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnInquiry2/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'tellering', action:'showTxnAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'tellering', action:'search'))
printHtmlPart(6)
})
invokeTag('javascript','g',47,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(8, 2)
invokeTag('captureContent','sitemesh',52,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(txnFileInstance.txnType.description)
printHtmlPart(13)
expressionOut.print(txnTemplateInstance.acctNo)
printHtmlPart(14)
expressionOut.print(txnTemplateInstance.branch.name)
printHtmlPart(15)
expressionOut.print(txnFileInstance.txnDate)
printHtmlPart(16)
expressionOut.print(txnFileInstance.txnAmt)
printHtmlPart(17)
expressionOut.print(txnFileInstance.txnCode)
printHtmlPart(18)
expressionOut.print(txnFileInstance.txnTemplate.description)
printHtmlPart(19)
expressionOut.print(txnFileInstance.txnRef)
printHtmlPart(20)
expressionOut.print(txnFileInstance.txnParticulars)
printHtmlPart(21)
expressionOut.print(txnFileInstance.status.description)
printHtmlPart(22)
expressionOut.print(txnFileInstance.user.userName)
printHtmlPart(23)
if(true && (senderInstance)) {
printHtmlPart(24)
expressionOut.print(senderInstance.displayName)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (senderInstance)) {
printHtmlPart(24)
expressionOut.print(senderInstance.birthDate)
printHtmlPart(25)
}
printHtmlPart(27)
invokeTag('set','g',162,['var':("address"),'value':(senderInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(25)
if(true && (address)) {
printHtmlPart(24)
expressionOut.print(address?.address1)
printHtmlPart(28)
expressionOut.print(address?.address2)
printHtmlPart(28)
expressionOut.print(address?.address3)
printHtmlPart(29)
}
else {
printHtmlPart(30)
}
invokeTag('set','g',170,['var':("address"),'value':(senderInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(25)
if(true && (address)) {
printHtmlPart(24)
expressionOut.print(address?.address1)
printHtmlPart(28)
expressionOut.print(address?.address2)
printHtmlPart(28)
expressionOut.print(address?.address3)
printHtmlPart(29)
}
else {
printHtmlPart(30)
}
printHtmlPart(31)
if(true && ((senderInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(32)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (senderInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (beneficiaryInstance)) {
printHtmlPart(24)
expressionOut.print(beneficiaryInstance.displayName)
printHtmlPart(25)
}
printHtmlPart(35)
if(true && (beneficiaryInstance)) {
printHtmlPart(24)
expressionOut.print(beneficiaryInstance.birthDate)
printHtmlPart(25)
}
printHtmlPart(36)
invokeTag('set','g',216,['var':("address"),'value':(beneficiaryInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(25)
if(true && (address)) {
printHtmlPart(24)
expressionOut.print(address?.address1)
printHtmlPart(28)
expressionOut.print(address?.address2)
printHtmlPart(28)
expressionOut.print(address?.address3)
printHtmlPart(29)
}
else {
printHtmlPart(30)
}
printHtmlPart(37)
if(true && ((beneficiaryInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(32)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (beneficiaryInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(33)
}
printHtmlPart(38)
expressionOut.print(indicator)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',280,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',284,['onclick':("createReport")],3)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',285,['action':("takeAction"),'params':([isApproved:true, txnFileInstanceId:txnFileInstance.id])],3)
printHtmlPart(42)
createClosureForHtmlPart(44, 3)
invokeTag('link','g',286,['action':("takeAction"),'params':([isApproved:false]),'resource':(txnFileInstance)],3)
printHtmlPart(42)
createClosureForHtmlPart(45, 3)
invokeTag('link','g',287,['action':("index"),'onclick':("return confirm('Are you sure you want to return to tellering index Page?');")],3)
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',289,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',290,[:],1)
printHtmlPart(47)
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
