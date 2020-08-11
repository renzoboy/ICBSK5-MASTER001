import icbs.loans.PenaltyIncomeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_penaltyIncomeSchemeedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/penaltyIncomeScheme/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'penaltyIncomeScheme.label', default: 'PenaltyIncomeScheme'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(3, 2)
invokeTag('javascript','g',25,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/penaltyIncomeScheme'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',31,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createClosureForHtmlPart(13, 3)
invokeTag('hasErrors','g',54,['bean':(penaltySchemeInstance)],3)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('hiddenField','g',56,['name':("version"),'value':(penaltyIncomeSchemeInstance?.version)],-1)
printHtmlPart(15)
invokeTag('render','g',66,['template':("details")],-1)
printHtmlPart(16)
invokeTag('render','g',71,['template':("products")],-1)
printHtmlPart(17)
})
invokeTag('form','g',75,['id':("edit"),'url':([resource:penaltyIncomeSchemeInstance, action:'update']),'method':("PUT")],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',77,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('submitButton','g',80,['name':("save"),'value':("Save"),'onclick':("jQuery('#form').submit()")],-1)
printHtmlPart(20)
invokeTag('submitButton','g',89,['name':("create"),'id':("editPenaltyIncomeScheme"),'class':("btn btn-primary"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('CFG01103', 'form#edit', 'Override Edit Penalty Income Scheme.', null);                             
                                    },
                                function(){
                                    return;
                                });                             
                        """)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',90,['action':("show"),'id':(penaltyIncomeSchemeInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(24)
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
