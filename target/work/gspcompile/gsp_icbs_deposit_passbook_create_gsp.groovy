import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_passbook_create_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/passbook/_create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (flash.message)) {
printHtmlPart(2)
expressionOut.print(flash.message)
printHtmlPart(3)
expressionOut.print(flash.message)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(8)
expressionOut.print(error.field)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',41,['error':(error)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',42,['bean':(issuePassbookInstance),'var':("error")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',46,['bean':(issuePassbookInstance)],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(13)
invokeTag('render','g',48,['template':("passbook/form"),'model':([issuePassbookInstance:issuePassbookInstance])],-1)
printHtmlPart(5)
})
invokeTag('form','g',1,['name':("savePassbookForm")],1)
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
