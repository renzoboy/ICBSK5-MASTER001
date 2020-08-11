import icbs.gl.FsControlAccount
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fsControlAccount_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fsControlAccount/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',4,['name':("idto"),'id':("idto"),'value':(params.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: fsControlAccountInstance, field: 'reference', 'has-error'))
printHtmlPart(3)
invokeTag('textField','g',8,['name':("account"),'id':("account"),'required':(""),'value':(fsControlAccountInstance?.account),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',13,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',14,['bean':(fsControlAccountInstance),'field':("account")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',17,['bean':(fsControlAccountInstance),'field':("account")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: fsControlAccountInstance, field: 'reference', 'has-error'))
printHtmlPart(10)
invokeTag('textField','g',22,['name':("description"),'id':("description"),'required':(""),'value':(fsControlAccountInstance?.description),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',27,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',28,['bean':(fsControlAccountInstance),'field':("description")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',31,['bean':(fsControlAccountInstance),'field':("description")],1)
printHtmlPart(11)
if(true && (fsControlAccountInstance)) {
printHtmlPart(12)
invokeTag('hiddenField','g',35,['id':("fsControlId"),'name':("fsControlId"),'value':(fsControlAccountInstance?.id)],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: fsControlAccountInstance, field: 'status', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',38,['code':("fsControlAccountInstance.status.label"),'default':("status")],-1)
printHtmlPart(15)
invokeTag('select','g',41,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.list()),'optionKey':("id"),'required':(""),'value':(fsControlAccountInstance?.status?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',48,['bean':(fsControlAccountInstance),'field':("status")],3)
printHtmlPart(20)
})
invokeTag('hasErrors','g',51,['bean':(fsControlAccountInstance),'field':("status")],2)
printHtmlPart(21)
}
printHtmlPart(22)
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
