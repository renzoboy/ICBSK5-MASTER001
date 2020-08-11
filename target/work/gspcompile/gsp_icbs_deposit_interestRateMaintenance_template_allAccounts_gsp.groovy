import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_interestRateMaintenance_template_allAccounts_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/interestRateMaintenance/template/_allAccounts.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'code', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',12,['code':("depositInterestScheme.id.label"),'default':("Deposit Interest Scheme")],-1)
printHtmlPart(3)
invokeTag('select','g',15,['onchange':("changeInterestRateFormAjax()"),'id':("id"),'name':("id"),'from':(icbs.deposit.DepositInterestScheme.list()),'optionKey':("id"),'value':(depositInterestSchemeInstance?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',21,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',22,['bean':(depositInterestSchemeInstance),'field':("id")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',25,['bean':(depositInterestSchemeInstance),'field':("id")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'interestRate', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',34,['code':("depositInterestScheme.interestRate.label"),'default':(" Old Interest Rate")],-1)
printHtmlPart(11)
invokeTag('field','g',37,['name':("interestRate"),'disabled':("disabled"),'value':(fieldValue(bean: depositInterestSchemeInstance, field: 'interestRate')),'required':(""),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',43,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',44,['bean':(depositInterestSchemeInstance),'field':("interestRate")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',47,['bean':(depositInterestSchemeInstance),'field':("interestRate")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'interestRate', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',54,['code':("depositInterestScheme.interestRate.label"),'default':("New  Interest Rate")],-1)
printHtmlPart(11)
invokeTag('field','g',57,['name':("interestRate"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',64,['bean':(depositInterestSchemeInstance),'field':("interestRate")],2)
printHtmlPart(16)
})
invokeTag('hasErrors','g',67,['bean':(depositInterestSchemeInstance),'field':("interestRate")],1)
printHtmlPart(18)
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
