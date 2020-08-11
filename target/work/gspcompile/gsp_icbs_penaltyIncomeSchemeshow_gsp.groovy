import icbs.loans.PenaltyIncomeScheme
import icbs.lov.LoanPenaltyBasis
import icbs.lov.LoanPenaltyFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_penaltyIncomeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/penaltyIncomeScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'penaltyIncomeScheme.label', default: 'PenaltyIncomeScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/penaltyIncomeScheme'))
printHtmlPart(8)
})
invokeTag('captureContent','sitemesh',17,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',40,['code':("penaltyIncomeScheme.code.label"),'default':("Code")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',41,['bean':(penaltyIncomeSchemeInstance),'field':("code")],-1)
printHtmlPart(14)
invokeTag('message','g',44,['code':("penaltyIncomeScheme.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',45,['bean':(penaltyIncomeSchemeInstance),'field':("name")],-1)
printHtmlPart(14)
invokeTag('message','g',48,['code':("penaltyIncomeScheme.basis.label"),'default':("Basis")],-1)
printHtmlPart(15)
expressionOut.print(penaltyIncomeSchemeInstance?.basis?.description)
printHtmlPart(16)
invokeTag('message','g',52,['code':("penaltyIncomeScheme.type.label"),'default':("Type")],-1)
printHtmlPart(15)
expressionOut.print(penaltyIncomeSchemeInstance?.type?.description)
printHtmlPart(17)
if(true && (penaltyIncomeSchemeInstance.type.id == 1)) {
printHtmlPart(18)
invokeTag('message','g',58,['code':("penaltyIncomeScheme.frequency.label"),'default':("Frequency")],-1)
printHtmlPart(15)
expressionOut.print(penaltyIncomeSchemeInstance?.frequency?.description)
printHtmlPart(14)
invokeTag('message','g',62,['code':("penaltyIncomeScheme.defaultPenaltyAmount.label"),'default':("Default Penalty Amount")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',63,['bean':(penaltyIncomeSchemeInstance),'field':("defaultPenaltyAmount")],-1)
printHtmlPart(14)
invokeTag('message','g',66,['code':("penaltyIncomeScheme.minPenaltyAmount.label"),'default':("Minimum Penalty Amount")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',67,['bean':(penaltyIncomeSchemeInstance),'field':("minPenaltyAmount")],-1)
printHtmlPart(16)
invokeTag('message','g',70,['code':("penaltyIncomeScheme.maxPenaltyAmount.label"),'default':("Maximum Penalty Amount")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',71,['bean':(penaltyIncomeSchemeInstance),'field':("maxPenaltyAmount")],-1)
printHtmlPart(19)
}
else if(true && (penaltyIncomeSchemeInstance.type.id == 2)) {
printHtmlPart(18)
invokeTag('message','g',76,['code':("penaltyIncomeScheme.defaultPenaltyRate.label"),'default':("Default Penalty Rate")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',77,['bean':(penaltyIncomeSchemeInstance),'field':("defaultPenaltyRate")],-1)
printHtmlPart(20)
invokeTag('message','g',80,['code':("penaltyIncomeScheme.minPenaltyRate.label"),'default':("Minimum Penalty Rate")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',81,['bean':(penaltyIncomeSchemeInstance),'field':("minPenaltyRate")],-1)
printHtmlPart(20)
invokeTag('message','g',84,['code':("penaltyIncomeScheme.maxPenaltyRate.label"),'default':("Maximum Penalty Rate")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',85,['bean':(penaltyIncomeSchemeInstance),'field':("maxPenaltyRate")],-1)
printHtmlPart(20)
invokeTag('message','g',88,['code':("penaltyIncomeScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',89,['bean':(penaltyIncomeSchemeInstance),'field':("divisor")],-1)
printHtmlPart(19)
}
printHtmlPart(18)
invokeTag('message','g',93,['code':("penaltyIncomeScheme.gracePeriod.label"),'default':("Grace Period")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',94,['bean':(penaltyIncomeSchemeInstance),'field':("gracePeriod")],-1)
printHtmlPart(21)
invokeTag('message','g',97,['code':("penaltyIncomeScheme.canChangePenaltyRate.label"),'default':("Changeable Penalty Rate")],-1)
printHtmlPart(15)
invokeTag('formatBoolean','g',98,['boolean':(penaltyIncomeSchemeInstance?.canChangePenaltyRate)],-1)
printHtmlPart(14)
invokeTag('message','g',101,['code':("penaltyIncomeScheme.hasWeekendMode.label"),'default':("Weekend Mode")],-1)
printHtmlPart(15)
invokeTag('formatBoolean','g',102,['boolean':(penaltyIncomeSchemeInstance?.hasWeekendMode)],-1)
printHtmlPart(22)
invokeTag('message','g',105,['code':("penaltyIncomeScheme.status.label"),'default':("Status")],-1)
printHtmlPart(15)
expressionOut.print(penaltyIncomeSchemeInstance?.status?.description)
printHtmlPart(23)
invokeTag('sortableColumn','g',115,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(24)
invokeTag('sortableColumn','g',116,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(25)
loop:{
int i = 0
for( product in (penaltyIncomeSchemeInstance.products) ) {
printHtmlPart(26)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',122,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(28)
expressionOut.print(product.name)
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',131,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',133,['class':("list"),'action':("index")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',134,['action':("edit"),'controller':("penaltyIncomeScheme"),'id':(penaltyIncomeSchemeInstance.id)],3)
printHtmlPart(35)
if(true && (penaltyIncomeSchemeInstance.status.id == 1)) {
printHtmlPart(36)
createClosureForHtmlPart(37, 4)
invokeTag('form','g',136,['id':("activate"),'url':([resource:penaltyIncomeSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',142,['id':("activatePenaltyIncomeScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (penaltyIncomeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(41)
createClosureForHtmlPart(42, 4)
invokeTag('form','g',145,['id':("delete"),'url':([resource:penaltyIncomeSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(42)
invokeTag('actionSubmit','g',154,['id':("deletePenaltyIncomeScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01104', 'form#delete', 'Override New Penalty Income Scheme.', null);
                                },
                                function(){
                                    return;
                                });                               
                            """)],-1)
printHtmlPart(43)
}
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',168,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',168,[:],1)
printHtmlPart(45)
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
