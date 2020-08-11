import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateglLinkEntry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/glLinkEntry.gsp" }
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
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'GlBatch', 
                                  action:'addVoucherDetails'))
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('field','g',91,['type':("text"),'name':("description"),'id':("description"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(12)
invokeTag('select','g',100,['id':("glLinkEntry"),'name':("glLinkEntry"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.GlLinkEntryType.findAllByStatus(true)),'value':(""),'optionKey':("id"),'optionValue':("description"),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',109,['name':("create"),'class':("btn btn-primary"),'value':("Show Schedule")],-1)
printHtmlPart(14)
})
invokeTag('form','g',112,['name':("myForm"),'id':("myForm"),'url':([action:'addGlLinkEntry',controller:'CfgAcctGlTemplate'])],3)
printHtmlPart(15)
})
invokeTag('captureContent','sitemesh',115,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',122,['controller':("GlBatch"),'action':("showVoucherDetails"),'id':(glBatchHdrInstance?.id),'params':(['Bid': params.Bid])],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',124,['tag':("main-actions")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',125,[:],1)
printHtmlPart(20)
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
