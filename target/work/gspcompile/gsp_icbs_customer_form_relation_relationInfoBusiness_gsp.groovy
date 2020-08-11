import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_relation_relationInfoBusiness_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/relation/_relationInfoBusiness.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',10,['id':("customerRelationshipType"),'name':("customerRelationshipType"),'value':(customerRelationshipType)],-1)
printHtmlPart(2)
loop:{
int i = 0
for( relation in (customerInstance?.relations) ) {
printHtmlPart(3)
if(true && ((relation?.status?.id==2||!relation?.id))) {
printHtmlPart(4)
invokeTag('render','g',14,['template':("form/relation/onetomany/relation"),'model':(['relation':relation,'i':i,'choice':'4'])],-1)
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
