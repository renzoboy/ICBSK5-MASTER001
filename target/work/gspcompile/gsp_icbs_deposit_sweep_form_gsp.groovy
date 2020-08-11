import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_sweep_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/sweep/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',7,['name':("id"),'value':(sweepInstance?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("fundingDeposit.id"),'value':(sweepInstance?.fundingDeposit?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'fundedDeposit', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',12,['code':("sweep.fundedDeposit.label"),'default':("Funded Acct")],-1)
printHtmlPart(4)
if(true && (!edit)) {
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('hiddenField','g',19,['id':("fundedDeposit"),'name':("fundedDeposit.id"),'value':(sweepInstance?.fundedDeposit?.id)],-1)
printHtmlPart(6)
invokeTag('textField','g',20,['id':("fundedDeposit"),'name':("fundedDeposit.acctNo"),'disabled':("disabled"),'value':(sweepInstance?.fundedDeposit?.acctNo)],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',26,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',27,['bean':(sweepInstance),'field':("fundedDeposit")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',30,['bean':(sweepInstance),'field':("fundedDeposit")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'rule', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',37,['code':("sweep.rule.label"),'default':("Rule")],-1)
printHtmlPart(14)
invokeTag('select','g',40,['id':("rule"),'onchange':("updateForm()"),'name':("rule.id"),'from':(icbs.lov.SweepRule.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(sweepInstance?.rule?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',46,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',47,['bean':(sweepInstance),'field':("rule")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',50,['bean':(sweepInstance),'field':("rule")],1)
printHtmlPart(16)
if(true && (holdInstance?.type?.id==3)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'fundLimitAmt', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',56,['code':("sweep.fundLimitAmt.label"),'default':("Fund Limit Amt")],-1)
printHtmlPart(21)
invokeTag('field','g',59,['name':("fundLimitAmt"),'value':(fieldValue(bean: sweepInstance, field: 'fundLimitAmt')),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',65,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',66,['bean':(sweepInstance),'field':("fundLimitAmt")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',69,['bean':(sweepInstance),'field':("fundLimitAmt")],1)
printHtmlPart(22)
if(true && (standingOrderInstance?.type?.id==4)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'fundLimitPercentage', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',76,['code':("sweep.fundLimitPercentage.label"),'default':("Fund Limit Percentage")],-1)
printHtmlPart(14)
invokeTag('field','g',79,['name':("fundLimitPercentage"),'value':(fieldValue(bean: sweepInstance, field: 'fundLimitPercentage')),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',85,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',86,['bean':(sweepInstance),'field':("fundLimitPercentage")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',89,['bean':(sweepInstance),'field':("fundLimitPercentage")],1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'ordinalNum', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',95,['code':("sweep.ordinalNum.label"),'default':("Ordinal Num")],-1)
printHtmlPart(14)
invokeTag('field','g',98,['name':("ordinalNum"),'type':("number"),'min':("0"),'value':(sweepInstance.ordinalNum),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',104,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',105,['bean':(sweepInstance),'field':("ordinalNum")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',108,['bean':(sweepInstance),'field':("ordinalNum")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'remarks', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',113,['code':("sweep.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(21)
invokeTag('textArea','g',116,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(sweepInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',122,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',123,['bean':(sweepInstance),'field':("remarks")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',126,['bean':(sweepInstance),'field':("remarks")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: sweepInstance, field: 'status', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',133,['code':("sweep.status.label"),'default':("Status")],-1)
printHtmlPart(21)
invokeTag('select','g',136,['id':("status"),'name':("status.id"),'from':(icbs.lov.SweepStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(sweepInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',142,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',143,['bean':(sweepInstance),'field':("status")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',146,['bean':(sweepInstance),'field':("status")],1)
printHtmlPart(29)
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
