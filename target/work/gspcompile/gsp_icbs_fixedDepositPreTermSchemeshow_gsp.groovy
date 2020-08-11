import icbs.deposit.FixedDepositPreTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositPreTermSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositPreTermScheme/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'fixedDepositPreTermScheme.label', default: 'FixedDepositPreTermScheme'))],-1)
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
expressionOut.print(createLink(uri: '/fixedDepositPreTermScheme'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (fixedDepositPreTermSchemeInstance?.code)) {
printHtmlPart(12)
invokeTag('message','g',30,['code':("fixedDepositPreTermScheme.code.label"),'default':("Code")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',31,['bean':(fixedDepositPreTermSchemeInstance),'field':("code")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.description)) {
printHtmlPart(12)
invokeTag('message','g',37,['code':("fixedDepositPreTermScheme.description.label"),'default':("Description")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',38,['bean':(fixedDepositPreTermSchemeInstance),'field':("description")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.type)) {
printHtmlPart(12)
invokeTag('message','g',44,['code':("fixedDepositPreTermScheme.type.label"),'default':("Type")],-1)
printHtmlPart(17)
expressionOut.print(fixedDepositPreTermSchemeInstance?.type?.encodeAsHTML())
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.rate)) {
printHtmlPart(12)
invokeTag('message','g',51,['code':("fixedDepositPreTermScheme.rate.label"),'default':("Rate")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',52,['bean':(fixedDepositPreTermSchemeInstance),'field':("rate")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.term1stHalf)) {
printHtmlPart(12)
invokeTag('message','g',58,['code':("fixedDepositPreTermScheme.term1stHalf.label"),'default':("Term1st Half")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',59,['bean':(fixedDepositPreTermSchemeInstance),'field':("term1stHalf")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.term2ndHalf)) {
printHtmlPart(12)
invokeTag('message','g',65,['code':("fixedDepositPreTermScheme.term2ndHalf.label"),'default':("Term2nd Half")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',66,['bean':(fixedDepositPreTermSchemeInstance),'field':("term2ndHalf")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.divisor)) {
printHtmlPart(12)
invokeTag('message','g',72,['code':("fixedDepositPreTermScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',73,['bean':(fixedDepositPreTermSchemeInstance),'field':("divisor")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.status)) {
printHtmlPart(12)
invokeTag('message','g',79,['code':("fixedDepositPreTermScheme.status.label"),'default':("Status")],-1)
printHtmlPart(22)
expressionOut.print(fixedDepositPreTermSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositPreTermSchemeInstance?.isGradeRate)) {
printHtmlPart(12)
invokeTag('message','g',86,['code':("fixedDepositPreTermScheme.isGradeRate.label"),'default':("Is Grade Rate")],-1)
printHtmlPart(23)
invokeTag('formatBoolean','g',87,['boolean':(fixedDepositPreTermSchemeInstance?.isGradeRate)],-1)
printHtmlPart(14)
}
printHtmlPart(24)
invokeTag('sortableColumn','g',96,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(25)
invokeTag('sortableColumn','g',97,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(26)
loop:{
int i = 0
for( product in (fixedDepositPreTermSchemeInstance.products) ) {
printHtmlPart(27)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',103,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(29)
expressionOut.print(product.name)
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',111,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',114,['class':("list"),'action':("index")],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',115,['class':("create"),'action':("create")],3)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',117,['action':("edit"),'controller':("FixedDepositPreTermScheme"),'id':(fixedDepositPreTermSchemeInstance.id)],3)
printHtmlPart(39)
if(true && (fixedDepositPreTermSchemeInstance.status.id == 1)) {
printHtmlPart(40)
createTagBody(4, {->
printHtmlPart(41)
invokeTag('actionSubmit','g',121,['action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',122,['url':([id:fixedDepositPreTermSchemeInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (fixedDepositPreTermSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(45)
createClosureForHtmlPart(46, 4)
invokeTag('form','g',127,['id':("deleteFixedDepositPreTermSchemeForm"),'url':([id:fixedDepositPreTermSchemeInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(47)
invokeTag('actionSubmit','g',136,['id':("deleteFixedDepositPreTermScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00903', 'form#deleteFixedDepositPreTermSchemeForm', 'Override delete Fixed Deposit PreTerm Scheme.', null); 
                                },
                                function(){
                                    return;
                                });                             
                            """)],-1)
printHtmlPart(48)
}
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',150,[:],1)
printHtmlPart(50)
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
