import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_pdc_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/pdc/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (collateralInstance?.pdcs)) {
printHtmlPart(1)
for( pdc in (collateralInstance?.pdcs.sort{it.accountNo}) ) {
printHtmlPart(2)
expressionOut.print(pdc?.accountNo)
printHtmlPart(3)
expressionOut.print(pdc?.checkNo)
printHtmlPart(3)
invokeTag('formatNumber','g',26,['format':("###,###,##0.00"),'number':(pdc?.amount)],-1)
printHtmlPart(3)
expressionOut.print(pdc?.bank)
printHtmlPart(3)
invokeTag('formatBoolean','g',28,['boolean':(pdc?.onUs)],-1)
printHtmlPart(3)
invokeTag('formatDate','g',29,['format':("MM/dd/yyyy"),'date':(pdc?.pdcDate)],-1)
printHtmlPart(4)
expressionOut.print(pdc?.id)
printHtmlPart(5)
expressionOut.print(pdc?.id)
printHtmlPart(6)
}
printHtmlPart(1)
for( tot in (collateralInstance?.pdcs.sort{it.accountNo}.sum{it.amount}) ) {
printHtmlPart(7)
invokeTag('formatNumber','g',41,['format':("###,##0.00"),'number':(tot)],-1)
printHtmlPart(8)
}
printHtmlPart(9)
}
else if(true && (session["pdcs"])) {
printHtmlPart(10)
invokeTag('set','g',50,['var':("i"),'value':(0)],-1)
printHtmlPart(10)
for( pdc in (session["pdcs"]) ) {
printHtmlPart(11)
expressionOut.print(pdc?.accountNo)
printHtmlPart(12)
expressionOut.print(pdc?.checkNo)
printHtmlPart(12)
expressionOut.print(pdc?.amount)
printHtmlPart(13)
expressionOut.print(pdc?.bank)
printHtmlPart(13)
invokeTag('formatBoolean','g',58,['boolean':(pdc?.onUs)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',59,['format':("MM/dd/yyyy"),'date':(pdc?.pdcDate)],-1)
printHtmlPart(14)
expressionOut.print(i)
printHtmlPart(15)
expressionOut.print(i)
printHtmlPart(16)
invokeTag('set','g',66,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(17)
}
printHtmlPart(18)
for( total in (session["pdcs"].sum{it.amount}) ) {
printHtmlPart(19)
invokeTag('formatNumber','g',72,['format':("###,##0.00"),'number':(total)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('hiddenField','g',112,['name':("pdcId"),'value':("")],-1)
printHtmlPart(23)
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
