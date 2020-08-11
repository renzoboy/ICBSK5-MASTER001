import icbs.loans.LoanReClassHist
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanReclass_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanReclass/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('sortableColumn','g',12,['property':("reclassDate"),'title':(message(code: 'LoanReClassHist.reclassDate.label', default: 'Action Date'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',13,['property':("oldClass"),'title':(message(code: 'LoanReClassHist.oldClass.date', default: 'From (Old Classification)'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',14,['property':("newClass"),'title':(message(code: 'LoanReClassHist.newClass.label', default: 'To (New Classification)'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',15,['property':("txnFile"),'title':(message(code: 'LoanReClassHist.txnFile.label', default: 'Txn Id'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',16,['property':("reclassDesc"),'title':(message(code: 'LoanReClassHist.reclassDesc.label', default: 'Re Class Desc'))],-1)
printHtmlPart(2)
loop:{
int i = 0
for( LoanReClassHistInstance in (LoanReClassHist.findAllByLoanAcct(loanInstance,[sort: "id", order: "asc"])) ) {
printHtmlPart(3)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(4)
invokeTag('formatDate','g',22,['format':("MM/dd/yyyy"),'date':(LoanReClassHistInstance?.reclassDate)],-1)
printHtmlPart(5)
expressionOut.print(LoanReClassHistInstance?.oldClass)
printHtmlPart(5)
expressionOut.print(LoanReClassHistInstance?.newClass)
printHtmlPart(5)
expressionOut.print(LoanReClassHistInstance?.txnFile?.id)
printHtmlPart(5)
expressionOut.print(LoanReClassHistInstance?.reclassDesc)
printHtmlPart(6)
i++
}
}
printHtmlPart(7)
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
