import icbs.loans.AmortizedChargeScheme
import icbs.lov.LoanServiceChargeType
import icbs.lov.LoanServiceChargeBasis
import icbs.lov.LoanInstallmentFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_amortizedChargeScheme_details_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/amortizedChargeScheme/_details.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'code', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',11,['code':("amortizedChargeScheme.code.label"),'default':("Code")],-1)
printHtmlPart(3)
invokeTag('textField','g',15,['class':("form-control"),'name':("code"),'maxlength':("10"),'value':(amortizedChargeSchemeInstance?.code)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',20,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',21,['bean':(amortizedChargeSchemeInstance),'field':("code")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',24,['bean':(amortizedChargeSchemeInstance),'field':("code")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'name', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',30,['code':("amortizedChargeScheme.name.label"),'default':("Name")],-1)
printHtmlPart(11)
invokeTag('textField','g',34,['class':("form-control"),'name':("name"),'maxlength':("75"),'value':(amortizedChargeSchemeInstance?.name)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',39,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',40,['bean':(amortizedChargeSchemeInstance),'field':("name")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',43,['bean':(amortizedChargeSchemeInstance),'field':("name")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'basis', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',49,['code':("amortizedChargeScheme.basis.label"),'default':("Basis")],-1)
printHtmlPart(13)
invokeTag('select','g',52,['class':("form-control"),'id':("basis"),'name':("basis.id"),'from':(icbs.lov.LoanServiceChargeBasis.list()),'optionKey':("id"),'optionValue':("description"),'value':(amortizedChargeSchemeInstance?.basis?.id)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',58,['bean':(amortizedChargeSchemeInstance),'field':("basis")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',61,['bean':(amortizedChargeSchemeInstance),'field':("basis")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'type', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',67,['code':("amortizedChargeScheme.type.label"),'default':("Type")],-1)
printHtmlPart(13)
invokeTag('select','g',70,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.LoanServiceChargeType.list()),'optionKey':("id"),'optionValue':("description"),'value':(amortizedChargeSchemeInstance?.type?.id),'onchange':("updateForm()")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',75,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',76,['bean':(amortizedChargeSchemeInstance),'field':("type")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',78,['bean':(amortizedChargeSchemeInstance),'field':("type")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'amount', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',87,['code':("amortizedChargeScheme.amount.label"),'default':("Service Charge Amount")],-1)
printHtmlPart(18)
invokeTag('field','g',88,['class':("form-control truncated"),'name':("amount"),'value':(fieldValue(bean: amortizedChargeSchemeInstance, field: 'amount'))],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',93,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',94,['bean':(amortizedChargeSchemeInstance),'field':("amount")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',96,['bean':(amortizedChargeSchemeInstance),'field':("amount")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'rate', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',103,['code':("amortizedChargeScheme.rate.label"),'default':("Service Charge Rate (%)")],-1)
printHtmlPart(3)
invokeTag('field','g',107,['class':("form-control"),'name':("rate"),'value':(fieldValue(bean: amortizedChargeSchemeInstance, field: 'rate'))],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',112,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',112,['bean':(amortizedChargeSchemeInstance),'field':("rate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',114,['bean':(amortizedChargeSchemeInstance),'field':("rate")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: amortizedChargeSchemeInstance, field: 'hasEirMode', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',122,['code':("amortizedChargeScheme.hasEirMode.label"),'default':("EIR Mode")],-1)
printHtmlPart(22)
invokeTag('checkBox','g',126,['class':("form-control"),'name':("hasEirMode"),'value':(amortizedChargeSchemeInstance?.hasEirMode)],-1)
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
