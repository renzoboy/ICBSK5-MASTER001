import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_installments_formupload_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/installments/_formupload.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(add)
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(2)
expressionOut.print(message)
printHtmlPart(3)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('hasErrors','g',44,['bean':(installment)],1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: installment, field: 'installmentDate', 'has-error'))
printHtmlPart(7)
createClosureForHtmlPart(8, 1)
invokeTag('uploadForm','g',52,['name':("fileinfo")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: installment, field: 'installmentDate', 'has-error'))
printHtmlPart(10)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',64,['role':("button"),'action':("downloadSampleExcel")],1)
printHtmlPart(12)
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
