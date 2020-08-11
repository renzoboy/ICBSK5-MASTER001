import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropatransferToRopaGSP_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/transferToRopaGSP.gsp" }
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
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',10,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
createTagBody(4, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',19,['error':("${error.field} - ${error}")],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',20,['bean':(ropaInstance),'var':("error")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',22,['bean':(ropaInstance)],3)
printHtmlPart(17)
expressionOut.print(collateralInstance?.ropa?.loan?.accountNo)
printHtmlPart(18)
invokeTag('formatNumber','g',87,['format':("###,###,##0.00"),'number':(collateralInstance?.ropa?.loan?.balanceAmount)],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',88,['name':("lonbalance"),'id':("lonbalance"),'value':(collateralInstance?.ropa?.loan?.balanceAmount)],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',89,['name':("lonPerformanceId"),'id':("lonPerformanceId"),'value':(collateralInstance?.ropa?.loan?.loanPerformanceId.id)],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',90,['name':("loanStatusId"),'id':("loanStatusId"),'value':(collateralInstance?.ropa?.loan?.status.id)],-1)
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'transferAmount', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',97,['code':("RopaTransfer.transferAmount.label"),'default':("Transfer Amount")],-1)
printHtmlPart(24)
invokeTag('field','g',99,['name':("transferAmount"),'id':("transferAmount"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(25)
createTagBody(4, {->
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(27)
invokeTag('message','g',105,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',106,['bean':(transferToRopaInstance),'field':("transferAmount")],5)
printHtmlPart(29)
})
invokeTag('hasErrors','g',109,['bean':(transferToRopaInstance),'field':("transferAmount")],4)
printHtmlPart(30)
invokeTag('render','g',112,['template':("details/transferDetails")],-1)
printHtmlPart(31)
invokeTag('render','g',115,['template':("ropaTransfer/form")],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',116,['id':("collateral"),'name':("collateral"),'value':(collateralInstance?.id)],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',117,['id':("transferRopa"),'name':("transferRopa"),'value':(transferToRopaInstance?.id)],-1)
printHtmlPart(33)
})
invokeTag('form','g',119,['id':("save"),'url':([controller:'ropa', action:'saveTransferToRopa']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(35)
createTagBody(3, {->
invokeTag('message','g',125,['code':("default.cancel.label"),'args':([entityName]),'default':("List of ROPA")],-1)
})
invokeTag('link','g',125,['action':("index")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(37)
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
