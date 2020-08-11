import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_contact_contactInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/contact/_contactInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('render','g',11,['template':("form/contact/onetomany/contact"),'model':(['contact':customerInstance?.contacts[0],'i':0,'choice':'0',canDelete:'false'])],-1)
printHtmlPart(2)
loop:{
int i = 0
for( contact in (customerInstance.contacts) ) {
printHtmlPart(3)
if(true && (i>1 &&(contact?.type?.itemCode=="001" || contact?.type?.itemCode=="002")&&(contact?.status?.id==2||!contact?.id))) {
printHtmlPart(4)
invokeTag('render','g',15,['template':("form/contact/onetomany/contact"),'model':(['contact':contact,'i':i,'choice':'0'])],-1)
printHtmlPart(3)
}
printHtmlPart(5)
i++
}
}
printHtmlPart(6)
invokeTag('render','g',23,['template':("form/contact/onetomany/contact"),'model':(['contact':customerInstance?.contacts[1],'i':1,'choice':'1',canDelete:'false'])],-1)
printHtmlPart(7)
loop:{
int i = 0
for( contact in (customerInstance.contacts) ) {
printHtmlPart(3)
if(true && (i>1 && contact?.type?.itemCode=="003" && (contact?.status?.id==2||!contact?.id))) {
printHtmlPart(4)
invokeTag('render','g',27,['template':("form/contact/onetomany/contact"),'model':(['contact':contact,'i':i,'choice':'1'])],-1)
printHtmlPart(3)
}
printHtmlPart(5)
i++
}
}
printHtmlPart(8)
loop:{
int i = 0
for( contact in (customerInstance.contacts) ) {
printHtmlPart(3)
if(true && (i>1 && (contact?.type?.itemCode=="004" ||contact?.type?.itemCode=="005" ||contact?.type?.itemCode=="006")&& (contact?.status?.id==2 ||!contact?.id))) {
printHtmlPart(4)
invokeTag('render','g',38,['template':("form/contact/onetomany/contact"),'model':(['contact':contact,'i':i,'choice':'2'])],-1)
printHtmlPart(3)
}
printHtmlPart(5)
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
