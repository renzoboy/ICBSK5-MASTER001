import icbs.loans.GroupRecord
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_groupedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/group/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'group.label', default: 'Group'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller:'group', action:'getGroupInfoAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'group', action:'search'))
printHtmlPart(5)
expressionOut.print(groupInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'group', action:'showMembersAjax2'))
printHtmlPart(7)
expressionOut.print(groupInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller:'group', action:'addMemberAjax2'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(10)
expressionOut.print(groupInstance?.id)
printHtmlPart(11)
expressionOut.print(createLink(controller:'group', action:'deleteMemberAjax2'))
printHtmlPart(12)
expressionOut.print(groupInstance?.parent?.id)
printHtmlPart(13)
})
invokeTag('javascript','g',85,[:],2)
printHtmlPart(14)
})
invokeTag('captureHead','sitemesh',86,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('captureContent','sitemesh',90,['tag':("breadcrumbs")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(17)
if(true && (flash.message)) {
printHtmlPart(18)
expressionOut.print(flash.message)
printHtmlPart(19)
}
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('hasErrors','g',113,['bean':(groupInstance)],3)
printHtmlPart(20)
createTagBody(3, {->
printHtmlPart(22)
invokeTag('hiddenField','g',115,['name':("version"),'value':(groupInstance?.version)],-1)
printHtmlPart(23)
invokeTag('render','g',124,['template':("details/form")],-1)
printHtmlPart(24)
invokeTag('render','g',127,['template':("members/list")],-1)
printHtmlPart(25)
})
invokeTag('form','g',130,['id':("group-form"),'url':([controller:group, action:'update', id:groupInstance?.id]),'method':("PUT")],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',132,['tag':("main-content")],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(27)
invokeTag('submitButton','g',135,['name':("save"),'value':("Save"),'onclick':("jQuery('#group-form').submit()")],-1)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',136,['action':("show"),'id':(groupInstance?.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',138,['tag':("main-actions")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',139,[:],1)
printHtmlPart(32)
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
