import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_signatory_signatoryGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/signatory/_signatoryGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (depositInstance?.ownershipType?.id==1||!depositInstance?.ownershipType)) {
printHtmlPart(2)
}
printHtmlPart(3)
expressionOut.print(depositInstance?.id)
printHtmlPart(4)
loop:{
int i = 0
for( signatory in (depositInstance?.signatories) ) {
printHtmlPart(5)
if(true && (signatory?.status?.id!=3)) {
printHtmlPart(6)
invokeTag('render','g',22,['template':("form/signatory/onetomany/signatory"),'model':([signatory:signatory,i:i])],-1)
printHtmlPart(5)
}
printHtmlPart(7)
i++
}
}
printHtmlPart(8)
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
