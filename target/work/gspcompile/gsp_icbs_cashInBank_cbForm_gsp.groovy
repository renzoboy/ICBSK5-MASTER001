import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBank_cbForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/_cbForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',6,['name':("cashInBankInstance"),'value':(cashInBankInstance)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'intRate', 'has-error'))
printHtmlPart(2)
invokeTag('field','g',12,['class':("form-control"),'type':("number"),'name':("seriesStart"),'value':("")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(cashInBankInstance),'field':("seriesStart")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(cashInBankInstance),'field':("seriesStart")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: cashInBankInstance, field: 'seriesEnd', 'has-error'))
printHtmlPart(9)
invokeTag('field','g',28,['class':("form-control"),'type':("number"),'name':("seriesEnd"),'value':("")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',33,['error':(it?.code)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',34,['bean':(cashInBankInstance),'field':("seriesEnd")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',37,['bean':(cashInBankInstance),'field':("seriesEnd")],1)
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
