import icbs.admin.Institution
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_institutionedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/institution/edit.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'institution.label', default: 'Institution'))],-1)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
expressionOut.print(hasErrors(bean: institution, field: 'institutionName', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',20,['code':("institutionConfig"),'default':("Institution Name")],-1)
printHtmlPart(11)
invokeTag('textField','g',23,['name':("institutionName"),'value':(icbs.admin.Institution.findByParamCode("GEN.10000").paramValue),'class':("form-control")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: institution, field: 'institutionCode', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',30,['code':("institutionConfig"),'default':("Institution Code")],-1)
printHtmlPart(11)
invokeTag('textField','g',33,['name':("institutionCode"),'required':(""),'value':(icbs.admin.Institution.findByParamCode("GEN.10010").paramValue),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('actionSubmit','g',39,['class':("btn btn-primary"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(15)
})
invokeTag('form','g',41,['url':([action:'update']),'method':("PUT")],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',43,['tag':("main-content")],2)
printHtmlPart(2)
createClosureForHtmlPart(2, 2)
invokeTag('captureContent','sitemesh',45,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',46,[:],1)
printHtmlPart(17)
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
