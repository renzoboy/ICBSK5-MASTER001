import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'loanApplication', action:'showFinancialDetailsAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'loanApplication', action:'addFinancialDetailAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'loanApplication', action:'showAddFinancialDetailAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'loanApplication', action:'updateFinancialDetailAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'loanApplication', action:'showUpdateFinancialDetailAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteFinancialDetailAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'loanApplication', action:'showComakersAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'loanApplication', action:'addComakerAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(15)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteComakerAjax'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'loanApplication', action:'showCollateralAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller:'loanApplication', action:'addCollateralAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller: 'collateralManagement', action:'search'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteCollateralAjax'))
printHtmlPart(20)
expressionOut.print(loanApplicationInstance?.customer?.id ?: customer?.id)
printHtmlPart(21)
})
invokeTag('javascript','g',271,[:],2)
printHtmlPart(22)
})
invokeTag('captureHead','sitemesh',272,[:],1)
printHtmlPart(22)
createTagBody(1, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 2)
invokeTag('captureContent','sitemesh',276,['tag':("breadcrumbs")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(25)
if(true && (flash.message)) {
printHtmlPart(26)
expressionOut.print(flash.message)
printHtmlPart(27)
}
printHtmlPart(28)
createTagBody(3, {->
printHtmlPart(29)
expressionOut.print(it)
printHtmlPart(30)
})
invokeTag('hasErrors','g',296,['bean':(loanApplicationInstance)],3)
printHtmlPart(31)
createTagBody(3, {->
printHtmlPart(32)
invokeTag('render','g',309,['template':("specification/form")],-1)
printHtmlPart(33)
invokeTag('render','g',312,['template':("financialDetails/list")],-1)
printHtmlPart(34)
invokeTag('render','g',315,['template':("comakers/list")],-1)
printHtmlPart(35)
invokeTag('render','g',318,['template':("collateral/list")],-1)
printHtmlPart(36)
})
invokeTag('form','g',321,['id':("loan-application-form"),'url':([resource:loanApplicationInstance, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',323,['tag':("main-content")],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('submitButton','g',326,['id':("save"),'name':("save"),'value':("Save"),'onclick':("validateFields();")],-1)
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',336,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',384,['tag':("main-actions")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',385,[:],1)
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
