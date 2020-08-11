import icbs.tellering.TxnTellerBalance
import icbs.tellering.TxnTellerCash
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_homelanding_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/home/landing.gsp" }
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
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.error)) {
printHtmlPart(8)
expressionOut.print(flash.error)
printHtmlPart(9)
expressionOut.print(flash.error)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (flash.success)) {
printHtmlPart(12)
expressionOut.print(flash.success)
printHtmlPart(13)
expressionOut.print(flash.success)
printHtmlPart(14)
}
printHtmlPart(2)
if(true && (userInstance.designation.id==2)) {
printHtmlPart(2)
invokeTag('set','g',44,['var':("w"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',45,['var':("x"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',46,['var':("y"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',47,['var':("z"),'value':(0)],-1)
printHtmlPart(2)
loop:{
int i = 0
for( tbc in (tbCash) ) {
printHtmlPart(2)
if(true && (tbc?.txnFile.txnDate == tbc?.branch?.runDate)) {
printHtmlPart(15)
invokeTag('set','g',50,['var':("w"),'value':(w + tbc?.cashInAmt)],-1)
printHtmlPart(16)
invokeTag('set','g',51,['var':("x"),'value':(x + tbc?.cashOutAmt)],-1)
printHtmlPart(15)
invokeTag('set','g',52,['var':("y"),'value':(y + tbc?.checkInAmt)],-1)
printHtmlPart(15)
invokeTag('set','g',53,['var':("z"),'value':(z + tbc?.checkOutAmt)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
loop:{
int i = 0
for( userMessageInstance in (userMessageInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sender.name"))
printHtmlPart(23)
if(true && (userMessageInstance.isRead == true)) {
printHtmlPart(24)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',75,['controller':("UserMessage"),'action':("show"),'id':(userMessageInstance.id)],5)
printHtmlPart(23)
}
else {
printHtmlPart(25)
createTagBody(5, {->
expressionOut.print(fieldValue(bean: userMessageInstance, field: "subject"))
})
invokeTag('link','g',78,['controller':("UserMessage"),'action':("show"),'id':(userMessageInstance.id),'class':("bold")],5)
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "body"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: userMessageInstance, field: "sentAt"))
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',88,['tag':("main-content")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',92,['uri':("/userMaster/create")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',93,['uri':("/branch")],3)
printHtmlPart(33)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',94,['uri':("")],3)
printHtmlPart(33)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',95,['uri':("")],3)
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',96,['controller':("customer")],3)
printHtmlPart(37)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',97,['controller':("deposit"),'action':("depositSearch")],3)
printHtmlPart(37)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',98,['controller':("tellering")],3)
printHtmlPart(37)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',99,['url':("../ATMInterface")],3)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',101,['uri':("/userMessage/create")],3)
printHtmlPart(44)
if(true && (userInstance.designation.id==1)) {
printHtmlPart(45)
createClosureForHtmlPart(46, 4)
invokeTag('link','g',103,['uri':("/userMaster")],4)
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',104,['controller':("product"),'action':("index")],4)
printHtmlPart(49)
createClosureForHtmlPart(50, 4)
invokeTag('link','g',105,['uri':("/periodicOps")],4)
printHtmlPart(47)
createClosureForHtmlPart(51, 4)
invokeTag('link','g',106,['controller':("Holiday"),'action':("index")],4)
printHtmlPart(52)
createClosureForHtmlPart(53, 4)
invokeTag('link','g',107,['controller':("Branch"),'action':("index")],4)
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (userInstance.designation.id==2)) {
printHtmlPart(45)
createClosureForHtmlPart(56, 4)
invokeTag('link','g',111,['controller':("customer"),'action':("create")],4)
printHtmlPart(57)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',112,['uri':("/tellering")],4)
printHtmlPart(54)
}
printHtmlPart(58)
})
invokeTag('captureContent','sitemesh',116,['tag':("main-actions")],2)
printHtmlPart(59)
})
invokeTag('captureBody','sitemesh',118,[:],1)
printHtmlPart(60)
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
