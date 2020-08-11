import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_group_details_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/details/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: groupInstance, field: 'name', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("group.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("name"),'required':(""),'value':(groupInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(groupInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(groupInstance),'field':("name")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: groupInstance, field: 'description', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("group.description.label"),'default':("Description")],-1)
printHtmlPart(10)
invokeTag('textArea','g',30,['name':("description"),'value':(groupInstance?.description),'rows':("3"),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',37,['bean':(groupInstance),'field':("description")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',40,['bean':(groupInstance),'field':("description")],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: groupInstance, field: 'type', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',46,['code':("group.type.label"),'default':("Type")],-1)
printHtmlPart(13)
invokeTag('select','g',49,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.GroupType.list()),'optionKey':("id"),'optionValue':("description"),'value':(groupInstance?.type?.id)],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',55,['bean':(groupInstance),'field':("type")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',58,['bean':(groupInstance),'field':("installmetypentType")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: groupInstance, field: 'parent', 'has-error'))
printHtmlPart(20)
invokeTag('field','g',66,['name':("parent-name"),'value':(groupInstance?.parent?.name),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',67,['id':("parent"),'name':("parent.id"),'value':(groupInstance?.parent?.id)],-1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('message','g',73,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',74,['bean':(groupInstance),'field':("parent")],2)
printHtmlPart(25)
})
invokeTag('hasErrors','g',77,['bean':(groupInstance),'field':("parent")],1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: groupInstance, field: 'meetingDate', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',85,['code':("group.meetingDate.label"),'default':("Meeting Date")],-1)
printHtmlPart(10)
invokeTag('customDatePicker','g',87,['name':("meetingDate"),'precision':("day"),'class':("form-control"),'value':(groupInstance?.meetingDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',93,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',94,['bean':(groupInstance),'field':("meetingDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',97,['bean':(groupInstance),'field':("meetingDate")],1)
printHtmlPart(28)
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
