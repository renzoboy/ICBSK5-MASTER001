import icbs.cif.Code
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_codeshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/code/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'code.label', default: 'Code'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
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
if(true && (codeInstance?.type)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("code.type.label"),'default':("Type Id")],-1)
printHtmlPart(10)
createTagBody(4, {->
expressionOut.print(codeInstance?.type?.itemValue)
})
invokeTag('link','g',22,['controller':("lov"),'action':("show"),'id':(codeInstance?.type?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (codeInstance?.value)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("code.value.label"),'default':("Value")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',31,['bean':(codeInstance),'field':("value")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (codeInstance?.hash)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("code.hash.label"),'default':("Hash")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(codeInstance),'field':("hash")],-1)
printHtmlPart(11)
}
printHtmlPart(17)
})
invokeTag('captureContent','sitemesh',47,['tag':("main-content")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',51,['class':("list"),'action':("index")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',52,['class':("create"),'action':("create")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',54,['action':("edit"),'id':(codeInstance.id)],3)
printHtmlPart(25)
})
invokeTag('captureContent','sitemesh',56,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',57,[:],1)
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
