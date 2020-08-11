import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempeditSpecification_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/editSpecification.gsp" }
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
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(7)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(8)
})
invokeTag('javascript','g',54,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',55,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('hasErrors','g',79,['bean':(loanApplicationInstance)],3)
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('hiddenField','g',81,['name':("version"),'value':(loanApplicationInstance?.version)],-1)
printHtmlPart(17)
invokeTag('render','g',84,['template':("specification")],-1)
printHtmlPart(18)
invokeTag('actionSubmit','g',88,['class':("btn btn-primary"),'action':("updateSpecification"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(19)
})
invokeTag('form','g',90,['url':([resource:loanApplicationInstance, action:'updateSpecification']),'method':("PUT"),'class':("form-horizontal")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-content")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',112,['class':("list"),'action':("index")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',113,['class':("create"),'action':("create")],3)
printHtmlPart(23)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',114,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',115,['action':("showDetails"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',117,['action':("editFinancialDetails"),'resource':(loanApplicationInstance)],3)
printHtmlPart(23)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',118,['action':("editComakers"),'resource':(loanApplicationInstance)],3)
printHtmlPart(23)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',119,['action':("showCollaterals"),'resource':(loanApplicationInstance)],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(32)
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
