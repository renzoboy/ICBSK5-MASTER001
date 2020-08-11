import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_txnInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_txnInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(txnTemplateInstance?.codeDescription)
printHtmlPart(1)
expressionOut.print(txnFileInstance?.txnDate)
printHtmlPart(2)
expressionOut.print(txnFileInstance?.txnAmt)
printHtmlPart(3)
expressionOut.print(txnFileInstance.txnType.description)
printHtmlPart(4)
expressionOut.print(txnFileInstance.acctNo)
printHtmlPart(5)
expressionOut.print(txnFileInstance.branch?.name)
printHtmlPart(1)
expressionOut.print(txnFileInstance.txnDate.format('MM/dd/yyyy'))
printHtmlPart(2)
invokeTag('formatNumber','g',11,['number':(txnFileInstance.txnAmt),'format':("###,##0.00")],-1)
printHtmlPart(6)
expressionOut.print(txnFileInstance.txnCode)
printHtmlPart(7)
expressionOut.print(txnFileInstance.txnDescription)
printHtmlPart(8)
expressionOut.print(txnFileInstance.txnRef)
printHtmlPart(9)
expressionOut.print(txnFileInstance.txnParticulars)
printHtmlPart(10)
expressionOut.print(txnFileInstance.status.description)
printHtmlPart(11)
expressionOut.print(txnFileInstance.user?.username)
printHtmlPart(12)
if(true && (senderInstance)) {
printHtmlPart(13)
expressionOut.print(senderInstance.displayName)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (senderInstance)) {
printHtmlPart(13)
expressionOut.print(senderInstance.birthDate)
printHtmlPart(14)
}
printHtmlPart(16)
invokeTag('set','g',31,['var':("address"),'value':(senderInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(13)
if(true && (address)) {
printHtmlPart(17)
expressionOut.print(address?.address1)
printHtmlPart(18)
expressionOut.print(address?.address2)
printHtmlPart(18)
expressionOut.print(address?.address3)
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
if(true && ((senderInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(22)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (senderInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (beneficiaryInstance)) {
printHtmlPart(13)
expressionOut.print(beneficiaryInstance.displayName)
printHtmlPart(14)
}
printHtmlPart(25)
if(true && (beneficiaryInstance)) {
printHtmlPart(13)
expressionOut.print(beneficiaryInstance.birthDate)
printHtmlPart(14)
}
printHtmlPart(26)
invokeTag('set','g',55,['var':("address"),'value':(beneficiaryInstance?.addresses?.find{it.isPrimary==true})],-1)
printHtmlPart(13)
if(true && (address)) {
printHtmlPart(17)
expressionOut.print(address?.address1)
printHtmlPart(18)
expressionOut.print(address?.address2)
printHtmlPart(18)
expressionOut.print(address?.address3)
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(27)
if(true && ((beneficiaryInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(22)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (beneficiaryInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(23)
}
printHtmlPart(28)
expressionOut.print(txnFileInstance?.txnParticulars)
printHtmlPart(29)
expressionOut.print(txnFileInstance?.txnRef)
printHtmlPart(10)
expressionOut.print(txnFileInstance?.status.description)
printHtmlPart(30)
expressionOut.print(indicator)
printHtmlPart(31)
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
