import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(ropaInstanceList)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
invokeTag('select','g',22,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm pull-left"),'onchange':("this.form.submit()")],-1)
printHtmlPart(11)
invokeTag('textField','g',26,['type':("text"),'name':("query"),'class':("form-control input-sm pull-right"),'style':("width: 250px;"),'placeholder':("Search Description or Location")],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('submitButton','g',28,['name':("Search"),'class':("btn btn-sm btn-default")],4)
printHtmlPart(14)
})
invokeTag('form','g',30,['class':("form-inline")],3)
printHtmlPart(15)
loop:{
int i = 0
for( RopaInstance in (RopaInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(RopaInstance.id)
printHtmlPart(18)
invokeTag('hiddenField','g',49,['id':("reymartID"),'name':("reymartID"),'value':(RopaInstance?.collateral.id)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',52,['format':("MM/dd/yyyy"),'date':(RopaInstance?.refDate)],-1)
printHtmlPart(20)
expressionOut.print(RopaInstance?.kindOfLand)
printHtmlPart(21)
expressionOut.print(RopaInstance?.location)
printHtmlPart(21)
expressionOut.print(RopaInstance?.status?.description)
printHtmlPart(21)
createClosureForHtmlPart(22, 4)
invokeTag('link','g',56,['class':("btn btn-secondary"),'action':("collateralShow"),'id':(RopaInstance?.id)],4)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',65,['total':(BranchInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',68,['tag':("main-content")],2)
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',72,['controller':("home"),'action':("landing")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',73,['action':("create")],3)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',75,['action':("ropaForTransfer")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',76,['action':("ropaForTransfer")],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',77,['action':("printRopaSchedule")],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',79,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(38)
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
