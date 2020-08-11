import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (customerInstance?.contacts)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("customer.contacts.label"),'default':("Contacts")],-1)
printHtmlPart(10)
for( c in (customerInstance.contacts) ) {
printHtmlPart(11)
createTagBody(5, {->
expressionOut.print(c?.encodeAsHTML())
})
invokeTag('link','g',23,['controller':("contact"),'action':("show"),'id':(c.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.addresses)) {
printHtmlPart(15)
invokeTag('message','g',31,['code':("customer.addresses.label"),'default':("Addresses")],-1)
printHtmlPart(10)
for( a in (customerInstance.addresses) ) {
printHtmlPart(16)
createTagBody(5, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',34,['controller':("address"),'action':("show"),'id':(a.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.employments)) {
printHtmlPart(17)
invokeTag('message','g',42,['code':("customer.employments.label"),'default':("Employments")],-1)
printHtmlPart(10)
for( e in (customerInstance.employments) ) {
printHtmlPart(18)
createTagBody(5, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',45,['controller':("employment"),'action':("show"),'id':(e.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.businesses)) {
printHtmlPart(19)
invokeTag('message','g',53,['code':("customer.businesses.label"),'default':("Businesses")],-1)
printHtmlPart(10)
for( b in (customerInstance.businesses) ) {
printHtmlPart(20)
createTagBody(5, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',56,['controller':("business"),'action':("show"),'id':(b.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.educations)) {
printHtmlPart(21)
invokeTag('message','g',64,['code':("customer.educations.label"),'default':("Educations")],-1)
printHtmlPart(10)
for( e in (customerInstance.educations) ) {
printHtmlPart(22)
createTagBody(5, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("education"),'action':("show"),'id':(e.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.extendedinfos)) {
printHtmlPart(23)
invokeTag('message','g',75,['code':("customer.extendedinfos.label"),'default':("Extendedinfos")],-1)
printHtmlPart(10)
for( e in (customerInstance.extendedinfos) ) {
printHtmlPart(24)
createTagBody(5, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',78,['controller':("extendedInfo"),'action':("show"),'id':(e.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.otheraccts)) {
printHtmlPart(25)
invokeTag('message','g',86,['code':("customer.otheraccts.label"),'default':("Otheraccts")],-1)
printHtmlPart(10)
for( o in (customerInstance.otheraccts) ) {
printHtmlPart(26)
createTagBody(5, {->
expressionOut.print(o?.encodeAsHTML())
})
invokeTag('link','g',89,['controller':("otherAcct"),'action':("show"),'id':(o.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.attachments)) {
printHtmlPart(27)
invokeTag('message','g',97,['code':("customer.attachments.label"),'default':("Attachments")],-1)
printHtmlPart(10)
for( a in (customerInstance.attachments) ) {
printHtmlPart(28)
createTagBody(5, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',100,['controller':("attachment"),'action':("show"),'id':(a.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.presentedids)) {
printHtmlPart(29)
invokeTag('message','g',108,['code':("customer.presentedids.label"),'default':("Presentedids")],-1)
printHtmlPart(10)
for( p in (customerInstance.presentedids) ) {
printHtmlPart(30)
createTagBody(5, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',111,['controller':("presentedId"),'action':("show"),'id':(p.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.relations)) {
printHtmlPart(31)
invokeTag('message','g',119,['code':("customer.relations.label"),'default':("Relations")],-1)
printHtmlPart(10)
for( r in (customerInstance.relations) ) {
printHtmlPart(32)
createTagBody(5, {->
expressionOut.print(r?.encodeAsHTML())
})
invokeTag('link','g',122,['controller':("relation"),'action':("show"),'id':(r.id)],5)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (customerInstance?.type)) {
printHtmlPart(33)
invokeTag('message','g',130,['code':("customer.type.label"),'default':("Customer Type Id")],-1)
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(customerInstance?.type?.encodeAsHTML())
})
invokeTag('link','g',132,['controller':("type"),'action':("show"),'id':(customerInstance?.type?.id)],4)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.gender)) {
printHtmlPart(36)
invokeTag('message','g',139,['code':("customer.gender.label"),'default':("Gender Id")],-1)
printHtmlPart(37)
createTagBody(4, {->
expressionOut.print(customerInstance?.gender?.encodeAsHTML())
})
invokeTag('link','g',141,['controller':("gender"),'action':("show"),'id':(customerInstance?.gender?.id)],4)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.dosriCode)) {
printHtmlPart(38)
invokeTag('message','g',148,['code':("customer.dosriCode.label"),'default':("Customer Dosri Code Id")],-1)
printHtmlPart(39)
createTagBody(4, {->
expressionOut.print(customerInstance?.dosriCode?.encodeAsHTML())
})
invokeTag('link','g',150,['controller':("dosriCode"),'action':("show"),'id':(customerInstance?.dosriCode?.id)],4)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.status)) {
printHtmlPart(40)
invokeTag('message','g',157,['code':("customer.status.label"),'default':("Customer Status Id")],-1)
printHtmlPart(41)
createTagBody(4, {->
expressionOut.print(customerInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',159,['controller':("status"),'action':("show"),'id':(customerInstance?.status?.id)],4)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.title)) {
printHtmlPart(42)
invokeTag('message','g',166,['code':("customer.title.label"),'default':("Title ")],-1)
printHtmlPart(43)
createTagBody(4, {->
expressionOut.print(customerInstance?.title?.encodeAsHTML())
})
invokeTag('link','g',168,['controller':("lov"),'action':("show"),'id':(customerInstance?.title?.id)],4)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.civilStatus)) {
printHtmlPart(44)
invokeTag('message','g',175,['code':("customer.civilStatus.label"),'default':("Civil Status Id")],-1)
printHtmlPart(45)
createTagBody(4, {->
expressionOut.print(customerInstance?.civilStatus?.encodeAsHTML())
})
invokeTag('link','g',177,['controller':("lov"),'action':("show"),'id':(customerInstance?.civilStatus?.id)],4)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.customerId)) {
printHtmlPart(46)
invokeTag('message','g',184,['code':("customer.customerId.label"),'default':("Customer Id")],-1)
printHtmlPart(47)
invokeTag('fieldValue','g',186,['bean':(customerInstance),'field':("customerId")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.name1)) {
printHtmlPart(48)
invokeTag('message','g',193,['code':("customer.name1.label"),'default':("Name1")],-1)
printHtmlPart(49)
invokeTag('fieldValue','g',195,['bean':(customerInstance),'field':("name1")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.name2)) {
printHtmlPart(50)
invokeTag('message','g',202,['code':("customer.name2.label"),'default':("Name2")],-1)
printHtmlPart(51)
invokeTag('fieldValue','g',204,['bean':(customerInstance),'field':("name2")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.name3)) {
printHtmlPart(52)
invokeTag('message','g',211,['code':("customer.name3.label"),'default':("Name3")],-1)
printHtmlPart(53)
invokeTag('fieldValue','g',213,['bean':(customerInstance),'field':("name3")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.name4)) {
printHtmlPart(54)
invokeTag('message','g',220,['code':("customer.name4.label"),'default':("Name4")],-1)
printHtmlPart(55)
invokeTag('fieldValue','g',222,['bean':(customerInstance),'field':("name4")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.displayName)) {
printHtmlPart(56)
invokeTag('message','g',229,['code':("customer.displayName.label"),'default':("Display Name")],-1)
printHtmlPart(57)
invokeTag('fieldValue','g',231,['bean':(customerInstance),'field':("displayName")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.shortAddress)) {
printHtmlPart(58)
invokeTag('message','g',238,['code':("customer.shortAddress.label"),'default':("Short Address")],-1)
printHtmlPart(59)
invokeTag('fieldValue','g',240,['bean':(customerInstance),'field':("shortAddress")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.birthDate)) {
printHtmlPart(60)
invokeTag('message','g',247,['code':("customer.birthDate.label"),'default':("Birth Date")],-1)
printHtmlPart(61)
invokeTag('formatDate','g',249,['date':(customerInstance?.birthDate)],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.birthPlace)) {
printHtmlPart(62)
invokeTag('message','g',256,['code':("customer.birthPlace.label"),'default':("Birth Place")],-1)
printHtmlPart(63)
invokeTag('fieldValue','g',258,['bean':(customerInstance),'field':("birthPlace")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.isTaxable)) {
printHtmlPart(64)
invokeTag('message','g',265,['code':("customer.isTaxable.label"),'default':("Is Taxable")],-1)
printHtmlPart(65)
invokeTag('formatBoolean','g',267,['boolean':(customerInstance?.isTaxable)],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.creditLimit)) {
printHtmlPart(66)
invokeTag('message','g',274,['code':("customer.creditLimit.label"),'default':("Credit Limit")],-1)
printHtmlPart(67)
invokeTag('fieldValue','g',276,['bean':(customerInstance),'field':("creditLimit")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.sssNo)) {
printHtmlPart(68)
invokeTag('message','g',283,['code':("customer.sssNo.label"),'default':("Sss No")],-1)
printHtmlPart(69)
invokeTag('fieldValue','g',285,['bean':(customerInstance),'field':("sssNo")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.gisNo)) {
printHtmlPart(70)
invokeTag('message','g',292,['code':("customer.gisNo.label"),'default':("Gis No")],-1)
printHtmlPart(71)
invokeTag('fieldValue','g',294,['bean':(customerInstance),'field':("gisNo")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.tinNo)) {
printHtmlPart(72)
invokeTag('message','g',301,['code':("customer.tinNo.label"),'default':("Tin No")],-1)
printHtmlPart(73)
invokeTag('fieldValue','g',303,['bean':(customerInstance),'field':("tinNo")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.passportNo)) {
printHtmlPart(74)
invokeTag('message','g',310,['code':("customer.passportNo.label"),'default':("Passport No")],-1)
printHtmlPart(75)
invokeTag('fieldValue','g',312,['bean':(customerInstance),'field':("passportNo")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.remarks)) {
printHtmlPart(76)
invokeTag('message','g',319,['code':("customer.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(77)
invokeTag('fieldValue','g',321,['bean':(customerInstance),'field':("remarks")],-1)
printHtmlPart(35)
}
printHtmlPart(14)
if(true && (customerInstance?.hash)) {
printHtmlPart(78)
invokeTag('message','g',328,['code':("customer.hash.label"),'default':("Hash")],-1)
printHtmlPart(79)
invokeTag('fieldValue','g',330,['bean':(customerInstance),'field':("hash")],-1)
printHtmlPart(35)
}
printHtmlPart(80)
createTagBody(3, {->
printHtmlPart(81)
createTagBody(4, {->
invokeTag('message','g',338,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',338,['class':("edit"),'action':("edit"),'resource':(customerInstance)],4)
printHtmlPart(82)
invokeTag('actionSubmit','g',339,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(83)
})
invokeTag('form','g',341,['url':([resource:customerInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(84)
})
invokeTag('captureContent','sitemesh',343,['tag':("main-content")],2)
printHtmlPart(85)
createTagBody(2, {->
printHtmlPart(86)
createClosureForHtmlPart(87, 3)
invokeTag('link','g',346,['action':("customerInquiry"),'id':(customerInstance.id),'resource':(customerInstance)],3)
printHtmlPart(88)
createTagBody(3, {->
invokeTag('message','g',347,['code':("default.button.edit.label"),'default':("Edit")],-1)
printHtmlPart(89)
})
invokeTag('link','g',347,['class':("edit"),'action':("edit"),'resource':(customerInstance)],3)
printHtmlPart(90)
})
invokeTag('captureContent','sitemesh',349,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',350,[:],1)
printHtmlPart(91)
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
