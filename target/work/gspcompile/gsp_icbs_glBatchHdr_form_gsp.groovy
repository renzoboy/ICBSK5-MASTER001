import icbs.gl.GlBatchHdr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchHdr_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatchHdr/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'contraGl', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("glBatchHdr.contraGl.label"),'default':("Contra Gl")],-1)
printHtmlPart(2)
invokeTag('select','g',11,['id':("contraGl"),'name':("contraGl.id"),'from':(icbs.gl.GlAccount.list()),'optionKey':("id"),'value':(glBatchHdrInstance?.contraGl?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(glBatchHdrInstance),'field':("contraGl")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(glBatchHdrInstance),'field':("contraGl")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'errorGl', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("glBatchHdr.errorGl.label"),'default':("Error Gl")],-1)
printHtmlPart(2)
invokeTag('select','g',31,['id':("errorGl"),'name':("errorGl.id"),'from':(icbs.gl.GlAccount.list()),'optionKey':("id"),'value':(glBatchHdrInstance?.errorGl?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(glBatchHdrInstance),'field':("errorGl")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(glBatchHdrInstance),'field':("errorGl")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'batchType', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("glBatchHdr.batchType.label"),'default':("Batch Type")],-1)
printHtmlPart(2)
invokeTag('textField','g',51,['name':("batchType"),'value':(glBatchHdrInstance?.batchType),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(glBatchHdrInstance),'field':("batchType")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(glBatchHdrInstance),'field':("batchType")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'batchParticulars', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',68,['code':("glBatchHdr.batchParticulars.label"),'default':("Batch Particulars")],-1)
printHtmlPart(2)
invokeTag('textField','g',71,['name':("batchParticulars"),'value':(glBatchHdrInstance?.batchParticulars),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(glBatchHdrInstance),'field':("batchParticulars")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(glBatchHdrInstance),'field':("batchParticulars")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'loanAcct', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',88,['code':("glBatchHdr.loanAcct.label"),'default':("Loan Acct")],-1)
printHtmlPart(2)
invokeTag('select','g',91,['id':("loanAcct"),'name':("loanAcct.id"),'from':(icbs.loans.Loan.list()),'optionKey':("id"),'value':(glBatchHdrInstance?.loanAcct?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',98,['bean':(glBatchHdrInstance),'field':("loanAcct")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',101,['bean':(glBatchHdrInstance),'field':("loanAcct")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'txnType', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',108,['code':("glBatchHdr.txnType.label"),'default':("Txn Type")],-1)
printHtmlPart(2)
invokeTag('textField','g',111,['name':("txnType"),'value':(glBatchHdrInstance?.txnType),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',118,['bean':(glBatchHdrInstance),'field':("txnType")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',121,['bean':(glBatchHdrInstance),'field':("txnType")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'batchCurrency', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',128,['code':("glBatchHdr.batchCurrency.label"),'default':("Batch Currency")],-1)
printHtmlPart(15)
invokeTag('select','g',131,['id':("batchCurrency"),'name':("batchCurrency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'required':(""),'value':(glBatchHdrInstance?.batchCurrency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',137,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',138,['bean':(glBatchHdrInstance),'field':("batchCurrency")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',141,['bean':(glBatchHdrInstance),'field':("batchCurrency")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'batchId', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',148,['code':("glBatchHdr.batchId.label"),'default':("Batch Id")],-1)
printHtmlPart(15)
invokeTag('textField','g',151,['name':("batchId"),'required':(""),'value':(glBatchHdrInstance?.batchId),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',157,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',158,['bean':(glBatchHdrInstance),'field':("batchId")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',161,['bean':(glBatchHdrInstance),'field':("batchId")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'batchName', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',168,['code':("glBatchHdr.batchName.label"),'default':("Batch Name")],-1)
printHtmlPart(15)
invokeTag('textField','g',171,['name':("batchName"),'required':(""),'value':(glBatchHdrInstance?.batchName),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',177,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',178,['bean':(glBatchHdrInstance),'field':("batchName")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',181,['bean':(glBatchHdrInstance),'field':("batchName")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'branch', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',188,['code':("glBatchHdr.branch.label"),'default':("Branch")],-1)
printHtmlPart(15)
invokeTag('select','g',191,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.list()),'optionKey':("id"),'required':(""),'value':(glBatchHdrInstance?.branch?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',197,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',198,['bean':(glBatchHdrInstance),'field':("branch")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',201,['bean':(glBatchHdrInstance),'field':("branch")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'isBalanced', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',208,['code':("glBatchHdr.isBalanced.label"),'default':("Is Balanced")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',211,['name':("isBalanced"),'class':("form-control"),'value':(glBatchHdrInstance?.isBalanced)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',217,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',218,['bean':(glBatchHdrInstance),'field':("isBalanced")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',221,['bean':(glBatchHdrInstance),'field':("isBalanced")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'isLocked', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',228,['code':("glBatchHdr.isLocked.label"),'default':("Is Locked")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',231,['name':("isLocked"),'class':("form-control"),'value':(glBatchHdrInstance?.isLocked)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',237,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',238,['bean':(glBatchHdrInstance),'field':("isLocked")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',241,['bean':(glBatchHdrInstance),'field':("isLocked")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'totalCredit', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',248,['code':("glBatchHdr.totalCredit.label"),'default':("Total Credit")],-1)
printHtmlPart(15)
invokeTag('field','g',251,['name':("totalCredit"),'value':(fieldValue(bean: glBatchHdrInstance, field: 'totalCredit')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',257,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',258,['bean':(glBatchHdrInstance),'field':("totalCredit")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',261,['bean':(glBatchHdrInstance),'field':("totalCredit")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glBatchHdrInstance, field: 'totalDebit', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',268,['code':("glBatchHdr.totalDebit.label"),'default':("Total Debit")],-1)
printHtmlPart(15)
invokeTag('field','g',271,['name':("totalDebit"),'value':(fieldValue(bean: glBatchHdrInstance, field: 'totalDebit')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',277,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',278,['bean':(glBatchHdrInstance),'field':("totalDebit")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',281,['bean':(glBatchHdrInstance),'field':("totalDebit")],1)
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
