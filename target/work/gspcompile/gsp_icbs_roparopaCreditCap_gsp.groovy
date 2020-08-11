import icbs.loans.ROPA
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaCreditCap_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaCreditCap.gsp" }
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
expressionOut.print(ropacreditInstance?.loanAcctNo)
printHtmlPart(11)
expressionOut.print(ropacreditInstance?.customerDisplayName)
printHtmlPart(12)
expressionOut.print(ropacreditInstance?.branch?.name)
printHtmlPart(13)
invokeTag('formatDate','g',30,['format':("MM/dd/yyyy"),'date':(ropacreditInstance?.ropaDate)],-1)
printHtmlPart(14)
invokeTag('render','g',34,['template':("details/collateralDetails")],-1)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('set','g',45,['var':("netBookValue"),'value':(collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt - collateralInstance?.buildingAccDepreciation - collateralInstance?.otherAccDepreciation - collateralInstance?.allowanceProbLoss - collateralInstance?.allowanceProbLossBldg - collateralInstance?.allowanceProbLossOtherProp)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',46,['name':("netBvalue"),'id':("netBvalue"),'value':(netBookValue)],-1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(19)
invokeTag('select','g',50,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(54),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(20)
invokeTag('field','g',56,['class':("form-control truncated"),'id':("ropacreditAmt"),'name':("ropacreditAmt"),'value':("")],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',59,['name':("collID"),'id':("collID"),'value':(params.id)],-1)
printHtmlPart(22)
invokeTag('field','g',63,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(23)
invokeTag('field','g',69,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(24)
})
invokeTag('form','g',73,['id':("save"),'url':([controller:'ropa', action:'saveropaCredit']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',76,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',81,['action':("collateralShow"),'id':(collateralInstance.id)],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(30)
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
