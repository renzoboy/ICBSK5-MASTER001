import icbs.deposit.Deposit
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnInquiryview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnInquiry/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'tellering', action:'showTxnAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'tellering', action:'search'))
printHtmlPart(6)
})
invokeTag('javascript','g',57,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',58,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(8, 2)
invokeTag('captureContent','sitemesh',62,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('textField','g',82,['name':("txnID"),'value':(""),'class':("form-control")],-1)
printHtmlPart(14)
})
invokeTag('form','g',86,['action':("show")],3)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',252,['name':("_format"),'value':("PDF")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',253,['name':("_name"),'value':("Teller Transaction Report")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',254,['name':("_file"),'value':("txn_inquiry")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',255,['name':("tid"),'value':(""),'id':("create_report_id")],-1)
printHtmlPart(17)
})
invokeTag('form','g',259,['action':("createReport")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',261,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',265,['action':("index"),'onclick':("return confirm('Are you sure you want to return to tellering index Page?');")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',267,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',268,[:],1)
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
