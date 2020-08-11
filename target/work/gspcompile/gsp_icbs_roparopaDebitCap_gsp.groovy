import icbs.loans.ROPA
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaDebitCap_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaDebitCap.gsp" }
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
expressionOut.print(createLink(uri: '/ropa'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(ropadebitInstance?.loanAcctNo)
printHtmlPart(11)
expressionOut.print(ropadebitInstance?.customerDisplayName)
printHtmlPart(12)
expressionOut.print(ropadebitInstance?.branch?.name)
printHtmlPart(13)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(ropadebitInstance?.ropaDate)],-1)
printHtmlPart(14)
invokeTag('render','g',34,['template':("details/collateralDetails")],-1)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',44,['name':("collID"),'id':("collID"),'value':(params.id)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(18)
invokeTag('select','g',50,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(53),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(19)
invokeTag('field','g',56,['class':("form-control truncated"),'id':("ropadebit"),'name':("ropadebit"),'value':("")],-1)
printHtmlPart(20)
invokeTag('field','g',63,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(21)
invokeTag('field','g',69,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(22)
})
invokeTag('form','g',73,['id':("save"),'url':([controller:'ropa', action:'taropaDebitSave']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',81,['action':("collateralShow"),'id':(collateralInstance.id)],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(28)
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
