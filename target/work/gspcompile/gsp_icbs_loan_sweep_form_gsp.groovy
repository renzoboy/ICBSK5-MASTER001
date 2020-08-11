import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_sweep_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/sweep/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',26,['bean':(sweepAccount)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'depositAccount', 'has-error'))
printHtmlPart(6)
invokeTag('field','g',32,['class':("form-control"),'name':("accountNo"),'value':(sweepAccount?.depositAccount?.acctNo),'readonly':("true")],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',33,['id':("depositAccount"),'name':("depositAccount.id"),'value':(sweepAccount?.depositAccount?.id)],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',39,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',40,['bean':(sweepAccount),'field':("depositAccount")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',43,['bean':(sweepAccount),'field':("depositAccount")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'type', 'has-error'))
printHtmlPart(14)
invokeTag('select','g',52,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.SweepType.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(sweepAccount?.type?.id),'onchange':("updateSweepForm()")],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'rule', 'has-error'))
printHtmlPart(16)
invokeTag('select','g',59,['class':("form-control"),'id':("rule"),'name':("rule.id"),'from':(icbs.lov.SweepRule.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(sweepAccount?.rule?.id),'onchange':("updateSweepForm()")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'fundLimitAmt', 'has-error'))
printHtmlPart(18)
invokeTag('field','g',67,['type':("number"),'name':("fundLimitAmt"),'value':(fieldValue(bean: sweepAccount, field: 'fundLimitAmt')),'class':("form-control truncated")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',72,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',73,['bean':(sweepAccount),'field':("fundLimitAmt")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',76,['bean':(sweepAccount),'field':("fundLimitAmt")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'fundLimitPercentage', 'has-error'))
printHtmlPart(21)
invokeTag('field','g',83,['name':("fundLimitPercentage"),'value':(fieldValue(bean: sweepAccount, field: 'fundLimitPercentage')),'required':(""),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',89,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',90,['bean':(sweepAccount),'field':("fundLimitPercentage")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',93,['bean':(sweepAccount),'field':("fundLimitPercentage")],1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'ordinalNum', 'has-error'))
printHtmlPart(23)
invokeTag('field','g',100,['name':("ordinalNum"),'type':("number"),'min':("0"),'value':(sweepAccount?.ordinalNum),'required':(""),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',106,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',107,['bean':(sweepAccount),'field':("ordinalNum")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',110,['bean':(sweepAccount),'field':("ordinalNum")],1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'remarks', 'has-error'))
printHtmlPart(24)
invokeTag('textArea','g',117,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(sweepAccount?.remarks),'class':("form-control")],-1)
printHtmlPart(25)
invokeTag('hiddenField','g',120,['name':("arraypoistion"),'id':("arraypoistion"),'value':(session["sweepposition"])],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',121,['name':("loanidvalue"),'id':("loanidvalue"),'value':(session["loanidvalue"])],-1)
printHtmlPart(27)
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
