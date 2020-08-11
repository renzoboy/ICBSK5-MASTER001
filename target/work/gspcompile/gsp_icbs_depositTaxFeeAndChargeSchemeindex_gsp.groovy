import icbs.deposit.DepositTaxFeeAndChargeScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositTaxFeeAndChargeSchemeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositTaxFeeAndChargeScheme/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'depositTaxFeeAndChargeScheme.label', default: 'DepositTaxFeeAndChargeScheme'))],-1)
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
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',23,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
})
invokeTag('form','g',33,[:],3)
printHtmlPart(13)
invokeTag('sortableColumn','g',39,['property':("code"),'title':(message(code: 'depositTaxFeeAndChargeScheme.code.label', default: 'Code'))],-1)
printHtmlPart(14)
invokeTag('message','g',41,['code':("depositTaxFeeAndChargeScheme.type.label"),'default':("Type")],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',43,['property':("taxRate"),'title':(message(code: 'depositTaxFeeAndChargeScheme.taxRate.label', default: 'Tax Rate'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',45,['property':("feeRate"),'title':(message(code: 'depositTaxFeeAndChargeScheme.feeRate.label', default: 'Fee Rate'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',47,['property':("feeAmt"),'title':(message(code: 'depositTaxFeeAndChargeScheme.feeAmt.label', default: 'Fee Amt'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',49,['property':("chargeRate"),'title':(message(code: 'depositTaxFeeAndChargeScheme.chargeRate.label', default: 'Charge Rate'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( depositTaxFeeAndChargeSchemeInstance in (depositTaxFeeAndChargeSchemeInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: depositTaxFeeAndChargeSchemeInstance, field: "code"))
})
invokeTag('link','g',57,['action':("show"),'id':(depositTaxFeeAndChargeSchemeInstance.id)],4)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: depositTaxFeeAndChargeSchemeInstance, field: "type"))
printHtmlPart(20)
invokeTag('formatNumber','g',61,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.taxRate)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',63,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.feeRate)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',65,['format':("###,###,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.feeAmt)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',67,['format':("#,##0.00"),'number':(depositTaxFeeAndChargeSchemeInstance?.chargeRate)],-1)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',75,['total':(DepositTaxFeeAndChargeSchemeInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',78,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',81,['class':("create"),'action':("create")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',84,[:],1)
printHtmlPart(28)
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
