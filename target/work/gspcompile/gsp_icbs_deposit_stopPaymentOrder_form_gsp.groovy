import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_stopPaymentOrder_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/stopPaymentOrder/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("id"),'value':(stopPaymentOrderInstance?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['name':("deposit.id"),'value':(stopPaymentOrderInstance?.deposit?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'chequeNo', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',12,['code':("stopPaymentOrder.chequeNo.label"),'default':("Cheque No")],-1)
printHtmlPart(4)
if(true && (edit)) {
printHtmlPart(5)
invokeTag('textField','g',17,['disabled':("disabled"),'id':("cheque"),'name':("cheque.id"),'value':(stopPaymentOrderInstance?.cheque?.chequeNo),'class':("form-control")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('textField','g',20,['id':("chequeNo"),'name':("chequeNo"),'value':(stopPaymentOrderInstance?.cheque?.chequeNo),'class':("form-control")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',26,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',27,['bean':(stopPaymentOrderInstance),'field':("chequeNo")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',30,['bean':(stopPaymentOrderInstance),'field':("chequeNo")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'chkPayee', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',35,['code':("stopPaymentOrder.chkPayee.label"),'default':("Chk Payee")],-1)
printHtmlPart(14)
invokeTag('textField','g',38,['name':("chkPayee"),'maxlength':("50"),'value':(stopPaymentOrderInstance?.chkPayee),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',44,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',45,['bean':(stopPaymentOrderInstance),'field':("chkPayee")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',48,['bean':(stopPaymentOrderInstance),'field':("chkPayee")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'chkDate', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',55,['code':("stopPaymentOrder.chkDate.label"),'default':("Chk Date")],-1)
printHtmlPart(14)
invokeTag('customDatePicker','g',58,['name':("chkDate"),'precision':("day"),'class':("form-control"),'value':(stopPaymentOrderInstance?.chkDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',64,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',65,['bean':(stopPaymentOrderInstance),'field':("chkDate")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',68,['bean':(stopPaymentOrderInstance),'field':("chkDate")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'chkAmt', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',75,['code':("stopPaymentOrder.chkAmt.label"),'default':("Chk Amt")],-1)
printHtmlPart(14)
invokeTag('field','g',78,['name':("chkAmt"),'value':(fieldValue(bean: stopPaymentOrderInstance, field: 'chkAmt')),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',84,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',85,['bean':(stopPaymentOrderInstance),'field':("chkAmt")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',88,['bean':(stopPaymentOrderInstance),'field':("chkAmt")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'ref', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',94,['code':("stopPaymentOrder.ref.label"),'default':("Reference")],-1)
printHtmlPart(14)
invokeTag('textField','g',97,['name':("ref"),'maxlength':("50"),'value':(stopPaymentOrderInstance?.ref),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',103,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',104,['bean':(stopPaymentOrderInstance),'field':("ref")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',107,['bean':(stopPaymentOrderInstance),'field':("ref")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'remarks', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',113,['code':("stopPaymentOrder.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(14)
invokeTag('textArea','g',116,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(stopPaymentOrderInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',122,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',123,['bean':(stopPaymentOrderInstance),'field':("remarks")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',126,['bean':(stopPaymentOrderInstance),'field':("remarks")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: stopPaymentOrderInstance, field: 'status', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',131,['code':("stopPaymentOrder.status.label"),'default':("Status")],-1)
printHtmlPart(14)
invokeTag('select','g',134,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(stopPaymentOrderInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',140,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',141,['bean':(stopPaymentOrderInstance),'field':("status")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',144,['bean':(stopPaymentOrderInstance),'field':("status")],1)
printHtmlPart(23)
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
