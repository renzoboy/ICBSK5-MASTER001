import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMasterchangePassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/changePassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (msg)) {
printHtmlPart(7)
expressionOut.print(flash.success)
printHtmlPart(8)
expressionOut.print(msg)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('hiddenField','g',37,['name':("version"),'value':(userMasterInstance?.version)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'password', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',42,['code':("userMaster.password.label"),'default':("Current Password")],-1)
printHtmlPart(14)
invokeTag('passwordField','g',45,['name':("password"),'maxlength':("50"),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
createTagBody(5, {->
printHtmlPart(17)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',52,['bean':(userMasterInstance),'field':("password")],5)
printHtmlPart(19)
})
invokeTag('hasErrors','g',55,['bean':(userMasterInstance),'field':("password")],4)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'newPassword', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',61,['code':("userMaster.newPassword.label"),'default':("New Password")],-1)
printHtmlPart(14)
invokeTag('passwordField','g',64,['name':("newPassword"),'maxlength':("50"),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
createTagBody(5, {->
printHtmlPart(17)
invokeTag('message','g',70,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',71,['bean':(userMasterInstance),'field':("newPassword")],5)
printHtmlPart(19)
})
invokeTag('hasErrors','g',74,['bean':(userMasterInstance),'field':("newPassword")],4)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'confirmNewPassword', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',80,['code':("userMaster.confirmNewPassword.label"),'default':("Confirm New Password")],-1)
printHtmlPart(14)
invokeTag('passwordField','g',83,['name':("confirmNewPassword"),'maxlength':("50"),'required':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
createTagBody(5, {->
printHtmlPart(17)
invokeTag('message','g',89,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',90,['bean':(userMasterInstance),'field':("confirmNewPassword")],5)
printHtmlPart(19)
})
invokeTag('hasErrors','g',93,['bean':(userMasterInstance),'field':("confirmNewPassword")],4)
printHtmlPart(23)
})
invokeTag('form','g',98,['id':("changePassword"),'url':([resource:userMasterInstance, action:'saveChangePassword']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',100,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('actionSubmit','g',103,['form':("changePassword"),'action':("saveChangePassword"),'value':(message(code: 'default.button.reset.label', default: 'Update'))],-1)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',105,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',107,[:],1)
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
