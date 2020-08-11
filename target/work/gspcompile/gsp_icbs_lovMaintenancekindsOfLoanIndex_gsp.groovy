import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_lovMaintenancekindsOfLoanIndex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lovMaintenance/kindsOfLoanIndex.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':("CustomerKindOfLoan")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/lovMaintenance'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(1)
if(true && (flash.success)) {
printHtmlPart(7)
expressionOut.print(flash.success)
printHtmlPart(8)
}
printHtmlPart(9)
loop:{
int i = 0
for( loanKindOfLoanInstance in (loanKindOfLoanInstanceList) ) {
printHtmlPart(10)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(11)
expressionOut.print(loanKindOfLoanInstance.code)
printHtmlPart(12)
expressionOut.print(loanKindOfLoanInstance.description)
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',38,['class':("btn btn-secondary"),'action':("kindsOfLoanInstanceEdit"),'id':(loanKindOfLoanInstance.id)],4)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',39,['class':("btn btn-secondary"),'action':("kindsOfLoanInstanceDelete"),'id':(loanKindOfLoanInstance.id),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'formnovalidate':(""),'onclick':("return confirm('${message(code: 'default.button.update.confirm.message', default: 'Are you sure you want to delete this kind of loan?')}');")],4)
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
})
invokeTag('captureContent','sitemesh',45,['tag':("main-content")],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',48,['action':("kindsOfLoanInstanceCreate")],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',49,['action':("index")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',51,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',52,[:],1)
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
