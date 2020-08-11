import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_beneficiary_onetomany_beneficiary_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/beneficiary/onetomany/_beneficiary.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (beneficiary?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',9,['name':("beneficiaries[${i}].id"),'value':(beneficiary?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',10,['name':("beneficiaries[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',13,['name':("beneficiaries[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',15,['name':("beneficiaries[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].firstName', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('message','g',19,['code':("beneficiary.firstName.label"),'default':("First Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',23,['name':("beneficiaries[${i}].firstName"),'value':(beneficiary?.firstName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',28,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',29,['bean':(customerInstance),'field':("beneficiaries[${i}].firstName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',32,['bean':(customerInstance),'field':("beneficiaries[${i}].firstName")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].middleName', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(15)
invokeTag('message','g',37,['code':("beneficiary.middleName.label"),'default':("Middle Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',41,['name':("beneficiaries[${i}].middleName"),'value':(beneficiary?.middleName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',46,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',47,['bean':(customerInstance),'field':("beneficiaries[${i}].middleName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',50,['bean':(customerInstance),'field':("beneficiaries[${i}].middleName")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].lastName', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(16)
invokeTag('message','g',55,['code':("beneficiary.lastName.label"),'default':("Last Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',59,['name':("beneficiaries[${i}].lastName"),'value':(beneficiary?.lastName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',64,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',65,['bean':(customerInstance),'field':("beneficiaries[${i}].lastName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',68,['bean':(customerInstance),'field':("beneficiaries[${i}].lastName")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].suffixName', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(17)
invokeTag('message','g',73,['code':("beneficiary.suffixName.label"),'default':("Suffix Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',77,['name':("beneficiaries[${i}].suffixName"),'value':(beneficiary?.suffixName),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',82,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',83,['bean':(customerInstance),'field':("beneficiaries[${i}].suffixName")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',86,['bean':(customerInstance),'field':("beneficiaries[${i}].suffixName")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].birthDate', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',91,['code':("beneficiary.birthDate.label"),'default':("Bith Date")],-1)
printHtmlPart(19)
invokeTag('customDatePicker','g',94,['name':("beneficiaries[${i}].birthDate"),'precision':("day"),'value':(beneficiary?.birthDate),'default':("none"),'noSelection':(['': '']),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',99,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',100,['bean':(customerInstance),'field':("beneficiaries[${i}].birthDate")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',103,['bean':(customerInstance),'field':("beneficiaries[${i}].birthDate")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].customerRelationship', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(20)
invokeTag('message','g',108,['code':("beneficiary.customerRelationship.label"),'default':("Relationship")],-1)
printHtmlPart(19)
invokeTag('select','g',111,['id':("beneficiaries[${i}].customerRelationship"),'name':("beneficiaries[${i}].customerRelationship.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus('CRT','TRUE')),'optionKey':("id"),'optionValue':("itemValue"),'value':(beneficiary?.customerRelationship?.id),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',116,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',117,['bean':(customerInstance),'field':("beneficiaries[${i}].customerRelationship")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',120,['bean':(customerInstance),'field':("beneficiaries[${i}].customerRelationship")],1)
printHtmlPart(21)
if(true && (i!=0)) {
printHtmlPart(22)
}
printHtmlPart(23)
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
