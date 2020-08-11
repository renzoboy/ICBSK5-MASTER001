import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanDeductionSchemecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanDeductionScheme/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'loanDeductionScheme.label', default: 'LoanDeductionScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',38,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',39,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/loanDeductionScheme'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',44,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(6)
createClosureForHtmlPart(12, 3)
invokeTag('hasErrors','g',67,['bean':(loanDeductionSchemeInstance)],3)
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('render','g',78,['template':("details")],-1)
printHtmlPart(14)
invokeTag('render','g',83,['template':("products")],-1)
printHtmlPart(15)
})
invokeTag('form','g',87,['id':("create"),'url':([resource:loanDeductionSchemeInstance, action:'save'])],3)
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',89,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('submitButton','g',92,['name':("save"),'value':("Save"),'onclick':("jQuery('#form').submit()")],-1)
printHtmlPart(18)
invokeTag('submitButton','g',101,['name':("create"),'id':("newLoanDeductionScheme"),'class':("btn btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01302', 'form#create', 'Override new loan deduction scheme.', null);                               
                                    },
                                function(){
                                    return;
                                });                             
                        """)],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',102,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',113,['tag':("main-actions")],2)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',114,[:],1)
printHtmlPart(23)
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
