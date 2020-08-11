import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_signatory_onetomany_signatory_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/signatory/onetomany/_signatory.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: depositInstance, field: 'signatories['+i+'].signatory', 'has-error'))
printHtmlPart(3)
if(true && (signatory?.id)) {
printHtmlPart(4)
invokeTag('hiddenField','g',10,['name':("signatories[${i}].id"),'value':(signatory?.id)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',11,['name':("signatories[${i}].new"),'value':("false")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(4)
invokeTag('hiddenField','g',14,['name':("signatories[${i}].new"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
invokeTag('hiddenField','g',16,['name':("signatories[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',17,['name':("signatories[${i}].signatory.id"),'id':("signatories[${i}].signatory"),'value':(signatory?.signatory?.id)],-1)
printHtmlPart(6)
invokeTag('field','g',19,['class':("form-control"),'name':("c_id"),'disabled value':(signatory?.signatory?.customerId)],-1)
printHtmlPart(7)
expressionOut.print(signatory?.signatory?.customerId)
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(signatory?.signatory?.customerId)
})
invokeTag('link','g',21,['controller':("customer"),'action':("customerInquiry"),'id':(signatory?.signatory?.id)],1)
printHtmlPart(9)
invokeTag('field','g',24,['class':("form-control"),'name':("c_NAME"),'disabled value':(signatory?.signatory?.displayName)],-1)
printHtmlPart(10)
expressionOut.print(signatory?.signatory?.displayName)
printHtmlPart(11)
if(true && (!displayOnly)) {
printHtmlPart(12)
invokeTag('select','g',31,['id':("signatories[${i}].type"),'name':("signatories[${i}].type.id"),'from':(icbs.lov.SignatoryType.list()),'optionKey':("id"),'optionValue':("description"),'value':(signatory?.type?.id),'class':("form-control")],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',37,['bean':(signatory),'field':("signatories[${i}].type")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',40,['bean':(signatory),'field':("signatories[${i}].type")],2)
printHtmlPart(17)
}
else {
printHtmlPart(12)
expressionOut.print(signatory?.type?.description)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (!displayOnly)) {
printHtmlPart(20)
expressionOut.print(resource(dir:'images/skin', file:'database_delete.png'))
printHtmlPart(21)
}
printHtmlPart(22)
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
