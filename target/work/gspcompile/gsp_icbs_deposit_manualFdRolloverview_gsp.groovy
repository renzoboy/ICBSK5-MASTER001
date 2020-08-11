import icbs.deposit.Rollover
import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_manualFdRolloverview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/manualFdRollover/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("depositHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',15,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',15,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller : 'deposit', action:'createManualRolloverAjax'))
printHtmlPart(6)
expressionOut.print(depositInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'deposit', action:'saveManualRollover'))
printHtmlPart(8)
})
invokeTag('javascript','g',33,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',34,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('render','g',39,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(11)
invokeTag('render','g',42,['template':("details/ctdDetails"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(12)
expressionOut.print(depositInstance?.ownershipType?.description)
printHtmlPart(13)
if(true && (depositInstance?.signatories?.size()>0)) {
printHtmlPart(14)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(15)
if(true && (signatory.status.id!=3)) {
printHtmlPart(16)
invokeTag('render','g',66,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i,displayOnly:'true'])],-1)
printHtmlPart(15)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(depositInstance?.sigRules)
printHtmlPart(20)
expressionOut.print(depositInstance?.sigRemarks)
printHtmlPart(21)
invokeTag('render','g',93,['template':("/deposit/details/depositInfo"),'model':([depositInstance:depositInstance])],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
if(true && (depositInstance)) {
printHtmlPart(25)
expressionOut.print(depositInstance?.id)
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(depositInstance?.id)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',122,[:],1)
printHtmlPart(29)
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
