import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_education_onetomany_education_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/education/onetomany/_education.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (education?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',11,['name':("educations[${i}].id"),'value':(education?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',12,['name':("educations[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',15,['name':("educations[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',17,['name':("educations[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
if(true && (choice=='0')) {
printHtmlPart(3)
invokeTag('hiddenField','g',21,['name':("educations[${i}].type"),'value':("1")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (choice=='1')) {
printHtmlPart(3)
invokeTag('hiddenField','g',24,['name':("educations[${i}].type"),'value':("2")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (choice=='2')) {
printHtmlPart(3)
invokeTag('hiddenField','g',27,['name':("educations[${i}].type"),'value':("3")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (choice=='3')) {
printHtmlPart(3)
invokeTag('hiddenField','g',30,['name':("educations[${i}].type"),'value':("4")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (choice=='4')) {
printHtmlPart(3)
invokeTag('hiddenField','g',33,['name':("educations[${i}].type"),'value':("5")],-1)
printHtmlPart(4)
}
printHtmlPart(6)
expressionOut.print(hasErrors(bean: customerInstance, field: 'educations['+i+'].schoolAttended', 'has-error'))
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(8)
invokeTag('message','g',40,['code':("education.schoolAttended.label"),'default':("School Attended")],-1)
printHtmlPart(9)
invokeTag('textField','g',44,['name':("educations[${i}].schoolAttended"),'maxlength':("50"),'value':(education?.schoolAttended),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',49,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',50,['bean':(customerInstance),'field':("educations[${i}].schoolAttended")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',53,['bean':(customerInstance),'field':("educations[${i}].schoolAttended")],1)
printHtmlPart(15)
if(true && (!(choice=='0'||choice=='1'))) {
printHtmlPart(16)
expressionOut.print(hasErrors(bean: customerInstance, field:  'educations['+i+'].educationDegree', 'has-error'))
printHtmlPart(17)
expressionOut.print(i)
printHtmlPart(18)
invokeTag('message','g',59,['code':("education.educationDegree.label"),'default':("Education Degree")],-1)
printHtmlPart(19)
invokeTag('textField','g',63,['name':("educations[${i}].educationDegree"),'maxlength':("50"),'value':(education?.educationDegree),'class':("form-control")],-1)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('message','g',68,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',69,['bean':(customerInstance),'field':("educations[${i}].educationDegree")],3)
printHtmlPart(24)
})
invokeTag('hasErrors','g',72,['bean':(customerInstance),'field':("educations[${i}].educationDegree")],2)
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'educations['+i+'].yearStart', 'has-error'))
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(27)
invokeTag('message','g',78,['code':("education.yearStart.label"),'default':("Year Start")],-1)
printHtmlPart(9)
invokeTag('textField','g',82,['name':("educations[${i}].yearStart"),'maxlength':("4"),'value':(education?.yearStart),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',87,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',88,['bean':(customerInstance),'field':("educations[${i}].yearStart")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',91,['bean':(customerInstance),'field':("educations[${i}].yearStart")],1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: customerInstance, field: 'educations['+i+'].yearEnd', 'has-error'))
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(29)
invokeTag('message','g',98,['code':("education.yearStart.label"),'default':("Year End")],-1)
printHtmlPart(9)
invokeTag('textField','g',102,['name':("educations[${i}].yearEnd"),'maxlength':("4"),'value':(education?.yearEnd),'class':("form-control")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',107,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',108,['bean':(customerInstance),'field':("educations[${i}].yearEnd")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',111,['bean':(customerInstance),'field':("educations[${i}].yearEnd")],1)
printHtmlPart(30)
if(true && (canDelete!="false")) {
printHtmlPart(31)
}
printHtmlPart(32)
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
