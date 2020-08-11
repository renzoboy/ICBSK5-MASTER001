import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_ropaTransfer_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaTransfer/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(txnFileInstance.id)
printHtmlPart(1)
invokeTag('formatDate','g',13,['format':("MM/dd/yyyy"),'date':(txnFileInstance?.txnDate)],-1)
printHtmlPart(2)
invokeTag('fieldValue','g',17,['bean':(txnFileInstance),'field':("txnType.description")],-1)
printHtmlPart(3)
invokeTag('fieldValue','g',21,['bean':(txnFileInstance),'field':("acctNo")],-1)
printHtmlPart(4)
if(true && (txnFileInstance.depAcct)) {
printHtmlPart(5)
expressionOut.print(txnFileInstance.depAcct.customer.displayName)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (txnFileInstance.loanAcct)) {
printHtmlPart(8)
expressionOut.print(txnFileInstance.loanAcct.customer.displayName)
printHtmlPart(6)
}
printHtmlPart(9)
invokeTag('fieldValue','g',37,['bean':(txnFileInstance),'field':("branch.name")],-1)
printHtmlPart(10)
invokeTag('formatNumber','g',41,['format':("###,###,##0.00"),'number':(txnFileInstance?.txnAmt)],-1)
printHtmlPart(11)
invokeTag('fieldValue','g',46,['bean':(txnFileInstance),'field':("txnCode")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',50,['bean':(txnFileInstance),'field':("txnTemplate.description")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',54,['bean':(txnFileInstance),'field':("txnDescription")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',58,['bean':(txnFileInstance),'field':("txnRef")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',62,['bean':(txnFileInstance),'field':("txnParticulars")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',66,['bean':(txnFileInstance),'field':("status.description")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',70,['bean':(txnFileInstance),'field':("user.username")],-1)
printHtmlPart(18)
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
