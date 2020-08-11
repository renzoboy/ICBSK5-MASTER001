import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_update_customerEditMembership_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/update/_customerEditMembership.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(2)
expressionOut.print(message)
printHtmlPart(3)
expressionOut.print(params.id)
printHtmlPart(4)
}
printHtmlPart(5)
createClosureForHtmlPart(6, 1)
invokeTag('hasErrors','g',39,['bean':(customerInstance)],1)
printHtmlPart(5)
if(true && (!saved)) {
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',42,['name':("id"),'id':("id"),'value':(customerInstance?.id)],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: customerInstance, field: 'membershipType', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',45,['code':("membership.membershipType.label"),'default':("Customer Membership")],-1)
printHtmlPart(11)
invokeTag('select','g',48,['id':("membershipType"),'name':("membershipType"),'from':(icbs.lov.MembershipType.findAllByStatus('TRUE')),'optionKey':("id"),'optionValue':("description"),'value':(membership?.membershipType?.id),'noSelection':(['null': '']),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
invokeTag('message','g',53,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',54,['bean':(customerInstance),'field':("membershipType")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',57,['bean':(customerInstance),'field':("membershipType")],3)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'membershipDate', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',62,['code':("membership.membershipDate.label"),'default':("Date of Membership ")],-1)
printHtmlPart(11)
invokeTag('customDatePicker','g',65,['id':("membershipDate"),'name':("membershipDate"),'precision':("day"),'class':("form-control"),'value':(membership?.membershipDate)],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
invokeTag('message','g',70,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',71,['bean':(customerInstance),'field':("membershipDate")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',74,['bean':(customerInstance),'field':("membershipDate")],3)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: customerInstance, field: 'refferedBy', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',80,['code':("membership.refferedBy.label"),'default':("Reffered By")],-1)
printHtmlPart(11)
invokeTag('field','g',83,['name':("refferedBy"),'id':("refferedBy"),'value':(membership ?. refferedBy),'required':(""),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
invokeTag('message','g',88,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',89,['bean':(customerInstance),'field':("refferedBy")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',92,['bean':(customerInstance),'field':("refferedBy")],3)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: customerInstance, field: 'relationship', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',98,['code':("membership.relationship.label"),'default':("Relationship")],-1)
printHtmlPart(21)
invokeTag('select','g',101,['id':("relationship"),'name':("relationship"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus('CRT','TRUE')),'optionKey':("id"),'optionValue':("itemValue"),'value':(membership?.relationship?.id),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
invokeTag('message','g',106,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',107,['bean':(customerInstance),'field':("relationship")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',110,['bean':(customerInstance),'field':("relationship")],3)
printHtmlPart(22)
})
invokeTag('form','g',113,['name':("customerUpdateMembershipForm"),'id':("customerUpdateMembershipForm")],2)
printHtmlPart(5)
}
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1597125835193L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
