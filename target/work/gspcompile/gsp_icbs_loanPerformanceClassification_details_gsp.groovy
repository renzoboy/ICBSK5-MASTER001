import icbs.lov.LoanPerformanceClassification
import icbs.lov.LoanFreq
import icbs.lov.ConfigItemStatus
import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanPerformanceClassification_details_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanPerformanceClassification/_details.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'code', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',10,['code':("loanPerformanceClassification.code.label"),'default':("Code")],-1)
printHtmlPart(3)
invokeTag('textField','g',14,['class':("form-control"),'name':("code"),'maxlength':("10"),'value':(loanPerformanceClassificationInstance?.code)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',19,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',20,['bean':(loanPerformanceClassificationInstance),'field':("code")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',23,['bean':(loanPerformanceClassificationInstance),'field':("code")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'name', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',29,['code':("loanPerformanceClassification.name.label"),'default':("Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',33,['class':("form-control"),'name':("name"),'maxlength':("75"),'value':(loanPerformanceClassificationInstance?.name)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',39,['bean':(loanPerformanceClassificationInstance),'field':("name")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',42,['bean':(loanPerformanceClassificationInstance),'field':("name")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'prevClassification', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',48,['code':("loanPerformanceClassification.prevClassification.label"),'default':("Previous Classification")],-1)
printHtmlPart(12)
invokeTag('select','g',51,['class':("form-control"),'id':("prevClassification"),'name':("prevClassification.id"),'from':(LoanPerformanceClassification.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanPerformanceClassificationInstance?.prevClassification?.id)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',56,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',57,['bean':(loanPerformanceClassificationInstance),'field':("prevClassification")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',60,['bean':(loanPerformanceClassificationInstance),'field':("prevClassification")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'newClassification', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',66,['code':("loanPerformanceClassification.newClassification.label"),'default':("New Classification")],-1)
printHtmlPart(12)
invokeTag('select','g',69,['class':("form-control"),'id':("newClassification"),'name':("newClassification.id"),'from':(LoanPerformanceClassification.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanPerformanceClassificationInstance?.newClassification?.id)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',74,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',75,['bean':(loanPerformanceClassificationInstance),'field':("newClassification")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',78,['bean':(loanPerformanceClassificationInstance),'field':("newClassification")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'type', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',84,['code':("loanPerformanceClassification.type.label"),'default':("Type")],-1)
printHtmlPart(12)
invokeTag('select','g',87,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.LoanPerformanceClassificationType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanPerformanceClassificationInstance?.type?.id),'onchange':("updateForm()")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',92,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',93,['bean':(loanPerformanceClassificationInstance),'field':("type")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',96,['bean':(loanPerformanceClassificationInstance),'field':("type")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'thresholdAmount', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',103,['code':("loanPerformanceClassification.thresholdAmount.label"),'default':("Threshold Amount")],-1)
printHtmlPart(3)
invokeTag('field','g',107,['class':("form-control  truncated"),'name':("thresholdAmount"),'value':(fieldValue(bean: loanPerformanceClassificationInstance, field: 'thresholdAmount'))],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',112,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',113,['bean':(loanPerformanceClassificationInstance),'field':("thresholdAmount")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',116,['bean':(loanPerformanceClassificationInstance),'field':("thresholdAmount")],1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanPerformanceClassificationInstance, field: 'thresholdFreq', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',124,['code':("loanPerformanceClassification.thresholdFreq.label"),'default':("Threshold Frequency")],-1)
printHtmlPart(19)
invokeTag('field','g',128,['class':("form-control"),'name':("thresholdFreq"),'type':("number"),'value':(loanPerformanceClassificationInstance?.thresholdFreq)],-1)
printHtmlPart(20)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',133,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',134,['bean':(loanPerformanceClassificationInstance),'field':("thresholdFreq")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',137,['bean':(loanPerformanceClassificationInstance),'field':("thresholdFreq")],1)
printHtmlPart(21)
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
