import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_form_loanRediscount_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/form/_loanRediscount.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanRediscountingInstance, field: 'dateGranted', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',11,['code':("loan.dateGranted.label"),'default':("Date Granted")],-1)
printHtmlPart(3)
invokeTag('customDatePicker','g',15,['id':("dateGranted"),'name':("dateGranted"),'value':(loanRediscountingInstance?.dateGranted),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',20,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',21,['bean':(loanRediscountingInstance),'field':("dateGranted")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',24,['bean':(loanRediscountingInstance),'field':("dateGranted")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanRediscountingInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',29,['code':("loan.maturityDate.label"),'default':("Maturity Date")],-1)
printHtmlPart(3)
invokeTag('customDatePicker','g',33,['id':("maturityDate"),'name':("maturityDate"),'value':(loanRediscountingInstance?.maturityDate),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',39,['bean':(loanRediscountingInstance),'field':("maturityDate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',42,['bean':(loanRediscountingInstance),'field':("maturityDate")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: loanRediscountingInstance, field: 'pnNo', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',48,['code':("loan.pnNo.label"),'default':("PN No.")],-1)
printHtmlPart(13)
invokeTag('field','g',52,['type':("text"),'id':("pnNo"),'name':("pnNo"),'value':(loanRediscountingInstance?.pnNo),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',58,['bean':(loanRediscountingInstance),'field':("pnNo")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',61,['bean':(loanRediscountingInstance),'field':("pnNo")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanRediscountingInstance, field: 'loanRediscountingPartner', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',66,['code':("loan.loanRediscountingInstance.label"),'default':("Rediscounting Partner")],-1)
printHtmlPart(16)
invokeTag('select','g',69,['id':("loanRediscountingPartner"),'name':("loanRediscountingPartner"),'from':(icbs.lov.LoanRediscountingPartner.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(loanRediscountingInstance?.loanRediscountingPartner?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('message','g',74,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',75,['bean':(loanRediscountingInstance),'field':("loanRediscountingPartner")],2)
printHtmlPart(21)
})
invokeTag('hasErrors','g',78,['bean':(loanRediscountingInstance),'field':("loanRediscountingPartner")],1)
printHtmlPart(22)
if(true && (loanRediscountingInstance)) {
printHtmlPart(23)
expressionOut.print(hasErrors(bean: loanRediscountingInstance, field: 'loanRediscountingPartner', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',84,['code':("loan.loanRediscountingInstance.label"),'default':("Rediscounting Status")],-1)
printHtmlPart(16)
invokeTag('select','g',87,['id':("loanRediscountingStatus"),'name':("loanRediscountingStatus"),'from':(icbs.loans.LoanRediscountingStatus.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(loanRediscountingInstance?.loanRediscountingStatus?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('message','g',92,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',93,['bean':(loanRediscountingInstance),'field':("loanRediscountingStatus")],3)
printHtmlPart(21)
})
invokeTag('hasErrors','g',96,['bean':(loanRediscountingInstance),'field':("loanRediscountingStatus")],2)
printHtmlPart(22)
}
printHtmlPart(24)
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
