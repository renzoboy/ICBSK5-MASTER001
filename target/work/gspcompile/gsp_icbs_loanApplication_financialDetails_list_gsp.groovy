import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_financialDetails_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/financialDetails/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',18,['var':("x"),'value':(0)],-1)
printHtmlPart(1)
invokeTag('set','g',19,['var':("y"),'value':(0)],-1)
printHtmlPart(1)
invokeTag('set','g',20,['var':("z"),'value':(0)],-1)
printHtmlPart(2)
if(true && (loanApplicationInstance?.financialDetails)) {
printHtmlPart(3)
for( financialDetail in (loanApplicationInstance?.financialDetails.sort{it.description}) ) {
printHtmlPart(4)
expressionOut.print(financialDetail?.description)
printHtmlPart(5)
invokeTag('formatNumber','g',25,['number':(financialDetail?.value),'format':("###,##0.00")],-1)
printHtmlPart(6)
expressionOut.print(financialDetail?.type?.description)
printHtmlPart(7)
expressionOut.print(financialDetail?.id)
printHtmlPart(8)
expressionOut.print(financialDetail?.id)
printHtmlPart(9)
if(true && (financialDetail?.type?.description=='Expense')) {
printHtmlPart(10)
invokeTag('set','g',32,['var':("x"),'value':(x + financialDetail?.value)],-1)
printHtmlPart(11)
}
else if(true && (financialDetail?.type?.description=='Income')) {
printHtmlPart(10)
invokeTag('set','g',35,['var':("y"),'value':(y + financialDetail?.value)],-1)
printHtmlPart(11)
}
else if(true && (financialDetail?.type?.description=='Others')) {
printHtmlPart(10)
invokeTag('set','g',38,['var':("z"),'value':(z + financialDetail?.value)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
}
printHtmlPart(13)
}
else if(true && (session["financialDetails"])) {
printHtmlPart(3)
invokeTag('set','g',43,['var':("i"),'value':(0)],-1)
printHtmlPart(3)
for( financialDetail in (session["financialDetails"]) ) {
printHtmlPart(4)
expressionOut.print(financialDetail?.description)
printHtmlPart(5)
invokeTag('formatNumber','g',47,['number':(financialDetail?.value),'format':("###,##0.00")],-1)
printHtmlPart(6)
expressionOut.print(financialDetail?.type?.description)
printHtmlPart(7)
expressionOut.print(i)
printHtmlPart(8)
expressionOut.print(i)
printHtmlPart(14)
invokeTag('set','g',53,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(15)
if(true && (financialDetail?.type?.description=='Expense')) {
printHtmlPart(10)
invokeTag('set','g',55,['var':("x"),'value':(x + financialDetail?.value)],-1)
printHtmlPart(10)
}
else if(true && (financialDetail?.type?.description=='Income')) {
printHtmlPart(15)
invokeTag('set','g',58,['var':("y"),'value':(y + financialDetail?.value)],-1)
printHtmlPart(10)
}
else if(true && (financialDetail?.type?.description=='Others')) {
printHtmlPart(15)
invokeTag('set','g',61,['var':("z"),'value':(z + financialDetail?.value)],-1)
printHtmlPart(10)
}
printHtmlPart(16)
}
printHtmlPart(2)
}
printHtmlPart(17)
invokeTag('formatNumber','g',70,['format':("###,##0.00"),'number':(y)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',74,['format':("###,##0.00"),'number':(x)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',78,['format':("###,##0.00"),'number':(z)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',82,['format':("###,##0.00"),'number':(y-x)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',111,['name':("financialDetailId"),'value':("")],-1)
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
