import icbs.admin.Holiday
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_holiday_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/holiday/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: holidayInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("holiday.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("code"),'maxlength':("10"),'required':(""),'value':(holidayInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(holidayInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(holidayInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: holidayInstance, field: 'description', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("holiday.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("description"),'maxlength':("100"),'required':(""),'value':(holidayInstance?.description),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(holidayInstance),'field':("description")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(holidayInstance),'field':("description")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: holidayInstance, field: 'holidayDate', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',47,['code':("holidayInstance.holidayDate.label"),'default':("Holiday Date")],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',51,['id':("holidayDate"),'name':("existingHolidayDate"),'value':(holidayInstance?.holidayDate)],-1)
printHtmlPart(13)
invokeTag('customDatePicker','g',52,['name':("holidayDate"),'precision':("day"),'class':("form-control"),'value':(holidayInstance?.holidayDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',58,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',59,['bean':(holidayInstance),'field':("holidayDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',62,['bean':(holidayInstance),'field':("holidayDate")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: holidayInstance, field: 'month', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',68,['code':("holiday.month.label"),'default':("Date")],-1)
printHtmlPart(16)
invokeTag('select','g',72,['id':("month"),'name':("month.id"),'required':(""),'from':(icbs.lov.Month.list()),'optionKey':("id"),'optionValue':("description"),'value':(holidayInstance?.month?.id),'noSelection':(['null': '']),'style':("width:150px; clear:both; margin-right:5px; ")],-1)
invokeTag('select','g',72,['id':("day"),'name':("day"),'required':(""),'from':(1..31),'value':(holidayInstance?.day),'noSelection':(['null': '']),'style':("width:70px;")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',78,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',79,['bean':(holidayInstance),'field':("month")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',82,['bean':(holidayInstance),'field':("month")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: holidayInstance, field: 'type', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',89,['code':("holiday.type.label"),'default':("Type")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
expressionOut.print(it.radio)
printHtmlPart(21)
invokeTag('message','g',98,['code':(it.label)],-1)
printHtmlPart(22)
})
invokeTag('radioGroup','g',99,['name':("type"),'values':(icbs.admin.Holiday$Type?.values()),'labels':(icbs.admin.Holiday$Type.values()*.name()),'value':(holidayInstance?.type?.name())],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',105,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',106,['bean':(holidayInstance),'field':("type")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',109,['bean':(holidayInstance),'field':("type")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: holidayInstance, field: 'institutionWideHoliday', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',115,['code':("holidayInstance.institutionWideHoliday.label"),'default':("Bankwide Holiday")],-1)
printHtmlPart(24)
invokeTag('checkBox','g',118,['name':("institutionWideHoliday"),'class':("form-control"),'value':(holidayInstance?.institutionWideHoliday)],-1)
printHtmlPart(25)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',123,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',124,['bean':(holidayInstance),'field':("institutionWideHoliday")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',127,['bean':(holidayInstance),'field':("institutionWideHoliday")],1)
printHtmlPart(26)
invokeTag('hiddenField','g',130,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(27)
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
