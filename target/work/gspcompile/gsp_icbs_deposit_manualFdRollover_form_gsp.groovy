import icbs.deposit.Rollover
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_manualFdRollover_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/manualFdRollover/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("deposit"),'id':("deposit.id"),'value':(rolloverInstance.deposit.id)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: rolloverInstance, field: 'startDate', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("rollover.startDate.label"),'default':("Start Date")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',8,['name':("startDate"),'precision':("day"),'class':("form-control"),'value':(rolloverInstance.deposit.branch.runDate.format("MM/dd/yyyy"))],-1)
printHtmlPart(4)
invokeTag('field','g',9,['disabled':("disabled"),'name':("startDate"),'precision':("day"),'class':("form-control"),'value':(rolloverInstance.deposit.branch.runDate.format("MM/dd/yyyy"))],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',15,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',16,['bean':(rolloverInstance),'field':("startDate")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',19,['bean':(rolloverInstance),'field':("startDate")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: rolloverInstance, field: 'endDate', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',24,['code':("rollover.endDate.label"),'default':("End Date")],-1)
printHtmlPart(12)
invokeTag('customDatePicker','g',27,['name':("endDate"),'precision':("day"),'class':("form-control"),'value':(rolloverInstance.deposit.branch.runDate+rolloverInstance?.deposit?.fixedDepositTermScheme?.value.toInteger())],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',32,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',33,['bean':(rolloverInstance),'field':("endDate")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',36,['bean':(rolloverInstance),'field':("endDate")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: rolloverInstance, field: 'interestPaymentMode', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',42,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(16)
if(true && (rolloverInstance?.deposit?.currentRollover?.type?.id==1)) {
printHtmlPart(17)
invokeTag('select','g',46,['id':("interestPaymentMode"),'name':("interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.list()),'optionKey':("id"),'optionValue':("description"),'value':(interestPaymentMode?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(18)
}
printHtmlPart(18)
if(true && (rolloverInstance?.deposit?.currentRollover?.type?.id==2)) {
printHtmlPart(17)
invokeTag('select','g',49,['id':("interestPaymentMode"),'name':("interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([3])),'optionKey':("id"),'optionValue':("description"),'value':(interestPaymentMode?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(18)
}
printHtmlPart(18)
if(true && (rolloverInstance?.deposit?.currentRollover?.type?.id==3)) {
printHtmlPart(17)
invokeTag('select','g',52,['id':("interestPaymentMode"),'name':("interestPaymentMode.id"),'from':(icbs.lov.InterestPaymentMode.findAllByIdNotInList([1,2])),'optionKey':("id"),'optionValue':("description"),'value':(interestPaymentMode?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',59,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',60,['bean':(rolloverInstance),'field':("interestPaymentMode")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',63,['bean':(rolloverInstance),'field':("interestPaymentMode")],1)
printHtmlPart(21)
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
