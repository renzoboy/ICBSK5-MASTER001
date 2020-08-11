import icbs.gl.GlSortCode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glSortCode_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glSortCode/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: glSortCodeInstance, field: 'sort_code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("glSortCode.sort_code.label"),'default':("Sort Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("sort_code"),'value':(glSortCodeInstance?.sort_code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(glSortCodeInstance),'field':("sort_code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(glSortCodeInstance),'field':("sort_code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glSortCodeInstance, field: 'sort_name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("glSortCode.sort_name.label"),'default':("Sort Code Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("sort_name"),'value':(glSortCodeInstance?.sort_name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(glSortCodeInstance),'field':("sort_name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(glSortCodeInstance),'field':("sort_name")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glSortCodeInstance, field: 'parent_id', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("glSortCode.parent_id.label"),'default':("Parent Id")],-1)
printHtmlPart(11)
invokeTag('select','g',51,['id':("parent_id"),'name':("parent_id.id"),'from':(icbs.lov.GlAcctType.list()),'optionKey':("id"),'required':(""),'value':(glSortCodeInstance?.parent_id?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(glSortCodeInstance),'field':("parent_id")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(glSortCodeInstance),'field':("parent_id")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glSortCodeInstance, field: 'sort_code_status', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',68,['code':("glSortCode.sort_code_status.label"),'default':("Sort Code Status")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',71,['name':("sort_code_status"),'class':("form-control"),'value':(glSortCodeInstance?.sort_code_status)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(glSortCodeInstance),'field':("sort_code_status")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(glSortCodeInstance),'field':("sort_code_status")],1)
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
