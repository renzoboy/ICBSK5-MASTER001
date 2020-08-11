import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfacecreateAtmTerminal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/createAtmTerminal.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',16,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',17,['bean':(currencyInstance),'var':("error")],4)
printHtmlPart(15)
})
invokeTag('hasErrors','g',19,['bean':(atmTerminalInstance)],3)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('render','g',22,['template':("terminalform")],-1)
printHtmlPart(17)
})
invokeTag('form','g',24,['id':("create"),'url':([resource:atmTerminalInstance, action:'saveAtmTerminal'])],3)
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',26,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('submitButton','g',37,['id':("newAtmTerminal"),'name':("create"),'value':(message(code: 'default.button.create.label', default: 'Create')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to continue create ATM Terminal?',
                            function(){
                                checkIfAllowed('ADM00102', 'form#create', 'Create New ATM Termninal', null); 
                            },
                            function(){
                                return;
                            }); 
                    """)],-1)
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',38,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',38,['action':("atmTerminalView")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',40,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',41,[:],1)
printHtmlPart(22)
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
