import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankbankRecon_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/bankRecon.gsp" }
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
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('field','g',17,['class':("form-control"),'type':("Text"),'id':("acctno"),'name':("acctno"),'value':(bankReconInstance),'readonly':("readonly")],-1)
printHtmlPart(8)
invokeTag('message','g',23,['code':("customer.startDate.label"),'default':("Start Date")],-1)
printHtmlPart(9)
invokeTag('customDatePicker','g',27,['id':("startDate"),'name':("startDate"),'value':(""),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
invokeTag('message','g',32,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',33,['bean':(""),'field':("startDate")],4)
printHtmlPart(14)
})
invokeTag('hasErrors','g',36,['bean':(""),'field':("startDate")],3)
printHtmlPart(15)
invokeTag('message','g',42,['code':("customer.startDate.label"),'default':("End Date")],-1)
printHtmlPart(9)
invokeTag('customDatePicker','g',46,['id':("endDate"),'name':("endDate"),'value':(""),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',52,['bean':(""),'field':("endDate")],4)
printHtmlPart(14)
})
invokeTag('hasErrors','g',55,['bean':(""),'field':("endDate")],3)
printHtmlPart(16)
invokeTag('field','g',62,['class':("form-control"),'type':("Text"),'id':("begBal"),'name':("begBal"),'value':("")],-1)
printHtmlPart(17)
invokeTag('field','g',70,['class':("form-control"),'type':("Text"),'id':("endBal"),'name':("endBal"),'value':("")],-1)
printHtmlPart(18)
invokeTag('field','g',77,['class':("form-control"),'type':("Text"),'id':("balinfo"),'name':("balinfo"),'value':(""),'readonly':("readonly")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',80,['name':("cibid"),'id':("cibid"),'value':("")],-1)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-content")],2)
printHtmlPart(21)
createClosureForHtmlPart(22, 2)
invokeTag('captureContent','sitemesh',288,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',289,[:],1)
printHtmlPart(23)
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
