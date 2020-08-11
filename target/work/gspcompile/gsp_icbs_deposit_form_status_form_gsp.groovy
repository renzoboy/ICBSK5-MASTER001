import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_status_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/status/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("origStatus"),'value':(depositInstance.status.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: depositInstance, field: 'status', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',11,['code':("deposit.status.label"),'default':("Status")],-1)
printHtmlPart(4)
invokeTag('select','g',15,['id':("status"),'name':("status.id"),'from':(icbs.lov.DepositStatus.findAllByStatusAndDescriptionNotEqual(true,'Closed')),'optionKey':("id"),'optionValue':("description"),'value':(depositInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',20,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',21,['bean':(depositInstance),'field':("status")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',24,['bean':(depositInstance),'field':("status")],1)
printHtmlPart(10)
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
