import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_ropaSaleInstForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/_ropaSaleInstForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("loanID"),'name':("loanID"),'value':(ropaInstance?.loan)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("loanLedger.loan.label"),'default':("SCR Account")],-1)
printHtmlPart(3)
invokeTag('field','g',8,['name':("accountNo"),'value':(ropaInstance?.loan),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(it)
printHtmlPart(6)
})
invokeTag('hasErrors','g',19,['bean':(loanLedgerInstance),'field':("loan")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'loan', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',26,['name':("loanAccountName"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.loan?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',32,['bean':(ropaInstance),'field':("loan")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',35,['bean':(ropaInstance),'field':("loan")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ciName', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',40,['code':("creditInvestigation.ciName.label"),'default':("Granted Amount")],-1)
printHtmlPart(16)
invokeTag('field','g',42,['name':("xxxGranted"),'id':("xxxGranted"),'value':(""),'disabled':("disable"),'class':("form-control truncated")],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',49,['bean':(ropaInstance),'field':("ciName")],2)
printHtmlPart(21)
})
invokeTag('hasErrors','g',52,['bean':(ropaInstance),'field':("ciName")],1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ciName', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',57,['code':("creditInvestigation.ciName.label"),'default':("Product")],-1)
printHtmlPart(16)
invokeTag('field','g',59,['name':("productName"),'id':("productName"),'value':(""),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('message','g',65,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',66,['bean':(ropaInstance),'field':("productName")],2)
printHtmlPart(21)
})
invokeTag('hasErrors','g',69,['bean':(ropaInstance),'field':("productName")],1)
printHtmlPart(23)
invokeTag('hiddenField','g',72,['name':("id"),'id':("id"),'value':(params?.id)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',73,['name':("loanApplication"),'id':("loanApplication"),'value':(params?.id)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(24)
invokeTag('select','g',77,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.get(icbs.admin.Institution.findByParamCode("GLS.60630").paramValue.toInteger())),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'sellingPrice', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',82,['code':("ropaSale.sellingPrice.label"),'default':("Selling Price")],-1)
printHtmlPart(26)
invokeTag('field','g',84,['name':("sellingPrice"),'id':("sellingPrice"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',90,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',91,['bean':(collateralInstance),'field':("sellingPrice")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',94,['bean':(collateralInstance),'field':("sellingPrice")],1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'downPayment', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',100,['code':("ropaSale.downPayment.label"),'default':("Down Payment")],-1)
printHtmlPart(34)
invokeTag('field','g',102,['name':("downPayment"),'id':("downPayment"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',107,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',108,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',109,['bean':(collateralInstance),'field':("downPayment")],1)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'scrDiscount', 'has-error'))
printHtmlPart(36)
invokeTag('message','g',117,['code':("ropaSale.scrDiscount.label"),'default':("SCR Discount")],-1)
printHtmlPart(34)
invokeTag('field','g',119,['name':("scrDiscount"),'id':("scrDiscount"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',124,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',125,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',127,['bean':(collateralInstance),'field':("scrDiscount")],1)
printHtmlPart(37)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error'))
printHtmlPart(38)
invokeTag('message','g',136,['code':("ropaSale.commission.label"),'default':("Commission")],-1)
printHtmlPart(34)
invokeTag('field','g',138,['name':("commission"),'id':("commission"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',143,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',144,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',145,['bean':(collateralInstance),'field':("commission")],1)
printHtmlPart(39)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error'))
printHtmlPart(40)
invokeTag('message','g',153,['code':("ropaSale.commission.label"),'default':("Agent")],-1)
printHtmlPart(34)
invokeTag('select','g',157,['id':("agent"),'name':("agent.id"),'from':(icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',162,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',163,['bean':(collateralInstance),'field':("Agent")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',167,['bean':(collateralInstance),'field':("Agent")],1)
printHtmlPart(41)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error'))
printHtmlPart(38)
invokeTag('message','g',172,['code':("ropaSale.commission.label"),'default':("Reference")],-1)
printHtmlPart(34)
invokeTag('field','g',174,['name':("reference"),'id':("reference"),'value':(""),'class':("form-control")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',179,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',180,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',183,['bean':(collateralInstance),'field':("reference")],1)
printHtmlPart(42)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error'))
printHtmlPart(38)
invokeTag('message','g',189,['code':("ropaSale.commission.label"),'default':("Particulars")],-1)
printHtmlPart(34)
invokeTag('textArea','g',189,['name':("particulars"),'id':("particulars"),'value':(""),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',194,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',195,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',196,['bean':(collateralInstance),'field':("particulars")],1)
printHtmlPart(43)
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
