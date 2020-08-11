import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDet_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glAcct', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("cfgAcctGlTemplateDet.glAcct.label"),'default':("Gl Acct ${cfgAcctGlTemplateDetInstance?.glAcct}")],-1)
printHtmlPart(2)
invokeTag('textField','g',9,['id':("glAcct"),'name':("glAcct"),'required':(""),'value':(cfgAcctGlTemplateDetInstance?.glCode),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',15,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',16,['bean':(cfgAcctGlTemplateDetInstance),'field':("glAcct")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',19,['bean':(cfgAcctGlTemplateDetInstance),'field':("glAcct")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',26,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Description")],-1)
printHtmlPart(10)
invokeTag('textField','g',29,['name':("glDescription"),'required':(""),'value':(cfgAcctGlTemplateDetInstance?.glDescription),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',35,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',36,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',39,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glTemplate', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',46,['code':("cfgAcctGlTemplateDet.glTemplate.label"),'default':("Gl Template")],-1)
printHtmlPart(10)
invokeTag('select','g',49,['id':("glTemplate"),'name':("glTemplate.id"),'from':(icbs.gl.CfgAcctGlTemplate.list()),'optionValue':("description"),'optionKey':("id"),'required':(""),'value':(cfgAcctGlTemplateDetInstance?.glTemplate?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',56,['bean':(cfgAcctGlTemplateDetInstance),'field':("glTemplate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',59,['bean':(cfgAcctGlTemplateDetInstance),'field':("glTemplate")],1)
printHtmlPart(13)
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
