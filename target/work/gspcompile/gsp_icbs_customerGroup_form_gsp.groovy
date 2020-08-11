import icbs.admin.CustomerGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroup_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: customerGroupInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("customerGroup.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['name':("code"),'maxlength':("10"),'required':(""),'value':(customerGroupInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',15,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',16,['bean':(customerGroupInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',19,['bean':(customerGroupInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: customerGroupInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',26,['code':("customerGroup.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',29,['name':("name"),'maxlength':("50"),'required':(""),'value':(customerGroupInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',35,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',36,['bean':(customerGroupInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',39,['bean':(customerGroupInstance),'field':("name")],1)
printHtmlPart(10)
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
