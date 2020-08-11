import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_deposit_typeAndProduct_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/deposit/_typeAndProduct.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: depositInstance, field: 'type', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',11,['code':("deposit.type.label"),'default':("Deposit Type")],-1)
printHtmlPart(3)
invokeTag('select','g',14,['id':("type"),'name':("type.id"),'onchange':("changeTypeProductSchemeForm('type')"),'from':(icbs.lov.DepositType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(depositInstance?.type?.id),'noSelection':(['':'']),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',19,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',20,['bean':(depositInstance),'field':("v")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',23,['bean':(depositInstance),'field':("type")],1)
printHtmlPart(9)
if(true && (depositInstance?.type?.id)) {
printHtmlPart(10)
expressionOut.print(hasErrors(bean: depositInstance, field: 'product', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',29,['code':("deposit.product.label"),'default':("Deposit Product")],-1)
printHtmlPart(12)
if(true && (depositInstance?.type?.id==1)) {
printHtmlPart(13)
invokeTag('select','g',34,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAll{ productType.id == 1&& configItemStatus.id==2}),'onchange':("changeTypeProductSchemeForm('product')"),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.product?.id),'noSelection':(['':'']),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositInstance?.type?.id==2)) {
printHtmlPart(13)
invokeTag('select','g',37,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAll{ productType.id == 2 && configItemStatus.id==2}),'onchange':("changeTypeProductSchemeForm('product')"),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.product?.id),'noSelection':(['':'']),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(13)
invokeTag('select','g',40,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAll{ productType.id == 3 && configItemStatus.id==2}),'onchange':("changeTypeProductSchemeForm('product')"),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.product?.id),'noSelection':(['':'']),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositInstance?.type?.id==4)) {
printHtmlPart(13)
invokeTag('select','g',43,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAll{ productType.id == 4 && configItemStatus.id==2 }),'onchange':("changeTypeProductSchemeForm('product')"),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.product?.id),'noSelection':(['':'']),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (depositInstance?.type?.id==5)) {
printHtmlPart(13)
invokeTag('select','g',46,['id':("product"),'name':("product.id"),'from':(icbs.admin.Product.findAll{ productType.id == 5 && configItemStatus.id==2}),'onchange':("changeTypeProductSchemeForm('product')"),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.product?.id),'noSelection':(['':'']),'class':("many-to-one form-control")],-1)
printHtmlPart(14)
}
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('message','g',53,['error':(it)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',54,['bean':(depositInstance),'field':("product")],3)
printHtmlPart(20)
})
invokeTag('hasErrors','g',57,['bean':(depositInstance),'field':("product")],2)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (depositInstance?.product?.id && depositInstance?.type?.id)) {
printHtmlPart(23)
expressionOut.print(hasErrors(bean: depositInstance, field: 'depositInterestScheme', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',64,['code':("deposit.depositInterestScheme.label"),'default':("Deposit Interest Scheme")],-1)
printHtmlPart(25)
invokeTag('select','g',68,['id':("depositInterestScheme"),'name':("depositInterestScheme.id"),'from':(icbs.deposit.DepositInterestSchemeProduct.findAll{product.id==depositInstance.product.id}),'optionKey':("depositInterestSchemeId"),'optionValue':("depositInterestScheme"),'value':(depositInstance?.depositInterestScheme?.id),'class':("many-to-one form-control"),'noSelection':(['': ''])],-1)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',73,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',74,['bean':(depositInstance),'field':("depositInterestScheme")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',77,['bean':(depositInstance),'field':("depositInterestScheme")],2)
printHtmlPart(30)
}
printHtmlPart(22)
if(true && (depositInstance?.type?.id==3&& depositInstance?.product?.id)) {
printHtmlPart(23)
expressionOut.print(hasErrors(bean: depositInstance, field: 'fixedDepositPreTermScheme', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',84,['code':("deposit.fixedDepositPreTermScheme.label"),'default':("Fixed Deposit PreTerm Scheme")],-1)
printHtmlPart(25)
invokeTag('select','g',88,['id':("fixedDepositPreTermScheme"),'name':("fixedDepositPreTermScheme.id"),'from':(icbs.deposit.FixedDepositPreTermSchemeProduct.findAll{product.id==depositInstance.product.id}),'optionKey':("fixedDepositPreTermSchemeId"),'optionValue':("fixedDepositPreTermScheme"),'value':(depositInstance?.fixedDepositPreTermScheme?.id),'class':("many-to-one form-control"),'noSelection':(['': ''])],-1)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',93,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',94,['bean':(depositInstance),'field':("fixedDepositPreTermScheme")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',97,['bean':(depositInstance),'field':("fixedDepositPreTermScheme")],2)
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (depositInstance?.type?.id==3&& depositInstance?.product?.id)) {
printHtmlPart(23)
expressionOut.print(hasErrors(bean: depositInstance, field: 'fixedDepositTermScheme', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',104,['code':("deposit.fixedDepositTermScheme.label"),'default':("Fixed Deposit Term Scheme")],-1)
printHtmlPart(25)
invokeTag('select','g',108,['id':("fixedDepositermScheme"),'name':("fixedDepositTermScheme.id"),'from':(icbs.deposit.FixedDepositTermSchemeProduct.findAll{product.id==depositInstance.product.id}),'optionKey':("fixedDepositTermSchemeId"),'optionValue':("fixedDepositTermScheme"),'value':(depositInstance?.fixedDepositTermScheme?.id),'class':("many-to-one form-control"),'noSelection':(['': ''])],-1)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('message','g',113,['error':(it)],-1)
printHtmlPart(28)
})
invokeTag('eachError','g',114,['bean':(depositInstance),'field':("fixedDepositTermScheme")],3)
printHtmlPart(29)
})
invokeTag('hasErrors','g',117,['bean':(depositInstance),'field':("fixedDepositTermScheme")],2)
printHtmlPart(30)
}
printHtmlPart(32)
if(true && (firstCreate==true&&!depositInstance?.customer)) {
printHtmlPart(33)
}
printHtmlPart(34)
invokeTag('render','g',128,['template':("/customer/details/customerDetails"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(35)
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
