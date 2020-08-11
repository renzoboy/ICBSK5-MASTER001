import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(3)
if(true && (loanApplicationInstance?.product?.productType?.id == 6)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(4, 4)
invokeTag('captureTitle','sitemesh',9,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],3)
printHtmlPart(3)
}
printHtmlPart(3)
if(true && (loanApplicationInstance?.product?.productType?.id == 7)) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(5, 4)
invokeTag('captureTitle','sitemesh',12,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],3)
printHtmlPart(3)
}
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(9)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(10)
})
invokeTag('javascript','g',77,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',78,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('captureContent','sitemesh',82,['tag':("breadcrumbs")],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('render','g',104,['template':("specification/show")],-1)
printHtmlPart(18)
invokeTag('render','g',107,['template':("financialDetails/show")],-1)
printHtmlPart(19)
invokeTag('render','g',110,['template':("comakers/show")],-1)
printHtmlPart(20)
invokeTag('render','g',113,['template':("collateral/show")],-1)
printHtmlPart(21)
invokeTag('render','g',116,['template':("auditLog")],-1)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',137,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',140,['class':("list"),'action':("index")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',141,['action':("edit"),'resource':(loanApplicationInstance)],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',146,['controller':("creditInvestigation"),'action':("create"),'params':([id:loanApplicationInstance?.id,creditType: 'secured'])],3)
printHtmlPart(25)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',147,['controller':("creditInvestigation"),'action':("create"),'params':([id:loanApplicationInstance?.id,creditType: 'unsecured'])],3)
printHtmlPart(30)
if(true && (loanApplicationInstance?.product?.productType?.id == 6)) {
printHtmlPart(31)
createClosureForHtmlPart(32, 4)
invokeTag('link','g',149,['controller':("loan"),'action':("create"),'params':([id:loanApplicationInstance?.id])],4)
printHtmlPart(30)
}
printHtmlPart(33)
if(true && (loanApplicationInstance?.product?.productType?.id == 7)) {
printHtmlPart(31)
createClosureForHtmlPart(34, 4)
invokeTag('link','g',152,['controller':("loan"),'action':("create"),'params':([id:loanApplicationInstance?.id])],4)
printHtmlPart(30)
}
printHtmlPart(35)
createTagBody(3, {->
printHtmlPart(36)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(16).baseParams)
printHtmlPart(37)
expressionOut.print(icbs.admin.Report.get(16).outputParam)
printHtmlPart(38)
expressionOut.print(icbs.admin.Report.get(16).reportUnit)
printHtmlPart(39)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(40)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(41)
})
invokeTag('javascript','g',163,[:],3)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',164,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',165,[:],1)
printHtmlPart(42)
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
