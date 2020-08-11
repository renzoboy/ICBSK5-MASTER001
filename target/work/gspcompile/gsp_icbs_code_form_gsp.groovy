import icbs.cif.Code
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_code_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/code/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: codeInstance, field: 'type', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("code.typeId.label"),'default':("Type")],-1)
printHtmlPart(2)
invokeTag('select','g',11,['id':("type"),'name':("type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("CIFEXT",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(codeInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(codeInstance),'field':("type")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(codeInstance),'field':("type")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: codeInstance, field: 'value', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("code.value.label"),'default':("Value")],-1)
printHtmlPart(10)
invokeTag('textField','g',31,['name':("value"),'maxlength':("50"),'required':(""),'value':(codeInstance?.value),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(codeInstance),'field':("value")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(codeInstance),'field':("value")],1)
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
