import icbs.gl.GlLink
import icbs.loans.LoanBranchTransfer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_branch_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/branch/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(2)
expressionOut.print(message)
printHtmlPart(3)
}
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('hasErrors','g',25,['bean':(loanInstance)],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('hiddenField','g',27,['name':("id"),'id':("id"),'value':(loanInstance?.id)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: loanInstance, field: 'branch', 'has-error'))
printHtmlPart(8)
invokeTag('select','g',31,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(loanInstance?.branch?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',37,['bean':(loanInstance),'field':("branch")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',40,['bean':(loanInstance),'field':("branch")],2)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanBranchTransfer, field: 'particulars', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',45,['code':("loanBranchTransfer.particulars.label"),'default':("Particulars")],-1)
printHtmlPart(16)
invokeTag('textField','g',48,['name':("particulars"),'maxlength':("100"),'required':(""),'value':(loanBranchTransferInstance?.particulars),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',53,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',54,['bean':(loanBranchTransferInstance),'field':("particulars")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',57,['bean':(loanBranchTransferInstance),'field':("particulars")],2)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanBranchTransfer, field: 'reference', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',62,['code':("loanBranchTransfer.particulars.label"),'default':("Reference")],-1)
printHtmlPart(16)
invokeTag('textField','g',65,['name':("reference"),'maxlength':("50"),'required':(""),'value':(loanBranchTransferInstance?.reference),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',70,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',71,['bean':(loanBranchTransferInstance),'field':("reference")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',74,['bean':(loanBranchTransferInstance),'field':("reference")],2)
printHtmlPart(19)
})
invokeTag('form','g',77,['name':("update-branch-form")],1)
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
