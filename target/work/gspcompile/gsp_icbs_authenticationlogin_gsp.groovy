import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_authenticationlogin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/authentication/login.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("login")],-1)
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',5,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(2)
invokeTag('stylesheet','asset',11,['src':("myCustomStyleSheet.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',12,['src':("bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',13,['src':("AdminLTE/morris/morris.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',14,['src':("alertify.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',15,['src':("themes/semantic.min.css")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',17,['src':("AdminLTE/jvectormap/jquery-jvectormap-1.2.2.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',19,['src':("AdminLTE/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css")],-1)
printHtmlPart(5)
invokeTag('javascript','asset',23,['src':("alertify.min.js")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.success)) {
printHtmlPart(9)
expressionOut.print(flash.success)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (flash.error)) {
printHtmlPart(12)
expressionOut.print(flash.error)
printHtmlPart(10)
}
printHtmlPart(13)
expressionOut.print(resource(dir: "images", file: "expresso.png"))
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'userName', 'error'))
printHtmlPart(16)
invokeTag('textField','g',68,['id':("userNameFL"),'name':("username"),'value':(userMasterInstance?.username),'class':("form-control1"),'placeholder':("Username (case-sensitive)")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'password', 'error'))
printHtmlPart(18)
invokeTag('field','g',74,['id':("passsWordFL"),'type':("password"),'name':("password"),'value':(userMasterInstance?.password),'class':("form-control1"),'placeholder':("Password (case-sensitive)")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',75,['id':("plugOnOffLogUser"),'name':("plugOnOffLogUser"),'value':("false")],-1)
printHtmlPart(20)
if(true && (flash.error == 'You are logged in other terminal.')) {
printHtmlPart(21)
invokeTag('submitButton','g',82,['id':("clickmeFL"),'name':("login"),'class':("btn bg-black btn-block"),'value':("Login")],-1)
printHtmlPart(22)
}
else {
printHtmlPart(23)
invokeTag('submitButton','g',89,['id':("clickmeFL"),'name':("login"),'class':("btn bg-black btn-block"),'value':("Login")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('form','g',92,['controller':("authentication"),'action':("authenticate")],3)
printHtmlPart(26)
invokeTag('textField','g',108,['id':("userFLusername"),'name':("userFLusername"),'class':("form-control "),'style':("width: 50%;margin: auto;text-align: center;"),'placeholder':("Enter Username (case-sensitive)")],-1)
printHtmlPart(27)
invokeTag('passwordField','g',110,['id':("userFLpassword"),'name':("userFLpassword"),'type':("password"),'class':("form-control "),'style':("width: 50%;margin: auto;text-align: center;"),'placeholder':("Enter Password (case-sensitive)")],-1)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',147,['tag':("main-content")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',148,['class':("bg-black")],1)
printHtmlPart(30)
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
