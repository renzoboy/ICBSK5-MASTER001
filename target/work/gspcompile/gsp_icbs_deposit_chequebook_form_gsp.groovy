import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_chequebook_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/chequebook/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("id"),'value':(chequebookInstance?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['name':("deposit"),'id':("deposit.id"),'value':(chequebookInstance?.deposit?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: chequebookInstance, field: 'seriesStart', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',12,['code':("chequebook.seriesStart.label"),'default':("Series Start")],-1)
printHtmlPart(4)
if(true && (!chequebookInstance?.id)) {
printHtmlPart(5)
invokeTag('field','g',17,['name':("seriesStart"),'type':("number"),'value':(chequebookInstance.seriesStart),'required':(""),'class':("form-control")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('field','g',20,['name':("seriesStart"),'type':("number"),'value':(chequebookInstance.seriesStart),'required':(""),'readonly':("readonly"),'class':("form-control")],-1)
printHtmlPart(6)
}
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(it)
printHtmlPart(11)
})
invokeTag('eachError','g',36,['bean':(chequebookInstance),'field':("seriesStart")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',39,['bean':(chequebookInstance),'field':("seriesStart")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: chequebookInstance, field: 'seriesEnd', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',46,['code':("chequebook.seriesEnd.label"),'default':("Series End")],-1)
printHtmlPart(4)
if(true && (!chequebookInstance?.id)) {
printHtmlPart(5)
invokeTag('field','g',51,['name':("seriesEnd"),'type':("number"),'value':(chequebookInstance.seriesEnd),'required':(""),'class':("form-control")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(5)
invokeTag('field','g',54,['name':("seriesEnd"),'type':("number"),'value':(chequebookInstance.seriesEnd),'required':(""),'readonly':("readonly"),'class':("form-control")],-1)
printHtmlPart(6)
}
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(it)
printHtmlPart(17)
})
invokeTag('eachError','g',70,['bean':(chequebookInstance),'field':("seriesEnd")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',72,['bean':(chequebookInstance),'field':("seriesEnd")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: chequebookInstance, field: 'remarks', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',80,['code':("chequebook.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(20)
invokeTag('textField','g',84,['name':("remarks"),'required':("true"),'value':(chequebookInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(21, 2)
invokeTag('eachError','g',92,['bean':(chequebookInstance),'field':("remarks")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',93,['bean':(chequebookInstance),'field':("remarks")],1)
printHtmlPart(22)
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
