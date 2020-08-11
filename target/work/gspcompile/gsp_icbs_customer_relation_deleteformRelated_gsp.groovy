import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_relation_deleteformRelated_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/relation/_deleteformRelated.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['name':("id"),'id':("id"),'value':(relationInstance?.id)],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',10,['id':("customer"),'name':("customer.id"),'value':(relationInstance?.customer?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: relationInstance, field: 'customer2', 'has-error'))
printHtmlPart(4)
if(true && (!saved)) {
printHtmlPart(5)
invokeTag('message','g',14,['code':("relation.customer2.label"),'default':("Related Customer ID")],-1)
printHtmlPart(6)
if(true && (!disabled)) {
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('hiddenField','g',21,['id':("customer2"),'name':("customer2.id"),'value':(relationInstance?.customer2?.id)],-1)
printHtmlPart(8)
invokeTag('textField','g',22,['id':("customer2"),'name':("customer2.id"),'disabled':("disabled"),'value':(relationInstance?.customer2?.id)],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',28,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',29,['bean':(relationInstance),'field':("customer2")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',32,['bean':(relationInstance),'field':("customer2")],2)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',37,['code':("relation.type.label"),'default':("Relation Status ")],-1)
printHtmlPart(16)
if(true && (customerRelationshipType==1)) {
printHtmlPart(17)
invokeTag('select','g',42,['id':("type"),'name':("type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")),'optionKey':("id"),'optionValue':("itemValue"),'value':(relationInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(8)
}
printHtmlPart(8)
if(true && (customerRelationshipType!=1)) {
printHtmlPart(17)
invokeTag('select','g',45,['id':("type"),'name':("type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"2%")),'optionKey':("id"),'optionValue':("itemValue"),'value':(relationInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(8)
}
printHtmlPart(18)
invokeTag('select','g',48,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.findAllByCode('990')),'optionKey':("id"),'optionValue':("description"),'value':(relationInstance?.status?.id),'class':("form-control")],-1)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',55,['bean':(relationInstance),'field':("type")],3)
printHtmlPart(23)
})
invokeTag('hasErrors','g',58,['bean':(relationInstance),'field':("type")],2)
printHtmlPart(24)
}
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
