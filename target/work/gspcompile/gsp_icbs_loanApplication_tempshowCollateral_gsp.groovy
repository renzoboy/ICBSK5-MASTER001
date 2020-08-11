import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempshowCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/showCollateral.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'collateral.label', default: 'Collateral'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
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
if(true && (collateralInstance?.collateralType)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("collateral.collateralType.label"),'default':("Collateral Type")],-1)
printHtmlPart(10)
createTagBody(4, {->
expressionOut.print(collateralInstance?.collateralType?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("loanCollateralType"),'action':("show"),'id':(collateralInstance?.collateralType?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.estimatedValue)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("collateral.estimatedValue.label"),'default':("Estimated Value")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',31,['bean':(collateralInstance),'field':("estimatedValue")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.description)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("collateral.description.label"),'default':("Description")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(collateralInstance),'field':("description")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.remarks)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("collateral.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',49,['bean':(collateralInstance),'field':("remarks")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.status)) {
printHtmlPart(19)
invokeTag('message','g',56,['code':("collateral.status.label"),'default':("Status")],-1)
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(collateralInstance?.status?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("loanCollateralStatus"),'action':("show"),'id':(collateralInstance?.status?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.rem)) {
printHtmlPart(21)
invokeTag('message','g',65,['code':("collateral.rem.label"),'default':("Rem")],-1)
printHtmlPart(22)
createTagBody(4, {->
expressionOut.print(collateralInstance?.rem?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("collateralREM"),'action':("show"),'id':(collateralInstance?.rem?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.chattel)) {
printHtmlPart(23)
invokeTag('message','g',74,['code':("collateral.chattel.label"),'default':("Chattel")],-1)
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(collateralInstance?.chattel?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("collateralChattel"),'action':("show"),'id':(collateralInstance?.chattel?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.holdout)) {
printHtmlPart(25)
invokeTag('message','g',83,['code':("collateral.holdout.label"),'default':("Holdout")],-1)
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(collateralInstance?.holdout?.encodeAsHTML())
})
invokeTag('link','g',85,['controller':("collateralHoldout"),'action':("show"),'id':(collateralInstance?.holdout?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.pdc)) {
printHtmlPart(27)
invokeTag('message','g',92,['code':("collateral.pdc.label"),'default':("Pdc")],-1)
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(collateralInstance?.pdc?.encodeAsHTML())
})
invokeTag('link','g',94,['controller':("collateralPDC"),'action':("show"),'id':(collateralInstance?.pdc?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (collateralInstance?.loanApplications)) {
printHtmlPart(29)
invokeTag('message','g',101,['code':("collateral.loanApplications.label"),'default':("Loan Applications")],-1)
printHtmlPart(30)
for( l in (collateralInstance.loanApplications) ) {
printHtmlPart(31)
createTagBody(5, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',104,['controller':("loanApplicationCollateral"),'action':("show"),'id':(l.id)],5)
printHtmlPart(32)
}
printHtmlPart(33)
}
printHtmlPart(34)
createTagBody(3, {->
printHtmlPart(35)
createTagBody(4, {->
invokeTag('message','g',113,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',113,['class':("edit"),'action':("editCollateral"),'controller':("loanApplication"),'id':(collateralInstance.id),'params':([loanApplication:"${loanApplicationInstance?.id}"])],4)
printHtmlPart(36)
invokeTag('actionSubmit','g',114,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(37)
})
invokeTag('form','g',116,['url':([resource:collateralInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',118,['tag':("main-content")],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',121,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',122,['action':("showCollaterals"),'resource':(loanApplicationInstance)],3)
printHtmlPart(44)
createTagBody(3, {->
invokeTag('message','g',123,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',123,['action':("createCollateral")],3)
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',125,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',126,[:],1)
printHtmlPart(46)
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
