import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_reliefshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/relief/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(7)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(8)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(9)
invokeTag('formatDate','g',31,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',35,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(11)
invokeTag('formatNumber','g',39,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(12)
if(true && (reliefInstance)) {
printHtmlPart(13)
invokeTag('formatBoolean','g',47,['boolean':(reliefInstance?.loanReliefStatus),'true':("Applied"),'false':("Not Applied")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',51,['format':("MM/dd/yyyy"),'date':(reliefInstance?.reliefDate)],-1)
printHtmlPart(15)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(reliefInstance?.loanAmount)],-1)
printHtmlPart(16)
invokeTag('formatDate','g',59,['format':("MM/dd/yyyy"),'date':(reliefInstance?.reliefRemovalDate)],-1)
printHtmlPart(17)
expressionOut.print(reliefInstance?.particulars)
printHtmlPart(18)
expressionOut.print(reliefInstance?.updatedBy?.username)
printHtmlPart(19)
expressionOut.print(reliefInstance?.removedBy?.username)
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureContent','sitemesh',84,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
if(true && (reliefInstance)) {
printHtmlPart(24)
if(true && (reliefInstance?.loanReliefStatus == true)) {
printHtmlPart(25)
createClosureForHtmlPart(26, 5)
invokeTag('link','g',89,['class':("list"),'action':("removeRelief"),'id':(loanInstance.id)],5)
printHtmlPart(27)
}
else {
printHtmlPart(25)
createClosureForHtmlPart(28, 5)
invokeTag('link','g',92,['class':("list"),'action':("applyRelief"),'id':(loanInstance.id)],5)
printHtmlPart(27)
}
printHtmlPart(29)
}
else {
printHtmlPart(30)
createClosureForHtmlPart(28, 4)
invokeTag('link','g',96,['class':("list"),'action':("applyRelief"),'id':(loanInstance.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
createClosureForHtmlPart(33, 3)
invokeTag('link','g',98,['class':("list"),'action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',100,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',101,[:],1)
printHtmlPart(35)
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
