import icbs.deposit.Rollover
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_rollovershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rollover/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'rollover.label', default: 'Rollover'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (rolloverInstance?.rolloverSequence)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("rollover.rolloverSequence.label"),'default':("Rollover Sequence")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',22,['bean':(rolloverInstance),'field':("rolloverSequence")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.startDate)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("rollover.startDate.label"),'default':("Start Date")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',31,['date':(rolloverInstance?.startDate)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.endDate)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("rollover.endDate.label"),'default':("End Date")],-1)
printHtmlPart(16)
invokeTag('formatDate','g',40,['date':(rolloverInstance?.endDate)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.rolloverType)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("rollover.rolloverType.label"),'default':("Rollover Type")],-1)
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(rolloverInstance?.rolloverType?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("rolloverType"),'action':("show"),'id':(rolloverInstance?.rolloverType?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.principalAmt)) {
printHtmlPart(19)
invokeTag('message','g',56,['code':("rollover.principalAmt.label"),'default':("Principal Amt")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',58,['bean':(rolloverInstance),'field':("principalAmt")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.preTermInterestAmt)) {
printHtmlPart(21)
invokeTag('message','g',65,['code':("rollover.preTermInterestAmt.label"),'default':("Pre Term Interest Amt")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',67,['bean':(rolloverInstance),'field':("preTermInterestAmt")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.taxAmt1)) {
printHtmlPart(23)
invokeTag('message','g',74,['code':("rollover.taxAmt1.label"),'default':("Tax Amt1")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',76,['bean':(rolloverInstance),'field':("taxAmt1")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.taxAmt2)) {
printHtmlPart(25)
invokeTag('message','g',83,['code':("rollover.taxAmt2.label"),'default':("Tax Amt2")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',85,['bean':(rolloverInstance),'field':("taxAmt2")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.taxAmt3)) {
printHtmlPart(27)
invokeTag('message','g',92,['code':("rollover.taxAmt3.label"),'default':("Tax Amt3")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',94,['bean':(rolloverInstance),'field':("taxAmt3")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.ctd)) {
printHtmlPart(29)
invokeTag('message','g',101,['code':("rollover.ctd.label"),'default':("Ctd")],-1)
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(rolloverInstance?.ctd?.encodeAsHTML())
})
invokeTag('link','g',103,['controller':("CTD"),'action':("show"),'id':(rolloverInstance?.ctd?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.rolloverStatus)) {
printHtmlPart(31)
invokeTag('message','g',110,['code':("rollover.rolloverStatus.label"),'default':("Rollover Status")],-1)
printHtmlPart(32)
createTagBody(4, {->
expressionOut.print(rolloverInstance?.rolloverStatus?.encodeAsHTML())
})
invokeTag('link','g',112,['controller':("rolloverStatus"),'action':("show"),'id':(rolloverInstance?.rolloverStatus?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.interestPaymentMode)) {
printHtmlPart(33)
invokeTag('message','g',119,['code':("rollover.interestPaymentMode.label"),'default':("Interest Payment Mode")],-1)
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(rolloverInstance?.interestPaymentMode?.encodeAsHTML())
})
invokeTag('link','g',121,['controller':("interestPaymentMode"),'action':("show"),'id':(rolloverInstance?.interestPaymentMode?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.deposit)) {
printHtmlPart(35)
invokeTag('message','g',128,['code':("rollover.deposit.label"),'default':("Deposit")],-1)
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(rolloverInstance?.deposit?.encodeAsHTML())
})
invokeTag('link','g',130,['controller':("deposit"),'action':("show"),'id':(rolloverInstance?.deposit?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (rolloverInstance?.normalInterestAmt)) {
printHtmlPart(37)
invokeTag('message','g',137,['code':("rollover.normalInterestAmt.label"),'default':("Normal Interest Amt")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',139,['bean':(rolloverInstance),'field':("normalInterestAmt")],-1)
printHtmlPart(11)
}
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
createTagBody(4, {->
invokeTag('message','g',147,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',147,['class':("edit"),'action':("edit"),'resource':(rolloverInstance)],4)
printHtmlPart(41)
invokeTag('actionSubmit','g',148,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',150,['url':([resource:rolloverInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',152,['tag':("main-content")],2)
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(45)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(46)
invokeTag('message','g',155,['code':("default.home.label")],-1)
printHtmlPart(47)
createTagBody(3, {->
invokeTag('message','g',156,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',156,['class':("list"),'action':("index")],3)
printHtmlPart(48)
createTagBody(3, {->
invokeTag('message','g',157,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',157,['class':("create"),'action':("create")],3)
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',159,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',160,[:],1)
printHtmlPart(50)
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
