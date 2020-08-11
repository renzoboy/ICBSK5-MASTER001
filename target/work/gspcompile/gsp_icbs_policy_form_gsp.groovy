import icbs.admin.Policy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_policy_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/policy/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('select','g',11,['id':("type"),'name':("type"),'from':(['Process', 'TXN']),'value':(params.type),'class':("many-to-one form-control")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: policyInstance, field: 'policyTemplate', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',18,['code':("policy.policyTemplate.label"),'default':("Policy Template")],-1)
printHtmlPart(3)
invokeTag('select','g',21,['id':("policyTemplate"),'name':("policyTemplate.id"),'from':(""),'optionKey':("id"),'optionValue':("description"),'value':(policyInstance?.policyTemplate?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',27,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',28,['bean':(policyInstance),'field':("policyTemplate")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',31,['bean':(policyInstance),'field':("policyTemplate")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: policyInstance, field: 'description', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',74,['code':("policy.description.label"),'default':("Description")],-1)
printHtmlPart(3)
invokeTag('textField','g',77,['name':("description"),'maxlength':("100"),'required':(""),'value':(policyInstance?.description),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',83,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',84,['bean':(policyInstance),'field':("description")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',87,['bean':(policyInstance),'field':("description")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: policyInstance, field: 'txnAmtCondition', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',94,['code':("policy.txnAmtCondition.label"),'default':("Txn Amt Condition")],-1)
printHtmlPart(13)
invokeTag('field','g',97,['name':("txnAmtCondition"),'value':(fieldValue(bean: policyInstance, field: 'txnAmtCondition')),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',103,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',104,['bean':(policyInstance),'field':("txnAmtCondition")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',107,['bean':(policyInstance),'field':("txnAmtCondition")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: policyInstance, field: 'policyAction', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',114,['code':("policy.policyAction.label"),'default':("Policy Action")],-1)
printHtmlPart(3)
invokeTag('select','g',117,['id':("policyAction"),'name':("policyAction.id"),'from':(icbs.lov.PolicyAction.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(policyInstance?.policyAction?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',123,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',124,['bean':(policyInstance),'field':("policyAction")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',127,['bean':(policyInstance),'field':("policyAction")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: policyInstance, field: 'reference', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',134,['code':("policy.reference.label"),'default':("Reference")],-1)
printHtmlPart(13)
invokeTag('textField','g',137,['name':("reference"),'value':(policyInstance?.reference),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',143,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',144,['bean':(policyInstance),'field':("reference")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',147,['bean':(policyInstance),'field':("reference")],1)
printHtmlPart(17)
invokeTag('hiddenField','g',151,['name':("configItemStatus"),'value':("2")],-1)
printHtmlPart(18)
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
