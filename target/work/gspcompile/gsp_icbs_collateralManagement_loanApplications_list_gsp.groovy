import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagement_loanApplications_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/loanApplications/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (collateralInstance?.loanApplications)) {
printHtmlPart(1)
for( loanApplication in (collateralInstance?.loanApplications.sort{it.id}) ) {
printHtmlPart(2)
expressionOut.print(loanApplication?.id)
printHtmlPart(3)
expressionOut.print(loanApplication?.customer?.displayName)
printHtmlPart(3)
expressionOut.print(loanApplication?.product?.name)
printHtmlPart(3)
expressionOut.print(loanApplication?.amount)
printHtmlPart(3)
invokeTag('formatDate','g',28,['format':("MM/dd/yyyy"),'date':(loanApplication?.applicationDate)],-1)
printHtmlPart(3)
createClosureForHtmlPart(4, 3)
invokeTag('link','g',29,['class':("btn btn-secondary"),'controller':("loanApplication"),'action':("show"),'id':(loanApplication?.id)],3)
printHtmlPart(5)
expressionOut.print(loanApplication?.id)
printHtmlPart(6)
}
printHtmlPart(7)
}
else if(true && (session["loanApplications"])) {
printHtmlPart(1)
invokeTag('set','g',35,['var':("i"),'value':(0)],-1)
printHtmlPart(1)
for( loanApplication in (session["loanApplications"]) ) {
printHtmlPart(8)

if (!loanApplication.isAttached())
						loanApplication.attach()

printHtmlPart(2)
expressionOut.print(loanApplication?.id)
printHtmlPart(3)
expressionOut.print(loanApplication?.customer?.displayName)
printHtmlPart(3)
expressionOut.print(loanApplication?.product?.name)
printHtmlPart(3)
expressionOut.print(loanApplication?.amount)
printHtmlPart(3)
invokeTag('formatDate','g',46,['format':("MM/dd/yyyy"),'date':(loanApplication?.applicationDate)],-1)
printHtmlPart(3)
createClosureForHtmlPart(4, 3)
invokeTag('link','g',47,['class':("btn btn-secondary"),'controller':("loanApplication"),'action':("show"),'id':(loanApplication?.id)],3)
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(9)
invokeTag('set','g',50,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(1)
}
printHtmlPart(10)
}
printHtmlPart(11)
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
