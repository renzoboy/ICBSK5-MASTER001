import icbs.admin.ForexRate
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_forexRate_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/forexRate/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: forexRateInstance, field: 'currency', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("forexRate.currency.label"),'default':("Received Currency")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(forexRateInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',13,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',14,['bean':(forexRateInstance),'field':("currency")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',17,['bean':(forexRateInstance),'field':("currency")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: forexRateInstance, field: 'currency2', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',23,['code':("forexRate.currency2.label"),'default':("Pay Out Currency")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("currency2"),'name':("currency2.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(forexRateInstance?.currency2?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',32,['bean':(forexRateInstance),'field':("currency2")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',35,['bean':(forexRateInstance),'field':("currency2")],1)
printHtmlPart(10)
invokeTag('hiddenField','g',40,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',1,['name':("date"),'value':(new Date())],-1)
printHtmlPart(12)
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
