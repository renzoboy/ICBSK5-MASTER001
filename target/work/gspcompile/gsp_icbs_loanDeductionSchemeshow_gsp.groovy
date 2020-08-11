import icbs.loans.LoanDeductionScheme
import icbs.lov.LoanDeductionCalculationType
import icbs.lov.LoanDeductionSpecialCalculation
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanDeductionSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanDeductionScheme/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'loanDeductionScheme.label', default: 'LoanDeductionScheme'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/loanDeductionScheme'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',18,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',41,['code':("loanDeductionScheme.code.label"),'default':("Code")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',42,['bean':(loanDeductionSchemeInstance),'field':("code")],-1)
printHtmlPart(13)
invokeTag('message','g',45,['code':("loanDeductionScheme.name.label"),'default':("Name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',46,['bean':(loanDeductionSchemeInstance),'field':("name")],-1)
printHtmlPart(13)
invokeTag('message','g',49,['code':("loanDeductionScheme.description.label"),'default':("Description")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',50,['bean':(loanDeductionSchemeInstance),'field':("description")],-1)
printHtmlPart(14)
invokeTag('message','g',53,['code':("loanDeductionScheme.specialCalculation.label"),'default':("Special Calculation")],-1)
printHtmlPart(15)
expressionOut.print(loanDeductionSchemeInstance?.specialCalculation?.description)
printHtmlPart(16)
invokeTag('message','g',57,['code':("loanDeductionScheme.type.label"),'default':("Type")],-1)
printHtmlPart(15)
expressionOut.print(loanDeductionSchemeInstance?.type?.description)
printHtmlPart(17)
if(true && (loanDeductionSchemeInstance.type.id == 1)) {
printHtmlPart(18)
invokeTag('message','g',62,['code':("loanDeductionScheme.amount.label"),'default':("Amount")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',63,['bean':(loanDeductionSchemeInstance),'field':("amount")],-1)
printHtmlPart(19)
}
else if(true && (loanDeductionSchemeInstance.type.id == 2)) {
printHtmlPart(18)
invokeTag('message','g',68,['code':("loanDeductionScheme.rate.label"),'default':("Rate")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',69,['bean':(loanDeductionSchemeInstance),'field':("rate")],-1)
printHtmlPart(20)
invokeTag('message','g',72,['code':("loanDeductionScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',73,['bean':(loanDeductionSchemeInstance),'field':("divisor")],-1)
printHtmlPart(19)
}
printHtmlPart(18)
invokeTag('message','g',77,['code':("loanDeductionScheme.hasEirMode.label"),'default':("EIR Mode")],-1)
printHtmlPart(15)
invokeTag('formatBoolean','g',78,['boolean':(loanDeductionSchemeInstance?.hasEirMode)],-1)
printHtmlPart(14)
invokeTag('message','g',81,['code':("loanDeductionScheme.contraAcct.label"),'default':("GL Contra Account")],-1)
printHtmlPart(21)
expressionOut.print(loanDeductionSchemeInstance?.contraAcct?.name)
printHtmlPart(22)
invokeTag('message','g',85,['code':("loanDeductionScheme.status.label"),'default':("Status")],-1)
printHtmlPart(23)
expressionOut.print(loanDeductionSchemeInstance?.status?.description)
printHtmlPart(24)
invokeTag('sortableColumn','g',95,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',96,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(26)
loop:{
int i = 0
for( product in (loanDeductionSchemeInstance.products) ) {
printHtmlPart(27)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',102,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(29)
expressionOut.print(product.name)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',110,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',112,['class':("list"),'action':("index")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',113,['action':("edit"),'controller':("loanDeductionScheme"),'id':(loanDeductionSchemeInstance.id)],3)
printHtmlPart(36)
if(true && (loanDeductionSchemeInstance.status.id == 1)) {
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('form','g',117,['id':("activate"),'url':([resource:loanDeductionSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',121,['id':("activateLoanDeductionScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (loanDeductionSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(37)
createClosureForHtmlPart(41, 4)
invokeTag('form','g',124,['id':("delete"),'url':([resource:loanDeductionSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',133,['id':("deleteLoanDeductionScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01303', 'form#delete', 'Override new Check Deposit Clearing Type.', null);
                                },
                                function(){
                                    return;
                                });                           
                        """)],-1)
printHtmlPart(42)
}
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',147,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',148,[:],1)
printHtmlPart(44)
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
