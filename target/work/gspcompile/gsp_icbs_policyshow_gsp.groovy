import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policyshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policy/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'policy.label', default: 'Policy'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/policy'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (policyInstance.policyTemplate.type.toString() == 'TXN')) {
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(policyInstance?.policyTemplate?.description)
printHtmlPart(15)
expressionOut.print(policyInstance?.description)
printHtmlPart(16)
invokeTag('formatNumber','g',47,['format':("###,###,##0.00"),'number':(policyInstance?.txnAmtCondition)],-1)
printHtmlPart(17)
expressionOut.print(policyInstance?.policyAction?.description)
printHtmlPart(18)
expressionOut.print(policyInstance?.reference)
printHtmlPart(19)
expressionOut.print(policyInstance?.configItemStatus?.description)
printHtmlPart(20)
for( txnTemplate in (policyInstance.txnTemplates) ) {
printHtmlPart(21)
expressionOut.print(txnTemplate.description)
printHtmlPart(22)
}
printHtmlPart(23)
for( role in (policyInstance.roles) ) {
printHtmlPart(21)
expressionOut.print(role.name)
printHtmlPart(24)
}
printHtmlPart(25)
for( approver in (policyInstance.approvers) ) {
printHtmlPart(26)
expressionOut.print(approver.name)
printHtmlPart(27)
}
printHtmlPart(28)
createClosureForHtmlPart(2, 3)
invokeTag('form','g',102,['id':("remove"),'url':([resource:policyInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',104,['tag':("main-content")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',107,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',107,['class':("create"),'action':("create")],3)
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',108,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',108,['class':("edit"),'action':("edit"),'resource':(policyInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',109,['id':("deletePolicy"),'resource':(policyInstance),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete'))],-1)
printHtmlPart(34)
if(true && (policyInstance?.configItemStatus?.id == 1 || policyInstance?.configItemStatus?.id == 2)) {
printHtmlPart(35)
invokeTag('actionSubmit','g',119,['id':("deletePolicy"),'form':("show"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00404', 'form#remove', 'Remove policy.', null);
                                },
                                function(){
                                    return;
                                });                                       
                                """)],-1)
printHtmlPart(36)
}
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',131,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',132,[:],1)
printHtmlPart(38)
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
