import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_otheracct_onetomany_otherAcct_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/otheracct/onetomany/_otherAcct.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (otherAcct?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',11,['name':("otheraccts[${i}].id"),'value':(otherAcct?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',12,['name':("otheraccts[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',15,['name':("otheraccts[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',17,['name':("otheraccts[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].type', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('message','g',22,['code':("otherAcct.type.label"),'default':("Other Acct Type Id")],-1)
printHtmlPart(8)
invokeTag('select','g',26,['id':("otheraccts[${i}].type"),'name':("otheraccts[${i}].type.id"),'from':(icbs.lov.OtherAcctType.list()),'optionValue':("description"),'optionKey':("id"),'value':(otherAcct?.type?.id),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',32,['bean':(customerInstance),'field':("otheraccts[${i}].type")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',35,['bean':(customerInstance),'field':("otheraccts[${i}].type")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].bankName', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(16)
invokeTag('message','g',41,['code':("otherAcct.bankName.label"),'default':("Bank Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',45,['id':("bankName"),'name':("otheraccts[${i}].bankName"),'maxlength':("50"),'value':(otherAcct?.bankName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',50,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',51,['bean':(customerInstance),'field':("otheraccts[${i}].bankName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',54,['bean':(customerInstance),'field':("otheraccts[${i}].bankName")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].branchName', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',60,['code':("otherAcct.branchName.label"),'default':("Branch Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',64,['name':("otheraccts[${i}].branchName"),'maxlength':("50"),'value':(otherAcct?.branchName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',70,['bean':(customerInstance),'field':("otheraccts[${i}].branchName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',73,['bean':(customerInstance),'field':("otheraccts[${i}].branchName")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].acctNo', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(19)
invokeTag('message','g',79,['code':("otherAcct.acctNo.label"),'default':("Acct No")],-1)
printHtmlPart(8)
invokeTag('textField','g',83,['name':("otheraccts[${i}].acctNo"),'maxlength':("30"),'value':(otherAcct?.acctNo),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',88,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',89,['bean':(customerInstance),'field':("otheraccts[${i}].acctNo")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',92,['bean':(customerInstance),'field':("otheraccts[${i}].acctNo")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].yearObtained', 'has-error'))
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(22)
invokeTag('message','g',98,['code':("otherAcct.yearObtained.label"),'default':("Year Obtained")],-1)
printHtmlPart(23)
invokeTag('textField','g',102,['name':("otheraccts[${i}].yearObtained"),'id':("yearObtained"),'maxlength':("4"),'value':(otherAcct?.yearObtained),'class':("form-control")],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',107,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',108,['bean':(customerInstance),'field':("otheraccts[${i}].yearObtained")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',111,['bean':(customerInstance),'field':("otheraccts[${i}].yearObtained")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].isPayed', 'has-error'))
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(30)
invokeTag('message','g',117,['code':("otherAcct.isPayed.label"),'default':("Is Payed")],-1)
printHtmlPart(31)
invokeTag('checkBox','g',120,['id':("isPayed"),'name':("otheraccts[${i}].isPayed"),'class':(""),'checked':("false"),'value':(otherAcct?.isPayed)],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',125,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',126,['bean':(customerInstance),'field':("otheraccts[${i}].isPayed")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',129,['bean':(customerInstance),'field':("otheraccts[${i}].isPayed")],1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: customerInstance, field: 'otheraccts['+i+'].isOtherAcctJoint', 'has-error'))
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(33)
invokeTag('message','g',135,['code':("otherAcct.isOtherAcctJoint.label"),'default':("Is Other Acct Joint")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',139,['name':("otheraccts[${i}].isOtherAcctJoint"),'value':(otherAcct?.isOtherAcctJoint)],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',144,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',145,['bean':(customerInstance),'field':("otheraccts[${i}].isOtherAcctJoint")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',148,['bean':(customerInstance),'field':("otheraccts[${i}].isOtherAcctJoint")],1)
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
