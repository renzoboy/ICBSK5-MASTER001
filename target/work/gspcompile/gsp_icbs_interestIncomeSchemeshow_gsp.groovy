import icbs.loans.InterestIncomeScheme
import icbs.lov.LoanInstallmentType
import icbs.lov.LoanCalculation
import icbs.lov.LoanAdvancedInterestType
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_interestIncomeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/interestIncomeScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'interestIncomeScheme.label', default: 'InterestIncomeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/interestIncomeScheme'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',19,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',42,['code':("interestIncomeScheme.code.label"),'default':("Code")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',43,['bean':(interestIncomeSchemeInstance),'field':("code")],-1)
printHtmlPart(13)
invokeTag('message','g',46,['code':("interestIncomeScheme.name.label"),'default':("Name")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',47,['bean':(interestIncomeSchemeInstance),'field':("name")],-1)
printHtmlPart(13)
invokeTag('message','g',50,['code':("interestIncomeScheme.installmentType.label"),'default':("Installment Type")],-1)
printHtmlPart(14)
expressionOut.print(interestIncomeSchemeInstance.installmentType.description)
printHtmlPart(13)
invokeTag('message','g',54,['code':("interestIncomeScheme.installmentCalcType.label"),'default':("Installment Calculation Type")],-1)
printHtmlPart(15)
expressionOut.print(interestIncomeSchemeInstance.installmentCalcType.description)
printHtmlPart(13)
invokeTag('message','g',58,['code':("interestIncomeScheme.advInterestType.label"),'default':("Advanced Interest Type")],-1)
printHtmlPart(16)
expressionOut.print(interestIncomeSchemeInstance.advInterestType.description)
printHtmlPart(13)
invokeTag('message','g',62,['code':("interestIncomeScheme.defaultInterestRate.label"),'default':("Default Interest Rate")],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',63,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.defaultInterestRate)],-1)
printHtmlPart(17)
invokeTag('message','g',66,['code':("interestIncomeScheme.pastDueInterestRate.label"),'default':("Past Due Interest Rate")],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',67,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.pastDueInterestRate)],-1)
printHtmlPart(17)
invokeTag('message','g',70,['code':("interestIncomeScheme.minInterestRate.label"),'default':("Min Interest Rate")],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',71,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.minInterestRate)],-1)
printHtmlPart(17)
invokeTag('message','g',74,['code':("interestIncomeScheme.maxInterestRate.label"),'default':("Max Interest Rate")],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',75,['format':("#,##0.00"),'number':(interestIncomeSchemeInstance?.maxInterestRate)],-1)
printHtmlPart(17)
invokeTag('message','g',78,['code':("interestIncomeScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',79,['bean':(interestIncomeSchemeInstance),'field':("divisor")],-1)
printHtmlPart(13)
invokeTag('message','g',82,['code':("interestIncomeScheme.gracePeriod.label"),'default':("Grace Period")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',83,['bean':(interestIncomeSchemeInstance),'field':("gracePeriod")],-1)
printHtmlPart(13)
invokeTag('message','g',86,['code':("interestIncomeScheme.hasBalloonMode.label"),'default':("Balloon Mode")],-1)
printHtmlPart(18)
invokeTag('formatBoolean','g',87,['boolean':(interestIncomeSchemeInstance.hasBalloonMode)],-1)
printHtmlPart(13)
invokeTag('message','g',90,['code':("interestIncomeScheme.canChangeInterestRate.label"),'default':("Changeable Interest Rate")],-1)
printHtmlPart(14)
invokeTag('formatBoolean','g',91,['boolean':(interestIncomeSchemeInstance.canChangeInterestRate)],-1)
printHtmlPart(13)
invokeTag('message','g',94,['code':("interestIncomeScheme.hasInterestAccrual.label"),'default':("Interest Accrual")],-1)
printHtmlPart(14)
invokeTag('formatBoolean','g',95,['boolean':(interestIncomeSchemeInstance.hasInterestAccrual)],-1)
printHtmlPart(13)
invokeTag('message','g',98,['code':("interestIncomeScheme.status.label"),'default':("Status")],-1)
printHtmlPart(14)
expressionOut.print(interestIncomeSchemeInstance.status.description)
printHtmlPart(19)
invokeTag('sortableColumn','g',108,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(20)
invokeTag('sortableColumn','g',109,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(21)
loop:{
int i = 0
for( product in (interestIncomeSchemeInstance.products) ) {
printHtmlPart(22)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',115,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(24)
expressionOut.print(product.name)
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',125,['class':("list"),'action':("index")],3)
printHtmlPart(29)
if(true && (interestIncomeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',126,['action':("edit"),'controller':("interestIncomeScheme"),'id':(interestIncomeSchemeInstance.id)],4)
printHtmlPart(29)
}
printHtmlPart(32)
if(true && (interestIncomeSchemeInstance.status.id == 1)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 4)
invokeTag('form','g',133,['id':("activate"),'url':([resource:interestIncomeSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(34)
invokeTag('actionSubmit','g',135,['id':("activateInterestIncomeScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (interestIncomeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('form','g',138,['id':("delete"),'url':([resource:interestIncomeSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',147,['id':("deleteInterestIncomeScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01004', 'form#delete', 'Override delete Interest Income Scheme.', null);
                                },
                                function(){
                                    return;
                                });                               
                            """)],-1)
printHtmlPart(39)
}
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',161,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',162,[:],1)
printHtmlPart(41)
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
