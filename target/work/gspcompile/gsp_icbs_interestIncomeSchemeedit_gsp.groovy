import icbs.loans.InterestIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_interestIncomeSchemeedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/interestIncomeScheme/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'interestIncomeScheme.label', default: 'InterestIncomeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',35,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',36,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/interestIncomeScheme'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',41,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('hasErrors','g',64,['bean':(interestIncomeSchemeInstance)],3)
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('hiddenField','g',66,['name':("version"),'value':(interestIncomeSchemeInstance?.version)],-1)
printHtmlPart(14)
invokeTag('render','g',76,['template':("details")],-1)
printHtmlPart(15)
invokeTag('render','g',81,['template':("products")],-1)
printHtmlPart(16)
})
invokeTag('form','g',85,['id':("edit"),'url':([resource:interestIncomeSchemeInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('submitButton','g',90,['name':("save"),'value':("Save"),'onclick':("jQuery('#form').submit()")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',99,['name':("edit"),'id':("editInterestIncomeScheme"),'class':("btn btn-primary"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01003', 'form#edit', 'Override Edit Interest Income Scheme.', null);                               
                                    },
                                function(){
                                    return;
                                });                              
                        """)],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',100,['action':("show"),'id':(interestIncomeSchemeInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',111,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',112,[:],1)
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
