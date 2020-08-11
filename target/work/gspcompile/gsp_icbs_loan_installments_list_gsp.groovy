import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_installments_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/installments/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (onoffplugvalue == 'import')) {
printHtmlPart(1)
}
else {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (session["installments"])) {
printHtmlPart(4)
invokeTag('set','g',36,['var':("i"),'value':(0)],-1)
printHtmlPart(5)
invokeTag('set','g',36,['var':("x"),'value':(0)],-1)
printHtmlPart(5)
invokeTag('set','g',38,['var':("y"),'value':(0)],-1)
printHtmlPart(5)
invokeTag('set','g',39,['var':("z"),'value':(0)],-1)
printHtmlPart(4)
for( installment in (session["installments"]) ) {
printHtmlPart(6)
if(true && (installment?.principalInstallmentAmount <0 || installment?.interestInstallmentAmount < 0 || installment?.serviceChargeInstallmentAmount < 0)) {
printHtmlPart(7)
expressionOut.print(i + 1)
printHtmlPart(8)
invokeTag('formatDate','g',54,['format':("MM/dd/yyyy"),'date':(installment?.installmentDate)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',56,['format':("###,##0.00"),'number':(installment?.principalInstallmentAmount)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',57,['format':("###,##0.00"),'number':(installment?.interestInstallmentAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',59,['format':("###,##0.00"),'number':(installment?.serviceChargeInstallmentAmount)],-1)
printHtmlPart(12)
expressionOut.print(i)
printHtmlPart(13)
expressionOut.print(i)
printHtmlPart(14)
}
else {
printHtmlPart(15)
expressionOut.print(i + 1)
printHtmlPart(8)
invokeTag('formatDate','g',63,['format':("MM/dd/yyyy"),'date':(installment?.installmentDate)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',64,['format':("###,##0.00"),'number':(installment?.principalInstallmentAmount)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',66,['format':("###,##0.00"),'number':(installment?.interestInstallmentAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',70,['format':("###,##0.00"),'number':(installment?.serviceChargeInstallmentAmount)],-1)
printHtmlPart(12)
expressionOut.print(i)
printHtmlPart(13)
expressionOut.print(i)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('set','g',75,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(19)
invokeTag('set','g',75,['var':("x"),'value':(x + installment?.principalInstallmentAmount)],-1)
printHtmlPart(20)
invokeTag('set','g',76,['var':("y"),'value':(y + installment?.interestInstallmentAmount)],-1)
printHtmlPart(20)
invokeTag('set','g',77,['var':("z"),'value':(z + installment?.serviceChargeInstallmentAmount)],-1)
printHtmlPart(4)
}
printHtmlPart(21)
invokeTag('formatNumber','g',80,['format':("###,##0.00"),'number':(x)],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',82,['format':("###,##0.00"),'number':(y)],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',83,['format':("###,##0.00"),'number':(z)],-1)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('hiddenField','g',127,['name':("installmentId"),'value':("")],-1)
printHtmlPart(26)
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
