import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_hold_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/hold/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("id"),'value':(holdInstance?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("deposit"),'name':("deposit.id"),'value':(holdInstance?.deposit?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: holdInstance, field: 'type', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',14,['code':("hold.type.label"),'default':("Hold Type")],-1)
printHtmlPart(4)
if(true && (!disabled)) {
printHtmlPart(5)
invokeTag('select','g',19,['id':("type"),'name':("type.id"),'onchange':("updateForm()"),'from':(icbs.lov.HoldType.list()),'optionKey':("id"),'required':(""),'optionValue':("description"),'value':(holdInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(6)
}
else if(true && (disabled)) {
printHtmlPart(5)
invokeTag('select','g',23,['id':("type"),'disabled':("disabled"),'name':("type.id"),'onchange':("updateForm()"),'from':(icbs.lov.HoldType.list()),'optionKey':("id"),'required':(""),'optionValue':("description"),'value':(holdInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',32,['bean':(holdInstance),'field':("type")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',35,['bean':(holdInstance),'field':("type")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: holdInstance, field: 'status', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',41,['code':("hold.status.label"),'default':("Status")],-1)
printHtmlPart(14)
invokeTag('select','g',46,['id':("status"),'name':("status.id"),'from':(icbs.lov.HoldStatus.list()),'optionValue':("description"),'optionKey':("id"),'value':(holdInstance?.status?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(5)
if(true && (holdInstance?.status?.id < 3)) {
printHtmlPart(15)
invokeTag('hiddenField','g',49,['id':("holdDate"),'name':("holdDate"),'value':(icbs.admin.Branch.findById(session.branch_id).runDate.format("MM/dd/yyyy"))],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',50,['id':("heldById"),'name':("heldBy"),'value':(icbs.admin.UserMaster.findById(session.user_id).id)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: holdInstance, field: 'holdDate', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',58,['code':("hold.holdDate.label"),'default':("Hold Date")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',62,['id':("holdDate"),'name':("holdDate"),'value':(icbs.admin.Branch.findById(session.branch_id).runDate.format("MM/dd/yyyy"))],-1)
printHtmlPart(5)
invokeTag('textField','g',63,['name':("holdDate"),'disabled':("disabled"),'value':(icbs.admin.Branch.findById(session.branch_id).runDate.format("MM/dd/yyyy")),'class':("form-control")],-1)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',70,['bean':(holdInstance),'field':("holdDate")],3)
printHtmlPart(24)
})
invokeTag('hasErrors','g',73,['bean':(holdInstance),'field':("holdDate")],2)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: holdInstance, field: 'heldById', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',81,['code':("heldById.label"),'default':("Held By")],-1)
printHtmlPart(27)
expressionOut.print(icbs.admin.UserMaster.findById(session.user_id))
printHtmlPart(28)
invokeTag('textField','g',87,['name':("heldById"),'readonly':("true"),'value':(icbs.admin.UserMaster.findById(session.user_id).username),'class':("form-control")],-1)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',93,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',94,['bean':(holdInstance),'field':("heldById")],3)
printHtmlPart(24)
})
invokeTag('hasErrors','g',97,['bean':(holdInstance),'field':("heldById")],2)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: holdInstance, field: 'maturityDate', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',104,['code':("hold.maturityDate.label"),'default':("Maturity Date")],-1)
printHtmlPart(31)
if(true && (!disabled)) {
printHtmlPart(32)
invokeTag('customDatePicker','g',109,['name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(icbs.admin.Branch.findById(session.branch_id).runDate+1)],-1)
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (disabled)) {
printHtmlPart(35)
invokeTag('customDatePicker','g',112,['name':("maturityDate"),'precision':("day"),'class':("form-control"),'value':(holdInstance?.maturityDate)],-1)
printHtmlPart(33)
}
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
invokeTag('message','g',118,['error':(it)],-1)
printHtmlPart(10)
})
invokeTag('eachError','g',119,['bean':(holdInstance),'field':("maturityDate")],3)
printHtmlPart(11)
})
invokeTag('hasErrors','g',122,['bean':(holdInstance),'field':("maturityDate")],2)
printHtmlPart(36)
if(true && (holdInstance?.type?.id!=1&&holdInstance?.type?.id)) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(hasErrors(bean: holdInstance, field: 'percent', 'has-error'))
printHtmlPart(40)
invokeTag('message','g',130,['code':("hold.percent.label"),'default':("Percentage")],-1)
printHtmlPart(41)
invokeTag('field','g',133,['name':("percent"),'value':(fieldValue(bean: holdInstance, field: 'percent')),'class':("form-control")],-1)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
createTagBody(3, {->
printHtmlPart(44)
invokeTag('message','g',138,['error':(it)],-1)
printHtmlPart(45)
})
invokeTag('eachError','g',139,['bean':(holdInstance),'field':("percent")],3)
printHtmlPart(46)
})
invokeTag('hasErrors','g',142,['bean':(holdInstance),'field':("percent")],2)
printHtmlPart(47)
if(true && (session["holdaction"] == 'create')) {
printHtmlPart(48)
if(true && (holdInstance?.type?.id==1||(holdInstance?.type?.id==2&&holdInstance?.id)||!holdInstance?.type)) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(hasErrors(bean: holdInstance, field: 'amt', 'has-error'))
printHtmlPart(49)
invokeTag('message','g',151,['code':("hold.amt.label"),'default':("Amount")],-1)
printHtmlPart(50)
invokeTag('field','g',154,['name':("amt"),'value':(fieldValue(bean: holdInstance, field: 'amt')),'class':("form-control")],-1)
printHtmlPart(42)
createTagBody(3, {->
printHtmlPart(43)
createTagBody(4, {->
printHtmlPart(44)
invokeTag('message','g',159,['error':(it)],-1)
printHtmlPart(45)
})
invokeTag('eachError','g',160,['bean':(holdInstance),'field':("amt")],4)
printHtmlPart(46)
})
invokeTag('hasErrors','g',163,['bean':(holdInstance),'field':("amt")],3)
printHtmlPart(51)
}
else {
printHtmlPart(52)
if(true && (holdInstance?.type?.id==1||(holdInstance?.type?.id==2&&holdInstance?.id)||!holdInstance?.type)) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(hasErrors(bean: holdInstance, field: 'amt', 'has-error'))
printHtmlPart(49)
invokeTag('message','g',172,['code':("hold.amt.label"),'default':("Amount")],-1)
printHtmlPart(50)
invokeTag('field','g',175,['disabled':(disabled),'name':("amt"),'value':(fieldValue(bean: holdInstance, field: 'amt')),'class':("form-control")],-1)
printHtmlPart(42)
createTagBody(3, {->
printHtmlPart(43)
createTagBody(4, {->
printHtmlPart(44)
invokeTag('message','g',180,['error':(it)],-1)
printHtmlPart(45)
})
invokeTag('eachError','g',181,['bean':(holdInstance),'field':("amt")],4)
printHtmlPart(46)
})
invokeTag('hasErrors','g',184,['bean':(holdInstance),'field':("amt")],3)
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(hasErrors(bean: holdInstance, field: 'remarks', 'has-error'))
printHtmlPart(55)
invokeTag('message','g',192,['code':("hold.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(56)
invokeTag('textArea','g',196,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(holdInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(57)
if(true && (holdInstance?.type?.id==1||(holdInstance?.type?.id==2&&holdInstance?.id)||!holdInstance?.type)) {
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(hasErrors(bean: holdInstance, field: 'amt', 'has-error'))
printHtmlPart(49)
invokeTag('message','g',208,['code':("hold.amt.label"),'default':("Amount")],-1)
printHtmlPart(58)
invokeTag('field','g',212,['name':("amt"),'disabled':(disabled),'value':(fieldValue(bean: holdInstance, field: 'amt')),'class':("form-control")],-1)
printHtmlPart(42)
createTagBody(2, {->
printHtmlPart(43)
createTagBody(3, {->
printHtmlPart(44)
invokeTag('message','g',217,['error':(it)],-1)
printHtmlPart(45)
})
invokeTag('eachError','g',218,['bean':(holdInstance),'field':("amt")],3)
printHtmlPart(46)
})
invokeTag('hasErrors','g',221,['bean':(holdInstance),'field':("amt")],2)
printHtmlPart(59)
expressionOut.print(hasErrors(bean: holdInstance, field: 'remarks', 'has-error'))
printHtmlPart(60)
invokeTag('message','g',227,['code':("hold.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(50)
invokeTag('textArea','g',230,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(holdInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(61)
createTagBody(2, {->
printHtmlPart(43)
createTagBody(3, {->
printHtmlPart(44)
invokeTag('message','g',236,['error':(it)],-1)
printHtmlPart(45)
})
invokeTag('eachError','g',237,['bean':(holdInstance),'field':("remarks")],3)
printHtmlPart(46)
})
invokeTag('hasErrors','g',240,['bean':(holdInstance),'field':("remarks")],2)
printHtmlPart(62)
}
printHtmlPart(63)
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
