import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_pdc_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/pdc/_form.gsp" }
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
invokeTag('hasErrors','g',39,['bean':(pdc)],1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: pdc, field: 'accountNo', 'has-error'))
printHtmlPart(6)
invokeTag('field','g',45,['name':("accountNo"),'value':(pdc?.accountNo),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',52,['bean':(pdc),'field':("accountNo")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',55,['bean':(pdc),'field':("accountNo")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: pdc, field: 'checkNo', 'has-error'))
printHtmlPart(13)
invokeTag('field','g',62,['name':("checkNo"),'value':(pdc?.checkNo),'class':("form-control")],-1)
printHtmlPart(7)
createClosureForHtmlPart(14, 1)
invokeTag('hasErrors','g',66,['bean':(pdc),'field':("checkNo")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: pdc, field: 'amount', 'has-error'))
printHtmlPart(15)
invokeTag('field','g',74,['type':("number"),'name':("amount"),'value':(pdc?.amount),'class':("form-control truncated")],-1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',79,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',80,['bean':(pdc),'field':("amount")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',83,['bean':(pdc),'field':("amount")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: pdc, field: 'bank', 'has-error'))
printHtmlPart(17)
invokeTag('field','g',90,['name':("bank"),'value':(pdc?.bank),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',96,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',97,['bean':(pdc),'field':("bank")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',100,['bean':(pdc),'field':("bank")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: pdc, field: 'onUs', 'has-error'))
printHtmlPart(18)
expressionOut.print(pdc?.onUs ? 'checked="checked"' : '')
printHtmlPart(19)
expressionOut.print(hasErrors(bean: pdc, field: 'pdcDate', 'has-error'))
printHtmlPart(20)
invokeTag('customDatePicker','g',115,['name':("pdcDate"),'precision':("day"),'class':("form-control"),'value':(pdc?.pdcDate)],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',120,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',121,['bean':(pdc),'field':("pdcDate")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',123,['bean':(pdc),'field':("pdcDate")],1)
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
