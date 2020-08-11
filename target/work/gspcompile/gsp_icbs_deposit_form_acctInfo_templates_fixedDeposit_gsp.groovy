import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_acctInfo_templates_fixedDeposit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/acctInfo/templates/_fixedDeposit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: depositInstance, field: 'acctName', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',13,['code':("deposit.acctName.label"),'default':("Account Name")],-1)
printHtmlPart(4)
invokeTag('field','g',16,['name':("acctName"),'class':("form-control"),'value':(depositInstance?.acctName?:depositInstance?.customer?.displayName)],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',22,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',23,['bean':(depositInstance),'field':("acctName")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',26,['bean':(depositInstance),'field':("acctName")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'depositInterestScheme', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',31,['code':("deposit.depositInterestScheme.label"),'default':("Deposit Interest Scheme")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',34,['id':("depositInterestScheme"),'name':("depositInterestScheme.id"),'value':(depositInstance?.depositInterestScheme?.id)],-1)
printHtmlPart(13)
invokeTag('select','g',35,['id':("depositInterestScheme"),'disabled':("disabled"),'name':("depositInterestScheme.id"),'from':(icbs.deposit.DepositInterestScheme.list()),'optionKey':("id"),'value':(depositInstance?.depositInterestScheme?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',41,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',42,['bean':(depositInstance),'field':("depositInterestScheme")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',45,['bean':(depositInstance),'field':("depositInterestScheme")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: depositInstance, field: 'depositTaxChargeScheme', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',50,['code':("deposit.depositTaxChargeScheme.label"),'default':("Deposit Tax Charge Scheme")],-1)
printHtmlPart(21)
invokeTag('select','g',53,['id':("depositTaxChargeScheme"),'name':("depositTaxChargeScheme.id"),'from':(icbs.deposit.DepositTaxFeeAndChargeScheme.findAllByTypeInList([icbs.lov.TaxFeeCharge.read(1),icbs.lov.TaxFeeCharge.read(2)])),'optionKey':("id"),'value':(depositInstance?.depositTaxChargeScheme?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',59,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',60,['bean':(depositInstance),'field':("depositTaxChargeScheme")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',63,['bean':(depositInstance),'field':("depositTaxChargeScheme")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: depositInstance, field: 'fixedDepositPreTermScheme', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',68,['code':("deposit.fixedDepositPreTermScheme.label"),'default':("Fixed Deposit Pre Term Scheme")],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',71,['id':("fixedDepositPreTermScheme"),'name':("fixedDepositPreTermScheme.id"),'value':(depositInstance?.fixedDepositPreTermScheme?.id)],-1)
printHtmlPart(24)
invokeTag('select','g',72,['disabled':("disabled"),'id':("fixedDepositPreTermScheme"),'name':("fixedDepositPreTermScheme.id"),'from':(icbs.deposit.FixedDepositPreTermScheme.list()),'optionKey':("id"),'value':(depositInstance?.fixedDepositPreTermScheme?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',78,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',79,['bean':(depositInstance),'field':("fixedDepositPreTermScheme")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',82,['bean':(depositInstance),'field':("fixedDepositPreTermScheme")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'fixedDepositTermScheme', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',87,['code':("deposit.fixedDepositTermScheme.label"),'default':("Fixed Deposit Term Scheme")],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',90,['id':("fixedDepositTermScheme"),'name':("fixedDepositTermScheme.id"),'value':(depositInstance?.fixedDepositTermScheme?.id)],-1)
printHtmlPart(27)
invokeTag('select','g',91,['disabled':("disabled"),'id':("fixedDepositTermScheme"),'name':("fixedDepositTermScheme.id"),'from':(icbs.deposit.FixedDepositTermScheme.list()),'optionKey':("id"),'value':(depositInstance?.fixedDepositTermScheme?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',96,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',97,['bean':(depositInstance),'field':("fixedDepositTermScheme")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',100,['bean':(depositInstance),'field':("fixedDepositTermScheme")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'interestRate', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',105,['code':("deposit.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(30)
if(true && (depositInstance?.depositInterestScheme?.canChangeInterestRate==true)) {
printHtmlPart(27)
invokeTag('field','g',110,['name':("interestRate"),'value':(fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate')),'class':("form-control")],-1)
printHtmlPart(28)
}
else {
printHtmlPart(27)
invokeTag('hiddenField','g',113,['name':("interestRate"),'value':(fieldValue(bean: depositInstance, field: 'interestRate'))],-1)
printHtmlPart(27)
invokeTag('field','g',114,['name':("interestRate"),'disabled':("disabled"),'value':(fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate')),'class':("form-control")],-1)
printHtmlPart(28)
}
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',120,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',121,['bean':(depositInstance),'field':("interestRate")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',124,['bean':(depositInstance),'field':("interestRate")],1)
printHtmlPart(31)
if(true && (depositInstance.depositInterestScheme.fdMonthlyTransfer == false)) {
printHtmlPart(32)
expressionOut.print(hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',131,['code':("maturityDate.label"),'default':("FD Monthly Transfer")],-1)
printHtmlPart(34)
invokeTag('field','g',134,['name':("currentRollover.endDate"),'readonly':("true"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(35)
invokeTag('textField','g',135,['name':("fdMonthlyTransfer"),'value':(depositInstance?.depositInterestScheme?.fdMonthlyTransfer),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('message','g',140,['error':(it)],-1)
printHtmlPart(39)
})
invokeTag('eachError','g',141,['bean':(depositInstance),'field':("currentRollover.endDate")],3)
printHtmlPart(40)
})
invokeTag('hasErrors','g',144,['bean':(depositInstance),'field':("currentRollover.endDate")],2)
printHtmlPart(41)
expressionOut.print(hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',149,['code':("maturityDate.label"),'default':("Maturity Date")],-1)
printHtmlPart(34)
invokeTag('field','g',152,['name':("currentRollover.endDate"),'readonly':("true"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(35)
invokeTag('customDatePicker','g',153,['name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(depositInstance?.maturityDate)],-1)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('message','g',158,['error':(it)],-1)
printHtmlPart(39)
})
invokeTag('eachError','g',159,['bean':(depositInstance),'field':("currentRollover.endDate")],3)
printHtmlPart(40)
})
invokeTag('hasErrors','g',162,['bean':(depositInstance),'field':("currentRollover.endDate")],2)
printHtmlPart(42)
}
else {
printHtmlPart(32)
expressionOut.print(hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',170,['code':("maturityDate.label"),'default':("FD Monthly Transfer")],-1)
printHtmlPart(34)
invokeTag('field','g',173,['name':("currentRollover.endDate"),'readonly':("true"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(35)
invokeTag('textField','g',174,['name':("fdMonthlyTransfer"),'value':(depositInstance?.depositInterestScheme?.fdMonthlyTransfer),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('message','g',179,['error':(it)],-1)
printHtmlPart(39)
})
invokeTag('eachError','g',180,['bean':(depositInstance),'field':("currentRollover.endDate")],3)
printHtmlPart(40)
})
invokeTag('hasErrors','g',183,['bean':(depositInstance),'field':("currentRollover.endDate")],2)
printHtmlPart(43)
expressionOut.print(hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',188,['code':("maturityDate.label"),'default':("Rollover End Date")],-1)
printHtmlPart(34)
invokeTag('field','g',191,['name':("currentRollover.endDate"),'readonly':("true"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(35)
invokeTag('customDatePicker','g',192,['name':("rollOverEndDate"),'precision':("day"),'class':("form-control"),'value':(depositInstance?.currentRollover?.endDate)],-1)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('message','g',197,['error':(it)],-1)
printHtmlPart(39)
})
invokeTag('eachError','g',198,['bean':(depositInstance),'field':("currentRollover.endDate")],3)
printHtmlPart(40)
})
invokeTag('hasErrors','g',201,['bean':(depositInstance),'field':("currentRollover.endDate")],2)
printHtmlPart(44)
expressionOut.print(hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',206,['code':("maturityDate.label"),'default':("Maturity Date")],-1)
printHtmlPart(34)
invokeTag('field','g',209,['name':("currentRollover.endDate"),'readonly':("true"),'precision':("day"),'class':("form-control"),'value':(depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate)],-1)
printHtmlPart(35)
invokeTag('customDatePicker','g',210,['name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(depositInstance?.maturityDate)],-1)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
printHtmlPart(38)
invokeTag('message','g',215,['error':(it)],-1)
printHtmlPart(39)
})
invokeTag('eachError','g',216,['bean':(depositInstance),'field':("currentRollover.endDate")],3)
printHtmlPart(40)
})
invokeTag('hasErrors','g',219,['bean':(depositInstance),'field':("currentRollover.endDate")],2)
printHtmlPart(45)
}
printHtmlPart(1)
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
