import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loaneditSpecial_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/editSpecial.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
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
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('hasErrors','g',36,['bean':(loanInstance?.special)],3)
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('hiddenField','g',40,['name':("version"),'value':(loanInstance?.special?.version)],-1)
printHtmlPart(12)
invokeTag('select','g',44,['id':("type"),'name':("type.id"),'from':(icbs.lov.LoanSpecialType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.special?.type?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
createTagBody(5, {->
printHtmlPart(15)
invokeTag('message','g',50,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',51,['bean':(loanInstance?.special),'field':("type")],5)
printHtmlPart(17)
})
invokeTag('hasErrors','g',54,['bean':(loanInstance?.special),'field':("type")],4)
printHtmlPart(18)
invokeTag('textField','g',60,['name':("specialAction"),'value':(loanInstance?.special?.action),'class':("form-control")],-1)
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
createTagBody(5, {->
printHtmlPart(15)
invokeTag('message','g',66,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',67,['bean':(loanInstance?.special),'field':("action")],5)
printHtmlPart(17)
})
invokeTag('hasErrors','g',70,['bean':(loanInstance?.special),'field':("action")],4)
printHtmlPart(19)
invokeTag('customDatePicker','g',77,['name':("transferDate"),'precision':("day"),'class':("form-control"),'value':(loanInstance?.special?.transferDate),'type':("text"),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(20)
createTagBody(4, {->
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(22)
invokeTag('message','g',83,['error':(it)],-1)
printHtmlPart(23)
})
invokeTag('eachError','g',84,['bean':(loanInstance?.special),'field':("transferDate")],5)
printHtmlPart(24)
})
invokeTag('hasErrors','g',87,['bean':(loanInstance?.special),'field':("transferDate")],4)
printHtmlPart(25)
invokeTag('submitButton','g',93,['class':("btn btn-primary"),'name':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(26)
})
invokeTag('form','g',93,['url':([controller:loan, id:"${loanInstance?.id}", action:'updateSpecial']),'method':("POST")],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',93,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',99,['controller':("loanInquiry"),'action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',100,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',100,[:],1)
printHtmlPart(31)
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
