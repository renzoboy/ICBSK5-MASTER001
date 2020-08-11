import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_xform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_xform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('render','g',27,['template':("viewMoreInfoTemplates/otherInformation")],-1)
printHtmlPart(4)
invokeTag('render','g',31,['template':("viewMoreInfoTemplates/contactInformation")],-1)
printHtmlPart(5)
invokeTag('render','g',35,['template':("viewMoreInfoTemplates/addressInformation")],-1)
printHtmlPart(6)
invokeTag('render','g',39,['template':("viewMoreInfoTemplates/relationsInformation")],-1)
printHtmlPart(7)
invokeTag('render','g',43,['template':("viewMoreInfoTemplates/beneficiaryInformation")],-1)
printHtmlPart(8)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(9)
invokeTag('render','g',48,['template':("viewMoreInfoTemplates/educationalInformation")],-1)
printHtmlPart(8)
}
printHtmlPart(10)
invokeTag('render','g',53,['template':("viewMoreInfoTemplates/otherAccounts")],-1)
printHtmlPart(11)
invokeTag('render','g',57,['template':("viewMoreInfoTemplates/attachments")],-1)
printHtmlPart(12)
invokeTag('render','g',61,['template':("viewMoreInfoTemplates/recordTagging")],-1)
printHtmlPart(13)
invokeTag('render','g',65,['template':("viewMoreInfoTemplates/recordStatHistInformation")],-1)
printHtmlPart(14)
invokeTag('render','g',69,['template':("viewMoreInfoTemplates/businessInformation")],-1)
printHtmlPart(15)
invokeTag('render','g',73,['template':("viewMoreInfoTemplates/employmentInfo")],-1)
printHtmlPart(16)
invokeTag('render','g',77,['template':("viewMoreInfoTemplates/insuranceInformation")],-1)
printHtmlPart(17)
invokeTag('render','g',81,['template':("viewMoreInfoTemplates/membershipInformation")],-1)
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
