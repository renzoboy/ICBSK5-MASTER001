import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_contact_onetomany_contact_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/contact/onetomany/_contact.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (contact?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',10,['name':("contacts[${i}].id"),'value':(contact?.id)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',11,['name':("contacts[${i}].new"),'value':("false")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(4)
invokeTag('hiddenField','g',14,['name':("contacts[${i}].new"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('hiddenField','g',16,['name':("contacts[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
if(true && (choice=='0')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].type', 'has-error'))
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('message','g',20,['code':("contact.type.label"),'default':("Contact Type")],-1)
printHtmlPart(10)
invokeTag('select','g',24,['id':("contacts[${i}].type"),'name':("contacts[${i}].type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeInList("CON",true,['001','002','004'])),'optionKey':("id"),'required':(""),'optionValue':("itemValue"),'value':(contact?.type?.id),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',29,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',30,['bean':(customerInstance),'field':("contacts[${i}].type")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',33,['bean':(customerInstance),'field':("contacts[${i}].type")],2)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].contactValue', 'has-error'))
printHtmlPart(17)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',39,['code':("contact.contactValue.label"),'default':("Contact Number")],-1)
printHtmlPart(10)
invokeTag('textField','g',43,['id':("contactNum"),'name':("contacts[${i}].contactValue"),'maxlength':("50"),'value':(contact?.contactValue),'class':("form-control"),'onkeyup':("updateContact()")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',49,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',52,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],2)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].isPrimaryPhone', 'has-error'))
printHtmlPart(19)
expressionOut.print(i)
printHtmlPart(20)
invokeTag('message','g',58,['code':("contact.isPrimaryPhone.label"),'default':("Is Primary Phone")],-1)
printHtmlPart(21)
if(true && (i==0)) {
printHtmlPart(22)
if(true && (!customerInstance?.contacts?.find{it?.isPrimaryPhone == true})) {
printHtmlPart(23)
invokeTag('checkBox','g',64,['name':("contacts[${i}].isPrimaryPhone"),'checked':("true"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,1)"),'class':(" phone-radio"),'value':(contact?.isPrimaryPhone)],-1)
printHtmlPart(22)
}
else {
printHtmlPart(24)
invokeTag('checkBox','g',67,['name':("contacts[${i}].isPrimaryPhone"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,1)"),'class':(" phone-radio"),'value':(contact?.isPrimaryPhone)],-1)
printHtmlPart(22)
}
printHtmlPart(11)
}
else {
printHtmlPart(22)
invokeTag('checkBox','g',71,['name':("contacts[${i}].isPrimaryPhone"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,1)"),'class':(" phone-radio"),'value':(contact?.isPrimaryPhone)],-1)
printHtmlPart(11)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',78,['bean':(customerInstance),'field':("contacts[${i}].isPrimaryPhone")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',81,['bean':(customerInstance),'field':("contacts[${i}].isPrimaryPhone")],2)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (choice=='1')) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].type', 'has-error'))
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('message','g',89,['code':("contact.contactTypeId.label"),'default':("Contact type")],-1)
printHtmlPart(10)
invokeTag('select','g',93,['id':("contacts[${i}].type"),'name':("contacts[${i}].type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeInList("CON",true,['003'])),'optionKey':("id"),'required':(""),'optionValue':("itemValue"),'value':(contact?.type?.id),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',98,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',99,['bean':(customerInstance),'field':("contacts[${i}].type")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',102,['bean':(customerInstance),'field':("contacts[${i}].type")],2)
printHtmlPart(27)
if(true && (contact?.contactValue)) {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].contactValue', 'has-error'))
printHtmlPart(17)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',108,['code':("contact.contactValue.label"),'default':("Email Address")],-1)
printHtmlPart(10)
invokeTag('textField','g',112,['name':("contacts[${i}].contactValue"),'maxlength':("50"),'value':(contact?.contactValue),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',118,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',121,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],3)
printHtmlPart(27)
}
else {
printHtmlPart(7)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].contactValue', 'has-error'))
printHtmlPart(17)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',128,['code':("contact.contactValue.label"),'default':("Email Address")],-1)
printHtmlPart(10)
invokeTag('textField','g',132,['name':("contacts[${i}].contactValue"),'maxlength':("50"),'value':("nodata@noemail.com"),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
createTagBody(4, {->
printHtmlPart(13)
invokeTag('message','g',137,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',138,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',141,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],3)
printHtmlPart(28)
}
printHtmlPart(7)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].isPrimaryEmail', 'has-error'))
printHtmlPart(29)
expressionOut.print(i)
printHtmlPart(30)
invokeTag('message','g',147,['code':("contact.isPrimaryEmail.label"),'default':("Is Primary Email")],-1)
printHtmlPart(31)
invokeTag('checkBox','g',151,['name':("contacts[${i}].isPrimaryEmail"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,2)"),'class':("email-radio"),'value':(contact?.isPrimaryEmail)],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',156,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',157,['bean':(customerInstance),'field':("contacts[${i}].isPrimaryEmail")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',160,['bean':(customerInstance),'field':("contacts[${i}].isPrimaryEmail")],2)
printHtmlPart(32)
}
printHtmlPart(5)
if(true && (choice=='2')) {
printHtmlPart(33)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].type', 'has-error'))
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('message','g',167,['code':("contact.type.label"),'default':("Contact Type")],-1)
printHtmlPart(34)
invokeTag('select','g',171,['id':("contacts[${i}].type"),'name':("contacts[${i}].type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeInList("CON",true,['004','005','006'])),'optionKey':("id"),'required':(""),'optionValue':("itemValue"),'value':(contact?.type?.id),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',176,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',177,['bean':(customerInstance),'field':("contacts[${i}].type")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',180,['bean':(customerInstance),'field':("contacts[${i}].type")],2)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: customerInstance, field: 'contacts['+i+'].contactValue', 'has-error'))
printHtmlPart(36)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',185,['code':("contact.contactValue.label"),'default':("Social Media URL")],-1)
printHtmlPart(34)
invokeTag('textField','g',189,['name':("contacts[${i}].contactValue"),'maxlength':("50"),'value':(contact?.contactValue),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('message','g',194,['error':(it)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',195,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',198,['bean':(customerInstance),'field':("contacts[${i}].contactValue")],2)
printHtmlPart(37)
}
printHtmlPart(5)
if(true && (!canDelete)) {
printHtmlPart(38)
}
printHtmlPart(39)
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
