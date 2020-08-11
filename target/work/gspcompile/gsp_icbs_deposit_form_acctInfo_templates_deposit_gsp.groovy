import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_acctInfo_templates_deposit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/acctInfo/templates/_deposit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: depositInstance, field: 'acctName', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',12,['code':("deposit.acctName.label"),'default':("Account Name")],-1)
printHtmlPart(3)
invokeTag('field','g',15,['name':("acctName"),'class':("form-control"),'value':(depositInstance?.acctName?:depositInstance?.customer?.displayName)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',21,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',22,['bean':(depositInstance),'field':("acctName")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',25,['bean':(depositInstance),'field':("acctName")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: depositInstance, field: 'depositInterestScheme', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',30,['code':("deposit.depositInterestScheme.label"),'default':("Deposit Interest Scheme")],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',33,['id':("depositInterestScheme"),'name':("depositInterestScheme.id"),'value':(depositInstance?.depositInterestScheme?.id)],-1)
printHtmlPart(12)
invokeTag('select','g',34,['id':("depositInterestScheme"),'disabled':("disabled"),'name':("depositInterestScheme.id"),'from':(icbs.deposit.DepositInterestScheme.list()),'optionKey':("id"),'value':(depositInstance?.depositInterestScheme?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',40,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',41,['bean':(depositInstance),'field':("depositInterestScheme")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',44,['bean':(depositInstance),'field':("depositInterestScheme")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: depositInstance, field: 'depositTaxChargeScheme', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',49,['code':("deposit.depositTaxChargeScheme.label"),'default':("Deposit Tax Charge Scheme")],-1)
printHtmlPart(20)
invokeTag('select','g',52,['id':("depositTaxChargeScheme"),'name':("depositTaxChargeScheme.id"),'from':(icbs.deposit.DepositTaxFeeAndChargeScheme.findAllByTypeInList([icbs.lov.TaxFeeCharge.read(1),icbs.lov.TaxFeeCharge.read(2)])),'optionKey':("id"),'value':(depositInstance?.depositTaxChargeScheme?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',58,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',59,['bean':(depositInstance),'field':("depositTaxChargeScheme")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',62,['bean':(depositInstance),'field':("depositTaxChargeScheme")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: depositInstance, field: 'interestRate', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',67,['code':("deposit.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(23)
if(true && (depositInstance?.depositInterestScheme?.canChangeInterestRate==true)) {
printHtmlPart(24)
invokeTag('field','g',72,['name':("interestRate"),'value':(fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate')),'class':("form-control")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(24)
invokeTag('hiddenField','g',75,['name':("interestRate"),'value':(fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate'))],-1)
printHtmlPart(24)
invokeTag('field','g',76,['name':("interestRate"),'disabled':("disabled"),'value':(fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate')),'class':("form-control")],-1)
printHtmlPart(25)
}
printHtmlPart(25)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',82,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',83,['bean':(depositInstance),'field':("interestRate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',86,['bean':(depositInstance),'field':("interestRate")],1)
printHtmlPart(26)
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
