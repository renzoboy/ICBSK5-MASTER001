import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuaranteeloanGuaranteeDetail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/loanGuaranteeDetail.gsp" }
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
if(true && (loanGuaranteeInstance)) {
printHtmlPart(13)
expressionOut.print(loanGuaranteeInstance.id)
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
})
invokeTag('captureContent','sitemesh',60,['tag':("main-content")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',63,['class':("list"),'action':("agfpInformation"),'id':(loanInstance.id)],3)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',64,['class':("list"),'action':("sbgfcInformation"),'id':(loanInstance.id)],3)
printHtmlPart(19)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',65,['class':("list"),'action':("hgcInformation"),'id':(loanInstance.id)],3)
printHtmlPart(19)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',66,['class':("list"),'action':("loanRediscountingGsp"),'id':(loanInstance.id)],3)
printHtmlPart(19)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',67,['class':("list"),'action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',69,['tag':("main-actions")],2)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(25)
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
