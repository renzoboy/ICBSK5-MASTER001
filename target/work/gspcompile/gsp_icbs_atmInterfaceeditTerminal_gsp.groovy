import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceeditTerminal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/editTerminal.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(1)
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
invokeTag('hiddenField','g',15,['name':("version"),'value':(atmTerminalInstance?.version)],-1)
printHtmlPart(10)
invokeTag('render','g',17,['template':("terminalform")],-1)
printHtmlPart(11)
})
invokeTag('form','g',19,['id':("edit"),'controller':("ATMInterface"),'url':([resource:atmTerminalInstance, action:'updateTerminal']),'method':("PUT")],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',20,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('actionSubmit','g',31,['id':("editAtmTerminal"),'name':("edit"),'value':(message(code: 'default.button.create.label', default: 'Update')),'onclick':("""
                                alertify.confirm(AppTitle,'Are you sure you want to update ATM Terminal Information?',
                                function(){
                                    checkIfAllowed('ADM00103', 'form#edit', 'Edit Terminal.', null); // params: policyTemplate.code, form to be saved
                                },
                                function(){
                                    return;
                                }); 
                                """)],-1)
printHtmlPart(13)
createTagBody(3, {->
invokeTag('message','g',32,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',32,['action':("atmTerminalView")],3)
printHtmlPart(14)
})
invokeTag('captureContent','sitemesh',34,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',35,[:],1)
printHtmlPart(15)
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
