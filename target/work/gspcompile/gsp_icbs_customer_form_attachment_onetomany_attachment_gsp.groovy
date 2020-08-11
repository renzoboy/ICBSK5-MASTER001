import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_attachment_onetomany_attachment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/attachment/onetomany/_attachment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (attachment?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',12,['name':("attachments[${i}].id"),'value':(attachment?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',13,['name':("attachments[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',16,['name':("attachments[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('hiddenField','g',19,['name':("attachments[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
if(true && (attachment?.fileName!=null)) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: attachmentInstance, field: 'attachments['+i+'].fileName', 'has-error'))
printHtmlPart(7)
invokeTag('message','g',24,['code':("attachment.fileName.label"),'default':("File Name")],-1)
printHtmlPart(8)
if(true && (attachment?.id!=null)) {
printHtmlPart(9)
invokeTag('field','g',30,['disabled':("true"),'id':("attachments[${i}].fileName"),'name':("attachments[${i}].fileName"),'value':(attachment?.fileName),'class':("form-control")],-1)
printHtmlPart(10)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: attachment?.id))
printHtmlPart(11)
expressionOut.print(createLink(controller:'Attachment', action:'download', id: attachment?.id))
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',49,['bean':(customerInstance),'field':("attachments[${i}].fileName")],3)
printHtmlPart(17)
})
invokeTag('hasErrors','g',52,['bean':(customerInstance),'field':("attachments[${i}].fileName")],2)
printHtmlPart(18)
}
printHtmlPart(4)
if(true && (!type)) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: attachmentInstance, field: 'attachments['+i+'].type', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',60,['code':("attachment.type.label"),'default':("Attachment Type")],-1)
printHtmlPart(20)
invokeTag('select','g',64,['id':("attachments[${i}].type"),'name':("attachments[${i}].type.id"),'from':(icbs.lov.AttachmentType.findAllByCodeInList(['030','040','050'])),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(attachment?.type?.id),'class':("form-control")],-1)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',70,['bean':(customerInstance),'field':("attachments[${i}].type")],3)
printHtmlPart(25)
})
invokeTag('hasErrors','g',73,['bean':(customerInstance),'field':("attachments[${i}].type")],2)
printHtmlPart(26)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',78,['id':("attachments[${i}].type"),'name':("attachments[${i}].type.id"),'value':(type)],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (isPrimaryPhoto)) {
printHtmlPart(3)
invokeTag('hiddenField','g',81,['id':("attachments[${i}].isPrimaryPhoto"),'name':("attachments[${i}].isPrimaryPhoto"),'value':(isPrimaryPhoto)],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (isPrimarySig)) {
printHtmlPart(3)
invokeTag('hiddenField','g',84,['id':("attachments[${i}].isPrimarySig"),'name':("attachments[${i}].isPrimarySig"),'value':(isPrimarySig)],-1)
printHtmlPart(4)
}
printHtmlPart(27)
expressionOut.print(hasErrors(bean: customerInstance, field: 'attachments['+i+'].fileData', 'has-error'))
printHtmlPart(28)
expressionOut.print(i)
printHtmlPart(29)
invokeTag('message','g',88,['code':("attachment.fileData.label"),'default':("Others File")],-1)
printHtmlPart(30)
expressionOut.print(i)
printHtmlPart(31)
expressionOut.print(i)
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',96,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',97,['bean':(customerInstance),'field':("attachments[${i}].fileData")],2)
printHtmlPart(33)
})
invokeTag('hasErrors','g',100,['bean':(customerInstance),'field':("attachments[${i}].fileData")],1)
printHtmlPart(34)
if(true && (canDelete!="false")) {
printHtmlPart(35)
}
printHtmlPart(36)
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
