import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempshowFinancialDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/showFinancialDetails.gsp" }
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
expressionOut.print(createLink(controller :'loanApplication', action:'updateStatusAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller :'loanApplication', action:'showUpdateStatusAjax', params:[id:loanApplicationInstance.id]))
printHtmlPart(6)
})
invokeTag('javascript','g',28,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',29,[:],1)
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
invokeTag('render','g',43,['template':("showFinancialDetails")],-1)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('actionSubmit','g',65,['class':("btn"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(15)
})
invokeTag('form','g',67,['url':([resource:loanApplicationInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-content")],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',72,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',72,['class':("list"),'action':("index")],3)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',73,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(19)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',74,['action':("showDetails"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(19)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',75,['action':("editSpecification"),'resource':(loanApplicationInstance)],3)
printHtmlPart(19)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',76,['action':("editFinancialDetails"),'resource':(loanApplicationInstance)],3)
printHtmlPart(19)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',77,['action':("editComakers"),'resource':(loanApplicationInstance)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',80,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(26)
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
