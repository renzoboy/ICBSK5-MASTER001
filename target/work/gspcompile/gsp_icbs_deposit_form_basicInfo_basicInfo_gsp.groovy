import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_basicInfo_basicInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/basicInfo/_basicInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: depositInstance, field: 'type', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',12,['code':("deposit.type.label"),'default':(" Deposit Type")],-1)
printHtmlPart(3)
if(true && (!depositInstance?.type?.id)) {
printHtmlPart(4)
invokeTag('select','g',18,['id':("type"),'onchange':("changeAcctInformationForm()"),'name':("type.id"),'from':(icbs.lov.DepositType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(depositInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(4)
invokeTag('hiddenField','g',21,['id':("type"),'name':("type.id"),'value':(depositInstance?.type?.id)],-1)
printHtmlPart(4)
invokeTag('textField','g',22,['name':("type"),'disabled':("disabled"),'value':(depositInstance?.type?.description),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',28,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',29,['bean':(depositInstance),'field':("type")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',32,['bean':(depositInstance),'field':("type")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'product', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',37,['code':("deposit.product.label"),'default':("Deposit Product")],-1)
printHtmlPart(12)
if(true && (!depositInstance?.product?.id)) {
printHtmlPart(13)
invokeTag('select','g',42,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.list()),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.product?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(4)
invokeTag('hiddenField','g',45,['id':("product"),'name':("product.id"),'value':(depositInstance?.product?.id)],-1)
printHtmlPart(4)
invokeTag('textField','g',46,['name':("product"),'disabled':("disabled"),'value':(depositInstance?.product?.name),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',53,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',54,['bean':(depositInstance),'field':("product")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',57,['bean':(depositInstance),'field':("product")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: depositInstance, field: 'glLink', 'has-error'))
printHtmlPart(20)
if(true && (depositInstance?.typeId == 1)) {
printHtmlPart(4)
invokeTag('select','g',66,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.findAllByType("1")),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(14)
if(true && (depositInstance?.typeId == 2)) {
printHtmlPart(4)
invokeTag('select','g',70,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.findAllByType("2")),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(14)
if(true && (depositInstance?.typeId == 3)) {
printHtmlPart(4)
invokeTag('select','g',74,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.findAllByType("3")),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(14)
if(true && (depositInstance?.typeId == 4)) {
printHtmlPart(4)
invokeTag('select','g',78,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.findAllByType("4")),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(14)
if(true && (depositInstance?.typeId == 5)) {
printHtmlPart(4)
invokeTag('select','g',82,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.findAllByType("5")),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.glLink?.id),'class':("form-control")],-1)
printHtmlPart(5)
}
printHtmlPart(21)
invokeTag('hiddenField','g',85,['name':("oldGlinkId"),'id':("oldGlinkId"),'value':(depositInstance?.glLink?.id)],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',90,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',91,['bean':(depositInstance),'field':("glLink")],2)
printHtmlPart(22)
})
invokeTag('hasErrors','g',94,['bean':(depositInstance),'field':("glLink")],1)
printHtmlPart(23)
invokeTag('render','g',103,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(24)
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
