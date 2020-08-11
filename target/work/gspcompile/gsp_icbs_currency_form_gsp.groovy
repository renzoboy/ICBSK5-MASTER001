import icbs.admin.Currency
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_currency_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/currency/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: currencyInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("currency.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("code"),'maxlength':("5"),'required':(""),'value':(currencyInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',14,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',15,['bean':(currencyInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',18,['bean':(currencyInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: currencyInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',24,['code':("currency.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',27,['name':("name"),'maxlength':("50"),'required':(""),'value':(currencyInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',33,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',34,['bean':(currencyInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',37,['bean':(currencyInstance),'field':("name")],1)
printHtmlPart(10)
invokeTag('hiddenField','g',41,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(11)
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
