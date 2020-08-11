import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_branchshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/branch/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'branch.label', default: 'Branch'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/branch'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(fieldValue(bean: branchInstance, field: "code").padLeft(3, '0'))
printHtmlPart(13)
expressionOut.print(branchInstance.name)
printHtmlPart(14)
expressionOut.print(branchInstance.swiftCode)
printHtmlPart(15)
expressionOut.print(branchInstance?.address)
printHtmlPart(16)
expressionOut.print(branchInstance?.region?.itemValue)
printHtmlPart(17)
expressionOut.print(branchInstance?.contactNumber)
printHtmlPart(18)
if(true && (branchInstance?.managerId)) {
printHtmlPart(19)
expressionOut.print(branchInstance?.managerId?.name1)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('formatDate','g',65,['format':("MM/dd/yyyy"),'date':(branchInstance?.openDate)],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',69,['boolean':(branchInstance?.dataCenter),'true':("Yes"),'false':("No")],-1)
printHtmlPart(22)
expressionOut.print(branchInstance?.taxNo)
printHtmlPart(23)
if(true && (branchInstance?.openOnMon == true)) {
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (branchInstance?.openOnTue == true)) {
printHtmlPart(26)
}
printHtmlPart(25)
if(true && (branchInstance?.openOnWed == true)) {
printHtmlPart(27)
}
printHtmlPart(25)
if(true && (branchInstance?.openOnThu == true)) {
printHtmlPart(28)
}
printHtmlPart(25)
if(true && (branchInstance?.openOnFri == true)) {
printHtmlPart(29)
}
printHtmlPart(25)
if(true && (branchInstance?.openOnSat == true)) {
printHtmlPart(30)
}
printHtmlPart(25)
if(true && (branchInstance?.openOnSun == true)) {
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('formatDate','g',91,['format':("MM/dd/yyyy"),'date':(branchInstance?.runDate)],-1)
printHtmlPart(33)
expressionOut.print(branchInstance?.branchRunStatus?.description)
printHtmlPart(34)
expressionOut.print(branchInstance?.status?.description)
printHtmlPart(35)
expressionOut.print(branchInstance?.dueFromGl?.code)
printHtmlPart(36)
expressionOut.print(branchInstance?.dueFromGl.name)
printHtmlPart(37)
expressionOut.print(branchInstance?.dueToGl?.code)
printHtmlPart(36)
expressionOut.print(branchInstance?.dueToGl.name)
printHtmlPart(38)
expressionOut.print(branchInstance?.iccContra?.code)
printHtmlPart(36)
expressionOut.print(branchInstance?.iccContra.name)
printHtmlPart(39)
expressionOut.print(branchInstance?.yearEndClosingGl?.code)
printHtmlPart(36)
expressionOut.print(branchInstance?.yearEndClosingGl.name)
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('form','g',133,['name':("remove"),'id':("remove"),'url':([resource:branchInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(42)
createClosureForHtmlPart(41, 3)
invokeTag('form','g',135,['name':("closed"),'id':("closed"),'url':([resource:branchInstance, action:'close']),'method':("DELETE")],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',137,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(44)
if(true && (isPending && isAllowed)) {
printHtmlPart(45)
createClosureForHtmlPart(46, 4)
invokeTag('link','g',141,['action':("takeAction"),'params':([isApproved:true]),'resource':(branchInstance)],4)
printHtmlPart(47)
createClosureForHtmlPart(48, 4)
invokeTag('link','g',142,['action':("takeAction"),'params':([isApproved:false]),'resource':(branchInstance)],4)
printHtmlPart(49)
}
printHtmlPart(42)
if(true && (!isPending)) {
printHtmlPart(50)
createTagBody(4, {->
invokeTag('message','g',145,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',145,['class':("create"),'action':("create")],4)
printHtmlPart(51)
createTagBody(4, {->
invokeTag('message','g',146,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',146,['action':("edit"),'resource':(branchInstance)],4)
printHtmlPart(51)
invokeTag('actionSubmit','g',147,['id':("deleteBranch"),'resource':(branchInstance),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'branch.button.close.confirm.message', default: 'Are you sure you want this branch to be deleted?')}');")],-1)
printHtmlPart(47)
invokeTag('actionSubmit','g',148,['id':("closeBranch"),'resource':(branchInstance),'action':("close"),'value':(message(code: 'default.button.close.label', default: 'Close')),'onclick':("return confirm('${message(code: 'branch.button.close.confirm.message', default: 'Are you sure you want to close this branch?')}');")],-1)
printHtmlPart(52)
invokeTag('actionSubmit','g',150,['form':("show"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(53)
invokeTag('actionSubmit','g',151,['form':("show"),'action':("close"),'value':(message(code: 'branch.button.close.label', default: 'Close')),'onclick':("return confirm('${message(code: 'branch.button.close.confirm.message', default: 'Are you sure you want to close this branch?')}');")],-1)
printHtmlPart(54)
}
printHtmlPart(55)
})
invokeTag('captureContent','sitemesh',168,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',169,[:],1)
printHtmlPart(56)
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
