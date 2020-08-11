import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempeditFinancialDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/editFinancialDetails.gsp" }
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
invokeTag('javascript','asset',8,['src':("loan-scripts.js")],-1)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(5)
expressionOut.print(createLink(controller :'loanApplication', action:'showFinancialDetailFormAjax'))
printHtmlPart(6)
})
invokeTag('javascript','g',41,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('hasErrors','g',63,['bean':(loanApplicationInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('hiddenField','g',68,['name':("version"),'value':(loanApplicationInstance?.version)],-1)
printHtmlPart(15)
invokeTag('render','g',70,['template':("financialDetails")],-1)
printHtmlPart(16)
invokeTag('actionSubmit','g',74,['class':("btn btn-primary"),'action':("updateFinancialDetails"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(17)
})
invokeTag('form','g',74,['url':([resource:loanApplicationInstance, action:'updateFinancialDetails']),'method':("PUT"),'class':("form-horizontal")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',92,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',95,['class':("list"),'action':("index")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',100,['class':("create"),'action':("create")],3)
printHtmlPart(21)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',102,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(21)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',103,['action':("showDetails"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(21)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',104,['action':("editSpecification"),'resource':(loanApplicationInstance)],3)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',106,['action':("editComakers"),'resource':(loanApplicationInstance)],3)
printHtmlPart(21)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',107,['action':("showCollaterals"),'resource':(loanApplicationInstance)],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',109,[:],1)
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
