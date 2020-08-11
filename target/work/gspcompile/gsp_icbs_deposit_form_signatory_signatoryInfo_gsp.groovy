import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_signatory_signatoryInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/signatory/_signatoryInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: depositInstance, field: 'ownershipType', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',12,['code':("deposit.ownershipType.label"),'default':("Ownership Type")],-1)
printHtmlPart(3)
invokeTag('select','g',15,['id':("ownershipType"),'onchange':("showSignatories(this)"),'name':("ownershipType.id"),'from':(icbs.lov.OwnershipType.list()),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.ownershipType?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',21,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',22,['bean':(depositInstance),'field':("ownershipType")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',25,['bean':(depositInstance),'field':("ownershipType")],1)
printHtmlPart(9)
invokeTag('render','g',28,['template':("form/signatory/signatoryGrid")],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'sigRules', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',31,['code':("deposit.sigRules.label"),'default':("Sig Rules")],-1)
printHtmlPart(3)
invokeTag('textField','g',34,['name':("sigRules"),'maxlength':("50"),'value':(depositInstance?.sigRules),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',40,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',41,['bean':(depositInstance),'field':("sigRules")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',44,['bean':(depositInstance),'field':("sigRules")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: depositInstance, field: 'sigRemarks', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',49,['code':("deposit.sigRemarks.label"),'default':("Sig Remarks")],-1)
printHtmlPart(3)
invokeTag('textField','g',52,['name':("sigRemarks"),'maxlength':("50"),'value':(depositInstance?.sigRemarks),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',58,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',59,['bean':(depositInstance),'field':("sigRemarks")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',62,['bean':(depositInstance),'field':("sigRemarks")],1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
expressionOut.print(depositInstance?.signatories?.size())
printHtmlPart(17)
})
invokeTag('javascript','g',1,[:],1)
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
