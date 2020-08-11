import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_relation_formRelated_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/relation/_formRelated.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['name':("id"),'id':("id"),'value':(relationInstance?.id)],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',10,['id':("customer"),'name':("customer.id"),'value':(relationInstance?.customer?.id)],-1)
printHtmlPart(2)
if(true && (!saved)) {
printHtmlPart(3)
expressionOut.print(hasErrors(bean: relationInstance, field: 'customer2', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("relation.customer2.label"),'default':("Related Customer")],-1)
printHtmlPart(5)
if(true && (!disabled)) {
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('hiddenField','g',21,['id':("customer2"),'name':("customer2.id"),'value':(relationInstance?.customer2?.id)],-1)
printHtmlPart(8)
invokeTag('textField','g',23,['id':("displayName2"),'width':("150"),'name':("customer2.displayName"),'disabled':(disabled),'value':(relationInstance?.customer2?.displayName)],-1)
printHtmlPart(9)
invokeTag('message','g',25,['code':("relation.customer2.label"),'default':(relationInstance?.customer2?.displayName)],-1)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',30,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',31,['bean':(relationInstance),'field':("customer2")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',34,['bean':(relationInstance),'field':("customer2")],2)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: relationInstance, field: 'status', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',39,['code':("relation.status"),'default':("Status")],-1)
printHtmlPart(16)
invokeTag('select','g',44,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")),'optionKey':("id"),'optionValue':("description"),'value':(relationInstance?.status?.id),'class':("form-control")],-1)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('message','g',50,['error':(it)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',51,['bean':(relationInstance),'field':("status")],3)
printHtmlPart(21)
})
invokeTag('hasErrors','g',54,['bean':(relationInstance),'field':("status")],2)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: relationInstance, field: 'type', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',59,['code':("relation.type.label"),'default':("Relation Type ")],-1)
printHtmlPart(24)
if(true && (customerRelationshipType==1)) {
printHtmlPart(25)
invokeTag('select','g',64,['id':("type"),'name':("type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")),'optionKey':("id"),'optionValue':("itemValue"),'value':(relationInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(26)
}
printHtmlPart(26)
if(true && (customerRelationshipType!=1)) {
printHtmlPart(25)
invokeTag('select','g',67,['id':("type"),'name':("type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"2%")),'optionKey':("id"),'optionValue':("itemValue"),'value':(relationInstance?.type?.id),'class':("form-control")],-1)
printHtmlPart(26)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',73,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',74,['bean':(relationInstance),'field':("type")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',77,['bean':(relationInstance),'field':("type")],2)
printHtmlPart(27)
}
printHtmlPart(2)
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
