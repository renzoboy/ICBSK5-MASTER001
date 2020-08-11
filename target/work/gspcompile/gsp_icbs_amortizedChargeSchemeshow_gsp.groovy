import icbs.loans.AmortizedChargeScheme
import icbs.lov.LoanServiceChargeType
import icbs.lov.LoanServiceChargeBasis
import icbs.lov.LoanInstallmentFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_amortizedChargeSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/amortizedChargeScheme/show.gsp" }
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
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'amortizedChargeScheme.label', default: 'AmortizedChargeScheme'))],-1)
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
expressionOut.print(createLink(uri: '/amortizedChargeScheme'))
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
invokeTag('message','g',46,['code':("amortizedChargeScheme.code.label"),'default':("Code")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',49,['bean':(amortizedChargeSchemeInstance),'field':("code")],-1)
printHtmlPart(13)
invokeTag('message','g',54,['code':("amortizedChargeScheme.name.label"),'default':("Name")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',57,['bean':(amortizedChargeSchemeInstance),'field':("name")],-1)
printHtmlPart(15)
invokeTag('message','g',62,['code':("amortizedChargeScheme.basis.label"),'default':("Basis")],-1)
printHtmlPart(16)
expressionOut.print(amortizedChargeSchemeInstance?.basis?.description)
printHtmlPart(17)
invokeTag('message','g',70,['code':("amortizedChargeScheme.type.label"),'default':("Service Charge Type")],-1)
printHtmlPart(18)
expressionOut.print(amortizedChargeSchemeInstance?.type?.description)
printHtmlPart(19)
if(true && (amortizedChargeSchemeInstance.type.id == 1)) {
printHtmlPart(20)
invokeTag('message','g',79,['code':("amortizedChargeScheme.amount.label"),'default':("Service Charge Amount")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',82,['bean':(amortizedChargeSchemeInstance),'field':("amount")],-1)
printHtmlPart(22)
}
else if(true && (amortizedChargeSchemeInstance.type.id == 2)) {
printHtmlPart(23)
invokeTag('message','g',89,['code':("amortizedChargeScheme.rate.label"),'default':("Service Charge Rate")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',92,['bean':(amortizedChargeSchemeInstance),'field':("rate")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('message','g',98,['code':("amortizedChargeScheme.hasEirMode.label"),'default':("EIR Mode")],-1)
printHtmlPart(26)
invokeTag('formatBoolean','g',101,['boolean':(amortizedChargeSchemeInstance?.hasEirMode)],-1)
printHtmlPart(27)
invokeTag('message','g',106,['code':("amortizedChargeScheme.status.label"),'default':("Status")],-1)
printHtmlPart(28)
expressionOut.print(amortizedChargeSchemeInstance?.status?.description)
printHtmlPart(29)
for( product in (amortizedChargeSchemeInstance?.products) ) {
printHtmlPart(30)
expressionOut.print(product?.name)
printHtmlPart(31)
}
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',135,['class':("list"),'action':("index")],3)
printHtmlPart(35)
if(true && (amortizedChargeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(36)
createClosureForHtmlPart(37, 4)
invokeTag('link','g',141,['action':("edit"),'controller':("amortizedChargeScheme"),'id':(amortizedChargeSchemeInstance.id)],4)
printHtmlPart(35)
}
printHtmlPart(38)
if(true && (amortizedChargeSchemeInstance.status.id == 1)) {
printHtmlPart(39)
createClosureForHtmlPart(40, 4)
invokeTag('form','g',142,['id':("activate"),'url':([resource:amortizedChargeSchemeInstance, action:'activate']),'method':("POST")],4)
printHtmlPart(40)
invokeTag('actionSubmit','g',151,['id':("activateAmortChargeScheme"),'action':("activate"),'value':("Activate"),'onclick':(""" alertify.confirm(AppTitle,'Are you sure you want to Activate this??',
                                function(){
                                     checkIfAllowed('CFG01203', 'form#activate', 'Override new Check Deposit Clearing Type.', null);
                                },
                                function(){
                                    return;
                                });                        
                        """)],-1)
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (amortizedChargeSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(39)
createClosureForHtmlPart(43, 4)
invokeTag('form','g',156,['id':("delete"),'url':([resource:amortizedChargeSchemeInstance, action:'delete']),'method':("POST")],4)
printHtmlPart(44)
invokeTag('actionSubmit','g',164,['id':("deleteAmortChargeScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01204', 'form#delete', 'Override new Check Deposit Clearing Type.', null);
                                },
                                function(){
                                    return;
                                });                        
                        """)],-1)
printHtmlPart(41)
}
printHtmlPart(45)
})
invokeTag('captureContent','sitemesh',177,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',178,[:],1)
printHtmlPart(46)
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
