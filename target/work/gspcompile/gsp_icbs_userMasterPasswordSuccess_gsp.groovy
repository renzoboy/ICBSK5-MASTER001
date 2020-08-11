import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMasterPasswordSuccess_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/PasswordSuccess.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
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
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (userMasterInstance?.username)) {
printHtmlPart(10)
invokeTag('message','g',29,['code':("userMaster.username.label"),'default':("Username")],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',30,['bean':(userMasterInstance),'field':("username")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.name1)) {
printHtmlPart(14)
invokeTag('message','g',35,['code':("userMaster.name1.label"),'default':("First Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',36,['bean':(userMasterInstance),'field':("name1")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.name2)) {
printHtmlPart(16)
invokeTag('message','g',41,['code':("userMaster.name2.label"),'default':("Middle Name")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',42,['bean':(userMasterInstance),'field':("name2")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.name3)) {
printHtmlPart(18)
invokeTag('message','g',47,['code':("userMaster.name3.label"),'default':("Last Name")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',48,['bean':(userMasterInstance),'field':("name3")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.name4)) {
printHtmlPart(20)
invokeTag('message','g',53,['code':("userMaster.name4.label"),'default':("Name4")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',54,['bean':(userMasterInstance),'field':("name4")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.birthdate)) {
printHtmlPart(22)
invokeTag('message','g',59,['code':("userMaster.birthdate.label"),'default':("Birthdate")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',60,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.birthdate)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.gender)) {
printHtmlPart(24)
invokeTag('message','g',65,['code':("userMaster.gender.label"),'default':("Gender")],-1)
printHtmlPart(25)
expressionOut.print(userMasterInstance?.gender?.description)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.address1)) {
printHtmlPart(26)
invokeTag('message','g',71,['code':("userMaster.address1.label"),'default':("Address1")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',72,['bean':(userMasterInstance),'field':("address1")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.address2)) {
printHtmlPart(28)
invokeTag('message','g',77,['code':("userMaster.address2.label"),'default':("Address2")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',78,['bean':(userMasterInstance),'field':("address2")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.province)) {
printHtmlPart(30)
invokeTag('message','g',83,['code':("userMaster.province.label"),'default':("Province")],-1)
printHtmlPart(31)
expressionOut.print(userMasterInstance?.province?.itemValue)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.zipCode)) {
printHtmlPart(32)
invokeTag('message','g',89,['code':("userMaster.zipCode.label"),'default':("Zip Code")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',90,['bean':(userMasterInstance),'field':("zipCode")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.email)) {
printHtmlPart(34)
invokeTag('message','g',95,['code':("userMaster.email.label"),'default':("Email")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',96,['bean':(userMasterInstance),'field':("email")],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.contact)) {
printHtmlPart(36)
invokeTag('message','g',101,['code':("userMaster.contact.label"),'default':("Contact")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',102,['bean':(userMasterInstance),'field':("contact")],-1)
printHtmlPart(38)
}
printHtmlPart(13)
if(true && (userMasterInstance?.dateHired)) {
printHtmlPart(39)
invokeTag('message','g',107,['code':("userMaster.dateHired.label"),'default':("Date Hired")],-1)
printHtmlPart(40)
invokeTag('formatDate','g',108,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.dateHired)],-1)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.designation)) {
printHtmlPart(41)
invokeTag('message','g',113,['code':("userMaster.designation.label"),'default':("Designation")],-1)
printHtmlPart(42)
expressionOut.print(userMasterInstance?.designation?.description)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.branch)) {
printHtmlPart(43)
invokeTag('message','g',119,['code':("userMaster.branch.label"),'default':("Branch")],-1)
printHtmlPart(44)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.branch?.name)
})
invokeTag('link','g',120,['controller':("branch"),'action':("show"),'id':(userMasterInstance?.branch?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.cash)) {
printHtmlPart(45)
invokeTag('message','g',125,['code':("userMaster.cash.label"),'default':("Cash")],-1)
printHtmlPart(46)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.cash?.name)
})
invokeTag('link','g',126,['controller':("glAccount"),'action':("show"),'id':(userMasterInstance?.cash?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.coci)) {
printHtmlPart(47)
invokeTag('message','g',131,['code':("userMaster.coci.label"),'default':("COCI")],-1)
printHtmlPart(44)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.coci?.name)
})
invokeTag('link','g',132,['controller':("glAccount"),'action':("show"),'id':(userMasterInstance?.coci?.id)],4)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (userMasterInstance?.expiryDate)) {
printHtmlPart(48)
invokeTag('message','g',137,['code':("userMaster.expiryDate.label"),'default':("Expiry Date")],-1)
printHtmlPart(49)
invokeTag('formatDate','g',138,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.expiryDate)],-1)
printHtmlPart(38)
}
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',143,['tag':("main-content")],2)
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(52)
createClosureForHtmlPart(53, 3)
invokeTag('link','g',147,['action':("resetPassword"),'resource':(userMasterInstance)],3)
printHtmlPart(54)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-actions")],2)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',150,[:],1)
printHtmlPart(56)
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
