import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_address_onetomany_address_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/address/onetomany/_address.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (address?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',9,['name':("addresses[${i}].id"),'value':(address?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',10,['name':("addresses[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',13,['name':("addresses[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',15,['name':("addresses[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].type', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('message','g',20,['code':("address.type.label"),'default':("Address Type")],-1)
printHtmlPart(8)
invokeTag('select','g',24,['id':("addresses[${i}].type"),'name':("addresses[${i}].type.id"),'from':(icbs.lov.AddressType.list()),'optionKey':("id"),'optionValue':("description"),'value':(address?.type?.id),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',29,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',30,['bean':(customerInstance),'field':("addresses[${i}].type")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',33,['bean':(customerInstance),'field':("addresses[${i}].type")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].address1', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(15)
invokeTag('message','g',38,['code':("address.address1.label"),'default':("Address")],-1)
printHtmlPart(16)
invokeTag('textField','g',42,['placeholder':("Room No./Office Name, Bldg/House No., Street "),'name':("addresses[${i}].address1"),'maxlength':("200"),'value':(address?.address1),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',48,['bean':(customerInstance),'field':("addresses[${i}].address1")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',51,['bean':(customerInstance),'field':("addresses[${i}].address1")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].address2', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(17)
invokeTag('textField','g',58,['placeholder':("Subd/Barangay"),'name':("addresses[${i}].address2"),'maxlength':("200"),'value':(address?.address2),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',64,['bean':(customerInstance),'field':("addresses[${i}].address2")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',67,['bean':(customerInstance),'field':("addresses[${i}].address2")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].town', 'has-error'))
printHtmlPart(19)
expressionOut.print(i)
printHtmlPart(20)
invokeTag('message','g',73,['code':("address.region.label"),'default':("Town")],-1)
printHtmlPart(21)
invokeTag('select','g',76,['noSelection':(['null':'Town/City, Province']),'name':("addresses[${i}].town.id"),'from':(icbs.lov.Town.list()),'optionKey':("id"),'value':(address?.town?.id),'class':("form-control")],-1)
printHtmlPart(22)
createTagBody(1, {->
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('message','g',81,['error':(it)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',82,['bean':(customerInstance),'field':("addresses[${i}].town")],2)
printHtmlPart(26)
})
invokeTag('hasErrors','g',85,['bean':(customerInstance),'field':("addresses[${i}].town")],1)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].countryId', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(28)
invokeTag('message','g',91,['code':("address.countryId.label"),'default':("Country")],-1)
printHtmlPart(8)
invokeTag('select','g',95,['id':("addresses[${i}].countryId"),'name':("addresses[${i}].countryId.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("CTRY",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(address?.countryId?.id),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',100,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',101,['bean':(customerInstance),'field':("addresses[${i}].countryId")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',104,['bean':(customerInstance),'field':("addresses[${i}].countryId")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].address3', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(30)
invokeTag('message','g',110,['code':("address.address3.label"),'default':("Postal Code")],-1)
printHtmlPart(31)
invokeTag('textField','g',114,['name':("addresses[${i}].address3"),'maxlength':("6"),'value':(address?.address3),'class':("form-control")],-1)
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',120,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',121,['bean':(customerInstance),'field':("addresses[${i}].address3")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',124,['bean':(customerInstance),'field':("addresses[${i}].address3")],1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].phone1', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(34)
invokeTag('message','g',132,['code':("address.phone1.label"),'default':("Phone 1")],-1)
printHtmlPart(8)
invokeTag('textField','g',136,['name':("addresses[${i}].phone1"),'maxlength':("30"),'value':(address?.phone1),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',141,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',142,['bean':(customerInstance),'field':("addresses[${i}].phone1")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',145,['bean':(customerInstance),'field':("addresses[${i}].phone1")],1)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].phone2', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(36)
invokeTag('message','g',151,['code':("address.phone2.label"),'default':("Phone 2")],-1)
printHtmlPart(8)
invokeTag('textField','g',155,['name':("addresses[${i}].phone2"),'maxlength':("30"),'value':(address?.phone2),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',160,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',161,['bean':(customerInstance),'field':("addresses[${i}].phone2")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',164,['bean':(customerInstance),'field':("addresses[${i}].phone2")],1)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].phone3', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(37)
invokeTag('message','g',170,['code':("address.phone3.label"),'default':("Fax 1")],-1)
printHtmlPart(8)
invokeTag('textField','g',174,['name':("addresses[${i}].phone3"),'maxlength':("30"),'value':(address?.phone3),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',179,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',180,['bean':(customerInstance),'field':("addresses[${i}].phone3")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',183,['bean':(customerInstance),'field':("addresses[${i}].phone3")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].phone4', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(38)
invokeTag('message','g',188,['code':("address.phone4.label"),'default':("Fax 2")],-1)
printHtmlPart(8)
invokeTag('textField','g',192,['name':("addresses[${i}].phone4"),'maxlength':("30"),'value':(address?.phone4),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',197,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',198,['bean':(customerInstance),'field':("addresses[${i}].phone4")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',201,['bean':(customerInstance),'field':("addresses[${i}].phone4")],1)
printHtmlPart(39)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].isMailing', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(40)
invokeTag('message','g',207,['code':("address.isMailing.label"),'default':("Is Mailing")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',211,['name':("addresses[${i}].isMailing"),'value':(address?.isMailing)],-1)
printHtmlPart(41)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',216,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',217,['bean':(customerInstance),'field':("addresses[${i}].isMailing")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',220,['bean':(customerInstance),'field':("addresses[${i}].isMailing")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].isMortaged', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(42)
invokeTag('message','g',226,['code':("address.isMortaged.label"),'default':("Is Mortaged")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',230,['name':("addresses[${i}].isMortaged"),'value':(address?.isMortaged)],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',235,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',236,['bean':(customerInstance),'field':("addresses[${i}].isMortaged")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',239,['bean':(customerInstance),'field':("addresses[${i}].isMortaged")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].isOwned', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(43)
invokeTag('message','g',245,['code':("address.isOwned.label"),'default':("Is Owned")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',249,['name':("addresses[${i}].isOwned"),'value':(address?.isOwned)],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',254,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',255,['bean':(customerInstance),'field':("addresses[${i}].isOwned")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',258,['bean':(customerInstance),'field':("addresses[${i}].isOwned")],1)
printHtmlPart(44)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].isPrimary', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(45)
invokeTag('message','g',264,['code':("address.isPrimary.label"),'default':("Is Primary Address")],-1)
printHtmlPart(46)
if(true && (i==0)) {
printHtmlPart(47)
if(true && (!customerInstance?.addresses?.find{it.isPrimary == true})) {
printHtmlPart(48)
invokeTag('checkBox','g',271,['name':("addresses[${i}].isPrimary"),'checked':("true"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,3)"),'class':("address-radio"),'value':(address?.isPrimary)],-1)
printHtmlPart(47)
}
else {
printHtmlPart(49)
invokeTag('checkBox','g',274,['name':("addresses[${i}].isPrimary"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,3)"),'class':("address-radio"),'value':(address?.isPrimary)],-1)
printHtmlPart(47)
}
printHtmlPart(9)
}
else {
printHtmlPart(47)
invokeTag('checkBox','g',278,['name':("addresses[${i}].isPrimary"),'onclick':("icbs.Customer.Form.Utilities.radioCheckBox(event,3)"),'class':("address-radio"),'value':(address?.isPrimary)],-1)
printHtmlPart(9)
}
printHtmlPart(50)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',284,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',285,['bean':(customerInstance),'field':("addresses[${i}].isPrimary")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',288,['bean':(customerInstance),'field':("addresses[${i}].isPrimary")],1)
printHtmlPart(51)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].isRented', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(52)
invokeTag('message','g',295,['code':("address.isRented.label"),'default':("Is Rented")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',299,['name':("addresses[${i}].isRented"),'value':(address?.isRented)],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',304,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',305,['bean':(customerInstance),'field':("addresses[${i}].isRented")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',308,['bean':(customerInstance),'field':("addresses[${i}].isRented")],1)
printHtmlPart(53)
expressionOut.print(hasErrors(bean: customerInstance, field: 'addresses['+i+'].addressSince', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(54)
invokeTag('message','g',315,['code':("address.addressSince.label"),'default':("Address Since")],-1)
printHtmlPart(8)
invokeTag('customDatePicker','g',319,['name':("addresses[${i}].addressSince"),'precision':("day"),'value':(address?.addressSince),'default':("none"),'noSelection':(['': '']),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',324,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',325,['bean':(customerInstance),'field':("addresses[${i}].addressSince")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',328,['bean':(customerInstance),'field':("addresses[${i}].addressSince")],1)
printHtmlPart(55)
if(true && (i!=0)) {
printHtmlPart(56)
}
printHtmlPart(57)
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