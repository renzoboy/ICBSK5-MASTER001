import icbs.gl.GlContigentAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glContAcctcreatecontigent_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glContAcct/createcontigent.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
invokeTag('set','g',17,['var':("entityName"),'value':(message(code: 'ContigentAccount.label', default: 'Contigent Account'))],-1)
printHtmlPart(5)
createTagBody(2, {->
createClosureForHtmlPart(6, 3)
invokeTag('captureTitle','sitemesh',18,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',18,[:],2)
printHtmlPart(7)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',132,[:],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('captureContent','sitemesh',137,['tag':("breadcrumbs")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',146,['code':("loanLedger.loan.label"),'default':("Loan Account")],-1)
printHtmlPart(17)
invokeTag('field','g',149,['name':("accountNo"),'id':("accountNo"),'value':(""),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',157,['id':("loan"),'name':("loan.id"),'value':("")],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(20)
expressionOut.print(hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',201,['code':("customer.customerCode1.label"),'default':("Contigent Type")],-1)
printHtmlPart(22)
invokeTag('select','g',205,['id':("contigent"),'name':("contigent"),'from':(icbs.lov.ContigentAccount.findAllByStatus(true)),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("form-control"),'onchange':("validateContigent(this.value);")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',217,['code':("reference.label"),'default':("Title No")],-1)
printHtmlPart(25)
invokeTag('textField','g',221,['name':("titleNo"),'id':("titleNo"),'value':(""),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',231,['code':("reference.label"),'default':("Nominal Value")],-1)
printHtmlPart(25)
invokeTag('field','g',235,['type':("number"),'name':("nominalValue"),'id':("nominalValue"),'value':(""),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',245,['code':("reference.label"),'default':("Current Custodian")],-1)
printHtmlPart(25)
invokeTag('textField','g',249,['name':("currentCustodian"),'id':("currentCustodian"),'value':(""),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',259,['code':("reference.label"),'default':("Registered Mortgage(Amount)")],-1)
printHtmlPart(27)
invokeTag('textField','g',264,['name':("registeredMortgage"),'id':("registeredMortgage"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',274,['code':("reference.label"),'default':("Remarks")],-1)
printHtmlPart(25)
invokeTag('textField','g',278,['name':("remarks"),'id':("remarks"),'value':(""),'class':("form-control")],-1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',289,['code':("reference.label"),'default':("Reference")],-1)
printHtmlPart(29)
invokeTag('textField','g',294,['name':("reference"),'id':("reference"),'maxlength':("50"),'value':(customerInstance?.sssNo),'class':("form-control")],-1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: customerInstance, field: 'sssNo', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',304,['code':("particulars.label"),'default':("Particulars")],-1)
printHtmlPart(25)
invokeTag('textArea','g',308,['name':("particulars"),'id':("particulars"),'value':(customerInstance),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(31)
})
invokeTag('form','g',313,['name':("myFormcontigent"),'id':("myFormcontigent"),'url':([action:'savecontigent',controller:'GlContAcct']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(32)
})
invokeTag('captureContent','sitemesh',314,['tag':("main-content")],2)
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(34)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',324,['action':("index")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',325,['tag':("main-actions")],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',326,[:],1)
printHtmlPart(37)
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
