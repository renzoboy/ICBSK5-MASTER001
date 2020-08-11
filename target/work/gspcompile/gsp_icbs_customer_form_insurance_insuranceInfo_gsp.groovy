import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_insurance_insuranceInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/insurance/_insuranceInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('render','g',9,['template':("form/insurance/onetomany/insurance"),'model':(['insurance':customerInstance?.insurances[0],'i':0])],-1)
printHtmlPart(2)
loop:{
int i = 0
for( insurance in (customerInstance.insurances) ) {
printHtmlPart(3)
if(true && (i>0&&(insurance?.status?.id==2||!insurance?.id))) {
printHtmlPart(4)
invokeTag('render','g',14,['template':("form/insurance/onetomany/insurance"),'model':(['insurance':insurance,'i':i])],-1)
printHtmlPart(3)
}
printHtmlPart(5)
i++
}
}
printHtmlPart(6)
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
