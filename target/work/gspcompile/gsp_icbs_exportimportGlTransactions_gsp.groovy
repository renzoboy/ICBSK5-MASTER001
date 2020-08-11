import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_exportimportGlTransactions_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/export/importGlTransactions.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
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
invokeTag('message','g',34,['code':("inwardCheckClearing.file.label"),'default':("Branch")],-1)
printHtmlPart(10)
invokeTag('select','g',37,['id':("branch"),'name':("branch"),'required':("true"),'noSelection':(['':'']),'from':(icbs.admin.Branch.list()),'value':(""),'optionKey':("id"),'optionValue':("name"),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('message','g',42,['code':("inwardCheckClearing.file.label"),'default':("Batch Name")],-1)
printHtmlPart(10)
invokeTag('textField','g',45,['id':("name"),'name':("name"),'required':("true"),'value':(""),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('message','g',50,['code':("inwardCheckClearing.file.label"),'default':("GL Journal Transactions File Name")],-1)
printHtmlPart(12)
})
invokeTag('form','g',56,['name':("loanCollForm"),'action':("processImportGl"),'controller':("Export"),'enctype':("multipart/form-data")],3)
printHtmlPart(13)
})
invokeTag('captureContent','sitemesh',58,['tag':("main-content")],2)
printHtmlPart(4)
createClosureForHtmlPart(14, 2)
invokeTag('captureContent','sitemesh',63,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(15)
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
