import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policy_overrideModal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policy/_overrideModal.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('hiddenField','g',16,['name':("policyCode"),'id':("policyCode"),'value':("")],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',17,['name':("form"),'id':("form"),'value':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'userName', 'error'))
printHtmlPart(4)
invokeTag('message','g',21,['code':("userMaster.username.label"),'default':("Username")],-1)
printHtmlPart(5)
invokeTag('textField','g',24,['name':("username"),'id':("usernameOverrider"),'class':("form-control")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: userMasterInstance, field: 'password', 'error'))
printHtmlPart(7)
invokeTag('message','g',29,['code':("userMaster.password.label"),'default':("Password")],-1)
printHtmlPart(5)
invokeTag('field','g',32,['type':("password"),'name':("password"),'id':("passwordOverrider"),'class':("form-control")],-1)
printHtmlPart(8)
})
invokeTag('form','g',36,['controller':("authentication"),'action':("overrideAuthenticate"),'class':("form-horizontal"),'role':("form")],1)
printHtmlPart(9)
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
