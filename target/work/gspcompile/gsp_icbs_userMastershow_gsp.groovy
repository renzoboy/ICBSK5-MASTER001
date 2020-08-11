import icbs.admin.UserMaster
import icbs.audit.AuditLog
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMastershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/show.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/userMaster'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (userMasterInstance?.username)) {
printHtmlPart(12)
invokeTag('message','g',40,['code':("userMaster.username.label"),'default':("Username")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',41,['bean':(userMasterInstance),'field':("username")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.name1)) {
printHtmlPart(16)
invokeTag('message','g',47,['code':("userMaster.name1.label"),'default':("First Name")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',48,['bean':(userMasterInstance),'field':("name1")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.name2)) {
printHtmlPart(18)
invokeTag('message','g',54,['code':("userMaster.name2.label"),'default':("Middle Name")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',55,['bean':(userMasterInstance),'field':("name2")],-1)
printHtmlPart(20)
}
printHtmlPart(15)
if(true && (userMasterInstance?.name3)) {
printHtmlPart(21)
invokeTag('message','g',61,['code':("userMaster.name3.label"),'default':("Last Name")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',62,['bean':(userMasterInstance),'field':("name3")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.name4)) {
printHtmlPart(23)
invokeTag('message','g',68,['code':("userMaster.name4.label"),'default':("Name4")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',69,['bean':(userMasterInstance),'field':("name4")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.birthdate)) {
printHtmlPart(25)
invokeTag('message','g',75,['code':("userMaster.birthdate.label"),'default':("Birthdate")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',76,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.birthdate)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.gender)) {
printHtmlPart(27)
invokeTag('message','g',82,['code':("userMaster.gender.label"),'default':("Gender")],-1)
printHtmlPart(28)
expressionOut.print(userMasterInstance?.gender?.description)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.address1)) {
printHtmlPart(29)
invokeTag('message','g',89,['code':("userMaster.address1.label"),'default':("Address1")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',90,['bean':(userMasterInstance),'field':("address1")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.address2)) {
printHtmlPart(31)
invokeTag('message','g',96,['code':("userMaster.address2.label"),'default':("Address2")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',97,['bean':(userMasterInstance),'field':("address2")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.province)) {
printHtmlPart(33)
invokeTag('message','g',103,['code':("userMaster.province.label"),'default':("Province")],-1)
printHtmlPart(34)
expressionOut.print(userMasterInstance?.province?.itemValue)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.zipCode)) {
printHtmlPart(35)
invokeTag('message','g',110,['code':("userMaster.zipCode.label"),'default':("Zip Code")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',111,['bean':(userMasterInstance),'field':("zipCode")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.email)) {
printHtmlPart(37)
invokeTag('message','g',117,['code':("userMaster.email.label"),'default':("Email")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',118,['bean':(userMasterInstance),'field':("email")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.contact)) {
printHtmlPart(39)
invokeTag('message','g',124,['code':("userMaster.contact.label"),'default':("Contact")],-1)
printHtmlPart(40)
invokeTag('fieldValue','g',125,['bean':(userMasterInstance),'field':("contact")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.dateHired)) {
printHtmlPart(41)
invokeTag('message','g',131,['code':("userMaster.dateHired.label"),'default':("Date Hired")],-1)
printHtmlPart(42)
invokeTag('formatDate','g',132,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.dateHired)],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.designation)) {
printHtmlPart(43)
invokeTag('message','g',138,['code':("userMaster.designation.label"),'default':("Designation")],-1)
printHtmlPart(44)
expressionOut.print(userMasterInstance?.designation?.description)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.branch)) {
printHtmlPart(45)
invokeTag('message','g',145,['code':("userMaster.branch.label"),'default':("Branch")],-1)
printHtmlPart(46)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.branch?.name)
})
invokeTag('link','g',146,['controller':("branch"),'action':("show"),'id':(userMasterInstance?.branch?.id)],4)
printHtmlPart(14)
}
printHtmlPart(47)
if(true && (userMasterInstance?.cash)) {
printHtmlPart(48)
invokeTag('message','g',152,['code':("userMaster.cash.label"),'default':("Cash")],-1)
printHtmlPart(49)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.cash?.name)
})
invokeTag('link','g',153,['controller':("glAccount"),'action':("show"),'id':(userMasterInstance?.cash?.id)],4)
printHtmlPart(14)
}
printHtmlPart(47)
if(true && (userMasterInstance?.coci)) {
printHtmlPart(50)
invokeTag('message','g',159,['code':("userMaster.coci.label"),'default':("COCI")],-1)
printHtmlPart(46)
createTagBody(4, {->
expressionOut.print(userMasterInstance?.coci?.name)
})
invokeTag('link','g',160,['controller':("glAccount"),'action':("show"),'id':(userMasterInstance?.coci?.id)],4)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.employmentType)) {
printHtmlPart(51)
invokeTag('message','g',166,['code':("userMaster.employmentType.label"),'default':("Employment Type")],-1)
printHtmlPart(52)
expressionOut.print(userMasterInstance?.employmentType?.itemValue)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (userMasterInstance?.expiryDate)) {
printHtmlPart(53)
invokeTag('message','g',173,['code':("userMaster.expiryDate.label"),'default':("User Access Expiry Date")],-1)
printHtmlPart(54)
invokeTag('formatDate','g',174,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.expiryDate)],-1)
printHtmlPart(14)
}
printHtmlPart(55)
if(true && (userMasterInstance?.expiryPwdDate)) {
printHtmlPart(53)
invokeTag('message','g',180,['code':("userMaster.expiryPwdDate.label"),'default':("Password Expiry Date")],-1)
printHtmlPart(54)
invokeTag('formatDate','g',181,['format':("MM/dd/yyyy"),'date':(userMasterInstance?.expiryPwdDate)],-1)
printHtmlPart(14)
}
printHtmlPart(55)
if(true && (userMasterInstance?.isLocked)) {
printHtmlPart(56)
invokeTag('message','g',187,['code':("userMaster.isLocked.label"),'default':("User Locked")],-1)
printHtmlPart(57)
}
printHtmlPart(47)
if(true && (userMasterInstance?.hasExceededMaxLogin)) {
printHtmlPart(58)
invokeTag('message','g',194,['code':("userMaster.hasExceededMaxLogin.label"),'default':("User Has Exceeded Max Login Attempt")],-1)
printHtmlPart(59)
invokeTag('formatBoolean','g',195,['boolean':(userMasterInstance?.hasExceededMaxLogin),'true':("Yes"),'false':("No")],-1)
printHtmlPart(14)
}
printHtmlPart(60)
if(true && (userMasterInstance?.configItemStatus)) {
printHtmlPart(61)
invokeTag('message','g',201,['code':("userMaster.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(62)
expressionOut.print(userMasterInstance?.configItemStatus?.description)
printHtmlPart(14)
}
printHtmlPart(63)
for( role in (userMasterInstance.roles) ) {
printHtmlPart(64)
expressionOut.print(role.name)
printHtmlPart(65)
}
printHtmlPart(66)
createClosureForHtmlPart(67, 3)
invokeTag('form','g',248,['id':("deactivateUser"),'url':([resource:userMasterInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(68)
createClosureForHtmlPart(67, 3)
invokeTag('form','g',249,['id':("lockUserForm"),'url':([resource:userMasterInstance, action:'lock']),'method':("DELETE")],3)
printHtmlPart(68)
createClosureForHtmlPart(67, 3)
invokeTag('form','g',251,['id':("unlockUserForm"),'url':([resource:userMasterInstance, action:'unlock']),'method':("DELETE")],3)
printHtmlPart(69)
})
invokeTag('captureContent','sitemesh',252,['tag':("main-content")],2)
printHtmlPart(70)
createTagBody(2, {->
printHtmlPart(71)
createTagBody(3, {->
invokeTag('message','g',254,['code':("default.new.user"),'args':([entityName]),'default':("New User")],-1)
})
invokeTag('link','g',254,['class':("create"),'action':("create")],3)
printHtmlPart(72)
createTagBody(3, {->
invokeTag('message','g',257,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',257,['action':("edit"),'resource':(userMasterInstance)],3)
printHtmlPart(72)
createClosureForHtmlPart(73, 3)
invokeTag('link','g',258,['action':("resetPassword"),'resource':(userMasterInstance)],3)
printHtmlPart(72)
createClosureForHtmlPart(74, 3)
invokeTag('link','g',261,['action':("forceLogout"),'resource':(userMasterInstance)],3)
printHtmlPart(75)
createTagBody(3, {->
printHtmlPart(76)
invokeTag('hiddenField','g',270,['name':("id"),'id':("id"),'value':(params?.id)],-1)
printHtmlPart(77)
})
invokeTag('form','g',270,['name':("refreshUserBalance"),'id':("refreshUserBalance"),'onsubmit':("callLoadingDialog();"),'url':([action:'refreshBalance',controller:'userMaster']),'method':("POST")],3)
printHtmlPart(78)
invokeTag('actionSubmit','g',280,['id':("deleteUser"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00504', 'form#deactivateUser', 'Delete User.', null);
                                },
                                function(){
                                    return;
                                });                          
                    """)],-1)
printHtmlPart(79)
if(true && (!userMasterInstance.hasExceededMaxLogin && !userMasterInstance.isLocked)) {
printHtmlPart(80)
invokeTag('actionSubmit','g',287,['id':("lockUser"),'action':("lock"),'value':(message(code: 'default.button.unlock.label', default: 'Lock User')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to lock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#lockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                              
                        """)],-1)
printHtmlPart(79)
}
else {
printHtmlPart(80)
invokeTag('actionSubmit','g',296,['id':("unlockUser"),'action':("unlock"),'value':(message(code: 'default.button.unlock.label', default: 'Unlock User')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to unlock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#unlockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                               
                        """)],-1)
printHtmlPart(79)
}
printHtmlPart(81)
})
invokeTag('captureContent','sitemesh',324,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',325,[:],1)
printHtmlPart(82)
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
