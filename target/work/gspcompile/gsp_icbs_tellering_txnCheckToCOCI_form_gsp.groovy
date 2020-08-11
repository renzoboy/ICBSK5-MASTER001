import icbs.tellering.TxnCOCI
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCheckToCOCI_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCheckToCOCI/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( txnTemplateInstance in (icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(22),[sort:"code", order:"asc"])) ) {
printHtmlPart(1)
expressionOut.print(txnTemplateInstance.id)
printHtmlPart(2)
expressionOut.print(txnTemplateInstance.code)
printHtmlPart(3)
expressionOut.print(txnTemplateInstance.codeDescription)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: txnCheckToCOCIInstance, field: 'totalChecks', 'has-error'))
printHtmlPart(6)
invokeTag('message','g',18,['code':("txnCheckToCOCI.totalChecks.label"),'default':("Total Checks")],-1)
printHtmlPart(7)
invokeTag('textField','g',22,['name':("totalChecks"),'value':("0.00"),'class':("form-control truncated")],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',32,['property':("id"),'title':(message(code: 'txnCOCI.id.label', default: 'ID'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',34,['property':("checkType"),'title':(message(code: 'txnCOCI.checkType.label', default: 'Check Type'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',36,['property':("bank"),'title':(message(code: 'txnCOCI.bank.label', default: 'Bank'))],-1)
printHtmlPart(10)
invokeTag('message','g',38,['code':("txnCOCI.acctNo.label"),'default':("Account No.")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',40,['property':("checkDate"),'title':(message(code: 'txnCOCI.checkDate.label', default: 'Check Date'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',42,['property':("checkNo"),'title':(message(code: 'txnCOCI.checkNo.label', default: 'Check No.'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',44,['property':("clearingDate"),'title':(message(code: 'txnCOCI.clearingDate.label', default: 'Clearing Date'))],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',46,['property':("checkAmt"),'align':("right"),'title':(message(code: 'txnCOCI.checkAmt.label', default: 'Amount'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',47,['property':("txnCheckStatus"),'title':("pos")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( txnCOCIInstance in (TxnCOCIList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
expressionOut.print(txnCOCIInstance.id)
printHtmlPart(17)
expressionOut.print(txnCOCIInstance.checkType.description)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "bank.name"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "acctNo"))
printHtmlPart(17)
invokeTag('formatDate','g',68,['format':("yyyy-MM-dd"),'date':(txnCOCIInstance.checkDate)],-1)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "checkNo"))
printHtmlPart(19)
invokeTag('formatDate','g',73,['format':("yyyy-MM-dd"),'date':(txnCOCIInstance.clearingDate)],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "checkAmt"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: txnCOCIInstance, field: "txnCheckStatus.description"))
printHtmlPart(21)
if(true && (txnCOCIInstance.txnCheckStatus == icbs.lov.TxnCheckStatus.get(2))) {
printHtmlPart(22)
invokeTag('checkBox','g',80,['onclick':("btnCompute()"),'name':("cleared"),'value':(txnCOCIInstance.id),'checked':("false")],-1)
printHtmlPart(23)
}
else {
printHtmlPart(24)
invokeTag('checkBox','g',84,['onclick':("btnCompute()"),'name':("cleared"),'value':(txnCOCIInstance.id),'checked':("false"),'style':("display:none")],-1)
printHtmlPart(25)
invokeTag('checkBox','g',86,['onclick':("btnCompute()"),'name':("cleared"),'value':(txnCOCIInstance.id),'checked':("false"),'disabled':("disabled")],-1)
printHtmlPart(23)
}
printHtmlPart(26)
invokeTag('checkBox','g',91,['name':("cleared"),'value':(txnCOCIInstance?.cleared),'checked':("false"),'onclick':(remoteFunction(action:'toggleCheckStatus', id:txnCOCIInstance.id, params:'\'cleared=\' + this.checked'))],-1)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
expressionOut.print(hasErrors(bean: txnCheckToCOCIInstance, field: 'txnAmt', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',102,['code':("txnCheckToCOCI.txnAmt.label"),'default':("Check Control Total")],-1)
printHtmlPart(7)
invokeTag('field','g',106,['id':("txnAmt"),'name':("txnAmt"),'disabled':(""),'value':("0.00"),'class':("form-control")],-1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: txnCheckToCOCIInstance, field: 'txnRef', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',112,['code':("txnCheckToCOCI.txnRef.label"),'default':("Transaction Reference")],-1)
printHtmlPart(7)
invokeTag('textArea','g',116,['name':("txnRef"),'value':(txnCheckToCOCIInstance?.txnRef),'class':("form-control")],-1)
printHtmlPart(32)
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
