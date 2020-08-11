import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBank_cibCheckTransaction_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/_cibCheckTransaction.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(1)
invokeTag('select','g',4,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(44),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'checkNo', 'has-error'))
printHtmlPart(3)
invokeTag('textField','g',10,['name':("checkNo"),'id':("checkNo"),'required':(""),'value':(cashInBankCheckbookInstance?.checkNo),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',15,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',16,['bean':(cashInBankCheckbookInstance),'field':("checkNo")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',19,['bean':(cashInBankCheckbookInstance),'field':("checkNo")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'reference', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',25,['name':("reference"),'required':(""),'value':(cashInBankCheckbookInstance?.reference),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',30,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',31,['bean':(cashInBankCheckbookInstance),'field':("reference")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',34,['bean':(cashInBankCheckbookInstance),'field':("reference")],1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'checkVoucherNo', 'has-error'))
printHtmlPart(11)
invokeTag('textField','g',40,['name':("checkVoucherNo"),'id':("checkVoucherNo"),'required':(""),'value':(cashInBankCheckbookInstance?.checkVoucherNo),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',45,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',46,['bean':(cashInBankCheckbookInstance),'field':("checkVoucherNo")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',49,['bean':(cashInBankCheckbookInstance),'field':("checkVoucherNo")],1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'checkDate', 'has-error'))
printHtmlPart(12)
invokeTag('customDatePicker','g',59,['name':("checkDate"),'precision':("day"),'class':("form-control"),'value':(cashInBankCheckbookInstance?.openDate)],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',65,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',66,['bean':(cashInBankCheckbookInstance),'field':("checkDate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',69,['bean':(cashInBankCheckbookInstance),'field':("checkDate")],1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'payee', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',75,['name':("payee"),'required':(""),'value':(cashInBankCheckbookInstance?.payee),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',80,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',81,['bean':(cashInBankCheckbookInstance),'field':("payee")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',84,['bean':(cashInBankCheckbookInstance),'field':("payee")],1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'particulars', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',90,['name':("particulars"),'id':("particulars"),'required':(""),'value':(cashInBankCheckbookInstance?.particulars),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',95,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',96,['bean':(cashInBankCheckbookInstance),'field':("particulars")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',99,['bean':(cashInBankCheckbookInstance),'field':("particulars")],1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: cashInBankCheckbookInstance, field: 'checkAmt', 'has-error'))
printHtmlPart(16)
invokeTag('field','g',107,['class':("form-control truncated"),'name':("checkAmt"),'value':(cashInBankCheckbookInstance?.checkAmt)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',112,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',113,['bean':(cashInBankCheckbookInstance),'field':("checkAmt")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',116,['bean':(cashInBankCheckbookInstance),'field':("checkAmt")],1)
printHtmlPart(17)
invokeTag('hiddenField','g',1,['id':("cashInBankInstanceChkT"),'name':("cashInBankInstanceChkT"),'value':(params.id)],-1)
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
