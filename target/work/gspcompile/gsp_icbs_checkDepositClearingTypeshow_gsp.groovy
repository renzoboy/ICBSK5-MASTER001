import icbs.admin.CheckDepositClearingType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_checkDepositClearingTypeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checkDepositClearingType/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'checkDepositClearingType.label', default: 'CheckDepositClearingType'))],-1)
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
expressionOut.print(createLink(uri: '/checkDepositClearingType'))
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
expressionOut.print(checkDepositClearingTypeInstance?.code)
printHtmlPart(12)
expressionOut.print(checkDepositClearingTypeInstance?.description)
printHtmlPart(13)
expressionOut.print(checkDepositClearingTypeInstance?.shortDescription)
printHtmlPart(14)
expressionOut.print(checkDepositClearingTypeInstance?.clearingDays)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(checkDepositClearingTypeInstance?.currency?.name)
})
invokeTag('link','g',59,['controller':("currency"),'action':("show"),'id':(checkDepositClearingTypeInstance?.currency?.id)],3)
printHtmlPart(16)
expressionOut.print(checkDepositClearingTypeInstance?.configItemStatus)
printHtmlPart(17)
if(true && (checkDepositClearingTypeInstance?.code)) {
printHtmlPart(18)
invokeTag('message','g',72,['code':("checkDepositClearingType.code.label"),'default':("Code")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',74,['bean':(checkDepositClearingTypeInstance),'field':("code")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.description)) {
printHtmlPart(22)
invokeTag('message','g',81,['code':("checkDepositClearingType.description.label"),'default':("Description")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',83,['bean':(checkDepositClearingTypeInstance),'field':("description")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.shortDescription)) {
printHtmlPart(24)
invokeTag('message','g',90,['code':("checkDepositClearingType.shortDescription.label"),'default':("Short Description")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',92,['bean':(checkDepositClearingTypeInstance),'field':("shortDescription")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.isOnUs)) {
printHtmlPart(26)
invokeTag('message','g',99,['code':("checkDepositClearingType.isOnUs.label"),'default':("Is On Us")],-1)
printHtmlPart(27)
invokeTag('formatBoolean','g',101,['boolean':(checkDepositClearingTypeInstance?.isOnUs)],-1)
printHtmlPart(28)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.hasVariableClearingDays)) {
printHtmlPart(29)
invokeTag('message','g',108,['code':("checkDepositClearingType.hasVariableClearingDays.label"),'default':("Has Variable Clearing Days")],-1)
printHtmlPart(30)
invokeTag('formatBoolean','g',110,['boolean':(checkDepositClearingTypeInstance?.hasVariableClearingDays)],-1)
printHtmlPart(28)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.clearingDays)) {
printHtmlPart(31)
invokeTag('message','g',117,['code':("checkDepositClearingType.clearingDays.label"),'default':("Clearing Days")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',119,['bean':(checkDepositClearingTypeInstance),'field':("clearingDays")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.currency)) {
printHtmlPart(33)
invokeTag('message','g',126,['code':("checkDepositClearingType.currency.label"),'default':("Currency")],-1)
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(checkDepositClearingTypeInstance?.currency?.name)
})
invokeTag('link','g',128,['controller':("currency"),'action':("show"),'id':(checkDepositClearingTypeInstance?.currency?.id)],4)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (checkDepositClearingTypeInstance?.configItemStatus)) {
printHtmlPart(35)
invokeTag('message','g',135,['code':("checkDepositClearingType.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(36)
expressionOut.print(checkDepositClearingTypeInstance?.configItemStatus?.description)
printHtmlPart(20)
}
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('form','g',147,['id':("delete"),'url':([resource:checkDepositClearingTypeInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(5)
})
invokeTag('captureContent','sitemesh',147,['tag':("main-content")],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
createTagBody(3, {->
invokeTag('message','g',154,['code':("default.button.edit.label")],-1)
})
invokeTag('link','g',155,['class':("edit"),'action':("edit"),'resource':(checkDepositClearingTypeInstance)],3)
printHtmlPart(41)
invokeTag('actionSubmit','g',163,['class':("delete"),'id':("deleteDepositClearingType"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00403', 'form#delete', 'Override delete Check Deposit Clearing Type.', null); 
                                },
                                function(){
                                    return;
                                });                                
                        """)],-1)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',174,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',174,[:],1)
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
