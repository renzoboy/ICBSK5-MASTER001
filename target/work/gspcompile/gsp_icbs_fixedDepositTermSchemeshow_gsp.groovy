import icbs.deposit.FixedDepositTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositTermSchemeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositTermScheme/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'fixedDepositTermScheme.label', default: 'FixedDepositTermScheme'))],-1)
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
expressionOut.print(createLink(uri: '/fixedDepositTermScheme'))
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
if(true && (fixedDepositTermSchemeInstance?.code)) {
printHtmlPart(12)
invokeTag('message','g',30,['code':("fixedDepositTermScheme.code.label"),'default':("Code")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',31,['bean':(fixedDepositTermSchemeInstance),'field':("code")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositTermSchemeInstance?.description)) {
printHtmlPart(12)
invokeTag('message','g',36,['code':("fixedDepositTermScheme.description.label"),'default':("Description")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',37,['bean':(fixedDepositTermSchemeInstance),'field':("description")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositTermSchemeInstance?.value)) {
printHtmlPart(12)
invokeTag('message','g',42,['code':("fixedDepositTermScheme.value.label"),'default':("Value")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',43,['bean':(fixedDepositTermSchemeInstance),'field':("value")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositTermSchemeInstance?.termMin)) {
printHtmlPart(12)
invokeTag('message','g',48,['code':("fixedDepositTermScheme.termMin.label"),'default':("Term Min")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',49,['bean':(fixedDepositTermSchemeInstance),'field':("termMin")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositTermSchemeInstance?.termMax)) {
printHtmlPart(12)
invokeTag('message','g',54,['code':("fixedDepositTermScheme.termMax.label"),'default':("Term Max")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',55,['bean':(fixedDepositTermSchemeInstance),'field':("termMax")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (fixedDepositTermSchemeInstance?.status)) {
printHtmlPart(12)
invokeTag('message','g',60,['code':("fixedDepositTermScheme.status.label"),'default':("Status")],-1)
printHtmlPart(20)
expressionOut.print(fixedDepositTermSchemeInstance?.status?.encodeAsHTML())
printHtmlPart(14)
}
printHtmlPart(21)
invokeTag('sortableColumn','g',70,['property':("code"),'title':(message(code: 'product.code.label', default: 'Code'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',71,['property':("name"),'title':(message(code: 'product.description.label', default: 'Product Name'))],-1)
printHtmlPart(23)
loop:{
int i = 0
for( product in (fixedDepositTermSchemeInstance.products) ) {
printHtmlPart(24)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(25)
createTagBody(4, {->
expressionOut.print(product.code)
})
invokeTag('link','g',77,['controller':("Product"),'action':("show"),'id':(product.id)],4)
printHtmlPart(26)
expressionOut.print(product.name)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',87,['class':("list"),'action':("index")],3)
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',88,['class':("create"),'action':("create")],3)
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',90,['action':("edit"),'controller':("FixedDepositTermScheme"),'id':(fixedDepositTermSchemeInstance.id)],3)
printHtmlPart(36)
if(true && (fixedDepositTermSchemeInstance.status.id == 1)) {
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('form','g',94,['id':("activatefixedDepositTermSchemeForm"),'url':([id:fixedDepositTermSchemeInstance.id, action:'activate']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',95,['id':("activatefixedDepositTermScheme"),'action':("activate"),'value':("Activate"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (fixedDepositTermSchemeInstance.status.id.toInteger() in [1, 2])) {
printHtmlPart(37)
createClosureForHtmlPart(38, 4)
invokeTag('form','g',101,['id':("deletefixedDepositTermSchemeForm"),'url':([id:fixedDepositTermSchemeInstance.id, action:'delete']),'method':("POST")],4)
printHtmlPart(38)
invokeTag('actionSubmit','g',110,['id':("deletefixedDepositTermScheme"),'action':("delete"),'value':("Delete"),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG01504', 'form#deletefixedDepositTermSchemeForm', 'Override new fixed deposit term scheme form.', null); 
                                },
                                function(){
                                    return;
                                });                               
                            """)],-1)
printHtmlPart(41)
}
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',124,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',125,[:],1)
printHtmlPart(43)
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