import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_details_signatoryInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/details/_signatoryInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (signatory?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',11,['name':("signatories[${i}].id"),'value':(signatory?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',12,['name':("signatories[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',15,['name':("signatories[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',17,['name':("signatories[${i}].deleted"),'value':("false")],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',18,['name':("signatories[${i}].signatory.id"),'id':("signatories[${i}].signatory"),'value':(signatory?.signatory?.id)],-1)
printHtmlPart(5)
expressionOut.print(signatory?.signatory?.id)
printHtmlPart(6)
expressionOut.print(signatory?.signatory?.displayName)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: signatory, field: 'type', 'has-error'))
printHtmlPart(8)
if(true && (!displayOnly)) {
printHtmlPart(9)
invokeTag('select','g',29,['id':("signatories[${i}].type"),'name':("signatories[${i}].type.id"),'from':(icbs.lov.SignatoryType.list()),'optionKey':("id"),'optionValue':("description"),'value':(signatory?.type?.id),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',34,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',35,['bean':(signatory),'field':("signatories[${i}].type")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',38,['bean':(signatory),'field':("signatories[${i}].type")],2)
printHtmlPart(14)
}
else {
printHtmlPart(9)
expressionOut.print(signatory?.type?.description)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && ((signatory?.signatory?.attachments?.find{it.isPrimarySig==true})?.id)) {
printHtmlPart(17)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (signatory?.signatory?.attachments?.find{it.isPrimarySig==true})?.id ))
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
