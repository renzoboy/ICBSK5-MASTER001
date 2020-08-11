import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_exportindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/export/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',29,['action':("cif"),'class':("btn btn-primary")],3)
printHtmlPart(12)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',33,['action':("deposit"),'class':("btn btn-primary")],3)
printHtmlPart(13)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',37,['action':("loanAccount"),'class':("btn btn-primary")],3)
printHtmlPart(14)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',41,['action':(""),'class':("btn btn-primary")],3)
printHtmlPart(15)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',45,['action':(""),'class':("btn btn-primary")],3)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',49,['action':("depEdCollectionProcessing"),'class':("btn btn-primary")],3)
printHtmlPart(18)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',53,['action':("loanCollectionProcessing"),'class':("btn btn-primary")],3)
printHtmlPart(19)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',57,['action':("loanCollMixedBatch"),'class':("btn btn-primary")],3)
printHtmlPart(20)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',61,['action':("importGlTransactions"),'class':("btn btn-primary")],3)
printHtmlPart(21)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',65,['action':("importDepositList"),'class':("btn btn-primary")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',72,['tag':("main-content")],2)
printHtmlPart(6)
createClosureForHtmlPart(23, 2)
invokeTag('captureContent','sitemesh',76,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(24)
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
