import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccountshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glAccount.label', default: 'GlAccount'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
expressionOut.print(glAccountInstance?.name.encodeAsHTML())
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/glAccount'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
expressionOut.print(glAccountInstance?.type?.encodeAsHTML())
})
invokeTag('link','g',24,['controller':("glAcctType"),'action':("show"),'id':(glAccountInstance?.type?.id)],3)
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(glAccountInstance?.currency?.name.encodeAsHTML())
})
invokeTag('link','g',28,['controller':("currency"),'action':("show"),'id':(glAccountInstance?.currency?.id)],3)
printHtmlPart(12)
expressionOut.print(glAccountInstance?.code)
printHtmlPart(13)
expressionOut.print(glAccountInstance?.name)
printHtmlPart(14)
expressionOut.print(glAccountInstance?.shortName)
printHtmlPart(15)
expressionOut.print(glAccountInstance?.parent?.sort_name)
printHtmlPart(16)
invokeTag('formatBoolean','g',48,['boolean':(glAccountInstance?.batchUpdate)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',52,['format':("###,###,##0.00"),'number':(glAccountInstance?.debit)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',56,['format':("###,###,##0.00"),'number':(glAccountInstance?.credit)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',60,['format':("###,###,##0.00"),'number':(glAccountInstance?.debitToday)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',64,['format':("###,###,##0.00"),'number':(glAccountInstance?.creditToday)],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',68,['format':("###,###,##0.00"),'number':(glAccountInstance?.debitBalance)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',72,['format':("###,###,##0.00"),'number':(glAccountInstance?.creditBalance)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',76,['format':("###,###,##0.00"),'number':(glAccountInstance?.balance)],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',81,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',84,['class':("list"),'action':("index")],3)
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(glAccountInstance)],3)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('form','g',90,['id':("delete"),'url':([resource:glAccountInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',92,['class':("create"),'action':("create")],3)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(33)
invokeTag('textField','g',108,['class':("form-control"),'id':("glcode"),'name':("glcode"),'value':(glAccountInstance?.currency?.code.encodeAsHTML())],-1)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(35)
invokeTag('textField','g',112,['class':("form-control"),'id':("glcode"),'name':("glcode"),'value':(glAccountInstance.code)],-1)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(37)
invokeTag('customDatePicker','g',119,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(39)
invokeTag('customDatePicker','g',124,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',128,['target':("_blank"),'class':("btn btn-default"),'url':("${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(6).baseParams}&output=${icbs.admin.Report.get(6).outputParam}&reportUnit=${icbs.admin.Report.get(6).reportUnit}&date_start=document.getElementById('date1').value&date_end=document.getElementById('date2').value&gl_code=${glAccountInstance.code}&currency_code=${glAccountInstance?.currency?.code}&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}")],3)
printHtmlPart(42)
createTagBody(3, {->
printHtmlPart(43)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(24).baseParams)
printHtmlPart(44)
expressionOut.print(icbs.admin.Report.get(24).outputParam)
printHtmlPart(45)
expressionOut.print(icbs.admin.Report.get(24).reportUnit)
printHtmlPart(46)
expressionOut.print(glAccountInstance.code)
printHtmlPart(47)
expressionOut.print(glAccountInstance?.currency?.code)
printHtmlPart(48)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).branch.name)
printHtmlPart(49)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(50)
})
invokeTag('javascript','g',160,[:],3)
printHtmlPart(51)
})
invokeTag('captureContent','sitemesh',167,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',168,[:],1)
printHtmlPart(52)
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
