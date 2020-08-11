import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_holdout_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/holdout/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: holdoutInstance, field: 'accountNo', 'has-error'))
printHtmlPart(1)
invokeTag('field','g',5,['class':("form-control"),'name':("accountNo"),'value':(holdoutInstance?.accountNo),'readonly':("true")],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',6,['id':("depositAccount"),'name':("depositAccount.id"),'value':(sweepAccount?.depositAccount?.id)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',12,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',13,['bean':(holdoutInstance),'field':("accountNo")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',16,['bean':(holdoutInstance),'field':("accountNo")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: holdoutInstance, field: 'holdoutDate', 'has-error'))
printHtmlPart(9)
invokeTag('customDatePicker','g',28,['name':("holdoutDate"),'precision':("day"),'class':("form-control"),'value':(holdoutInstance?.holdoutDate)],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',34,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',35,['bean':(holdoutInstance),'field':("holdoutDate")],2)
printHtmlPart(11)
})
invokeTag('hasErrors','g',38,['bean':(holdoutInstance),'field':("holdoutDate")],1)
printHtmlPart(12)
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
