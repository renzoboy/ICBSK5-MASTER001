import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckReceiptAdjustment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckReceiptAdjustment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',3,['id':("CashReceiptCheckAdjustment"),'name':("CashReceiptCheckAdjustment"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(20), icbs.lov.MemoTxnType.read(1),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(hasErrors(bean: txnCheckReceiptAdjustmentInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(7)
invokeTag('textField','g',19,['type':("number"),'name':("txnAmt"),'required':(""),'value':(txnCheckReceiptAdjustmentInstance?.txnAmt),'class':("form-control truncated"),'onkeyup':("updateVar()")],-1)
printHtmlPart(8)
if(true && (txnCOCIInstance?.checks)) {
printHtmlPart(9)
for( check in (txnCOCIInstance?.checks.sort{it.description}) ) {
printHtmlPart(10)
expressionOut.print(check?.checkType?.description)
printHtmlPart(11)
expressionOut.print(check?.bank?.name)
printHtmlPart(11)
expressionOut.print(check?.acctNo)
printHtmlPart(11)
expressionOut.print(check?.checkDate)
printHtmlPart(11)
expressionOut.print(check?.checkNo)
printHtmlPart(11)
expressionOut.print(check?.checkAmt)
printHtmlPart(12)
expressionOut.print(check?.id)
printHtmlPart(13)
}
printHtmlPart(14)
}
else if(true && (session["checks"])) {
printHtmlPart(9)
invokeTag('set','g',57,['var':("i"),'value':(0)],-1)
printHtmlPart(9)
for( check in (session["checks"]) ) {
printHtmlPart(10)
expressionOut.print(check?.checkType?.description)
printHtmlPart(11)
expressionOut.print(check?.bank?.name)
printHtmlPart(11)
expressionOut.print(check?.acctNo)
printHtmlPart(11)
expressionOut.print(check?.checkDate)
printHtmlPart(11)
expressionOut.print(check?.checkNo)
printHtmlPart(11)
expressionOut.print(check?.checkAmt)
printHtmlPart(12)
expressionOut.print(i)
printHtmlPart(15)
invokeTag('set','g',70,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(9)
}
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(hasErrors(bean: txnCheckReceiptAdjustmentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(18)
invokeTag('textArea','g',81,['name':("txnRef"),'required':(""),'value':(txnCheckReceiptAdjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: txnCheckReceiptAdjustmentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(20)
invokeTag('textArea','g',89,['name':("txnParticulars"),'maxlength':("100"),'value':(txnCheckReceiptAdjustmentInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(21)
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
