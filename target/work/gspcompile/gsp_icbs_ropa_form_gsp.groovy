import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("loanID"),'name':("loanID"),'value':(ropaInstance?.loan)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("loanLedger.loan.label"),'default':("Account No.")],-1)
printHtmlPart(3)
invokeTag('field','g',8,['name':("accountNo"),'value':(ropaInstance?.loan),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(it)
printHtmlPart(6)
})
invokeTag('hasErrors','g',19,['bean':(loanLedgerInstance),'field':("loan")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'loan', 'has-error'))
printHtmlPart(8)
invokeTag('textField','g',26,['name':("loanAccountName"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.loan?.customer?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',32,['bean':(ropaInstance),'field':("loan")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',35,['bean':(ropaInstance),'field':("loan")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ropaDate', 'has-error'))
printHtmlPart(15)
invokeTag('textField','g',43,['value':(icbs.admin.Branch.get(1).runDate.format('YYYY/MM/dd')),'id':("valueDate"),'name':("newValueDate"),'precision':("day"),'class':("form-control"),'default':("none"),'noSelection':(['': '']),'disabled':("disabled")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',49,['bean':(ropaInstance),'field':("ropaDate")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',52,['bean':(ropaInstance),'field':("ropaDate")],1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'reference', 'has-error'))
printHtmlPart(17)
invokeTag('textField','g',58,['id':("reference"),'name':("reference"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',63,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',63,['bean':(ropaInstance),'field':("reference")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',65,['bean':(ropaInstance),'field':("reference")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'particulars', 'has-error'))
printHtmlPart(19)
invokeTag('textArea','g',73,['name':("particulars"),'id':("particulars"),'value':(""),'class':("form-control"),'rows':("5"),'cols':("40")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',78,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',78,['bean':(ropaInstance),'field':("particulars")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',80,['bean':(ropaInstance),'field':("particulars")],1)
printHtmlPart(20)
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
