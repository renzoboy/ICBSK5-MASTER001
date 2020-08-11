import icbs.admin.UserMaster
import icbs.admin.Currency
import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMaster_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'name1', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',9,['code':("userMaster.name1.label"),'default':("First Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',13,['name':("name1"),'maxlength':("50"),'required':(""),'value':(userMasterInstance?.name1),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',18,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',19,['bean':(userMasterInstance),'field':("name1")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',22,['bean':(userMasterInstance),'field':("name1")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'name2', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',29,['code':("userMaster.name2.label"),'default':("Middle Name")],-1)
printHtmlPart(11)
invokeTag('textField','g',31,['name':("name2"),'maxlength':("50"),'value':(userMasterInstance?.name2),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',38,['bean':(userMasterInstance),'field':("name2")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',41,['bean':(userMasterInstance),'field':("name2")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'name3', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',48,['code':("userMaster.name3.label"),'default':("Last Name")],-1)
printHtmlPart(14)
invokeTag('textField','g',52,['name':("name3"),'maxlength':("50"),'required':(""),'value':(userMasterInstance?.name3),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',58,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',59,['bean':(userMasterInstance),'field':("name3")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',62,['bean':(userMasterInstance),'field':("name3")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'birthdate', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',69,['code':("userMaster.birthdate.label"),'default':("Birthdate")],-1)
printHtmlPart(16)
invokeTag('customDatePicker','g',72,['name':("birthdate"),'required':(""),'precision':("day"),'class':("form-control"),'value':(userMasterInstance?.birthdate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',78,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',79,['bean':(userMasterInstance),'field':("birthdate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',82,['bean':(userMasterInstance),'field':("birthdate")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'gender', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',89,['code':("userMaster.gender.label"),'default':("Gender")],-1)
printHtmlPart(16)
invokeTag('select','g',92,['id':("gender"),'name':("gender.id"),'from':(icbs.lov.Gender.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(userMasterInstance?.gender?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',98,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',99,['bean':(userMasterInstance),'field':("gender")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',102,['bean':(userMasterInstance),'field':("gender")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'address1', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',109,['code':("userMaster.address1.label"),'default':("Address1")],-1)
printHtmlPart(16)
invokeTag('textField','g',112,['name':("address1"),'maxlength':("100"),'required':(""),'value':(userMasterInstance?.address1),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',118,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',119,['bean':(userMasterInstance),'field':("address1")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',122,['bean':(userMasterInstance),'field':("address1")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'address2', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',129,['code':("userMaster.address2.label"),'default':("Address2")],-1)
printHtmlPart(20)
invokeTag('textField','g',132,['name':("address2"),'maxlength':("100"),'value':(userMasterInstance?.address2),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',138,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',139,['bean':(userMasterInstance),'field':("address2")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',142,['bean':(userMasterInstance),'field':("address2")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'province', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',149,['code':("userMaster.province.label"),'default':("Province")],-1)
printHtmlPart(20)
invokeTag('select','g',152,['id':("province"),'name':("province.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("PROV",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(userMasterInstance?.province?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',158,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',159,['bean':(userMasterInstance),'field':("province")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',162,['bean':(userMasterInstance),'field':("province")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'zipCode', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',169,['code':("userMaster.zipCode.label"),'default':("Zip Code")],-1)
printHtmlPart(16)
invokeTag('textField','g',172,['name':("zipCode"),'maxlength':("10"),'required':(""),'value':(userMasterInstance?.zipCode),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',178,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',179,['bean':(userMasterInstance),'field':("zipCode")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',182,['bean':(userMasterInstance),'field':("zipCode")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'email', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',189,['code':("userMaster.email.label"),'default':("Email")],-1)
printHtmlPart(16)
invokeTag('textField','g',192,['name':("email"),'maxlength':("100"),'required':(""),'value':(userMasterInstance?.email),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',198,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',199,['bean':(userMasterInstance),'field':("email")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',202,['bean':(userMasterInstance),'field':("email")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'contact', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',209,['code':("userMaster.contact.label"),'default':("Contact")],-1)
printHtmlPart(16)
invokeTag('textField','g',212,['name':("contact"),'maxlength':("30"),'required':(""),'value':(userMasterInstance?.contact),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',218,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',219,['bean':(userMasterInstance),'field':("contact")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',222,['bean':(userMasterInstance),'field':("contact")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'dateHired', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',229,['code':("userMaster.dateHired.label"),'default':("Date Hired")],-1)
printHtmlPart(11)
invokeTag('customDatePicker','g',231,['name':("dateHired"),'required':(""),'precision':("day"),'class':("form-control"),'value':(userMasterInstance?.dateHired),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',237,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',238,['bean':(userMasterInstance),'field':("dateHired")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',241,['bean':(userMasterInstance),'field':("dateHired")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'designation', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',248,['code':("userMaster.designation.label"),'default':("Designation")],-1)
printHtmlPart(11)
invokeTag('select','g',250,['id':("designation"),'name':("designation.id"),'from':(icbs.lov.Designation.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(userMasterInstance?.designation?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',256,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',257,['bean':(userMasterInstance),'field':("designation")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',260,['bean':(userMasterInstance),'field':("designation")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'branch', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',267,['code':("userMaster.branch.label"),'default':("Branch")],-1)
printHtmlPart(16)
invokeTag('select','g',270,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(userMasterInstance?.branch?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',276,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',277,['bean':(userMasterInstance),'field':("branch")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',280,['bean':(userMasterInstance),'field':("branch")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'cash', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',287,['code':("userMaster.cash.label"),'default':("Cash")],-1)
printHtmlPart(29)
invokeTag('select','g',289,['id':("cash"),'name':("cash.id"),'from':(icbs.gl.GlAccount.findAllByBranchAndCurrencyAndCodeLike(Branch.get(1),Currency.get(1),icbs.admin.Institution.findAllByParamCode("GLS.60100").paramValue)),'optionKey':("id"),'optionValue':("name"),'value':(userMasterInstance?.cash?.id),'noSelection':(['': '']),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',295,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',296,['bean':(userMasterInstance),'field':("cash")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',299,['bean':(userMasterInstance),'field':("cash")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'coci', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',306,['code':("userMaster.coci.label"),'default':("COCI")],-1)
printHtmlPart(29)
invokeTag('select','g',308,['id':("coci"),'name':("coci.id"),'from':(icbs.gl.GlAccount.findAllByBranchAndCurrencyAndCodeLike(Branch.get(1),Currency.get(1),icbs.admin.Institution.findAllByParamCode("GLS.60200").paramValue)),'optionKey':("id"),'optionValue':("name"),'value':(userMasterInstance?.coci?.id),'noSelection':(['': '']),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',314,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',315,['bean':(userMasterInstance),'field':("coci")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',318,['bean':(userMasterInstance),'field':("coci")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'employmentType', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',325,['code':("userMaster.employmentType.label"),'default':("Employment Type")],-1)
printHtmlPart(11)
invokeTag('select','g',327,['id':("employmentType"),'name':("employmentType.id"),'required':(""),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("CET",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(userMasterInstance?.employmentType?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',333,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',334,['bean':(userMasterInstance),'field':("employmentType")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',337,['bean':(userMasterInstance),'field':("employmentType")],1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'expiryDate', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',342,['code':("userMaster.expiryDate.label"),'default':("Access Expiry Date")],-1)
printHtmlPart(11)
invokeTag('customDatePicker','g',344,['name':("expiryDate"),'required':(""),'precision':("day"),'class':("form-control"),'value':(userMasterInstance?.expiryDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',350,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',351,['bean':(userMasterInstance),'field':("expiryDate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',354,['bean':(userMasterInstance),'field':("expiryDate")],1)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'username', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',364,['code':("userMaster.username.label"),'default':("Username")],-1)
printHtmlPart(36)
if(true && (mode=='edit')) {
printHtmlPart(37)
invokeTag('textField','g',369,['name':("username"),'maxlength':("20"),'required':(""),'value':(userMasterInstance?.username),'class':("form-control"),'disabled':("")],-1)
printHtmlPart(38)
}
else {
printHtmlPart(37)
invokeTag('textField','g',372,['name':("username"),'maxlength':("20"),'required':(""),'value':(userMasterInstance?.username),'class':("form-control")],-1)
printHtmlPart(38)
}
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',379,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',380,['bean':(userMasterInstance),'field':("username")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',383,['bean':(userMasterInstance),'field':("username")],1)
printHtmlPart(39)
if(true && (mode=='create')) {
printHtmlPart(40)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'password', 'has-error'))
printHtmlPart(41)
invokeTag('message','g',390,['code':("userMaster.password.label"),'default':("Password")],-1)
printHtmlPart(42)
invokeTag('hiddenField','g',395,['id':("newPasswordHiddenField"),'name':("password"),'value':("")],-1)
printHtmlPart(43)
invokeTag('textField','g',396,['id':("newPasswordTextField"),'name':("p"),'required':(""),'disabled':("disabled"),'value':(""),'size':("30")],-1)
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(45)
createTagBody(3, {->
printHtmlPart(46)
invokeTag('message','g',402,['error':(it)],-1)
printHtmlPart(47)
})
invokeTag('eachError','g',403,['bean':(userMasterInstance),'field':("password")],3)
printHtmlPart(48)
})
invokeTag('hasErrors','g',406,['bean':(userMasterInstance),'field':("password")],2)
printHtmlPart(49)
}
printHtmlPart(50)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'expiryDate', 'has-error'))
printHtmlPart(51)
invokeTag('message','g',414,['code':("userMaster.expiryDate.label"),'default':("Expiry Date")],-1)
printHtmlPart(52)
if(true && (mode=='create')) {
printHtmlPart(53)
invokeTag('customDatePicker','g',418,['name':("expiryDate"),'required':(""),'precision':("day"),'class':("form-control"),'value':(branchRunDate.plus(accessValidity)),'noSelection':(['': ''])],-1)
printHtmlPart(38)
}
else {
printHtmlPart(37)
invokeTag('customDatePicker','g',421,['name':("expiryDate"),'required':(""),'precision':("day"),'class':("form-control"),'value':(userMasterInstance?.expiryDate),'noSelection':(['': ''])],-1)
printHtmlPart(38)
}
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',428,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',429,['bean':(userMasterInstance),'field':("expiryDate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',432,['bean':(userMasterInstance),'field':("expiryDate")],1)
printHtmlPart(54)
invokeTag('hiddenField','g',1,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(55)
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