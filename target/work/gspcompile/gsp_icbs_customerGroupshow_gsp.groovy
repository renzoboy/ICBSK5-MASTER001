import icbs.admin.CustomerGroup
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customerGroupshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customerGroup/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customerGroup.label', default: 'CustomerGroup'))],-1)
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
expressionOut.print(createLink(uri: '/customerGroup'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (customerGroupInstance?.code)) {
printHtmlPart(12)
invokeTag('message','g',24,['code':("customerGroup.code.label"),'default':("Code")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',27,['bean':(customerGroupInstance),'field':("code")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (customerGroupInstance?.name)) {
printHtmlPart(12)
invokeTag('message','g',35,['code':("customerGroup.name.label"),'default':("Name")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',38,['bean':(customerGroupInstance),'field':("name")],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (customerGroupInstance?.configItemStatus)) {
printHtmlPart(12)
invokeTag('message','g',46,['code':("customerGroup.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(18)
expressionOut.print(customerGroupInstance?.configItemStatus?.description)
printHtmlPart(17)
}
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('form','g',56,['id':("delete"),'url':([resource:customerGroupInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(2)
})
invokeTag('captureContent','sitemesh',57,['tag':("main-content")],2)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',61,['code':("default.new.customerGroup"),'args':([entityName]),'default':("New Customer Group")],-1)
})
invokeTag('link','g',61,['class':("create"),'action':("create")],3)
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',62,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',62,['class':("btn btn-primary"),'action':("edit"),'resource':(customerGroupInstance)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',63,['id':("deleteCustomerGroup"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',72,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',73,[:],1)
printHtmlPart(25)
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
