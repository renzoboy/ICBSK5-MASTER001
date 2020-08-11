import icbs.loans.LoanDeductionScheme
import icbs.lov.LoanDeductionCalculationType
import icbs.lov.LoanDeductionSpecialCalculation
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanDeductionScheme_details_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanDeductionScheme/_details.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'code', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',10,['code':("loanDeductionScheme.code.label"),'default':("Code")],-1)
printHtmlPart(3)
invokeTag('textField','g',14,['class':("form-control"),'name':("code"),'maxlength':("10"),'value':(loanDeductionSchemeInstance?.code)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',19,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',20,['bean':(loanDeductionSchemeInstance),'field':("code")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',23,['bean':(loanDeductionSchemeInstance),'field':("code")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'name', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',29,['code':("loanDeductionScheme.name.label"),'default':("Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',33,['class':("form-control"),'name':("name"),'maxlength':("75"),'value':(loanDeductionSchemeInstance?.name)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',39,['bean':(loanDeductionSchemeInstance),'field':("name")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',42,['bean':(loanDeductionSchemeInstance),'field':("name")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'description', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',48,['code':("collateral.description.label"),'default':("Description")],-1)
printHtmlPart(13)
invokeTag('textArea','g',50,['name':("description"),'value':(loanDeductionSchemeInstance?.description),'rows':("3"),'class':("form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',56,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',57,['bean':(loanDeductionSchemeInstance),'field':("description")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',60,['bean':(loanDeductionSchemeInstance),'field':("description")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'specialCalculation', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',66,['code':("loanDeductionScheme.specialCalculation.label"),'default':("Special Calculation")],-1)
printHtmlPart(21)
invokeTag('select','g',69,['class':("form-control"),'id':("specialCalculation"),'name':("specialCalculation.id"),'from':(icbs.lov.LoanDeductionSpecialCalculation.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanDeductionSchemeInstance?.specialCalculation?.id)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',74,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',75,['bean':(loanDeductionSchemeInstance),'field':("specialCalculation")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',78,['bean':(loanDeductionSchemeInstance),'field':("specialCalculation")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'type', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',84,['code':("loanDeductionScheme.type.label"),'default':("Type")],-1)
printHtmlPart(21)
invokeTag('select','g',88,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.LoanDeductionCalculationType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanDeductionSchemeInstance?.type?.id),'onchange':("updateForm()")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',93,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',94,['bean':(loanDeductionSchemeInstance),'field':("type")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',97,['bean':(loanDeductionSchemeInstance),'field':("type")],1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'amount', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',103,['code':("loanDeductionScheme.amount.label"),'default':("Amount")],-1)
printHtmlPart(3)
invokeTag('field','g',107,['class':("form-control"),'name':("amount"),'value':(fieldValue(bean: loanDeductionSchemeInstance, field: 'amount'))],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',112,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',113,['bean':(loanDeductionSchemeInstance),'field':("amount")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',116,['bean':(loanDeductionSchemeInstance),'field':("amount")],1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'rate', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',122,['code':("loanDeductionScheme.rate.label"),'default':("Rate (%)")],-1)
printHtmlPart(3)
invokeTag('field','g',126,['class':("form-control"),'name':("rate"),'value':(fieldValue(bean: loanDeductionSchemeInstance, field: 'rate'))],-1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
invokeTag('message','g',131,['error':(it)],-1)
printHtmlPart(30)
})
invokeTag('eachError','g',132,['bean':(loanDeductionSchemeInstance),'field':("rate")],2)
printHtmlPart(31)
})
invokeTag('hasErrors','g',135,['bean':(loanDeductionSchemeInstance),'field':("rate")],1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'divisor', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',141,['code':("loanDeductionScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(3)
invokeTag('field','g',145,['class':("form-control"),'name':("divisor"),'type':("number"),'value':(loanDeductionSchemeInstance.divisor)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',150,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',151,['bean':(loanDeductionSchemeInstance),'field':("divisor")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',154,['bean':(loanDeductionSchemeInstance),'field':("divisor")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'hasEirMode', 'has-error'))
printHtmlPart(34)
invokeTag('message','g',160,['code':("loanDeductionScheme.hasEirMode.label"),'default':("EIR Mode")],-1)
printHtmlPart(21)
invokeTag('checkBox','g',163,['class':("form-control"),'name':("hasEirMode"),'value':(loanDeductionSchemeInstance?.hasEirMode)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: loanDeductionSchemeInstance, field: 'contraAcct', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',169,['code':("loanDeductionScheme.contraAcct.label"),'default':("GL Contra Account")],-1)
printHtmlPart(36)
invokeTag('select','g',171,['id':("contraAcct"),'name':("contraAcct.id"),'from':(icbs.gl.GlAccount.findAllByBranch(icbs.admin.Branch.get(1))),'optionKey':("id"),'optionValue':("name"),'value':(loanDeductionSchemeInstance?.contraAcct?.id),'noSelection':(['': '']),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',177,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',178,['bean':(loanDeductionSchemeInstance),'field':("contraAcct")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',181,['bean':(loanDeductionSchemeInstance),'field':("contraAcct")],1)
printHtmlPart(37)
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
