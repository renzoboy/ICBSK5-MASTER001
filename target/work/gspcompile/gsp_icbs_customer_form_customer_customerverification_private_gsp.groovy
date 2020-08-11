import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_customer_customerverification_private_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/customer/customerverification/_private.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(customerInstance?.civilStatus?.id)
printHtmlPart(2)
if(true && (customerInstance?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',29,['id':("id"),'name':("id"),'value':(customerInstance.id)],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: customerInstance, field: 'type', 'has-error'))
printHtmlPart(6)
invokeTag('hiddenField','g',36,['name':("type.id"),'value':(customerInstance?.type?.id)],-1)
printHtmlPart(7)
invokeTag('select','g',37,['id':("type"),'onchange':("changeVerificationForm()"),'disabled':("disabled"),'name':("type.id"),'from':(icbs.lov.CustomerType.findAllByStatusAndIdNotInList(true,['4'])),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',42,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',43,['bean':(customerInstance),'field':("type")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',46,['bean':(customerInstance),'field':("type")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: customerInstance, field: 'group', 'has-error'))
printHtmlPart(13)
invokeTag('select','g',54,['id':("group"),'name':("group.id"),'from':(icbs.admin.CustomerGroup.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(customerInstance?.group?.id),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',59,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',60,['bean':(customerInstance),'field':("group")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',63,['bean':(customerInstance),'field':("group")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: customerInstance, field: 'title', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',68,['code':("customer.title.label"),'default':("Title")],-1)
printHtmlPart(17)
invokeTag('select','g',72,['id':("title"),'name':("title.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndIdNotEqual("CT",true,65)),'optionKey':("id"),'optionValue':("itemValue"),'value':(customerInstance?.title?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',78,['bean':(customerInstance),'field':("title")],2)
printHtmlPart(22)
})
invokeTag('hasErrors','g',81,['bean':(customerInstance),'field':("title")],1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name1', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',85,['code':("customer.name1.label"),'default':("First Name")],-1)
printHtmlPart(25)
invokeTag('textField','g',90,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name1"),'name':("name1"),'maxlength':("50"),'':(""),'value':(customerInstance?.name1),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',95,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',96,['bean':(customerInstance),'field':("name1")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',99,['bean':(customerInstance),'field':("name1")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name2', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',105,['code':("customer.name2.label"),'default':("Middle Name")],-1)
printHtmlPart(28)
invokeTag('textField','g',109,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name2"),'name':("name2"),'maxlength':("50"),'':(""),'value':(customerInstance?.name2),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',114,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',115,['bean':(customerInstance),'field':("name2")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',118,['bean':(customerInstance),'field':("name2")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name3', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',124,['code':("customer.name3.label"),'default':("Last Name")],-1)
printHtmlPart(31)
invokeTag('textField','g',128,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name3"),'name':("name3"),'maxlength':("50"),'':(""),'value':(customerInstance?.name3),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',133,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',134,['bean':(customerInstance),'field':("name3")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',137,['bean':(customerInstance),'field':("name3")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name5', 'has-error'))
printHtmlPart(32)
invokeTag('message','g',143,['code':("customer.name5.label"),'default':("Suffix Name")],-1)
printHtmlPart(28)
invokeTag('select','g',147,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name5"),'name':("name5.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("SXNAME",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(customerInstance?.name5?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(33)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',152,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',153,['bean':(customerInstance),'field':("name5")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',156,['bean':(customerInstance),'field':("name5")],1)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: customerInstance, field: 'name4', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',162,['code':("customer.name4.label"),'default':("Nickname")],-1)
printHtmlPart(28)
invokeTag('textField','g',166,['onchange':("icbs.Customer.Form.Utilities.appendToDisplayName()"),'id':("name4"),'name':("name4"),'maxlength':("50"),'':(""),'value':(customerInstance?.name4),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',171,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',172,['bean':(customerInstance),'field':("name4")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',175,['bean':(customerInstance),'field':("name4")],1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: customerInstance, field: 'gender', 'has-error'))
printHtmlPart(37)
invokeTag('message','g',180,['code':("customer.gender.label"),'default':("Gender")],-1)
printHtmlPart(38)
invokeTag('select','g',184,['id':("gender"),'name':("gender.id"),'from':(icbs.lov.Gender.findAllByIdNotInListAndStatus(['1'],true)),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.gender?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',189,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',190,['bean':(customerInstance),'field':("gender")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',193,['bean':(customerInstance),'field':("gender")],1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: customerInstance, field: 'birthDate', 'has-error'))
printHtmlPart(39)
invokeTag('message','g',198,['code':("customer.birthDate.label"),'default':("Birth Date")],-1)
printHtmlPart(31)
invokeTag('customDatePicker','g',202,['name':("birthDate"),'value':(customerInstance?.birthDate),'class':("form-control")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',207,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',208,['bean':(customerInstance),'field':("birthDate")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',211,['bean':(customerInstance),'field':("birthDate")],1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: customerInstance, field: 'civilStatus', 'has-error'))
printHtmlPart(40)
invokeTag('select','g',220,['id':("civilStatus"),'name':("civilStatus.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeNotInList("CS",true,['0'])),'optionKey':("id"),'optionValue':("itemValue"),'value':(customerInstance?.civilStatus?.id),'class':("form-control"),'noSelection':(['null': '']),'onchange':("getCivilStatus(this.value);")],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',221,['name':("xxcivilStatus"),'id':("xxcivilStatus"),'value':("")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',226,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',227,['bean':(customerInstance),'field':("civilStatus")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',230,['bean':(customerInstance),'field':("civilStatus")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: customerInstance, field: 'birthPlace', 'has-error'))
printHtmlPart(41)
invokeTag('message','g',235,['code':("customer.birthPlace.label"),'default':("Birth Place")],-1)
printHtmlPart(42)
if(true && (session["customerpagevalidator"] == "edit")) {
printHtmlPart(43)
invokeTag('select','g',241,['id':("birthPlace"),'name':("birthPlace"),'noSelection':(['':'Select Birth Place']),'from':(icbs.lov.Town.list()),'optionKey':("id"),'optionValue':("description"),'value':(icbs.lov.Town.findByDescription(customerInstance?.birthPlace).id),'class':("form-control")],-1)
printHtmlPart(44)
}
else {
printHtmlPart(45)
invokeTag('select','g',245,['name':("birthPlace"),'noSelection':(['':'Select Birth Place']),'from':(icbs.lov.Town.findAll{id != 1}),'optionKey':("id"),'optionValue':("description"),'value':(customerInstance?.birthPlace),'class':("form-control")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
createTagBody(1, {->
printHtmlPart(48)
createTagBody(2, {->
printHtmlPart(49)
invokeTag('message','g',251,['error':(it)],-1)
printHtmlPart(50)
})
invokeTag('eachError','g',252,['bean':(customerInstance),'field':("birthPlace")],2)
printHtmlPart(51)
})
invokeTag('hasErrors','g',255,['bean':(customerInstance),'field':("birthPlace")],1)
printHtmlPart(52)
if(true && (duplicateList?.size()>0)) {
printHtmlPart(53)
for( customer in (duplicateList) ) {
printHtmlPart(54)
expressionOut.print(customer.name1)
printHtmlPart(55)
expressionOut.print(customer.name3)
printHtmlPart(56)
expressionOut.print(customer.name4)
printHtmlPart(56)
expressionOut.print(customer.gender?.description)
printHtmlPart(57)
}
printHtmlPart(58)
}
printHtmlPart(59)
createClosureForHtmlPart(60, 1)
invokeTag('link','g',292,['action':("customerInquiry"),'data-dismiss':("modal"),'class':("btn"),'onclick':("return confirm('Are you sure you want to return to CIF inquiries page?');")],1)
printHtmlPart(45)
if(true && (!onsubmit)) {
printHtmlPart(61)
}
else {
printHtmlPart(62)
}
printHtmlPart(63)
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
