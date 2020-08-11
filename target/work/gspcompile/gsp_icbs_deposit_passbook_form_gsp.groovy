import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_passbook_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/passbook/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['name':("id"),'value':(issuePassbookInstance?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',9,['id':("deposit"),'name':("deposit.id"),'value':(issuePassbookInstance?.deposit?.id)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',10,['id':("UserID"),'name':("UserID"),'value':(issuePassbookInstance?.issuedBy?.id)],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: issuePassbookInstance, field: 'passbookNo', 'has-error'))
printHtmlPart(3)
invokeTag('message','g',16,['code':("issuePassbook.passbookNo.label"),'default':("Passbook No")],-1)
printHtmlPart(4)
invokeTag('textField','g',23,['name':("passbookNo"),'required':(""),'value':(issuePassbookInstance?.passbook?.passbookNo),'class':("form-control passbookNo")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',29,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',30,['bean':(issuePassbookInstance),'field':("passbookNo")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',33,['bean':(issuePassbookInstance),'field':("passbookNo")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: issuePassbookInstance, field: 'remarks', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',38,['code':("issuePassbook.remarks.label"),'default':("Remarks")],-1)
printHtmlPart(12)
invokeTag('textArea','g',41,['id':("remarks"),'name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(issuePassbookInstance?.remarks),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',47,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',48,['bean':(issuePassbookInstance),'field':("remarks")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',51,['bean':(issuePassbookInstance),'field':("remarks")],1)
printHtmlPart(13)
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
