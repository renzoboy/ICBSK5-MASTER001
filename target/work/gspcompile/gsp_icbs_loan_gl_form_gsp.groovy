import icbs.gl.GlLink
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_gl_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/gl/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',25,['bean':(loanInstance)],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',27,['name':("id"),'id':("id"),'value':(loanInstance?.id)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: loanInstance, field: 'glLink', 'has-error'))
printHtmlPart(7)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(8)
invokeTag('select','g',33,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.list().findAll{it.type == 7}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(10)
invokeTag('select','g',36,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.list().findAll{it.type == 6}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('message','g',43,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',43,['bean':(loanInstance),'field':("glLink")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',46,['bean':(loanInstance),'field':("glLink")],2)
printHtmlPart(17)
})
invokeTag('form','g',48,['name':("update-gl-form")],1)
printHtmlPart(18)
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
