import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaeditCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/editCollateral.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',11,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
createTagBody(4, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',20,['error':("${error.field} - ${error}")],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',21,['bean':(ropaInstance),'var':("error")],4)
printHtmlPart(17)
})
invokeTag('hasErrors','g',23,['bean':(ropaInstance)],3)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('render','g',27,['template':("collateralInformation/editForm")],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',28,['name':("collateralId"),'id':("collateralId"),'value':(params?.id)],-1)
printHtmlPart(21)
})
invokeTag('form','g',30,['id':("updateCollateral"),'url':([controller:'ropa', action:'updateCollateral']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',34,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('submitButton','g',45,['id':("updateCollateral"),'name':("update"),'value':(message(code: 'default.button.update.label', default: 'Update')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue create ROPA?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#updateCollateral', 'Create New ROPA', null); 
                                },
                                function(){
                                    return;
                            }); 
                """)],-1)
printHtmlPart(24)
createTagBody(3, {->
invokeTag('message','g',46,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',46,['action':("index")],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',48,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(26)
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
