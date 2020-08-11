import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reschedule_sweep_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/reschedule/sweep/_form.gsp" }
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
invokeTag('hasErrors','g',23,['bean':(sweepAccount)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'depositAccount', 'has-error'))
printHtmlPart(6)
invokeTag('field','g',29,['class':("form-control"),'name':("accountNo"),'value':(sweepAccount?.depositAccount?.acctNo),'readonly':("true")],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',30,['id':("depositAccount"),'name':("depositAccount.id"),'value':(sweepAccount?.depositAccount?.id)],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',37,['bean':(sweepAccount),'field':("depositAccount")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',40,['bean':(sweepAccount),'field':("depositAccount")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'rule', 'has-error'))
printHtmlPart(14)
invokeTag('select','g',49,['class':("form-control"),'id':("rule"),'name':("rule.id"),'from':(icbs.lov.SweepRule.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(sweepAccount?.rule?.id)],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'fundLimitAmt', 'has-error'))
printHtmlPart(16)
invokeTag('field','g',56,['name':("fundLimitAmt"),'value':(fieldValue(bean: sweepAccount, field: 'fundLimitAmt')),'class':("form-control")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'fundLimitPercentage', 'has-error'))
printHtmlPart(18)
invokeTag('field','g',63,['name':("fundLimitPercentage"),'value':(fieldValue(bean: sweepAccount, field: 'fundLimitPercentage')),'required':(""),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',70,['bean':(sweepAccount),'field':("fundLimitPercentage")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',73,['bean':(sweepAccount),'field':("fundLimitPercentage")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'ordinalNum', 'has-error'))
printHtmlPart(20)
invokeTag('field','g',80,['name':("ordinalNum"),'type':("number"),'min':("0"),'value':(sweepAccount?.ordinalNum),'required':(""),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',86,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',87,['bean':(sweepAccount),'field':("ordinalNum")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',90,['bean':(sweepAccount),'field':("ordinalNum")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: sweepAccount, field: 'remarks', 'has-error'))
printHtmlPart(21)
invokeTag('textArea','g',97,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(sweepAccount?.remarks),'class':("form-control")],-1)
printHtmlPart(22)
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
