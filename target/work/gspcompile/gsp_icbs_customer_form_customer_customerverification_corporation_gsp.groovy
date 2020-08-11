import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_customer_customerverification_corporation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/customer/customerverification/_corporation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (customerInstance?.id)) {
printHtmlPart(2)
invokeTag('hiddenField','g',9,['id':("id"),'name':("id"),'value':(customerInstance.id)],-1)
printHtmlPart(1)
}
printHtmlPart(1)
invokeTag('hiddenField','g',11,['id':("title"),'name':("title.id"),'value':("65")],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',12,['id':("gender"),'name':("gender.id"),'value':("1")],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',13,['id':("civilStatus"),'name':("civilStatus.id"),'value':("27")],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',14,['id':("birthPlace"),'name':("birthPlace"),'value':("NA")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: customerInstance, field: 'type', 'has-error'))
printHtmlPart(4)
invokeTag('hiddenField','g',20,['name':("type.id"),'value':(customerInstance?.type?.id)],-1)
printHtmlPart(5)
invokeTag('select','g',21,['id':("type"),'onchange':("changeVerificationForm(2)"),'disabled':("disabled"),'name':("type.id"),'from':(icbs.lov.CustomerType.findAllByStatus(true)),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',26,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',27,['bean':(customerInstance),'field':("type")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',30,['bean':(customerInstance),'field':("type")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: customerInstance, field: 'group', 'has-error'))
printHtmlPart(11)
invokeTag('select','g',38,['id':("group"),'name':("group.id"),'from':(icbs.admin.CustomerGroup.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(customerInstance?.group?.id),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',43,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',44,['bean':(customerInstance),'field':("group")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',47,['bean':(customerInstance),'field':("group")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name1', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',52,['code':("customer.name1.label"),'default':("Company Name ")],-1)
printHtmlPart(14)
invokeTag('textField','g',57,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName(2)"),'id':("name1"),'name':("name1"),'maxlength':("50"),'':(""),'value':(customerInstance?.name1),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(15, 2)
invokeTag('eachError','g',62,['bean':(customerInstance),'field':("name1")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',65,['bean':(customerInstance),'field':("name1")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: customerInstance, field: 'birthDate', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',71,['code':("customer.birthDate.label"),'default':("Registration Date")],-1)
printHtmlPart(18)
invokeTag('customDatePicker','g',75,['name':("birthDate"),'precision':("day"),'value':(customerInstance?.birthDate),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createClosureForHtmlPart(19, 2)
invokeTag('eachError','g',80,['bean':(customerInstance),'field':("birthDate")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',81,['bean':(customerInstance),'field':("birthDate")],1)
printHtmlPart(20)
if(true && (duplicateList?.size()>0)) {
printHtmlPart(21)
for( customer in (duplicateList) ) {
printHtmlPart(22)
expressionOut.print(customer.name1)
printHtmlPart(23)
expressionOut.print(customer.name2)
printHtmlPart(24)
expressionOut.print(customer.name3)
printHtmlPart(24)
expressionOut.print(customer.name4)
printHtmlPart(24)
expressionOut.print(customer.gender?.description)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
createClosureForHtmlPart(28, 1)
invokeTag('link','g',122,['action':("customerInquiry"),'data-dismiss':("modal"),'class':("btn"),'onclick':("return confirm('Are you sure you want to return to CIF inquiries page?');")],1)
printHtmlPart(29)
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
