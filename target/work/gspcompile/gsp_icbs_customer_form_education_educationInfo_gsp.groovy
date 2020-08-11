import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_education_educationInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/education/_educationInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
loop:{
int i = 0
for( education in (customerInstance.educations) ) {
printHtmlPart(2)
if(true && (education?.type?.id ==1&&(education.status?.id==2||!education?.id))) {
printHtmlPart(3)
invokeTag('render','g',13,['template':("form/education/onetomany/education"),'model':(['education':education,'i':i,'choice':'0'])],-1)
printHtmlPart(2)
}
printHtmlPart(4)
i++
}
}
printHtmlPart(5)
loop:{
int i = 0
for( education in (customerInstance.educations) ) {
printHtmlPart(2)
if(true && (education?.type?.id ==2&&(education.status?.id==2||!education?.id))) {
printHtmlPart(3)
invokeTag('render','g',24,['template':("form/education/onetomany/education"),'model':(['education':education,'i':i,'choice':'1'])],-1)
printHtmlPart(2)
}
printHtmlPart(4)
i++
}
}
printHtmlPart(6)
loop:{
int i = 0
for( education in (customerInstance.educations) ) {
printHtmlPart(2)
if(true && (education?.type?.id ==3&&(education.status?.id==2||!education?.id))) {
printHtmlPart(3)
invokeTag('render','g',35,['template':("form/education/onetomany/education"),'model':(['education':education,'i':i,'choice':'2'])],-1)
printHtmlPart(2)
}
printHtmlPart(4)
i++
}
}
printHtmlPart(7)
loop:{
int i = 0
for( education in (customerInstance.educations) ) {
printHtmlPart(2)
if(true && (education?.type?.id ==4&&(education.status?.id==2||!education?.id))) {
printHtmlPart(3)
invokeTag('render','g',47,['template':("form/education/onetomany/education"),'model':(['education':education,'i':i,'choice':'3'])],-1)
printHtmlPart(2)
}
printHtmlPart(4)
i++
}
}
printHtmlPart(8)
loop:{
int i = 0
for( education in (customerInstance.educations) ) {
printHtmlPart(2)
if(true && (education?.type?.id ==5&&(education.status?.id==2||!education?.id))) {
printHtmlPart(3)
invokeTag('render','g',58,['template':("form/education/onetomany/education"),'model':(['education':education,'i':i,'choice':'4'])],-1)
printHtmlPart(2)
}
printHtmlPart(4)
i++
}
}
printHtmlPart(9)
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
