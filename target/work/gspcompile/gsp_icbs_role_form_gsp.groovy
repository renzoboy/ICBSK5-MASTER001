import icbs.admin.Role
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_role_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/role/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: roleInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("role.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("code"),'maxlength':("10"),'required':(""),'value':(roleInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(roleInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(roleInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: roleInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("role.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("name"),'maxlength':("50"),'required':(""),'value':(roleInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(roleInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(roleInstance),'field':("name")],1)
printHtmlPart(10)
invokeTag('hiddenField','g',45,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(11)
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
