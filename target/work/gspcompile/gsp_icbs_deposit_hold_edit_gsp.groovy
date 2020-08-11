import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_hold_edit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/hold/_edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (flash.message)) {
printHtmlPart(2)
}
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(6)
expressionOut.print(error.field)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('message','g',27,['error':(error)],-1)
printHtmlPart(9)
})
invokeTag('eachError','g',28,['bean':(holdInstance),'var':("error")],2)
printHtmlPart(10)
})
invokeTag('hasErrors','g',32,['bean':(holdInstance)],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('render','g',34,['template':("hold/form"),'model':([holdInstance:holdInstance,disabled:'disabled'])],-1)
printHtmlPart(3)
})
invokeTag('form','g',1,['name':("editHoldForm")],1)
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
