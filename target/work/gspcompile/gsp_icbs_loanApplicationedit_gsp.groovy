import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplicationedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loanApplication.label', default: 'LoanApplication'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller :'loanApplication', action:'showFinancialDetailsAjax2'))
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loanApplication', action:'addFinancialDetailAjax2'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'loanApplication', action:'showAddFinancialDetailAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller :'loanApplication', action:'updateFinancialDetailAjax2'))
printHtmlPart(11)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateFinancialDetailAjax2'))
printHtmlPart(12)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(13)
expressionOut.print(createLink(controller :'loanApplication', action:'deleteFinancialDetailAjax2'))
printHtmlPart(14)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller :'loanApplication', action:'showComakersAjax2'))
printHtmlPart(15)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(16)
expressionOut.print(createLink(controller :'loanApplication', action:'addComakerAjax2'))
printHtmlPart(17)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(18)
expressionOut.print(createLink(controller :'loanApplication', action:'deleteComakerAjax2'))
printHtmlPart(19)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'loanApplication', action:'showCollateralAjax2'))
printHtmlPart(20)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(21)
expressionOut.print(createLink(controller:'loanApplication', action:'addCollateralAjax2'))
printHtmlPart(22)
expressionOut.print(createLink(controller: 'collateralManagement', action:'search'))
printHtmlPart(23)
expressionOut.print(loanApplicationInstance?.id)
printHtmlPart(24)
expressionOut.print(createLink(controller:'loanApplication', action:'deleteCollateralAjax2'))
printHtmlPart(25)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(26)
})
invokeTag('javascript','g',235,[:],2)
printHtmlPart(27)
})
invokeTag('captureHead','sitemesh',236,[:],1)
printHtmlPart(27)
createTagBody(1, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 2)
invokeTag('captureContent','sitemesh',240,['tag':("breadcrumbs")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(30)
if(true && (flash.message)) {
printHtmlPart(31)
expressionOut.print(flash.message)
printHtmlPart(32)
}
printHtmlPart(33)
createTagBody(3, {->
printHtmlPart(34)
expressionOut.print(it)
printHtmlPart(35)
})
invokeTag('hasErrors','g',260,['bean':(loanApplicationInstance)],3)
printHtmlPart(36)
createTagBody(3, {->
printHtmlPart(37)
invokeTag('hiddenField','g',263,['name':("version"),'value':(loanApplicationInstance?.version)],-1)
printHtmlPart(38)
if(true && (loanApplicationInstance?.product?.productType?.id == 6)) {
printHtmlPart(39)
invokeTag('render','g',275,['template':("specification/form")],-1)
printHtmlPart(40)
}
else {
printHtmlPart(41)
invokeTag('render','g',279,['template':("specification/formScr")],-1)
printHtmlPart(40)
}
printHtmlPart(42)
invokeTag('render','g',283,['template':("financialDetails/list")],-1)
printHtmlPart(43)
invokeTag('render','g',286,['template':("comakers/list")],-1)
printHtmlPart(44)
invokeTag('render','g',289,['template':("collateral/list")],-1)
printHtmlPart(45)
})
invokeTag('form','g',291,['id':("loan-application-form"),'url':([resource:loanApplicationInstance, action:'update']),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',294,['tag':("main-content")],2)
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(47)
invokeTag('submitButton','g',297,['id':("save"),'name':("save"),'value':("Save"),'onclick':("validateFields();")],-1)
printHtmlPart(48)
createClosureForHtmlPart(49, 3)
invokeTag('link','g',314,['action':("show"),'id':(loanApplicationInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',358,['tag':("main-actions")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',358,[:],1)
printHtmlPart(51)
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
