import icbs.admin.Holiday
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_holidayshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/holiday/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'holiday.label', default: 'Holiday'))],-1)
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
expressionOut.print(createLink(uri: '/holiday'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(holidayInstance?.code)
printHtmlPart(14)
invokeTag('formatDate','g',45,['format':("MM/dd/yyyy"),'date':(holidayInstance?.holidayDate)],-1)
printHtmlPart(15)
expressionOut.print(holidayInstance?.description)
printHtmlPart(16)
expressionOut.print(holidayInstance?.type)
printHtmlPart(17)
expressionOut.print(holidayInstance?.institutionWideHoliday)
printHtmlPart(18)
expressionOut.print(holidayInstance?.configItemStatus?.description)
printHtmlPart(19)
for( branch in (holidayInstance.branches) ) {
printHtmlPart(20)
expressionOut.print(branch.name)
printHtmlPart(21)
}
printHtmlPart(22)
createClosureForHtmlPart(2, 3)
invokeTag('form','g',81,['name':("remove"),'id':("remove"),'url':([resource:holidayInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',83,['tag':("main-content")],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',87,['class':("create"),'action':("index")],3)
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',88,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',88,['class':("create"),'action':("create")],3)
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',89,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',89,['action':("edit"),'resource':(holidayInstance)],3)
printHtmlPart(28)
invokeTag('actionSubmit','g',91,['id':("deleteHoliday"),'form':("show"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete'))],-1)
printHtmlPart(29)
invokeTag('actionSubmit','g',101,['id':("deleteHoliday"),'resource':(holidayInstance),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00304', 'form#remove', 'Remove holiday.', null);
                                },
                                function(){
                                    return;
                                });                      
                """)],-1)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',113,['tag':("main-actions")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',114,[:],1)
printHtmlPart(31)
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
