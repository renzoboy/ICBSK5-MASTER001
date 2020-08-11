import icbs.lov.LoanCollateralStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_status_editStatus_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/status/_editStatus.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (message)) {
printHtmlPart(1)
expressionOut.print(message)
printHtmlPart(2)
}
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('hasErrors','g',25,['bean':(collateralInstance)],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('hiddenField','g',27,['name':("id"),'id':("id"),'value':(collateralInstance?.id)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'status', 'has-error'))
printHtmlPart(7)
invokeTag('select','g',31,['id':("status"),'name':("status.id"),'from':(LoanCollateralStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(collateralInstance?.status?.id),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',37,['bean':(collateralInstance),'field':("status")],3)
printHtmlPart(12)
})
invokeTag('hasErrors','g',40,['bean':(collateralInstance),'field':("status")],2)
printHtmlPart(13)
})
invokeTag('form','g',43,['name':("update-status-form")],1)
printHtmlPart(14)
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
