import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_form_agriRefundPool_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/form/_agriRefundPool.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(createLink(controller:'loan', action:'commodityRateAjax'))
printHtmlPart(1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'agfpCommodity', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',48,['code':("loan.agfpCommodity.label"),'default':("Commodity")],-1)
printHtmlPart(4)
invokeTag('select','g',51,['id':("agfpCommodity"),'name':("agfpCommodity"),'noSelection':(['':'Select One Commodity']),'from':(icbs.lov.Commodity.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(loanGuaranteeInstance?.agfpCommodity?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',56,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',57,['bean':(loanGuaranteeInstance),'field':("agfpCommodity")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',60,['bean':(loanGuaranteeInstance),'field':("agfpCommodity")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'agfpHectaresOrHeads', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',66,['code':("loan.agfpHectaresOrHeads.label"),'default':("Hectar Age/No. of Heads")],-1)
printHtmlPart(12)
invokeTag('field','g',70,['type':("text"),'id':("agfpHectaresOrHeads"),'name':("agfpHectaresOrHeads"),'value':(loanGuaranteeInstance?.agfpHectaresOrHeads),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',75,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',76,['bean':(loanGuaranteeInstance),'field':("agfpHectaresOrHeads")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',79,['bean':(loanGuaranteeInstance),'field':("agfpHectaresOrHeads")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'agfpGuaranteeRate', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',86,['code':("loan.agfpGuaranteeRate.label"),'default':("Guarantee Fee rate")],-1)
printHtmlPart(12)
invokeTag('field','g',89,['type':("text"),'id':("agfpGuaranteeRate"),'name':("agfpGuaranteeRate"),'value':(loanGuaranteeInstance?.agfpGuaranteeRate),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',94,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',95,['bean':(loanGuaranteeInstance),'field':("agfpGuaranteeRate")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',98,['bean':(loanGuaranteeInstance),'field':("agfpGuaranteeRate")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'agfpGuaranteeFee', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',104,['code':("loan.agfpGuaranteeFee.label"),'default':("Guarantee Fee")],-1)
printHtmlPart(12)
invokeTag('field','g',108,['id':("agfpGuaranteeFee"),'name':("agfpGuaranteeFee"),'value':(loanGuaranteeInstance?.agfpGuaranteeFee),'class':("form-control truncated")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',113,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',114,['bean':(loanGuaranteeInstance),'field':("agfpGuaranteeFee")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',116,['bean':(loanGuaranteeInstance),'field':("agfpGuaranteeFee")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'agfpReferred', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',123,['code':("loan.agfpReferred.label"),'default':("Referred")],-1)
printHtmlPart(12)
invokeTag('field','g',127,['type':("text"),'id':("agfpReferred"),'name':("agfpReferred"),'value':(loanGuaranteeInstance?.agfpReferred),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',131,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',132,['bean':(loanGuaranteeInstance),'field':("agfpReferred")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',133,['bean':(loanGuaranteeInstance),'field':("agfpReferred")],1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'agfpRemarks', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',141,['code':("loan.agfpRemarks.label"),'default':("Remarks")],-1)
printHtmlPart(12)
invokeTag('field','g',146,['type':("text"),'id':("agfpRemarks"),'name':("agfpRemarks"),'value':(loanGuaranteeInstance?.agfpRemarks),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',150,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',150,['bean':(loanGuaranteeInstance),'field':("agfpRemarks")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',151,['bean':(loanGuaranteeInstance),'field':("agfpRemarks")],1)
printHtmlPart(24)
invokeTag('hiddenField','g',155,['name':("loanGranted"),'id':("loanGranted"),'value':(loanInstance?.grantedAmount)],-1)
printHtmlPart(25)
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
