import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_pdc_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/pdc/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: pdcInstance, field: 'accountNo', 'has-error'))
printHtmlPart(1)
invokeTag('field','g',7,['name':("accountNo"),'value':(pdcInstance?.accountNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',12,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',13,['bean':(pdcInstance),'field':("accountNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',16,['bean':(pdcInstance),'field':("accountNo")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: pdcInstance, field: 'checkNo', 'has-error'))
printHtmlPart(8)
invokeTag('field','g',26,['name':("checkNo"),'value':(pdcInstance?.checkNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',32,['bean':(pdcInstance),'field':("checkNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',35,['bean':(pdcInstance),'field':("checkNo")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: pdcInstance, field: 'amount', 'has-error'))
printHtmlPart(9)
invokeTag('field','g',45,['type':("number"),'name':("amount"),'value':(pdc?.amount),'class':("form-control truncated")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',50,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',51,['bean':(pdcInstance),'field':("amount")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',54,['bean':(pdcInstance),'field':("amount")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: pdcInstance, field: 'bank', 'has-error'))
printHtmlPart(10)
invokeTag('field','g',64,['name':("bank"),'value':(pdcInstance?.bank),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',70,['bean':(pdcInstance),'field':("bank")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',73,['bean':(pdcInstance),'field':("bank")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: pdcInstance, field: 'onUs', 'has-error'))
printHtmlPart(11)
invokeTag('checkBox','g',82,['class':("form-control"),'name':("onUs"),'value':(pdcInstance?.onUs)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: pdcInstance, field: 'pdcDate', 'has-error'))
printHtmlPart(12)
invokeTag('customDatePicker','g',92,['name':("pdcDate"),'precision':("day"),'class':("form-control"),'value':(pdcInstance?.pdcDate)],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',98,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',99,['bean':(pdcInstance),'field':("pdcDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',102,['bean':(pdcInstance),'field':("pdcDate")],1)
printHtmlPart(14)
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
