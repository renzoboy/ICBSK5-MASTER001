import icbs.tellering.TxnDepositAcctLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnFDPreTermination_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnFDPreTermination/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("FDDepID"),'name':("FDDepID")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByConfigItemStatusAndTxnType(icbs.lov.ConfigItemStatus.read(2),icbs.lov.TxnType.read(18),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.requirePassbook)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(5)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (!txnFDPreTerminationInstance?.acct)) {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('render','g',48,['template':("/tellering/details/depositDetails"),'model':([depositInstance:txnFDPreTerminationInstance?.acct])],-1)
printHtmlPart(10)
if(true && (txnFDPreTerminationInstance?.acct)) {
printHtmlPart(11)
invokeTag('render','g',50,['template':("/tellering/details/signatureDetails"),'model':([depositInstance:txnFDPreTerminationInstance?.acct])],-1)
printHtmlPart(11)
invokeTag('render','g',51,['template':("/tellering/details/signatoryDetails"),'model':([depositInstance:txnFDPreTerminationInstance?.acct])],-1)
printHtmlPart(10)
}
printHtmlPart(12)
expressionOut.print(hasErrors(bean: txnFDPreTerminationInstance, field: 'passbookBal', 'has-error'))
printHtmlPart(13)
invokeTag('textField','g',59,['type':("number"),'id':("FDpassbookBalAmt"),'name':("passbookBal"),'required':(""),'disabled':("disabled"),'value':(txnFDPreTerminationInstance?.passbookBal),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnFDPreTerminationInstance, field: 'debitAmt', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',69,['type':("number"),'id':("FDwithdraw"),'disabled':("disabled"),'name':("debitAmt"),'readOnly':("true"),'required':(""),'value':(txnFDPreTerminationInstance?.debitAmt),'class':("form-control")],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: txnFDPreTerminationInstance, field: 'txnRef', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',76,['code':("txnFDPreTermination.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(18)
invokeTag('textArea','g',79,['name':("txnRef"),'required':(""),'value':(txnFDPreTerminationInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(19)
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
