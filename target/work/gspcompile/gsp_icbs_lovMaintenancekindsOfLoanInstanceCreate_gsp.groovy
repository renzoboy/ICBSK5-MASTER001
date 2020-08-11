import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenancekindsOfLoanInstanceCreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/kindsOfLoanInstanceCreate.gsp" }
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
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/lovMaintenance'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 4)
invokeTag('eachError','g',17,['bean':(loanKindOfLoanInstance),'var':("error")],4)
printHtmlPart(11)
})
invokeTag('hasErrors','g',19,['bean':(loanKindOfLoanInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('hiddenField','g',22,['name':("id"),'value':(loanKindOfLoanInstance?.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',23,['name':("version"),'value':(loanKindOfLoanInstance?.version)],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanKindOfLoanInstance, field: 'code', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',27,['code':("loanKindOfLoanInstance.code.label"),'default':("Code")],-1)
printHtmlPart(16)
invokeTag('textField','g',30,['name':("code"),'maxlength':("100"),'required':(""),'value':(loanKindOfLoanInstance?.code),'class':("form-control")],-1)
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
createTagBody(5, {->
printHtmlPart(19)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',37,['bean':(loanKindOfLoanInstance),'field':("code")],5)
printHtmlPart(21)
})
invokeTag('hasErrors','g',40,['bean':(loanKindOfLoanInstance),'field':("code")],4)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: loanKindOfLoanInstance, field: 'description', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',45,['code':("loanKindOfLoanInstance.description.label"),'default':("Description")],-1)
printHtmlPart(16)
invokeTag('textField','g',48,['name':("description"),'maxlength':("100"),'required':(""),'value':(loanKindOfLoanInstance?.description),'class':("form-control")],-1)
printHtmlPart(17)
createTagBody(4, {->
printHtmlPart(18)
createTagBody(5, {->
printHtmlPart(24)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',55,['bean':(loanKindOfLoanInstance),'field':("description")],5)
printHtmlPart(21)
})
invokeTag('hasErrors','g',58,['bean':(loanKindOfLoanInstance),'field':("description")],4)
printHtmlPart(25)
invokeTag('hiddenField','g',61,['name':("status"),'value':("true")],-1)
printHtmlPart(26)
invokeTag('actionSubmit','g',63,['class':("btn btn-primary"),'action':("kindsOfLoanInstanceSave"),'value':(message(code: 'default.button.created.label', default: 'Save')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to create this kind of loan?')}');")],-1)
printHtmlPart(27)
})
invokeTag('form','g',64,['controller':("lovMaintenance"),'action':("kindsOfLoanInstanceSave")],3)
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',67,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',71,['action':("kindsOfLoanIndex")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',73,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',74,[:],1)
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
