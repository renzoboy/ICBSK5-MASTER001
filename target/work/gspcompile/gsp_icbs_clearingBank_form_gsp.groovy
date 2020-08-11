import icbs.admin.ClearingBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_clearingBank_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/clearingBank/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("clearingBank.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("code"),'maxlength':("50"),'required':(""),'value':(clearingBankInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(clearingBankInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(clearingBankInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("clearingBank.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("name"),'maxlength':("100"),'required':(""),'value':(clearingBankInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(clearingBankInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(clearingBankInstance),'field':("name")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'shortName', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("clearingBank.shortName.label"),'default':("Short Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',51,['name':("shortName"),'maxlength':("50"),'required':(""),'value':(clearingBankInstance?.shortName),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(clearingBankInstance),'field':("shortName")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(clearingBankInstance),'field':("shortName")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'address', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',68,['code':("clearingBank.address.label"),'default':("Address")],-1)
printHtmlPart(12)
invokeTag('textArea','g',71,['name':("address"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(clearingBankInstance?.address),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(clearingBankInstance),'field':("address")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(clearingBankInstance),'field':("address")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'contactPerson', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("clearingBank.contactPerson.label"),'default':("Contact Person")],-1)
printHtmlPart(12)
invokeTag('textField','g',91,['name':("contactPerson"),'maxlength':("50"),'value':(clearingBankInstance?.contactPerson),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',98,['bean':(clearingBankInstance),'field':("contactPerson")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',101,['bean':(clearingBankInstance),'field':("contactPerson")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'contact', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',108,['code':("clearingBank.contact.label"),'default':("Contact")],-1)
printHtmlPart(12)
invokeTag('textField','g',111,['name':("contact"),'maxlength':("50"),'value':(clearingBankInstance?.contact),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',118,['bean':(clearingBankInstance),'field':("contact")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',121,['bean':(clearingBankInstance),'field':("contact")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'email', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',128,['code':("clearingBank.email.label"),'default':("Email")],-1)
printHtmlPart(12)
invokeTag('textField','g',131,['name':("email"),'maxlength':("50"),'value':(clearingBankInstance?.email),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',137,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',138,['bean':(clearingBankInstance),'field':("email")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',141,['bean':(clearingBankInstance),'field':("email")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: clearingBankInstance, field: 'swiftCode', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',148,['code':("clearingBank.swiftCode.label"),'default':("Swift Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',151,['name':("swiftCode"),'maxlength':("10"),'required':(""),'value':(clearingBankInstance?.swiftCode),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',157,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',158,['bean':(clearingBankInstance),'field':("swiftCode")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',161,['bean':(clearingBankInstance),'field':("swiftCode")],1)
printHtmlPart(17)
invokeTag('hiddenField','g',165,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(18)
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
