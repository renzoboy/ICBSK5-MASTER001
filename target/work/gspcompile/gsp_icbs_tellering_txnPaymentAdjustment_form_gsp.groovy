import icbs.tellering.TxnFile
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnPaymentAdjustment_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnPaymentAdjustment/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("OtherCashPaymentAdjustment"),'name':("OtherCashPaymentAdjustment"),'value':("0")],-1)
printHtmlPart(1)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByMemoTxnTypeAndTxnType(icbs.lov.MemoTxnType.read(1), icbs.lov.TxnType.read(21),[sort:"code", order:"asc"])) ) {
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(4)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(hasErrors(bean: txnPaymentAdjustmentInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(7)
invokeTag('textField','g',43,['type':("number"),'id':("txnAmt"),'name':("txnAmt"),'required':(""),'value':(txnPaymentAdjustmentInstance?.txnAmt),'class':("form-control truncated")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnPaymentAdjustmentInstance, field: 'txnRef', 'has-error'))
printHtmlPart(9)
invokeTag('textArea','g',51,['name':("txnRef"),'required':(""),'value':(txnPaymentAdjustmentInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: txnPaymentAdjustmentInstance, field: 'txnParticulars', 'has-error'))
printHtmlPart(11)
invokeTag('textArea','g',59,['name':("txnParticulars"),'value':(txnPaymentAdjustmentInstance?.txnParticulars),'class':("form-control")],-1)
printHtmlPart(12)
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
