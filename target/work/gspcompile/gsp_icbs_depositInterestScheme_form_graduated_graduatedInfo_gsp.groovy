import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestScheme_form_graduated_graduatedInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/form/graduated/_graduatedInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
loop:{
int i = 0
for( graduated in (depositInterestSchemeInstance.graduateds) ) {
printHtmlPart(2)
if(true && (graduated?.status?.id!=3)) {
printHtmlPart(3)
invokeTag('render','g',13,['template':("form/graduated/onetomany/graduated"),'model':(['graduated':graduated,'i':i])],-1)
printHtmlPart(2)
}
printHtmlPart(4)
i++
}
}
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(depositInterestSchemeInstance?.graduateds?.size())
printHtmlPart(7)
})
invokeTag('javascript','g',1,[:],1)
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
