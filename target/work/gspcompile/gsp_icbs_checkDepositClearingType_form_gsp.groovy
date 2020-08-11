import icbs.admin.CheckDepositClearingType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_checkDepositClearingType_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checkDepositClearingType/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("checkDepositClearingType.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("code"),'maxlength':("10"),'required':(""),'value':(checkDepositClearingTypeInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(checkDepositClearingTypeInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(checkDepositClearingTypeInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'description', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("checkDepositClearingType.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("description"),'maxlength':("100"),'required':(""),'value':(checkDepositClearingTypeInstance?.description),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(checkDepositClearingTypeInstance),'field':("description")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(checkDepositClearingTypeInstance),'field':("description")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'shortDescription', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("checkDepositClearingType.shortDescription.label"),'default':("Short Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',51,['name':("shortDescription"),'maxlength':("50"),'required':(""),'value':(checkDepositClearingTypeInstance?.shortDescription),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(checkDepositClearingTypeInstance),'field':("shortDescription")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(checkDepositClearingTypeInstance),'field':("shortDescription")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'isOnUs', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',68,['code':("checkDepositClearingType.isOnUs.label"),'default':("On Us Type")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',71,['name':("isOnUs"),'class':("form-control"),'value':(checkDepositClearingTypeInstance?.isOnUs)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(checkDepositClearingTypeInstance),'field':("isOnUs")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(checkDepositClearingTypeInstance),'field':("isOnUs")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'hasVariableClearingDays', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("checkDepositClearingType.hasVariableClearingDays.label"),'default':("Variable Clearing")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',91,['name':("hasVariableClearingDays"),'class':("form-control"),'value':(checkDepositClearingTypeInstance?.hasVariableClearingDays)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',98,['bean':(checkDepositClearingTypeInstance),'field':("hasVariableClearingDays")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',101,['bean':(checkDepositClearingTypeInstance),'field':("hasVariableClearingDays")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'clearingDays', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',108,['code':("checkDepositClearingType.clearingDays.label"),'default':("Clearing Days")],-1)
printHtmlPart(12)
invokeTag('field','g',111,['name':("clearingDays"),'type':("number"),'value':(checkDepositClearingTypeInstance.clearingDays),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',118,['bean':(checkDepositClearingTypeInstance),'field':("clearingDays")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',121,['bean':(checkDepositClearingTypeInstance),'field':("clearingDays")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: checkDepositClearingTypeInstance, field: 'currency', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',128,['code':("checkDepositClearingType.currency.label"),'default':("Currency")],-1)
printHtmlPart(2)
invokeTag('select','g',131,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(checkDepositClearingTypeInstance?.currency?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',137,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',138,['bean':(checkDepositClearingTypeInstance),'field':("currency")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',141,['bean':(checkDepositClearingTypeInstance),'field':("currency")],1)
printHtmlPart(16)
invokeTag('hiddenField','g',1,['name':("configItemStatus"),'value':("2")],-1)
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
