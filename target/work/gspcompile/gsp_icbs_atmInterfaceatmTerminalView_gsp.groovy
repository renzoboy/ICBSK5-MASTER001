import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_atmInterfaceatmTerminalView_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atmInterface/atmTerminalView.gsp" }
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
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('sortableColumn','g',20,['property':("terminalCode"),'title':(message(code: 'branch.code.label', default: 'Code')),'defaultOrder':("asc")],-1)
printHtmlPart(9)
invokeTag('sortableColumn','g',21,['property':("branch"),'title':(message(code: 'branch.code.label', default: 'Branch')),'defaultOrder':("asc")],-1)
printHtmlPart(10)
loop:{
int i = 0
for( atmTerminalInstance in (atmTerminal) ) {
printHtmlPart(11)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(12)
expressionOut.print(fieldValue(bean: atmTerminalInstance, field: "terminalCode"))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: atmTerminalInstance, field: "branch.name"))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: atmTerminalInstance, field: "remarks"))
printHtmlPart(13)
expressionOut.print(fieldValue(bean: atmTerminalInstance, field: "terminalStatus.description"))
printHtmlPart(14)
if(true && (atmTerminalInstance.terminalStatus.id == 2)) {
printHtmlPart(15)
createClosureForHtmlPart(16, 5)
invokeTag('link','g',36,['class':("btn btn-secondary"),'action':("editTerminal"),'id':(atmTerminalInstance.id)],5)
printHtmlPart(15)
createClosureForHtmlPart(17, 5)
invokeTag('link','g',37,['class':("btn btn-secondary"),'action':("deleteTerminal"),'id':(atmTerminalInstance.id)],5)
printHtmlPart(18)
}
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
})
invokeTag('captureContent','sitemesh',46,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
invokeTag('message','g',50,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',50,['class':("create"),'action':("create")],3)
printHtmlPart(22)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',52,['action':("viewAtmInterface")],3)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',53,['action':("createAtmTerminal")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',55,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(27)
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
