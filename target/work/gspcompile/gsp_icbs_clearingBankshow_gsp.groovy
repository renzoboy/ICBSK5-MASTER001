import icbs.admin.ClearingBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_clearingBankshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/clearingBank/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'clearingBank.label', default: 'ClearingBank'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/clearingBank'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(clearingBankInstance?.code)
printHtmlPart(13)
expressionOut.print(clearingBankInstance?.name)
printHtmlPart(14)
expressionOut.print(clearingBankInstance?.shortName)
printHtmlPart(15)
expressionOut.print(clearingBankInstance?.address)
printHtmlPart(16)
expressionOut.print(clearingBankInstance?.contactPerson)
printHtmlPart(17)
expressionOut.print(clearingBankInstance?.contact)
printHtmlPart(18)
expressionOut.print(clearingBankInstance?.email)
printHtmlPart(19)
expressionOut.print(clearingBankInstance?.swiftCode)
printHtmlPart(20)
expressionOut.print(clearingBankInstance?.configItemStatus)
printHtmlPart(21)
if(true && (clearingBankInstance?.code)) {
printHtmlPart(22)
invokeTag('message','g',86,['code':("clearingBank.code.label"),'default':("Code")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',88,['bean':(clearingBankInstance),'field':("code")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.name)) {
printHtmlPart(26)
invokeTag('message','g',95,['code':("clearingBank.name.label"),'default':("Name")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',97,['bean':(clearingBankInstance),'field':("name")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.shortName)) {
printHtmlPart(28)
invokeTag('message','g',104,['code':("clearingBank.shortName.label"),'default':("Short Name")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',106,['bean':(clearingBankInstance),'field':("shortName")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.address)) {
printHtmlPart(30)
invokeTag('message','g',113,['code':("clearingBank.address.label"),'default':("Address")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',115,['bean':(clearingBankInstance),'field':("address")],-1)
printHtmlPart(32)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.contactPerson)) {
printHtmlPart(33)
invokeTag('message','g',122,['code':("clearingBank.contactPerson.label"),'default':("Contact Person")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',124,['bean':(clearingBankInstance),'field':("contactPerson")],-1)
printHtmlPart(32)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.contact)) {
printHtmlPart(35)
invokeTag('message','g',131,['code':("clearingBank.contact.label"),'default':("Contact")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',133,['bean':(clearingBankInstance),'field':("contact")],-1)
printHtmlPart(32)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.email)) {
printHtmlPart(37)
invokeTag('message','g',140,['code':("clearingBank.email.label"),'default':("Email")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',142,['bean':(clearingBankInstance),'field':("email")],-1)
printHtmlPart(32)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.swiftCode)) {
printHtmlPart(39)
invokeTag('message','g',149,['code':("clearingBank.swiftCode.label"),'default':("Swift Code")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',151,['bean':(clearingBankInstance),'field':("swiftCode")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (clearingBankInstance?.configItemStatus)) {
printHtmlPart(41)
invokeTag('message','g',158,['code':("clearingBank.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(42)
expressionOut.print(clearingBankInstance?.configItemStatus?.description)
printHtmlPart(24)
}
printHtmlPart(43)
invokeTag('form','g',169,['id':("delete"),'url':([resource:clearingBankInstance, action:'delete']),'method':("DELETE")],-1)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',170,['tag':("main-content")],2)
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(46)
createTagBody(3, {->
invokeTag('message','g',176,['code':("default.new.clearingBank"),'args':([entityName]),'default':("New Clearing Bank")],-1)
})
invokeTag('link','g',176,['class':("create"),'action':("create")],3)
printHtmlPart(47)
createTagBody(3, {->
invokeTag('message','g',182,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',182,['class':("edit"),'action':("edit"),'resource':(clearingBankInstance)],3)
printHtmlPart(47)
invokeTag('actionSubmit','g',187,['class':("delete"),'id':("deleteClearingBank"),'name':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00303', 'form#delete', 'Override delete clearing bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                """)],-1)
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',197,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',197,[:],1)
printHtmlPart(49)
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
