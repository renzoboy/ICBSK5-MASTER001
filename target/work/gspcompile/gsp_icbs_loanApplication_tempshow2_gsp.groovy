import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempshow2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/show2.gsp" }
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
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(6)
expressionOut.print(loanApplicationInstance.id)
printHtmlPart(7)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(9)
expressionOut.print(loanApplicationInstance?.customer?.id)
printHtmlPart(10)
})
invokeTag('javascript','g',66,[:],2)
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',67,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('render','g',81,['template':("specification/show")],-1)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('actionSubmit','g',103,['class':("btn"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(19)
})
invokeTag('form','g',105,['url':([resource:loanApplicationInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',107,['tag':("main-content")],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',110,['class':("list"),'action':("index")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',111,['class':("create"),'action':("create")],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',113,['action':("showDetails"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(23)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',114,['action':("edit"),'resource':(loanApplicationInstance)],3)
printHtmlPart(23)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',115,['action':("editSpecification"),'resource':(loanApplicationInstance)],3)
printHtmlPart(23)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',116,['action':("editFinancialDetails"),'resource':(loanApplicationInstance)],3)
printHtmlPart(23)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',117,['action':("editComakers"),'resource':(loanApplicationInstance)],3)
printHtmlPart(23)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',118,['action':("showCollaterals"),'resource':(loanApplicationInstance)],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',120,[:],1)
printHtmlPart(33)
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
