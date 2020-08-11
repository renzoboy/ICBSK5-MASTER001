import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_userMasterresetPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userMaster/resetPassword.gsp" }
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
expressionOut.print(createLink(action:'generatePassword', 'controller':'userMaster'))
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/userMaster'))
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('link','g',23,['action':("show"),'resource':(userMasterInstance)],3)
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',25,['tag':("breadcrumbs")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(17)
expressionOut.print(error.field)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',35,['error':(error)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',36,['bean':(userMasterInstance),'var':("error")],4)
printHtmlPart(21)
})
invokeTag('hasErrors','g',38,['bean':(userMasterInstance)],3)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('hiddenField','g',40,['name':("version"),'value':(userMasterInstance?.version)],-1)
printHtmlPart(23)
invokeTag('message','g',44,['code':("userMaster.name.label"),'default':("User")],-1)
printHtmlPart(24)
invokeTag('textField','g',46,['name':("name"),'value':(userMasterInstance?.name1 + ' ' + userMasterInstance?.name2),'class':("form-control"),'disabled':("disabled")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'password', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',52,['code':("userMaster.password.label"),'default':("Password")],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',57,['id':("newPasswordHiddenField"),'name':("password"),'value':("")],-1)
printHtmlPart(28)
invokeTag('textField','g',58,['id':("newPasswordTextField"),'name':("p"),'required':(""),'disabled':("disabled"),'value':(""),'size':("30")],-1)
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
createTagBody(5, {->
printHtmlPart(31)
invokeTag('message','g',64,['error':(it)],-1)
printHtmlPart(32)
})
invokeTag('eachError','g',65,['bean':(userMasterInstance),'field':("password")],5)
printHtmlPart(33)
})
invokeTag('hasErrors','g',68,['bean':(userMasterInstance),'field':("password")],4)
printHtmlPart(34)
})
invokeTag('form','g',72,['id':("resetPassword"),'url':([resource:userMasterInstance, action:'saveResetPassword']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',74,['tag':("main-content")],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
invokeTag('actionSubmit','g',77,['id':("resetUserPassword"),'action':("saveResetPassword"),'value':(message(code: 'default.button.reset.label', default: 'Reset'))],-1)
printHtmlPart(38)
createTagBody(3, {->
invokeTag('message','g',78,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',78,['action':("show"),'resource':(userMasterInstance)],3)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-actions")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',92,[:],1)
printHtmlPart(41)
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
