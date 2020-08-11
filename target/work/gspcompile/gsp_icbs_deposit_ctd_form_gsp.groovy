import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_ctd_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/ctd/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['name':("id"),'value':(issueCTDInstance?.id)],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',10,['id':("deposit"),'name':("deposit.id"),'value':(issueCTDInstance?.deposit?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: issueCTDInstance, field: 'ctdNo', 'has-error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("issueCTD.ctdNo.label"),'default':("Ctd No")],-1)
printHtmlPart(5)
if(true && (!issueCTDInstance?.id)) {
printHtmlPart(6)
invokeTag('field','g',18,['name':("ctdNo"),'type':("number"),'value':(issueCTDInstance?.ctdNo),'required':(""),'class':("form-control")],-1)
printHtmlPart(7)
}
else {
printHtmlPart(6)
invokeTag('field','g',21,['disabled':("disabled"),'name':("ctdNo"),'type':("number"),'value':(issueCTDInstance?.ctd?.ctdNo),'required':(""),'class':("form-control")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',28,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',29,['bean':(issueCTDInstance),'field':("ctdNo")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',32,['bean':(issueCTDInstance),'field':("ctdNo")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: issueCTDInstance, field: 'remarks', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',38,['code':("issueCTD.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(15)
invokeTag('textArea','g',41,['name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(issueCTDInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',48,['bean':(issueCTDInstance),'field':("remarks")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',51,['bean':(issueCTDInstance),'field':("remarks")],1)
printHtmlPart(16)
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
