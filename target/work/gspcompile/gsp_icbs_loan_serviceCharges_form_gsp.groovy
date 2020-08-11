import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_serviceCharges_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/serviceCharges/_form.gsp" }
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
invokeTag('hasErrors','g',26,['bean':(serviceCharge)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: serviceCharge, field: 'scheme', 'has-error'))
printHtmlPart(6)
invokeTag('select','g',32,['class':("form-control"),'id':("serviceChargeScheme"),'name':("scheme.id"),'from':(product?.amortizedChargeSchemes?.sort{it.id}),'optionKey':("id"),'optionValue':("name"),'value':(serviceCharge?.scheme?.id),'onchange':("updateServiceChargeForm()")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',39,['bean':(serviceCharge),'field':("scheme")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',42,['bean':(serviceCharge),'field':("scheme")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: serviceCharge, field: 'amount', 'has-error'))
printHtmlPart(13)
invokeTag('field','g',48,['class':("form-control"),'name':("serviceChargeAmount"),'value':(serviceCharge?.amount),'onkeyup':("service()")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',55,['bean':(serviceCharge),'field':("amount")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',58,['bean':(serviceCharge),'field':("amount")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: serviceCharge, field: 'rate', 'has-error'))
printHtmlPart(15)
invokeTag('field','g',65,['class':("form-control"),'name':("serviceChargeRate"),'value':(serviceCharge?.rate),'onkeyup':("updateServiceChargeAmount()")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',71,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',72,['bean':(serviceCharge),'field':("rate")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',75,['bean':(serviceCharge),'field':("rate")],1)
printHtmlPart(16)
invokeTag('field','g',81,['class':("form-control"),'name':("serviceChargeRateAmount"),'readonly':("true")],-1)
printHtmlPart(17)
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
