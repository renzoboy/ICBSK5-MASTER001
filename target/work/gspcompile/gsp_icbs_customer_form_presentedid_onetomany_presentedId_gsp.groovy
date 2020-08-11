import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_presentedid_onetomany_presentedId_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/presentedid/onetomany/_presentedId.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(presentedId?.type?.id)
printHtmlPart(2)
expressionOut.print(i)
printHtmlPart(3)
if(true && (presentedId?.id)) {
printHtmlPart(4)
invokeTag('hiddenField','g',35,['name':("presentedids[${i}].id"),'value':(presentedId?.id)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',36,['name':("presentedids[${i}].new"),'value':("false")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(4)
invokeTag('hiddenField','g',39,['name':("presentedids[${i}].new"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
invokeTag('hiddenField','g',41,['name':("presentedids[${i}].deleted"),'value':("false")],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].type', 'has-error'))
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(8)
invokeTag('message','g',46,['code':("presentedId.type.label"),'default':("Presented Id Type")],-1)
printHtmlPart(9)
invokeTag('select','g',51,['id':("presentedids[${i}].type"),'name':("presentedids[${i}].type.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("CIDT",true)),'optionKey':("id"),'optionValue':("itemValue"),'required':(""),'value':(presentedId?.type?.id),'class':("form-control"),'noSelection':(['null': '']),'onchange':("getPresentedId(this.value);")],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',52,['name':("xxpresentID"),'id':("xxpresentID"),'value':("")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',58,['bean':(customerInstance),'field':("presentedids[${i}].type")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',61,['bean':(customerInstance),'field':("presentedids[${i}].type")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].idNo', 'has-error'))
printHtmlPart(16)
expressionOut.print(i)
printHtmlPart(17)
invokeTag('message','g',67,['code':("presentedId.idNo.label"),'default':("Id No")],-1)
printHtmlPart(18)
invokeTag('textField','g',72,['name':("presentedids[${i}].idNo"),'id':("idno${i}"),'value':(presentedId?.idNo),'class':("form-control")],-1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(22)
})
invokeTag('eachError','g',78,['bean':(customerInstance),'field':("presentedids[${i}].idNo")],2)
printHtmlPart(23)
})
invokeTag('hasErrors','g',81,['bean':(customerInstance),'field':("presentedids[${i}].idNo")],1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].issueDate', 'has-error'))
printHtmlPart(25)
expressionOut.print(i)
printHtmlPart(26)
invokeTag('message','g',88,['code':("presentedId.issueDate.label"),'default':("Issue Date")],-1)
printHtmlPart(27)
invokeTag('customDatePicker','g',92,['name':("presentedids[${i}].issueDate"),'precision':("day"),'value':(presentedId?.issueDate),'default':("none"),'noSelection':(['': '']),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('message','g',97,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',98,['bean':(customerInstance),'field':("presentedids[${i}].issueDate")],2)
printHtmlPart(32)
})
invokeTag('hasErrors','g',101,['bean':(customerInstance),'field':("presentedids[${i}].issueDate")],1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].validDate', 'has-error'))
printHtmlPart(25)
expressionOut.print(i)
printHtmlPart(34)
invokeTag('message','g',108,['code':("presentedId.issueDate.label"),'default':("Valid Till Date")],-1)
printHtmlPart(27)
invokeTag('customDatePicker','g',112,['name':("presentedids[${i}].validDate"),'precision':("day"),'value':(presentedId?.validDate),'default':("none"),'noSelection':(['': '']),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('message','g',117,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',118,['bean':(customerInstance),'field':("presentedids[${i}].validDate")],2)
printHtmlPart(32)
})
invokeTag('hasErrors','g',121,['bean':(customerInstance),'field':("presentedids[${i}].validDate")],1)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].isGovtIssue', 'has-error'))
printHtmlPart(36)
expressionOut.print(i)
printHtmlPart(37)
invokeTag('message','g',129,['code':("presentedId.isGovtIssue.label"),'default':("Is Govt Issue")],-1)
printHtmlPart(27)
invokeTag('checkBox','g',133,['name':("presentedids[${i}].isGovtIssue"),'value':(presentedId?.isGovtIssue)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('message','g',138,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',139,['bean':(customerInstance),'field':("presentedids[${i}].isGovtIssue")],2)
printHtmlPart(32)
})
invokeTag('hasErrors','g',142,['bean':(customerInstance),'field':("presentedids[${i}].isGovtIssue")],1)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].isWithPhoto', 'has-error'))
printHtmlPart(36)
expressionOut.print(i)
printHtmlPart(39)
invokeTag('message','g',150,['code':("presentedId.isWithPhoto.label"),'default':("Is With Photo")],-1)
printHtmlPart(27)
invokeTag('checkBox','g',154,['name':("presentedids[${i}].isWithPhoto"),'value':(presentedId?.isWithPhoto)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('message','g',159,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',160,['bean':(customerInstance),'field':("presentedids[${i}].isWithPhoto")],2)
printHtmlPart(32)
})
invokeTag('hasErrors','g',163,['bean':(customerInstance),'field':("presentedids[${i}].isWithPhoto")],1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: customerInstance, field: 'presentedids['+i+'].isWithSignature', 'has-error'))
printHtmlPart(36)
expressionOut.print(i)
printHtmlPart(40)
invokeTag('message','g',170,['code':("presentedId.isWithSignature.label"),'default':("Is With Signature")],-1)
printHtmlPart(27)
invokeTag('checkBox','g',174,['name':("presentedids[${i}].isWithSignature"),'value':(presentedId?.isWithSignature)],-1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('message','g',179,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',180,['bean':(customerInstance),'field':("presentedids[${i}].isWithSignature")],2)
printHtmlPart(32)
})
invokeTag('hasErrors','g',183,['bean':(customerInstance),'field':("presentedids[${i}].isWithSignature")],1)
printHtmlPart(41)
if(true && (canDelete!="false")) {
printHtmlPart(42)
}
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595404931307L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
